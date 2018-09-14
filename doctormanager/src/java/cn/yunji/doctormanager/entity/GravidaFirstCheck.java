package cn.yunji.doctormanager.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class GravidaFirstCheck {
    private Integer gfcid;

    private String mid;

    private Integer weight;

    private Integer dpressure;

    private Integer spressure;

    private Integer heart;

    private Integer lung;

    private Integer vulva;

    private Integer cervixuteri;

    private Integer vagina;

    private Integer uterus;
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    private Date checkdate;

    private String complaint;
   

    public Integer getGfcid() {
        return gfcid;
    }

    public void setGfcid(Integer gfcid) {
        this.gfcid = gfcid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getDpressure() {
        return dpressure;
    }

    public void setDpressure(Integer dpressure) {
        this.dpressure = dpressure;
    }

    public Integer getSpressure() {
        return spressure;
    }

    public void setSpressure(Integer spressure) {
        this.spressure = spressure;
    }

    public Integer getHeart() {
        return heart;
    }

    public void setHeart(Integer heart) {
        this.heart = heart;
    }

    public Integer getLung() {
        return lung;
    }

    public void setLung(Integer lung) {
        this.lung = lung;
    }

    public Integer getVulva() {
        return vulva;
    }

    public void setVulva(Integer vulva) {
        this.vulva = vulva;
    }

    public Integer getCervixuteri() {
        return cervixuteri;
    }

    public void setCervixuteri(Integer cervixuteri) {
        this.cervixuteri = cervixuteri;
    }

    public Integer getVagina() {
        return vagina;
    }

    public void setVagina(Integer vagina) {
        this.vagina = vagina;
    }

    public Integer getUterus() {
        return uterus;
    }

    public void setUterus(Integer uterus) {
        this.uterus = uterus;
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint == null ? null : complaint.trim();
    }
}