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
	oTable = new TableInit(address + "doctorAdvice/findByMid.do", "advice_list", getColumnParams());
	query();//查询
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
		field: 'advicedate',
		title: '医嘱发送时间',
		sortable: true,
		align: 'center',
		width: '15%'
	}, {
		title: '孕周',
		sortable: true,
		align: 'center',
		width: '15%',
		sortable: true,
		formatter: function(value, row, index) {
			var week=getWeeksToDate(endDate,new Date(row.advicedate)).weeks;
			return  week + "周";
		}
	}, {
		field: 'myknowledge',
		title: '医嘱',
		align: 'center',
		width: '70%',
		formatter: function(value, row, index) {
			return "<div style='color:#169BD5;'>"+value+"</div>";
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