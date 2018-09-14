package cn.yunji.doctormanager.entity;

import java.util.Date;

public class UserTb {
	private Integer userid;

	private String username;

	private String password;

	private String loginstatus;

	private String nickname;

	private String avatar;
	private UserRole addUserRole;
	private Doctor doctorid;
	
	private Date createDate;
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 添加护士登录的对象 mcally.ly
	 */
	private  Nurse   nuser;
	
	
	private Integer count;
	

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	private GravidaInfo gravidaInfo;
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Nurse getNuser() {
		return nuser;
	}

	public void setNuser(Nurse nuser) {
		this.nuser = nuser;
	}

	public GravidaInfo getGravidaInfo() {
		return gravidaInfo;
	}

	public void setGravidaInfo(GravidaInfo gravidaInfo) {
		this.gravidaInfo = gravidaInfo;
	}

	public UserTb() {

	}

	public Doctor getDoctorid() {
		return doctorid;
	}

	public UserRole getAddUserRole() {
		return addUserRole;
	}

	public void setAddUserRole(UserRole addUserRole) {
		this.addUserRole = addUserRole;
	}

	public void setDoctorid(Doctor doctorid) {
		this.doctorid = doctorid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getLoginstatus() {
		return loginstatus;
	}

	public void setLoginstatus(String loginstatus) {
		this.loginstatus = loginstatus == null ? null : loginstatus.trim();
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname == null ? null : nickname.trim();
	}

	public String getImage() {
		return avatar;
	}

	public void setImage(String avatar) {
		this.avatar = avatar == null ? null : avatar.trim();
	}

	@Override
	public String toString() {
		return "UserTb [userid=" + userid + ", username=" + username + ", password=" + password + ", loginstatus="
				+ loginstatus + ", nickname=" + nickname + ", image=" + avatar + ", addUserRole=" + addUserRole
				+ ", doctorid=" + doctorid + ", gravidaInfo=" + gravidaInfo + "]";
	}

}