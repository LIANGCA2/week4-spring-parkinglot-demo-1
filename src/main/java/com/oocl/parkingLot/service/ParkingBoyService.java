package com.oocl.parkingLot.service;

import com.oocl.parkingLot.model.ParkingBoy;

import java.util.List;

public interface ParkingBoyService  {
    List<ParkingBoy> findAllParkingBoy();
    List<ParkingBoy> addParkingBoy(ParkingBoy parkingBoy);
}
