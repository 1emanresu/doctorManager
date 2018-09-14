package cn.yunji.doctormanager.entity;

public class UserInfo {

	
	private String 	accid;		//网易云通信ID，最大长度32字符
	private String 	name;		//网易云通信ID昵称，最大长度64字符
	private String 	props;		//json属性，第三方可选填，最大长度1024字符
	private String 	icon;		//网易云通信ID头像URL
	private String 	token;		//网易云通信ID可以指定登录token值
	private String 	sign;		//用户签名，最大长度256字符
	private String 	email;		//用户email，最大长度64字符
	private String 	birth;		//用户生日，最大长度16字符
	private String 	mobile;		//用户mobile，最大长度32字符，只支持国内号码
	private Integer gender=0;	//用户性别，0表示未知，1表示男，2女表示女，其它会报参数错误
	private String 	ex;			//用户名片扩展字段，最大长度1024字符，用户可自行扩展，建议封装成JSON字符串
	public String getAccid() {
		return accid;
	}
	public void setAccid(String accid) {
		this.accid = accid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProps() {
		return props;
	}
	public void setProps(String props) {
		this.props = props;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getEx() {
		return ex;
	}
	public void setEx(String ex) {
		this.ex = ex;
	}


	

}
