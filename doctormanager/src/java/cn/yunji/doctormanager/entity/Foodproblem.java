package cn.yunji.doctormanager.entity;

public class Foodproblem {
    private Integer fpid;

    private String problem;

    private String answera;

    public Integer getFpid() {
        return fpid;
    }

    public void setFpid(Integer fpid) {
        this.fpid = fpid;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem == null ? null : problem.trim();
    }

    public String getAnswera() {
        return answera;
    }

    public void setAnswera(String answera) {
        this.answera = answera == null ? null : answera.trim();
    }
}