/*@author zhangqt查看医嘱*/
var mid = sessionStorage.getItem("mid");
var doctorId = sessionStorage.getItem("doctorId");
var address = sessionStorage.getItem("address");
var oTable;
//末次月经
var endDate;
//var sdate
var sdate;
//var edate
var edate
//获取历史医嘱
$(function() {
	$('.weeks').append(prfweeksQuery());
	endDate = sessionStorage.getItem('endDate');
	oTable = new TableInit(address + "weeklyReport/findByMid.do", "advice_list", getColumnParams());
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
		field: 'wdate',
		title: '报告发送时间',
		sortable: true,
		align: 'center',
		width: '10%'
	}, {
		title: '孕周',
		sortable: true,
		align: 'center',
		width: '10%',
		sortable: true,
		formatter: function(value, row, index) {
			var week = getWeeksToDate(endDate, new Date(row.wdate)).weeks;
			return week + "周";
		}
	}, {
		field: 'abnormityinfoIndex',
		title: '异常指标分析',
		sortable: true,
		align: 'center',
		width: '35%',
		formatter: function(value, row, index) {
			if(value!=null){
				return "<div style='color:#169BD5;'>" + value + "</div>";
			}
				return "<div style='color:#169BD5;'>-</div>";
		}
	}, {
		title: '医嘱',
		sortable: true,
		align: 'center',
		width: '35%',
		formatter: function(value, row, index) {
			return "<div style='color:#169BD5;'>" + row.doctoradvice + "</div>";
		}
	}, {
		title: '操作',
		align: 'center',
		width: '10%',
		formatter: function(value, row, index) {
			return "<a class='pointer' onclick='seeWeeklyReport("+
							  +getWeeksToDate(endDate, new Date(row.wdate)).weeks
							  +",\""
							  +row.wdate
							  +"\",\""
							  +row.doctoradvice
							  +"\""
							  +")'>查看微报告</a>";
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
//历史记录预览
function seeWeeklyReport(week,date,advice){
	sessionStorage.setItem("viewDoctorStr",advice);
	sessionStorage.setItem("week",week);
	sessionStorage.setItem("weeklyReportDate",date);
	$("#iframe_report1").attr("src","../../Remotelnterrogation/weeklyTemplate2.html");
	$('.swiper-container').show();
}
//关闭事件
$('.close-move').click(function(i) {
	$(this).parent().hide();
});