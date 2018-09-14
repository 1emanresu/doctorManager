package cn.yunji.doctormanager.entity;

public class PsychologyEssentials {
    private Integer id;

    private String dealwith;

    private String essentialsname;

    private String essentialsdescribe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDealwith() {
        return dealwith;
    }

    public void setDealwith(String dealwith) {
        this.dealwith = dealwith == null ? null : dealwith.trim();
    }

    public String getEssentialsname() {
        return essentialsname;
    }

    public void setEssentialsname(String essentialsname) {
        this.essentialsname = essentialsname == null ? null : essentialsname.trim();
    }

    public String getEssentialsdescribe() {
        return essentialsdescribe;
    }

    public void setEssentialsdescribe(String essentialsdescribe) {
        this.essentialsdescribe = essentialsdescribe == null ? null : essentialsdescribe.trim();
    }
}