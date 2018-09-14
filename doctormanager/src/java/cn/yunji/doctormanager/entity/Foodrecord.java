package cn.yunji.doctormanager.entity;

import java.util.Date;

public class Foodrecord {
    private Integer frid;

    private String mid;

    private Date recorddate;

    private String content;

    public Integer getFrid() {
        return frid;
    }

    public void setFrid(Integer frid) {
        this.frid = frid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Date getRecorddate() {
        return recorddate;
    }

    public void setRecorddate(Date recorddate) {
        this.recorddate = recorddate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}