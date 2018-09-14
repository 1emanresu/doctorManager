package cn.yunji.doctormanager.entity;

public class Antenatal_Item {
    private Integer itemid;

    private String antenatalbeginweeks;

    private String itemname;

    private Integer checkprojectid;

    private String antenatalendweeks;
    
    private Integer checktype;

    public Integer getChecktype() {
        return checktype;
    }

    public void setChecktype(Integer checktype) {
        this.checktype = checktype;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public String getAntenatalbeginweeks() {
        return antenatalbeginweeks;
    }

    public void setAntenatalbeginweeks(String antenatalbeginweeks) {
        this.antenatalbeginweeks = antenatalbeginweeks == null ? null : antenatalbeginweeks.trim();
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    public Integer getCheckprojectid() {
        return checkprojectid;
    }

    public void setCheckprojectid(Integer checkprojectid) {
        this.checkprojectid = checkprojectid;
    }

    public String getAntenatalendweeks() {
        return antenatalendweeks;
    }

    public void setAntenatalendweeks(String antenatalendweeks) {
        this.antenatalendweeks = antenatalendweeks == null ? null : antenatalendweeks.trim();
    }
}