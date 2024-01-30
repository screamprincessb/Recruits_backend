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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
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
}
