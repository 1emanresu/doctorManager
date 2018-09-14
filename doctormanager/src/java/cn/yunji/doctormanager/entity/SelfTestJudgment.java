package cn.yunji.doctormanager.entity;

public class SelfTestJudgment {
    private Integer sid;

    private Integer qid;

    private String sname;

    private String judgment;

    private String illustration;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getJudgment() {
        return judgment;
    }

    public void setJudgment(String judgment) {
        this.judgment = judgment == null ? null : judgment.trim();
    }

    public String getIllustration() {
        return illustration;
    }

    public void setIllustration(String illustration) {
        this.illustration = illustration == null ? null : illustration.trim();
    }
}