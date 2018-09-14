package cn.yunji.doctormanager.entity;

import java.util.Date;

public class Urine {
    private Integer bid;

    private String mid;

    private Integer checkprojectid;

    private Date bdate;

    private String leu;

    private String nit;

    private String glu;

    private String bil;

    private String vc;

    private String ph;

    private String bld;

    private String ket;

    private String ubg;

    private String pro;

    private String sg;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Integer getCheckprojectid() {
        return checkprojectid;
    }

    public void setCheckprojectid(Integer checkprojectid) {
        this.checkprojectid = checkprojectid;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public String getLeu() {
        return leu;
    }

    public void setLeu(String leu) {
        this.leu = leu == null ? null : leu.trim();
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit == null ? null : nit.trim();
    }

    public String getGlu() {
        return glu;
    }

    public void setGlu(String glu) {
        this.glu = glu == null ? null : glu.trim();
    }

    public String getBil() {
        return bil;
    }

    public void setBil(String bil) {
        this.bil = bil == null ? null : bil.trim();
    }

    public String getVc() {
        return vc;
    }

    public void setVc(String vc) {
        this.vc = vc == null ? null : vc.trim();
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph == null ? null : ph.trim();
    }

    public String getBld() {
        return bld;
    }

    public void setBld(String bld) {
        this.bld = bld == null ? null : bld.trim();
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket == null ? null : ket.trim();
    }

    public String getUbg() {
        return ubg;
    }

    public void setUbg(String ubg) {
        this.ubg = ubg == null ? null : ubg.trim();
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro == null ? null : pro.trim();
    }

    public String getSg() {
        return sg;
    }

    public void setSg(String sg) {
        this.sg = sg == null ? null : sg.trim();
    }
}