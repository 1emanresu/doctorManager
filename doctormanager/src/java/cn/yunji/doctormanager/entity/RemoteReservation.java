package cn.yunji.doctormanager.entity;

import java.util.Date;

public class RemoteReservation {
    private Integer rrid;

    private String hospitalid;

    private Integer doctorid;

    private String mid;

    private Integer type;

    private Date booktime;

    private Integer inquirystate;
    
    private Date interrogationTime;
    
    private Integer pendingState;


	public Integer getPendingState() {
		return pendingState;
	}

	public void setPendingState(Integer pendingState) {
		this.pendingState = pendingState;
	}

	public Date getInterrogationTime() {
		return interrogationTime;
	}

	public void setInterrogationTime(Date interrogationTime) {
		this.interrogationTime = interrogationTime;
	}

	public Integer getRrid() {
        return rrid;
    }

    public void setRrid(Integer rrid) {
        this.rrid = rrid;
    }

    public String getHospitalid() {
        return hospitalid;
    }

    public void setHospitalid(String hospitalid) {
        this.hospitalid = hospitalid == null ? null : hospitalid.trim();
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getBooktime() {
        return booktime;
    }

    public void setBooktime(Date booktime) {
        this.booktime = booktime;
    }

    public Integer getInquirystate() {
        return inquirystate;
    }

    public void setInquirystate(Integer inquirystate) {
        this.inquirystate = inquirystate;
    }
}