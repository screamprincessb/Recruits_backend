/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.dao.auth;

import com.sense.backend.hb.dao.BaseDAO;
import com.sense.backend.hb.entity.auth.HREntity;
import com.sense.backend.hb.entity.auth.PositionLinkFormEntity;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SenseInfoTech
 */
@Repository
public class PositionLinkFormDAO extends BaseDAO<PositionLinkFormEntity, String> {
    
        public PositionLinkFormDAO(){
        super(PositionLinkFormEntity.class);
    }
}
