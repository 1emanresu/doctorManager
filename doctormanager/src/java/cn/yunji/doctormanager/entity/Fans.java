package cn.yunji.doctormanager.entity;

public class Fans {
    private Integer fid;

    private Integer doctorid;

    private String mid;

    private Integer attentionstate;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Integer getAttentionstate() {
        return attentionstate;
    }

    public void setAttentionstate(Integer attentionstate) {
        this.attentionstate = attentionstate;
    }
}