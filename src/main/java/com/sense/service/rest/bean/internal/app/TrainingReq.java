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
public class TrainingReq implements Serializable {

    private TrainingData data;

    @Data
    public class TrainingData {

        private String trainingId;
//    private Date trainingDate;
        private String trainingCourse;
        private String trainingInstitution;
        private String trainingQualification;
        private String trainingTime;
    }
}
