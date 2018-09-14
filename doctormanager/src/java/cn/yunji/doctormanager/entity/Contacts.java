package cn.yunji.doctormanager.entity;

public class Contacts {
    private Integer contid;

    private String mid;

    private Integer relationid;

    private String contname;

    private String contphone;

    public Integer getContid() {
        return contid;
    }

    public void setContid(Integer contid) {
        this.contid = contid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Integer getRelationid() {
        return relationid;
    }

    public void setRelationid(Integer relationid) {
        this.relationid = relationid;
    }

    public String getContname() {
        return contname;
    }

    public void setContname(String contname) {
        this.contname = contname == null ? null : contname.trim();
    }

    public String getContphone() {
        return contphone;
    }

    public void setContphone(String contphone) {
        this.contphone = contphone == null ? null : contphone.trim();
    }
}