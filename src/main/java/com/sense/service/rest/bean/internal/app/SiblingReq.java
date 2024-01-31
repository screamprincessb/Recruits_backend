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
public class SiblingReq implements Serializable {

    private SiblingData data;

    @Data
    public class SiblingData {

        private Integer siblingId;
        private Integer siblingNumber;
        private Integer siblingYouAre;
        private String siblingFirstName;
        private String siblingLastName;
        private Integer siblingAge;
        private String siblingOccupation;
        private String siblingWorkLocation;
    }
    
}
