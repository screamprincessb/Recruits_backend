/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.bean.internal.app;

import lombok.Data;
import lombok.ToString;

/**
 *
 * @author SenseInfoTech
 */
@ToString
@Data
public class qLanguagesReq {
    private qLanguagesData data;

    @Data
    public class qLanguagesData {

        private Integer abillitiesId;
        private String vehicleType;
        private String vehicleDrive;
        private String vehicleOwn;
        private String vehicleNo;
     
    }
}
