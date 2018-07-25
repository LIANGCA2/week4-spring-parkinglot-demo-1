package com.oocl.parkingLot.service;

import com.oocl.parkingLot.model.Order;
import com.oocl.parkingLot.model.ParkingBoy;
import com.oocl.parkingLot.model.ParkingLot;
import com.oocl.parkingLot.model.Receipt;

import java.util.List;

public interface ParkingLotManageService {
    List<ParkingLot> findAllParkingLot();

    List<ParkingBoy> findAllParkingBoy();

    ParkingLot giveParkingLotToParkingBoy(Integer parkingBoyId, ParkingLot parkingLot);

    List<ParkingLot> addParkingLot(ParkingLot parkingLot);

    List<ParkingBoy> addParkingBoy(ParkingBoy parkingBoy);

    Receipt getReceipt();

    Order addOrder(Order order);
}
