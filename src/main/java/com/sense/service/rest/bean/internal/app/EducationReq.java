/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.bean.internal.app;

import jakarta.persistence.Column;
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
public class EducationReq implements Serializable {

    private EducationData data;

    @Data
    public class EducationData {

        private String educationId;
        private String educationLevel;
        private String educationName;
        private String educationQualification;
        private String educationMajor;
        private Date educationStartDT;
        private Date educationEndDT;
        private float educationGPA;
        private String applicationId;
    }

}
