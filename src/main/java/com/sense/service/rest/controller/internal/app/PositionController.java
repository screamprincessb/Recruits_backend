/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.controller.internal.app;

import com.sense.backend.common.helper.HBHelper;
import com.sense.backend.hb.entity.auth.PositionEntity;
import com.sense.backend.hb.service.PositionService;
import com.sense.service.base.BaseRestController;
import com.sense.service.conts.ApiFilterConst;
import com.sense.service.custom.filter.ApiAttrBean;
import com.sense.service.rest.bean.internal.app.HRReq;
import com.sense.service.rest.bean.internal.app.PositionReq;
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
@Tag(name = "Position")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/rest/internal/app/Recruits_POSITION")
@RestController
public class PositionController extends BaseRestController {

    @PostConstruct
    public void init() {

    }

    @Operation(summary = "Position")
    @RequestMapping(value = "findAll", method = RequestMethod.GET)

    public List<PositionEntity> findAll(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token) {

        PositionService positionservice = HBHelper.instance().service(PositionService.class);
        List<PositionEntity> result = positionservice.findAll();

        return result;
    }

    @Operation(summary = "Position")
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public PositionEntity findById(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("positionId") Integer positionId) {

        PositionService service = HBHelper.instance().service(PositionService.class);
        PositionEntity en = service.findById(positionId);
        return en;
    }

    @Operation(summary = "Position")
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.PUT)

    public String saveOrUpdate(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestBody PositionReq req) {
        String status = "";
        try {
            PositionService service = HBHelper.instance().service(PositionService.class);
            PositionEntity val = new PositionEntity();
            val.setPositionId(req.getData().getPositionId());
            val.setPositionName(req.getData().getPositionName());
            val.setPositionLink(req.getData().getPositionLink());
            service.saveOrUpdate(val);

            status = "OK";
        } catch (Exception e) {
            status = e.getMessage();
        }
        return status;
    }

    @Operation(summary = "Position")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public void delete(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            Integer id) {

        PositionService service = HBHelper.instance().service(PositionService.class);
        PositionEntity result = new PositionEntity();
        result.setPositionId(id);
        service.delete(result);

    }

}
