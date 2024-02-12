/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.entity.auth;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author SenseInfoTech
 */
@Data
@Entity
@Table(name = "POSITION_LINK_FORM")
public class PositionLinkFormEntity implements Serializable {
    
    @Id
    @Column(name = "POSITION_ID")
    private Integer positionId;

    @Column(name = "POSITION_NAME")
    private String positionName;

    @Column(name = "POSITION_LINK")
    private String positionLink;
    
}
