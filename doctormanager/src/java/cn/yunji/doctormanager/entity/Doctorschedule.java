package cn.yunji.doctormanager.entity;

import java.util.Date;

public class Doctorschedule {
    private Integer scheduleid;

    private Integer doctorid;

    private String dname;

    private Date dutydate;

    private Date dutybegintime;

    private Date dutyendtime;

    private Integer regnumresouce;

    private String dutyframe;
    private Integer dutyWeek;
    
    public Integer getDutyWeek() {
        return dutyWeek;
    }

    public void setDutyWeek(Integer dutyWeek) {
        this.dutyWeek = dutyWeek;
    }

    public Integer getScheduleid() {
        return scheduleid;
    }

    public void setScheduleid(Integer scheduleid) {
        this.scheduleid = scheduleid;
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname == null ? null : dname.trim();
    }

    public Date getDutydate() {
        return dutydate;
    }

    public void setDutydate(Date dutydate) {
        this.dutydate = dutydate;
    }

    public Date getDutybegintime() {
        return dutybegintime;
    }

    public void setDutybegintime(Date dutybegintime) {
        this.dutybegintime = dutybegintime;
    }

    public Date getDutyendtime() {
        return dutyendtime;
    }

    public void setDutyendtime(Date dutyendtime) {
        this.dutyendtime = dutyendtime;
    }

    public Integer getRegnumresouce() {
        return regnumresouce;
    }

    public void setRegnumresouce(Integer regnumresouce) {
        this.regnumresouce = regnumresouce;
    }

    public String getDutyframe() {
        return dutyframe;
    }

    public void setDutyframe(String dutyframe) {
        this.dutyframe = dutyframe == null ? null : dutyframe.trim();
    }
}