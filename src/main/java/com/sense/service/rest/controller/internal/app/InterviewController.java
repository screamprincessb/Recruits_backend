/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.controller.internal.app;

import com.sense.backend.common.helper.HBHelper;
import com.sense.backend.hb.entity.auth.InterviewEntity;
import com.sense.backend.hb.entity.auth.qInterviewAppointmentEntity;
import com.sense.backend.hb.service.InterviewService;
import com.sense.service.base.BaseRestController;
import com.sense.service.conts.ApiFilterConst;
import com.sense.service.custom.filter.ApiAttrBean;
import com.sense.service.rest.bean.internal.app.InterviewReq;
import com.sense.service.util.DateTimeUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.PostConstruct;
import java.util.Date;
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
@Tag(name = "Interview")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/rest/internal/app/Recruits_Interview")
@RestController
public class InterviewController extends BaseRestController {

    @PostConstruct
    public void init() {

    }

    @Operation(summary = "Interview")
    @RequestMapping(value = "findAll", method = RequestMethod.GET)

    public List<InterviewEntity> findAll(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token) {

        InterviewService interviewservice = HBHelper.instance().service(InterviewService.class);
        List<InterviewEntity> result = interviewservice.findAll();

        return result;
    }

    @Operation(summary = "Interview")
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public InterviewEntity findById(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("interviewId") String interviewId) {

        InterviewService service = HBHelper.instance().service(InterviewService.class);
        InterviewEntity en = service.findById(interviewId);
        return en;
    }

    @Operation(summary = "Interview")
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.PUT)

    public String saveOrUpdate(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestBody InterviewReq req) {
        String status = "";

        try {
            InterviewService service = HBHelper.instance().service(InterviewService.class);
            InterviewEntity val = new InterviewEntity();
            val.setInterviewId(req.getData().getInterviewId());
            val.setInterviewResult(req.getData().getInterviewResult());
            val.setInterviewNote(req.getData().getInterviewNote());
            val.setInterviewStatus(req.getData().getInterviewStatus());
            val.setInterviewDT(req.getData().getInterviewDT());
            val.setInterviewTime(req.getData().getInterviewTime());
            val.setInterviewLocation(req.getData().getInterviewLocation());
            val.setInterviewCreateDT(new Date());
            val.setInterviewCreateby(req.getData().getInterviewCreateby());
            val.setInterviewUpdateDT(new Date());
            val.setInterviewUpdateby(req.getData().getInterviewUpdateby());
            val.setInterviewDelete(req.getData().getInterviewDelete());
            val.setApplicationId(req.getData().getApplicationId());
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

        InterviewService service = HBHelper.instance().service(InterviewService.class);
        InterviewEntity result = new InterviewEntity();
        result.setInterviewId(id);
        service.delete(result);

    }

    @Operation(summary = "Interview")
    @RequestMapping(value = "findAllInterviewApp", method = RequestMethod.GET)

    public List<qInterviewAppointmentEntity> findAllInterviewApp(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token) {

        InterviewService interviewservice = HBHelper.instance().service(InterviewService.class);
        try {
            List<qInterviewAppointmentEntity> result = interviewservice.findAllInterApp();
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
    @Operation(summary = "Interview")
    @RequestMapping(value = "findInterAppByIdInterview", method = RequestMethod.GET)
    public List<qInterviewAppointmentEntity> findInterAppById(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("interviewId") String interviewId) {
        InterviewService service = HBHelper.instance().service(InterviewService.class);
        try {
            List<qInterviewAppointmentEntity> result = service.findInterAppById(interviewId);
            return result;
        } catch (Exception e) {
            System.out.print(e);
        }
        return null;
    }

}
