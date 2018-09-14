package cn.yunji.doctormanager.entity;

public class NeteasyIm {
    private Integer id;

    private Integer yjuuserid;

    private String imid;

    private String impassword;

    private String imnickname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYjuuserid() {
        return yjuuserid;
    }

    public void setYjuuserid(Integer yjuuserid) {
        this.yjuuserid = yjuuserid;
    }

    public String getImid() {
        return imid;
    }

    public void setImid(String imid) {
        this.imid = imid == null ? null : imid.trim();
    }

    public String getImpassword() {
        return impassword;
    }

    public void setImpassword(String impassword) {
        this.impassword = impassword == null ? null : impassword.trim();
    }

    public String getImnickname() {
        return imnickname;
    }

    public void setImnickname(String imnickname) {
        this.imnickname = imnickname == null ? null : imnickname.trim();
    }
}