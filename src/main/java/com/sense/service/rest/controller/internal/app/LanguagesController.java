/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.controller.internal.app;

import com.sense.backend.common.helper.HBHelper;
import com.sense.backend.hb.entity.auth.LanguagesEntity;
import com.sense.backend.hb.service.LanguagesService;
import com.sense.service.base.BaseRestController;
import com.sense.service.conts.ApiFilterConst;
import com.sense.service.custom.filter.ApiAttrBean;
import com.sense.service.rest.bean.internal.app.LanguagesReq;
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
@Tag(name = "Languages")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/rest/internal/app/Recruits_Languages")
@RestController
public class LanguagesController extends BaseRestController {

    @PostConstruct
    public void init() {

    }

    @Operation(summary = "Languages")
    @RequestMapping(value = "findAll", method = RequestMethod.GET)

    public List<LanguagesEntity> findAll(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token) {

        LanguagesService languagesservice = HBHelper.instance().service(LanguagesService.class);
        List<LanguagesEntity> result = languagesservice.findAll();

        return result;
    }

    @Operation(summary = "Languages")
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public LanguagesEntity findById(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("languagesId") String languagesId) {

        LanguagesService service = HBHelper.instance().service(LanguagesService.class);
        LanguagesEntity en = service.findById(languagesId);
        return en;
    }

    @Operation(summary = "Languages")
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.PUT)

    public String saveOrUpdate(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestBody LanguagesReq req) {
        String status = "";

        try {
            LanguagesService service = HBHelper.instance().service(LanguagesService.class);
            LanguagesEntity val = new LanguagesEntity();
            val.setLanguagesId(req.getData().getLanguagesId());
            val.setLanguagesName(req.getData().getLanguagesName());
            val.setLanguagesSpeaking(req.getData().getLanguagesSpeaking());
            val.setLanguagesReading(req.getData().getLanguagesReading());
            val.setLanguagesWriting(req.getData().getLanguagesWriting());
            val.setLanguagesTypewriter(req.getData().getLanguagesTypewriter());
            service.saveOrUpdate(val);

        } catch (Exception e) {
            status = e.getMessage();
        }
        return status;

    }

    @Operation(summary = "Languages")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public void delete(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            String id) {

        LanguagesService service = HBHelper.instance().service(LanguagesService.class);
        LanguagesEntity result = new LanguagesEntity();
        result.setLanguagesId(id);
        service.delete(result);

    }
}
