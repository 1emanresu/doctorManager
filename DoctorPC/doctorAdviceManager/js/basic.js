/**
 * @wangzw basciInfo
 */
//var address = "http://192.168.1.60:8080/doctormanager/";
var address = sessionStorage.getItem("address");
var mid = sessionStorage.getItem("mid");
//var mid = 'dg000001';
$(function() {
	/*
	 * @wangzw
	 * 孕妇信息
	 */
	//2017-09-20 luoyc注释
	/*$.ajax({
		type: "post",
		url: address + "weekly/queryAbstractAll.do",
		dataType: "json",
		async: true,
		data: {
			mids: mid
		},
		success: function(result) {
			var information = result.data;
			if(information != null) {
				$("#gName").text(information[0].gname);
				$("#gAge").text(information[0].age);
				$("#gexpectedConfinement").text(information[0].expectedConfinement);
				$("#gHiskGrade").text(information[0].highRiskResultType);
				$("#gElement").text(information[0].shu + information[0].check);
			}

		},
	});*/
	$('#checkDates').text("");
	$("#weeksTime").text("");
	$('.spanresult').text("");
	$('.whatthe').text("");
	/*
	 * @wangzw
	 * 基本检查
	 */
	$.ajax({
		type: "post",
		url: address + "weekly/selectGravidaInfo.do",
		dataType: "json",
		async: true,
		data: {
			mids: mid
		},
		success: function(result) {
			var information = result.data;
			if(information != null) {
				createExpectBasic(information);
			}

		},
	});
	/**
	 * 孕妇既往史
	 */
	medicalHistory(mid);
	/**
	 * 血压
	 */
	bloodPressures();
	/**
	 * 孕妇病史
	 */
	graderInfoMedicalHistory(mid);
	/**
	 * 男方血型
	 */
	blood(mid);
	/**
	 * 女方家族史
	 */
	wonmanQueryPersonage(mid);
	/**
	 * 男方家族史
	 */
	manQueryPersonage(mid);
	/**
	 * 孕产史
	 */
	symptoms(mid);

	/**
	 * 产检
	 */
	gradeChange();
});

function createExpectBasic(data) {
	if(data == undefined) {
		return;
	}
	var str_start = data.expectedConfinement;
	var count = 295;
	var start = new Date(str_start);
	var date = new Date();
	var init = parseInt(Math.abs(date - start) / 1000 / 60 / 60 / 24);
	var end = start.setDate(start.getDate() + 295);
	var str_end = start.getFullYear() + "/" + (start.getMonth() + 1) + "/" + start.getDate();
	var gWeeks = null;
	if(init) {
		if(parseInt(init % 7) == 0) {
			gWeeks = "孕" + parseInt(init / 7) + "周";
			var graweek = "孕" + parseInt(init / 7) + "周";
			sessionStorage.setItem("graWeeks", graweek);
		} else {
			gWeeks = "孕" + parseInt(init / 7) + "周" + "+" + init % 7 + "天";
			var graweek = "孕" + parseInt(init / 7) + "周" + "+" + init % 7 + "天";
			sessionStorage.setItem("graWeeks", graweek);
		}
	}
	var bmis = (data.pregnancy / data.gHigh / data.gHigh * 10000).toFixed(1);
	if(data.expectedConfinement == null){
		$("#expectedDate").text('无');
	}else{
		$("#expectedDate").text(data.expectedConfinement);
	}
	if(data.birthYears == null){
		$("#birthDate").text('无');
	}else{
		$("#birthDate").text(data.birthYears);
	}
	$("#gestationalWeeks").text(gWeeks);
	if(data.age == null){
		$("#ages").text('无');
	}else{
		$("#ages").text(data.age);
	}
	if(data.gHigh == null){
		$("#statures").text('无');
	}else{
		$("#statures").text(data.gHigh);
	}
	if(data.pregnancy == null){
		$("#weights").text('无');
	}else{
		$("#weights").text(data.pregnancy);
	}
	if(bmis == null || bmis == undefined){
		$("#bmis").text('无');
	}else{
		$("#bmis").text(bmis);
	}
	
	//alert(gWeeks);
	$("#weeksTime").text(gWeeks);
	if(data.gHigh == null){
		$("#td_doctorAdviceManager_sHisk").text('无');
	}else{
		$("#td_doctorAdviceManager_sHisk").text(data.gHigh);
	}
	if(data.pregnancy == null){
		$("#td_doctorAdviceManager_weight").text('无');
	}else{
		$("#td_doctorAdviceManager_weight").text(data.pregnancy);
	}
	if(bmis == null){
		$("#td_doctorAdviceManager_BMI").text('无');
	}else{
		$("#td_doctorAdviceManager_BMI").text(bmis);
	}
	if(data.age == null){
		$("#td_doctorAdviceManager_Age").text('无');
	}else{
		$("#td_doctorAdviceManager_Age").text(data.age);
	}
	
}
//血压
function bloodPressures() {
	$.ajax({
		type: "post",
		url: address + "bloodpressure/find.do",
		dataType: "json",
		async: true,
		data: {
			mid: mid
		},
		success: function(result) {
			if(result.data.length == 0) {
				return;
			}
			var list = result.data;
			var bloodPressureStr = list[list.length - 1].diastolic + "/" + list[list.length - 1].systolic;
			$("#booldPressure").text(bloodPressureStr);
		},
	});
}

