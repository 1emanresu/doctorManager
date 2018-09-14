package cn.yunji.doctormanager.entity;

public class OfficeItem {
    private Integer offid;

    private Integer officeid;

    private String offname;

    public Integer getOffid() {
        return offid;
    }

    public void setOffid(Integer offid) {
        this.offid = offid;
    }

    public Integer getOfficeid() {
        return officeid;
    }

    public void setOfficeid(Integer officeid) {
        this.officeid = officeid;
    }

    public String getOffname() {
        return offname;
    }

    public void setOffname(String offname) {
        this.offname = offname == null ? null : offname.trim();
    }
}