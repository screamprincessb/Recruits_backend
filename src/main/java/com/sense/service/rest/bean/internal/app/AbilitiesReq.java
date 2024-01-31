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
public class AbilitiesReq implements Serializable {

    private AbilitiesData data;

    @Data
    public class AbilitiesData {

        private Integer abillitiesId;
        private Integer abillitiesToeicScore;
        private Integer abillitiesTofelScore;
        private String abillitiesComputerSkill;
        private String abillitiesOther;
        private String abillitiesHobby;

    }
}