function medicalHistory(mid) {
	$.ajax({
		type: "post",
		url: address + "pregnancyHistory/selectHistoryGradeInfo.do",
		dataType: "json",
		async: true,
		data: {
			mid: mid
		},
		success: function(result) {
			if(result.data.length == 0) {
				return;
			}
			var information = result.data;
			var heart = null;
			var lung = null;
			var vulva = null;
			var cervixUteri = null;
			var uterus = null;
			var vagina = null;
			var abdominal = null;
			if(information != null) {
				if(information[0].heart == 0) {
					heart = "正常";
				} else if(information[0].heart == 1) {
					heart = "异常";
				} else {
					heart = "其他";
				}
				if(information[0].lung == 0) {
					lung = "正常";
				} else if(information[0].lung == 1) {
					lung = "异常";
				} else {
					lung = "其他";
				}
				if(information[0].vulva == 0) {
					vulva = "正常";
				} else if(information[0].vulva == 1) {
					vulva = "异常";
				} else {
					vulva = "其他";
				}
				if(information[0].cervixUteri == 0) {
					cervixUteri = "正常";
				} else if(information[0].cervixUteri == 1) {
					cervixUteri = "异常";
				} else {
					cervixUteri = "其他";
				}
				if(information[0].uterus == 0) {
					uterus = "正常";
				} else if(information[0].uterus == 1) {
					uterus = "异常";
				} else {
					uterus = "其他";
				}
				if(information[0].vagina == 0) {
					vagina = "正常";
				} else if(information[0].vagina == 1) {
					vagina = "异常";
				} else {
					vagina = "其他";
				}
				if(information[0].abdominal == 0) {
					abdominal = "正常";
				} else if(information[0].abdominal == 1) {
					abdominal = "异常";
				} else {
					abdominal = "其他";
				}
				$("#heart").text(heart);
				$("#lung").text(lung);
				$("#vulva").text(vulva);
				$("#cervixUteri").text(cervixUteri);
				$("#uterus").text(uterus);
				$("#vagina").text(vagina);

				$("#td_doctorAdviceManager_heart").text(heart);
				$("#td_doctorAdviceManager_lung").text(lung);
				$("#td_doctorAdviceManager_vulva").text(vulva);
				$("#td_doctorAdviceManager_cervixUteri").text(cervixUteri);
				$("#td_doctorAdviceManager_uteri").text(uterus);
				$("#td_doctorAdviceManager_vagina").text(vagina);
				$("#td_doctorAdviceManager_abdominal").text(abdominal);

			}
		},
	});
}

function graderInfoMedicalHistory(mid) {
	$.ajax({
		type: "post",
		url: address + "pregnancyHistory/selectHistory.do",
		async: true,
		dataType: "json",
		data: {
			mid: mid
		},
		success: function(result) {
			$("#gHistory").text(result.data.history);
			$("#td_doctorAdviceManager_ji").text(result.data.history);
		},
	});
}

