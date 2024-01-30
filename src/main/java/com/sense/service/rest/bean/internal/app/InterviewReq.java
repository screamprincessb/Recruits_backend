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
public class InterviewReq implements Serializable {
     private InterviewData data;
    
    @Data
    public class InterviewData {
        private int interviewId;
//        private Date interviewDT;
//        private Date interviewTime;
        private String interviewResult;
        private String interviewNote;
        private String interviewStatus;
    }
    
}
