package cn.yunji.doctormanager.entity;

public class Exercise {
    private Integer exerciseid;

    private String exercisename;

    private String attribute;

    private String filtercondition;

    private String effect;

    private Integer exercisetype;

    private String taboo;

    public Integer getExerciseid() {
        return exerciseid;
    }

    public void setExerciseid(Integer exerciseid) {
        this.exerciseid = exerciseid;
    }

    public String getExercisename() {
        return exercisename;
    }

    public void setExercisename(String exercisename) {
        this.exercisename = exercisename == null ? null : exercisename.trim();
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute == null ? null : attribute.trim();
    }

    public String getFiltercondition() {
        return filtercondition;
    }

    public void setFiltercondition(String filtercondition) {
        this.filtercondition = filtercondition == null ? null : filtercondition.trim();
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect == null ? null : effect.trim();
    }

    public Integer getExercisetype() {
        return exercisetype;
    }

    public void setExercisetype(Integer exercisetype) {
        this.exercisetype = exercisetype;
    }

    public String getTaboo() {
        return taboo;
    }

    public void setTaboo(String taboo) {
        this.taboo = taboo == null ? null : taboo.trim();
    }
}