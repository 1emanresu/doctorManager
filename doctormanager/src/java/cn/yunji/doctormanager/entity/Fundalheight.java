package cn.yunji.doctormanager.entity;

import java.util.Date;

public class Fundalheight {
    private Integer fid;
    private String mid;

    private Date fdate;

    private String fundalheight;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Date getFdate() {
        return fdate;
    }

    public void setFdate(Date fdate) {
        this.fdate = fdate;
    }

    public String getFundalheight() {
        return fundalheight;
    }

    public void setFundalheight(String fundalheight) {
        this.fundalheight = fundalheight == null ? null : fundalheight.trim();
    }
}