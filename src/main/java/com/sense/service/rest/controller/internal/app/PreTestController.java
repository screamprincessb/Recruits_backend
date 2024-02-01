/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.controller.internal.app;

import com.sense.backend.common.helper.HBHelper;
import com.sense.backend.hb.entity.auth.PreTestEntity;
import com.sense.backend.hb.service.PreTestService;
import com.sense.service.base.BaseRestController;
import com.sense.service.conts.ApiFilterConst;
import com.sense.service.custom.filter.ApiAttrBean;
import com.sense.service.rest.bean.internal.app.PreTestReq;
import com.sense.service.rest.bean.internal.app.VehicleReq;
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
@Tag(name = "Pre Test")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/rest/internal/app/Recruits_Pre_Test")
@RestController
public class PreTestController extends BaseRestController {

    @PostConstruct
    public void init() {

    }

    @Operation(summary = "Pre Test")
    @RequestMapping(value = "findAll", method = RequestMethod.GET)

    public List<PreTestEntity> findAll(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token) {

        PreTestService pretestService = HBHelper.instance().service(PreTestService.class);
        List<PreTestEntity> result = pretestService.findAll();

        return result;
    }

    @Operation(summary = "Pre Test")
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public PreTestEntity findById(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("preTestId") Integer preTestId) {

        PreTestService service = HBHelper.instance().service(PreTestService.class);
        PreTestEntity en = service.findById(preTestId);
        return en;
    }

    @Operation(summary = "Pre Test")
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.PUT)

    public String saveOrUpdate(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestBody PreTestReq req) {
        String status = "";

        try {
            PreTestService service = HBHelper.instance().service(PreTestService.class);
            PreTestEntity val = new PreTestEntity();
            val.setPreTestId(req.getData().getPreTestId());
            val.setPreTestQuestion(req.getData().getPreTestQuestion());
            val.setPreTestChoice1(req.getData().getPreTestChoice1());
            val.setPreTestChoice2(req.getData().getPreTestChoice2());
            val.setPreTestChoice3(req.getData().getPreTestChoice3());
            val.setPreTestChoice4(req.getData().getPreTestChoice4());            
            val.setPreTestCorrect(req.getData().getPreTestCorrect());
            val.setPreTestCreateDT(new Date());
            val.setPreTestCreateBy(req.getData().getPreTestCreateBy());
            val.setPreTestUpdateDT(new Date());
            val.setPreTestupdateBy(req.getData().getPreTestupdateBy());
            val.setPreTestDelete(req.getData().getPreTestDelete());
            service.saveOrUpdate(val);

        } catch (Exception e) {
            status = e.getMessage();
        }
        return status;

    }

    @Operation(summary = "Pre Test")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public void delete(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            Integer id) {

        PreTestService service = HBHelper.instance().service(PreTestService.class);
        PreTestEntity result = new PreTestEntity();
        result.setPreTestId(id);
        service.delete(result);

    }
}
