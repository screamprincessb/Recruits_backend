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
@Table(name = "LANGUAGES")
public class LanguagesEntity implements Serializable {
    
    @Id
    @Column(name = "LANGUAGES_ID")
    private String languagesId;
    
    @Column(name = "LANGUAGES_NAME")
    private String languagesName;
    
    @Column(name = "LANGUAGES_SPEAKING")
    private char languagesSpeaking;
    
    @Column(name = "LANGUAGES_READING")
    private char languagesReading;
    
    @Column(name = "LANGUAGES_WRITING")
    private char languagesWriting;
    
    @Column(name = "LANGUAGES_TYPEWRITER")
    private String languagesTypewriter;
    
}
