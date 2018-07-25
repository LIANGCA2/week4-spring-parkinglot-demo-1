package com.oocl.parkingLot.controller;

import com.oocl.parkingLot.model.ParkingBoy;
import com.oocl.parkingLot.service.ParkingBoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParkingBoyController {
    @Autowired
    private ParkingBoyService parkingBoyService;
    @GetMapping("parkingBoys")
    public List<ParkingBoy> getAllParkingBoy(){
        return parkingBoyService.findAllParkingBoy();
    }

    @PostMapping("parkingBoys")
    public List<ParkingBoy> addParking(@RequestBody ParkingBoy parkingBoy){
        return parkingBoyService.addParkingBoy(parkingBoy);
    }
}
