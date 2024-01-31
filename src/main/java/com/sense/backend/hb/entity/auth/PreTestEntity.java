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
@Table(name = "PRETEST")
public class PreTestEntity implements Serializable {
    
    @Id
    @Column(name = "PRE_TEST_ID")
    private Integer preTestId;
    
    @Column(name = "PRE_TEST_QUESTION")
    private String preTestQuestion;
    
    @Column(name = "PRE_TEST_CHOICE")
    private String preTestChoice;
    
    @Column(name = "PRE_TEST_CORRECT")
    private char preTestCorrect;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PRE_TEST_CREATE_DATE")
    private Date preTestCreateDT;
    
    @Column(name = "PRE_TEST_CREATE_BY")
    private String preTestCreateBy;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PRE_TEST_UPDATE_DATE")
    private Date preTestUpdateDT;
    
    @Column(name = "PRE_TEST_UPDATE_BY")
    private String preTestupdateBy;
    
    
    
}
