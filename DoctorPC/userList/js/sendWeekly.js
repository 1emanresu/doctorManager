/*用于发送报告（周报）author luoyc*/
var address = sessionStorage.getItem("address");
var mid = sessionStorage.getItem("mid");
var doctorId = sessionStorage.getItem("doctorId");
var addressUrl;
//查看更多基本信息
var index = true;
$(".basicInfo-container-hide").hide();
$(".showMore").click(function() {
	if(index) {
		$(".basicInfo-container-hide").show();
		index = false;
	} else {
		$(".basicInfo-container-hide").hide();
		index = true;
	}
	$('#index-top').toggleClass("rotate-img");
});
$("#weChat-service").click(function() {

});
//计算孕周
function getWeeks(date1) {
	var date2 = new Date();
	var date3 = date2.getTime() - new Date(date1).getTime();
	var days = Math.floor(date3 / (24 * 3600 * 1000));
	var json = {
		"weeks": parseInt(days / 7),
		"day": days % 7
	};
	return json;
}
if(address != null) {
	addressUrl = address.split("doctormanager")[0] + "gravidamanager/";
} else {
	addressUrl = "http://192.168.1.49:8080/gravidamanager/";
}
//获取当前孕周
var week;
$.ajax({
	type: "post",
	ContentType: "application/x-www-form-urlencoded;charset=utf-8",
	url: addressUrl + "gravidainfo/find.do",
	dataType: "json",
	data: {
		"mid": mid,
	},
	success: function(e) {
		var date3 = new Date(e.data.enddate)
		week = getWeeks(date3).weeks;
		var year1 = date3.getFullYear();
		var month1 = date3.getMonth() + 1;
		if(month1 < 10) {
			month1 = "0" + month1;
		};
		var strDate1 = date3.getDate();
		if(strDate1 < 10) {
			strDate1 = "0" + strDate1;
		}
		var endDateStr = year1 + "-" + month1 + "-" + strDate1;
		//往期报告回顾
		$.ajax({
			type: "post",
			dataType: "json",
			data: {
				'mid': mid
			},
			url: sessionStorage.getItem("address") + "weeklyReport/findByMid.do",
			success: function(result) {
				var list3 = result.rows;
				var tableStr = ""
				$.each(list3, function(l) {
					var gweek = getWeeksToDate(endDateStr, new Date(list3[l].wdate)).weeks;
					tableStr += "<tr><td>" +
						list3[l].wdate +
						"</td><td>" +
						gweek +
						"</td><td>" +
						list3[l].abnormityinfoIndex +
						"</td><td>" +
						list3[l].doctoradvice +
						"</td><td>" +
						"<span style='cursor:pointer;color:#79A9EC' onclick='seeWeeklyReport(" +
						+gweek +
						",\"" +
						list3[l].wdate +
						"\",\"" +
						list3[l].doctoradvice +
						"\"" +
						")'>" +
						"查看微报告" +
						"</span></td></tr>";
				});
				if(list3.length != 0) {
					$("#table-weeklyReportHistory").append(tableStr);
				} else {
					$("#table-weeklyReportHistory").append("<tr><td colspan='5'>暂无数据</td></tr>")
				}
			}
		});
		//症状记录
		$.ajax({
			type: "post",
			url: address + "pregnancyRecord/queryCheckDetail.do",
			data: {
				"mid": mid,
				"weeks": week
			},
			success: function(d) {
				var systomlist = d.data[0];
				var timelist = d.data[1];
				var descriptionlist = d.data[2];
				var tableStr2 = "";
				$.each(systomlist, function(i) {
					tableStr2 += "<tr><td>" +
						systomlist[i] +
						"</td><td>" +
						timelist[i] +
						"</td><td>" +
						descriptionlist[i] +
						"</td></tr>";
				});
				if(tableStr2.trim() == "") {
					$("#Table-systom").append("<tr><td colspan='3'>暂无数据</td></tr>");
				} else {
					$("#Table-systom").append(tableStr2);
				}

			},
			error: function(e) {

			}
		});
	},
	error: function(e) {

	}
});

