var mid = sessionStorage.getItem("mid");
var docId = sessionStorage.getItem("doctorId");
var address = sessionStorage.getItem("address");

$(function() {
	//获取历史医嘱
	getHistoryAdvice();
	//取消按钮事件
	$("#cancel").click(function() {
		location.href = "javascript:history.go(-1)";
	});

	//发送医嘱事件
	$("#submit").click(function() {
		//自测提醒 
		send_reminder();
	})
});

//获取历史医嘱
function getHistoryAdvice() {
	$.ajax({
		type: "post",
		dataType: "json",
		data: {
			"mid": mid,
		},
		url: address + "doctorAdvice/queryByMid.do",
		success: function(result) {
			var list = result.data;
			var table = '';
			if(list == null || list == '') {
				$('#advice_history').remove();
				$("#advice_record").text('暂无历史医嘱');
			} else {
				for(var i = 0; i < list.length; i++) {
					var advice = list[i].myknowledge;
					var date = list[i].advicedate;
					date = date.replace(/-/g, "/");
					var img = list[i].prescriptionimg;
					if(img == null || img == '') {
						table += '<tr><td>' + date + '</td><td>' + advice + '</td><td></td>';
					} else {
						var imgaddress = address + "doctor/pics/prescription/" + img;
						table += '<tr><td>' + date + '</td><td>' + advice + '</td><td><img src="' + imgaddress + '" width="100%" height="100%"/>' + '</td>';
					}
				}
				$('#advice_history').append(table);
			}
		},
		error: function() {

		}
	});
}


//发送医嘱提醒
function send_reminder() {
	var DocAdviceCont = $("#thisAdvice_content").html().trim();
	if(DocAdviceCont == '') {
		alert("请输入医嘱");
	} else{
		var peoplestr = "";
		var relationIds = [];
		$("#sendingPeople button").each(function() {
			if($(this).css("background-color") == "rgb(149, 188, 240)") {
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
				if($(this).css("background-color") == "rgb(149, 188, 240)") {
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
				var Msgdata={
					"relationIds": relationIds,
					"DocAdviceCont": DocAdviceCont
				}
				var date = new Date();
				var seperator = "-";
				var year = date.getFullYear();
				var month = date.getMonth() + 1;
				if(month < 10) {
					month = "0" + month;
				};
				var strDate = date.getDate();
				var currentdate = year + seperator + month + seperator + strDate;
				$.ajax({
					type: "post",
					dataType: "json",
					data: {
						"mid": mid,
						"doctorid": docId,
						"myknowledge": DocAdviceCont,
						"advicedate": currentdate,
						"sendingways": remindWay,
						"acceptedpeople": peoplestr
					},
					url: address + "Reminder/insert.do",
					success: function(result) {
						//更新处理状态--zhangqt
						updateState();
						//发送短信、APP推送
						$.each(sendingWay, function(i) {
							if(sendingWay[i] == 1) {
								pushSmsMsg(mid, 2, Msgdata);
							} else if(sendingWay[i] == 2) {
								pushAppMsg(mid, 2, Msgdata);
							}else if(sendingWay[i] == 3){
								pushWeChatMsg(mid, 2, Msgdata)
							}
						});
						alert("发送成功！");
					},
					error: function() {
		
					}
				});
			}
		}
	}
}

//更改为已处理状态--zhangqt
function updateState() {
	var odid = sessionStorage.getItem("odid");
	if(odid == '' || odid == null || odid == undefined) {
		return;
	}
	$.ajax({
		type: "get",
		url: address + "orderDetails/updateState.do",
		data: {
			odid: odid
		},
		async: false,
		success: function(e) {
		}
	});
}

$.ajax({
	type: "post",
	url: address + "abnormityinfo/findByWeeks.do",
	data: {
		"mid": mid,
		"sWeeks": 4,
		"eWeeks": 4
	},
	dataType: "json",
	ContentType: "application/x-www-form-urlencoded;charset=utf-8",
	success: function(e) {
		var list = e.data;
		var riskStr = '';
		var doctorAdviceStr = '';
		$.each(list, function(i) {
			if(list[i].cunit == '' || list[i].cunit == null) {
				unit = ''
			} else {
				unit = list[i].cunit;
			}
			riskStr += (i + 1) + '.' + list[i].cname + '≥' + (Number(list[i].cend) + Number(list[i].difference)) + unit + '或≤' + (Number(list[i].cbegin) - Number(list[i].difference)) + unit + '<br/>';
			doctorAdviceStr += list[i].knowledge;
		});
		$("#riskTip_content").html(riskStr);
		$("#riskTip_content").css("color", "red");
		$("#thisAdvice_content").html(doctorAdviceStr);
	},
	error: function() {

	}
});
$("#sendPeopleAndWay div span button").click(function() {
	if($(this).css("background-color") != "rgb(149, 188, 240)") {
		$(this).css({
			"background-color": "#95BCF0",
			"border": "1px solid #95BCF0",
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