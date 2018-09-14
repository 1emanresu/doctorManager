package cn.yunji.doctormanager.entity;

import java.math.BigDecimal;

public class HighRiskRtandard {
    private Integer highriskstandardid;

    private String hospitalid;

    private Integer cid;

    private String highriskname;

    private BigDecimal cbegin;

    private Integer highriskscore;

    public Integer getHighriskstandardid() {
        return highriskstandardid;
    }

    public void setHighriskstandardid(Integer highriskstandardid) {
        this.highriskstandardid = highriskstandardid;
    }

    public String getHospitalid() {
        return hospitalid;
    }

    public void setHospitalid(String hospitalid) {
        this.hospitalid = hospitalid == null ? null : hospitalid.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getHighriskname() {
        return highriskname;
    }

    public void setHighriskname(String highriskname) {
        this.highriskname = highriskname == null ? null : highriskname.trim();
    }

    public BigDecimal getCbegin() {
        return cbegin;
    }

    public void setCbegin(BigDecimal cbegin) {
        this.cbegin = cbegin;
    }

    public Integer getHighriskscore() {
        return highriskscore;
    }

    public void setHighriskscore(Integer highriskscore) {
        this.highriskscore = highriskscore;
    }
}