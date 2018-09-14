package cn.yunji.doctormanager.entity;

import java.util.Date;

public class MyEcg {
    private Integer myecg;

    private String mid;

    private Integer checkprojectid;

    private Date bdate;

    private String hearrate;

    private String qtinterval;

    private String pdispersion;

    private String qtcinterval;

    private String qdispersion;

    private String qrsduration;

    private String stsegment;

    private String rwaveamplitude;

    public Integer getMyecg() {
        return myecg;
    }

    public void setMyecg(Integer myecg) {
        this.myecg = myecg;
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

    public String getHearrate() {
        return hearrate;
    }

    public void setHearrate(String hearrate) {
        this.hearrate = hearrate == null ? null : hearrate.trim();
    }

    public String getQtinterval() {
        return qtinterval;
    }

    public void setQtinterval(String qtinterval) {
        this.qtinterval = qtinterval == null ? null : qtinterval.trim();
    }

    public String getPdispersion() {
        return pdispersion;
    }

    public void setPdispersion(String pdispersion) {
        this.pdispersion = pdispersion == null ? null : pdispersion.trim();
    }

    public String getQtcinterval() {
        return qtcinterval;
    }

    public void setQtcinterval(String qtcinterval) {
        this.qtcinterval = qtcinterval == null ? null : qtcinterval.trim();
    }

    public String getQdispersion() {
        return qdispersion;
    }

    public void setQdispersion(String qdispersion) {
        this.qdispersion = qdispersion == null ? null : qdispersion.trim();
    }

    public String getQrsduration() {
        return qrsduration;
    }

    public void setQrsduration(String qrsduration) {
        this.qrsduration = qrsduration == null ? null : qrsduration.trim();
    }

    public String getStsegment() {
        return stsegment;
    }

    public void setStsegment(String stsegment) {
        this.stsegment = stsegment == null ? null : stsegment.trim();
    }

    public String getRwaveamplitude() {
        return rwaveamplitude;
    }

    public void setRwaveamplitude(String rwaveamplitude) {
        this.rwaveamplitude = rwaveamplitude == null ? null : rwaveamplitude.trim();
    }
}