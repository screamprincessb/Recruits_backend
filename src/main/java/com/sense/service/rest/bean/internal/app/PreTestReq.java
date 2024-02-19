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
public class PreTestReq implements Serializable {

    private PreTestData data;

    @Data
    public class PreTestData {

        private String preTestId;
        private Integer preTestNumber;
        private String preTestQuestion;
        private String preTestChoice1;
        private String preTestChoice2;
        private String preTestChoice3;
        private String preTestChoice4;
        private String preTestCorrect;
//    private Date preTestCreateDT;
        private String preTestCreateBy;
//    private Date preTestUpdateDT;
        private String preTestupdateBy;
        private String preTestDelete;
    }
}
