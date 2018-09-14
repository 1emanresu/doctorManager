var doctorId = sessionStorage.getItem('doctorId');
//address = "http://192.168.1.38:8080/doctormanager/";
$(function() {
	addCheEvent(); //为报告上传完整度弹出框添加事件
	//弹出框关闭时间---通用
	$('.close-move').click(function() {
		$(this).parent().hide();
	});
	$('div[class=right_firm_container] label').click(function() {
		if(this.innerText == "高危分型分级标准?") {
			location.href = "../function/riskAnalysis.html";
		} else if(this.innerText == "已购服务类型说明?") {
			location.href = "../function/servicePurchase.html";
		}
	});
	$('#hiskGrade').append(prfhiskGrade());
	$('#weeksQuery').append(prfweeksQuery());
	//需要拖动的元素;
	drag($('#checkReportData')); //检查完整度框
	drag($('#selfTest-box')); //自测弹出框
	drag($('#risk-box')); //风险模型框
	drag($('.service1')); //vip服务
	drag($('#hCheck-box')); //vip服务
	drag($("#service-count")); //服务类型统计
});
//获取vip等级列表 author zhangqt
function getVipList() {
	$.ajax({
		type: "post",
		url: address + "vipGrade/find.do",
		async: true,
		success: function(d) {
			var data = d.data;
			var htm = "<option value='-1'>选择套餐</option>";
			for(var i = 0; i < data.length; i++) {
				htm += "<option value='" + data[i].vipgradeid + "'>" + data[i].vipgradename + "</option>";
			}
			$(".vipGrade").append(htm);
		}
	});
}

//重置搜索input
function resetInput() {
	$(".vipGrade option").eq(0).attr("selected", "selected");
	$(".weeks option").eq(0).attr("selected", "selected");
	$(".hiskGrade option").eq(0).attr("selected", "selected");
	$(".gname").val('');
	$(".g_age").val('');
	$(".medicalrecordno").val("");
}

//获取检查数据---已检查与未检查的
function getDataWz(row, week, percentage) {
	//按钮的颜色为未点击状态
	$("#sendingPeople2 button,#sendingWay2 button").css({
		"background-color": "white",
		"border": "1px solid gainsboro",
		"color": "#666"
	});
	//推荐项目，已检查，未检查默认为‘无’
	$("#div-button2").html('无');
	$("#checkProjecButton2").html('无');
	$("#inCheck").html('<span style="color:#696969;">无</span>');
	$("#checkProject").html('无');
	$("#notCheck").html('无');
	$(".gname2").html(row.gName);
	$(".gname").html(row.gName);
	$("#gWeek").html(week);
	var circles = [];
	//生成圆形进度条
	circles.push(Circles.create({
		id: 'circleForHCheck', //要显示圆形进度条的元素id
		value: percentage, //百分比
		radius: 65, //圆形的大小
		width: 20, //圆形的线条粗细
		colors: ['#2EDFC3', '#206FF7'] //圆形的颜色--数组类型
	}));
	$.ajax({
		type: "post",
		url: address + "weekly/findCheckProject.do",
		data: {
			mid: row.mId,
			week: week
		},
		async: false,
		success: function(d) {
			//console.log(JSON.stringify(d.data))
			if(d.data != null) {
				var data = d.data;
				//检查了的项目
				var inCheck = "";
				var inCheck2 = "";
				var inHtml = "";
				//判断有没有检查了的报告
				if(data.in.length != 0) {
					$('#check-table').css('display', 'block');
					queryBypid(data.in[0].pid, data.in[0].name, week, row.mId);
				} else {
					$("#div-table2").css("margin-left", "80px");
					$("#circleForHCheck").css("margin-left", "120px");
					$('#check-table').css('display', 'none');
				}
				//处理点击检查项目名称查看报告
				for(var i = 0; i < data.in.length; i++) {
					inHtml += "<button>" + data.in[i].name + "<img  onclick='addBut(this)' src='../images/blueAdd.png'/></button>";
					if(i == 0) {
						inCheck2 += data.in[i].name;
						inCheck += "<a class='pointer' onclick='queryBypid(" + data.in[i].pid + ",\"" + data.in[i].name + "\"," + week + ",\"" + row.mId + "\")'>" + data.in[i].name + "</a>";
					} else {
						inCheck2 += "、" + data.in[i].name;
						inCheck += "、<a class='pointer' onclick='queryBypid(" + data.in[i].pid + ",\"" + data.in[i].name + "\"," + week + ",\"" + row.mId + "\")'>" + data.in[i].name + "</a>";
					}
				}
				var notCheck = "";
				var notHtml = "";
				for(var i = 0; i < data.not.length; i++) {
					notHtml += "<button>" + data.not[i].name + "<img  onclick='removeBut(this)' src='../images/redClose.png'/></button>"
					if(i == 0) {
						notCheck += data.not[i].name;
					} else {
						notCheck += "、" + data.not[i].name;
					}
				}

				$("#div-button2").html('').html(inHtml);
				$("#checkProjecButton2").html('').html(notHtml);
				$("#inCheck").html('').html(retuWu(inCheck));
				//所有需要检查的项目
				var allCheck = inCheck2 + "、" + notCheck;
				$("#checkProject").html('').html(retuWu(allCheck));
				$("#notCheck").html('').html(retuWu(notCheck));
			} else {
				$("#div-table2").css("margin-left", "80px");
				$("#circleForHCheck").css("margin-left", "120px");
				$('#check-table').css('display', 'none');
			}
		}
	});
	$("#comfirmSending2").attr("onclick","comfirmSending(\""+row.mId+"\")");
	$("#hCheck-box").show();
}

