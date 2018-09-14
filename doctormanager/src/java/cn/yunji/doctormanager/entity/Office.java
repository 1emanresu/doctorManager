package cn.yunji.doctormanager.entity;

public class Office {
    private Integer officeid;

    private String officename;

    public Integer getOfficeid() {
        return officeid;
    }

    public void setOfficeid(Integer officeid) {
        this.officeid = officeid;
    }

    public String getOfficename() {
        return officename;
    }

    public void setOfficename(String officename) {
        this.officename = officename == null ? null : officename.trim();
    }
}