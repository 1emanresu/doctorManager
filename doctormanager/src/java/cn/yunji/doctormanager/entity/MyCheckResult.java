package cn.yunji.doctormanager.entity;

import java.util.Date;

public class MyCheckResult {
    private Integer mcrid;

    private String mid;

    private Integer checkprojectid;

    private Integer resultid;

    private Date resultdate;

    private Integer weeks;

    public Integer getMcrid() {
        return mcrid;
    }

    public void setMcrid(Integer mcrid) {
        this.mcrid = mcrid;
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

    public Integer getResultid() {
        return resultid;
    }

    public void setResultid(Integer resultid) {
        this.resultid = resultid;
    }

    public Date getResultdate() {
        return resultdate;
    }

    public void setResultdate(Date resultdate) {
        this.resultdate = resultdate;
    }

    public Integer getWeeks() {
        return weeks;
    }

    public void setWeeks(Integer weeks) {
        this.weeks = weeks;
    }
}