package com.oocl.parkingLot.service;

import com.oocl.parkingLot.model.ParkingLot;

import java.util.List;

public interface ParkingLotService {
    List<ParkingLot> findAllParkingLot();
    List<ParkingLot> addParkingLot(ParkingLot parkingLot);
}
