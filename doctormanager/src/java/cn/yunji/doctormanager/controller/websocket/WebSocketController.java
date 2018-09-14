package cn.yunji.doctormanager.controller.websocket;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/websocket")
public class WebSocketController {
    
    @RequestMapping("/getUserID.do")
    @ResponseBody
    public JsonResult getUserID(HttpSession session){
        //System.out.println("开始,sessionID:"+session.getId()+"     address:"+session.getLastAccessedTime());
        String user = (String) session.getAttribute("userid");
        //System.out.println("getUser:"+user);
        return new JsonResult(user);
    }
}
