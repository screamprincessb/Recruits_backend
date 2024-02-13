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
@Table(name = "Q_APPLICATION")
public class qApplicationEntity {
    @Id
    @Column(name = "APPLICATION_ID")
    private Integer applicationId;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "APPLICATION_SUBMIT_DATE")
    private Date applicationSubmitDT;
    
    @Column(name = "CAN_FIRST_NAME_TH")
    private String canFirstNameTH;
    
    @Column(name = "CAN_LAST_NAME_TH")
    private String canLastNameTH;
    
    @Column(name = "POSITION_NAME")
    private String positionName;
    
    @Column(name = "APPLICATION_STATUS")
    private String applicationStatus;
}
