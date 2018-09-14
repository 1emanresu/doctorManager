package cn.yunji.doctormanager.entity;

public class Medicalcheck {
    private Integer mid;

    private Integer tid;

    private Integer mtype;

    private String mname;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getMtype() {
        return mtype;
    }

    public void setMtype(Integer mtype) {
        this.mtype = mtype;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname == null ? null : mname.trim();
    }
}