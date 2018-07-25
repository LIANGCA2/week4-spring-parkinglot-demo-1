package com.oocl.parkingLot.serviceImpl;

import com.oocl.parkingLot.model.ParkingLot;
import com.oocl.parkingLot.service.ParkingLotManageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("parkingLotManageService")
public class ParkingLotManageServiceImpl implements ParkingLotManageService {
    @Override
    public List<ParkingLot> findAllParkingLot() {
        return null;
    }
}
