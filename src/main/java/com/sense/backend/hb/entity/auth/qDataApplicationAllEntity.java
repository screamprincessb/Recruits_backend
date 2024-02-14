/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.entity.auth;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author SenseInfoTech
 */
@Data
@Entity
@Table(name = "Q_DATA_APPLICATION_ENTITY")
public class qDataApplicationAllEntity {
    @Id
    @Column(name = "APPLICATION_ID")
    private Integer applicationId;
    
    @Column(name = "APPLICATION_RESUME_CV")
    private String applicationResumeCV;
    
    @Column(name = "APPLICATION_TRANSCRIPT")
    private String applicationTranscript;
    
    @Column(name = "APPLICATION_SALARY_RANGE")
    private String applicationSalaryRange;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "APPLICATION_START_DATE")
    private Date applicationStartDT;
    
    @Temporal(TemporalType.DATE)
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
    private Integer canAge;
    
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
    private Integer famFatherAge;
    
    @Column(name = "FAM_FATHER_OCCUPATION")
    private String famFatherOccupation;
    
    @Column(name = "FAM_FATHER_WORK_LOCATION")
    private String famFatherWorkLocation;
    
    @Column(name = "FAM_MOTHER_FIRST_NAME")
    private String famMotherFirstName;
    
    @Column(name = "FAM_MOTHER_LAST_NAME")
    private String famMotherLastName;
    
    @Column(name = "FAM_MOTHER_AGE")
    private Integer famMotherAge;
    
    @Column(name = "FAM_MoTHER_OCCUPATION")
    private String famMotherOccupation;
    
    @Column(name = "FAM_MOTHER_WORK_LOCATION")
    private String famMotherWorkLocation;
    
    @Column(name = "FAM_SIBLING_AMOUNT")
    private Integer famSiblingAmount;
    
    @Column(name = "FAM_SPOUSE_FIRST_NAME")
    private String famSpouseFirstName;
    
    @Column(name = "FAM_SPOUSE_LAST_NAME")
    private String famSpouseLastName; 
    
    @Column(name = "FAM_SPOUSE_AGE")
    private Integer famSpouseAge;
    
    @Column(name = "FAM_SPOUSE_OCCUPATION")
    private String famSpouseOccupation;
    
    @Column(name = "FAM_SPOUSE_WORK_LOCATION")
    private String famSpouseWorkLocation;
    
    @Column(name = "FAM_CHILD_AMOUNT")
    private Integer famChildAmount;
    
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
    
    @Column(name = "CONTACT_EMAIL")
    private String contactEmail;
    
    @Column(name = "CURRENT_EDU_LEVEL")
    private String currentEDULevel;
    
    @Column(name = "CURRENT_EDU_NAME")
    private String currentEDUName;
    
    @Column(name = "CURRENT_EDU_MAJOR")
    private String currentEDUMajor;
    
    @Column(name = "CURRENT_EDU_SEMESTER")
    private String currentEDUSemester;
    
    @Column(name = "CURRENT_EDU_EXPECTED")
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
    private Integer testScore;
    
    @Column(name = "TEST_TOTAL_SCORE")
    private Integer testTotalScore;
    
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
    
    @Column (name = "POSITION_ID")
    private Integer positionId;
    @Column(name = "CHILD_ID")
    private Integer childId;

    @Column(name = "CHILD_NUMBER")
    private Integer childNumber;

    @Column(name = "CHILD_FIRST_NAME")
    private String childFirstName;

    @Column(name = "CHILD_LAST_NAME")
    private String childLastName;

    @Column(name = "CHILD_AGE")
    private Integer childAge;

    @Column(name = "CHILD_GENDER")
    private String childGender;

    @Column(name = "CHILD_EDUCATION_LEVEL")
    private String childEducationLevel;

    @Column(name = "DO_ID")
    private Integer doId;

    @Column(name = "DO_QUESTION")
    private String doQuestion;

    @Column(name = "DO_ANS")
    private String doANS;

    @Column(name = "DO_OTHER_ANS")
    private String doOtherANS;
    
    @Column(name = "SIBLING_ID")
    private Integer siblingId;

    @Column(name = "SIBLING_NUMBER")
    private Integer siblingNumber;

    @Column(name = "SIBLING_YOU_ARE")
    private Integer siblingYouAre;

    @Column(name = "SIBLING_FIRST_NAME")
    private String siblingFirstName;

    @Column(name = "SIBLING_LAST_NAME")
    private String siblingLastName;

    @Column(name = "SIBLING_AGE")
    private Integer siblingAge;

    @Column(name = "SIBLING_OCCUPATION")
    private String siblingOccupation;

    @Column(name = "SIBLING_WORK_LOCATION")
    private String siblingWorkLocation;
    
    @Column(name = "ABILLITIES_ID")
    private Integer abillitiesId;

    @Column(name = "ABILLITIES_TOEIC_SCORE")
    private Integer abillitiesToeicScore;

    @Column(name = "ABiLLITIES_TOFEL_SCORE")
    private Integer abillitiesTofelScore;

    @Column(name = "ABILLITIES_COMPUTER_SKILL")
    private String abillitiesComputerSkill;

    @Column(name = "ABILLITIES_OTHER")
    private String abillitiesOther;

    @Column(name = "ABILLITIES_HOBBY")
    private String abillitiesHobby;
    
    @Column(name = "EDUCATION_ID")
    private Integer educationId;

    @Column(name = "EDUCATION_LEVEL")
    private String educationLevel;

    @Column(name = "EDUCATION_NAME")
    private String educationName;

    @Column(name = "EDUCATION_QUALIFICATION")
    private String educationQualification;

    @Column(name = "EDUCATION_MAJOR")
    private String educationMajor;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EDUCATION_START_DATE")
    private String educationStartDT;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EDUCATION_END_DATE")
    private String educationEndDT;

    @Column(name = "EDUCATION_GPA")
    private float educationGPA;
    
    @Column(name = "TRAINING_ID")
    private Integer trainingId;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TRAINING_DATE")
    private Date trainingDate;
    
    @Column(name = "TRAINING_COURSE")
    private String trainingCourse;
    
    @Column(name = "TRAINING_INSTITUTION")
    private String trainingInstitution;
    
    @Column(name = "TRAINING_QUALIFICATION")
    private String trainingQualification;
    
    @Column(name = "TRAINING_TIME")
    private String trainingTime;
    
    @Column(name = "WORK_EXPERIENCE_ID")
    private Integer workExperienceId;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "WE_START_DATE")
    private Date weStartDT;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "WE_END_DATE")
    private Date weEndDT;
    
    @Column(name = "WE_BUSINESS_TYPE")
    private String weBusinessType;
    
    @Column(name = "WE_NAME")
    private String weName;
    
    @Column(name = "WE_POSITION")
    private String wePosition;
    
    @Column(name = "WE_OTHER_BENEFIT")
    private String weOtherBenefit;
    
    @Column(name = "WE_SALARY")
    private float weSalary;
    
    @Column(name = "WE_ADDRESS_PHONE")
    private String weAddressPhone;
    
    @Column(name = "WE_DESCRIPTION")
    private String weDescription;
    
    @Column(name = "WE_REASON_LEAVING")
    private String weReasonLeaving;
    
    @Column(name = "CONTACT_PERSON_ID")
    private Integer contactPersonId;
    
    @Column(name = "CP_FIRST_NAME")
    private String cpFirstName;
    
    @Column(name = "CP_LAST_NAME")
    private String cpLastName;
    
    @Column(name = "CP_RELATION")
    private String cpRelation;
    
    @Column(name = "CP_PHONE")
    private String cpPhone;
    
    @Column(name = "CP_ADDRESS")
    private String cpAddress;
    
}
