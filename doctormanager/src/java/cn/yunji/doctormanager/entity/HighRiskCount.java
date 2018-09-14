package cn.yunji.doctormanager.entity;

import java.math.BigDecimal;

public class HighRiskCount {
    private Integer highriskcountid;

    private Integer cid;

    private String highriskname;

    private BigDecimal cbegin;

    private Integer highriskscore;

    public Integer getHighriskcountid() {
        return highriskcountid;
    }

    public void setHighriskcountid(Integer highriskcountid) {
        this.highriskcountid = highriskcountid;
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