function retuWu(str) {
	if(str.trim() == "") {
		return "<span style='color:#696969;'>无</span>";
	}
	return str;
}

//发送院检报告提醒
function comfirmSending(mid) {
	var remindProjectStr = ""
	$("#checkProjecButton2 button").each(function() {
		if($(this).css("display") != "none") {
			if(remindProjectStr == "") {
				remindProjectStr += $(this).text();
			} else {
				remindProjectStr += "~" + $(this).text();
			}
		};
	});
	if(remindProjectStr == "") {
		alert("请添加提醒项目");
	} else {
		var peoplestr = "";
		var relationIds = [];
		$("#sendingPeople2 button").each(function() {
			if($(this).css("background-color") == "rgb(252, 195, 0)") {
				relationIds.push($(this).attr("data"));
				if(peoplestr == "") {
					peoplestr += $(this).text();
				} else {
					peoplestr += "~" + $(this).text();
				}
			}
		})
		if(peoplestr == "") {
			alert("请选择发送对象");
		} else {
			var remindWay = "";
			var sendingWay = [];
			$("#sendingWay2 button").each(function() {
				if($(this).css("background-color") == "rgb(252, 195, 0)") {
					sendingWay.push($(this).attr("data"));
					if(remindWay == "") {
						remindWay += $(this).text();
					} else {
						remindWay += "~" + $(this).text();
					}
				}
			})
			if(remindWay == "") {
				alert("请选择提醒方式");
			} else {
				$.ajax({
					type: "post",
					dataType: "json",
					data: {
						"mid": mid, //孕妇id
						"doctorid": sessionStorage.getItem("doctorId"),
						"sendingways": remindWay, //提醒方式
						"acceptedpeople": peoplestr, //提醒人
						"reportReminder": remindProjectStr //提醒项目
					},
					url: address + "Reminder/insertReminder.do",
					success: function(result) {
						var reg = new RegExp("~", "g")
						var selfTestStr = remindProjectStr.replace(reg, "、");
						var content =$(".gname2").text()+ $(".cont-1").text()+ selfTestStr +$(".cont-2").text();
						var Msgdata = {
							"relationIds": relationIds,
							"title": "",
							"content": content
						};
						$.each(sendingWay, function(i) {
							if(sendingWay[i] == 1) {
								pushSmsMsg(mid, 3, Msgdata);
							} else if(sendingWay[i] == 2) {
								Msgdata.title="报告上传提醒";
								pushAppMsg(mid, 3, Msgdata);
							} else if(sendingWay[i] == 3) {
								Msgdata.title="报告上传提醒";
								pushWeChatMsg(mid, 3, Msgdata);
							}
						});
						alert("发送成功！");
						$("#hCheck-box").hide();
					},
					error: function() {

					}
				});
			}
		}
	}
}

//为报告上传完整度弹出框添加事件
function addCheEvent() {
	//显示与隐藏微信客服追踪记录
	var flag = true;
	$("#weChat-service2").click(function() {
		if(flag) {
			$("#weChat-record2").show();
			flag = false;
		} else {
			$("#weChat-record2").hide();
			flag = true;
		}
		//图片转向
		$('#index-top').toggleClass("rotate-img");
	});
	//取消按钮
	$("#cancel2").click(function() {
		$("#hCheck-box").hide();
	})
	$("#sendPeopleAndWay2 div span button").click(function() {
		if($(this).css("background-color") != "rgb(252, 195, 0)") {
			$(this).css({
				"background-color": "#FCC300",
				"border": "1px solid #FCC300",
				"color": "white"
			});
			var src = $(this).find("img").attr("src").replace("1","2");
			$(this).find("img").attr("src",src);
		} else {
			$(this).css({
				"background-color": "white",
				"border": "1px solid gainsboro",
				"color": "#666"
			});
			var src = $(this).find("img").attr("src").replace("2","1");
			$(this).find("img").attr("src",src);
		}
	})
}
//减少检查项目的提醒
function removeBut(that) {
	$(that).parent().remove();
	$("#div-button2").append("<button>" + $(that).parent().text() + "<img onclick='addBut(this)' src='../images/blueAdd.png'/></button>");
}
//增加检查项目的提醒
function addBut(that) {
	$(that).parent().remove();
	$("#checkProjecButton2").append("<button>" + $(that).parent().text() + "<img onclick='removeBut(this)'  src='../images/redClose.png'/></button>")
}

function queryBypid(pid, proName, week, mid) {
	var report = checkReport({
		checkProjectId: pid,
		weeks: week,
		mid: mid,
		htmlType: 'table-box'
	});
	$("#check-result").html('').html(report);
	$(".proName").html(proName);
	var picLink = checkReport.prototype.picLink == undefined ? '' : checkReport.prototype.picLink;
	$(".report-table").append("<tr><td colspan='4' class='pointer' onclick='seeOriginalReport(\"" + picLink + "\")'><a>查看原始报告</a></td></tr>");
	$("#div-table2").css("margin-left", "15px");
	$("#circleForHCheck").css("margin-left", "0");
}

