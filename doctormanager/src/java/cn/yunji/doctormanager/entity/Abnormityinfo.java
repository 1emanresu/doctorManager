package cn.yunji.doctormanager.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
 
public class Abnormityinfo {
    private Integer abnormityid;

    private Integer highriskresulttypeid;

    private Integer cid;

    private String mid;

    private String hospitalid;

    private Date checkdate;

    private Integer score;

    private String abnormity;

    private Double deviation;

    private Integer weeks;
    
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date uploadDate;

	private GravidaInfo gravidaInfo;
    
	private Integer checkprojectid;
	
	private Integer resultid;
	
	private Checkindex checkindex;
	
	private CheckProject checkproject;
	
	public CheckProject getCheckproject() {
        return checkproject;
    }

    public void setCheckproject(CheckProject checkproject) {
        this.checkproject = checkproject;
    }

    public Checkindex getCheckindex() {
		return checkindex;
	}

	public void setCheckindex(Checkindex checkindex) {
		this.checkindex = checkindex;
	}

	public void setCheckprojectid(Integer checkprojectid) {
		this.checkprojectid = checkprojectid;
	}

	public Integer getCheckprojectid() {
		return checkprojectid;
	}

	public Integer getResultid() {
		return resultid;
	}

	public void setResultid(Integer resultid) {
		this.resultid = resultid;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	
    public GravidaInfo getGravidaInfo() {
        return gravidaInfo;
    }

    public void setGravidaInfo(GravidaInfo gravidaInfo) {
        this.gravidaInfo = gravidaInfo;
    }

    public Integer getAbnormityid() {
        return abnormityid;
    }

    public void setAbnormityid(Integer abnormityid) {
        this.abnormityid = abnormityid;
    }

    public Integer getHighriskresulttypeid() {
        return highriskresulttypeid;
    }

    public void setHighriskresulttypeid(Integer highriskresulttypeid) {
        this.highriskresulttypeid = highriskresulttypeid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public String getHospitalid() {
        return hospitalid;
    }

    public void setHospitalid(String hospitalid) {
        this.hospitalid = hospitalid == null ? null : hospitalid.trim();
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAbnormity() {
        return abnormity;
    }

    public void setAbnormity(String abnormity) {
        this.abnormity = abnormity;
    }

    public Double getDeviation() {
        return deviation;
    }

    public void setDeviation(Double deviation) {
        this.deviation = deviation;
    }

    public Integer getWeeks() {
        return weeks;
    }

    public void setWeeks(Integer weeks) {
        this.weeks = weeks;
    }
}