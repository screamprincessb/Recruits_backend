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
@Table(name = "DATA_OTHER")
public class DataOtherEntity implements Serializable {

    @Id
    @Column(name = "DO_ID")
    private String doId;

    @Column(name = "DO_QUESTION")
    private String doQuestion;

    @Column(name = "DO_ANS")
    private String doANS;

    @Column(name = "APPLICATION_ID")
    private String applicationId;

}
