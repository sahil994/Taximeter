package com.sahil.models;


import javax.persistence.*;

@Entity
@Table(name = "SaveHistory")
public class SaveTariffHistoryModel {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public int id;

    @Column(name="userid")
    public int userid;
    @Column(name = "tariffstarttime")
    public String starttime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(String distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public String getTripPrice() {
        return tripPrice;
    }

    public void setTripPrice(String tripPrice) {
        this.tripPrice = tripPrice;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Column(name = "tariffendtime")
    public String endTime;
    @Column(name = "tariffdistance")
    public String distanceTravelled;
    @Column(name = "tariffPrice")
    public String tripPrice;
    @Column(name = "tarifftotaltime")
    public String totalTime;
    @Column(name = "tariffstartdate")
    public String  startDate;


}
