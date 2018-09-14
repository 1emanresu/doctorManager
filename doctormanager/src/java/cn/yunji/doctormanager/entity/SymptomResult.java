package cn.yunji.doctormanager.entity;

import java.util.Date;

public class SymptomResult {
    private Integer symptomid;

    private Integer symptomdetailid;

    private String mid;

    private Date arisedate;

    public Integer getSymptomid() {
        return symptomid;
    }

    public void setSymptomid(Integer symptomid) {
        this.symptomid = symptomid;
    }

    public Integer getSymptomdetailid() {
        return symptomdetailid;
    }

    public void setSymptomdetailid(Integer symptomdetailid) {
        this.symptomdetailid = symptomdetailid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Date getArisedate() {
        return arisedate;
    }

    public void setArisedate(Date arisedate) {
        this.arisedate = arisedate;
    }
}