var address = sessionStorage.getItem("address");
var typeId = 1;
var queryParams;
//病历号
var medicalrecordno = "";
//高危类型---隐藏表单域声明
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
		'vipGrade': $('.vipGrade').val(),
		'typeId': typeId,
		'sweeks': sweeks, //开始孕周
		'eweeks': eweeks, //结束孕周
		'sortName':'doctor',
		'sortOrder':'asc',
		'medicalrecordno': medicalrecordno //病历卡号
	};
}

//搜索功能
function searchList() {
	medicalrecordno = $(".medicalrecordno").val();
	changeParam();
	oTable.Init(queryParams);
}

//操作
function operation(row, tId) {
	var htm='';
	if(row.doctor == 1) {
		 htm += "<a style='cursor: pointer;color:rgb(105, 105, 105)' onclick='setMid2(\"" + row.mId + "\",2);'>查看建档</a>";
	} else if(row.doctor == 0||row.doctor==''||row.doctor==null) {
		 htm = "<a style='cursor: pointer;' onclick='setMid2(\"" + row.mId + "\",1);'>建档审核</a>";
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

function setMid2(mid,i) {
	sessionStorage.setItem("mid", mid);
	sessionStorage.setItem("whether", i);
	location.href = 'function/firstDiagnose_yet_bookbuilding_info.html';
}

//设置mid
function setMid(mid) {
	sessionStorage.setItem("mid", mid);
	location.href = '../userList/function/firstDiagnose_yet_bookbuilding_info.html';
}

function getHealthy(tId, row) {
	if(tId == 1) {
		return "<a style='cursor: pointer;' onclick='getHealthyByID(\"" + row.mId + "\",1)'>建档审核 </a>";
	} else {
		return "<a style='cursor: pointer;' onclick='getHealthyByID(\"" + row.mId + "\",2)'>查看建档 </a>";
	}
}

function getHealthyByID(mid, i_f) {
	sessionStorage.setItem("mid", mid);
	sessionStorage.setItem("whether", i_f);
	location.href = 'function/firstDiagnose_yet_bookbuilding_info.html';
}
//获取vip等级列表

function getVipGrade(value, row, index) {
	console.log(row.vipGradeid)
	if(row.vipGradeid == 100) {
		return "<a style='cursor: pointer;' onclick='VipDescDate(" + row.vipGradeid + ")'>" + "VIP1" + "</a>";
	} else if(row.vipGradeid == 101) {
		return "<a style='cursor: pointer;' onclick='VipDescDate(" + row.vipGradeid + ")'>" + "VIP2" + "</a>";
	} else {
		return "-";
	}
}
$.ajax({
	type: "post",
	url: address + "vipGrade/find.do",
	async: false,
	success: function(d) {
		service(d);
	}
});

function service(d) {
	for(var i = 0; i < d.data.length; i++) {
		var htm = "<tr><th>提供相应的服务：</th></tr><tr><td>" + d.data[i].vipintroduce + "</td></tr>";
		htm = htm.replace(/&a/g, "<br/>");
		htm = htm.replace(/&b/g, "<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		htm = htm.replace(/&c/g, "<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		$("#service" + (i + 1)).html("").append(htm);
	}
}

function VipDescDate(vipgradeid) {
	changeVipDescDate(vipgradeid);
}

//显示vip套餐的内容 that (100,101)
function changeVipDescDate(vipgradeid) {
	if(vipgradeid == 100) {
		$("div[class=service1]").css("display", "block");

	} else if(vipgradeid == 101) {
		$("div[class=service2]").css("display", "block");
	}
}