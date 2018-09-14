package cn.yunji.doctormanager.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FolicAcid {
    private Integer faid;

    private String mid;

    private Integer dosage;

    private String drugname;
    
    private Date dreDate;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    public Date getDreDate() {
		return dreDate;
	}

	public void setDreDate(Date dreDate) {
		this.dreDate = dreDate;
	}

	public Integer getFaid() {
        return faid;
    }

    public void setFaid(Integer faid) {
        this.faid = faid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Integer getDosage() {
        return dosage;
    }

    public void setDosage(Integer dosage) {
        this.dosage = dosage;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname == null ? null : drugname.trim();
    }
}