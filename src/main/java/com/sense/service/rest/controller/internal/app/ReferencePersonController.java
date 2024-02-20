/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.controller.internal.app;

import com.sense.backend.common.helper.HBHelper;
import com.sense.backend.hb.entity.auth.ReferencePersonEntity;
import com.sense.backend.hb.service.ReferencePersonService;
import com.sense.service.base.BaseRestController;
import com.sense.service.conts.ApiFilterConst;
import com.sense.service.custom.filter.ApiAttrBean;
import com.sense.service.rest.bean.internal.app.ReferencePersonReq;
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
@Tag(name = "Reference Person")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/rest/internal/app/Recruits_Reference_Person")
@RestController
public class ReferencePersonController extends BaseRestController {

    @PostConstruct
    public void init() {

    }

    @Operation(summary = "Reference Person")
    @RequestMapping(value = "findAll", method = RequestMethod.GET)

    public List<ReferencePersonEntity> findAll(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token) {

        ReferencePersonService referencepersonservice = HBHelper.instance().service(ReferencePersonService.class);
        List<ReferencePersonEntity> result = referencepersonservice.findAll();

        return result;
    }

    @Operation(summary = "Reference Person")
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public ReferencePersonEntity findById(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("refPersonId") String refPersonId) {

        ReferencePersonService service = HBHelper.instance().service(ReferencePersonService.class);
        ReferencePersonEntity en = service.findById(refPersonId);
        return en;
    }

    @Operation(summary = "Reference Person")
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.PUT)

    public String saveOrUpdate(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestBody ReferencePersonReq req) {
        String status = "";

        try {
            ReferencePersonService service = HBHelper.instance().service(ReferencePersonService.class);
            ReferencePersonEntity val = new ReferencePersonEntity();
            val.setRefPersonId(req.getData().getRefPersonId());
            val.setRefFirstName(req.getData().getRefFirstName());
            val.setRefLastName(req.getData().getRefLastName());
            val.setRefJobPosition(req.getData().getRefJobPosition());
            val.setRefWorkLocation(req.getData().getRefWorkLocation());
            val.setRefPhone(req.getData().getRefPhone());
            val.setWorkExperienceId(req.getData().getWorkExperienceId());
            service.saveOrUpdate(val);

        } catch (Exception e) {
            status = e.getMessage();
        }
        return status;

    }

    @Operation(summary = "Reference Person")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public void delete(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            String id) {

        ReferencePersonService service = HBHelper.instance().service(ReferencePersonService.class);
        ReferencePersonEntity result = new ReferencePersonEntity();
        result.setRefPersonId(id);
        service.delete(result);

    }
}
