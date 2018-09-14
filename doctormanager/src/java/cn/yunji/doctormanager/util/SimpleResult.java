package cn.yunji.doctormanager.util;
/**
 * 图片上传
 * @author Wangzw
 *
 */
public class SimpleResult {
	private boolean success;
	private String msg;
	
	public SimpleResult() {
		success = true;
	}
	
	public SimpleResult(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public boolean getSuccess() {
		return success;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}
	
	@Override
	public String toString() {
		return "Result [success " + success + " message " + msg + "]";
	}
}
