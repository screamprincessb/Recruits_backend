/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.dao.auth;

import com.sense.backend.hb.dao.BaseDAO;
import com.sense.backend.hb.entity.auth.TrainingEntity;

/**
 *
 * @author SenseInfoTech
 */
public class TrainingDAO extends BaseDAO <TrainingEntity, Integer> {
    
    public TrainingDAO() {
        super(TrainingEntity.class);
    }
    
}