$(function() {
	//产检摘要
	$.ajax({
		type: "post",
		dataType: "json",
		data: {
			'mid': mid
		},
		url: sessionStorage.getItem("address") + "abnormityinfo/findByDateRangeCount.do",
		success: function(result) {
			var list = result.data;
			var checkReportStr = "";
			$.each(list, function(k) {
				checkReportStr += "<tr class='add_checkReport'><td>" +
					list[k].cname +
					"</td><td>" +
					list[k].quantity +
					"项</td><td>" +
					"<span style='cursor:pointer;color:#79A9EC' onclick='checkReport(" +
					list[k].rid +
					")'>" +
					"查看" +
					"</span></td></tr>";
			});
			if(checkReportStr.trim() == "") {
				$("#Table-checkProject").append("<tr><td colspan='3'>暂无数据</td></tr>");
			} else {
				$("#Table-checkProject").append(checkReportStr);
			}
		}
	});
	//自测摘要
	$.ajax({
		type: "post",
		dataType: "json",
		data: {
			'mid': mid
		},
		url: sessionStorage.getItem("address") + "selfTest/findWeeklySelfTestDone.do",
		success: function(result) {
			var list4 = result.data;
			var tablestr2 = "";
			if(list4.体重 != undefined) {
				tablestr2 += "<tr class='add_selfTest'><td>" +
					"体重" +
					"</td><td>" +
					list4.体重.length +
					"次</td><td><span style='cursor:pointer;color:#79A9EC' onclick='seeEcharts(" +
					1 +
					",this)'>" +
					"查看" +
					"</span></td></tr>";
			}
			if(list4.血压 != undefined) {
				tablestr2 += "<tr class='add_selfTest'><td>" +
					"血压" +
					"</td><td>" +
					list4.血压.length +
					"次</td><td><span style='cursor:pointer;color:#79A9EC' onclick='seeEcharts(" +
					2 +
					",this)'>" +
					"查看" +
					"</span></td></tr>";
			}
			if(list4.血糖 != undefined) {
				tablestr2 += "<tr class='add_selfTest'><td>" +
					"血糖" +
					"</td><td>" +
					list4.血糖.length +
					"次</td><td><span style='cursor:pointer;color:#79A9EC' onclick='seeEcharts(" +
					3 +
					",this)'>" +
					"查看" +
					"</span></td></tr>";
			}
			if(list4.胎动 != undefined) {
				tablestr2 += "<tr class='add_selfTest'><td>" +
					"胎动" +
					"</td><td>" +
					list4.胎动.length +
					"次</td><td><span style='cursor:pointer;color:#79A9EC' onclick='seeEcharts(" +
					4 +
					",this)'>" +
					"查看" +
					"</span></td></tr>";
			}
			if(list4.宫高 != undefined) {
				tablestr2 += "<tr class='add_selfTest'><td>" +
					"宫高" +
					"</td><td>" +
					list4.宫高.length +
					"次</td><td><span style='cursor:pointer;color:#79A9EC' onclick='seeEcharts(" +
					5 +
					",this)'>" +
					"查看" +
					"</span></td></tr>";
			}
			if(list4.腹围 != undefined) {
				tablestr2 += "<tr class='add_selfTest'><td>" +
					"腹围" +
					"</td><td>" +
					list4.腹围.length +
					"次</td><td><span style='cursor:pointer;color:#79A9EC' onclick='seeEcharts(" +
					6 +
					",this)'>" +
					"查看" +
					"</span></td></tr>";
			}
			if(list4.胎心 != undefined) {
				tablestr2 += "<tr class='add_selfTest'><td>" +
					"胎心" +
					"</td><td>" +
					list4.胎心.length +
					"次</td><td><span style='cursor:pointer;color:#79A9EC' onclick='seeEcharts(" +
					7 +
					",this)'>" +
					"查看" +
					"</span></td></tr>";
			}
			if(tablestr2.trim() == "") {
				$("#Table-selfTest").append("<tr><td colspan='3'>暂无数据</td></tr>");
			} else {
				$("#Table-selfTest").append(tablestr2);
			}
		}
	});
})
//保存周报记录
function saveRecord() {
	var date = new Date();
	var seperator = "-";
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	if(month < 10) {
		month = "0" + month;
	};
	var strDate = date.getDate();
	if(strDate < 10) {
		strDate = "0" + strDate;
	};
	var currentdate = year + seperator + month + seperator + strDate;
	var ele = document.getElementById("thisAdvice_content");
	var doctoradvice = getText(ele);
	if(doctoradvice.trim() == '') {
		alert("医嘱建议不能为空");
	} else {
		var abnormityinfoIndex = $("#abnormal-analysis").html();
		//周报记录保存
		$.ajax({
			type: "post",
			ContentType: "application/x-www-form-urlencoded;charset=utf-8",
			url: address + "weeklyReport/insert.do",
			dataType: "json",
			data: {
				"mid": mid,
				"doctorid": doctorId,
				"doctoradvice": doctoradvice,
				"abnormityinfoIndex": abnormityinfoIndex
			},
			success: function(e) {
				//app推送
				$.ajax({
					type: "post",
					url: addressUrl + "appPush/pushWeeklyReport.do",
					data: {
						"mid": mid,
						"relationIds": 1,
						"date": currentdate,
						"week": week
					},
					dataType: "json",
					ContentType: "application/x-www-form-urlencoded;charset=utf-8",
					success: function(e) {
						alert("发送成功！");
					},
					error: function() {

					}
				});
				//微信推送
				$.ajax({
					type: "post",
					url: addressUrl + "weChat/pushWeeklyReport.do",
					data: {
						"mid": mid,
						"relationIds": 1,
						"date": currentdate,
						"week": week
					},
					dataType: "json",
					ContentType: "application/x-www-form-urlencoded;charset=utf-8",
					success: function(e) {
					},
					error: function() {

					}
				});
				var Msgdata = {
					"relationIds": [1],
					"title": "",
					"content": "您有一份新的周报记录，请及时查看。"
				}
				//短信发送
				pushSmsMsg(mid, 3, Msgdata);
				//更改为已处理状态--zhangqt
				updateState();
			},
			error: function() {

			}
		});
	}
}
function updateState() {
	var odid = sessionStorage.getItem("odid");
	if(odid == '' || odid == null || odid == undefined) {
		return;
	}
	$.ajax({
		type: "post",
		url: address + "orderDetails/updateState.do",
		data: {
			odid: odid
		},
		async: true,
		success: function(e) {
		},error:function(){
			
		}
	});
}

