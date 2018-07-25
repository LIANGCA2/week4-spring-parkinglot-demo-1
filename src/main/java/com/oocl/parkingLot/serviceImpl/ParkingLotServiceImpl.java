package com.oocl.parkingLot.serviceImpl;

import com.oocl.parkingLot.ParkingLotApplication;
import com.oocl.parkingLot.model.ParkingLot;
import com.oocl.parkingLot.service.ParkingLotService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("parkingLotService")
public class ParkingLotServiceImpl implements ParkingLotService {
    private List<ParkingLot> parkingLotList = ParkingLotApplication.allParkingLot();
    @Override
    public List<ParkingLot> findAllParkingLot() {
        return parkingLotList;
    }
    @Override
    public List<ParkingLot> addParkingLot(ParkingLot parkingLot) {
        parkingLotList.add(parkingLot);
        return parkingLotList;
    }
}
