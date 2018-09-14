package cn.yunji.doctormanager.entity;

import java.util.List;

public class Doctor {
    private Integer doctorid;

    private String hospitalid;

    private Integer userid;

    private Integer officeid;

    private String dname;

    private Integer sex;

    private String introduce;

    private String address;

    private String email;
    
	private Integer pid;
	 
	private String fixedTelephone;
	 
	private String dphone;
	
	private Hospital hospital;
	
	private Office office;
	
	private UserTb userTb;
	
	private  List<CheckResult> checkResult;
	
	private String offID;
	
	
	public String getOffID() {
        return offID;
    }

    public void setOffID(String offID) {
        this.offID = offID;
    }

    public Integer getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(Integer doctorid) {
		this.doctorid = doctorid;
	}

	public String getHospitalid() {
		return hospitalid;
	}

	public void setHospitalid(String hospitalid) {
		this.hospitalid = hospitalid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getOfficeid() {
		return officeid;
	}

	public void setOfficeid(Integer officeid) {
		this.officeid = officeid;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getFixedTelephone() {
		return fixedTelephone;
	}

	public void setFixedTelephone(String fixedTelephone) {
		this.fixedTelephone = fixedTelephone;
	}

	public String getDphone() {
		return dphone;
	}

	public void setDphone(String dphone) {
		this.dphone = dphone;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public UserTb getUserTb() {
		return userTb;
	}

	public void setUserTb(UserTb userTb) {
		this.userTb = userTb;
	}

	public List<CheckResult> getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(List<CheckResult> checkResult) {
		this.checkResult = checkResult;
	}

	@Override
	public String toString() {
		return "Doctor [doctorid=" + doctorid + ", hospitalid=" + hospitalid + ", userid=" + userid + ", officeid="
				+ officeid + ", dname=" + dname + ", sex=" + sex + ", introduce=" + introduce + ", address=" + address
				+ ", email=" + email + ", pid=" + pid + ", fixedTelephone=" + fixedTelephone + ", dphone=" + dphone
				+ ", hospital=" + hospital + ", office=" + office + ", userTb=" + userTb + ", checkResult="
				+ checkResult + "]";
	}
	




    
}