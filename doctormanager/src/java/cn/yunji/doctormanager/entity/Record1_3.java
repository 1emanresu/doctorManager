package cn.yunji.doctormanager.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Record1_3 {
    private Integer rid13;

    private String mid;

    private Integer weeks;

    private Integer colporrhagia;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date colporrhagiadate;

    private String colporrhagiacon;

    private Integer bellyache;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date bellyachedate;

    private String bellyachecon;

    private Integer fever;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date feverdate;

    private String fevercon;

    private Integer emesis;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date emesisdate;

    private String emesisnoeatcon;

    private Integer havahighrisk;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date havahighriskdate;

    private String havahighriskcon;
    
    private Date recorddate;

    public Integer getRid13() {
        return rid13;
    }

    public void setRid13(Integer rid13) {
        this.rid13 = rid13;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Integer getWeeks() {
        return weeks;
    }

    public void setWeeks(Integer weeks) {
        this.weeks = weeks;
    }

    public Integer getColporrhagia() {
        return colporrhagia;
    }

    public void setColporrhagia(Integer colporrhagia) {
        this.colporrhagia = colporrhagia;
    }

    public Date getColporrhagiadate() {
        return colporrhagiadate;
    }

    public void setColporrhagiadate(Date colporrhagiadate) {
        this.colporrhagiadate = colporrhagiadate;
    }

    public String getColporrhagiacon() {
        return colporrhagiacon;
    }

    public void setColporrhagiacon(String colporrhagiacon) {
        this.colporrhagiacon = colporrhagiacon == null ? null : colporrhagiacon.trim();
    }

    public Integer getBellyache() {
        return bellyache;
    }

    public void setBellyache(Integer bellyache) {
        this.bellyache = bellyache;
    }

    public Date getBellyachedate() {
        return bellyachedate;
    }

    public void setBellyachedate(Date bellyachedate) {
        this.bellyachedate = bellyachedate;
    }

    public String getBellyachecon() {
        return bellyachecon;
    }

    public void setBellyachecon(String bellyachecon) {
        this.bellyachecon = bellyachecon == null ? null : bellyachecon.trim();
    }

    public Integer getFever() {
        return fever;
    }

    public void setFever(Integer fever) {
        this.fever = fever;
    }

    public Date getFeverdate() {
        return feverdate;
    }

    public void setFeverdate(Date feverdate) {
        this.feverdate = feverdate;
    }

    public String getFevercon() {
        return fevercon;
    }

    public void setFevercon(String fevercon) {
        this.fevercon = fevercon == null ? null : fevercon.trim();
    }

    public Integer getEmesis() {
        return emesis;
    }

    public void setEmesis(Integer emesis) {
        this.emesis = emesis;
    }

    public Date getEmesisdate() {
        return emesisdate;
    }

    public void setEmesisdate(Date emesisdate) {
        this.emesisdate = emesisdate;
    }

    public String getEmesisnoeatcon() {
        return emesisnoeatcon;
    }

    public void setEmesisnoeatcon(String emesisnoeatcon) {
        this.emesisnoeatcon = emesisnoeatcon == null ? null : emesisnoeatcon.trim();
    }

    public Integer getHavahighrisk() {
        return havahighrisk;
    }

    public void setHavahighrisk(Integer havahighrisk) {
        this.havahighrisk = havahighrisk;
    }

    public Date getHavahighriskdate() {
        return havahighriskdate;
    }

    public void setHavahighriskdate(Date havahighriskdate) {
        this.havahighriskdate = havahighriskdate;
    }

    public String getHavahighriskcon() {
        return havahighriskcon;
    }

    public void setHavahighriskcon(String havahighriskcon) {
        this.havahighriskcon = havahighriskcon == null ? null : havahighriskcon.trim();
    }

    public Date getRecorddate() {
        return recorddate;
    }

    public void setRecorddate(Date recorddate) {
        this.recorddate = recorddate;
    }
}