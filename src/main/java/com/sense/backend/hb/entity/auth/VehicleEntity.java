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
@Table(name = "VEHICLE")
public class VehicleEntity implements Serializable{
    
    @Id
    @Column(name = "VEHICLE_ID")
    private Integer vehicleId;
    
    @Column(name = "VEHICLE_TYPE")
    private String vehicleType;
    
    @Column(name = "VEHICLE_DRIVE")
    private String vehicleDrive;
    
    @Column(name = "VEHICLE_OWN")
    private String vehicleOwn;
    
    @Column(name = "VEHICLE_NO")
    private String vehicleNo;
    
    
    
    
}
