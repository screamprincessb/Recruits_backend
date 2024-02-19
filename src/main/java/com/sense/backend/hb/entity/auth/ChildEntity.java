/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.entity.auth;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 *
 * @author SenseInfoTech
 */
@Data
@Entity
@Table(name = "CHILD")
public class ChildEntity implements Serializable {

    @Id
    @Column(name = "CHILD_ID")
    private String childId;

    @Column(name = "CHILD_NUMBER")
    private Integer childNumber;

    @Column(name = "CHILD_FIRST_NAME")
    private String childFirstName;

    @Column(name = "CHILD_LAST_NAME")
    private String childLastName;

    @Column(name = "CHILD_AGE")
    private Integer childAge;

    @Column(name = "CHILD_GENDER")
    private String childGender;

    @Column(name = "CHILD_EDUCATION_LEVEL")
    private String childEducationLevel;

    @Column(name = "APPLICATION_ID")
    private String applicationId   ;
}
