package cn.yunji.doctormanager.controller.websocket;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.alibaba.fastjson.JSONObject;

/**
 * spring websocket 服务
 * @author oumh
 * @CreateDate 2017年11月1日 下午5:14:47
 */
@ServerEndpoint(value="/webchat",configurator = HttpSessionConfigurator.class)
public class ChatServer {
	/** 所有房间集*/
	private static ConcurrentHashMap<String, ChatRoom> chatRooms = new ConcurrentHashMap<>();
	/** 当前连接聊天室*/
	private ChatRoom currentChatRoom;
	/** 当前与客户端的session*/
    private Session session;
    /** 当前session对应用户名*/
    private String userid;
    /** 请求的session*/
    private HttpSession httpSession;
    /**
     * 
     * 连接成功调用的方法
     * @param session
     * @param config
     * @author oumh
     * @createDate 2017年11月1日 下午5:44:19
     */
    @OnOpen
    public void odOpen(Session session , EndpointConfig config){
    	this.session = session;//给客户端发送信息的回话
    	this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
    	Map<String,List<String>> requestParameterMap = session.getRequestParameterMap();
    	List<String> roomidList =  requestParameterMap.get("roomid");//房间号
    	List<String> userName=requestParameterMap.get("username");
    	//System.out.println("userName:"+userName.toString());
    	if(roomidList.size()>0){
    		this.currentChatRoom = chatRooms.get(roomidList.get(0));
    		if(this.currentChatRoom == null){
    			this.currentChatRoom = new ChatRoom(roomidList.get(0));
    			chatRooms.put(roomidList.get(0), this.currentChatRoom);
        		this.currentChatRoom = chatRooms.get(roomidList.get(0));
    		}
    		this.currentChatRoom.addServer(this);
    		//2017-11-27 增加userid非空传参判断 wanghp
    		String userid="";
    		if(this.httpSession!=null){
    		    userid=(String) this.httpSession.getAttribute("userid");
    		}
            if(userid=="" || userid == null){
                userid=userName.get(0);//用户名
            }
          //  System.out.println("userid:"+userid);
    		this.userid = userid;
    		this.currentChatRoom.addSession(this.userid,this.session);
        
        	
        	this.currentChatRoom.addUser(this.userid);
        	String message = 
        			getMessage(
        					"[" + userid + "]加入聊天室,当前在线人数为"+this.currentChatRoom.getOnLineCount()+"位", 
        					"notice",  
        					this.currentChatRoom.getUserList()
        					);
        	broadcast(message);//广播
    	}else{
    		
    	}

    }
    /**
     * 
     * 当连接关闭是调用
     * @author oumh
     * @createDate 2017年11月1日 下午5:52:58
     */
    @OnClose
    public void onClose(){
    	this.currentChatRoom.removeServer(this);
    	this.currentChatRoom.removeUser(userid);
    	this.currentChatRoom.removeRoutetab(userid);
        String message = getMessage(
        		"[" + userid +"]离开了聊天室,当前在线人数为"+this.currentChatRoom.getOnLineCount()+"位",
        		"notice", 
        		this.currentChatRoom.getUserList()
        		);
        broadcast(message);
    }

    /**
     * 
     * 当接收到信息时调用的方法
     * @param _message
     * @author oumh
     * @createDate 2017年11月1日 下午7:08:45
     */
    @OnMessage
    public void onMessage(String _message){
    	JSONObject chat = JSONObject.parseObject(_message);
    	JSONObject message = JSONObject.parseObject(chat.get("message").toString());
    	if(message.get("to") == null || "".equals(message.get("to"))){//to为空则广播
    		broadcast(_message);
    	}else{
    		String[] userList = message.get("to").toString().split(",");
    		singleSend(_message,(Session)this.currentChatRoom.getSession(message.get("from")));
    		for(String user : userList ){
    			if(!user.equals(message.get("from"))){
    				singleSend(_message, (Session)this.currentChatRoom.getSession(message.get("to")));
    			}
    		}
    	}
    }
    
    /** 
	 * 给特定用户发信息
	 * @param _message
	 * @param session2
	 * @author oumh
	 * @createDate 2017年11月1日 下午7:03:43
	 */
	private void singleSend(String _message, Session session) {
		try {
			session.getBasicRemote().sendText(_message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
     * 
     * 连接出错时调用
     * @param error
     * @author oumh
     * @createDate 2017年11月1日 下午5:54:59
     */
    @OnError
    public void onError(Throwable error){
    	error.printStackTrace();
    }

	/** 
	 * 广播信息
	 * @param message
	 * @author oumh
	 * @createDate 2017年11月1日 下午5:39:54
	 */
	private void broadcast(String message) {
        for(ChatServer chat: this.currentChatRoom.getWebSocket()){
            try {
                chat.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
	}

	/** 
	 * Json对象转为String
	 * @param string
	 * @param string2
	 * @param list2
	 * @return
	 * @author oumh
	 * @createDate 2017年11月1日 下午5:36:30
	 */
	private String getMessage(String message, String type, List<String> list) {
        JSONObject member = new JSONObject();
        member.put("message", message);
        member.put("type", type);
        member.put("list", list);
        return member.toString();
	}
	
}
