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
@Table(name = "CHILD")
public class ChildEntity implements Serializable{
    
    @Id
    @Column(name = "CHILD_ID")
    private int childId;
    
    @Column(name = "CHILD_NUMBER")
    private int childNumber;
    
    @Column(name = "CHILD_FIRST_NAME")
    private String childFirstName;
    
    @Column(name = "CHILD_LAST_NAME")
    private String childLasrName;
    
    @Column(name = "CHILD_AGE")
    private int childAge;
    
    @Column(name = "CHILD_GENDER")
    private String childGender;
    
    @Column(name = "CHILD_EDUCATION_LEVEL")
    private String childEducationLevel;
}
