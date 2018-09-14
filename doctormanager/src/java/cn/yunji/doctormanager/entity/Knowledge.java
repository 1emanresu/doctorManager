package cn.yunji.doctormanager.entity;

public class Knowledge {
    private Integer knowledgeid;

    private Integer highriskresulttypeid;

    private Integer cid;

    private String knowledge;

    public Integer getKnowledgeid() {
        return knowledgeid;
    }

    public void setKnowledgeid(Integer knowledgeid) {
        this.knowledgeid = knowledgeid;
    }

    public Integer getHighriskresulttypeid() {
        return highriskresulttypeid;
    }

    public void setHighriskresulttypeid(Integer highriskresulttypeid) {
        this.highriskresulttypeid = highriskresulttypeid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge == null ? null : knowledge.trim();
    }
}