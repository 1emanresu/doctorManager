package cn.yunji.doctormanager.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.sun.media.sound.SoftSynthesizer;

import cn.yunji.doctormanager.entity.ChartMessage;
import cn.yunji.doctormanager.entity.HelpRecords;
import net.sf.json.JSONObject;

@ServerEndpoint("/echo")
public class EchoSocket {
	private static List<String> usernames = new ArrayList<String>();
	private static List<Session> sessions = new ArrayList<Session>();
	private static Map<String, Session> sessionMap = new HashMap<String, Session>();
	private String username;
	private Session session;

	@OnOpen
	public void open(Session session) { // 打开websocket
		String string = session.getQueryString();
		this.username = string.split("=")[1];
		// 更新在线状态--上线
//		System.out.println(this.username);
		this.usernames.add(this.username);
		this.sessions.add(session);
//		System.out.println("open");
		sessionMap.put(this.username, session);
		String welcome = this.username + "已上线";
		ChartMessage message = new ChartMessage(welcome, this.usernames);
		this.broadcast(this.sessions, message.getChartMessageToJson());
	}

	@OnClose
	public void close(Session session) { // 关闭websocket
		this.sessions.remove(session);
		this.usernames.remove(this.username);
		String goMsg = this.username + "已下线";
		// 更新在线状态--离线
		ChartMessage message = new ChartMessage(goMsg, this.usernames);
		sessionMap.remove(this.username);
		this.broadcast(this.sessions, message.getChartMessageToJson());
	}

	@OnMessage
	public void message(Session session, String msg) throws ParseException {
	    //System.out.println("收到信息--》"+msg+"\nsession--》"+session.getId()+"   isOpen:"+session.isOpen());
		// 用于保存到数据库的对象
		String fileType = null;
		HelpRecords helpRecords = new HelpRecords();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		helpRecords.setSenddate(sdf.parse(time));// 发送时间
		if (session.isOpen()) {
			JSONObject msgJsonObj = JSONObject.fromObject(msg);
			ChartMessage chartMessage = (ChartMessage) JSONObject.toBean(msgJsonObj, ChartMessage.class);
			// 判断所要发送用户是否在线
			boolean bool = sessionMap.containsKey(chartMessage.getTo().get(0));
			if (bool) {
				// 用户在线的处理
				chartMessage.setUsernames(this.usernames);
				if (chartMessage.getType() == 1) {
					// type =1 单聊
					List<Session> sessionsPrivateList = new ArrayList<Session>();
					for (int i = 0; i < chartMessage.getTo().size(); i++) {
						String userChartName = chartMessage.getTo().get(i);
						sessionsPrivateList.add(sessionMap.get(userChartName));
					}
					sessionsPrivateList.add(sessionMap.get(chartMessage.getFrom()));
					String s = chartMessage.getChartMessageToJson();
					// 文件类型
					fileType = msgJsonObj.getString("fileType");
					this.broadcast(sessionsPrivateList,
							s.substring(0, s.length() - 1) + ",\"fileType\":\"" + fileType + "\"}");
					/*helpRecords.setSendcontent(msgJsonObj.getString("content"));// 发送内容
					helpRecords.setSenderid(msgJsonObj.getString("from"));// 发送人
					helpRecords.setReceiverid(chartMessage.getTo().get(0));// 接收人
					helpRecords.setFiletype(Integer.parseInt(msgJsonObj.getString("fileType")));// 文件类型
					helpRecords.setLogStuta(1);// 状态，对方不在线的情况下为0，反之为1
*/				}
			} else {
				// 不在线的处理
				List<Session> sessionsPrivateList = new ArrayList<Session>();
				sessionsPrivateList.add(session);
				// 发送到发信息本人
				String s = chartMessage.getChartMessageToJson();
				fileType = msgJsonObj.getString("fileType");
				String prompt = "用户离线状态，你发送的消息，用户将在上线时看到。";
				String hui = s.substring(0, s.length() - 1) + ",\"prompt\":\"" + prompt + "\"" + ",\"fileType\":\""
						+ fileType + "\"}";
//				System.out.println(hui);
				this.broadcast(sessionsPrivateList, hui);
				/*helpRecords.setSendcontent(msgJsonObj.getString("content"));// 发送内容
				helpRecords.setSenderid(msgJsonObj.getString("from"));// 发送人
				helpRecords.setReceiverid(chartMessage.getTo().get(0));// 接收人
				helpRecords.setFiletype(Integer.parseInt(msgJsonObj.getString("fileType")));// 文件类型
				helpRecords.setLogStuta(0);// 状态，对方不在线的情况下为0，反之为1
*/			}
			if (Integer.parseInt(fileType) != 4) {
				//this.insert(helpRecords);
			}
		}
	}

	// 做发送处理
	private void broadcast(List<Session> sessionsList, String msg) {
//		System.out.println(sessionsList.size());
		if (sessionsList.size() > 0) {
			for (int i = 0; i < sessionsList.size(); i++) {
				try {
					sessionsList.get(i).getBasicRemote().sendText(msg);
				} catch (IOException e) {
					//System.out.println("EchoSocket.java broadcast method ,发送失败 ");
					e.printStackTrace();
				}
			}
		}
	}

	// 保存信息到数据库
	public void insert(HelpRecords helpRecords) {
		try {
			HelpRecordsController helpLogController = new HelpRecordsController();
			helpLogController.insert(helpRecords);
		} catch (Exception e) {
			//System.out.println(e.getMessage());
		}
	}

	// 处理出错信息
	@OnError
	public void onError(Throwable e, Session session) {

	}

	public List<String> getUsernames() {
		return usernames;
	}

	public List<Session> getSessions() {
		return sessions;
	}
}
