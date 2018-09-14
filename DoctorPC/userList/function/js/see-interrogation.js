/*@author zhangqt查看医嘱*/
var mid = sessionStorage.getItem("mid");
var doctorId = sessionStorage.getItem("doctorId");
var address = sessionStorage.getItem("address");
var oTable;
var endDate;
//var sdate
var sdate;
//var edate
var edate
//获取历史医嘱
$(function() {
	$('.weeks').append(prfweeksQuery());
	endDate=sessionStorage.getItem('endDate');
	oTable = new TableInit(address + "inquiryRecord/findByMid.do", "advice_list", getColumnParams());
	query();
});
var keyword;

function query() {
	var params= {
		'mid': mid,
		'sdate':sdate,
		'edate':edate,
		'keyword': keyword
	};
	oTable.Init(params);
}

function getColumnParams() {
	var columnParams = [{
		field: 'qdate',
		title: '问诊时间',
		sortable: true,
		align: 'center',
		width: '10%'
	}, {
		title: '问诊孕周',
		sortable: true,
		align: 'center',
		width: '10%',
		sortable: true,
		formatter: function(value, row, index) {
			var week=getWeeksToDate(endDate,new Date(row.qdate)).weeks;
			return  week + "周";
		}
	}, {
		field: 'doctoradvice',
		title: '问诊结果',
		align: 'center',
		width: '70%',
		formatter: function(value, row, index) {
			return "<div style='color:#169BD5;'>"+value+"</div>";
		}
	}, {
		title: '操作',
		align: 'center',
		width: '10%',
		formatter: function(value, row, index) {
			return "<a class='pointer' onclick='seeInterrogationHistory("+row.qid+",\""+row.mid+"\")'>查看问诊记录</a>";
		}
	}]
	return columnParams;
}

function searchList() {
var weeks = $(".weeks").val();
	var sweeks;
	var eweeks;
	if(weeks != 0) {
		//开始孕周
		var w = weeks.split('-');
		sweeks = w[0];
		eweeks = w[1];
	}
	//加五天.  
	sdate = longToDate(DateAdd(sweeks*7, new Date(endDate)));
	edate = longToDate(DateAdd(eweeks*7, new Date(endDate)));
	keyword = $('.keyword').val();
	query();//查询
}
//重置搜索input
function resetInput() {
	$(".vipGrade option").eq(0).attr("selected", "selected");
	$(".weeks option").eq(0).attr("selected", "selected");
	$(".hiskGrade option").eq(0).attr("selected", "selected");
	$(".gname").val('');
	$(".g_age").val('');
	$(".keyword").val('');
	$(".medicalrecordno").val("");
}
//查看问诊历史记录
function seeInterrogationHistory(qid,Mid){
	sessionStorage.setItem("mid",Mid);
	//console.log(Mid);
	sessionStorage.setItem("viewId",qid);
	//console.log(qid);
	sessionStorage.setItem('viewHistory',1);
	location.href='../../Remotelnterrogation/confirmReportViewHistory.html';
}
