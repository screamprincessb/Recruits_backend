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
@Table(name = "DATA_OTHER")
public class DataOtherEntity implements Serializable{
    
    @Id
    @Column(name = "DO_ID")
    private int doId;
    
    @Column(name = "DO_QUESTION")
    private String doQuestion;
    
    @Column(name = "DO_ANS")
    private char doANS;
    
    @Column(name = "DO_OTHER_ANS")
    private String doOtherANS;
    
}
