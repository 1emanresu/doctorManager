/*@author Luoyc查看医嘱*/
var mid = sessionStorage.getItem("mid");
var doctorId = sessionStorage.getItem("doctorId");
var address = sessionStorage.getItem("address");
//var address = "http://192.168.1.49:8080/doctormanager/";
//var address = "http://120.76.194.76/doctormanager/";
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
		var daid = 0;
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
				if(i == list.length - 1) {
					$("#thisAdvice_content").val(advice);
					var daid = list[i].daid;
				}
			}
			$('#advice_history').append(table);
			$.ajax({
				type: "post",
				dataType: "json",
				data: {
					"daid": daid,
				},
				url: address + "Reminder/findReminderByDaid.do",
				success: function(result) {
					var reminder=result.data;
					var noticeStr=''
					var acceptedPeople=reminder.acceptedpeople.split("~");
					for(var i = 0;i<acceptedPeople.length;i++){
						$("#people"+i).text(acceptedPeople[i]);
					}
					var sendingWays=reminder.sendingways.split("~");
					for(var i = 0;i<sendingWays.length;i++){
						$("#way"+i).text(sendingWays[i]);
					}
					var selfTestDetails=reminder.selftestdetails.split("~");
					for(var i = 0;i<selfTestDetails.length;i++){
						if(i==0&&selfTestDetails[i].substr(selfTestDetails[i].length-4,selfTestDetails[i].length)=='测量7天'){
							noticeStr ="<span>血压检测  <span>"+selfTestDetails[i]+"</span></span><br/>"
						}else{
							noticeStr ="<span>"+selfTestDetails[i].substr(selfTestDetails[i].length-4,selfTestDetails[i].length)+"<span>"+selfTestDetails[i]+"</span></span><br/>"
						}
						$(".Notice_content").append(noticeStr)	
					}
				},
				error: function() {

				}
			});
		}
	},
	error: function() {

	}
});
$.ajax({
	type: "post",
	url: address + "abnormityinfo/findByWeeks.do",
	data: {
		"mid": mid,
		"sWeeks": 0,
		"eWeeks": 43
	},
	dataType: "json",
	ContentType: "application/x-www-form-urlencoded;charset=utf-8",
	success: function(e) {
		var list = e.data;
		var riskStr = '';
		$.each(list, function(i) {
			if(list[i].cunit == '' || list[i].cunit == null) {
				unit = ''
			} else {
				unit = list[i].cunit;
			}
			riskStr += (i + 1) + '.' + list[i].cname + '≥' + (Number(list[i].cend) + Number(list[i].difference)) + unit + '或≤' + (Number(list[i].cbegin) - Number(list[i].difference)) + unit + '<br/>';
		});
		$("#riskTip_content").html(riskStr);
		$("#riskTip_content").css("color","red");
	},
	error: function() {

	}
});