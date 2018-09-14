package cn.yunji.doctormanager.entity;

public class Role {
    private Integer roleid;

    private String rtype;

   
    
    
  
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Role(Integer roleid, String rtype) {
		super();
		this.roleid = roleid;
		this.rtype = rtype;
	}




	public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRtype() {
        return rtype;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype == null ? null : rtype.trim();
    }




	@Override
	public String toString() {
		return "Role [roleid=" + roleid + ", rtype=" + rtype + "]";
	}
    
    
}