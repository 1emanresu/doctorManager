package cn.yunji.doctormanager.entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InquiryRecord {
    private Integer qid;

    private String mid;

    private Integer doctorid;
    
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date qdate;
	
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
   	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date uploaddate;
    	
    private String rationalsymptom;
    
    private String doctoradvice;
    
    private List<SelfTestJudgment> selfTestJudgment;
    
    private List<Doctor> doctor;
    
    private String abnormityinfoIndex;

    private String inquiryVideo;
    
    
	public String getInquiryVideo() {
		return inquiryVideo;
	}

	public void setInquiryVideo(String inquiryVideo) {
		this.inquiryVideo = inquiryVideo;
	}

	public List<Doctor> getDoctor() {
		return doctor;
	}

	public void setDoctor(List<Doctor> doctor) {
		this.doctor = doctor;
	}

	public String getAbnormityinfoIndex() {
        return abnormityinfoIndex;
    }

    public void setAbnormityinfoIndex(String abnormityinfoIndex) {
        this.abnormityinfoIndex = abnormityinfoIndex;
    }

    public List<SelfTestJudgment> getSelfTestJudgment() {
		return selfTestJudgment;
	}

	public void setSelfTestJudgment(List<SelfTestJudgment> selfTestJudgment) {
		this.selfTestJudgment = selfTestJudgment;
	}

    public Date getUploaddate() {
		return uploaddate;
	}

	public void setUploaddate(Date uploaddate) {
		this.uploaddate = uploaddate;
	}

	public String getDoctoradvice() {
		return doctoradvice;
	}

	public void setDoctoradvice(String doctoradvice) {
		this.doctoradvice = doctoradvice;
	}

	public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
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

    public Date getQdate() {
        return qdate;
    }

    public void setQdate(Date qdate) {
        this.qdate = qdate;
    }

    public String getRationalsymptom() {
        return rationalsymptom;
    }

    public void setRationalsymptom(String rationalsymptom) {
        this.rationalsymptom = rationalsymptom == null ? null : rationalsymptom.trim();
    }

    @Override
    public String toString() {
        return "InquiryRecord [qid=" + qid + ", mid=" + mid + ", doctorid=" + doctorid + ", qdate=" + qdate
                + ", uploaddate=" + uploaddate + ", rationalsymptom=" + rationalsymptom + ", doctoradvice="
                + doctoradvice + ", selfTestJudgment=" + selfTestJudgment + ", doctor=" + doctor
                + ", abnormityinfoIndex=" + abnormityinfoIndex + ", inquiryVideo=" + inquiryVideo + "]";
    }
    
}