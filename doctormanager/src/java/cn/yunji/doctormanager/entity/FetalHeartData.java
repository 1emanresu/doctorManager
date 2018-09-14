package cn.yunji.doctormanager.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FetalHeartData {
    private Integer fdid;

    private Integer fetalheartid;

    private String mid;
    //胎心数据
    private String fhrlist;
    //胎心数据
    private int[] FHlistArr;
    //胎动数据
    private String fmlist;
    //胎动数据
    private int[] FMlistArr;
    //宫缩数据
    private String uclist;
    //宫缩数据
    private int[] UClistArr;
    
    private Integer t;
    //胎监开始时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date starttime;
    //胎监结束时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endtime;
    //胎监时长（秒）
    private Integer lengthtime;
    //胎心音
    private String audio;

    public Integer getFdid() {
        return fdid;
    }

    public void setFdid(Integer fdid) {
        this.fdid = fdid;
    }

    public Integer getFetalheartid() {
        return fetalheartid;
    }

    public void setFetalheartid(Integer fetalheartid) {
        this.fetalheartid = fetalheartid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public String getFhrlist() {
        return fhrlist;
    }

    public void setFhrlist(String fhrlist) {
        this.fhrlist = fhrlist == null ? null : fhrlist.trim();
    }

    public String getFmlist() {
        return fmlist;
    }

    public void setFmlist(String fmlist) {
        this.fmlist = fmlist == null ? null : fmlist.trim();
    }

    public String getUclist() {
        return uclist;
    }

    public void setUclist(String uclist) {
        this.uclist = uclist == null ? null : uclist.trim();
    }

    public Integer getT() {
        return t;
    }

    public void setT(Integer t) {
        this.t = t;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getLengthtime() {
        return lengthtime;
    }

    public void setLengthtime(Integer lengthtime) {
        this.lengthtime = lengthtime;
    }

	public int[] getFHlistArr() {
		return FHlistArr;
	}

	public void setFHlistArr(int[] fHlistArr) {
		FHlistArr = fHlistArr;
	}

	public int[] getFMlistArr() {
		return FMlistArr;
	}

	public void setFMlistArr(int[] fMlistArr) {
		FMlistArr = fMlistArr;
	}

	public int[] getUClistArr() {
		return UClistArr;
	}

	public void setUClistArr(int[] uClistArr) {
		UClistArr = uClistArr;
	}

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }


}