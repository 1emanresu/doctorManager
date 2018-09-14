package cn.yunji.doctormanager.entity;

public class SymptomProblem {
    private Integer spid;

    private Integer sweeks;

    private Integer eweeks;

    private String problem;

    private String answer;

    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
    }

    public Integer getSweeks() {
        return sweeks;
    }

    public void setSweeks(Integer sweeks) {
        this.sweeks = sweeks;
    }

    public Integer getEweeks() {
        return eweeks;
    }

    public void setEweeks(Integer eweeks) {
        this.eweeks = eweeks;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem == null ? null : problem.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }
}