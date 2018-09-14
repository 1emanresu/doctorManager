package cn.yunji.doctormanager.entity;

import java.util.Date;

public class Geneticscreening {
    private Integer gid;

    private String mid;

    private Integer checkprojectid;

    private String hospitalname;

    private String t13;

    private String t18;

    private String t21;

    private Date checkdate;

    private Integer gweeks;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
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

    public String getT13() {
        return t13;
    }

    public void setT13(String t13) {
        this.t13 = t13 == null ? null : t13.trim();
    }

    public String getT18() {
        return t18;
    }

    public void setT18(String t18) {
        this.t18 = t18 == null ? null : t18.trim();
    }

    public String getT21() {
        return t21;
    }

    public void setT21(String t21) {
        this.t21 = t21 == null ? null : t21.trim();
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
}