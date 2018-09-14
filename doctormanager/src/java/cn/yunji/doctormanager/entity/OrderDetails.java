package cn.yunji.doctormanager.entity;

import java.util.Date;

public class OrderDetails {
    private Integer odid;

    private Integer ovipid;

    private Integer servicetype;

    private Date startdate;

    private Date expiredate;

    private Integer processingstate;

    public Integer getOdid() {
        return odid;
    }

    public void setOdid(Integer odid) {
        this.odid = odid;
    }

    public Integer getOvipid() {
        return ovipid;
    }

    public void setOvipid(Integer ovipid) {
        this.ovipid = ovipid;
    }

    public Integer getServicetype() {
        return servicetype;
    }

    public void setServicetype(Integer servicetype) {
        this.servicetype = servicetype;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getExpiredate() {
        return expiredate;
    }

    public void setExpiredate(Date expiredate) {
        this.expiredate = expiredate;
    }

    public Integer getProcessingstate() {
        return processingstate;
    }

    public void setProcessingstate(Integer processingstate) {
        this.processingstate = processingstate;
    }
}