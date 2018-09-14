package cn.yunji.doctormanager.entity;

import java.util.Date;

public class Disease {
    private Integer diseaseid;

    private String mid;

    private Date occurdate;

    private String describecontent;

    public Integer getDiseaseid() {
        return diseaseid;
    }

    public void setDiseaseid(Integer diseaseid) {
        this.diseaseid = diseaseid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Date getOccurdate() {
        return occurdate;
    }

    public void setOccurdate(Date occurdate) {
        this.occurdate = occurdate;
    }

    public String getDescribecontent() {
        return describecontent;
    }

    public void setDescribecontent(String describecontent) {
        this.describecontent = describecontent == null ? null : describecontent.trim();
    }
}