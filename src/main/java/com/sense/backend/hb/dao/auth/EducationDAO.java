/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.dao.auth;

import com.sense.backend.hb.dao.BaseDAO;
import com.sense.backend.hb.entity.auth.DataOtherEntity;
import com.sense.backend.hb.entity.auth.EducationEntity;

/**
 *
 * @author SenseInfoTech
 */
public class EducationDAO extends BaseDAO <EducationEntity, Integer> {
    
    public EducationDAO() {
            super(EducationEntity.class);
        }
    
}
