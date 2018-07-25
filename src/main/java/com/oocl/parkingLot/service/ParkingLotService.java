package com.oocl.parkingLot.service;

import com.oocl.parkingLot.model.ParkingBoy;
import com.oocl.parkingLot.model.ParkingLot;

import java.util.List;

public interface ParkingLotService {
    List<ParkingLot> findAllParkingLot();
    List<ParkingLot> addParkingLot(ParkingLot parkingLot);

    ParkingLot findNotFullParkingLot(ParkingBoy parkingBoy) throws Exception;

    void ReduceParkingLotRemainSize(ParkingLot parkingLot);

    void unpark(Integer parkingLotId);
}