//去掉最后一个字符
function delLastStr(str) {
	var strs = str.substring(0, str.length - 1);
	return strs;
}

//计算高危级别
function getriskType(score) {
	var highType = "";
	if(score == 0) {
		return "无高危";
	}
	$.ajax({
		type: "post",
		url: address + "highRiskResultType/queryByType.do",
		data: {
			score: score
		},
		async: false,
		success: function(d) {
			var data = d.data;
			if(data != null) {
				highType = "<span style='color:red;'>" + data.highriskresulttype + "</span>";
			} else {
				highType = "<span style='color:red;'>极度高危</span>";
			}
		}
	});
	return highType;
}

//获取检查项目完成百分比
function getPercentage(row) {
	var percentage = 0;
	//孕周
	var weeks = getWeeks(row.endDate).weeks;
	$.ajax({
		type: "post",
		url: address + "weekly/findCheckProjectAll.do",
		data: {
			mid: row.mId,
			weeks: weeks
		},
		async: false,
		success: function(d) {
			percentage = d.data.sum.toFixed(0);
			if(percentage > 100) {
				percentage = 100;
			}
		}
	});
	var htm = "<div  onclick='getDataWz(" + JSON.stringify(row) + "," + weeks + ",\"" + percentage + "\")' id='data_firstDiagnos_schedule'><div class='class_schedule'>";
	htm += "<div class='bar' style='width: " + percentage + "%;'></div></div><div class='p_schedule'>" + percentage + "%</div></div>";
	return htm;
}

//自测数据上传完整度
function getTestPercentage(row) {
	var result;
	var sum = 0;
	$.ajax({
		type: "post",
		url: address + "selfTest/findThis.do",
		dataType: "json",
		data: {
			mid: row.mId
		},
		async: false,
		success: function(d) {
			sum = d.percentage;
			result = d;

		},
	});
	var htm = "<div onclick='familyTestData(" + JSON.stringify(row) + "," + JSON.stringify(result) + ")' id='data_firstDiagnos_schedule'><div class='class_schedule blue'>";
	htm += "<div class='pbcolor' style='width: " + sum + "%;'></div></div><div class='p_schedule'>" + sum + "%</div></div>";
	return htm;
}

