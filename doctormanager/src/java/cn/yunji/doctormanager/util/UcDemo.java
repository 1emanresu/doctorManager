package cn.yunji.doctormanager.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.yunji.doctormanager.entity.FetalException;


public class UcDemo {
	private List<Date> xList=new ArrayList<>();
	private List<Integer> yList=new ArrayList<>();
	private List<Integer> List=new ArrayList<>();//索引值
	private List<Double> difList=new ArrayList<>();//导数
	private List<Double> fitList=new ArrayList<>();//拟合函数值
	private List<Double> plist=new ArrayList<>();//平滑函数值
	private List<Double> baseline=new ArrayList<>();//基线
	private List<FetalException> Msglist=new ArrayList<>();//记录具体信息
	public UcDemo(List<Integer> list,List<Integer> yList) {
		super();
	    this.List=list;
		this.yList = yList;
	}
	public UcDemo(List<Integer> yList) {
		super();
	  
		this.yList = yList;
	}
	public UcDemo() {
		super();
	}

	public List<FetalException> getMsglist() {
		return Msglist;
	}

	public void setMsglist(List<FetalException> msglist) {
		Msglist = msglist;
	}

	public List<Integer> getList() {
		return List;
	}

	public void setList(List<Integer> list) {
		List = list;
	}

	public List<Date> getxList() {
		return xList;
	}
	public void setxList(List<Date> xList) {
		this.xList = xList;
	}
	public List<Integer> getyList() {
		return yList;
	}
	public void setyList(List<Integer> yList) {
		this.yList = yList;
	}
	public List<Double> getDifList() {
		return difList;
	}
	public void setDifList(List<Double> difList) {
		this.difList = difList;
	}
	public List<Double> getFitList() {
		return fitList;
	}
	public void setFitList(List<Double> fitList) {
		this.fitList = fitList;
	}
	public List<Double> getPlist() {
		return plist;
	}
	public void setPlist(List<Double> plist) {
		this.plist = plist;
	}
	public List<Double> getBaseline() {
		return baseline;
	}
	public void setBaseline(List<Double> baseline) {
		this.baseline = baseline;
	}
	
}
