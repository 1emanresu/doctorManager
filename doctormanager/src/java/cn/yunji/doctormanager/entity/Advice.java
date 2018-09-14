package cn.yunji.doctormanager.entity;

import java.util.Date;

public class Advice {
	private Integer adid;

    private Integer userid;

    private String theme;

    private String content;

    private String phone;

    private Date adate;

    public Integer getAdid() {
        return adid;
    }

    public void setAdid(Integer adid) {
        this.adid = adid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getAdate() {
        return adate;
    }

    public void setAdate(Date adate) {
        this.adate = adate;
    }
}