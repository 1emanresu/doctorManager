package cn.yunji.doctormanager.entity;

public class WeeklyNursing {
    private Integer wid;

    private Integer week;

    private String weeklynursing;

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

    public String getWeeklynursing() {
        return weeklynursing;
    }

    public void setWeeklynursing(String weeklynursing) {
        this.weeklynursing = weeklynursing == null ? null : weeklynursing.trim();
    }
}