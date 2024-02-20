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
public class ContactPersonReq implements Serializable {

    private ContactPersonData data;

    @Data
    public class ContactPersonData {

        private String contactPersonId;
        private String cpFirstName;
        private String cpLastName;
        private String cpRelation;
        private String cpPhone;
        private String cpAddress;
        private String applicationId;
    }
}
