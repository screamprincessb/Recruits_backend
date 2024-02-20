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
public class ChildReq implements Serializable {

    private ChildData data;

    @Data
    public class ChildData {

        private String childId;
        private Integer childNumber;
        private String childFirstName;
        private String childLastName;
        private Integer childAge;
        private String childGender;
        private String childEducationLevel;
        private String applicationId;

    }
}
