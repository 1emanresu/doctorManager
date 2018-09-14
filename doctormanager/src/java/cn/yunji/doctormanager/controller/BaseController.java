package  cn.yunji.doctormanager.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.util.JsonResult;

public abstract class BaseController {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public JsonResult exceptionHandle(Exception e) {
	
		e.printStackTrace();
//		System.out.println("exceptionHandle");
		return new JsonResult(e);
	}

}