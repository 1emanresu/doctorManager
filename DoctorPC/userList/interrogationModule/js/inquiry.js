var oTable;
var address = sessionStorage.getItem('address');
$(function() {
	//为时间下拉列表赋值,本星期
	var url = address + 'remoteReservation/queryByBespeak.do';
	oTable = new TableInit(url, "user_list", getColumnParams());
	setSelect();
	var pendingState=$("#pending-state").val();
	query(pendingState);
	//孕周下拉赋值
	$('.weeks').append(prfweeksQuery());
});
var now = new Date();
//查询参数
var today = now.getFullYear() + "-" + (now.getMonth() + 1) + "-" + PrefixInteger(now.getDate());
/*查询的时间段，默认当天*/
var monday ;
var sunday ;
//孕周
var weeks;
//孕妇姓名
var gname;
//改变请求参数
function query(pendingState) {
	var weeks = $(".weeks").val();
	var sweeks;
	var eweeks;
	if(weeks != 0 && weeks != undefined) {
		//开始孕周
		var w = weeks.split('-');
		sweeks = w[0];
		eweeks = w[1];
	}
	var params = {
		'sdate': monday,
		'edate': sunday,
		'sweeks': sweeks,
		'eweeks': eweeks,
		'name': gname,
		'pendingState':pendingState
	}
	oTable.Init(params);
}

//为时间下拉列表赋值,本星期
function setSelect() {
	var nowTime = now.getTime();
	var day = now.getDay();
	var oneDayLong = 24 * 60 * 60 * 1000;
	var MondayTime = nowTime - (day - 1) * oneDayLong;
	var op = "";
	for(var i = 1; i < 8; i++) {
		var SundayTime = nowTime + (i - day) * oneDayLong;
		var mydate1 = new Date(SundayTime);
		var mydate2 = mydate1.getFullYear() + "-" + (mydate1.getMonth() + 1) + "-" + PrefixInteger(mydate1.getDate());
		op += "<option value='" + mydate2 + "'>" + mydate2 + "</option>";
	}
	$("#day").append(op);
	$("#day option[value='" + today + "']").attr("selected", "selected");
}

//补零操作
function PrefixInteger(num) {
	return(Array(2).join(0) + num).slice(-2);
}
//搜索按钮点击事件
function search() {
	//姓名搜索
	var name = $('.gname').val();
	if(name.trim() != null && name.trim() != '') {
		gname = name;
	} else {
		gname = undefined;
	}

	var monDay = $("#day").val();
	if(monDay != -1) {
		var dat = new Date(monDay);
		/*monday = dat.getFullYear() + "-" + (dat.getMonth() + 1) + "-" + dat.getDate() + " 00:00:00";
		sunday = dat.getFullYear() + "-" + (dat.getMonth() + 1) + "-" + dat.getDate() + " 23:59:59";*/
	} else {
		monday=undefined;
		sunday=undefined;
		console.log(1);
		//点击本周预约   。。本周时间星期一到星期天
		var nowTime = now.getTime();
		var day = now.getDay();
		var oneDayLong = 24 * 60 * 60 * 1000;
		var MondayTime = nowTime - (day - 1) * oneDayLong;
		var SundayTime = nowTime + (7 - day) * oneDayLong;
		var mydate1 = new Date(MondayTime);
		var mydate2 = new Date(SundayTime);
		//本周星期一时间
		monday = mydate1.getFullYear() + "-" + (mydate1.getMonth() + 1) + "-" + mydate1.getDate() + " 00:00:00";
		//本周星期天时间
		sunday = mydate2.getFullYear() + "-" + (mydate2.getMonth() + 1) + "-" + mydate2.getDate() + " 23:59:59";
	}
	query($("#pending-state").val());
}

function getColumnParams() {
	var columnParams = [{
		align: 'center',
		checkbox: true
	}, {
		title: '预约日期',
		sortable: true,
		align: 'center',
		clickToSelect: false,
		formatter: function(value, row, index) {
			return dateUtil.longToDate(row.bookTime);
		}
	}, {
		title: '预约时段',
		sortable: true,
		align: 'center',
		clickToSelect: false,
		sortable: true,
		formatter: function(value, row, index) {
			return getDateTime(row.bookTime);
		}
	}, {
		field: 'gname',
		title: '患者姓名',
		align: 'center',
		clickToSelect: false,
		sortable: true
	}, {
		field: 'birthYears',
		title: '年龄',
		align: 'center',
		clickToSelect: false,
		sortable: true,
		formatter: function(value, row, index) {
			return dateUtil.dateToAge('1992-05-10');
		}
	}, {
		field: 'enddate',
		title: '孕周',
		align: 'center',
		clickToSelect: false,
		sortable: true,
		formatter: function(value, row, index) {
			return getWeeks(row.enddate).weeks;
		}
	}, {
		field: 'expectedConfinement',
		title: '预产期',
		sortable: true,
		align: 'center'
	}, {
		title: '健康套餐',
		sortable: true,
		align: 'center',
		clickToSelect: false,
		formatter: function(value, row, index) {
			return '套餐B';
		}
	}, {
		title: '状态',
		sortable: true,
		align: 'center',
		clickToSelect: false,
		formatter: function(value, row, index) {
			if(row.inquiryState == 0) {
				return "<img src='images/u242.png' width='15px'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;下线";
			} else {
				return "<img src='images/u349.png' width='15px'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在线";
			}
		}
	}, {
		title: '操作',
		align: 'center',
		clickToSelect: false,
		formatter: function(value, row, index) {
			if(row.pendingState==0){
				return "<div class='pointer' onclick='setMid(\"" + row.mId + "\",\""+row.rrid+"\")'><a>接诊</a></div>";
			}else if(row.pendingState){
			return "<div class='pointer' onclick='seeinquiry(\"" + row.mId + "\",\""+row.enddate+"\")'><a>问诊记录</a></div>";
			}
		}
	}]
	return columnParams;
}

//设置mid到session,跳到远程问诊页面
function setMid(mid,rrid) {
	saveGravidaIMAccount(mid)
	sessionStorage.setItem('mid', mid);
	sessionStorage.setItem('rrid', rrid);
	window.parent.location.href = '../../Remotelnterrogation/interrogation.html';
}

//查看问诊记录
function seeinquiry(mid,endDate){
	
	sessionStorage.setItem("mid",mid);
	sessionStorage.setItem("endDate",endDate);
	sessionStorage.setItem('backonly',0);
	window.location.href = '../function/seeInterrogation.html';
}
//返回预约的时间段
function getDateTime(long) {
	var date = new Date(long);
	return date.getHours() + ":" + date.getMinutes() + "-" + date.getHours() + ":" + (date.getMinutes() + 10);
}

/**
 * 获取孕妇的网易IM账号信息
 * @author yinzx 
 * @param {Object} mid
 */
function saveGravidaIMAccount(mid){
 	$.ajax({
		type: "post",
		dataType: "json",
		data: {
			"mid": mid
		},
		async:false,
		url: address + "user/findIMByMid.do",
		success: function(result) {
			var imaccount = result.data;
			console.log("saveGravidaIMAccount:"+JSON.stringify(imaccount))
			localStorage.setItem("gravidaIMAccount",JSON.stringify(imaccount))
		}
	});
 }