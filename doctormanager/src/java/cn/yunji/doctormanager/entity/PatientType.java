package cn.yunji.doctormanager.entity;

public class PatientType {
    private Integer patienttypeid;

    private String patienttypename;

    public Integer getPatienttypeid() {
        return patienttypeid;
    }

    public void setPatienttypeid(Integer patienttypeid) {
        this.patienttypeid = patienttypeid;
    }

    public String getPatienttypename() {
        return patienttypename;
    }

    public void setPatienttypename(String patienttypename) {
        this.patienttypename = patienttypename == null ? null : patienttypename.trim();
    }
}