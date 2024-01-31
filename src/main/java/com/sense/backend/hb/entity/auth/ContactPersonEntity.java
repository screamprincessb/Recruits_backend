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
@Table(name = "CONTACT_PERSON")
public class ContactPersonEntity implements Serializable{
    
    @Id
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

    @Column (name = "APPLICATION_ID")
    private Integer applicationId;
}