//点取消无操作,暂时设定为跳转到微报告  2017/10/31
$('.but2').click(function() {
	location.href = '../weeklyModule/weeklyManager.html';
});

$(function() {
	//基本信息
	$.ajax({
		type: "post",
		url: address.replace("doctormanager", "gravidamanager") + "gravidainfo/find.do",
		data: {
			mid: mid
		},
		dataType: "json",
		success: function(e) {
			var gravidainfo = e.data;
			$(".gName").text(replaceUndefined(gravidainfo.gname));
			var now = new Date();
			var age = "暂无数据";
			if(gravidainfo.birthYears != null && gravidainfo.birthYears != undefined) {
				age = Math.floor((now.getTime() - gravidainfo.birthYears) / 1000 / 60 / 60 / 24 / 365);
			}
			$(".gAge").text(age);
			var weeks = "暂无数据";
			if(gravidainfo.enddate != null && gravidainfo.enddate != undefined) {
				weeks = getWeeks(new Date(gravidainfo.enddate)).weeks;
			}
			$(".gWeek").html(weeks); //孕周
			//预览周报所需参数
			if(gravidainfo.enddate != null && gravidainfo.enddate != undefined) {
				var expectedDate = new Date(gravidainfo.expectedconfinement);
				var year = expectedDate.getFullYear();
				var month = expectedDate.getMonth() + 1;
				if(month < 10) {
					month = "0" + month;
				};
				var strDate = expectedDate.getDate();
				if(strDate < 10) {
					strDate = "0" + strDate;
				}
				var currentdate = year + "年" + month + "月" + strDate + "日";
				$(".expected").text(currentdate);
			} else {
				$(".expected").text("暂无数据");
			}
			if(gravidainfo.pregnancybirth != null && gravidainfo.pregnancybirth != undefined) {
				$(".pregnancybirth").text(gravidainfo.pregnancybirth.replace("#", " "));
			} else {
				$(".pregnancybirth").text("无");
			}
		}
	});
	//血型
	$.ajax({
		type: "post",
		url: address.replace("doctormanager", "gravidamanager") + "familyMember/findAllByMid.do",
		data: {
			mid: mid
		},
		dataType: "json",
		success: function(e) {
			var list2 = e.data;
			$.each(list2, function(j) {
				if(list2[j].relationid == 1) {
					$(".gBloodType").text(bloodtype(list2[j].bloodtype) + " " + bloodtype2(list2[j].rh));
				} else if(list2[j].relationid == 2) {
					$(".hBloodType").text(bloodtype(list2[j].bloodtype) + "  " + bloodtype2(list2[j].rh));
				}
			});
		}
	});
});
//计算孕周
function getWeeks(date1) {
	var date2 = new Date();
	var date3 = date2.getTime() - new Date(date1).getTime();
	var days = Math.floor(date3 / (24 * 3600 * 1000));
	var json = {
		"weeks": parseInt(days / 7),
		"day": days % 7
	};
	return json;
}
//血型ABO
function bloodtype(type) {
	var bloodType = '';
	if(type == 0) {
		bloodType = "A型";
	} else if(type == 1) {
		bloodType = "B型";
	} else if(type == 2) {
		bloodType = "O型";
	} else if(type == 3) {
		bloodType = "AB型";
	} else {
		bloodType = "暂无";
	}
	return bloodType;
}
//血型rh
function bloodtype2(type) {
	var bloodType = '';
	if(type == 0) {
		bloodType = "阴性";
	} else if(type == 1) {
		bloodType = "阳性";
	} else {
		bloodType = "暂无";
	}
	return bloodType;
}
//自测摘要点击查看事件
function seeEcharts(i, ele) {
	$("#selfTest-box").show();
	$("#echartsTitle").text($(ele).parent().parent().find("td:first-child").text());
	if(i == 1) {
		weightSetDate(mid);
	} else if(i == 2) {
		bloodpressureSetDate(mid);
	} else if(i == 3) {
		bloodsugreSetDate(mid);
	} else if(i == 4) {
		featalMovementSetDate(mid);
	} else if(i == 5) {
		fundalheightSetDate(mid);
	} else if(i == 6) {
		abdominalgirthSetDate(mid);
	} else if(i == 7) {
		featalHeartSetDate(mid);
	}
}
//产检摘要点击查看事件
function checkReport(i) {
	$.ajax({
		type: "post",
		url: address + "checkResult/selectByPrimaryKey.do",
		data: {
			resultid: i
		},
		dataType: "json",
		success: function(e) {
			var list = e.data;
			var expecialCheckStr = "";
			var checkDetailList = list.checkDetailList;
			$("#checkProjectTitle").text(list.checkProject.riskname);
			$.each(checkDetailList, function(j) {
				if(j == 8) {
					return false;
				}
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
				expecialCheckStr += "<tr class='tr-add'><td>" +
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
			if(list.picLink != null && list.picLink.trim() != '') {
				src = list.picLink;
			}
			expecialCheckStr += "<tr class='tr-add'><td></td><td></td><td></td><td>" +
				"<a style='cursor:pointer;' onclick='seeOriginalReport(\"" +
				src +
				"\")'>查看原始报告单</a>" +
				"</td></tr></table></div></div>";
			$(".tr-add").remove();
			if(expecialCheckStr.trim() != "") {
				$("#checkProjectTable").append(expecialCheckStr);
			}
			$("#checkProject-box").show();
		}
	});
}
//初始化echarts柱状图
var echarts2 = document.getElementById('echarts2');
var myEcharts2 = echarts.init(echarts2);
var option3 = {
	tooltip: {
		trigger: 'axis'
	},
	grid: {
		top: '10%',
	},
	calculable: true,
	xAxis: [{
		type: 'category',
		data: []
	}],
	yAxis: [{
		type: 'value',
		max: 10,
		min: 0,
	}],
	series: [{
		name: '血糖',
		type: 'bar',
		data: [],
		barWidth: 30
	}]
};
myEcharts2.setOption(option3);
//柱状图点击事件
function showEcharts2(m) {
	var element2;
	if(m == 1) {
		$("#mainContentName").text("产检摘要");
		element2 = $(".add_checkReport");
	} else {
		$("#mainContentName").text("自测摘要");
		element2 = $(".add_selfTest");
	}
	var nameList = [];
	var timeList = [];
	element2.each(function() {
		nameList.push($(this).find("td:nth-child(1)").text());
		timeList.push($(this).find("td:nth-child(2)").text().replace("项", "").replace("次", ""));
	})
	myEcharts2.setOption({
		xAxis: {
			data: nameList
		},
		series: [{
			data: timeList
		}]
	});
	if(element2.length != 0) {
		$("#echarts2-box").show();
	} else {
		if(m == 1) {
			alert("暂无产检数据");
		} else {
			alert("暂无自测数据");
		}
	}
};
//报告预览
$(".but3").click(function() {
	var now2 = new Date();
	console.log(1);
	sessionStorage.setItem("viewDoctorStr", $("#thisAdvice_content").text());
	sessionStorage.setItem("week", $(".gWeek").text());
	sessionStorage.setItem("weeklyReportDate", longToDate(now2));
	$("#iframe_report1").attr("src", "../../Remotelnterrogation/weeklyTemplate2.html");
	$('.swiper-container').show();
})
//历史记录预览
function seeWeeklyReport(week, date, advice) {
	sessionStorage.setItem("viewDoctorStr", advice);
	sessionStorage.setItem("week", week);
	sessionStorage.setItem("weeklyReportDate", date);
	$("#iframe_report1").attr("src", "../../Remotelnterrogation/weeklyTemplate2.html");
	$('.swiper-container').show();
}
//关闭事件
$('.close-move').click(function(i) {
	$(this).parent().hide();
});
//拖动
drag($("#selfTest-box"));
drag($("#checkProject-box"));
drag($("#echarts2-box"));
//替换空值
function replaceUndefined(str) {
	if(str == undefined || str == null) {
		return "暂无数据"
	}
	return str;
}