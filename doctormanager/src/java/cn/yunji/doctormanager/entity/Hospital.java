package cn.yunji.doctormanager.entity;

public class Hospital {
    private String hospitalid;

    private String hospitalname;

    private String lelvel;

    private String haddress;

    private String hphone;

    private String superior;

    public String getHospitalid() {
        return hospitalid;
    }

    public void setHospitalid(String hospitalid) {
        this.hospitalid = hospitalid == null ? null : hospitalid.trim();
    }

    public String getHospitalname() {
        return hospitalname;
    }

    public void setHospitalname(String hospitalname) {
        this.hospitalname = hospitalname == null ? null : hospitalname.trim();
    }

    public String getLelvel() {
        return lelvel;
    }

    public void setLelvel(String lelvel) {
        this.lelvel = lelvel == null ? null : lelvel.trim();
    }

    public String getHaddress() {
        return haddress;
    }

    public void setHaddress(String haddress) {
        this.haddress = haddress == null ? null : haddress.trim();
    }

    public String getHphone() {
        return hphone;
    }

    public void setHphone(String hphone) {
        this.hphone = hphone == null ? null : hphone.trim();
    }

    public String getSuperior() {
        return superior;
    }

    public void setSuperior(String superior) {
        this.superior = superior == null ? null : superior.trim();
    }
}