/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.dao.auth;

import com.sense.backend.hb.dao.BaseDAO;
import com.sense.backend.hb.entity.auth.ChildEntity;
import com.sense.backend.hb.entity.auth.DataOtherEntity;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SenseInfoTech
 */
@Repository
public class DataOtherDAO extends BaseDAO<DataOtherEntity, String > {
        
        public DataOtherDAO() {
            super(DataOtherEntity.class);
        }
       
}
