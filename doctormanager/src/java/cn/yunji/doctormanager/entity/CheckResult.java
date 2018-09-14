package cn.yunji.doctormanager.entity;

import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CheckResult {
    private Integer checkresultid;
    private String hospitalid;
    private String mid;
    private Integer doctorid;
    private GravidaInfo gravidaInfo;
    private Doctor doctor;
	private Integer checkprojectid;
    private List<CheckDetail> checkDetailList;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date checkdate;
    private Integer gweeks;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date uploadDate;
	//异常信息迎合数据库
    private List<Abnormityinfo> abnormityinfo;
    
    private CheckProject checkProject;
    
    private String picLink;
    //@Author 文字结果描述
    private String fontresult;
    
    public String getPicLink() {
		return picLink;
	}

	public void setPicLink(String picLink) {
		this.picLink = picLink;
	}

	public CheckProject getCheckProject() {
		return checkProject;
	}

	public void setCheckProject(CheckProject checkProject) {
		this.checkProject = checkProject;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public List<Abnormityinfo> getAbnormityinfo() {
		return abnormityinfo;
	}

	public void setAbnormityinfo(List<Abnormityinfo> abnormityinfo) {
		this.abnormityinfo = abnormityinfo;
	}

	public Integer getCheckresultid() {
        return checkresultid;
    }

    public void setCheckresultid(Integer checkresultid) {
        this.checkresultid = checkresultid;
    }

    public String getHospitalid() {
        return hospitalid;
    }

    public void setHospitalid(String hospitalid) {
        this.hospitalid = hospitalid == null ? null : hospitalid.trim();
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

    public Integer getCheckprojectid() {
		return checkprojectid;
	}

	public void setCheckprojectid(Integer checkprojectid) {
		this.checkprojectid = checkprojectid;
	}

	public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public Integer getGweeks() {
        return gweeks;
    }

    public void setGweeks(Integer gweeks) {
        this.gweeks = gweeks;
    }
    public GravidaInfo getGravidaInfo() {
    	return gravidaInfo;
    }

        public void setGravidaInfo(GravidaInfo gravidaInfo) {
    	this.gravidaInfo = gravidaInfo;
    }

    public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

    public List<CheckDetail> getCheckDetailList() {
		return checkDetailList;
    }

    public void setCheckDetailList(List<CheckDetail> checkDetailList) {
		this.checkDetailList = checkDetailList;
    }

	/**
	 * @return the fontresult
	 */
	public String getFontresult() {
		return fontresult;
	}

	/**
	 * @param fontresult the fontresult to set
	 */
	public void setFontresult(String fontresult) {
		this.fontresult = fontresult;
	}

}