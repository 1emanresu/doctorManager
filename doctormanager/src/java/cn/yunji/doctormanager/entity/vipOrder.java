package cn.yunji.doctormanager.entity;

import java.util.Date;

public class vipOrder {
    private Integer ovipid;

    private Date voderdate;

    private String vodername;

    private Integer vipid;

    private String mid;

    private Date sdate;

    private Date edate;

    public Integer getOvipid() {
        return ovipid;
    }

    public void setOvipid(Integer ovipid) {
        this.ovipid = ovipid;
    }

    public Date getVoderdate() {
        return voderdate;
    }

    public void setVoderdate(Date voderdate) {
        this.voderdate = voderdate;
    }

    public String getVodername() {
        return vodername;
    }

    public void setVodername(String vodername) {
        this.vodername = vodername == null ? null : vodername.trim();
    }

    public Integer getVipid() {
        return vipid;
    }

    public void setVipid(Integer vipid) {
        this.vipid = vipid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }
}