/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.entity.auth;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author SenseInfoTech
 */
@Data
@Entity
@Table(name = "HR")
public class HREntity implements Serializable{
    
    @Id
    @Column(name = "HR_ID")
    private int hrId;
    
    @Column(name = "HR_TITLE_NAME")
    private String hrTitleName;
    
    @Column(name = "HR_FIRST_NAME")
    private String hrFirstName;
    
    @Column(name = "HR_LAST_NAME")
    private String hrLastName;
    
    @Column(name = "HR_POSITION")
    private String hrPosition;
    
    @Column(name = "HR_PHONE")
    private String hrPhone;
    
    @Column(name = "HR_EMAIL")
    private String hrEmail;
    
    @Column(name = "HR_USER")
    private String hrUser;
    
    @Column(name = "HR_PASSWORD")
    private String hrPassword;
    
    @Temporal(TemporalType.TIMESTAMP)    
    @Column(name = "HR_CREATE_DATE")
    private Date hrCreateDT;
    
    @Column(name = "HR_CREATE_BY")
    private String hrCreateBy;
    
    @Temporal(TemporalType.TIMESTAMP)    
    @Column(name = "HR_UPDATE_DATE")
    private Date hrUpdateDT;
    
    @Column(name = "HR_UPDATE_BY")
    private String hrUpdateBy;
    
    @Column(name = "HR_DELETE_FLAG")
    private String hrDeleteFlag;
}
