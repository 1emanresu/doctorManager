package cn.yunji.doctormanager.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TangScreen {
    private Integer tsid;

	private String mid;

	private Integer checkprojectid;

	private String hospitalname;

	private String bpiclink;

	private String samplenum;

	private String numeration;
	 @DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date sampletime;

	private String smaterials;

	private String smethod;
	
	private Integer fetusnumber;

	private String senddept;

	private String senddoctor;

	private String conclusion;

	private BigDecimal hafp;

	private BigDecimal hafqMom;

	private BigDecimal freeHcg;

	private BigDecimal freeHcgMom;

	private String ntd;

	private String t21;

	private String t18;

	private String t13;
	 @DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date reporttime;
	 @DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date checkdate;

	private String examiner;

	private String auditor;

	private Integer weeks;

	public Integer getTsid() {
		return tsid;
	}

	public void setTsid(Integer tsid) {
		this.tsid = tsid;
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

	public String getSamplenum() {
		return samplenum;
	}

	public void setSamplenum(String samplenum) {
		this.samplenum = samplenum == null ? null : samplenum.trim();
	}

	public String getNumeration() {
		return numeration;
	}

	public void setNumeration(String numeration) {
		this.numeration = numeration == null ? null : numeration.trim();
	}

	public Integer getFetusnumber() {
		return fetusnumber;
	}

	public void setFetusnumber(Integer fetusnumber) {
		this.fetusnumber = fetusnumber;
	}

	public Date getSampletime() {
		return sampletime;
	}

	public void setSampletime(Date sampletime) {
		this.sampletime = sampletime;
	}

	public String getSmaterials() {
		return smaterials;
	}

	public void setSmaterials(String smaterials) {
		this.smaterials = smaterials == null ? null : smaterials.trim();
	}

	public String getSmethod() {
		return smethod;
	}

	public void setSmethod(String smethod) {
		this.smethod = smethod == null ? null : smethod.trim();
	}

	public String getSenddept() {
		return senddept;
	}

	public void setSenddept(String senddept) {
		this.senddept = senddept == null ? null : senddept.trim();
	}

	public String getSenddoctor() {
		return senddoctor;
	}

	public void setSenddoctor(String senddoctor) {
		this.senddoctor = senddoctor == null ? null : senddoctor.trim();
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion == null ? null : conclusion.trim();
	}

	public BigDecimal getHafp() {
		return hafp;
	}

	public void setHafp(BigDecimal hafp) {
		this.hafp = hafp;
	}

	public BigDecimal getHafqMom() {
		return hafqMom;
	}

	public void setHafqMom(BigDecimal hafqMom) {
		this.hafqMom = hafqMom;
	}

	public BigDecimal getFreeHcg() {
		return freeHcg;
	}

	public void setFreeHcg(BigDecimal freeHcg) {
		this.freeHcg = freeHcg;
	}

	public BigDecimal getFreeHcgMom() {
		return freeHcgMom;
	}

	public void setFreeHcgMom(BigDecimal freeHcgMom) {
		this.freeHcgMom = freeHcgMom;
	}

	public String getNtd() {
		return ntd;
	}

	public void setNtd(String ntd) {
		this.ntd = ntd == null ? null : ntd.trim();
	}

	public String getT21() {
		return t21;
	}

	public void setT21(String t21) {
		this.t21 = t21 == null ? null : t21.trim();
	}

	public String getT18() {
		return t18;
	}

	public void setT18(String t18) {
		this.t18 = t18 == null ? null : t18.trim();
	}

	public String getT13() {
		return t13;
	}

	public void setT13(String t13) {
		this.t13 = t13 == null ? null : t13.trim();
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