package cn.yunji.doctormanager.entity;

import java.util.Date;

public class CommentReply {
    private Integer crid;

    private Integer pid;

    private Integer userid;

    private String replycontent;

    private Date replydate;

    public Integer getCrid() {
        return crid;
    }

    public void setCrid(Integer crid) {
        this.crid = crid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getReplycontent() {
        return replycontent;
    }

    public void setReplycontent(String replycontent) {
        this.replycontent = replycontent == null ? null : replycontent.trim();
    }

    public Date getReplydate() {
        return replydate;
    }

    public void setReplydate(Date replydate) {
        this.replydate = replydate;
    }
}