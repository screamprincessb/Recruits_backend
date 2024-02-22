/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.entity.auth;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 *
 * @author SenseInfoTech
 */
@Data
@Entity
public class qCandidateEntityToUse {
    
    @Id
    @Column(name = "APPLICATION_ID")
    private String applicationId;
    
    @Column(name = "CAN_FIRST_NAME_TH")
    private String canFirstNameTH;

    @Column(name = "CAN_LAST_NAME_TH")
    private String canLastNameTH;
    
    @Column(name = "APPLICATION_STATUS")
    private String applicationStatus;
    
    @Column(name = "POSITION_ID")
    private String positionId;

    @Column(name = "POSITION_NAME")
    private String positionName;
}
