/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.controller.internal.app;

import com.sense.backend.common.helper.HBHelper;
import com.sense.backend.hb.entity.auth.AbillitiesEntity;
import com.sense.backend.hb.entity.auth.ApplicationEntity;
import com.sense.backend.hb.entity.auth.ChildEntity;
import com.sense.backend.hb.entity.auth.ContactPersonEntity;
import com.sense.backend.hb.entity.auth.DataOtherEntity;
import com.sense.backend.hb.entity.auth.EducationEntity;
import com.sense.backend.hb.entity.auth.PreTestEntity;
import com.sense.backend.hb.entity.auth.QueryPDF;
import com.sense.backend.hb.entity.auth.ReferencePersonEntity;
import com.sense.backend.hb.entity.auth.SiblingEntity;
import com.sense.backend.hb.entity.auth.TrainingEntity;
import com.sense.backend.hb.entity.auth.WorkExperienceEntity;
import com.sense.backend.hb.entity.auth.qApplicationEntity;
import com.sense.backend.hb.entity.auth.qCandidateEntityToUse;
import com.sense.backend.hb.entity.auth.qPositionNameEntityToJoin;
import com.sense.backend.hb.entity.auth.qWorkExperienceEntityToJoin;
import com.sense.backend.hb.service.ApplicationService;
import com.sense.service.base.BaseRestController;
import com.sense.service.conts.ApiFilterConst;
import com.sense.service.custom.filter.ApiAttrBean;
import com.sense.service.rest.bean.internal.app.ApplicationReq;
import com.sense.service.util.DateTimeUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@Tag(name = "Application")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/rest/internal/app/Recruits_Application")
@RestController
public class ApplicationController extends BaseRestController {

    @PostConstruct
    public void init() {

    }

    @Operation(summary = "Application")
    @RequestMapping(value = "findAll", method = RequestMethod.GET)

    public List<ApplicationEntity> findAll(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token) {

        ApplicationService applicationservice = HBHelper.instance().service(ApplicationService.class);
        List<ApplicationEntity> result = applicationservice.findAll();

        return result;
    }

    @Operation(summary = "Application")
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public ApplicationEntity findById(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("applicationId") String applicationId) {

        ApplicationService service = HBHelper.instance().service(ApplicationService.class);
        ApplicationEntity en = service.findById(applicationId);
        return en;
    }

