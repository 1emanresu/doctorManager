package cn.yunji.doctormanager.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Electrocardio {
    private Integer elid;

    private String mid;

    private Integer checkprojectid;

    private String hospitalname;

    private Integer weeks;

    private Date checkdate;

    private String bpiclink;

    private String heartrate;

    private String roomrate1;

    private String roomrate2;

    private String qrsEa;

    private String qtc;

    private String p;

    private String pR;

    private String qrs;

    private String rv5Sv1;

    private String rscount;
    
    private String description;
    
    private String tip;
    
    @JsonIgnore
    private Hospital hospital;
    @JsonIgnore
    private Doctor doctor;
    @JsonIgnore
    private GravidaInfo gravidaInfo;

	public Integer getElid() {
        return elid;
    }

    public void setElid(Integer elid) {
        this.elid = elid;
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

    public String getHospitalname() {
        return hospitalname;
    }

    public void setHospitalname(String hospitalname) {
        this.hospitalname = hospitalname == null ? null : hospitalname.trim();
    }

    public Integer getWeeks() {
        return weeks;
    }

    public void setWeeks(Integer weeks) {
        this.weeks = weeks;
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public String getBpiclink() {
        return bpiclink;
    }

    public void setBpiclink(String bpiclink) {
        this.bpiclink = bpiclink == null ? null : bpiclink.trim();
    }

    public String getHeartrate() {
        return heartrate;
    }

    public void setHeartrate(String heartrate) {
        this.heartrate = heartrate == null ? null : heartrate.trim();
    }

    public String getRoomrate1() {
        return roomrate1;
    }

    public void setRoomrate1(String roomrate1) {
        this.roomrate1 = roomrate1 == null ? null : roomrate1.trim();
    }

    public String getRoomrate2() {
        return roomrate2;
    }

    public void setRoomrate2(String roomrate2) {
        this.roomrate2 = roomrate2 == null ? null : roomrate2.trim();
    }

    public String getQrsEa() {
        return qrsEa;
    }

    public void setQrsEa(String qrsEa) {
        this.qrsEa = qrsEa == null ? null : qrsEa.trim();
    }

    public String getQtc() {
        return qtc;
    }

    public void setQtc(String qtc) {
        this.qtc = qtc == null ? null : qtc.trim();
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p == null ? null : p.trim();
    }

    public String getpR() {
        return pR;
    }

    public void setpR(String pR) {
        this.pR = pR == null ? null : pR.trim();
    }

    public String getQrs() {
        return qrs;
    }

    public void setQrs(String qrs) {
        this.qrs = qrs == null ? null : qrs.trim();
    }

    public String getRv5Sv1() {
        return rv5Sv1;
    }

    public void setRv5Sv1(String rv5Sv1) {
        this.rv5Sv1 = rv5Sv1 == null ? null : rv5Sv1.trim();
    }

    public String getRscount() {
        return rscount;
    }

    public void setRscount(String rscount) {
        this.rscount = rscount == null ? null : rscount.trim();
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
}