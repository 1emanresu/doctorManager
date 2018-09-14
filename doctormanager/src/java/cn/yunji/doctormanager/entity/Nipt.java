package cn.yunji.doctormanager.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Nipt {
    private Integer nid;

	private String mid;

	private Integer checkprojectid;

	private String hospitalname;

	private String bpiclink;

	private Integer bid;
	 
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date sampletime;
    
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date receivedtime;
    
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date enddate;

	private String history;

	private Integer fetusnumber;

	private String sampletype;

	private Integer samplestatus;

	private String clinicaldiagnosis;

	private Integer methodsandproperties;

	private Integer project;

	private String description;

	private String tip;

	private Integer ivfEt;

	private BigDecimal t21;

	private BigDecimal t18;

	private BigDecimal t13;
	 
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date reporttime;
	 
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date checkdate;

	private String examiner;

	private String auditor;

	private Integer weeks;

	public Integer getNid() {
		return nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
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

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Date getSampletime() {
		return sampletime;
	}

	public void setSampletime(Date sampletime) {
		this.sampletime = sampletime;
	}

	public Date getReceivedtime() {
		return receivedtime;
	}

	public void setReceivedtime(Date receivedtime) {
		this.receivedtime = receivedtime;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history == null ? null : history.trim();
	}

	public Integer getFetusnumber() {
		return fetusnumber;
	}

	public void setFetusnumber(Integer fetusnumber) {
		this.fetusnumber = fetusnumber;
	}

	public String getSampletype() {
		return sampletype;
	}

	public void setSampletype(String sampletype) {
		this.sampletype = sampletype == null ? null : sampletype.trim();
	}

	public Integer getSamplestatus() {
		return samplestatus;
	}

	public void setSamplestatus(Integer samplestatus) {
		this.samplestatus = samplestatus;
	}

	public String getClinicaldiagnosis() {
		return clinicaldiagnosis;
	}

	public void setClinicaldiagnosis(String clinicaldiagnosis) {
		this.clinicaldiagnosis = clinicaldiagnosis == null ? null : clinicaldiagnosis.trim();
	}

	public Integer getMethodsandproperties() {
		return methodsandproperties;
	}

	public void setMethodsandproperties(Integer methodsandproperties) {
		this.methodsandproperties = methodsandproperties;
	}

	public Integer getProject() {
		return project;
	}

	public void setProject(Integer project) {
		this.project = project;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip == null ? null : tip.trim();
	}

	public Integer getIvfEt() {
		return ivfEt;
	}

	public void setIvfEt(Integer ivfEt) {
		this.ivfEt = ivfEt;
	}

	public BigDecimal getT21() {
		return t21;
	}

	public void setT21(BigDecimal t21) {
		this.t21 = t21;
	}

	public BigDecimal getT18() {
		return t18;
	}

	public void setT18(BigDecimal t18) {
		this.t18 = t18;
	}

	public BigDecimal getT13() {
		return t13;
	}

	public void setT13(BigDecimal t13) {
		this.t13 = t13;
	}

	public Date getReporttime() {
		return reporttime;
	}

	public void setReporttime(Date reporttime) {
		this.reporttime = reporttime;
	}

	public Date getCheckdate() {
		return checkdate;
	}

	public void setCheckdate(Date checkdate) {
		this.checkdate = checkdate;
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