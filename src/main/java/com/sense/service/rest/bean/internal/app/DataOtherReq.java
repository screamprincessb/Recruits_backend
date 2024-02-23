/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.bean.internal.app;

import jakarta.persistence.Column;
import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author SenseInfoTech
 */
@ToString
@Data
public class DataOtherReq implements Serializable {

    private DataOtherData data;

    @Data
    public class DataOtherData {

        private String doId;
        private String doQuestion;
        private String doANS;
        private String applicationId;
    }
}