function blood(mid) {
	var bloodType = null;
	$.ajax({
		type: "post",
		url: address + "pregnancyHistory/queryManBlood.do",
		async: true,
		dataType: "json",
		data: {
			mid: mid
		},
		success: function(result) {
			if(result.data == null) {
				return;
			}
			var data = result.data;
			if(data.bloodType == 0) {
				bloodType = "A型";
			} else if(data.bloodType == 1) {
				bloodType = "B型";
			} else if(data.bloodType == 2) {
				bloodType = "O型";
			} else {
				bloodType = "AB型";
			}
			$("#manBlood").text(bloodType);
			$("#td_doctorAdviceManager_blood").text(bloodType);
		},
	});
}

function wonmanQueryPersonage(mid) {
	var hPersonalHistory = null;
	$.ajax({
		type: "post",
		url: address + "pregnancyHistory/queryPersonage.do",
		async: true,
		dataType: "json",
		data: {
			relationId: 1,
			mid: mid
		},
		success: function(result) {
			if(result.data == null || result.data.length == 0) {
				return;
			}
			var data = result.data;
			//console.log(data);
			if(data.hPersonalHistory == 0) {
				hPersonalHistory = "无";
			} else if(data.hPersonalHistory == 1) {
				hPersonalHistory = "其他";
			} else if(data.hPersonalHistory == 2) {
				hPersonalHistory = "接触放射线";
			} else if(data.hPersonalHistory == 3) {
				hPersonalHistory = "接触有毒有害物质";
			} else if(data.hPersonalHistory == 4) {
				hPersonalHistory = "服用药物";
			} else if(data.hPersonalHistory == 5) {
				hPersonalHistory = "饮酒";
			} else if(data.hPersonalHistory == 6) {
				hPersonalHistory = "吸烟";
			}
			$("#womanHistory").text(hPersonalHistory);
			$("#womanPersonage").text(hPersonalHistory);
			$("#td_doctorAdviceManager_womanF").text(hPersonalHistory);
			$("#td_doctorAdviceManager_womanper").text(hPersonalHistory);
			$("#pregnancyBirth").text(data.pregnancyBirth);
		},
	});
}

function manQueryPersonage(mid) {
	var hPersonalHistory = null;
	$.ajax({
		type: "post",
		url: address + "pregnancyHistory/queryPersonage.do",
		async: true,
		dataType: "json",
		data: {
			relationId: 2,
			mid: mid
		},
		success: function(result) {
			if(result.data == null || result.data.length == 0) {
				return;
			}
			var data = result.data;
			if(data.hPersonalHistory == 0) {
				hPersonalHistory = "无";
			} else if(data.hPersonalHistory == 1) {
				hPersonalHistory = "其他";
			} else if(data.hPersonalHistory == 2) {
				hPersonalHistory = "接触放射线";
			} else if(data.hPersonalHistory == 3) {
				hPersonalHistory = "接触有毒有害物质";
			} else if(data.hPersonalHistory == 4) {
				hPersonalHistory = "服用药物";
			} else if(data.hPersonalHistory == 5) {
				hPersonalHistory = "饮酒";
			} else if(data.hPersonalHistory == 6) {
				hPersonalHistory = "吸烟";
			}
			$("#manHistory").text(hPersonalHistory);
			$("#manPersonage").text(hPersonalHistory);
			$("#td_doctorAdviceManager_manF").text(hPersonalHistory);
			$("#td_doctorAdviceManager_manper").text(hPersonalHistory);
		},
	});
}

function symptom() {
	var eWeeks = sessionStorage.getItem("eWeeks");
	var sWeeks = sessionStorage.getItem("sWeeks");
	var symptom = null;
	$.ajax({
		type: "post",
		url: address + "pregnancyHistory/querySymptom.do",
		async: true,
		dataType: "json",
		data: {
			mid: mid,
			"sWeeks": sWeeks,
			"eWeeks": eWeeks
		},
		success: function(result) {
			var data = result.data;
			$("#symptomName").empty();
			for(var i = 0; i < data.length; i++) {
				if(i == 0) {
					var content = "<span>" + data[i].symptomName + "</span>";
				} else {
					var content = "<span>" + data[i].symptomName + "</span>";
				}

				$("#symptomName").append(content);

			}
			if(data.length == 0) {
				$("#symptomName").append("无");
				$("#symptomName").css("color", "#666");
			}

		},
	});
}