    @Operation(summary = "Application")
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.PUT)

    public String saveOrUpdate(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestBody ApplicationReq req) {
        String status = "";

        try {
            ApplicationService service = HBHelper.instance().service(ApplicationService.class);
            ApplicationEntity val = new ApplicationEntity();
            val.setApplicationId(req.getData().getApplicationId());
            val.setApplicationResumeCV(req.getData().getApplicationResumeCV());
            val.setApplicationTranscript(req.getData().getApplicationTranscript());
            val.setApplicationSalaryRange(req.getData().getApplicationSalaryRange());
            val.setApplicationStartDT(DateTimeUtil.stringToDate2(req.getData().getApplicationStartDT()));
            val.setApplicationSubmitDT(new Date());
            val.setApplicationStatus(req.getData().getApplicationStatus());
            val.setCanTitleNameTH(req.getData().getCanTitleNameTH());

            val.setCanFirstNameTH(req.getData().getCanFirstNameTH());
            val.setCanLastNameTH(req.getData().getCanLastNameTH());
            val.setCanNicknameTH(req.getData().getCanNicknameTH());
            val.setCanTitleNameENG(req.getData().getCanTitleNameENG());
            val.setCanFirstNameENG(req.getData().getCanFirstNameENG());
            val.setCanLastNameENG(req.getData().getCanLastNameENG());
            val.setCanNicknameENG(req.getData().getCanNicknameENG());
            val.setCanPhoto(req.getData().getCanPhoto());
            val.setCanSight(req.getData().getCanSight());
            val.setCanWeight(req.getData().getCanWeight());

            val.setCanHeight(req.getData().getCanHeight());
            val.setCanDtOfBirth(DateTimeUtil.stringToDate2(req.getData().getCanDtOfBirth()));
            val.setCanAge(req.getData().getCanAge());
            val.setCanNational(req.getData().getCanNational());
            val.setCanEthincity(req.getData().getCanEthincity());
            val.setCanCardId(req.getData().getCanCardId());
            val.setCanPlaceOfIssue(req.getData().getCanPlaceOfIssue());
            val.setCanDTOfIssue(DateTimeUtil.stringToDate2(req.getData().getCanDTOfIssue()));
            val.setCanMarriageStatus(req.getData().getCanMarriageStatus());
            val.setFamFatherFirstName(req.getData().getFamFatherFirstName());

            val.setFamFatherLastName(req.getData().getFamFatherLastName());
            val.setFamFatherAge(req.getData().getFamFatherAge());
            val.setFamFatherOccupation(req.getData().getFamFatherOccupation());
            val.setFamFatherWorkLocation(req.getData().getFamFatherWorkLocation());
            val.setFamMotherFirstName(req.getData().getFamMotherFirstName());
            val.setFamMotherLastName(req.getData().getFamMotherLastName());
            val.setFamMotherAge(req.getData().getFamMotherAge());
            val.setFamMotherOccupation(req.getData().getFamMotherOccupation());
            val.setFamMotherWorkLocation(req.getData().getFamMotherWorkLocation());
            val.setFamSiblingAmount(req.getData().getFamSiblingAmount());

            val.setFamSpouseFirstName(req.getData().getFamSpouseFirstName());
            val.setFamSpouseLastName(req.getData().getFamSpouseLastName());
            val.setFamSpouseAge(req.getData().getFamSpouseAge());
            val.setFamSpouseOccupation(req.getData().getFamSpouseOccupation());
            val.setFamSpouseWorkLocation(req.getData().getFamSpouseWorkLocation());
            val.setFamChildAmount(req.getData().getFamChildAmount());
            val.setContactHouseNumber(req.getData().getContactHouseNumber());
            val.setContactVillage(req.getData().getContactVillage());
            val.setContactAlley(req.getData().getContactAlley());
            val.setContactRoad(req.getData().getContactRoad());

            val.setContactSubdistrict(req.getData().getContactSubdistrict());
            val.setContactDistrict(req.getData().getContactDistrict());
            val.setContactProvince(req.getData().getContactProvince());
            val.setContactPostcode(req.getData().getContactPostcode());
            val.setContactHomePhone(req.getData().getContactHomePhone());
            val.setContactMobilePhone(req.getData().getContactMobilePhone());
            val.setContactEmail(req.getData().getContactEmail());
            val.setCurrentEDULevel(req.getData().getCurrentEDULevel());
            val.setCurrentEDUName(req.getData().getCurrentEDUName());
            val.setCurrentEDUMajor(req.getData().getCurrentEDUMajor());

            val.setCurrentEDUSemester(req.getData().getCurrentEDUSemester());
            val.setCurrentExpected(req.getData().getCurrentExpected());
            val.setTestName(req.getData().getTestName());
            val.setTestDT(new Date());
            val.setTestStartTime(new Date());
            val.setTestEndTime(new Date());
            val.setTestScore(req.getData().getTestScore());
            val.setTestTotalScore(req.getData().getTestTotalScore());
            val.setApplicationCreateDT(new Date());
            val.setApplicationCreateBy(req.getData().getApplicationCreateBy());

            val.setApplicationUpdateDT(new Date());
            val.setApplicationUpdateBy(req.getData().getApplicationUpdateBy());
            val.setApplicationDeleteFlag(req.getData().getApplicationDeleteFlag());

            val.setSiblingYouAre(req.getData().getSiblingYouAre());
            val.setPositionId(req.getData().getPositionId());
            service.saveOrUpdate(val);

        } catch (Exception e) {
            status = e.getMessage();
        }
        return status;

    }

    @Operation(summary = "Application")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public void delete(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            String id) {

        ApplicationService service = HBHelper.instance().service(ApplicationService.class);
        ApplicationEntity result = new ApplicationEntity();
        result.setApplicationId(id);
        service.delete(result);

    }

    @Operation(summary = "Application")
    @GetMapping("/allnames")
    //@RequestMapping(value = "findAllName", method = RequestMethod.GET)

    public List<qApplicationEntity> findAllName(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token) {
        ApplicationService applicationservice = HBHelper.instance().service(ApplicationService.class);
        try {
            List<qApplicationEntity> result = applicationservice.findAllName();
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    @Operation(summary = "Application")
    @RequestMapping(value = "findAbillitiesByIdToApplication", method = RequestMethod.GET)
    public List<AbillitiesEntity> findAbillitiesById(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("applicationId") String applicationId) {
        ApplicationService service = HBHelper.instance().service(ApplicationService.class);
        try {
            List<AbillitiesEntity> result = service.findAbillitiesById(applicationId);
            return result;
        } catch (Exception e) {
            System.out.print(e);
        }
        return null;
    }

    @Operation(summary = "Application")
    @RequestMapping(value = "findWorkExperienceByIdToApplication", method = RequestMethod.GET)
    public List<WorkExperienceEntity> findWorkExperienceById(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("applicationId") String applicationId) {
        ApplicationService service = HBHelper.instance().service(ApplicationService.class);
        try {
            List<WorkExperienceEntity> result = service.findWorkExperienceById(applicationId);
            return result;
        } catch (Exception e) {
            System.out.print(e);
        }
        return null;
    }

    @Operation(summary = "Application")
    @RequestMapping(value = "findReferenceByIdToApplication", method = RequestMethod.GET)
    public List<ReferencePersonEntity> findReferencePersonById(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("applicationId") String applicationId) {
        ApplicationService service = HBHelper.instance().service(ApplicationService.class);
        try {
            List<ReferencePersonEntity> result = service.findReferencePersonById(applicationId);
            return result;
        } catch (Exception e) {
            System.out.print(e);
        }
        return null;
    }

    @Operation(summary = "Application")
    @RequestMapping(value = "findTestById", method = RequestMethod.GET)
    public List<PreTestEntity> findPreTestById(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("applicationId") String applicationId) {
        ApplicationService service = HBHelper.instance().service(ApplicationService.class);
        try {
            List<PreTestEntity> result = service.findPreTestById(applicationId);
            return result;
        } catch (Exception e) {
            System.out.print(e);
        }
        return null;
    }

    @Operation(summary = "Application")
    @RequestMapping(value = "findChildByIdToApplication", method = RequestMethod.GET)
    public List<ChildEntity> findChildByid(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("applicationId") String applicationId) {
        ApplicationService service = HBHelper.instance().service(ApplicationService.class);
        try {
            List<ChildEntity> result = service.findChildByid(applicationId);
            return result;
        } catch (Exception e) {
            System.out.print(e);
        }
        return null;
    }

    @Operation(summary = "Application")
    @RequestMapping(value = "findContactPersonByIdToApplication", method = RequestMethod.GET)
    public List<ContactPersonEntity> findContactPersonByid(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("applicationId") String applicationId) {
        ApplicationService service = HBHelper.instance().service(ApplicationService.class);
        try {
            List<ContactPersonEntity> result = service.findContactPersonByid(applicationId);
            return result;
        } catch (Exception e) {
            System.out.print(e);
        }
        return null;
    }

    @Operation(summary = "Application")
    @RequestMapping(value = "findDataOtherByIdToApplication", method = RequestMethod.GET)
    public List<DataOtherEntity> findDataOtherByid(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("applicationId") String applicationId) {
        ApplicationService service = HBHelper.instance().service(ApplicationService.class);
        try {
            List<DataOtherEntity> result = service.findDataOtherByid(applicationId);
            return result;
        } catch (Exception e) {
            System.out.print(e);
        }
        return null;
    }

    @Operation(summary = "Application")
    @RequestMapping(value = "findEducationByIdToApplication", method = RequestMethod.GET)
    public List<EducationEntity> findEducationById(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("applicationId") String applicationId) {
        ApplicationService service = HBHelper.instance().service(ApplicationService.class);
        try {
            List<EducationEntity> result = service.findEducationById(applicationId);
            return result;
        } catch (Exception e) {
            System.out.print(e);
        }
        return null;
    }

    @Operation(summary = "Application")
    @RequestMapping(value = "findPositionNameByIdToApplication", method = RequestMethod.GET)
    public List<qPositionNameEntityToJoin> findPositionNameById(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("applicationId") String applicationId) {
        ApplicationService service = HBHelper.instance().service(ApplicationService.class);
        try {
            List<qPositionNameEntityToJoin> result = service.findPositionNameById(applicationId);
            return result;
        } catch (Exception e) {
            System.out.print(e);
        }
        return null;
    }

    @Operation(summary = "Application")
    @RequestMapping(value = "findSiblingByIdToApplication", method = RequestMethod.GET)
    public List<SiblingEntity> findSiblingById(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("applicationId") String applicationId) {
        ApplicationService service = HBHelper.instance().service(ApplicationService.class);
        try {
            List<SiblingEntity> result = service.findSiblingById(applicationId);
            return result;
        } catch (Exception e) {
            System.out.print(e);
        }
        return null;
    }

    @Operation(summary = "Application")
    @RequestMapping(value = "findTrainingByIdToApplication", method = RequestMethod.GET)
    public List<TrainingEntity> findTrainingById(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("applicationId") String applicationId) {
        ApplicationService service = HBHelper.instance().service(ApplicationService.class);
        try {
            List<TrainingEntity> result = service.findTrainingById(applicationId);
            return result;
        } catch (Exception e) {
            System.out.print(e);
        }
        return null;
    }

    @Operation(summary = "Application")
    @RequestMapping(value = "findCandidateByStatusToApplication", method = RequestMethod.GET)
    public List<qCandidateEntityToUse> finCandidateByStatus(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("applicationStatus") String applicationStatus) {
        ApplicationService service = HBHelper.instance().service(ApplicationService.class);
        try {
            List<qCandidateEntityToUse> result = service.finCandidateByStatus(applicationStatus);
            return result;
        } catch (Exception e) {
            System.out.print(e);
        }
        return null;
    }

    @Operation(summary = "Application")
    @RequestMapping(value = "findCandidateByIdToApplication", method = RequestMethod.GET)
    public List<qCandidateEntityToUse> finCandidateById(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("applicationId") String applicationId) {
        ApplicationService service = HBHelper.instance().service(ApplicationService.class);
        try {
            List<qCandidateEntityToUse> result = service.finCandidateById(applicationId);
            return result;
        } catch (Exception e) {
            System.out.print(e);
        }
        return null;
    }

    @Operation(summary = "Application")
    @RequestMapping(value = "findPDF", method = RequestMethod.GET)
    public QueryPDF findPDF(
            @Parameter(hidden = true)
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            @RequestParam("applicationId") String applicationId
    ) {
        ApplicationService service = HBHelper.instance().service(ApplicationService.class);
        try {
            QueryPDF result = service.findPDF(applicationId);
            return result;
        } catch (Exception e) {
            System.out.print(e);
        }
        return null;
    }

    @Operation(summary = "Application")
    @RequestMapping(value = "UpdateApplicationStatus", method = RequestMethod.PATCH)
    public void updateApplicationStatus(
            @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME) ApiAttrBean attrData,
            @RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token,
            String id,
            String status) {

        ApplicationService service = HBHelper.instance().service(ApplicationService.class);
        service.updateApplicationStatus(id, status);

    }
}
