var address = sessionStorage.getItem("address");
var typeId = 10;
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

//改变查询的参数
function changeParam() {
	var weeks = $(".weeks").val();
	var sweeks = -1;
	var eweeks = -1;
	try {
		if(weeks != 0) {
			//开始孕周
			var w = weeks.split('-');
			sweeks = w[0];
			eweeks = w[1];
		}
	} catch(e) {
		//TODO handle the exception
	}
	queryParams = {
		'vipGrade': $('.vipGrade').val(),//
		'typeId': typeId,
		'sweeks': sweeks, //开始孕周
		'eweeks': eweeks, //结束孕周
		'sortName':'doctor',
		'sortOrder':'asc',
		'medicalrecordno': medicalrecordno //病历卡号
	};
}

//操作
function operation(row, tId) {
	var htm = "<a style='cursor: pointer;color:#337ab7' onclick='showrecord(\"" + row.mId + "\");'>发送提醒记录</a>";
	return htm;
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
	location.href = '../../doctorAdviceManager/hypertension.html';
}
