package cn.yunji.doctormanager.entity;

public class WeeklyReportBasic {
    private Integer wid;

    private Integer week;

    private String keyattention;

    private String antenatalitem;

    private String symptom;

    private String exerciseyes;

    private String exerciseno;

    private String nursingessentials;

    private String psycholoyessentials;

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public String getKeyattention() {
        return keyattention;
    }

    public void setKeyattention(String keyattention) {
        this.keyattention = keyattention == null ? null : keyattention.trim();
    }

    public String getAntenatalitem() {
        return antenatalitem;
    }

    public void setAntenatalitem(String antenatalitem) {
        this.antenatalitem = antenatalitem == null ? null : antenatalitem.trim();
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom == null ? null : symptom.trim();
    }

    public String getExerciseyes() {
        return exerciseyes;
    }

    public void setExerciseyes(String exerciseyes) {
        this.exerciseyes = exerciseyes == null ? null : exerciseyes.trim();
    }

    public String getExerciseno() {
        return exerciseno;
    }

    public void setExerciseno(String exerciseno) {
        this.exerciseno = exerciseno == null ? null : exerciseno.trim();
    }

    public String getNursingessentials() {
        return nursingessentials;
    }

    public void setNursingessentials(String nursingessentials) {
        this.nursingessentials = nursingessentials == null ? null : nursingessentials.trim();
    }

    public String getPsycholoyessentials() {
        return psycholoyessentials;
    }

    public void setPsycholoyessentials(String psycholoyessentials) {
        this.psycholoyessentials = psycholoyessentials == null ? null : psycholoyessentials.trim();
    }
}