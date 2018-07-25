package com.oocl.parkingLot.serviceImpl;

import com.oocl.parkingLot.ParkingLotApplication;
import com.oocl.parkingLot.Util.GenerateUtil;
import com.oocl.parkingLot.model.Order;
import com.oocl.parkingLot.model.ParkingBoy;
import com.oocl.parkingLot.model.ParkingLot;
import com.oocl.parkingLot.model.Receipt;
import com.oocl.parkingLot.service.ParkingBoyService;
import com.oocl.parkingLot.service.ParkingLotManageService;
import com.oocl.parkingLot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.rmi.CORBA.Util;
import java.util.List;

@Service("parkingLotManageService")
public class ParkingLotManageServiceImpl implements ParkingLotManageService {
    @Autowired
    private ParkingLotService parkingLotService;
    @Autowired
    private ParkingBoyService parkingBoyService;


    @Override
    public ParkingLot giveParkingLotToParkingBoy(Integer parkingBoyId, ParkingLot parkingLot) throws Exception {
        List<ParkingLot> parkingLotList= parkingLotService.findAllParkingLot();
        for(int i =0;i<parkingLotList.size();i++){
           if(parkingLotList.get(i).getId()==parkingLot.getId()){
               parkingLotList.get(i).setParkingBoyId(parkingBoyId);
               return parkingLotList.get(i);
           }
       }
        throw new Exception("该停车场不存在");
    }


}