//自测数据弹窗
function familyTestData(row, result) {
	sessionStorage.setItem("mid", row.mId);
	$("#sendPeopleAndWay div span button").css({
		"background-color": "white",
		"border": "1px solid gainsboro",
		"color": "#666"
	})
	var circles = [];
	var notDoneTypeStr = "";
	$("#div-button button").show();
	$("#checkProjecButton button").hide();
	//表格赋值
	$.each(result.selfTestNotDoneType, function(i) {

		if(i == 0) {
			notDoneTypeStr += result.selfTestNotDoneType[i];
		} else {
			notDoneTypeStr += "、" + result.selfTestNotDoneType[i];
		}
	})
	if(result.selfTestNotDoneType.length == 0) {
		notDoneTypeStr = "无";
	}
	$("#selfTestNotDone").text(notDoneTypeStr);
	var doneStr = ""
	$.each(result.selfTestNotDoneType, function(i) {
		$("#div-button button").each(function() {
			if($(this).text() == result.selfTestNotDoneType[i]) {
				$(this).hide();
			}
		})
		$("#checkProjecButton button").each(function() {
			if($(this).text() == result.selfTestNotDoneType[i]) {
				$(this).show();
			}
		})
	});
	$.each(result.selfTestDoneType, function(i) {
		if(i == 0) {
			doneStr += "<span class='showEcharts firstshowEcharts'>" + result.selfTestDoneType[i] + "</span>";
		} else {
			doneStr += "、<span class='showEcharts'>" + result.selfTestDoneType[i] + "</span>";
		}
	});
	if(doneStr == "") {
		doneStr = "<span style='color:#666;cursor:default'>无</span>";
		hideEcharts();
	}
	$("#selfTestDone").html(doneStr);

	//圆环
	circles.push(Circles.create({
		id: 'circleForSelfTest', //要显示圆形进度条的元素id
		value: result.percentage, //百分比
		radius: 65, //圆形的大小
		width: 20, //圆形的线条粗细
		colors: ['#FCC300', '#FE9E00'] //圆形的颜色--数组类型 
	}));
	//微信客服弹出框隐藏显示
	var flag = true;
	$("#weChat-record").hide();
	//发送提醒
	$("#comfirmSending").click(function() {
		var remindProjectStr = ""
		$("#checkProjecButton button").each(function() {
			if($(this).css("display") != "none") {
				if(remindProjectStr == "") {
					remindProjectStr += $(this).text();
				} else {
					remindProjectStr += "~" + $(this).text();
				}
			};
		});
		if(remindProjectStr == "") {
			alert("请添加提醒项目");
		} else {
			var peoplestr = "";
			var relationIds = [];
			$("#sendingPeople button").each(function() {
				if($(this).css("background-color") == "rgb(252, 195, 0)") {
					relationIds.push($(this).attr("data"));
					if(peoplestr == "") {
						peoplestr += $(this).text();
					} else {
						peoplestr += "~" + $(this).text();
					}
				}
			})
			if(peoplestr == "") {
				alert("请选择发送对象");
			} else {
				var remindWay = "";
				var sendingWay = [];
				$("#sendingWay button").each(function() {
					if($(this).css("background-color") == "rgb(252, 195, 0)") {
						sendingWay.push($(this).attr("data"));
						if(remindWay == "") {
							remindWay += $(this).text();
						} else {
							remindWay += "~" + $(this).text();
						}
					}
				})
				if(remindWay == "") {
					alert("请选择提醒方式");
				} else {
					$.ajax({
						type: "post",
						dataType: "json",
						data: {
							"mid": sessionStorage.getItem("mid"), //孕妇id
							"doctorid": sessionStorage.getItem("doctorId"),
							"sendingways": remindWay, //提醒方式
							"acceptedpeople": peoplestr, //提醒人
							"selftestdetails": remindProjectStr //提醒项目
						},
						url: address + "Reminder/insertReminder.do",
						success: function(result) {
							var content = $(".smsContent").text();
							var reg = new RegExp("~", "g")
							var selfTestStr = remindProjectStr.replace(reg, "、");
							content = content.replace("replaceContent", selfTestStr)
							var Msgdata = {
								"relationIds": relationIds,
								"title": "",
								"content": content
							};
							$.each(sendingWay, function(i) {
								if(sendingWay[i] == 1) {
									pushSmsMsg(row.mId, 3, Msgdata);
								} else if(sendingWay[i] == 2) {
									Msgdata.title="自测提醒";
									pushAppMsg(row.mId, 3, Msgdata);
								} else if(sendingWay[i] == 3) {
									Msgdata.title="自测提醒";
									pushWeChatMsg(row.mId, 3, Msgdata);
								}
							});
							alert("发送成功！");
							$("#selfTest-box").hide();
						},
						error: function() {

						}
					});
				}
			}
		}
	});
	//echarts出现方法
	$(".showEcharts").click(function() {
		$("#div-echarts").show();
		$("#div-suggestProject").css("width", "280px");
		$("#circleForSelfTest").css("margin-top", "30px");
		$("#div-table").css({
			"margin-left": "20px",
			"width": "280px"
		})
		$("#circleForSelfTest").css("margin-left", "0");
		$("#selfTestProject").text($(this).text());
		if($(this).text() == "体重") {
			weightSetDate(row.mId);
		} else if($(this).text() == "血糖") {
			bloodsugreSetDate(row.mId);
		} else if($(this).text() == "血压") {
			bloodpressureSetDate(row.mId);
		} else if($(this).text() == "腹围") {
			abdominalgirthSetDate(row.mId);
		} else if($(this).text() == "宫高") {
			fundalheightSetDate(row.mId);
		} else if($(this).text() == "胎动") {
			featalMovementSetDate(row.mId);
		} else if($(this).text() == "胎心") {
			featalHeartSetDate(row.mId);
		}
	});
	$(".firstshowEcharts").click();
	//名字、孕周赋值
	$(".gname").text(row.gName);
	var week = getWeeks(row.endDate).weeks;
	if(week < 20) {
		$("#suggestProject").text("体重、血压、血糖");
	} else {
		$("#suggestProject").text("体重、血压、血糖、宫高、腹围、胎动、胎心");
	}
	$("#gWeek2").text(week);
	sessionStorage.setItem("week", week);
	$("#selfTest-box").show();
}

//发送提醒 
function send_reminder() {
	var mid = $("#send_mid").val();
	var selected_selfTest = '';
	if($(".select_bloodsugar:checked").next().find("option:selected").text() != '') {
		selected_selfTest += $(".select_bloodsugar:checked").next().find("option:selected").text();
		$(".selected_selfTest:checked").each(function() {
			selected_selfTest += "~" + $(this).next().text();
		});
	} else {
		$(".selected_selfTest:checked").each(function(i) {
			if(i == 0) {
				selected_selfTest += $(this).next().text();
			} else {
				selected_selfTest += "~" + $(this).next().text();
			}
		});
	}
	if($("#thisAdvice_content").val() == '' && selected_selfTest == '') {
		alert("请输入提醒内容或勾选提醒项目");
	} else {
		var sendTo_people = '';
		$(".sendTo_people:checked").each(function(i) {
			if(i == 0) {
				sendTo_people += $(this).next().text();
			} else {
				sendTo_people += "~" + $(this).next().text();
			}
		});
		var sending_way = '';
		$(".sending_way:checked").each(function(i) {
			if(i == 0) {
				sending_way += $(this).next().text();
			} else {
				sending_way += "~" + $(this).next().text();
			}
		});
		if(sendTo_people == '' || sending_way == '') {
			alert("请选择接收人或提醒方式");
		} else {
			var doctor_advice = $("#thisAdvice_content").val();
			$.ajax({
				type: "post",
				dataType: "json",
				data: {
					"mid": mid,
					"doctorid": doctorId,
					"monitoringsuggestion": doctor_advice,
					"sendingways": sending_way,
					"acceptedpeople": sendTo_people,
					"selftestdetails": selected_selfTest
				},
				url: address + "Reminder/insertReminder.do",
				success: function(result) {
					alert("发送成功！");
					sendNoticeClose();
				},
				error: function() {

				}
			});
		}
	}
}

