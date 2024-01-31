/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.bean.internal.app;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author SenseInfoTech
 */
@ToString
@Data
public class ApplicationReq implements Serializable {

    private ApplicationData data;

    @Data
    public class ApplicationData {

        private Integer applicationId;
        private String applicationLink;
        private String applicationResumeCV;
        private String applicationTranscript;
        private String applicationPosition;
        private String applicationSalaryRange;
//        private Date applicationStartDT;
//        private Date applicationSubmitDT;
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
//        private Date canDtOfBirth;
        private Integer canAge;
        private String canNational;
        private String canEthincity;
        private String canCardId;
        private String canPlaceOfIssue;
//        private Date canDTOfIssue;
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
        private String famSpouseLaastName;
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
//        private Date testDT;
//        private Date testStartTime;
//        private Date testEndTime;
        private Integer testScore;
        private Integer testTotalScore;
//        private Date applicationCreateDT;
        private String applicationCreateBy;
//        private Date applicationUpdateDT;
        private String applicationUpdateBy;
        private String applicationDeleteFlag;

    }
}
