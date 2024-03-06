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
@Table(name = "APPLICATION")
public class QueryPDF {

    @Id
    @Column(name = "APPLICATION_ID")
    private String applicationId;

    @Column(name = "APPLICATION_SALARY_RANGE")
    private String applicationSalaryRange;

    @Temporal(TemporalType.DATE)
    @Column(name = "APPLICATION_START_DATE")
    private Date applicationStartDT;

    @Column(name = "CAN_TITLE_NAME_TH")
    private String canTitleNameTH;

    @Column(name = "CAN_FIRST_NAME_TH")
    private String canFirstNameTH;

    @Column(name = "CAN_LAST_NAME_TH")
    private String canLastNameTH;

    @Column(name = "CAN_NICKNAME_TH")
    private String canNicknameTH;

    @Column(name = "CAN_TITLE_NAME_ENG")
    private String canTitleNameENG;

    @Column(name = "CAN_FIRST_NAME_ENG")
    private String canFirstNameENG;

    @Column(name = "CAN_LAST_NAME_ENG")
    private String canLastNameENG;

    @Column(name = "CAN_NICKNAME_ENG")
    private String canNicknameENG;

//    @Column(name = "CAN_PHOTO")
//    private String canPhoto;
    @Column(name = "CAN_SIGHT")
    private String canSight;

    @Column(name = "CAN_WEIGHT")
    private float canWeight;

    @Column(name = "CAN_HEIGHT")
    private float canHeight;

    @Temporal(TemporalType.DATE)
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

    @Temporal(TemporalType.DATE)
    @Column(name = "CAN_DATE_OF_ISSUE")
    private Date canDTOfIssue;

    @Column(name = "CAN_MARRIAGE_STATUS")
    private String canMarriageStatus;

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

    @Column(name = "FAM_MOTHER_OCCUPATION")
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
    private String contactHouseNumber;

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

    @Column(name = "SIBLING_YOU_ARE")
    private String siblingYouAre;

    @Column(name = "POSITION_ID")
    private String positionId;

    @Column(name = "POSITION_NAME")
    private String positionName;

    @Column(name = "CHILD_ID")
    private String childId;

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

    @Column(name = "CONTACT_PERSON_ID")
    private String contactPersonId;

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

    @Column(name = "EDUCATION_ID")
    private String educationId;

    @Column(name = "EDUCATION_LEVEL")
    private String educationLevel;

    @Column(name = "EDUCATION_NAME")
    private String educationName;

    @Column(name = "EDUCATION_QUALIFICATION")
    private String educationQualification;

    @Column(name = "EDUCATION_MAJOR")
    private String educationMajor;

//    @Temporal(TemporalType.DATE)
    @Column(name = "EDUCATION_START_DATE")
    private String educationStartDT;

//    @Temporal(TemporalType.DATE)
    @Column(name = "EDUCATION_END_DATE")
    private String educationEndDT;

    @Column(name = "EDUCATION_GPA")
    private float educationGPA;

    @Column(name = "SIBLING_ID")
    private String siblingId;

    @Column(name = "SIBLING_NUMBER")
    private Integer siblingNumber;

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

    @Column(name = "TRAINING_ID")
    private String trainingId;

    @Temporal(TemporalType.DATE)
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
    private String workExperienceId;

    @Temporal(TemporalType.DATE)
    @Column(name = "WE_START_DATE")
    private Date weStartDT;

    @Temporal(TemporalType.DATE)
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

}
