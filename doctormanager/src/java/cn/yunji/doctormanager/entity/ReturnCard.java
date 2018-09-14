package cn.yunji.doctormanager.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReturnCard {
private  Integer rId;
private Integer  eId;
private String rcontent;
private Integer  userId;
@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
@DateTimeFormat(pattern="yyyy-MM-dd") 
private   Date  eDate;






public ReturnCard(Integer eId, String rcontent, Integer userId, Date eDate) {
	super();
	this.eId = eId;
	this.rcontent = rcontent;
	this.userId = userId;
	this.eDate = eDate;
}
public ReturnCard(Integer rId, Integer eId, String rcontent, Integer userId, Date eDate) {
	super();
	this.rId = rId;
	this.eId = eId;
	this.rcontent = rcontent;
	this.userId = userId;
	this.eDate = eDate;
}
public Integer getrId() {
	return rId;
}
public void setrId(Integer rId) {
	this.rId = rId;
}
public Integer geteId() {
	return eId;
}
public void seteId(Integer eId) {
	this.eId = eId;
}
public String getRcontent() {
	return rcontent;
}
public void setRcontent(String rcontent) {
	this.rcontent = rcontent;
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public  Date geteDate() {
	return eDate;
}
public void seteDate(Date eDate) {
	this.eDate = eDate;
}
@Override
public String toString() {
	return "ReturnCard [rId=" + rId + ", eId=" + eId + ", rcontent=" + rcontent + ", userId=" + userId + ", eDate="
			+ eDate + "]";
}

	

}
