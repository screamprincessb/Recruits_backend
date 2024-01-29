/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.dao.auth;

import com.sense.backend.hb.dao.BaseDAO;
import com.sense.backend.hb.entity.auth.ContactPersonEntity;

/**
 *
 * @author SenseInfoTech
 */
public class ContactPersonDAO extends BaseDAO <ContactPersonEntity, Integer> {
    
    public ContactPersonDAO() {
        super(ContactPersonEntity.class);
    }
    
}
