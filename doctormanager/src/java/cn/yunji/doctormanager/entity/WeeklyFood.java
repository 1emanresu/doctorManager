package cn.yunji.doctormanager.entity;

public class WeeklyFood {
    private Integer wid;

    private Integer week;

    private String eatyes;

    private String eatno;

    private String nutritional;

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public String getEatyes() {
        return eatyes;
    }

    public void setEatyes(String eatyes) {
        this.eatyes = eatyes == null ? null : eatyes.trim();
    }

    public String getEatno() {
        return eatno;
    }

    public void setEatno(String eatno) {
        this.eatno = eatno == null ? null : eatno.trim();
    }

    public String getNutritional() {
        return nutritional;
    }

    public void setNutritional(String nutritional) {
        this.nutritional = nutritional == null ? null : nutritional.trim();
    }
}