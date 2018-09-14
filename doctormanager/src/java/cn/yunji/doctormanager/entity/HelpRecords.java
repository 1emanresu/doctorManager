package cn.yunji.doctormanager.entity;

import java.util.Date;

public class HelpRecords {
    private Integer logid;

    private String senderid;

    private String receiverid;

    private Integer logStuta;

    private String sendcontent;

    private Integer filetype;

    private Date senddate;

    public Integer getLogid() {
        return logid;
    }

    public void setLogid(Integer logid) {
        this.logid = logid;
    }

    public String getSenderid() {
        return senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid == null ? null : senderid.trim();
    }

    public String getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(String receiverid) {
        this.receiverid = receiverid == null ? null : receiverid.trim();
    }

    public Integer getLogStuta() {
        return logStuta;
    }

    public void setLogStuta(Integer logStuta) {
        this.logStuta = logStuta;
    }

    public String getSendcontent() {
        return sendcontent;
    }

    public void setSendcontent(String sendcontent) {
        this.sendcontent = sendcontent == null ? null : sendcontent.trim();
    }

    public Integer getFiletype() {
        return filetype;
    }

    public void setFiletype(Integer filetype) {
        this.filetype = filetype;
    }

    public Date getSenddate() {
        return senddate;
    }

    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }

	@Override
	public String toString() {
		return "HelpRecords [logid=" + logid + ", senderid=" + senderid + ", receiverid=" + receiverid + ", logStuta="
				+ logStuta + ", sendcontent=" + sendcontent + ", filetype=" + filetype + ", senddate=" + senddate + "]";
	}
    
}