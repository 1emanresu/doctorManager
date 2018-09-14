/*author luoyc*/
var address = sessionStorage.getItem("address");
var mid = sessionStorage.getItem("mid");
var doctorId=sessionStorage.getItem("doctorId");

$(function() {
	$.ajax({
		type: "post",
		url: address + "checkResult/queryWeeklyUploadReport.do",
		data: {
			"mid": mid,
		},
		dataType: "json",
		ContentType: "application/x-www-form-urlencoded;charset=utf-8",
		success: function(e) {
			var list = e.data;
			var expecialCheckStr = '';
			var checkDetailList = [];
			$.each(list, function(i) {
				var reportName = list[i].checkProject.riskname;
				checkDetailList = list[i].checkDetailList;
				if(i % 3 == 0) {
					expecialCheckStr += "<div class='pro2' style='padding-top: 10px;'>" +
						"<div class='pro_left' style='width: 100%;display: flex;'>";
				}
				if(i % 3 != 1) {
					expecialCheckStr += "<div style='flex: 1;'><div style='margin: 10px 0;color: #FF9900;'>" +
						reportName + "</div>" +
						"<table style='width: 100%;line-height: 25px;color: #696969;'>" +
						"<tr style='background: #F7F7F7;'>" +
						"<td>名称</td><td>结果</td><td>单位</td><td>参考值</td></tr>";
				} else {
					expecialCheckStr += "<div style='flex: 1;margin:0 25px;'><div style='margin: 10px 0;color: #FF9900;'>" +
						reportName + "</div>" +
						"<table style='width: 100%;line-height: 25px;color: #696969;'>" +
						"<tr style='background: #F7F7F7;'>" +
						"<td>名称</td><td>结果</td><td>单位</td><td>参考值</td></tr>";
				}
				$.each(checkDetailList, function(j) {
					if(j==8)return false;
					var checkresult = '';
					if(checkDetailList[j].checkvalue != null) {
						checkresult = checkDetailList[j].checkvalue;
					} else if(checkDetailList[j].description != null) {
						checkresult = checkDetailList[j].description;
					}
					var unit = '';
					if(checkDetailList[j].checkindex.cunit != null) {
						unit = checkDetailList[j].checkindex.cunit
					}
					var referencevalue = '';
					if(checkDetailList[j].checkindex.referencevalue != null) {
						referencevalue = checkDetailList[j].checkindex.referencevalue;
					}
					expecialCheckStr += "<tr><td>" +
						checkDetailList[j].checkindex.cname +
						"</td><td>" +
						checkresult +
						"</td><td>" +
						unit +
						"</td><td>" +
						referencevalue +
						"</td></tr>";
				});
				var src = '';
				if(list[i].picLink != null && list[i].picLink.trim() != '') {
					src = ""+list[i].picLink;
				}
				expecialCheckStr += "<tr><td colspan='4' style='text-align: right;'>" +
					"<div style='cursor:pointer;color: #6FA0E4;margin-right:10px;' class='click-to-see' onclick='seeOriginalReport(\"" +
					src +
					"\")'>查看原始报告单</div>" +
					"</td></tr></table></div>";
				if(i % 3 == 2) {
					expecialCheckStr += "</div></div>";
				}
				if(i == list.length - 1) {
					if(i % 3 == 1) {
						expecialCheckStr += "<div style='flex: 1;'>&nbsp;</div>";
					}
					if(i % 3 == 0) {
						expecialCheckStr += "<div style='flex: 1;margin:0 25px;'>&nbsp;</div><div style='flex: 1;'>&nbsp;</div>";
					}
					if(i % 3 != 2) {
						expecialCheckStr += "</div></div>";
					}
				}
			});
			if(list.length == 0) {
				expecialCheckStr == "无";
			}
			$("#checkProjectHaveDone").html(expecialCheckStr);
		},
		error: function() {

		}
	});
});