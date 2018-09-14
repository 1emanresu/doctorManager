package cn.yunji.doctormanager.entity;

public class MyIntegral {
    private Integer iid;

    private Integer userid;

    private String gaintime;

    private String iitandard;

    private Integer patienttype;

    private Integer conversionitandard;

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getGaintime() {
        return gaintime;
    }

    public void setGaintime(String gaintime) {
        this.gaintime = gaintime == null ? null : gaintime.trim();
    }

    public String getIitandard() {
        return iitandard;
    }

    public void setIitandard(String iitandard) {
        this.iitandard = iitandard == null ? null : iitandard.trim();
    }

    public Integer getPatienttype() {
        return patienttype;
    }

    public void setPatienttype(Integer patienttype) {
        this.patienttype = patienttype;
    }

    public Integer getConversionitandard() {
        return conversionitandard;
    }

    public void setConversionitandard(Integer conversionitandard) {
        this.conversionitandard = conversionitandard;
    }
}