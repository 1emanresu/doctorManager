package cn.yunji.doctormanager.entity;

public class PregnancyCheck {
    private Integer pcheckid;

    private Integer pcid;

    private Integer dpressure;

    private Integer spressure;

    private Integer psychosis;

    private Integer intelligence;

    private Integer facialfeatures;

    private Integer specialbody;

    private Integer specialface;

    private Integer skinhair;

    private Integer thyroiddisease;

    private Integer heartrate;

    private Integer rhythmheart;

    private Integer noise;

    private Integer lung;

    private Integer liver;

    private Integer limbsspine;

    private String otherphysique;

    private Integer pubes;

    private Integer breast;

    private Integer vulva;

    private Integer cervixuteri;

    private Integer secretion;

    private Integer uterus;

    private String enclosure;

    private String other;

    public Integer getPcheckid() {
        return pcheckid;
    }

    public void setPcheckid(Integer pcheckid) {
        this.pcheckid = pcheckid;
    }

    public Integer getPcid() {
        return pcid;
    }

    public void setPcid(Integer pcid) {
        this.pcid = pcid;
    }

    public Integer getDpressure() {
        return dpressure;
    }

    public void setDpressure(Integer dpressure) {
        this.dpressure = dpressure;
    }

    public Integer getSpressure() {
        return spressure;
    }

    public void setSpressure(Integer spressure) {
        this.spressure = spressure;
    }

    public Integer getPsychosis() {
        return psychosis;
    }

    public void setPsychosis(Integer psychosis) {
        this.psychosis = psychosis;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getFacialfeatures() {
        return facialfeatures;
    }

    public void setFacialfeatures(Integer facialfeatures) {
        this.facialfeatures = facialfeatures;
    }

    public Integer getSpecialbody() {
        return specialbody;
    }

    public void setSpecialbody(Integer specialbody) {
        this.specialbody = specialbody;
    }

    public Integer getSpecialface() {
        return specialface;
    }

    public void setSpecialface(Integer specialface) {
        this.specialface = specialface;
    }

    public Integer getSkinhair() {
        return skinhair;
    }

    public void setSkinhair(Integer skinhair) {
        this.skinhair = skinhair;
    }

    public Integer getThyroiddisease() {
        return thyroiddisease;
    }

    public void setThyroiddisease(Integer thyroiddisease) {
        this.thyroiddisease = thyroiddisease;
    }

    public Integer getHeartrate() {
        return heartrate;
    }

    public void setHeartrate(Integer heartrate) {
        this.heartrate = heartrate;
    }

    public Integer getRhythmheart() {
        return rhythmheart;
    }

    public void setRhythmheart(Integer rhythmheart) {
        this.rhythmheart = rhythmheart;
    }

    public Integer getNoise() {
        return noise;
    }

    public void setNoise(Integer noise) {
        this.noise = noise;
    }

    public Integer getLung() {
        return lung;
    }

    public void setLung(Integer lung) {
        this.lung = lung;
    }

    public Integer getLiver() {
        return liver;
    }

    public void setLiver(Integer liver) {
        this.liver = liver;
    }

    public Integer getLimbsspine() {
        return limbsspine;
    }

    public void setLimbsspine(Integer limbsspine) {
        this.limbsspine = limbsspine;
    }

    public String getOtherphysique() {
        return otherphysique;
    }

    public void setOtherphysique(String otherphysique) {
        this.otherphysique = otherphysique == null ? null : otherphysique.trim();
    }

    public Integer getPubes() {
        return pubes;
    }

    public void setPubes(Integer pubes) {
        this.pubes = pubes;
    }

    public Integer getBreast() {
        return breast;
    }

    public void setBreast(Integer breast) {
        this.breast = breast;
    }

    public Integer getVulva() {
        return vulva;
    }

    public void setVulva(Integer vulva) {
        this.vulva = vulva;
    }

    public Integer getCervixuteri() {
        return cervixuteri;
    }

    public void setCervixuteri(Integer cervixuteri) {
        this.cervixuteri = cervixuteri;
    }

    public Integer getSecretion() {
        return secretion;
    }

    public void setSecretion(Integer secretion) {
        this.secretion = secretion;
    }

    public Integer getUterus() {
        return uterus;
    }

    public void setUterus(Integer uterus) {
        this.uterus = uterus;
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure == null ? null : enclosure.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    @Override
    public String toString() {
        return "PregnancyCheck [pcheckid=" + pcheckid + ", pcid=" + pcid + ", dpressure=" + dpressure + ", spressure="
                + spressure + ", psychosis=" + psychosis + ", intelligence=" + intelligence + ", facialfeatures="
                + facialfeatures + ", specialbody=" + specialbody + ", specialface=" + specialface + ", skinhair="
                + skinhair + ", thyroiddisease=" + thyroiddisease + ", heartrate=" + heartrate + ", rhythmheart="
                + rhythmheart + ", noise=" + noise + ", lung=" + lung + ", liver=" + liver + ", limbsspine="
                + limbsspine + ", otherphysique=" + otherphysique + ", pubes=" + pubes + ", breast=" + breast
                + ", vulva=" + vulva + ", cervixuteri=" + cervixuteri + ", secretion=" + secretion + ", uterus="
                + uterus + ", enclosure=" + enclosure + ", other=" + other + "]";
    }
    
}