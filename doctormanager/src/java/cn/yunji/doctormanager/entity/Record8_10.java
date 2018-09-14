package cn.yunji.doctormanager.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Record8_10 {
    private Integer rid810;

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

    private Integer havahighrisk;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date havahighriskdate;

    private String havahighriskcon;

    private Integer beflustered;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date beflustereddate;

    private String beflusteredcon;

    private Integer headswirl;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date headswirldate;

    private String headswirlcon;

    private Integer edema;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date edemadate;

    private String edemacon;

    private Integer blood;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date blooddate;

    private String bloodcon;

    private Integer sabnormalfetalirrirability;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date sabnormalfetalirrirabilitydate;

    private String abnormalfetalirrirabilitycon;

    private Integer gestationalweeks;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date gestationalweeksdate;

    private String gestationalweekscon;

    private Date recorddate;

    public Integer getRid810() {
        return rid810;
    }

    public void setRid810(Integer rid810) {
        this.rid810 = rid810;
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

    public Integer getBeflustered() {
        return beflustered;
    }

    public void setBeflustered(Integer beflustered) {
        this.beflustered = beflustered;
    }

    public Date getBeflustereddate() {
        return beflustereddate;
    }

    public void setBeflustereddate(Date beflustereddate) {
        this.beflustereddate = beflustereddate;
    }

    public String getBeflusteredcon() {
        return beflusteredcon;
    }

    public void setBeflusteredcon(String beflusteredcon) {
        this.beflusteredcon = beflusteredcon == null ? null : beflusteredcon.trim();
    }

    public Integer getHeadswirl() {
        return headswirl;
    }

    public void setHeadswirl(Integer headswirl) {
        this.headswirl = headswirl;
    }

    public Date getHeadswirldate() {
        return headswirldate;
    }

    public void setHeadswirldate(Date headswirldate) {
        this.headswirldate = headswirldate;
    }

    public String getHeadswirlcon() {
        return headswirlcon;
    }

    public void setHeadswirlcon(String headswirlcon) {
        this.headswirlcon = headswirlcon == null ? null : headswirlcon.trim();
    }

    public Integer getEdema() {
        return edema;
    }

    public void setEdema(Integer edema) {
        this.edema = edema;
    }

    public Date getEdemadate() {
        return edemadate;
    }

    public void setEdemadate(Date edemadate) {
        this.edemadate = edemadate;
    }

    public String getEdemacon() {
        return edemacon;
    }

    public void setEdemacon(String edemacon) {
        this.edemacon = edemacon == null ? null : edemacon.trim();
    }

    public Integer getBlood() {
        return blood;
    }

    public void setBlood(Integer blood) {
        this.blood = blood;
    }

    public Date getBlooddate() {
        return blooddate;
    }

    public void setBlooddate(Date blooddate) {
        this.blooddate = blooddate;
    }

    public String getBloodcon() {
        return bloodcon;
    }

    public void setBloodcon(String bloodcon) {
        this.bloodcon = bloodcon == null ? null : bloodcon.trim();
    }

    public Integer getSabnormalfetalirrirability() {
        return sabnormalfetalirrirability;
    }

    public void setSabnormalfetalirrirability(Integer sabnormalfetalirrirability) {
        this.sabnormalfetalirrirability = sabnormalfetalirrirability;
    }

    public Date getSabnormalfetalirrirabilitydate() {
        return sabnormalfetalirrirabilitydate;
    }

    public void setSabnormalfetalirrirabilitydate(Date sabnormalfetalirrirabilitydate) {
        this.sabnormalfetalirrirabilitydate = sabnormalfetalirrirabilitydate;
    }

    public String getAbnormalfetalirrirabilitycon() {
        return abnormalfetalirrirabilitycon;
    }

    public void setAbnormalfetalirrirabilitycon(String abnormalfetalirrirabilitycon) {
        this.abnormalfetalirrirabilitycon = abnormalfetalirrirabilitycon == null ? null : abnormalfetalirrirabilitycon.trim();
    }

    public Integer getGestationalweeks() {
        return gestationalweeks;
    }

    public void setGestationalweeks(Integer gestationalweeks) {
        this.gestationalweeks = gestationalweeks;
    }

    public Date getGestationalweeksdate() {
        return gestationalweeksdate;
    }

    public void setGestationalweeksdate(Date gestationalweeksdate) {
        this.gestationalweeksdate = gestationalweeksdate;
    }

    public String getGestationalweekscon() {
        return gestationalweekscon;
    }

    public void setGestationalweekscon(String gestationalweekscon) {
        this.gestationalweekscon = gestationalweekscon == null ? null : gestationalweekscon.trim();
    }

    public Date getRecorddate() {
        return recorddate;
    }

    public void setRecorddate(Date recorddate) {
        this.recorddate = recorddate;
    }
}