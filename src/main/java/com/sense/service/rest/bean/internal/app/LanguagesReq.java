/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.bean.internal.app;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author SenseInfoTech
 */
@ToString
@Data
public class LanguagesReq implements Serializable {

    private LanguagesData data;

    @Data
    public class LanguagesData {

        private String languagesId;
        private String languagesName;
        private String languagesSpeaking;
        private String languagesReading;
        private String languagesWriting;
        private String languagesTypewriter;
        private String abillitiesId;

    }
}
