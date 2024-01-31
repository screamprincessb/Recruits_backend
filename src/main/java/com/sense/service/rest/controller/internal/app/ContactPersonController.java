/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.controller.internal.app;

import com.sense.backend.common.helper.HBHelper;
import com.sense.backend.hb.entity.auth.ContactPersonEntity;
import com.sense.backend.hb.service.ContactPersonService;
import com.sense.service.base.BaseRestController;
import com.sense.service.conts.ApiFilterConst;
import com.sense.service.custom.filter.ApiAttrBean;
import com.sense.service.rest.bean.internal.app.ContactPersonReq;
import com.sense.service.rest.bean.internal.app.VehicleReq;
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
@Tag(name = "Contact Person")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/rest/internal/app/Recruits_Contact_Person")
@RestController
public class ContactPersonController extends BaseRestController {

    @PostConstruct
    public void init() {

    }

    @Operation(summary = "Contact Person")
    @RequestMapping(value = "findAll", method = RequestMethod.GET)

    public List<ContactPersonEntity> findAll(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token) {

        ContactPersonService contactpersonService = HBHelper.instance().service(ContactPersonService.class);
        List<ContactPersonEntity> result = contactpersonService.findAll();

        return result;
    }

    @Operation(summary = "Contact Person")
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public ContactPersonEntity findById(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("contactPersonId") Integer contactPersonId) {

        ContactPersonService service = HBHelper.instance().service(ContactPersonService.class);
        ContactPersonEntity en = service.findById(contactPersonId);
        return en;
    }

    @Operation(summary = "Contact Person")
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.PUT)

    public String saveOrUpdate(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestBody ContactPersonReq req) {
        String status = "";

        try {
            ContactPersonService service = HBHelper.instance().service(ContactPersonService.class);
            ContactPersonEntity val = new ContactPersonEntity();
            val.setContactPersonId(req.getData().getContactPersonId());
            val.setCpFirstName(req.getData().getCpFirstName());
            val.setCpLastName(req.getData().getCpLastName());
            val.setCpRelation(req.getData().getCpRelation());
            val.setCpPhone(req.getData().getCpPhone());
            val.setCpAddress(req.getData().getCpAddress());

            service.saveOrUpdate(val);

        } catch (Exception e) {
            status = e.getMessage();
        }
        return status;

    }

    @Operation(summary = "Contact Person")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public void delete(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            Integer id) {

        ContactPersonService service = HBHelper.instance().service(ContactPersonService.class);
        ContactPersonEntity result = new ContactPersonEntity();
        result.setContactPersonId(id);
        service.delete(result);

    }
}
