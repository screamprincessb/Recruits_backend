/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.controller.internal.app;

import com.sense.backend.common.helper.HBHelper;
import com.sense.backend.hb.entity.auth.InterviewAppointmentEntity;
import com.sense.backend.hb.entity.auth.InterviewEntity;
import com.sense.backend.hb.entity.auth.qInterviewAppointmentEntity;
import com.sense.backend.hb.service.InterviewAppointmentService;
import com.sense.backend.hb.service.InterviewService;
import com.sense.service.base.BaseRestController;
import com.sense.service.conts.ApiFilterConst;
import com.sense.service.custom.filter.ApiAttrBean;
import com.sense.service.rest.bean.internal.app.InterviewAppointmentReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@Tag(name = "Interview Appointment")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/rest/internal/app/Recruits_Interview_Appointment")
@RestController
public class InterviewAppointmentController extends BaseRestController {

    @PostConstruct
    public void init() {

    }

    @Operation(summary = "Interview Appointment")
    @RequestMapping(value = "findAll", method = RequestMethod.GET)

    public List<InterviewAppointmentEntity> findAll(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token) {

        InterviewAppointmentService interviewappointmentservice = HBHelper.instance().service(InterviewAppointmentService.class);
        List<InterviewAppointmentEntity> result = interviewappointmentservice.findAll();

        return result;
    }

    @Operation(summary = "Interview Appointment")
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public InterviewAppointmentEntity findById(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("interAppId") Integer interAppId) {

        InterviewAppointmentService service = HBHelper.instance().service(InterviewAppointmentService.class);
        InterviewAppointmentEntity en = service.findById(interAppId);
        return en;
    }

    @Operation(summary = "Interview Appointment")
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.PUT)

    public String saveOrUpdate(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestBody InterviewAppointmentReq req) {
        String status = "";

        try {
            InterviewAppointmentService service = HBHelper.instance().service(InterviewAppointmentService.class);
            InterviewAppointmentEntity val = new InterviewAppointmentEntity();
            val.setInterAppId(req.getData().getInterAppId());
            val.setInterAppLocation(req.getData().getInterAppLocation());
            val.setInterAppStatus(req.getData().getInterAppStatus());
            val.setInterAppCreateby(req.getData().getInterAppCreateby());
            val.setInterAppUpdateby(req.getData().getInterAppUpdateby());
            val.setInterAppDelete(req.getData().getInterAppDelete());
            service.saveOrUpdate(val);

        } catch (Exception e) {
            status = e.getMessage();
        }
        return status;

    }

    @Operation(summary = "Interview Appointment")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public void delete(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            Integer id) {

        InterviewAppointmentService service = HBHelper.instance().service(InterviewAppointmentService.class);
        InterviewAppointmentEntity result = new InterviewAppointmentEntity();
        result.setInterAppId(id);
        service.delete(result);

    }

    @Operation(summary = "Interview Appointment")
    @GetMapping("/allnames")
    //@RequestMapping(value = "findAllName", method = RequestMethod.GET)

    public List<qInterviewAppointmentEntity> findAllName(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token) {
        InterviewAppointmentService interviewappointmentservice = HBHelper.instance().service(InterviewAppointmentService.class);
        try{
            List<qInterviewAppointmentEntity> result = interviewappointmentservice.findAllName();
            return result;
        } catch (Exception e){
            System.out.println(e);
        }
        

        return null;
    }

}
