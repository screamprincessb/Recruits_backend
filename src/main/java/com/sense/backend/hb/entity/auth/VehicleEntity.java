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
    private int vehicleId;
    
    @Column(name = "VEHICLE_TYPE")
    private char vehicleType;
    
    @Column(name = "VEHICLE_DRIVE")
    private String vehicleDrive;
    
    @Column(name = "VEHICLE_OWN")
    private char vehicleOwn;
    
    @Column(name = "VEHICLE_NO")
    private String vehicleNo;
    
    
    
    
}
