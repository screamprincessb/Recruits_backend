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
public class qDataAbillitiesEntityToJoin {
    @Id
    @Column(name = "ABILLITIES_ID")
    private Integer abillitiesId;

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
    private Integer applicationId;
    
    @Column(name = "VEHICLE_TYPE")
    private String vehicleType;

    @Column(name = "VEHICLE_DRIVE")
    private String vehicleDrive;

    @Column(name = "VEHICLE_OWN")
    private String vehicleOwn;

    @Column(name = "VEHICLE_NO")
    private String vehicleNo;
    
    @Column(name = "LANGUAGES_NAME")
    private String languagesName;
    
    @Column(name = "LANGUAGES_SPEAKING")
    private String languagesSpeaking;
    
    @Column(name = "LANGUAGES_READING")
    private String languagesReading;
    
    @Column(name = "LANGUAGES_WRITING")
    private String languagesWriting;
    
    @Column(name = "LANGUAGES_TYPEWRITER")
    private String languagesTypewriter;
}
