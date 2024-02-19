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
@Table(name = "ABILLITIES")
public class AbillitiesEntity implements Serializable {

    @Id
    @Column(name = "ABILLITIES_ID")
    private String abillitiesId;

    @Column(name = "ABILLITIES_TOEIC_SCORE")
    private Integer abillitiesToeicScore;

    @Column(name = "ABiLLITIES_TOFEL_SCORE")
    private Integer abillitiesTofelScore;

    @Column(name = "ABILLITIES_COMPUTER_SKILL")
    private String abillitiesComputerSkill;

    @Column(name = "ABILLITIES_OTHER")
    private String abillitiesOther;

    @Column(name = "ABILLITIES_HOBBY")
    private String abillitiesHobby;

    @Column(name = "APPLICATION_ID")
    private String applicationId;

}
