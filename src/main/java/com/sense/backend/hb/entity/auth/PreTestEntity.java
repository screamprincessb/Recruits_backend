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
@Table(name = "PRE_TEST")
public class PreTestEntity implements Serializable {

    @Id
    @Column(name = "PRE_TEST_ID")
    private Integer preTestId;

    @Column(name = "PRE_TEST_QUESTION")
    private String preTestQuestion;

    @Column(name = "PRE_TEST_CHOICE1")
    private String preTestChoice1;

    @Column(name = "PRE_TEST_CHOICE2")
    private String preTestChoice2;
    @Column(name = "PRE_TEST_CHOICE3")
    private String preTestChoice3;

    @Column(name = "PRE_TEST_CHOICE4")
    private String preTestChoice4;

    @Column(name = "PRE_TEST_CORRECT")
    private String preTestCorrect;

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

    @Column(name = "PRE_TEST_DELETE")
    private String preTestDelete;

    @Column(name = "APPLICATION_ID")
    private Integer applicationId;

}
