/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.controller.internal.app;

import com.sense.backend.common.helper.HBHelper;
import com.sense.backend.hb.entity.auth.TrainingEntity;
import com.sense.backend.hb.service.TrainingService;
import com.sense.service.base.BaseRestController;
import com.sense.service.conts.ApiFilterConst;
import com.sense.service.custom.filter.ApiAttrBean;
import com.sense.service.rest.bean.internal.app.TrainingReq;
import com.sense.service.util.DateTimeUtil;
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
@Tag(name = "Training")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/rest/internal/app/Recruits_Training")
@RestController
public class TrainingController extends BaseRestController {

    @PostConstruct
    public void init() {

    }

    @Operation(summary = "Training")
    @RequestMapping(value = "findAll", method = RequestMethod.GET)

    public List<TrainingEntity> findAll(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token) {

        TrainingService trainingservice = HBHelper.instance().service(TrainingService.class);
        List<TrainingEntity> result = trainingservice.findAll();

        return result;
    }

    @Operation(summary = "Training")
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public TrainingEntity findById(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("trainingId") String trainingId) {

        TrainingService service = HBHelper.instance().service(TrainingService.class);
        TrainingEntity en = service.findById(trainingId);
        return en;
    }

    @Operation(summary = "Training")
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.PUT)

    public String saveOrUpdate(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestBody TrainingReq req) {
        String status = "";

        try {
            TrainingService service = HBHelper.instance().service(TrainingService.class);
            TrainingEntity val = new TrainingEntity();
            val.setTrainingId(req.getData().getTrainingId());
//            val.setTrainingDate(new Date());
            val.setTrainingDate(DateTimeUtil.stringToDate2(req.getData().getTrainingDate()));
            val.setTrainingCourse(req.getData().getTrainingCourse());
            val.setTrainingInstitution(req.getData().getTrainingInstitution());
            val.setTrainingQualification(req.getData().getTrainingQualification());
            val.setTrainingTime(req.getData().getTrainingTime());
            val.setApplicationId(req.getData().getApplicationId());
            service.saveOrUpdate(val);

        } catch (Exception e) {
            status = e.getMessage();
        }
        return status;

    }

    @Operation(summary = "Training")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public void delete(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            String id) {

        TrainingService service = HBHelper.instance().service(TrainingService.class);
        TrainingEntity result = new TrainingEntity();
        result.setTrainingId(id);
        service.delete(result);

    }
}