/*转高危模块 author zhangqt*/
//选择高危类别，右边显示值--转高危
function selectRiskType(i) {
	if($(".select_risk_type" + i).is(':checked')) {
		$(".hisk_trans_content div label input:checked").prop("checked", false);
		$(".select_risk_type" + i).prop("checked", true);
		$(".risk_type_change").hide();
		$("#select_risk_type" + i).show();
	} else {
		$("#select_risk_type" + i).hide();
		$(".select_risk_type" + i).prop("checked", false);
	}
}

//删除选择好的高危类型--转高危
function deleteRiskType(i) {
	$("#select_risk_type" + i).hide();
	$(".select_risk_type" + i).prop("checked", false);
}

//取消按钮--转高危
function transHighRiskClose() {
	$('#trans_high_risk').modal('hide');
}

var seperator = "-";

function changeRiskType(mid) {
	$.ajax({
		type: "post",
		url: address + "abnormityinfo/findByWeeks.do",
		data: {
			"mid": mid,
			"sWeeks": 0,
			"eWeeks": 40
		},
		dataType: "json",
		ContentType: "application/x-www-form-urlencoded;charset=utf-8",
		success: function(e) {
			var list = e.data;
			var scoreSum = 0;
			var table = '<tr class="tr_width"><td>序号</td><td>出现时间</td><td>出现孕周</td><td>风险因素</td><td>高危分值</td></tr>'
			var riskType = "正常";
			$.each(list, function(i) {
				scoreSum += Number(list[i].score);
				if(list[i].cunit == '' || list[i].cunit == null) {
					unit = ''
				} else {
					unit = list[i].cunit;
				}
				var date = new Date(list[i].checkdate);
				//var seperator1 = "-";
				var year = date.getFullYear();
				var month = date.getMonth() + 1;
				if(month < 10) {
					month = "0" + month;
				};
				var strDate = date.getDate();
				if(strDate < 10) {
					strDate = "0" + strDate;
				}
				var currentdate = year + seperator + month + seperator + strDate;
				table += "<tr class='tr_width'><td>" + (i + 1) + "</td><td class='class_color'>" + currentdate + "</td><td class='class_color'>" + list[i].weeks + "</td><td class='class_color'>" + list[i].cname + "≥" + (Number(list[i].cend) + Number(list[i].difference)) + unit + "或≤" + (Number(list[i].cbegin) - Number(list[i].difference)) + unit + "</td><td class='class_color'>" + list[i].score + "</td></tr>"
			});
			if(scoreSum > 0 && scoreSum <= 10) {
				riskType = "轻度高危";
			} else if(scoreSum > 10 && scoreSum <= 20) {
				riskType = "中度高危";
			} else if(scoreSum > 20 && scoreSum <= 30) {
				riskType = "重度高危";
			} else if(scoreSum >= 40) {
				riskType = "极度高危";
			} else {
				riskType = "无高危";
			}
			if(riskType == "无高危") {
				$(".high_school").html("建议患者继续保持。");
			} else {
				$(".high_school").html("建议加入高危患者管理，以便及时通知患者。");
			}
			$(".high_type").html(riskType);
			$("#table_risk_detail tr").remove();
			$("#table_risk_detail").append(table);
			$("#risk_type").text(riskType);
			$("#risk_score").text(scoreSum);
		},
		error: function() {

		}
	});
}

function sendHigh(mid) {
	changeRiskType(mid);
	sessionStorage.setItem("mid", mid);
	$('#trans_high_risk').modal('show')
}
//确定按钮--转高危
function sendRiskTypeChange() {
	var mid = sessionStorage.getItem("mid");
	var patientType = $(".select_risk_type:checked").parent().text().trim();
	if(patientType == '') {
		alert("请选择高危类型");
	} else {
		var sendTo_people1 = '';
		$(".sendTo_people1:checked").each(function(i) {
			if(i == 0) {
				sendTo_people1 += $(this).next().text();
			} else {
				sendTo_people1 += "~" + $(this).next().text();
			}
		});
		var sending_way1 = '';
		$(".sending_way1:checked").each(function(i) {
			if(i == 0) {
				sending_way1 += $(this).next().text();
			} else {
				sending_way1 += "~" + $(this).next().text();
			}
		});
		if(sendTo_people1 == '' || sending_way1 == '') {
			alert("请选择接收人或提醒方式");
		} else {
			var doctor_advice = $("#thisAdvice_content").val();
			$.ajax({
				type: "post",
				dataType: "json",
				data: {
					"mid": mid,
					"doctorid": doctorId,
					"monitoringsuggestion": patientType,
					"sendingways": sending_way1,
					"acceptedpeople": sendTo_people1
				},
				url: address + "Reminder/insertReminder1.do",
				success: function(result) {
					var Msgdata = getHighMessage();
					if($('#messages').is(':checked')){
						console.log('短信通知')
						pushSmsMsg(mid, 3, Msgdata)
					}
					if($('#wechats').is(':checked')){
						console.log('微信通知')
						pushWeChatMsg(mid, 3, Msgdata)
					}
					if($('#apps').is(':checked')){
						console.log('App通知')
						pushAppMsg(mid, 3, Msgdata)
					}
					alert("发送成功！");
					transHighRiskClose();
					window.location.reload();
				},
				error: function(e) {
					console.log(JSON.stringify(e))
				}
			});
		}
	}
}

