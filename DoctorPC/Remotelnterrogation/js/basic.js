/**
 * @wangzw basciInfo
 */
//var address = "http://192.168.1.49:8080/doctormanager/";
var address = sessionStorage.getItem("address");
var mid = sessionStorage.getItem("mid");
$(function() {
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
				createExpectBasic(information[0]);
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
//基本信息
function createExpectBasic(data) {
    if(data == undefined) {
    	$("#statures").text("暂无数据");
	    $("#weights").text("暂无数据");
	    $("#bmis").text("暂无数据");
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
   replaceUndefined(data.gHigh);
    $("#expectedDate").text(replaceUndefined(data.expectedConfinement));
    $("#gestationalWeeks").text(gWeeks);
    $("#ages").text(replaceUndefined(data.age));
    $("#statures").text(replaceUndefined(data.gHigh));
    $("#weights").text(replaceUndefined(data.pregnancy));
    if(bmis=="NaN"){
    	bmis="暂无数据";
    };
    $("#bmis").text(bmis);
    $("#weeksTime").text(gWeeks);
    $("#td_doctorAdviceManager_sHisk").text(replaceUndefined(data.gHigh));
    $("#td_doctorAdviceManager_weight").text(replaceUndefined(data.pregnancy));
    $("#td_doctorAdviceManager_BMI").text(bmis);
    $("#td_doctorAdviceManager_Age").text(replaceUndefined(data.age));
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
            	$("#booldPressure").text("暂无数据");
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
            	$("#heart").text("暂无数据");
                $("#lung").text("暂无数据");
                $("#vulva").text("暂无数据");
                $("#cervixUteri").text("暂无数据");
                $("#uterus").text("暂无数据");
                $("#vagina").text("暂无数据");
                $("#td_doctorAdviceManager_heart").text("暂无数据");
                $("#td_doctorAdviceManager_lung").text("暂无数据");
                $("#td_doctorAdviceManager_vulva").text("暂无数据");
                $("#td_doctorAdviceManager_cervixUteri").text("暂无数据");
                $("#td_doctorAdviceManager_uteri").text("暂无数据");
                $("#td_doctorAdviceManager_vagina").text("暂无数据");
                $("#td_doctorAdviceManager_abdominal").text("暂无数据");
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
            $("#gHistory").text(replaceUndefined(result.data.history));
            $("#td_doctorAdviceManager_ji").text(replaceUndefined(result.data.history));
        },
    });
}
//父亲血型
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
            	$("#manBlood").text("暂无数据");
            	$("#td_doctorAdviceManager_blood").text("暂无数据");
                return;
            }
            var data = result.data;
            if(data.bloodType == 0) {
                bloodType = "A型";
            } else if(data.bloodType == 1) {
                bloodType = "B型";
            } else if(data.bloodType == 2) {
                bloodType = "O型";
            } else if(data.bloodType == 3) {
                bloodType = "AB型";
            } else{
            	bloodType = "暂无数据";
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
            	$("#womanHistory").text("暂无数据");
	            $("#womanPersonage").text("暂无数据");
	            $("#td_doctorAdviceManager_womanF").text("暂无数据");
	            $("#td_doctorAdviceManager_womanper").text("暂无数据");
	            $("#pregnancyBirth").text("暂无数据");
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
            }else{
            	hPersonalHistory = "暂无数据";
            }
            $("#womanHistory").text(hPersonalHistory);
            $("#womanPersonage").text(hPersonalHistory);
            $("#td_doctorAdviceManager_womanF").text(hPersonalHistory);
            $("#td_doctorAdviceManager_womanper").text(hPersonalHistory);
            $("#pregnancyBirth").text(data.pregnancyBirth.replace("#"," "));
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
            	$("#manHistory").text("暂无数据");
	            $("#manPersonage").text("暂无数据");
	            $("#td_doctorAdviceManager_manF").text("暂无数据");
	            $("#td_doctorAdviceManager_manper").text("暂无数据");

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
            }else{
            	hPersonalHistory="暂无数据"
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
					var content = "<span>、" + data[i].symptomName + "</span>";
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
	checkText = $("#pid").find("option:selected").text();
	queryAntenatalcaretime(checkText);
}

function queryAntenatalcaretime(checkText) {
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
		} else {
			$("#checkDates").text("");
		}
	}
	if(checkText == 2) {
		if(data.secondantenatalcaretime != null) {
			$("#checkDates").text(dstartateTime2);
		} else {
			$("#checkDates").text("");
		}
	}
	if(checkText == 3) {
		if(data.thirdantenatalcaretime != null) {
			$("#checkDates").text(dstartateTime3);
		} else {
			$("#checkDates").text("");
		}
	}
	if(checkText == 4) {
		if(data.forthantenatalcaretime != null) {
			$("#checkDates").text(dstartateTime4);
		} else {
			$("#checkDates").text("");
		}
	}
	if(checkText == 5) {
		if(data.fifthantenatalcaretime != null) {
			$("#checkDates").text(dstartateTime5);
		} else {
			$("#checkDates").text("");
		}
	}
	if(checkText == 6) {
		if(data.sixthantenatalcaretime != null) {
			$("#checkDates").text(dstartateTime6);
		} else {
			$("#checkDates").text("");
		}
	}
	if(checkText == 7) {
		if(data.seventhantenatalcaretime != null) {
			$("#checkDates").text(dstartateTime7);
		} else {
			$("#checkDates").text("");
		}
	}
}
function replaceUndefined(str){
	if(str==undefined||str==null){
		return "暂无数据"
	}
	return str;
}