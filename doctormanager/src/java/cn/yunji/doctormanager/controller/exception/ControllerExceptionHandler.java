package cn.yunji.doctormanager.controller.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.util.JsonResult;



/**
 * 统一异常处理
 * @author oumh
 *
 */
@ControllerAdvice
public class ControllerExceptionHandler {

	/**
	 * 抓取业务异常并处理
	 * @param e 业务异常
	 * @return
	 */
	@ExceptionHandler(ServiceException.class)
	@ResponseBody
	public JsonResult handleServiceException(ServiceException e){
		e.printStackTrace();
		return new JsonResult(e);
	}
}
