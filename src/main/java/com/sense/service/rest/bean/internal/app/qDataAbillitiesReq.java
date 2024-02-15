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
public class qDataAbillitiesReq implements Serializable {

    private qDataAbillitiesData data;

    @Data
    public class qDataAbillitiesData {

        private Integer abillitiesId;
        private Integer abillitiesToeicScore;
        private Integer abillitiesTofelScore;
        private String abillitiesComputerSkill;
        private String abillitiesOther;
        private String abillitiesHobby;
        private Integer applicationId;
        private String vehicleType;
        private String vehicleDrive;
        private String vehicleOwn;
        private String vehicleNo;
        private String languagesName;
        private String languagesSpeaking;
        private String languagesReading;
        private String languagesWriting;
        private String languagesTypewriter;
    };
}
