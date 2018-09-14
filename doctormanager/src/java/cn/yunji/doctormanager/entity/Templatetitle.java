package cn.yunji.doctormanager.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Templatetitle {
    private Integer ttid;

	private Integer checkprojectid;

	private String mid;
	
	private String name;
	private int age;
	
	private Integer weeks;

	private String medicalrecord;

	private Integer pay;

	private String sampleid;

	private String barcode;

	private String department;

	private String senddoctor;

	private String bednum;

	private String sampletype;

	private String clinicaldiagnosis;
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date reportdate;
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date checkdate;

	private String examiner;

	private String auditor;

	public Integer getTtid() {
		return ttid;
	}

	public void setTtid(Integer ttid) {
		this.ttid = ttid;
	}

	public Integer getCheckprojectid() {
		return checkprojectid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Integer getWeeks() {
		return weeks;
	}

	public void setWeeks(Integer weeks) {
		this.weeks = weeks;
	}

	public void setCheckprojectid(Integer checkprojectid) {
		this.checkprojectid = checkprojectid;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid == null ? null : mid.trim();
	}

	public String getMedicalrecord() {
		return medicalrecord;
	}

	public void setMedicalrecord(String medicalrecord) {
		this.medicalrecord = medicalrecord == null ? null : medicalrecord.trim();
	}

	public Integer getPay() {
		return pay;
	}

	public void setPay(Integer pay) {
		this.pay = pay;
	}

	public String getSampleid() {
		return sampleid;
	}

	public void setSampleid(String sampleid) {
		this.sampleid = sampleid == null ? null : sampleid.trim();
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode == null ? null : barcode.trim();
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department == null ? null : department.trim();
	}

	public String getSenddoctor() {
		return senddoctor;
	}

	public void setSenddoctor(String senddoctor) {
		this.senddoctor = senddoctor == null ? null : senddoctor.trim();
	}

	public String getBednum() {
		return bednum;
	}

	public void setBednum(String bednum) {
		this.bednum = bednum == null ? null : bednum.trim();
	}

	public String getSampletype() {
		return sampletype;
	}

	public void setSampletype(String sampletype) {
		this.sampletype = sampletype == null ? null : sampletype.trim();
	}

	public String getClinicaldiagnosis() {
		return clinicaldiagnosis;
	}

	public void setClinicaldiagnosis(String clinicaldiagnosis) {
		this.clinicaldiagnosis = clinicaldiagnosis == null ? null : clinicaldiagnosis.trim();
	}

	public Date getReportdate() {
		return reportdate;
	}

	public void setReportdate(Date reportdate) {
		this.reportdate = reportdate;
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

}