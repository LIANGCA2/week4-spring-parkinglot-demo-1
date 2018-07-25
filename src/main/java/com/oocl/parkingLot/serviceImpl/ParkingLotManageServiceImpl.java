package com.oocl.parkingLot.serviceImpl;

import com.oocl.parkingLot.ParkingLotApplication;
import com.oocl.parkingLot.model.ParkingBoy;
import com.oocl.parkingLot.model.ParkingLot;
import com.oocl.parkingLot.service.ParkingLotManageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("parkingLotManageService")
public class ParkingLotManageServiceImpl implements ParkingLotManageService {
    private List<ParkingLot> parkingLotList = ParkingLotApplication.allParkingLot();
    private List<ParkingBoy> parkingBoyList = ParkingLotApplication.allParkingBoy();
    @Override
    public List<ParkingLot> findAllParkingLot() {
        return parkingLotList;
    }

    @Override
    public List<ParkingBoy> findAllParkingBoy() {
        return parkingBoyList;
    }

    @Override
    public ParkingLot giveParkingLotToParkingBoy(Integer parkingBoyId, ParkingLot parkingLot) {
       parkingLot.setParkingBoyId(parkingBoyId);
       parkingLotList.add(parkingLot);
        return null;
    }

    @Override
    public List<ParkingLot> addParkingLot(ParkingLot parkingLot) {
        parkingLotList.add(parkingLot);
        return parkingLotList;
    }
}
