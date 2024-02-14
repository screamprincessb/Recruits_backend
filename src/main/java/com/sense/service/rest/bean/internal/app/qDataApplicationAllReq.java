/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.bean.internal.app;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author SenseInfoTech
 */
@ToString
@Data
public class qDataApplicationAllReq implements Serializable {

    private qDataApplicationAllData data;
    
    @Data
    public class qDataApplicationAllData {

        private Integer applicationId;
        private String applicationResumeCV;
        private String applicationTranscript;
        private String applicationSalaryRange;
//    private Date applicationStartDT;
//    private Date applicationSubmitDT;
        private String applicationStatus;
        private String canTitleNameTH;
        private String canFirstNameTH;
        private String canLastNameTH;
        private String canNickameTH;
        private String canTitleNameENG;
        private String canFirstNameENG;
        private String canLastNameENG;
        private String canNickameENG;
        private String canPhoto;
        private float canSight;
        private float canWeight;
        private float canHeight;
//    private Date canDtOfBirth;
        private Integer canAge;
        private String canNational;
        private String canEthincity;
        private String canCardId;
        private String canPlaceOfIssue;
//    private Date canDTOfIssue;
        private String canMarrieageStatus;
        private String famFatherFirstName;
        private String famFatherLastName;
        private Integer famFatherAge;
        private String famFatherOccupation;
        private String famFatherWorkLocation;
        private String famMotherFirstName;
        private String famMotherLastName;
        private Integer famMotherAge;
        private String famMotherOccupation;
        private String famMotherWorkLocation;
        private Integer famSiblingAmount;
        private String famSpouseFirstName;
        private String famSpouseLastName;
        private Integer famSpouseAge;
        private String famSpouseOccupation;
        private String famSpouseWorkLocation;
        private Integer famChildAmount;
        private String contactHouseNubmer;
        private String contactVillage;
        private String contactAlley;
        private String contactRoad;
        private String contactSubdistrict;
        private String contactDistrict;
        private String contactProvince;
        private String contactPostcode;
        private String contactHomePhone;
        private String contactMobilePhone;
        private String contactEmail;
        private String currentEDULevel;
        private String currentEDUName;
        private String currentEDUMajor;
        private String currentEDUSemester;
        private String currentExpected;
        private String testName;
//    private Date testDT;
//    private Date testStartTime;
//    private Date testEndTime;
        private Integer testScore;
        private Integer testTotalScore;
//    private Date applicationCreateDT;
        private String applicationCreateBy;
//    private Date applicationUpdateDT;
        private String applicationUpdateBy;
        private String applicationDeleteFlag;
        private Integer positionId;
        private Integer childId;
        private Integer childNumber;
        private String childFirstName;
        private String childLastName;
        private Integer childAge;
        private String childGender;
        private String childEducationLevel;
        private Integer doId;
        private String doQuestion;
        private String doANS;
        private String doOtherANS;
        private Integer siblingId;
        private Integer siblingNumber;
        private Integer siblingYouAre;
        private String siblingFirstName;
        private String siblingLastName;
        private Integer siblingAge;
        private String siblingOccupation;
        private String siblingWorkLocation;
        private Integer abillitiesId;
        private Integer abillitiesToeicScore;
        private Integer abillitiesTofelScore;
        private String abillitiesComputerSkill;
        private String abillitiesOther;
        private String abillitiesHobby;
        private Integer educationId;
        private String educationLevel;
        private String educationName;
        private String educationQualification;
        private String educationMajor;
//    private String educationStartDT;
//    private String educationEndDT;
        private float educationGPA;
        private Integer trainingId;
//    private Date trainingDate;
        private String trainingCourse;
        private String trainingInstitution;
        private String trainingQualification;
        private String trainingTime;
        private Integer workExperienceId;
//    private Date weStartDT;
//    private Date weEndDT;
        private String weBusinessType;
        private String weName;
        private String wePosition;
        private String weOtherBenefit;
        private float weSalary;
        private String weAddressPhone;
        private String weDescription;
        private String weReasonLeaving;
        private Integer contactPersonId;
        private String cpFirstName;
        private String cpLastName;
        private String cpRelation;
        private String cpPhone;
        private String cpAddress;
    }
}
