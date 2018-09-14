package cn.yunji.doctormanager.entity;

import java.util.Date;

public class Bloodsugre {
    private Integer wid;

    private String mid;

    private Integer checkprojectid;

    private Date wdate;

    private String bbreakfast;

    private String afbre;

    private String bflun;

    private String aflun;

    private String bfdin;

    private String afdin;

    private String bfsle;

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
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

    public Date getWdate() {
        return wdate;
    }

    public void setWdate(Date wdate) {
        this.wdate = wdate;
    }

    public String getBbreakfast() {
        return bbreakfast;
    }

    public void setBbreakfast(String bbreakfast) {
        this.bbreakfast = bbreakfast == null ? null : bbreakfast.trim();
    }

    public String getAfbre() {
        return afbre;
    }

    public void setAfbre(String afbre) {
        this.afbre = afbre == null ? null : afbre.trim();
    }

    public String getBflun() {
        return bflun;
    }

    public void setBflun(String bflun) {
        this.bflun = bflun == null ? null : bflun.trim();
    }

    public String getAflun() {
        return aflun;
    }

    public void setAflun(String aflun) {
        this.aflun = aflun == null ? null : aflun.trim();
    }

    public String getBfdin() {
        return bfdin;
    }

    public void setBfdin(String bfdin) {
        this.bfdin = bfdin == null ? null : bfdin.trim();
    }

    public String getAfdin() {
        return afdin;
    }

    public void setAfdin(String afdin) {
        this.afdin = afdin == null ? null : afdin.trim();
    }

    public String getBfsle() {
        return bfsle;
    }

    public void setBfsle(String bfsle) {
        this.bfsle = bfsle == null ? null : bfsle.trim();
    }
}