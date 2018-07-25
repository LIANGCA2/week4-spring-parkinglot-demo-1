package com.oocl.parkingLot.serviceImpl;

import com.oocl.parkingLot.ParkingLotApplication;
import com.oocl.parkingLot.model.ParkingBoy;
import com.oocl.parkingLot.model.ParkingLot;
import com.oocl.parkingLot.service.ParkingLotService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public ParkingLot findNotFullParkingLot(ParkingBoy parkingBoy) throws Exception {
        List<ParkingLot> parkingLots = findAllParkingLot().stream().filter(item -> item.getParkingBoyId() == parkingBoy.getId() && item.getRemainSize() > 0).limit(1).collect(Collectors.toList());
        if(parkingLots.size()>0){
            return parkingLots.get(0);
        }else{
            throw new Exception("没有空余的车位");
        }
    }

    @Override
    public void ReduceParkingLotRemainSize(ParkingLot parkingLot) {
        List<ParkingLot> allParkingLot = findAllParkingLot();
        for(int i =0;i<allParkingLot.size();i++){
            if(allParkingLot.get(i).getId()==parkingLot.getId()){
                allParkingLot.get(i).setRemainSize(allParkingLot.get(i).getRemainSize()-1);
            }
        }
    }

    @Override
    public void unpark(Integer parkingLotId) {
        for(int i = 0;i<parkingLotList.size();i++){
            if(parkingLotList.get(i).getParkingBoyId()==parkingLotId){
                parkingLotList.get(i).setRemainSize(parkingLotList.get(i).getRemainSize()+1);
            }
        }
    }
}
