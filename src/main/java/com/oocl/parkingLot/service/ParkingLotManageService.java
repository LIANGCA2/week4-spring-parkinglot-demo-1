package com.oocl.parkingLot.service;

import com.oocl.parkingLot.model.ParkingBoy;
import com.oocl.parkingLot.model.ParkingLot;

import java.util.List;

public interface ParkingLotManageService {
    List<ParkingLot> findAllParkingLot();

    List<ParkingBoy> findAllParkingBoy();
}