function symptoms(mid) {
	$.ajax({
		type: "post",
		url: address + "symptom/querySymptom.do",
		async: true,
		dataType: "json",
		data: {
			mid: mid
		},
		success: function(result) {
			var data = result.data;
			for(var i = 0; i < data.length; i++) {
				if(data[i].symptomName.trim() == "皮肤瘙痒") {
					$("#td_doctorAdviceManager_symptoms0").text("有");
					$("#symptomInfo").val("皮肤瘙痒");
				} else {
					$("#td_doctorAdviceManager_symptoms0").text("无");
				}
				if(data[i].symptomName.trim() == "腹痛") {
					$("#td_doctorAdviceManager_symptoms1").text("有");
					$("#symptomInfo").val("腹痛");
				} else {
					$("#td_doctorAdviceManager_symptoms1").text("无");
				}
				if(data[i].symptomName.trim() == "外阴出血") {
					$("#symptomInfo").val("外阴出血");
					$("#td_doctorAdviceManager_symptoms2").text("有");
				} else {
					$("#td_doctorAdviceManager_symptoms2").text("无");
				}
				if(data[i].symptomName.trim() == "头昏") {
					$("#td_doctorAdviceManager_symptoms3").text("有");
					$("#symptomInfo").val("头昏");
				} else {
					$("#td_doctorAdviceManager_symptoms3").text("无");
				}
				if(data[i].symptomName.trim() == "发热") {
					$("#td_doctorAdviceManager_symptoms4").text("有");
					$("#symptomInfo").val("发热");
				} else {
					$("#td_doctorAdviceManager_symptoms4").text("无");
				}
				if(data[i].symptomName.trim() == "阴道溢液") {
					$("#td_doctorAdviceManager_symptoms5").text("有");
					$("#symptomInfo").val("阴道溢液");
				} else {
					$("#td_doctorAdviceManager_symptoms5").text("无");
				}
				if(data[i].symptomName.trim() == "呼吸困难") {
					$("#td_doctorAdviceManager_symptoms6").text("有");
					$("#symptomInfo").val("呼吸困难");
				} else {
					$("#td_doctorAdviceManager_symptoms6").text("无");
				}
				if(data[i].symptomName.trim() == "眼花") {
					$("#td_doctorAdviceManager_symptoms7").text("有");
					$("#symptomInfo").val("眼花");
				} else {
					$("#td_doctorAdviceManager_symptoms7").text("无");
				}
				if(data[i].symptomName.trim() == "其他") {
					$("#td_doctorAdviceManager_symptoms8").text("有");
					$("#symptomInfo").val("其他");
				} else {
					$("#td_doctorAdviceManager_symptoms8").text("无");
				}
			}
		},
	});
}

function gradeChange() {
	var checkText = 1;
	checkText = $("#pid").val();
	var weeks = checkText;
	var sweeks = 1;
	var eweeks = 41;
	if(weeks != 0 && weeks != undefined) {
		//开始孕周
		var w = weeks.split('-');
		sweeks = w[0];
		eweeks = w[1];
	}
	if(sweeks == 6 && eweeks == 13 || sweeks == 1 && eweeks == 41){
		$('.first-result').text("首诊结论");
	}else{
		$('.first-result').text("复诊结论");
	}
	if(sweeks == 1){
		return;
	}
	var week = '';
	if(sweeks == 6 && eweeks == 13){
		week = 10;
	}else if(sweeks == 14 && eweeks == 20){
		week = 18;
	}else if(sweeks == 20 && eweeks == 24){
		week = 22;
	}else if(sweeks == 24 && eweeks == 28){
		week = 26;
	}else if(sweeks == 28 && eweeks == 32){
		week = 30;
	}else if(sweeks == 33 && eweeks == 36){
		week = 35;
	}else if(sweeks == 37 && eweeks == 41){
		week = 39;
	}else{
		week == null;
	}
	showTest(week);
	queryAntenatalcaretime(checkText);
}

