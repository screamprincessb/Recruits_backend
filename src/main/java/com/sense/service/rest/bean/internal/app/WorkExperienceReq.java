/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.bean.internal.app;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author SenseInfoTech
 */
@ToString
@Data
public class WorkExperienceReq implements Serializable {

    private WorkExperienceData data;

    @Data
    public class WorkExperienceData {

        private Integer workExperienceId;
//        private Date weStartDT;
//        private Date weEndDT;
        private String weBusinessType;
        private String weName;
        private String wePosition;
        private String weMajor;
        private float weSalary;
        private String weAddressPhone;
        private String weDescription;
        private String weReasonLeaving;
    }
}
