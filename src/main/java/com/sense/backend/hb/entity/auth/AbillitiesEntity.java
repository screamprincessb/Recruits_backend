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
@Table(name = "ABILLITIES")
public class AbillitiesEntity implements Serializable{
    
    @Id
    @Column(name = "ABILLITIES_ID")
    private int abillitiesId;
    
    @Column(name = "ABILLITIES_TOEIC_SCORE")
    private int abillitiesToeicScore;
    
    @Column(name = "ABiLLITIES_TOFEL_SCORE")
    private int abillitiesTofelScore;
    
    @Column(name = "ABILLITIES_COMPUTER_SKILL")
    private String abillitiesComputerSkill;
    
    @Column(name = "ABILLITIES_OTHER")
    private String abillitiesOther;
    
    @Column(name = "ABILLITIES_HOBBY")
    private String abillitiesHobby;
    
}
