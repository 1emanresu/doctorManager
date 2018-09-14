package cn.yunji.doctormanager.entity;

public class HighriskProblem {
    private Integer highriskproblemid;

    private String highriskproblem;

    private Integer problemscore;

    public Integer getHighriskproblemid() {
        return highriskproblemid;
    }

    public void setHighriskproblemid(Integer highriskproblemid) {
        this.highriskproblemid = highriskproblemid;
    }

    public String getHighriskproblem() {
        return highriskproblem;
    }

    public void setHighriskproblem(String highriskproblem) {
        this.highriskproblem = highriskproblem == null ? null : highriskproblem.trim();
    }

    public Integer getProblemscore() {
        return problemscore;
    }

    public void setProblemscore(Integer problemscore) {
        this.problemscore = problemscore;
    }
}