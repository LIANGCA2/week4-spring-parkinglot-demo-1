package com.oocl.parkingLot.service;

import com.oocl.parkingLot.model.Order;
import com.oocl.parkingLot.model.ParkingBoy;
import com.oocl.parkingLot.model.ParkingLot;
import com.oocl.parkingLot.model.Receipt;

import java.util.List;

public interface ParkingLotManageService {



    ParkingLot giveParkingLotToParkingBoy(Integer parkingBoyId, ParkingLot parkingLot) throws Exception;





}
