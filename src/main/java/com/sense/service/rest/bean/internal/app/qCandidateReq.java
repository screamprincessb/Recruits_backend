/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.bean.internal.app;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author SenseInfoTech
 */
@ToString
@Data
public class qCandidateReq {

    private qCandidateData data;

    @Data
    public class qCandidateData {

        private String applicationId;
        private String canFirstNameTH;
        private String canLastNameTH;
        private String applicationStatus;
        private String positionId;
        private String positionName;
    }
}
