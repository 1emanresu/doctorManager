package cn.yunji.doctormanager.entity;

import java.util.Date;

public class CountQuickening {
    private Integer cid;

    private String mid;

    private Integer checkprojectid;

    private Date cdate;

    private String actualclick;

    private String validhits;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getActualclick() {
        return actualclick;
    }

    public void setActualclick(String actualclick) {
        this.actualclick = actualclick == null ? null : actualclick.trim();
    }

    public String getValidhits() {
        return validhits;
    }

    public void setValidhits(String validhits) {
        this.validhits = validhits == null ? null : validhits.trim();
    }
}