/**********    孕妇首诊详情的基本信息  @yinzx     ***********/
var mid = sessionStorage.getItem("mid");
//mid='dg000001';
var address = sessionStorage.getItem("address");

//var address = "http://192.168.1.43:8080/doctormanager/";
$(function() {
	$.ajax({
		type: "post",
		url: address + "gravidaFirstCheck/findByMid.do",
		dataType: "json",
		async: true,
		data: {
			mid: mid
		},
		success: function(result) {
			var data = result.data;

			if(data != null) {
				getGravidaFirstCheck(data);
			}
		}
	});
})

function getGravidaFirstCheck(data) {
	var flist = data.flist;
	var weight = data.weight;
	var ghigh = (data.gHigh) / 100;
	var BMI = '';
	if(weight != undefined && data.gHigh != undefined) {
		BMI = (weight / (ghigh * ghigh)).toFixed(2);
	}
	if(data.checkDate != undefined) {
		$("#gfc_checkDate").html(getDateString(data.checkDate));
	}
	$("#gfc_age").html(flist[0].age);
	if(data.expectedConfinement != undefined) {
		$("#gfc_eDate").html(getDateString(data.expectedConfinement));
	}
	$("#gfc_weeks").html(data.weeks);
	if(data.birthYears != undefined) {
		$("#gfc_bornDate").html(getDateString(data.birthYears));
	}
	$("#gfc_high").html(data.gHigh);
	$("#gfc_heart").html(selectValue(data.heart));
	$("#gfc_uterus").html(selectValue(data.uterus));
	$("#gfc_hung").html(selectValue(data.hung));
	$("#gfc_vagina").html(selectValue(data.vagina));
	$("#gfc_BMI").html(BMI);
	$("#gfc_vulva").html(selectValue(data.vulva));
	$("#gfc_lung").html(selectValue(data.lung));
	$("#gfc_cervixUteri").html(selectValue(data.cervixUteri));
	var pressue = (data.spressure == null ? "" : data.spressure) + "/" + (data.dpressure == null ? "" : data.dpressure);
	$("#gfc_pressure").html(pressue);
	$("#gfc_history").html(data.previous);
	$("#gfc_weight").html(weight);
	$("#gfc_mhistory").html(selectValue2(flist[0].hpersonalhistory));
	$("#gfc_blood").html(selectValue3(flist[1].bloodtype));
	$("#gfc_fhistory").html(selectValue2(flist[1].hpersonalhistory));
	$("#gfc_mfhistory").html(selectValue2(flist[0].hpersonalhistory));
	$("#gfc_blood").html(selectValue3(flist[1].bloodtype));

	$("#gfc_phistory").html(data.pregnancyBirth == null ? "" : data.pregnancyBirth);
	$("#gfc_ffhistory").html(selectValue2(flist[1].hpersonalhistory));

	$("#gfc_complaint").html(data.complaint == null ? "暂无" : data.complaint);

}

//日期转换字符串
function getDateString(mydate) {
	if(mydate == null || mydate == '') {
		return '';
	}
	var d = new Date(mydate);
	//格式化日，如果小于9，前面补0  
	var day = ("0" + d.getDate()).slice(-2);
	//格式化月，如果小于9，前面补0  
	var month = ("0" + (d.getMonth() + 1)).slice(-2);
	//拼装完整日期格式  
	var date1 = d.getFullYear() + "-" + (month) + "-" + (day);
	return date1;
}

function selectValue(value) {
	var result = "";
	if(value != null) {
		switch(value) {
			case 0:
				result = "正常";
				break;
			case 1:
				result = "异常";
				break;
			case 2:
				result = "其他";
				break;
		}
	}
	return result;
}

function selectValue2(value) {
	var result = "";
	if(value != null) {
		switch(value) {
			case "0":
				result = "无";
				break;
			case "1":
				result = "有";
				break;

		}
	}
	return result;
}

function selectValue3(value) {
	var result = "";
	if(value != null) {
		switch(value) {
			case 0:
				result = "A型";
				break;
			case 1:
				result = "B型";
				break;
			case 2:
				result = "O型";
				break;
			case 3:
				result = "AB型";
				break;

		}
	}
	return result;
}