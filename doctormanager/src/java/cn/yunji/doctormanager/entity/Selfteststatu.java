package cn.yunji.doctormanager.entity;

import java.math.BigDecimal;

public class Selfteststatu {
    private Integer id;

    private Integer cid;

    private Integer week;

    private BigDecimal bmitop;

    private BigDecimal bmibottom;

    private BigDecimal cbegin;

    private BigDecimal cend;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public BigDecimal getBmitop() {
        return bmitop;
    }

    public void setBmitop(BigDecimal bmitop) {
        this.bmitop = bmitop;
    }

    public BigDecimal getBmibottom() {
        return bmibottom;
    }

    public void setBmibottom(BigDecimal bmibottom) {
        this.bmibottom = bmibottom;
    }

    public BigDecimal getCbegin() {
        return cbegin;
    }

    public void setCbegin(BigDecimal cbegin) {
        this.cbegin = cbegin;
    }

    public BigDecimal getCend() {
        return cend;
    }

    public void setCend(BigDecimal cend) {
        this.cend = cend;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}