package cn.yunji.doctormanager.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Bloodpressure {
    private Integer bid;

    private String mid;

    private Integer checkprojectid;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date bdate;

    private String systolic;

    private String diastolic;

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

    public Integer getCheckprojectid() {
        return checkprojectid;
    }

    public void setCheckprojectid(Integer checkprojectid) {
        this.checkprojectid = checkprojectid;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public String getSystolic() {
        return systolic;
    }

    public void setSystolic(String systolic) {
        this.systolic = systolic == null ? null : systolic.trim();
    }

    public String getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(String diastolic) {
        this.diastolic = diastolic == null ? null : diastolic.trim();
    }

    public String getHeartrate() {
        return heartrate;
    }

    public void setHeartrate(String heartrate) {
        this.heartrate = heartrate == null ? null : heartrate.trim();
    }
}