/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.bean.internal.app;

import com.sense.backend.hb.entity.auth.PositionLinkFormEntity;
import com.sense.service.base.BaseResp;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author SenseInfoTech
 */
@ToString
@Data
public class PositionLinkFormReq implements Serializable {
    private PositionLinkFormData data;
    
    @Data
    public class PositionLinkFormData {
        private String positionId;
        private String positionName;
        private String positionLink;
    }
}
