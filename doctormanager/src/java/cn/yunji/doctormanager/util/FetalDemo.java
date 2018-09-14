package cn.yunji.doctormanager.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.yunji.doctormanager.entity.FetalException;



public class FetalDemo {

	private List<Date> xList=new ArrayList<>();
	private List<Integer> yList=new ArrayList<>();
	private List<Integer> List=new ArrayList<>();//常数 x
	private List<Double> difList=new ArrayList<>();//导数
	private List<Double> fitList=new ArrayList<>();//拟合函数值
	private List<Double> prelist=new ArrayList<>();//平滑函数值
	private List<FetalException> exceptions=new ArrayList<>();//记录异常信息
	private Integer baseFHR; //胎心基线
	
	
	public Integer getBaseFHR() {
		return baseFHR;
	}
	public void setBaseFHR(Integer baseFHR) {
		this.baseFHR = baseFHR;
	}
	public void setxList(List<Date> xList) {
		this.xList = xList;
	}
	public void setyList(List<Integer> yList) {
		this.yList = yList;
	}
	public void setList(List<Integer> List) {
		this.List = List;
	}
	public List<Integer> getList() {
		return List;
	}
	
	public List<Double> getPrelist() {
		return prelist;
	}
	public void setPrelist(List<Double> prelist) {
		this.prelist = prelist;
	}
	public List<Date> getxList() {
		return xList;
	}
	public List<Integer> getyList() {
		return yList;
	}
	
	public List<FetalException> getExceptions() {
		return exceptions;
	}
	public void setExceptions(List<FetalException> exceptions) {
		this.exceptions = exceptions;
	}
	public void setDifList(List<Double> difList) {
//		if(this.yList.size()>0){
//			this.difList = difList(this.yList);
//		}else{
			this.difList = difList;
//		}
		
	}
	public List<Double> getDifList() {
		return difList;
	}
	public List<Double> getFitList() {
		return fitList;
	}
	public void setFitList(List<Double> fitList) {
		this.fitList = fitList;
	}
	
	
}
