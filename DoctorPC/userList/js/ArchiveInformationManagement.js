var address = sessionStorage.getItem("address");
var typeId = 9;
//病历号
var medicalrecordno = "";
//vip
var vipGrade;
//周报有无处理
var weeklyState = null;
$(function() {
	getVipList();
	//查询列表数据
	query();
});

//改变查询的参数
function query() {
	var weeks = $(".weeks").val();
	var sweeks = -1;
	var eweeks = -1;
	if(weeks != 0 && weeks != undefined) {
		//开始孕周
		var w = weeks.split('-');
		sweeks = w[0];
		eweeks = w[1];
	}
	var queryParams = {
		'vipGrade':vipGrade,
		'typeId': typeId,
		'sweeks': sweeks, //开始孕周
		'eweeks': eweeks, //结束孕周
		'medicalrecordno': medicalrecordno //病历卡号
	};
	queryList(queryParams);
}

//搜索功能
function searchList() {
	var vipId=$('.vipGrade').val();
	vipGrade=vipId==-1?undefined:vipId;
	medicalrecordno = $(".medicalrecordno").val();
	query();
}

//操作
function operation(row, tId) {
var htm = "";
	if(row.vipGradeid == 100) {
		htm+= "<a style='cursor: pointer;' onclick='seeWeekly(\"" + row.mId + "\")'>报告记录</a> &nbsp;&nbsp;&nbsp;";
		return htm += "<a style='cursor: default;opacity:0' >占位置用</a>";
	} else if(row.vipGradeid == 101) {
		htm+="<a style='cursor: pointer;' onclick='seeAdvice(\"" + row.mId +"\")'>医嘱记录</a> &nbsp;&nbsp;&nbsp;";
		return htm += "<a style='cursor: pointer;' onclick='seeInterrogation(\"" + row.mId +"\")'>问诊记录</a>";
	}
}

//查看报告
function seeWeekly(mid){
	sessionStorage.setItem("mid",mid);
	window.location.href = '../function/seeWeekly.html';
}

//查看医嘱
function seeAdvice(mid){
	sessionStorage.setItem("mid",mid);
	window.location.href = '../function/seeAdvice2.html';
}

//查看问诊报告
function seeInterrogation(mid){
	sessionStorage.setItem("mid",mid);
	window.location.href = '../function/seeInterrogation.html';
}

//设置mid
function setMid(mid,gname) {
	sessionStorage.setItem("mid", mid);
	sessionStorage.setItem("gName", gname);
	location.href = '../../doctorAdviceManager/hypertension.html';
}


//设置mid
function setMid(mid,gname) {
	sessionStorage.setItem("mid", mid);
	sessionStorage.setItem("gName", gname);
	location.href = '../doctorAdviceManager/hypertension.html';
}
