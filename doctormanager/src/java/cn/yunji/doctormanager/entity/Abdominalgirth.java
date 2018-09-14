package cn.yunji.doctormanager.entity;
import java.util.Date;
public class Abdominalgirth {
    private Integer agid;

    private String mid;

    private String abdominalgirth;

    private Date agdate;

    public Integer getAgid() {
        return agid;
    }

    public void setAgid(Integer agid) {
        this.agid = agid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public String getAbdominalgirth() {
        return abdominalgirth;
    }

    public void setAbdominalgirth(String abdominalgirth) {
        this.abdominalgirth = abdominalgirth == null ? null : abdominalgirth.trim();
    }

    public Date getAgdate() {
        return agdate;
    }

    public void setAgdate(Date agdate) {
        this.agdate = agdate;
    }
}