/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.entity.auth;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author SenseInfoTech
 */
@Data
@Entity
@Table(name = "APPLICATION")
public class ContactPersonEntity implements Serializable{
    
    @Id
    @Column(name = "CONTACT_PERSON_ID")
    private int contactPersonId;
    
    @Column(name = "CP_FIRST_NAME")
    private String cpFirstName;
    
    @Column
}
