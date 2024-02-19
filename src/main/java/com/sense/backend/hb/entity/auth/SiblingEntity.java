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
@Table(name = "SIBLING")
public class SiblingEntity implements Serializable {

    @Id
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
    
    @Column(name = "APPLICATION_ID")
    private String applicationId;

}
