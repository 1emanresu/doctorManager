/*发送医嘱js @author yinzx*/
var mid = sessionStorage.getItem("mid");
var doctorId = sessionStorage.getItem("doctorId");
var address = sessionStorage.getItem("address");
//全选检测项目建议
function selectAllNotice() {
	if($('.Notice_selectAll').is(':checked')) {

		$(".select_fetelHeart").prop("checked", true);
		$(".select_fetelMovement").prop("checked", true);
		$(".select_pressure").prop("checked", true);
		$(".select_urine").prop("checked", true);
		$(".select_weight").prop("checked", true);
	} else {

		$(".select_fetelHeart").prop("checked", false);
		$(".select_fetelMovement").prop("checked", false);
		$(".select_pressure").prop("checked", false);
		$(".select_urine").prop("checked", false);
		$(".select_weight").prop("checked", false);
	}
}
//全选发送
function selectAllSend() {
	if($('.send_selectAll').is(':checked')) {
		$(".select_gravida").prop("checked", true);
		$(".select_husband").prop("checked", true);
		$(".select_orderlies").prop("checked", true);
		$(".select_other").prop("checked", true);
		$("#sms_alerts").prop("checked", true);
		$("#app_alerts").prop("checked", true);
		$("#weChat_alerts").prop("checked", true);
	} else {
		$(".select_gravida").prop("checked", false);
		$(".select_husband").prop("checked", false);
		$(".select_orderlies").prop("checked", false);
		$(".select_other").prop("checked", false);
		$("#sms_alerts").prop("checked", false);
		$("#app_alerts").prop("checked", false);
		$("#weChat_alerts").prop("checked", false);
	}
}
/*@author Luoyc发送医嘱*/
$("#cancel").click(function() {
	location.href = "javascript:history.go(-1)";
});

//var address = "http://192.168.1.49:8080/doctormanager/";
//var address = "http://120.76.194.76/doctormanager/";
//var doctorId = 2;
//var mid = 'dg000001';

//记录发送推送的mid    yinzx 2017/9/21
$("#send_mid").val(mid);

//获取历史医嘱
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
//发送医嘱提醒
function send_reminder() {
	if($("#thisAdvice_content").val() == '') {
		alert("请输入医嘱");
	} else {
		var selected_selfTest = '';
		if($(".select_pressure:checked").next().find("option:selected").text() != '') {
			selected_selfTest += $(".select_pressure:checked").next().find("option:selected").text();
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
					"doctorid": doctorId,
					"myknowledge": doctor_advice,
					"advicedate": currentdate,
					"sendingways": sending_way,
					"acceptedpeople": sendTo_people,
					"selftestdetails": selected_selfTest
				},
				url: address + "Reminder/insert.do",
				success: function(result) {
					alert("发送成功！")
				},
				error: function() {

				}
			});
		}
	}
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
		var doctorAdviceStr='';
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
		$("#riskTip_content").css("color","red");
		$("#thisAdvice_content").val(doctorAdviceStr);
	},
	error: function() {

	}
});
