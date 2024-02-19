/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.controller.internal.app;

import com.sense.backend.common.helper.HBHelper;
import com.sense.backend.hb.entity.auth.ChildEntity;
import com.sense.backend.hb.service.ChildService;
import com.sense.service.base.BaseRestController;
import com.sense.service.conts.ApiFilterConst;
import com.sense.service.custom.filter.ApiAttrBean;
import com.sense.service.rest.bean.internal.app.ChildReq;
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
@Tag(name = "Child")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/rest/internal/app/Recruits_Child")
@RestController
public class ChildController extends BaseRestController {

    @PostConstruct
    public void init() {

    }

    @Operation(summary = "Child")
    @RequestMapping(value = "findAll", method = RequestMethod.GET)

    public List<ChildEntity> findAll(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token) {

        ChildService childservice = HBHelper.instance().service(ChildService.class);
        List<ChildEntity> result = childservice.findAll();

        return result;
    }

    @Operation(summary = "Child")
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public ChildEntity findById(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("childId") String childId) {

        ChildService service = HBHelper.instance().service(ChildService.class);
        ChildEntity en = service.findById(childId);
        return en;
    }

    @Operation(summary = "Child")
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.PUT)

    public String saveOrUpdate(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestBody ChildReq req) {
        String status = "";

        try {
            ChildService service = HBHelper.instance().service(ChildService.class);
            ChildEntity val = new ChildEntity();
            val.setChildId(req.getData().getChildId());
            val.setChildNumber(req.getData().getChildNumber());
            val.setChildFirstName(req.getData().getChildFirstName());
            val.setChildLastName(req.getData().getChildLastName());
            val.setChildAge(req.getData().getChildAge());
            val.setChildGender(req.getData().getChildGender());
            val.setChildEducationLevel(req.getData().getChildEducationLevel());
            service.saveOrUpdate(val);

        } catch (Exception e) {
            status = e.getMessage();
        }
        return status;

    }

    @Operation(summary = "Child")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public void delete(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            String id) {

        ChildService service = HBHelper.instance().service(ChildService.class);
        ChildEntity result = new ChildEntity();
        result.setChildId(id);
        service.delete(result);

    }
}
