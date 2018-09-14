package cn.yunji.doctormanager.util;

import java.io.Serializable;

public class JsonResult implements Serializable{

	private static final long serialVersionUID = 812376774103405857L;
	/**
	 * 状态属性：0表示成功
	 * 1或其它表示失败
	 */
	private Integer state;
	/**
	 * 服务器处理成功返回json数据
	 */
	private Object data;
	/**
	 * 返回提示信息
	 */
	private String message;
	/**
	 *返回状态0成功1失败
	 */
	public static final int ERROR=1;
	public static final int SUCCESS=0;
	public JsonResult() {
	}
	/**
	 * @description:全参构造器
	 * @param state
	 * @param data
	 * @param message
	 */
	public JsonResult(Integer state, Object data, String message) {
		this.state = state;
		this.data = data;
		this.message = message;
	}
	/**
	 * @description:异常构造器
	 * @param e
	 */
	public JsonResult(Throwable e) {
		state=ERROR;
		data=null;
		message=e.getMessage();
	}
	/**
	 * @description:json数据构造器
	 * @param data
	 */
	public JsonResult(Object data) {
		state=SUCCESS;
		this.data=data;
		message="";
	}
	/**
	 * @description:异常状态构造器
	 * @param state
	 * @param e
	 */
	public JsonResult(int state,Throwable e){
		this.state=state;
		data=null;
		message=e.getMessage();
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", data=" + data + ", message=" + message + "]";
	}	
}
