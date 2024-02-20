/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.controller.internal.app;

import com.sense.backend.common.helper.HBHelper;
import com.sense.backend.hb.entity.auth.VehicleEntity;
import com.sense.backend.hb.service.VehicleService;
import com.sense.service.base.BaseRestController;
import com.sense.service.conts.ApiFilterConst;
import com.sense.service.custom.filter.ApiAttrBean;
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
@Tag(name = "Vehicle")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/rest/internal/app/Recruits_Vehicle")
@RestController
public class VehicleController extends BaseRestController {

    @PostConstruct
    public void init() {

    }

    @Operation(summary = "Vehicle")
    @RequestMapping(value = "findAll", method = RequestMethod.GET)

    public List<VehicleEntity> findAll(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token) {

        VehicleService vehicleservice = HBHelper.instance().service(VehicleService.class);
        List<VehicleEntity> result = vehicleservice.findAll();

        return result;
    }

    @Operation(summary = "Vehicle")
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public VehicleEntity findById(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("vehicleId") String vehicleId) {

        VehicleService service = HBHelper.instance().service(VehicleService.class);
        VehicleEntity en = service.findById(vehicleId);
        return en;
    }

    @Operation(summary = "Vehicle")
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.PUT)

    public String saveOrUpdate(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestBody VehicleReq req) {
        String status = "";

        try {
            VehicleService service = HBHelper.instance().service(VehicleService.class);
            VehicleEntity val = new VehicleEntity();
            val.setVehicleId(req.getData().getVehicleId());
            val.setVehicleType(req.getData().getVehicleType());
            val.setVehicleDrive(req.getData().getVehicleDrive());
            val.setVehicleOwn(req.getData().getVehicleOwn());
            val.setVehicleNo(req.getData().getVehicleNo());
            val.setAbillitiesId(req.getData().getAbillitiesId());
            service.saveOrUpdate(val);

        } catch (Exception e) {
            status = e.getMessage();
        }
        return status;

    }

    @Operation(summary = "Vehicle")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public void delete(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            String id) {

        VehicleService service = HBHelper.instance().service(VehicleService.class);
        VehicleEntity result = new VehicleEntity();
        result.setVehicleId(id);
        service.delete(result);

    }
}
