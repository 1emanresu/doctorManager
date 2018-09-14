package cn.yunji.doctormanager.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Record4_7 {
    private Integer rid47;

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

    private Integer beflustered;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date beflustereddate;

    private String beflusteredcon;

    private Integer headswirl;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")    
    private Date headswirldate;

    private String headswirlcon;

    private Integer fever1;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date fever1date;

    private String fever1con;

    private Integer blood;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date blooddate;

    private String bloodcon;

    private Integer shortweightnimiety;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date shortweightnimietydate;

    private String shortweightnimietycon;

    private Date recorddate;

    public Integer getRid47() {
        return rid47;
    }

    public void setRid47(Integer rid47) {
        this.rid47 = rid47;
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

    public Integer getFever1() {
        return fever1;
    }

    public void setFever1(Integer fever1) {
        this.fever1 = fever1;
    }

    public Date getFever1date() {
        return fever1date;
    }

    public void setFever1date(Date fever1date) {
        this.fever1date = fever1date;
    }

    public String getFever1con() {
        return fever1con;
    }

    public void setFever1con(String fever1con) {
        this.fever1con = fever1con == null ? null : fever1con.trim();
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

    public Integer getShortweightnimiety() {
        return shortweightnimiety;
    }

    public void setShortweightnimiety(Integer shortweightnimiety) {
        this.shortweightnimiety = shortweightnimiety;
    }

    public Date getShortweightnimietydate() {
        return shortweightnimietydate;
    }

    public void setShortweightnimietydate(Date shortweightnimietydate) {
        this.shortweightnimietydate = shortweightnimietydate;
    }

    public String getShortweightnimietycon() {
        return shortweightnimietycon;
    }

    public void setShortweightnimietycon(String shortweightnimietycon) {
        this.shortweightnimietycon = shortweightnimietycon == null ? null : shortweightnimietycon.trim();
    }

    public Date getRecorddate() {
        return recorddate;
    }

    public void setRecorddate(Date recorddate) {
        this.recorddate = recorddate;
    }
}