package cn.yunji.doctormanager.entity;

import java.util.Date;

public class WeightTest {
    private Integer wid;

    private String mid;

    private Integer checkprojectid;

    private Date wdate;

    private String pregnancy;

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
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

    public Date getWdate() {
        return wdate;
    }

    public void setWdate(Date wdate) {
        this.wdate = wdate;
    }

    public String getPregnancy() {
        return pregnancy;
    }

    public void setPregnancy(String pregnancy) {
        this.pregnancy = pregnancy == null ? null : pregnancy.trim();
    }
}