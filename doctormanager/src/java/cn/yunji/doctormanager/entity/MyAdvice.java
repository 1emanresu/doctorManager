package cn.yunji.doctormanager.entity;

public class MyAdvice {
    private Integer myadviceid;

    private Integer riskfactorid;

    private Integer cid;

    private Integer doctorid;

    private String myknowledge;

    public Integer getMyadviceid() {
        return myadviceid;
    }

    public void setMyadviceid(Integer myadviceid) {
        this.myadviceid = myadviceid;
    }

    public Integer getRiskfactorid() {
        return riskfactorid;
    }

    public void setRiskfactorid(Integer riskfactorid) {
        this.riskfactorid = riskfactorid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public String getMyknowledge() {
        return myknowledge;
    }

    public void setMyknowledge(String myknowledge) {
        this.myknowledge = myknowledge == null ? null : myknowledge.trim();
    }
}