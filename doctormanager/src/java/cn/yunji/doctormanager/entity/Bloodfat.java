package cn.yunji.doctormanager.entity;

import java.util.Date;

public class Bloodfat {
    private Integer bid;

    private String mid;

    private Integer checkprojectid;

    private Date bdate;

    private String chol;

    private String hdl;

    private String trig;

    private String ldl;

    private String hdlc;

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

    public String getChol() {
        return chol;
    }

    public void setChol(String chol) {
        this.chol = chol == null ? null : chol.trim();
    }

    public String getHdl() {
        return hdl;
    }

    public void setHdl(String hdl) {
        this.hdl = hdl == null ? null : hdl.trim();
    }

    public String getTrig() {
        return trig;
    }

    public void setTrig(String trig) {
        this.trig = trig == null ? null : trig.trim();
    }

    public String getLdl() {
        return ldl;
    }

    public void setLdl(String ldl) {
        this.ldl = ldl == null ? null : ldl.trim();
    }

    public String getHdlc() {
        return hdlc;
    }

    public void setHdlc(String hdlc) {
        this.hdlc = hdlc == null ? null : hdlc.trim();
    }
}