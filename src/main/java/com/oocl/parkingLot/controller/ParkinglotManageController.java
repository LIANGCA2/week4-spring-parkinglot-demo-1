package com.oocl.parkingLot.controller;


import com.oocl.parkingLot.model.ParkingBoy;
import com.oocl.parkingLot.model.ParkingLot;
import com.oocl.parkingLot.service.ParkingLotManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkinglotManageController {

    @Autowired
    private  ParkingLotManageService parkingLotManageService;


    @GetMapping("parkinglots")
    public List<ParkingLot> getAllParkingLot(){
        return parkingLotManageService.findAllParkingLot();
    }

    @PostMapping("parkinglots")
    public List<ParkingLot> addParkingLot(@RequestBody ParkingLot parkingLot){
        return parkingLotManageService.addParkingLot(parkingLot);
    }


    @GetMapping("parkingBoys")
    public List<ParkingBoy> getAllParkingBoy(){
        return parkingLotManageService.findAllParkingBoy();
    }

    @PostMapping("parkingBoys/{parkingBoyId}/parkingLots")
    public ParkingLot updateParkingLot(@PathVariable Integer parkingBoyId, ParkingLot parkingLot){
        try {
            return parkingLotManageService.giveParkingLotToParkingBoy(parkingBoyId,parkingLot);
        }catch (Exception e){
            System.out.println("fail to update");
            return null;
        }

    }

}
