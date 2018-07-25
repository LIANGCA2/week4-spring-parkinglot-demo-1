package com.oocl.parkingLot.controller;


import com.oocl.parkingLot.model.ParkingBoy;
import com.oocl.parkingLot.model.ParkingLot;
import com.oocl.parkingLot.service.ParkingLotManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParkinglotManageController {

    @Autowired
    private  ParkingLotManageService parkingLotManageService;


    @GetMapping("parkinglots")
    public List<ParkingLot> getAllParkingLot(){
        return parkingLotManageService.findAllParkingLot();
    }


    @GetMapping("parkingBoys")
    public List<ParkingBoy> getAllParkingBoy(){
        return parkingLotManageService.findAllParkingBoy();
    }

}
