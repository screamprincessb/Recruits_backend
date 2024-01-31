/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.controller.internal.app;

import com.sense.backend.common.helper.HBHelper;
import com.sense.backend.hb.entity.auth.WorkExperienceEntity;
import com.sense.backend.hb.service.WorkExperienceService;
import com.sense.service.base.BaseRestController;
import com.sense.service.conts.ApiFilterConst;
import com.sense.service.custom.filter.ApiAttrBean;
import com.sense.service.rest.bean.internal.app.WorkExperienceReq;
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
@Tag(name = "Work Experience")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/rest/internal/app/Recruits_Work_Experience")
@RestController
public class WorkExperienceController extends BaseRestController {

    @PostConstruct
    public void init() {

    }

    @Operation(summary = "Work Experience")
    @RequestMapping(value = "findAll", method = RequestMethod.GET)

    public List<WorkExperienceEntity> findAll(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token) {

        WorkExperienceService workexperienceService = HBHelper.instance().service(WorkExperienceService.class);
        List<WorkExperienceEntity> result = workexperienceService.findAll();

        return result;
    }

    @Operation(summary = "Work Experience")
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public WorkExperienceEntity findById(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("workExperienceId") Integer workExperienceId) {

        WorkExperienceService service = HBHelper.instance().service(WorkExperienceService.class);
        WorkExperienceEntity en = service.findById(workExperienceId);
        return en;
    }

    @Operation(summary = "Work Experience")
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.PUT)

    public String saveOrUpdate(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestBody WorkExperienceReq req) {
        String status = "";

        try {
            WorkExperienceService service = HBHelper.instance().service(WorkExperienceService.class);
            WorkExperienceEntity val = new WorkExperienceEntity();
            val.setWorkExperienceId(req.getData().getWorkExperienceId());
            val.setWeStartDT(new Date());
            val.setWeEndDT(new Date());
            val.setWeBusinessType(req.getData().getWeBusinessType());
            val.setWeName(req.getData().getWeName());
            val.setWePosition(req.getData().getWePosition());
            val.setWeMajor(req.getData().getWeMajor());
            val.setWeSalary(req.getData().getWeSalary());
            val.setWeAddressPhone(req.getData().getWeAddressPhone());
            val.setWeDescription(req.getData().getWeDescription());
            val.setWeReasonLeaving(req.getData().getWeReasonLeaving());
            service.saveOrUpdate(val);

        } catch (Exception e) {
            status = e.getMessage();
        }
        return status;

    }

    @Operation(summary = "Work Experience")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public void delete(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            Integer id) {

        WorkExperienceService service = HBHelper.instance().service(WorkExperienceService.class);
        WorkExperienceEntity result = new WorkExperienceEntity();
        result.setWorkExperienceId(id);
        service.delete(result);

    }
}
