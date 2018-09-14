var address = sessionStorage.getItem("address");
//address = "http://192.168.1.38:8080/doctormanager/";
var typeId = 9;
//病历号
var medicalrecordno = "";
//vip
var vipGrade;
//名称
var gname;
var g_age;
//周报有无处理
var weeklyState = null;
$(function() {
	getVipList();
	//查询列表数据
	query();
	weeklyReportPie();
	serviceTypePie();
	adviceReportPie();
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
		'gname':gname,
		'birthYears':g_age,
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
	var gage = $('.g_age').val();
	var age2;
	if(gage != null && gage != ''){
		var myDate = new Date().getFullYear();
	    var births = myDate-gage;
	    age2 = births;
	}else{
		age2 = gage;
	}    
	g_age = age2==''?undefined:age2;
	var gn=$('.gname').val();
	gname=gn.trim()==''?undefined:gn;
	var vipId=$('.vipGrade').val();
	vipGrade=vipId==-1?undefined:vipId;
	medicalrecordno = $(".medicalrecordno").val();
	query();
}

//操作
function operation(row, tId) {
var htm = "<a style='cursor: pointer;' onclick='sendHigh(\"" + row.mId + "\")'>转高危</a> &nbsp;&nbsp;&nbsp;";
	if(row.vipId == 100) {
		htm+= "<a style='cursor: pointer;' onclick='seeWeekly(\"" + row.mId + "\",\""+row.endDate+"\")'>报告记录</a> &nbsp;&nbsp;&nbsp;";
		return htm += "<a style='cursor: default;opacity:0' >占位置用</a>";
	} else if(row.vipId == 101) {
		htm+="<a style='cursor: pointer;' onclick='seeAdvice(\"" + row.mId +"\",\""+row.endDate+"\")'>医嘱记录</a> &nbsp;&nbsp;&nbsp;";
		return htm += "<a style='cursor: pointer;' onclick='seeInterrogation(\"" + row.mId +"\",\""+row.endDate+"\")'>问诊记录</a>";
	}
}

//查看报告
function seeWeekly(mid,endDate){
	sessionStorage.setItem("mid",mid);
	sessionStorage.setItem("endDate",endDate);
	window.location.href = '../function/seeWeekly.html';
}

//查看医嘱
function seeAdvice(mid,endDate){
	sessionStorage.setItem("mid",mid);
	sessionStorage.setItem("endDate",endDate);
	window.location.href = '../function/seeAdvice2.html';
}

//查看问诊报告
function seeInterrogation(mid,endDate){
	sessionStorage.setItem("mid",mid);
	sessionStorage.setItem("endDate",endDate);
	window.location.href = '../function/seeInterrogation.html';
}

//设置mid
function setMid(mid,gname) {
	sessionStorage.setItem("mid", mid);
	sessionStorage.setItem("gName", gname);
	location.href = '../../doctorAdviceManager/hypertension.html';
}


//获取高危提醒信息
function getHighMessage() {
	var content = ""; //高危提醒内容
	if($('#hideBlood').is(':checked')) {
		content = '您已转移至"妊娠高血压"高危类别'
	}
	if($('#diabetes').is(':checked')) {
		content = '您已转移至"妊娠糖尿病"高危类别'
	}
	if($('#anemia').is(':checked')) {
		content = '您已转移至"妊娠合并贫血"高危类别'
	}
	if($('#fat').is(':checked')) {
		content = '您已转移至"妊娠肥胖"高危类别'
	}
	if($('#elseHigh').is(':checked')) {
		content = '您已转移至高危类别'
	}
	
	var relationIds = [];
	for(var j = 1; j < 4; j++) {
		if($('#sendPerson' + j).is(':checked')) {
			relationIds.push(j);
			console.log(relationIds)
		}
	}
	//存储信息的对象
	var Msgdata = {
		"title": "温馨提醒",
		"content":content,//高危提醒内容
		"relationIds": relationIds//发送人
	}
	return Msgdata;

}


