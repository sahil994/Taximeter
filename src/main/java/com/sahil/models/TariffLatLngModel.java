package com.sahil.models;


import javax.persistence.*;

@Entity
@Table(name = "TariffPostition")
public class TariffLatLngModel {


    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public int id;
*/
    @Id
    @Column(name="userid")
    public int userid;
    @Column(name = "latitude")
    public String latitude;
    @Column(name = "longitude")
    public String longitude;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
