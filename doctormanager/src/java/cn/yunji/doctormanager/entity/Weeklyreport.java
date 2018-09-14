package cn.yunji.doctormanager.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Weeklyreport {
    private Integer wid;

    private String mid;

    private Integer doctorid;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date uploaddate;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date wdate;

    private String doctoradvice;
    
    private String abnormityinfoIndex;

    public String getAbnormityinfoIndex() {
		return abnormityinfoIndex;
	}

	public void setAbnormityinfoIndex(String abnormityinfoIndex) {
		this.abnormityinfoIndex = abnormityinfoIndex;
	}

	public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public Date getUploaddate() {
        return uploaddate;
    }

    public void setUploaddate(Date uploaddate) {
        this.uploaddate = uploaddate;
    }

    public Date getWdate() {
        return wdate;
    }

    public void setWdate(Date wdate) {
        this.wdate = wdate;
    }

    public String getDoctoradvice() {
        return doctoradvice;
    }

    public void setDoctoradvice(String doctoradvice) {
        this.doctoradvice = doctoradvice == null ? null : doctoradvice.trim();
    }
}