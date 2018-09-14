package cn.yunji.doctormanager.entity;

public class UserRole {
    private Integer userroleid;

    private Integer userid;

  private Integer roleid;
  private  Role  role;
  

    public Role getRole() {
	return role;
}

public void setRole(Role role) {
	this.role = role;
}

	public Integer getUserroleid() {
        return userroleid;
    }

    public void setUserroleid(Integer userroleid) {
        this.userroleid = userroleid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

	@Override
	public String toString() {
		return "UserRole [userroleid=" + userroleid + ", userid=" + userid + ", roleid=" + roleid + ", role=" + role
				+ "]";
	}
    
    
}