//輸出下拉框高危级别hiskGrade
function prfhiskGrade() {
	var str = "<option value='0'>全部高危</option>";
	$.ajax({
		type: "post",
		url: address + "highRiskResultType/queryAll.do",
		async: false,
		success: function(d) {
			var data = d.data;
			for(var i = 0; i < data.length; i++) {
				str += "<option value='" + data[i].highriskresulttypeid + "'>" + data[i].highriskresulttype + "</option>";
			}
		}
	});
	return str;
}
//輸出下拉框weeksQuery
function prfweeksQuery() {
	var str = "";
	str = str.concat('<option value="1-41">选择孕周</option>');
	str = str.concat('<option value="6-13">6-13周</option>');
	str = str.concat('<option value="14-20">14-20周</option>');
	str = str.concat('<option value="20-24">20-24周</option>');
	str = str.concat('<option value="24-28">24-28周</option>');
	str = str.concat('<option value="28-32">28-32周</option>');
	str = str.concat('<option value="33-36">33-36周</option>');
	str = str.concat('<option value="37-41">37-41周</option>');
	return str;
}
/*end*/
//获取vip等级列表
function getVipGrade(value, row, index) {
	return "<a style='cursor: pointer;' onclick='VipDescDate(" + JSON.stringify(row) + ")'>" + un(row.vipGradeName) + "</a>";
}

//点击vip弹出框
function VipDescDate(data) {
	//保存孕妇的末次月经到session中
	sessionStorage.setItem('endDate', data.endDate);
	//vip套餐开始时间
	var sdate = longToDate(data.sdate);
	//vip套餐结束时间
	var edate = longToDate(data.edate);
	if(data.vipId == 100) {
		$('.v-name').html('微报告'); //套餐名称
		$('.vip-itn').html('一个月四次微健康报告，每周诊断并下发一次报告');
		$('.vip-ill').html('每周向孕妈妈下发一份诊断的微健康报告，微健康报告需在指定日期1个工作日内处理<br>完成。'); //操作指导说明
		$('.vip-sedate').html(sdate + ' 至 ' + edate); //开始与结束时间
		$('.vip-num1').html("待发报告份数：" + data.surplus_weekly + "份"); //剩余分数
		$('.manual span').html('样例预览').attr('onclick', 'location.href=""'); //样例预览
		$('.manual').attr("onclick","operationGuide(1)")
		$('.ser-small').html('微健康报告处理小贴士：');
		$('.vip-small').html('<br>1、检阅孕产妇家庭测量项目，审核本周各项身体指标情况；<br>2、结合自觉症状描述以及当前孕程产检报告进行诊疗并下发医嘱，发送报告。');
		$('.see-report').html('查看已发报告').attr("onclick", "setMidAndSkip(\"" + data.mId + "\",\"../function/seeWeekly.html\")"); //查看已发报告
		$('.serviceCount').attr("onclick", "typeCount(1)");
		$('.vip-img2,.vip-num2').hide();
	} else if(data.vipId == 101) {
		$('.v-name').html('医嘱远程问诊'); //套餐名称
		$('.vip-itn').html('每月一次综合医嘱下发+三次远程问诊'); //操作指导
		var str1 = '<br>1、针对孕产妇每月上传的产检报进行告分析诊断，下发医嘱；医嘱需在指定日期1个工作日内处理完成。';
		str1 += '<br>2、孕产妇会通过袋鼠妈妈APP进行远程问诊的预约，医生需按照预约时间上线，接诊预约的孕产妇。';
		var str = '<br>综合医嘱下发：综合概览当前孕周所有产检报告，结合异常指标项进行诊断，下发医嘱。<br>远程问诊：';
		str += '<br />1、通过孕程导航回顾孕产妇历史身体状况，查阅当前孕程产检报告；';
		str += '<br />2、了解孕产妇自觉症状，家庭自测项目曲线趋势图；';
		str += '<br />3、结合问询情况对孕产妇本周身体情况进行诊断，进行膳食、运动等多方面指导；';
		str += '<br />4、审阅问诊记录并下发。';
		$('.ser-small').html('服务处理小贴士：');
		$('.vip-ill').html(str1); //操作指导说明
		$('.vip-small').html(str);
		$('.vip-sedate').html(sdate + ' 至 ' + edate); //开始与结束时间
		$('.vip-num1').html("待发发送医嘱：" + data.surplus_diagnosis + "份"); //剩余分数
		$('.vip-num2').html("待处理远程问诊次数：" + data.surplus_diagnosis + "份"); //剩余分数
		$('.manual span').html('远程问诊操作指导').attr('onclick', 'location.href=""'); //样例预览
		$('.manual').attr("onclick","operationGuide(2)")
		$('.see-report').html('查看已发医嘱').attr("onclick", "setMidAndSkip(\"" + data.mId + "\",\"../function/seeAdvice2.html\")"); //查看已发医嘱
		$('.vip-img2,.vip-num2').show();
		$(".see-advice").attr("onclick", "setMidAndSkip(\"" + data.mId + "\",\"../function/seeInterrogation.html\")");
		$('.serviceCount').attr("onclick", "typeCount(2)");
	}
	$(".service1").show();
}

