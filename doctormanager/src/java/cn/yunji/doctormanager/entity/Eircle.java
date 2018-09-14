package cn.yunji.doctormanager.entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;



 public class Eircle {
 private   Integer  eid;
 private  String title;
 private  String   content;
 private  Integer userId;
 @DateTimeFormat(pattern="yyyy-MM-dd  HH:mm:ss") 
 @JsonFormat(pattern="yyyy-MM-dd  HH:mm:ss",timezone = "GMT+8")
 private  Date eDate;
 private  String  praise;
 private  List<ReturnCard> rec;
 private String avatar;
 
 
 
public String getAvatar() {
	return avatar;
}
public void setAvatar(String avatar) {
	this.avatar = avatar;
}
public List<ReturnCard> getRec() {
	return rec;
}
public void setRec(List<ReturnCard> rec) {
	this.rec = rec;
}
public Eircle() {
	super();
}
public Integer getEid() {
	return eid;
}
public void setEid(Integer eid) {
	this.eid = eid;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}


public Date geteDate() {
	return eDate;
}
public void seteDate(Date eDate) {
	this.eDate = eDate;
}
public String getPraise() {
	return praise;
}
public void setPraise(String praise) {
	this.praise = praise;
}

public Eircle(Integer eid, String title, String content, Integer userId,Date eDate, String praise) {
	super();
	this.eid = eid;
	this.title = title;
	this.content = content;
	this.userId = userId;
	this.eDate = eDate;
	this.praise = praise;
}


public Eircle(Integer eid, Integer userId, String praise) {
	super();
	this.eid = eid;
	this.userId = userId;
	this.praise = praise;
}

}
