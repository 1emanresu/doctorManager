package cn.yunji.doctormanager.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Bscan {
    private Integer bid; //B超报告编号

    private String mid; //孕妇编号

    private Integer checkprojectid; //检查项目编号

    private String hospitalname; //医院名称

    private String bpiclink; //图片链接
    
    private String piclevel;//图像等级
    
    private String bladder;//膀胱充盈度
    
    private String way;//检查途径
    
    private String checkpoint;//检查部位
    
    private String probefrequency;//探头频率

    private Integer bpd; //双顶径

    private Integer crl; //顶臂长

    private Integer femurl; //股骨长

    private Integer humerusl; //肱骨长

    private Integer fetalheartrate; //胎心率

    private Integer fetalmovement; //胎动

    private Integer fetalheart; //胎心

    private Integer amnioticfluid; //羊水

    private Integer placentalthickness; //胎盘厚度

    private Integer placentalposition; //胎盘位置

    private Integer leftovary; //左侧卵巢

    private Date checkdate; //检查时间

    private Integer rightovary; //右侧卵巢

    private BigDecimal nt; //颈项透明层厚度

    private BigDecimal nf; //颈部软组织厚度

    private Integer nasalbone; //鼻骨

    private Integer fetusnumber; //胎数

    private Integer weeks; //估计孕周

    private String bdescription; //B超检查描述

    private String btip; //B超检查提示
    
    private Integer week; //实际孕周

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Integer getCheckprojectid() {
        return checkprojectid;
    }

    public void setCheckprojectid(Integer checkprojectid) {
        this.checkprojectid = checkprojectid;
    }

    
    public String getPiclevel() {
		return piclevel;
	}

	public void setPiclevel(String piclevel) {
		this.piclevel = piclevel;
	}

	public String getBladder() {
		return bladder;
	}

	public void setBladder(String bladder) {
		this.bladder = bladder;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public String getCheckpoint() {
		return checkpoint;
	}

	public void setCheckpoint(String checkpoint) {
		this.checkpoint = checkpoint;
	}

	public String getProbefrequency() {
		return probefrequency;
	}

	public void setProbefrequency(String probefrequency) {
		this.probefrequency = probefrequency;
	}

	public String getHospitalname() {
        return hospitalname;
    }

    public void setHospitalname(String hospitalname) {
        this.hospitalname = hospitalname == null ? null : hospitalname.trim();
    }

    public String getBpiclink() {
        return bpiclink;
    }

    public void setBpiclink(String bpiclink) {
        this.bpiclink = bpiclink == null ? null : bpiclink.trim();
    }

    public Integer getBpd() {
        return bpd;
    }

    public void setBpd(Integer bpd) {
        this.bpd = bpd;
    }

    public Integer getCrl() {
        return crl;
    }

    public void setCrl(Integer crl) {
        this.crl = crl;
    }

    public Integer getFemurl() {
        return femurl;
    }

    public void setFemurl(Integer femurl) {
        this.femurl = femurl;
    }

    public Integer getHumerusl() {
        return humerusl;
    }

    public void setHumerusl(Integer humerusl) {
        this.humerusl = humerusl;
    }

    public Integer getFetalheartrate() {
        return fetalheartrate;
    }

    public void setFetalheartrate(Integer fetalheartrate) {
        this.fetalheartrate = fetalheartrate;
    }

    public Integer getFetalmovement() {
        return fetalmovement;
    }

    public void setFetalmovement(Integer fetalmovement) {
        this.fetalmovement = fetalmovement;
    }

    public Integer getFetalheart() {
        return fetalheart;
    }

    public void setFetalheart(Integer fetalheart) {
        this.fetalheart = fetalheart;
    }

    public Integer getAmnioticfluid() {
        return amnioticfluid;
    }

    public void setAmnioticfluid(Integer amnioticfluid) {
        this.amnioticfluid = amnioticfluid;
    }

    public Integer getPlacentalthickness() {
        return placentalthickness;
    }

    public void setPlacentalthickness(Integer placentalthickness) {
        this.placentalthickness = placentalthickness;
    }

    public Integer getPlacentalposition() {
        return placentalposition;
    }

    public void setPlacentalposition(Integer placentalposition) {
        this.placentalposition = placentalposition;
    }

    public Integer getLeftovary() {
        return leftovary;
    }

    public void setLeftovary(Integer leftovary) {
        this.leftovary = leftovary;
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public Integer getRightovary() {
        return rightovary;
    }

    public void setRightovary(Integer rightovary) {
        this.rightovary = rightovary;
    }

    public BigDecimal getNt() {
        return nt;
    }

    public void setNt(BigDecimal nt) {
        this.nt = nt;
    }

    public BigDecimal getNf() {
        return nf;
    }

    public void setNf(BigDecimal nf) {
        this.nf = nf;
    }

    public Integer getNasalbone() {
        return nasalbone;
    }

    public void setNasalbone(Integer nasalbone) {
        this.nasalbone = nasalbone;
    }

    public Integer getFetusnumber() {
        return fetusnumber;
    }

    public void setFetusnumber(Integer fetusnumber) {
        this.fetusnumber = fetusnumber;
    }

    public Integer getWeeks() {
        return weeks;
    }

    public void setWeeks(Integer weeks) {
        this.weeks = weeks;
    }

    public String getBdescription() {
        return bdescription;
    }

    public void setBdescription(String bdescription) {
        this.bdescription = bdescription == null ? null : bdescription.trim();
    }

    public String getBtip() {
        return btip;
    }

    public void setBtip(String btip) {
        this.btip = btip == null ? null : btip.trim();
    }

	public Integer getWeek() {
		return week;
	}

	public void setWeek(Integer week) {
		this.week = week;
	}
}