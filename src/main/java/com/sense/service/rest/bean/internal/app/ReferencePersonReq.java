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
public class ReferencePersonReq implements Serializable {

    private ReferencePersonData data;

    @Data
    public class ReferencePersonData {

        private String refPersonId;
        private String refFirstName;
        private String refLastName;
        private String refJobPosition;
        private String refWorkLocation;
        private String refPhone;
        private String workExperienceId;
    }
}
