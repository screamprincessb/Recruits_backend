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
@Table(name = "EDUCATION")
public class EducationEntity implements Serializable {

    @Id
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

    @Temporal(TemporalType.DATE)
    @Column(name = "EDUCATION_START_DATE")
    private Date educationStartDT;

    @Temporal(TemporalType.DATE)
    @Column(name = "EDUCATION_END_DATE")
    private Date educationEndDT;

    @Column(name = "EDUCATION_GPA")
    private float educationGPA;

    @Column(name = "APPLICATION_ID")
    private String applicationId;
}
