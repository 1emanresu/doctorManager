package cn.yunji.doctormanager.controller.websocket;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * 
 * 用一句话描述这个类的作用
 * @author oumh
 * @CreateDate 2017年11月1日 下午7:54:51
 */
public class HttpSessionConfigurator extends ServerEndpointConfig.Configurator  {
    @Override
    public void modifyHandshake(ServerEndpointConfig config, HandshakeRequest request, HandshakeResponse response){
    	//System.out.println(request.toString());
        HttpSession httpSession = (HttpSession)request.getHttpSession();
        if(httpSession == null){
        	//System.out.println("为空啦！！！！！！！！！！");
        	return;
        }
        config.getUserProperties().put(HttpSession.class.getName(),httpSession);
    }
}
