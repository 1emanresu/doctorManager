var address = sessionStorage.getItem("address");
var typeId = 6;
var queryParams;
//病历号
var medicalrecordno = "";
//医嘱有无处理
var adviceState = 0;
//高危类型---隐藏表单域声明
//孕妇姓名
var gname;

$(function() {
	getVipList();
	changeParam()
	queryList(queryParams);
});

//点击有无处理
function changeState(i) {
	resetInput();
	if(i == 1) {
		//每次点开都是新的
		typeId=6;
		medicalrecordno = "";
		adviceState = 0;
		changeParam();
		queryList(queryParams);
	} else {
		//每次点开都是新的
		typeId=6;
		medicalrecordno = "";
		adviceState = 1;
		changeParam();
		queryList(queryParams);
	}
}
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
		'vipGrade': 101,
		'typeId': typeId,
		'gname':gname,
		'sweeks': sweeks, //开始孕周
		'eweeks': eweeks, //结束孕周
		'adviceState': adviceState,
		'medicalrecordno': medicalrecordno //病历卡号
	};
}

//搜索功能
function searchList() {
	var gn=$('.gname').val();
	gname=gn.trim()==''?undefined:gn;
	medicalrecordno = $(".medicalrecordno").val();
	changeParam();
	oTable.Init(queryParams);
}

//操作
function operation(row, tId) {
	var htm = "";
	if(row.adviceState == 0) {
		return htm += "<a style='cursor: pointer;' onclick='sendAdvice(\"" + row.mId +"\",\""+row.gName+"\")'>发送医嘱</a>";
	} else if(row.adviceState == 1) {
		return htm += "<a style='cursor: pointer;color:rgb(105, 105, 105)' onclick='seeAdvice(\"" + row.mId + "\",\""+row.gName+"\")'>查看医嘱</a>";
	}
}

//发送周报
function goToWeekly(mid,gname) {
	sessionStorage.setItem("mid", mid);
	sessionStorage.setItem("gName", gname);
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

//查看医嘱
function seeAdvice(mid) {
	sessionStorage.setItem("mid", mid);
	window.location.href = 'function/seeAdvice.html';
}

function setMid2(mid) {
	sessionStorage.setItem("mid", mid);
}
//去掉最后一个字符
function delLastStr(str) {
	var strs = str.substring(0, str.length - 1);
	return strs;
}

//设置mid
function setMid(mid,gname) {
	sessionStorage.setItem("mid", mid);
	sessionStorage.setItem("gName", gname);
	location.href = '../doctorAdviceManager/hypertension.html';
}

function make_State(row) {
	if(row.adviceState == 0)
		return '未处理'
	else if(row.adviceState == 1)
		return '已处理'
}