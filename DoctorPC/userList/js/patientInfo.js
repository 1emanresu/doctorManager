var address = sessionStorage.getItem("address");
var queryParams;
//病历号
var medicalrecordno = "";
//患者有无处理
var processingState=0;
//高危类型---隐藏表单域声明
var vipGrade=-1;
var typeId=3;
$(function() {
		//vip下拉
	getVipList();
	changeParam()
	queryList(queryParams);
});

//改变查询的参数
function changeParam() {
	var weeks = $(".weeks").val();
	var sweeks = -1;
	var eweeks = -1;
	if(weeks != 0 && weeks != undefined) {
		//开始孕周
		var w = weeks.split('-');
		sweeks = w[0];
		eweeks = w[1];
	}
	queryParams = {
		'vipGrade': vipGrade,
		'typeId': typeId,
		'sweeks': sweeks, //开始孕周
		'eweeks': eweeks, //结束孕周
		'processingState':processingState,//患者有无处理
		'medicalrecordno': medicalrecordno //病历卡号
	};
}


//点击有无处理
function changeState(i) {
	resetInput();
	if(i == 1) {
		//每次点开都是新的
		medicalrecordno = "";
		typeId=3;
		processingState=0;
		changeParam();
		queryList(queryParams);
	} else {
		//每次点开都是新的 
		medicalrecordno = "";
		typeId=4;
		processingState=1;
		changeParam();
		queryList(queryParams);
	}
}

//搜索功能
function searchList() {
	vipGrade=$(".vipGrade").val();
	medicalrecordno = $(".medicalrecordno").val();
	changeParam();
	oTable.Init(queryParams);
}

//操作
function operation(mid,i) {
	var htm='';
	if(i==3){
		htm +="<a style='cursor: pointer;' onclick='sendNotice(\"" + mid + "\")'>发送提醒</a>";
	    htm += "<a style='cursor: pointer;margin-left:15px;' onclick='sendHigh(\"" + mid + "\")'>转高危</a>";
	}else if(i==4){
		htm +="<a style='cursor: pointer;' onclick='goToWeekly(\"" + mid + "\")'>查看提醒</a>";
	    htm += "<a style='cursor: pointer;margin-left:15px;' onclick='sendHigh(\"" + mid + "\")'>转高危</a>";
	}else if(i==7){
		htm +="<a style='cursor: pointer;' onclick='goToWeekly(\"" + mid + "\")'>发送报告</a>";
	}else if(i==8){
		htm +="<a style='cursor: pointer;' onclick='goToWeekly(\"" + mid + "\")'>报告查看</a>";
	}
	return htm;
}


//发送周报
function goToWeekly(mid) {
	sessionStorage.setItem("mid", mid);
	window.location.href = 'sendWeekly.html';
}

//关闭提醒窗口
function sendNoticeClose() {
	$('#myModal').modal('hide');
}

//发送提醒
function sendNotice(mid) {
	$("#send_mid").val(mid);
	$('#myModal').modal('show')
}


function setMidToSession(mid) {
	sessionStorage.setItem("mid", mid);
}

//去掉最后一个字符
function delLastStr(str) {
	var strs = str.substring(0, str.length - 1);
	return strs;
}

//设置mid
function setMid(mid) {
	sessionStorage.setItem("mid", mid);
	location.href = '../doctorAdviceManager/hypertension.html';
}