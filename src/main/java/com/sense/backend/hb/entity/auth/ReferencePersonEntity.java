/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.entity.auth;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author SenseInfoTech
 */
@Data
@Entity
@Table(name = "REFERENCE_PERSON")
public class ReferencePersonEntity implements Serializable{
    
    @Id
    @Column(name = "REF_PERSON_ID")
    private int refPersonId;
    
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
    
    
}
