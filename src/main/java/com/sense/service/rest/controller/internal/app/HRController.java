/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.controller.internal.app;

import com.sense.backend.common.helper.HBHelper;
import com.sense.backend.hb.entity.auth.HREntity;
import com.sense.backend.hb.service.HRService;
import com.sense.service.base.BaseRestController;
import com.sense.service.conts.ApiFilterConst;
import com.sense.service.custom.filter.ApiAttrBean;
import com.sense.service.rest.bean.internal.app.HRReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author SenseInfoTech
 */
@Slf4j
@Api(tags = {"Recruits HR Service"}, description = " ")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/rest/internal/app/Recruits_HR")
@RestController
public class HRController extends BaseRestController {

    @PostConstruct
    public void init() {

    }

    @ApiOperation(value = "HR")
    @RequestMapping(value = "findAll", method = RequestMethod.GET)

    public List<HREntity> findAll(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token) {

        HRService hrservice = HBHelper.instance().service(HRService.class);
        List<HREntity> result = hrservice.findAll();

        return result;
    }

    @ApiOperation(value = "HR")
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.PUT)

    public String saveOrUpdate(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestBody HRReq req) {
        String status = "";
        try {
            HRService service = HBHelper.instance().service(HRService.class);
            HREntity val = new HREntity();
            val.setHrId(req.getData().getHrId());
            val.setHrTitleName(req.getData().getHrTitleName());
            val.setHrFirstName(req.getData().getHrFirstName());
            val.setHrLastName(req.getData().getHrLastName());
            val.setHrPosition(req.getData().getHrPosition());
            val.setHrPhone(req.getData().getHrPhone());
            val.setHrEmail(req.getData().getHrEmail());
            val.setHrUser(req.getData().getHrUser());
            val.setHrPassword(req.getData().getHrPassword());
            val.setHrCreateDT(new Date());
            val.setHrCreateBy(req.getData().getHrCreateBy());
            val.setHrUpdateDT(new Date());
            val.setHrUpdateBy(req.getData().getHrUpdateBy());
            val.setHrDeleteFlag(req.getData().getHrDeleteFlag());
            service.saveOrUpdate(val);

            status = "OK";
        } catch (Exception e) {
            status = e.getMessage();
        }
        return status;
    }

}
