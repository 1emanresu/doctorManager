package cn.yunji.doctormanager.entity;

public class NursingEssentials {
    private Integer id;

    private String nursingtips;

    private String essentialsname;

    private String essentialsdescribe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNursingtips() {
        return nursingtips;
    }

    public void setNursingtips(String nursingtips) {
        this.nursingtips = nursingtips == null ? null : nursingtips.trim();
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