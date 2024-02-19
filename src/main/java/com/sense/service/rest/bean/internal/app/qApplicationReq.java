/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.bean.internal.app;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author SenseInfoTech
 */
@ToString
@Data
public class qApplicationReq implements Serializable{
    
    private qApplicationData data;
    
    @Data
    public class qApplicationData{
    private String applicationId;
    private Integer positionId;
    private Date applicationSubmitDT;
    private String canFirstNameTH;
    private String canLastNameTH;
    private String positionName;
    private String applicationStatus;
}
}
