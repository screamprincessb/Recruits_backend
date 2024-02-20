/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.controller.internal.app;

import com.sense.backend.common.helper.HBHelper;
import com.sense.backend.hb.entity.auth.InterviewerEntity;
import com.sense.backend.hb.service.InterviewerService;
import com.sense.service.base.BaseRestController;
import com.sense.service.conts.ApiFilterConst;
import com.sense.service.custom.filter.ApiAttrBean;
import com.sense.service.rest.bean.internal.app.InterviewerReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.PostConstruct;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author SenseInfoTech
 */
@Tag(name = "Interviewer")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/rest/internal/app/Recruits_Interviewer")
@RestController
public class InterviewerController extends BaseRestController {
        @PostConstruct
    public void init() {

    }
    
    
    @Operation(summary = "Interviewer")
    @RequestMapping(value = "findAll", method = RequestMethod.GET)

    public List<InterviewerEntity> findAll(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token) {

        InterviewerService interviewerservice = HBHelper.instance().service(InterviewerService.class);
        List<InterviewerEntity> result = interviewerservice.findAll();

        return result;
    }
        
    @Operation(summary = "Interview")
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public InterviewerEntity findById(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("interviewerId") String interviewerId) {

        InterviewerService service = HBHelper.instance().service(InterviewerService.class);
        InterviewerEntity en = service.findById(interviewerId);
        return en;
    }
    
    @Operation(summary = "Interview")
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.PUT)

    public String saveOrUpdate(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestBody InterviewerReq req) {
        String status = "";

        try {
            InterviewerService service = HBHelper.instance().service(InterviewerService.class);
            InterviewerEntity val = new InterviewerEntity();
            val.setInterviewerId(req.getData().getInterviewerId());
            val.setInterviewerStatus(req.getData().getInterviewerStatus());
            val.setHrId(req.getData().getHrId());
            service.saveOrUpdate(val);

        } catch (Exception e) {
            status = e.getMessage();
        }
        return status;

    }
    
    @Operation(summary = "Interview")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public void delete(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            String id) {

        InterviewerService service = HBHelper.instance().service(InterviewerService.class);
        InterviewerEntity result = new InterviewerEntity();
        result.setInterviewerId(id);
        service.delete(result);

    }
}
