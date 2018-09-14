var address = sessionStorage.getItem("address");
var typeId = 6;
//病历号
var medicalrecordno = "";
//医嘱有无处理
var adviceState;
//高危类型---隐藏表单域声明
//孕妇姓名
var gname;
var g_age;
$(function() {
	//获取隐藏域里面的值0代表为处理，1代表已处理
	adviceState=$("#advice-state").val();
	getVipList();
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
	var edate;
	if(adviceState==0){
		edate=getLastDay();
	}
	var queryParams = {
		'vipGrade': 101,
		'typeId': typeId,
		'gname':gname,
		'birthYears':g_age,
		'sweeks': sweeks, //开始孕周
		'eweeks': eweeks, //结束孕周
		'processingState': adviceState,//处理状态
		'edate':edate,//本月中的最后一天
		'serviceType':1,//1为医嘱
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
	medicalrecordno = $(".medicalrecordno").val();
	query();
}

//操作
function operation(row, tId) {
	var htm = "";
	if(adviceState == 0) {
		return htm += "<a style='cursor: pointer;' onclick='sendAdvice(\"" + row.mId +"\",\""+row.odId+"\")'>发送医嘱</a>";
	} else if(adviceState == 1) {
		return htm += "<a style='cursor: pointer;' onclick='seeAdvice(\"" + row.mId + "\",\""+row.endDate+"\")'>查看医嘱</a>";
	}
}

//发送医嘱
function sendAdvice(mid,odid) {
	sessionStorage.setItem("mid", mid);
	sessionStorage.setItem("odid", odid);
	window.location.href = '../function/sendAdvice.html';
}

//查看医嘱
function seeAdvice(mid,endDate) {
	sessionStorage.setItem("mid", mid);
	sessionStorage.setItem("endDate", endDate);
	window.location.href = '../function/seeAdvice2.html';
}

//设置mid
function setMid(mid,gname) {
	sessionStorage.setItem("mid", mid);
	sessionStorage.setItem("gName", gname);
	location.href = '../../doctorAdviceManager/hypertension.html';
}
