/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.entity.auth;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 *
 * @author SenseInfoTech
 */
@Data
@Entity
public class qVehicleEntityToJoin {
    @Id
    @Column(name = "ABILLITIES_ID")
    private Integer abillitiesId;
    
    @Column(name = "VEHICLE_TYPE")
    private String vehicleType;

    @Column(name = "VEHICLE_DRIVE")
    private String vehicleDrive;

    @Column(name = "VEHICLE_OWN")
    private String vehicleOwn;

    @Column(name = "VEHICLE_NO")
    private String vehicleNo;
    
   
}
