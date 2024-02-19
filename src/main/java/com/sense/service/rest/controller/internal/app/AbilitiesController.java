/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.controller.internal.app;

import com.sense.backend.common.helper.HBHelper;
import com.sense.backend.hb.entity.auth.AbillitiesEntity;
import com.sense.backend.hb.entity.auth.LanguagesEntity;
import com.sense.backend.hb.entity.auth.VehicleEntity;
import com.sense.backend.hb.service.AbilitiesService;
import com.sense.service.base.BaseRestController;
import com.sense.service.conts.ApiFilterConst;
import com.sense.service.custom.filter.ApiAttrBean;
import com.sense.service.rest.bean.internal.app.AbilitiesReq;
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
@Tag(name = "Abilities")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/rest/internal/app/Recruits_Abilities")
@RestController
public class AbilitiesController extends BaseRestController {

    @PostConstruct
    public void init() {

    }

    @Operation(summary = "Abilities")
    @RequestMapping(value = "findAll", method = RequestMethod.GET)

    public List<AbillitiesEntity> findAll(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token) {

        AbilitiesService abilitiesservice = HBHelper.instance().service(AbilitiesService.class);
        List<AbillitiesEntity> result = abilitiesservice.findAll();

        return result;
    }

    @Operation(summary = "Abilities")
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public AbillitiesEntity findById(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("abillitiesId") Integer abillitiesId) {

        AbilitiesService service = HBHelper.instance().service(AbilitiesService.class);
        AbillitiesEntity en = service.findById(abillitiesId);
        return en;
    }

    @Operation(summary = "Abilities")
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.PUT)

    public String saveOrUpdate(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestBody AbilitiesReq req) {
        String status = "";

        try {
            AbilitiesService service = HBHelper.instance().service(AbilitiesService.class);
            AbillitiesEntity val = new AbillitiesEntity();
            val.setAbillitiesId(req.getData().getAbillitiesId());
            val.setAbillitiesToeicScore(req.getData().getAbillitiesToeicScore());
            val.setAbillitiesTofelScore(req.getData().getAbillitiesTofelScore());
            val.setAbillitiesComputerSkill(req.getData().getAbillitiesComputerSkill());
            val.setAbillitiesOther(req.getData().getAbillitiesOther());
            val.setAbillitiesHobby(req.getData().getAbillitiesHobby());
            service.saveOrUpdate(val);

        } catch (Exception e) {
            status = e.getMessage();
        }
        return status;

    }

    @Operation(summary = "Abilities")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public void delete(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            Integer id) {

        AbilitiesService service = HBHelper.instance().service(AbilitiesService.class);
        AbillitiesEntity result = new AbillitiesEntity();
        result.setAbillitiesId(id);
        service.delete(result);

    }

    @Operation(summary = "Abillities")
    @RequestMapping(value = "findVehicleByIdToAbillities", method = RequestMethod.GET)
    public List<VehicleEntity> findVehicleById(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("applicationId") Integer applicationId) {
        AbilitiesService service = HBHelper.instance().service(AbilitiesService.class);
        try {
            List<VehicleEntity> result = service.findVehicleById(applicationId);
            return result;
        } catch (Exception e) {
            System.out.print(e);
        }
        return null;
    }

    @Operation(summary = "Abillities")
    @RequestMapping(value = "findLanguagesByIdToAbillities", method = RequestMethod.GET)
    public List<LanguagesEntity> findLanguagesById(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("applicationId") Integer applicationId) {
        AbilitiesService service = HBHelper.instance().service(AbilitiesService.class);
        try {
            List<LanguagesEntity> result = service.findLanguagesById(applicationId);
            return result;
        } catch (Exception e) {
            System.out.print(e);
        }
        return null;
    }
}
