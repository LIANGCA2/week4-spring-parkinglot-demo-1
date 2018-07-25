package com.oocl.parkingLot.serviceImpl;

import com.oocl.parkingLot.ParkingLotApplication;
import com.oocl.parkingLot.model.ParkingBoy;
import com.oocl.parkingLot.service.ParkingBoyService;
import com.oocl.parkingLot.service.ParkingLotService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("parkingBoyService")
public class ParkingBoyServiceImpl implements ParkingBoyService {
    private List<ParkingBoy> parkingBoyList = ParkingLotApplication.allParkingBoy();
    @Override
    public List<ParkingBoy> findAllParkingBoy() {
        return parkingBoyList;
    }
    @Override
    public List<ParkingBoy> addParkingBoy(ParkingBoy parkingBoy) {
        parkingBoyList.add(parkingBoy);
        return parkingBoyList;
    }
}
