/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.entity.auth;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author SenseInfoTech
 */
@Data
@Entity
@Table(name = "APPLICATION")
public class ApplicationEntity implements Serializable{
    
    @Id
    @Column(name = "AAPLICATION_ID")
    private int application_id;
    
    @Column(name = "APPLICATION_LINK")
    private String applicationLink;
    
    @Column(name = "APPLICATION_RESUME_CV")
    private String applicationResumeCV;
    
    @Column(name = "APPLICATION_TRANSCRIPT")
    private String applicationTranscript;
    
    @Column(name = "APPLICATION_POSITION")
    private String applicationPosition;
    
    @Column(name = "APPLICATION_SALARY_RANGE")
    private String applicationSalaryRange;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "APPLICATION_START_DATE")
    private Date applicationStartDT;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "APPLICATION_SUBMIT_DATE")
    private Date applicationSubmitDT;
    
    @Column(name = "APPLICATION_STATUS")
    private String applicationStatus;
    
    @Column(name = "CAN_TITLE_NAME_TH")
    private String canTitleNameTH;
    
    @Column(name = "CAN_FIRST_NAME_TH")
    private String canFirstNameTH;
    
    @Column(name = "CAN_LAST_NAME_TH")
    private String canLastNameTH;
    
    @Column(name = "CAN_NICKNAME_TH")
    private String canNickameTH;
    
    @Column(name = "CAN_TITLE_NAME_ENG")
    private String canTitleNameENG;
    
    @Column(name = "CAN_FIRST_NAME_ENG")
    private String canFirstNameENG;
    
    @Column(name = "CAN_LAST_NAME_ENG")
    private String canLastNameENG;
    
    @Column(name = "CAN_NICKNAME_ENG")
    private String canNickameENG;
    
    @Column(name = "CAN_PHOTO")
    private String canPhoto;
    
    @Column(name = "CAN_SIGHT")
    private float canSight;
    
    @Column(name = "CAN_WEIGHT")
    private float canWeight;
    
    @Column(name = "CAN_HEIGHT")
    private float canHeight;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CAN_DATE_OF_BIRTH")
    private Date canDtOfBirth;
    
    @Column(name = "CAN_AGE")
    private int canAge;
    
    @Column(name = "CAN_NATIONAL")
    private String canNational;
    
    @Column(name = "CAN_ETHINCITY")
    private String canEthincity;
    
    @Column(name = "CAN_CARD_ID")
    private String canCardId;
    
    @Column(name = "CAN_PLACE_OF_ISSUE")
    private String canPlaceOfIssue;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CAN_DATE_OF_ISSUE")
    private Date canDTOfIssue;
    
    @Column(name = "CAN_MARRIEAGE_STATUS")
    private String canMarrieageStatus;
    
    @Column(name = "FAM_FATHER_FIRST_NAME")
    private String famFatherFirstName;
    
    @Column(name = "FAM_FATHER_LAST_NAME")
    private String famFatherLastName;
    
    @Column(name = "FAM_FATHER_AGE")
    private int famFatherAge;
    
    @Column(name = "FAM_FATHER_OCCUPATION")
    private String famFatherOccupation;
    
    @Column(name = "FAM_FATHER_WORK_LOCATION")
    private String famFatherWorkLocation;
    
    @Column(name = "FAM_MOTHER_FIRST_NAME")
    private String famMotherFirstName;
    
    @Column(name = "FAM_MOTHER_LAST_NAME")
    private String famMotherLastName;
    
    @Column(name = "FAM_MOTHER_AGE")
    private int famMotherAge;
    
    @Column(name = "FAM_MoTHER_OCCUPATION")
    private String famMotherOccupation;
    
    @Column(name = "FAM_MOTHER_WORK_LOCATION")
    private String famMotherWorkLocation;
    
    @Column(name = "FAM_SIBLING_AMOUNT")
    private int famSiblingAmount;
    
    @Column(name = "FAM_SPOUSE_FIRST_NAME")
    private String famSpouseFirstName;
    
    @Column(name = "FAM_SPOUSE_LAST_NAME")
    private String famSpouseLaastName;
    
    @Column(name = "FAM_SPOUSE_AGE")
    private int famSpouseAge;
    
    @Column(name = "FAM_SPOUSE_OCCUPATION")
    private String famSpouseOccupation;
    
    @Column(name = "FAM_SPOUSE_WORK_LOCATION")
    private String famSpouseWorkLocation;
    
    @Column(name = "FAM_CHILD_AMOUNT")
    private int famChildAmount;
    
    @Column(name = "CONTACT_HOUSE_NUMBER")
    private String contactHouseNubmer;
    
    @Column(name = "CONTACT_VILLAGE")
    private String contactVillage;
    
    @Column(name = "CONTACT_ALLEY")
    private String contactAlley;
    
    @Column(name = "CONTACT_ROAD")
    private String contactRoad;
    
    @Column(name = "CONTACT_SUBDISTRICT")
    private String contactSubdistrict;
    
    @Column(name = "CONTACT_DISTRICT")
    private String contactDistrict;
    
    @Column(name = "CONTACT_PROVINCE")
    private String contactProvince;
    
    @Column(name = "CONTACT_POSTCODE")
    private String contactPostcode;
    
    @Column(name = "CONTACT_HOME_PHONE")
    private String contactHomePhone;
    
    @Column(name = "CONTACT_MOBILE_PHONE")
    private String contactMobilePhone;
    
    @Column(name = "CONATACT_EMAIL")
    private String contactEmail;
    
    @Column(name = "CURRENT_EDU_LEVEL")
    private String currentEDULevel;
    
    @Column(name = "CURRENT_EDU_NAME")
    private String currentEDUName;
    
    @Column(name = "CURRENT_EDU_MAJOR")
    private String currentEDUMajor;
    
    @Column(name = "CURRENT_EDU_SEMESTER")
    private String currentEDUSemester;
    
    @Column(name = "CURRENT_EXPECTED")
    private String currentExpected;
    
    @Column(name = "TEST_NAME")
    private String testName;
    
    @Temporal(TemporalType.TIMESTAMP)    
    @Column(name = "TEST_DATE")
    private Date testDT;
    
    @Temporal(TemporalType.TIMESTAMP)    
    @Column(name = "TEST_START_TIME")
    private Date testStartTime;
    
    @Temporal(TemporalType.TIMESTAMP)    
    @Column(name = "TEST_END_TIME")
    private Date testEndTime;
    
    @Column(name = "TEST_SCORE")
    private int testScore;
    
    @Column(name = "TEST_TOTAL_SCORE")
    private int testTotalScore;
    
    @Temporal(TemporalType.TIMESTAMP)    
    @Column(name = "APPLICATION_CREATE_DATE")
    private Date applicationCreateDT;
    
    @Column(name = "APPLICATION_CREATE_BY")
    private String applicationCreateBy;
    
    @Temporal(TemporalType.TIMESTAMP)    
    @Column(name = "APPLICATION_UPDATE_DATE")
    private Date applicationUpdateDT;
    
    @Column(name = "APPLICATION_UPDATE_BY")
    private String applicationUpdateBy;
    
    @Column(name = "APPLICATION_DELETE_FLAG")
    private String applicationDeleteFlag;
}
