package com.sahil.models;


import javax.persistence.*;

@Entity
@Table(name = "TariffDetail")
public class AddTariffModel {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getBaseFeeRate() {
        return baseFeeRate;
    }

    public void setBaseFeeRate(String baseFeeRate) {
        this.baseFeeRate = baseFeeRate;
    }

    public String getFreeKilometerRate() {
        return freeKilometerRate;
    }

    public void setFreeKilometerRate(String freeKilometerRate) {
        this.freeKilometerRate = freeKilometerRate;
    }

    public String getFreeMinuteRate() {
        return freeMinuteRate;
    }

    public void setFreeMinuteRate(String freeMinuteRate) {
        this.freeMinuteRate = freeMinuteRate;
    }

    public String getRateKilometerRate() {
        return rateKilometerRate;
    }

    public void setRateKilometerRate(String rateKilometerRate) {
        this.rateKilometerRate = rateKilometerRate;
    }

    public String getTimeMinuteRate() {
        return timeMinuteRate;
    }

    public void setTimeMinuteRate(String timeMinuteRate) {
        this.timeMinuteRate = timeMinuteRate;
    }

    public String getIdealMinuteRate() {
        return idealMinuteRate;
    }

    public void setIdealMinuteRate(String idealMinuteRate) {
        this.idealMinuteRate = idealMinuteRate;
    }

    public String getExtraPlusMinuteRate() {
        return extraPlusMinuteRate;
    }

    public void setExtraPlusMinuteRate(String extraPlusMinuteRate) {
        this.extraPlusMinuteRate = extraPlusMinuteRate;
    }

    public String getTrafficMinuteRate() {
        return trafficMinuteRate;
    }

    public void setTrafficMinuteRate(String trafficMinuteRate) {
        this.trafficMinuteRate = trafficMinuteRate;
    }

    public boolean isBaseFee() {
        return baseFee;
    }

    public void setBaseFee(boolean baseFee) {
        this.baseFee = baseFee;
    }

    public boolean isFreeKilometer() {
        return freeKilometer;
    }

    public void setFreeKilometer(boolean freeKilometer) {
        this.freeKilometer = freeKilometer;
    }

    public boolean isFreeMinute() {
        return freeMinute;
    }

    public void setFreeMinute(boolean freeMinute) {
        this.freeMinute = freeMinute;
    }

    public boolean isRateKilometer() {
        return rateKilometer;
    }

    public void setRateKilometer(boolean rateKilometer) {
        this.rateKilometer = rateKilometer;
    }

    public boolean isTimeMinute() {
        return timeMinute;
    }

    public void setTimeMinute(boolean timeMinute) {
        this.timeMinute = timeMinute;
    }

    public boolean isIdealMinute() {
        return idealMinute;
    }

    public void setIdealMinute(boolean idealMinute) {
        this.idealMinute = idealMinute;
    }

    public boolean isExtraPlusMinute() {
        return extraPlusMinute;
    }

    public void setExtraPlusMinute(boolean extraPlusMinute) {
        this.extraPlusMinute = extraPlusMinute;
    }

    public boolean isTrafficMinute() {
        return trafficMinute;
    }

    public void setTrafficMinute(boolean trafficMinute) {
        this.trafficMinute = trafficMinute;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column(name = "carname")
    private String carName;

    @Column(name = "basefeerate")
    private String baseFeeRate;
    @Column(name = "freekilometerate")
    private String freeKilometerRate;
    @Column(name = "freeminuterate")
    private String freeMinuteRate;
    @Column(name = "ratekilometerate")
    private String rateKilometerRate;
    @Column(name = "timeminuterate")
    private String timeMinuteRate;
    @Column(name = "idealminuterate")
    private String idealMinuteRate;
    @Column(name = "extraplusminuterate")
    private String extraPlusMinuteRate;
    @Column(name = "trafficminuterate")
    private String trafficMinuteRate;
    @Column(name = "basefee")
    private boolean baseFee;
    @Column(name = "freekilomete")
    private boolean freeKilometer;
    @Column(name = "freeminute")
    private boolean freeMinute;
    @Column(name = "ratekilometer")
    private boolean rateKilometer;
    @Column(name = "timeminute")
    private boolean timeMinute;
    @Column(name = "idealminute")
    private boolean idealMinute;
    @Column(name = "extraplusminute")
    private boolean extraPlusMinute;
    @Column(name = "trafficminute")
    private boolean trafficMinute;


}
