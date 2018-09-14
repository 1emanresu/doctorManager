package cn.yunji.doctormanager.entity;

import java.util.Date;

public class Temperature {
    private Integer tid;

    private String mid;

    private Integer checkprojectid;

    private Date tdate;

    private String temperature;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
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

    public Date getTdate() {
        return tdate;
    }

    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature == null ? null : temperature.trim();
    }
}