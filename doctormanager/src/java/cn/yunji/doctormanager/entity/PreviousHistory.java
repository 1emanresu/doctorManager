package cn.yunji.doctormanager.entity;

public class PreviousHistory {
    private Integer previousid;

    private String mid;

    private Integer heartdisease;

    private Integer tb;

    private Integer hepatopathy;

    private Integer urogenitaldiseases;

    private Integer diabetes;

    private Integer hypertension;

    private Integer psychosis;

    private Integer umpire;

    private Integer epilepsy;

    private Integer heent;

    private Integer thyroiddisease;

    private Integer hereditarydisease;

    private String other;

    public Integer getPreviousid() {
        return previousid;
    }

    public void setPreviousid(Integer previousid) {
        this.previousid = previousid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Integer getHeartdisease() {
        return heartdisease;
    }

    public void setHeartdisease(Integer heartdisease) {
        this.heartdisease = heartdisease;
    }

    public Integer getTb() {
        return tb;
    }

    public void setTb(Integer tb) {
        this.tb = tb;
    }

    public Integer getHepatopathy() {
        return hepatopathy;
    }

    public void setHepatopathy(Integer hepatopathy) {
        this.hepatopathy = hepatopathy;
    }

    public Integer getUrogenitaldiseases() {
        return urogenitaldiseases;
    }

    public void setUrogenitaldiseases(Integer urogenitaldiseases) {
        this.urogenitaldiseases = urogenitaldiseases;
    }

    public Integer getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(Integer diabetes) {
        this.diabetes = diabetes;
    }

    public Integer getHypertension() {
        return hypertension;
    }

    public void setHypertension(Integer hypertension) {
        this.hypertension = hypertension;
    }

    public Integer getPsychosis() {
        return psychosis;
    }

    public void setPsychosis(Integer psychosis) {
        this.psychosis = psychosis;
    }

    public Integer getUmpire() {
        return umpire;
    }

    public void setUmpire(Integer umpire) {
        this.umpire = umpire;
    }

    public Integer getEpilepsy() {
        return epilepsy;
    }

    public void setEpilepsy(Integer epilepsy) {
        this.epilepsy = epilepsy;
    }

    public Integer getHeent() {
        return heent;
    }

    public void setHeent(Integer heent) {
        this.heent = heent;
    }

    public Integer getThyroiddisease() {
        return thyroiddisease;
    }

    public void setThyroiddisease(Integer thyroiddisease) {
        this.thyroiddisease = thyroiddisease;
    }

    public Integer getHereditarydisease() {
        return hereditarydisease;
    }

    public void setHereditarydisease(Integer hereditarydisease) {
        this.hereditarydisease = hereditarydisease;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    @Override
    public String toString() {
        return "PreviousHistory [previousid=" + previousid + ", mid=" + mid + ", heartdisease=" + heartdisease + ", tb="
                + tb + ", hepatopathy=" + hepatopathy + ", urogenitaldiseases=" + urogenitaldiseases + ", diabetes="
                + diabetes + ", hypertension=" + hypertension + ", psychosis=" + psychosis + ", umpire=" + umpire
                + ", epilepsy=" + epilepsy + ", heent=" + heent + ", thyroiddisease=" + thyroiddisease
                + ", hereditarydisease=" + hereditarydisease + ", other=" + other + "]";
    }
    
}