var checkReport = function(opt) {
	//默认值
	var picLink = '';
	var checkProjectId = opt.checkProjectId || 0;
	var startWeek = opt.startWeek || opt.weeks;
	var endWeek = opt.endWeek || opt.weeks;
	//默认返回table
	var htmlType = opt.htmlType || 'table';
	var htm;
	ajax({
		type: "post",
		url: "checkResult/queryCheckDetailByWeeks",
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
				var tbody = "<table class='report-table'><tr ><td>名称</td><td>结果</td><td>单位</td><td>参考值</td></tr>";
				for(var i = 0; i < length; i++) {
					var checkResult = data[i].checkValue == undefined ? data[i].description : data[i].checkValue;
					tbody+="<tr><td>" + isUN(data[i].cname) + "</td>";
					tbody+="<td>" + isUN(checkResult) + "</td>";
					tbody+="<td style='color: red;'>" + isUN(data[i].cunit) + "</td>";
					tbody+="<td>" + isUN(data[i].referencevalue) + "</td></tr>";
				}
				reportHtml = tbody + "</table>";
				break;
			}
		case 'table-checkbox':
			{
				var tbody = "<table class='report-table'><tr ><td></td><td>名称</td><td>结果</td><td>单位</td><td>参考值</td></tr>";
				for(var i = 0; i < length; i++) {
					var checkResult = data[i].checkValue == undefined ? data[i].description : data[i].checkValue;
					tbody+="<td><input type='checkbox'></td>";
					tbody+="<td>" + isUN(data[i].cname) + "</td>";
					tbody+="<td>" + isUN(checkResult) + "</td>";
					tbody+="<td style='color: red;'>" + isUN(data[i].cunit) + "</td>";
					tbody+="<td>" + isUN(data[i].referencevalue) + "</td></tr>";
				}
				reportHtml = tbody + "</table>";
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