package cn.yunji.doctormanager.entity;

public class Subscribe {
    private Integer subscribeid;

    private String hospitalid;

    private String mid;

    private Integer officeid;

    private Integer doctorid;

    private Integer scount;

    private String antenatalcare;

    private String sprojectname;

    private String sdate;

    private String sdatetime;

    public Integer getSubscribeid() {
        return subscribeid;
    }

    public void setSubscribeid(Integer subscribeid) {
        this.subscribeid = subscribeid;
    }

    public String getHospitalid() {
        return hospitalid;
    }

    public void setHospitalid(String hospitalid) {
        this.hospitalid = hospitalid == null ? null : hospitalid.trim();
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Integer getOfficeid() {
        return officeid;
    }

    public void setOfficeid(Integer officeid) {
        this.officeid = officeid;
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public Integer getScount() {
        return scount;
    }

    public void setScount(Integer scount) {
        this.scount = scount;
    }

    public String getAntenatalcare() {
        return antenatalcare;
    }

    public void setAntenatalcare(String antenatalcare) {
        this.antenatalcare = antenatalcare == null ? null : antenatalcare.trim();
    }

    public String getSprojectname() {
        return sprojectname;
    }

    public void setSprojectname(String sprojectname) {
        this.sprojectname = sprojectname == null ? null : sprojectname.trim();
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate == null ? null : sdate.trim();
    }

    public String getSdatetime() {
        return sdatetime;
    }

    public void setSdatetime(String sdatetime) {
        this.sdatetime = sdatetime == null ? null : sdatetime.trim();
    }
}