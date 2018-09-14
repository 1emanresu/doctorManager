package cn.yunji.doctormanager.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Amniocentesis {
	private Integer amid;

	private String mid;

	private Integer checkprojectid;

	private String hospitalname;

	private String bpiclink;

	private String ci;

	private String smaterials;

	private String sitems;

	private String result;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date reporttime;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date checkDate;

	private String examiner;

	private String auditor;

	private Integer weeks;

	public Integer getAmid() {
		return amid;
	}

	public void setAmid(Integer amid) {
		this.amid = amid;
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

	public String getBpiclink() {
		return bpiclink;
	}

	public void setBpiclink(String bpiclink) {
		this.bpiclink = bpiclink == null ? null : bpiclink.trim();
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci == null ? null : ci.trim();
	}

	public String getSmaterials() {
		return smaterials;
	}

	public void setSmaterials(String smaterials) {
		this.smaterials = smaterials == null ? null : smaterials.trim();
	}

	public String getSitems() {
		return sitems;
	}

	public void setSitems(String sitems) {
		this.sitems = sitems == null ? null : sitems.trim();
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result == null ? null : result.trim();
	}

	public Date getReporttime() {
		return reporttime;
	}

	public void setReporttime(Date reporttime) {
		this.reporttime = reporttime;
	}


	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getExaminer() {
		return examiner;
	}

	public void setExaminer(String examiner) {
		this.examiner = examiner == null ? null : examiner.trim();
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor == null ? null : auditor.trim();
	}

	public Integer getWeeks() {
		return weeks;
	}

	public void setWeeks(Integer weeks) {
		this.weeks = weeks;
	}
}