package cn.yunji.doctormanager.entity;

import java.util.Date;

public class Bloodoxygen {
    private Integer bid;

    private String mid;

    private Date bdate;

    private String bloodoxygen;

    private String heartrate;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public String getBloodoxygen() {
        return bloodoxygen;
    }

    public void setBloodoxygen(String bloodoxygen) {
        this.bloodoxygen = bloodoxygen == null ? null : bloodoxygen.trim();
    }

    public String getHeartrate() {
        return heartrate;
    }

    public void setHeartrate(String heartrate) {
        this.heartrate = heartrate == null ? null : heartrate.trim();
    }
}