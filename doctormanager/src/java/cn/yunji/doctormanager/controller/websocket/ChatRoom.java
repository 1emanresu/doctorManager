package cn.yunji.doctormanager.controller.websocket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.Session;

/**
 * 聊天室
 * @author oumh
 * @CreateDate 2017年11月27日 下午3:32:48
 */
public class ChatRoom {
	/** 聊天室房间号*/
	private String roomid;
	/** 所有聊天实体*/
	private CopyOnWriteArraySet<ChatServer> webSocketSet;
	/** 存在聊天室的所有用户*/
    private List<String> list;
    /** 应收到信息的所有session*/
    private Map<String,Session> routetab;
    /** 房间总人数*/
    private AtomicInteger onLineCount;
    
    public ChatRoom(String roomid){
    	this.roomid = roomid;
    	this.webSocketSet = new CopyOnWriteArraySet<>(); 
    	this.list = new ArrayList<>();
    	this.routetab = new HashMap<>();
    	this.onLineCount = new AtomicInteger();
    }

	/** 
	 * 增加一个处理服务端
	 * @param chatServer
	 * @author oumh
	 * @createDate 2017年11月27日 下午3:39:50
	 */
	public void addServer(ChatServer chatServer) {
		this.webSocketSet.add(chatServer);
		onLineCount.getAndIncrement();
	}

	/** 
	 * 增加一个在线用户
	 * @param userid
	 * @author oumh
	 * @createDate 2017年11月27日 下午3:49:06
	 */
	public void addUser(String userid) {
		this.list.add(userid);
	}

	/** 
	 * 往路由里加用户session以便发送信息
	 * @param userid
	 * @param session
	 * @author oumh
	 * @createDate 2017年11月27日 下午3:53:59
	 */
	public void addSession(String userid, Session session) {
		this.routetab.put(userid, session);
	}

	/**
	 * 
	 * 获取房间号
	 * @return
	 * @author oumh
	 * @createDate 2017年11月27日 下午3:57:22
	 */
	public String getRoomid() {
		return roomid;
	}

	/** 
	 * 获取当前房间的用户列表
	 * @return
	 * @author oumh
	 * @createDate 2017年11月27日 下午4:10:11
	 */
	public List<String> getUserList() {
		return this.list;
	}

	/** 
	 * 获取聊天室总人数包括未登录
	 * @return
	 * @author oumh
	 * @createDate 2017年11月27日 下午4:13:15
	 */
	public int getOnLineCount() {
		return this.onLineCount.get();
	}

	/** 
	 * 删除一个处理服务端
	 * @param chatServer
	 * @author oumh
	 * @createDate 2017年11月27日 下午4:24:40
	 */
	public void removeServer(ChatServer chatServer) {
		this.webSocketSet.remove(chatServer);
		onLineCount.getAndDecrement();
	}

	/** 
	 * 用一句话描述该方法做什么
	 * @param userid
	 * @author oumh
	 * @createDate 2017年11月27日 下午4:25:38
	 */
	public void removeUser(String userid) {
		this.list.remove(userid);
	}

	/** 
	 * 删除用户所在路由
	 * @param userid
	 * @author oumh
	 * @createDate 2017年11月27日 下午4:27:59
	 */
	public void removeRoutetab(String userid) {
		this.routetab.remove(userid);
	}

	/** 
	 * 根据用户id获取session
	 * @param object
	 * @return
	 * @author oumh
	 * @createDate 2017年11月27日 下午4:31:48
	 */
	public Session getSession(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * 返回所有客户服务端
	 * @return
	 * @author oumh
	 * @createDate 2017年11月27日 下午4:33:20
	 */
	public CopyOnWriteArraySet<ChatServer> getWebSocket() {
		return this.webSocketSet;
	}
		
}