function queryAntenatalcaretime(checkText) {
	$('#checkDates').text("");
	$("#weeksTime").text("");
	$('.spanresult').text("");
	$('.whatthe').val("");
	$.ajax({
		type: "post",
		url: address + "antenatalcaretime/queryAntenatalcaretime.do",
		async: true,
		dataType: "json",
		data: {
			mid: mid
		},
		success: function(result) {
			var data = result.data;
			antenatalcaretimeData(checkText, data[0]);
		},
	});
}

function antenatalcaretimeData(checkText, data) {
	if(data==undefined){return;}
	var start = new Date(data.firstantenatalcaretime);
	var dstartateTime = start.getFullYear() + "/" + (start.getMonth() + 1) + "/" + start.getDate();
	var start2 = new Date(data.secondantenatalcaretime);
	var dstartateTime2 = start2.getFullYear() + "/" + (start2.getMonth() + 1) + "/" + start2.getDate();
	var start3 = new Date(data.thirdantenatalcaretime);
	var dstartateTime3 = start3.getFullYear() + "/" + (start3.getMonth() + 1) + "/" + start3.getDate();
	var start4 = new Date(data.forthantenatalcaretime);
	var dstartateTime4 = start4.getFullYear() + "/" + (start4.getMonth() + 1) + "/" + start4.getDate();
	var start5 = new Date(data.fifthantenatalcaretime);
	var dstartateTime5 = start5.getFullYear() + "/" + (start5.getMonth() + 1) + "/" + start5.getDate();
	var start6 = new Date(data.sixthantenatalcaretime);
	var dstartateTime6 = start6.getFullYear() + "/" + (start6.getMonth() + 1) + "/" + start6.getDate();
	var start7 = new Date(data.seventhantenatalcaretime);
	var dstartateTime7 = start7.getFullYear() + "/" + (start7.getMonth() + 1) + "/" + start7.getDate();
	if(checkText == 1) {
		if(data.firstantenatalcaretime != null) {
			$("#checkDates").text(dstartateTime);
			$('#weeksTime').text(13);
		} else {
			$("#checkDates").text("");
			$('#weeksTime').text("");
		}
	}
	if(checkText == 2) {
		if(data.secondantenatalcaretime != null) {
			$("#checkDates").text(dstartateTime2);
			$('#weeksTime').text(19);
		} else {
			$("#checkDates").text("");
			$('#weeksTime').text("");
		}
	}
	if(checkText == 3) {
		if(data.thirdantenatalcaretime != null) {
			$("#checkDates").text(dstartateTime3);
			$('#weeksTime').text(24);
		} else {
			$("#checkDates").text("");
			$('#weeksTime').text("");
		}
	}
	if(checkText == 4) {
		if(data.forthantenatalcaretime != null) {
			$("#checkDates").text(dstartateTime4);
			$('#weeksTime').text(28);
		} else {
			$("#checkDates").text("");
			$('#weeksTime').text("");
		}
	}
	if(checkText == 5) {
		if(data.fifthantenatalcaretime != null) {
			$("#checkDates").text(dstartateTime5);
			$('#weeksTime').text(32);
		} else {
			$("#checkDates").text("");
			$('#weeksTime').text("");
		}
	}
	if(checkText == 6) {
		if(data.sixthantenatalcaretime != null) {
			$("#checkDates").text(dstartateTime6);
			$('#weeksTime').text(37);
		} else {
			$("#checkDates").text("");
			$('#weeksTime').text("");
		}
	}
	if(checkText == 7) {
		if(data.seventhantenatalcaretime != null) {
			$("#checkDates").text(dstartateTime7);
			$('#weeksTime').text(41);
		} else {
			$("#checkDates").text("");
			$('#weeksTime').text("");
		}
	}
	if(checkText == 0) {
		if(data.seventhantenatalcaretime != null) {
			$("#checkDates").text("");
			$('#weeksTime').text("");
		} else {
			$("#checkDates").text("");
			$('#weeksTime').text("");
		}
	}
}

$('.active').click(function(){
	
	$('.spanresult').text("");
	$('.whatthe').val("");
})