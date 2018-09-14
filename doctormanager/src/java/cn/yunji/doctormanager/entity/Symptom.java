package cn.yunji.doctormanager.entity;

public class Symptom {
    private Integer symptomdetailid;

    private String symptomname;

    private String grade;

    private String reason;

    private String normalexpression;

    private String abnormalexpression;

    private String dispose;

    private String suggest;

    private String prevention;

    private String influence;

    private String check;

    private String disposedescription;

    public Integer getSymptomdetailid() {
        return symptomdetailid;
    }

    public void setSymptomdetailid(Integer symptomdetailid) {
        this.symptomdetailid = symptomdetailid;
    }

    public String getSymptomname() {
        return symptomname;
    }

    public void setSymptomname(String symptomname) {
        this.symptomname = symptomname == null ? null : symptomname.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getNormalexpression() {
        return normalexpression;
    }

    public void setNormalexpression(String normalexpression) {
        this.normalexpression = normalexpression == null ? null : normalexpression.trim();
    }

    public String getAbnormalexpression() {
        return abnormalexpression;
    }

    public void setAbnormalexpression(String abnormalexpression) {
        this.abnormalexpression = abnormalexpression == null ? null : abnormalexpression.trim();
    }

    public String getDispose() {
        return dispose;
    }

    public void setDispose(String dispose) {
        this.dispose = dispose == null ? null : dispose.trim();
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest == null ? null : suggest.trim();
    }

    public String getPrevention() {
        return prevention;
    }

    public void setPrevention(String prevention) {
        this.prevention = prevention == null ? null : prevention.trim();
    }

    public String getInfluence() {
        return influence;
    }

    public void setInfluence(String influence) {
        this.influence = influence == null ? null : influence.trim();
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check == null ? null : check.trim();
    }

    public String getDisposedescription() {
        return disposedescription;
    }

    public void setDisposedescription(String disposedescription) {
        this.disposedescription = disposedescription == null ? null : disposedescription.trim();
    }

    @Override
    public String toString() {
        return "Symptom [symptomdetailid=" + symptomdetailid + ", symptomname=" + symptomname + ", grade=" + grade
                + ", reason=" + reason + ", normalexpression=" + normalexpression + ", abnormalexpression="
                + abnormalexpression + ", dispose=" + dispose + ", suggest=" + suggest + ", prevention=" + prevention
                + ", influence=" + influence + ", check=" + check + ", disposedescription=" + disposedescription + "]";
    }
    
}