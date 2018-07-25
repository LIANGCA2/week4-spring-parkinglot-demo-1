package com.oocl.parkingLot.model;

public class ParkingLot {
    private Integer id;
    private Integer parkingBoyId;
    private Integer size;

    public ParkingLot(Integer id, Integer parkingBoyId, Integer size) {
        this.id = id;
        this.parkingBoyId = parkingBoyId;
        this.size = size;
        this.remainSize = size;
    }

    public Integer getRemainSize() {
        return remainSize;
    }

    public void setRemainSize(Integer remainSize) {
        this.remainSize = remainSize;
    }

    private Integer remainSize;



    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public ParkingLot() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParkingBoyId() {
        return parkingBoyId;
    }

    public void setParkingBoyId(Integer parkingBoyId) {
        this.parkingBoyId = parkingBoyId;
    }


}