//点击开通服务类型统计
function typeCount(i) {
	$("#service-count").show();
	if(i == 1) {
		$(".serviceV1").show();
		$(".serviceV2").hide();
	} else {
		$(".serviceV1").hide();
		$(".serviceV2").show();
	}
}

//点击操作指南
function operationGuide(i) {
	if(i==1){
		location.href='../function/ZBoperationManual.html';
	}else{
		location.href='../function/WZoperationManual.html';
	}
}

//跳转并且跳到指定的页面--zhangqt
function setMidAndSkip(mid, page) {
	sessionStorage.setItem('mid', mid);
	location.href = page;
}
//风险模型框
function selectGravida(id, data) {
	$(".select-gravida").prop("checked", false);
	$("#" + id).prop("checked", true);
	//获取echarts图表信息
	getRiskModel('div-modelChart', JSON.stringify(data), 'risk_result')
}
//风险模型框
function showMoreRisk(id, str) {
	selectGravida(id, str);
	//高危弹出框显示
	$("#risk-box").show();
}
//自测弹出框点击事件
//按钮点击变色
$("#sendPeopleAndWay div span button").click(function() {
	if($(this).css("background-color") != "rgb(252, 195, 0)") {
		$(this).css({
			"background-color": "#FCC300",
			"border": "1px solid #FCC300",
			"color": "white"
		});
		var src = $(this).find("img").attr("src").replace("1","2");
		$(this).find("img").attr("src",src);
	} else {
		$(this).css({
			"background-color": "white",
			"border": "1px solid gainsboro",
			"color": "#666"
		});
		var src = $(this).find("img").attr("src").replace("2","1");
		$(this).find("img").attr("src",src);
	}
})
$("#weChat-service").click(function() {
	if(flag) {
		$("#weChat-record").show();
		flag = false;
	} else {
		$("#weChat-record").hide();
		flag = true;
	}
	$('#index-top').toggleClass("rotate-img");
});
//关闭弹出框
$("#cancel").click(function() {
	$("#selfTest-box").hide();
})
//echarts出现和隐藏，样式改变
function hideEcharts() {
	$("#div-echarts").hide();
	$("#div-suggestProject").css("width", "365px");
	$("#div-table").css({
		"margin-left": "80px",
		"width": "auto"
	})
	$("#circleForSelfTest").css("margin-left", "120px");
	$("#circleForSelfTest").css("margin-top", "10px");
};
//添加和删除提醒项目
$(".redClose").click(function() {
	$(this).parent().hide();
	var buttonStr = $(this).parent().text();
	$("#div-button button").each(function() {
		if($(this).text() == buttonStr) {
			$(this).show();
		}
	})
});
$(".blueAdd").click(function() {
	$(this).parent().hide();
	var buttonStr = $(this).parent().text();
	$("#checkProjecButton button").each(function() {
		if($(this).text() == buttonStr) {
			$(this).show();
		}
	})
});

//周报已处理、未处理饼图
function weeklyReportPie() {
	var option;
	var weeklyReportEchart = document.getElementById('weeklyReportEchart');
	var weeklyReportChart = echarts.init(weeklyReportEchart);
	$.ajax({
		type: "post",
		dataType: 'json',
		url: sessionStorage.getItem("address") + "dataSummary/queryWeeklyHandleNum.do",
		data: {

		},
		success: function(e) {
			var dataJson = e.data;
			option = {
				tooltip: {
					trigger: 'item',
					formatter: "{a} <br/>{b}: {c} ({d}%)"
				},
				legend: {
					orient: 'vertical',
					bottom: "0px",
					data: ['已发报告', '待发报告'],
					itemWidth: 14,
					formatter: function(name) {
						if(name == "已发报告") {
							return name + ' ' + dataJson.ins + "人";
						} else {
							return name + ' ' + dataJson.not + "人";
						}
					}
				},
				series: [{
					name: '微健康报告',
					type: 'pie',
					radius: ['60%', '70%'],
					center: ['50%', '40%'],
					startAngle: 0,
					cursor: 'auto',
					avoidLabelOverlap: false,
					itemStyle: {
						normal: {
							color: function(params) {
								var colorList = ['#79D0F4', 'rgba(255,255,255,0)'];
								return colorList[params.dataIndex];
							}
						}
					},
					label: {
						normal: {
							show: false,
							position: 'center'
						},
						emphasis: {
							show: true,
							textStyle: {
								fontSize: '16',
								fontWeight: 'bold'
							}
						}
					},
					labelLine: {
						normal: {
							show: false
						}
					},
					data: [{
							value: dataJson.not,
							name: '待发报告'
						},
						{
							value: dataJson.ins,
							itemStyle: {
								emphasis: {
									opacity: 0
								}
							},
							tooltip: {
								trigger: 'trigger'
							}
						}
					]
				}, {
					name: '微健康报告',
					type: 'pie',
					startAngle: 0,
					radius: ['50%', '60%'],
					center: ['50%', '40%'],
					cursor: 'auto',
					avoidLabelOverlap: false,
					itemStyle: {
						normal: {
							color: function(params) {
								var colorList = ['#008CCF', 'rgba(255,255,255,0)'];
								return colorList[params.dataIndex];
							}
						},
					},
					label: {
						normal: {
							show: false,
							position: 'center'
						},
						emphasis: {
							show: true,
							textStyle: {
								fontSize: '16',
								fontWeight: 'bold'
							}
						}
					},
					labelLine: {
						normal: {
							show: false
						}
					},
					data: [{
							value: dataJson.ins,
							name: '已发报告'
						},
						{
							value: dataJson.not,
							itemStyle: {
								emphasis: {
									opacity: 0
								}
							},
							tooltip: {
								trigger: 'trigger'
							}
						}
					],
				}]
			};
			weeklyReportChart.setOption(option);
		}
	});

}

