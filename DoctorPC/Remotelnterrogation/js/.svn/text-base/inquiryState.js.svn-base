/*查询预约挂号孕妇的在线状态js*/
//var address = "http://192.168.1.26:8080/doctormanager/";
//医生id
var doctorId = sessionStorage.getItem("doctorId");
var address=sessionStorage.getItem("address");
$(function() {
	queryInquiryState();
});

//以医生id与vip等级查找孕妇
var now = new Date();
//查询参数
var today = now.getFullYear() + "-" + (now.getMonth() + 1) + "-" + PrefixInteger(now.getDate());
/*查询的时间段，默认当天*/
var monday = today + " 00:00:00";
var sunday = today + " 23:59:59";
function queryInquiryState() { 
	$.ajax({
		type: "post",
		url: address + "remoteReservation/queryByBespeak.do",
		data: {
			'sdate':monday,
			'edate':sunday,
			'pageIndex': 0,
			'pageSize':999
		},
		async: true,
		success: function(d) {
			changeData(d.rows);
		}
	});
}
//补零操作
function PrefixInteger(num) {
	return(Array(2).join(0) + num).slice(-2);
}
//处理在线状态数据
function changeData(data) {
	//清空
	$(".user_list").html("");
	//获取总人数与在线人数
	var online=0;
	for(var i = 0; i < data.length; i++) {
		var li = "<li class='li' onclick='serviceObject(\""+data[i].mid+"\")'><img src='[img]' width='15px' /><span>[name]</span><span>[date]</span></li>";
		li = li.replace('[name]', data[i].gname);
		//将long类型的时间转为1990-1-1 00:00:00格式
		var myDate = new Date(data[i].bookTime);
		rdate = myDate.getFullYear() + '-' + (myDate.getMonth() + 1) + '-' + myDate.getDate() + " " + myDate.getHours() + ":" + myDate.getMinutes() + ":" + myDate.getSeconds();
		li=li.replace('[date]',rdate);
		if(data[i].inquiryState==0){
			li=li.replace('[img]',"images/u242.png");
		}else{
			online++;
			li=li.replace('[img]',"images/u349.png");
		}
		$(".user_list").append(li);
	}
	var onli="<li class='onlineState'>今日共"+data.length+"名患者预约远程问诊<br />当前"+online+"人在线等候。</li>";
	$(".user_list").prepend(onli);
}

