package cn.yunji.doctormanager.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
/*
 * 聊天用到的
 * author:zhangqt
 * */
public class ChartMessage {
	private int type;  // 单聊 type = 1 ,type =2 群聊
	private String from;  //由谁发的
	private List<String> to; //发给谁
	private String content; //聊天内容
	private String welcome; //进聊天室和离开聊天室提示信息
	private List<String> usernames ; //用户列表名字
	private List<String> sessionUsernames;//websocket session名字
	private static Gson gson = new Gson();
	private String date;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public ChartMessage(){
		
	}
	public ChartMessage(String welcome,List<String> usernames ){
		this.welcome = welcome;
		this.usernames = usernames;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public List<String> getTo() {
		return to;
	}
	public void setTo(List<String> to) {
		this.to = to;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		this.date=time;
		this.content = content;
	}
	
	public String getChartMessageToJson(){
		return gson.toJson(this);
	}
	public List<String> getUsernames() {
		return usernames;
	}
	public void setUsernames(List<String> usernames) {
		this.usernames = usernames;
	}
	public String getWelcome() {
		return welcome;
	}
	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}
	public List<String> getSessionUsernames() {
		return sessionUsernames;
	}
	public void setSessionUsernames(List<String> sessionUsernames) {
		this.sessionUsernames = sessionUsernames;
	}
	
}