//周报已处理、未处理饼图
function adviceReportPie() {
	var option;
	var adviceReportEchart = document.getElementById('adviceReportEchart');
	var adviceReportChart = echarts.init(adviceReportEchart);
	$.ajax({
		type: "post",
		dataType: 'json',
		url: sessionStorage.getItem("address") + "dataSummary/queryAdviceHandleNum.do",
		data: {

		},
		success: function(e) {
			var dataJson = e.data;
			option = {
				tooltip: {
					trigger: 'item',
					formatter: "{a} <br/>{b}: {c} ({d}%)"
				},
				legend: {
					orient: 'vertical',
					bottom: "0px",
					data: ['已发医嘱', '待发医嘱'],
					itemWidth: 14,
					formatter: function(name) {
						if(name == "已发医嘱") {
							return name + ' ' + dataJson.ins + "人";
						} else {
							return name + ' ' + dataJson.not + "人";
						}
					}
				},
				series: [{
					name: '医嘱',
					type: 'pie',
					radius: ['60%', '70%'],
					center: ['50%', '40%'],
					startAngle: 0,
					cursor: 'auto',
					avoidLabelOverlap: false,
					itemStyle: {
						normal: {
							color: function(params) {
								var colorList = ['#79D0F4', 'rgba(255,255,255,0)'];
								return colorList[params.dataIndex];
							}
						}
					},
					label: {
						normal: {
							show: false,
							position: 'center'
						},
						emphasis: {
							show: true,
							textStyle: {
								fontSize: '16',
								fontWeight: 'bold'
							}
						}
					},
					labelLine: {
						normal: {
							show: false
						}
					},
					data: [{
							value: dataJson.not,
							name: '待发医嘱'
						},
						{
							value: dataJson.ins,
							itemStyle: {
								emphasis: {
									opacity: 0
								}
							},
							tooltip: {
								trigger: 'trigger'
							}
						}
					]
				}, {
					name: '医嘱',
					type: 'pie',
					startAngle: 0,
					radius: ['50%', '60%'],
					center: ['50%', '40%'],
					cursor: 'auto',
					avoidLabelOverlap: false,
					itemStyle: {
						normal: {
							color: function(params) {
								var colorList = ['#008CCF', 'rgba(255,255,255,0)'];
								return colorList[params.dataIndex];
							}
						},
					},
					label: {
						normal: {
							show: false,
							position: 'center'
						},
						emphasis: {
							show: true,
							textStyle: {
								fontSize: '16',
								fontWeight: 'bold'
							}
						}
					},
					labelLine: {
						normal: {
							show: false
						}
					},
					data: [{
							value: dataJson.ins,
							name: '已发医嘱'
						},
						{
							value: dataJson.not,
							itemStyle: {
								emphasis: {
									opacity: 0
								}
							},
							tooltip: {
								trigger: 'trigger'
							}
						}
					],
				}]
			};
			adviceReportChart.setOption(option);
		}
	});
}
//服务类型饼图
function serviceTypePie() {
	$.ajax({
		type: "post",
		dataType: 'json',
		url: sessionStorage.getItem("address") + "dataSummary/queryServiceTypeNum.do",
		data: {

		},
		success: function(e) {
			var dataJson = e.data;
			var serviceTypechart = document.getElementById('servicePie');
			var servicePieChart = echarts.init(serviceTypechart);
			option = {
				tooltip: {
					trigger: 'item',
					formatter: "{a} <br/>{b} : {c}人 ({d}%)"
				},
				legend: {
					bottom: "0px",
					orient: 'vertical',
					itemWidth: 14,
					data: ['健康周报服务', '医嘱问诊服务'],
					formatter: function(name) {
						if(name == "健康周报服务") {
							return name + " " + dataJson.weekly + "人";
						} else {
							return name + " " + dataJson.inquiry + "人";
						}

					}
				},
				calculable: true,
				series: [{
					name: '服务开通人群',
					type: 'pie',
					radius: [35, 90],
					center: ['48%', '40%'],
					roseType: 'roseType',
					label: {
						normal: {
							show: false
						}
					},
					data: [{
							value: dataJson.weekly,
							name: '健康周报服务'
						},
						{
							value: dataJson.inquiry,
							name: '医嘱问诊服务',
							itemStyle: {
								normal: {
									borderWidth: 1,
									borderColor: '#A6C8E6'
								}
							}
						}
					],
					color: ["#5B9BD5", "#f2f2f2"]
				}]
			};
			servicePieChart.setOption(option);
		}
	});
}