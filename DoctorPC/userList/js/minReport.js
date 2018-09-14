var address = sessionStorage.getItem("address");
var typeId = 7;
var queryParams;
//病历号
var medicalrecordno = "";
var gname;
//周报有无处理
var weeklyState = 0;
$(function() {
	getVipList();
	//查询列表数据
	changeParam()
	queryList(queryParams);

});

//点击有无处理
function changeState(i) {
	resetInput();
	if(i == 1) {
		//每次点开都是新的
		typeId=7;
		medicalrecordno = "";
		weeklyState = 0;
		changeParam();
		queryList(queryParams);
	} else {
		//每次点开都是新的
		typeId=8;
		medicalrecordno = "";
		weeklyState = 1;
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
		'vipGrade': 100, //发送报告只有vip1,就是200元的
		'gname': gname,
		'typeId': typeId,
		'sweeks': sweeks, //开始孕周
		'eweeks': eweeks, //结束孕周
		'weeklyState':weeklyState,
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
	var i = tId;
	var htm = "";
	if(row.weeklyState == 0) {
		return htm += "<a style='cursor: pointer;' onclick='goToWeekly(\"" + row.mId + "\",\""+row.gName+"\")'>发送报告</a>";
	} else if(row.weeklyState == 1) {
		return htm += "<a style='cursor: pointer; color:rgb(105, 105, 105)' onclick='goToWeekly(\"" + row.mId +"\",\""+row.gName+ "\")'>查看报告</a>";
	}
}

//发送周报
function goToWeekly(mid,gname) {
	sessionStorage.setItem("mid", mid);
	sessionStorage.setItem("gName",gname);
	window.location.href = 'function/sendWeekly.html';
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

function setMid2(mid) {
	sessionStorage.setItem("mid", mid);
}

//设置mid
function setMid(mid,gname) {
	sessionStorage.setItem("mid", mid);
	sessionStorage.setItem("gName", gname);
	location.href = '../doctorAdviceManager/hypertension.html';
}
