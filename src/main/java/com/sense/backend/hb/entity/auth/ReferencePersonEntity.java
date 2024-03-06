/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.entity.auth;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 *
 * @author SenseInfoTech
 */
@Data
@Entity
@Table(name = "REFERENCE_PERSON")
public class ReferencePersonEntity implements Serializable {

    @Id
    @Column(name = "REF_PERSON_ID")
    private String refPersonId;

    @Column(name = "REF_FIRST_NAME")
    private String refFirstName;

    @Column(name = "REF_LAST_NAME")
    private String refLastName;

    @Column(name = "REF_JOB_POSITION")
    private String refJobPosition;

    @Column(name = "REF_WORK_LOCATION")
    private String refWorkLocation;

    @Column(name = "REF_PHONE")
    private String refPhone;
    
    @Column(name = "APPLICATION_ID")
    private String applicationId;

}
