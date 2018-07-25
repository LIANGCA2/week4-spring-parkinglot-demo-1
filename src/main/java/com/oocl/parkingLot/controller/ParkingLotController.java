package com.oocl.parkingLot.controller;

import com.oocl.parkingLot.model.ParkingLot;
import com.oocl.parkingLot.service.ParkingLotManageService;
import com.oocl.parkingLot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParkingLotController {

    @Autowired
    private ParkingLotService parkingLotService;
    @GetMapping("parkinglots")
    public List<ParkingLot> getAllParkingLot(){
        return parkingLotService.findAllParkingLot();
    }

    @PostMapping("parkinglots")
    public List<ParkingLot> addParkingLot(@RequestBody ParkingLot parkingLot){
        return parkingLotService.addParkingLot(parkingLot);
    }
}
