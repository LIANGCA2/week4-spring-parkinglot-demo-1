package com.oocl.parkingLot.controller;


import com.oocl.parkingLot.model.Order;
import com.oocl.parkingLot.model.ParkingBoy;
import com.oocl.parkingLot.model.ParkingLot;
import com.oocl.parkingLot.model.Receipt;
import com.oocl.parkingLot.service.ParkingLotManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkinglotManageController {

    @Autowired
    private  ParkingLotManageService parkingLotManageService;

    @PostMapping("parkingBoys/{parkingBoyId}/parkingLots")
    public ParkingLot updateParkingLot(@PathVariable Integer parkingBoyId, @RequestBody ParkingLot parkingLot){
        try {
            return parkingLotManageService.giveParkingLotToParkingBoy(parkingBoyId,parkingLot);
        }catch (Exception e){
            System.out.println("fail to update");
            return null;
        }

    }




}
