package cn.yunji.doctormanager.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FetalException {

	private Integer feid;

	private Integer fetalheartid;

	private String mid;

	private Integer fetaldataid;
	//胎心基线
	private Integer  basevalue;
    //异常类型 0:心动过速，1：心速过缓，2：胎心加速，3：胎心减速，4：胎动，5：宫缩'
	private Integer type;
	//二级类型，若type=3 胎心减速，dtype  0：早期减速，1：晚期减速，2：变异减速，3：中度变异减速，4：重度变异减速，5：延长减速
	private Integer dtype;
	//出现类型现象的起点索引
	private int first;
	//出现类型现象的终点索引
	private Integer endindex;
	//出现峰值的索引
	private int peak;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date starttime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endtime;

	private Integer max;

	private Integer min;

	private Integer changevalue;

	private Integer risetime;

	private String decs;

	public Integer getBasevalue() {
		return basevalue;
	}

	public void setBasevalue(Integer basevalue) {
		this.basevalue = basevalue;
	}

	public FetalException(Integer basevalue) {
		super();
		this.basevalue = basevalue;
	}

	public Integer getFeid() {
		return feid;
	}

	public void setFeid(Integer feid) {
		this.feid = feid;
	}

	public Integer getDtype() {
		return dtype;
	}

	public void setDtype(Integer dtype) {
		this.dtype = dtype;
	}

	public int getPeak() {
		return peak;
	}

	public void setPeak(int peak) {
		this.peak = peak;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public Integer getChangevalue() {
		return changevalue;
	}

	public void setChangevalue(Integer changevalue) {
		this.changevalue = changevalue;
	}

	public Integer getRisetime() {
		return risetime;
	}

	public void setRisetime(Integer risetime) {
		this.risetime = risetime;
	}

	public String getDecs() {
		return decs;
	}

	public void setDecs(String decs) {
		this.decs = decs == null ? null : decs.trim();
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}


	public Integer getFetaldataid() {
		return fetaldataid;
	}

	public void setFetaldataid(Integer fetaldataid) {
		this.fetaldataid = fetaldataid;
	}

	public Integer getEndindex() {
		return endindex;
	}

	public void setEndindex(Integer endindex) {
		this.endindex = endindex;
	}

	public FetalException(Integer type, int peak) {
		super();
		this.type = type;
		this.peak = peak;
	}

	public FetalException() {
		super();
	}
}