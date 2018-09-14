var address = sessionStorage.getItem('address');
var checkReport = function(opt) {

	//默认值
	var picLink = '';
	var checkProjectId = opt.checkProjectId || 0;
	var startWeek = opt.startWeek || opt.weeks;
	var endWeek = opt.endWeek || opt.weeks;
	//默认返回table
	var htmlType = opt.htmlType || 'table';
	var htm;
	$.ajax({
		type: "post",
		url: address + "checkResult/queryCheckDetailByWeeks.do",
		data: {
			"startWeek": startWeek,
			"endWeek": endWeek,
			"checkProjectId": checkProjectId,
			"mId": opt.mid
		},
		async: false,
		dataType: "json",
		success: function(e) {
			var data = e.data[0];
			if(data != undefined) {
				htm = rtnHtml(data, htmlType);
				checkReport.prototype.picLink = data[0].picLink;
			} else {
				htm = '';
			}
		}

	});
	return htm;
};

//返回table
var rtnHtml = function(data, htmlType) {
	var length = data.length;
	var reportHtml;
	switch(htmlType) {
		case 'table':
			{
				var tbody = "<table class='report-table><tr ><td>名称</td><td>结果</td><td>单位</td><td>参考值</td></tr>";
				for(var i = 0; i < length; i++) {
					var checkResult = data[i].checkValue == undefined ? data[i].description : data[i].checkValue;
					tbody += "<tr><td>" + isUN(data[i].cname) + "</td>";
					tbody += "<td>" + isUN(checkResult) + "</td>";
					tbody += "<td style='color: red;'>" + isUN(data[i].cunit) + "</td>";
					tbody += "<td>" + isUN(data[i].referencevalue) + "</td></tr>";
				}
				reportHtml = tbody + "</table>";
				break;
			}
		case 'table-checkbox':
			{
				var tbody = "<table class='report-table'><tr ><td></td><td>名称</td><td>结果</td><td>单位</td><td>参考值</td></tr>";
				for(var i = 0; i < length; i++) {
					var checkResult = data[i].checkValue == undefined ? data[i].description : data[i].checkValue;
					tbody += "<td><input type='checkbox'></td>";
					tbody += "<td>" + isUN(data[i].cname) + "</td>";
					tbody += "<td>" + isUN(checkResult) + "</td>";
					tbody += "<td style='color: red;'>" + isUN(data[i].cunit) + "</td>";
					tbody += "<td>" + isUN(data[i].referencevalue) + "</td></tr>";
				}
				reportHtml = tbody + "</table>";
				break;
			}
		case 'table-box':
			{
				var tbody = "<table class='report-table'><tr ><td>名称</td><td>结果</td><td>单位</td><td>参考值</td></tr>";
				//设置最多显示五条记录
				var j = length > 5 ? 5 : length;
				for(var i = 0; i < j; i++) {
					var checkResult = data[i].checkValue == undefined ? data[i].description : data[i].checkValue;
					tbody += "<tr><td>" + isUN(data[i].cname) + "</td>";
					tbody += "<td>" + isUN(checkResult) + "</td>";
					tbody += "<td>" + isUN(data[i].cunit) + "</td>";
					tbody += "<td>" + isUN(data[i].referencevalue) + "</td></tr>";
				}
				reportHtml = tbody + "</table>";
				break;
			}
			case 'table-tang'://唐筛
			{
				var tbody = "<table class='tr_doctorAdviceManager_border'><tr ><td>项目名称</td><td>结果</td><td>单位</td><td>MOM值</td><td>参考值</td></tr>";
				console.log(JSON.stringify(data));
				for(var i = 0; i < length; i++) {
					var checkResult = data[i].checkValue == undefined ? data[i].description : data[i].checkValue;
					
					tbody += "<td>" + isUN(data[i].cname) + "</td>";
					tbody += "<td>" + isUN(checkResult) + "</td>";
					tbody += "<td style='color: red;'>" + isUN(data[i].cunit) + "</td>";
					tbody += "<td></td>";
					tbody += "<td>" + isUN(data[i].referencevalue) + "</td></tr>";
				}
				reportHtml = tbody + "</table>";
				checkReport.prototype.reportData = data;
				break;
			}
			case 'table-nipt'://NIPT
			{
				var tbody = "<table class='tr_doctorAdviceManager_border'><tr ><td>检测项目</td><td>三体风险指数</td><td>参考范围</td><td>胎儿三体结果</td></tr>";
				console.log(JSON.stringify(data));
				for(var i = 0; i < length; i++) {
					var checkResult = data[i].checkValue == undefined ? data[i].description : data[i].checkValue;
					
					tbody += "<td>" + isUN(data[i].cname) + "</td>";
					tbody += "<td>" + isUN(checkResult) + "</td>";
					tbody += "<td style='color: red;'>" + isUN(data[i].cunit) + "</td>";
					tbody += "<td>" + isUN(data[i].referencevalue) + "</td></tr>";
				}
				reportHtml = tbody + "</table>";
				checkReport.prototype.reportData = data;
				break;
			}
		default:
			{
				reportHtml = "<div style='text-align: center;'>无返回此类型的报告！！！</div>";
				break;
			}
	}
	return reportHtml;
}

//处理null或undefined
function isUN(str) {
	if(str == undefined || str == null) {
		return "";
	}
	return str;
}