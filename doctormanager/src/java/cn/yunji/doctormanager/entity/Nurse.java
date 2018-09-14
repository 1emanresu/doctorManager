package cn.yunji.doctormanager.entity;

public class Nurse {
    private Integer nurseid;

    private String hospitalid;

    private Integer userid;

    private Integer officeid;

    private String nname;

    private Integer sex;

    private String duty;

    private String goodat;

    private String address;

    private String email;

    private String nphone;

    public Integer getNurseid() {
        return nurseid;
    }

    public void setNurseid(Integer nurseid) {
        this.nurseid = nurseid;
    }

    public String getHospitalid() {
        return hospitalid;
    }

    public void setHospitalid(String hospitalid) {
        this.hospitalid = hospitalid == null ? null : hospitalid.trim();
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

    public String getNname() {
        return nname;
    }

    public void setNname(String nname) {
        this.nname = nname == null ? null : nname.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }



    public String getGoodat() {
		return goodat;
	}

	public void setGoodat(String goodat) {
		this.goodat = goodat;
	}

	public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getNphone() {
        return nphone;
    }

    public void setNphone(String nphone) {
        this.nphone = nphone == null ? null : nphone.trim();
    }
}