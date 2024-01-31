/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.controller.internal.app;

import com.sense.backend.common.helper.HBHelper;
import com.sense.backend.hb.entity.auth.EducationEntity;
import com.sense.backend.hb.service.EducationService;
import com.sense.service.base.BaseRestController;
import com.sense.service.conts.ApiFilterConst;
import com.sense.service.custom.filter.ApiAttrBean;
import com.sense.service.rest.bean.internal.app.DataOtherReq;
import com.sense.service.rest.bean.internal.app.EducationReq;
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
@Tag(name = "Education")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/rest/internal/app/Recruits_Education")
@RestController
public class EducationController extends BaseRestController {

    @PostConstruct
    public void init() {

    }

    @Operation(summary = "Education")
    @RequestMapping(value = "findAll", method = RequestMethod.GET)

    public List<EducationEntity> findAll(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token) {

        EducationService educationservice = HBHelper.instance().service(EducationService.class);
        List<EducationEntity> result = educationservice.findAll();

        return result;
    }

    @Operation(summary = "Education")
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public EducationEntity findById(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("educationId") Integer educationId) {

        EducationService service = HBHelper.instance().service(EducationService.class);
        EducationEntity en = service.findById(educationId);
        return en;
    }

    @Operation(summary = "Education")
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.PUT)

    public String saveOrUpdate(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestBody EducationReq req) {
        String status = "";

        try {
            EducationService service = HBHelper.instance().service(EducationService.class);
            EducationEntity val = new EducationEntity();
            val.setEducationId(req.getData().getEducationId());
            val.setEducationLevel(req.getData().getEducationLevel());
            val.setEducationName(req.getData().getEducationName());
            val.setEducationQualification(req.getData().getEducationQualification());
            val.setEducationMajor(req.getData().getEducationMajor());
            val.setEducationStartDT(new Date());
            val.setEducationEndDT(new Date());
            val.setEducationGPA(req.getData().getEducationGPA());
            service.saveOrUpdate(val);

        } catch (Exception e) {
            status = e.getMessage();
        }
        return status;

    }

    @Operation(summary = "Education")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public void delete(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            Integer id) {

        EducationService service = HBHelper.instance().service(EducationService.class);
        EducationEntity result = new EducationEntity();
        result.setEducationId(id);
        service.delete(result);

    }
}
