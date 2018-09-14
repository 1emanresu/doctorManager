package cn.yunji.doctormanager.entity;

import java.util.Date;

public class DescribeTb {
    private Integer did;

    private String mid;

    private Date describedate;

    private String describecontent;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Date getDescribedate() {
        return describedate;
    }

    public void setDescribedate(Date describedate) {
        this.describedate = describedate;
    }

    public String getDescribecontent() {
        return describecontent;
    }

    public void setDescribecontent(String describecontent) {
        this.describecontent = describecontent == null ? null : describecontent.trim();
    }
}