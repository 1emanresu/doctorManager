/*按孕周查看 特殊检查信息 js @author yinzx */
//var address = "http://192.168.1.49:8080/doctormanager/";
var address = sessionStorage.getItem("address");
var mid = sessionStorage.getItem("mid");
var weeks = 14;

//按孕周查询
$(function() {
	//查询血常规
	$.ajax({
		type: "post",
		url: address + "checkResult/queryCheckDetailByMId.do",
		data: {
			"weeks": weeks,
			"checkProjectId": 1,
			"mId": mid
		},
		async: false,
		dataType: "json",
		success: function(e) {
			getBloodMessage(e.data);
		},
		error: function() {

		}
	});
	//查询肝肾功能
	$.ajax({
		type: "post",
		url: address + "checkResult/queryCheckDetailByMId.do",
		data: {
			"weeks": weeks,
			"checkProjectId": 3,
			"mId": mid
		},
		async: false,
		dataType: "json",
		success: function(e) {
			getLiverMessage(e.data);
		},
		error: function() {

		}
	});
	//查询输血八项
	$.ajax({
		type: "post",
		url: address + "checkResult/queryCheckDetailByMId.do",
		data: {
			"weeks": weeks,
			"checkProjectId": 29,
			"mId": mid
		},
		async: false,
		dataType: "json",
		success: function(e) {
			getbloodTransfusion(e.data);
		},
		error: function() {

		}
	});
	//查询优生五项
	$.ajax({
		type: "post",
		url: address + "checkResult/queryCheckDetailByMId.do",
		data: {
			"weeks": weeks,
			"checkProjectId": 7,
			"mId": mid
		},
		async: false,
		dataType: "json",
		success: function(e) {
			getEugenicsFive(e.data);
		},
		error: function() {

		}
	});
	//查询血型
	$.ajax({
		type: "post",
		url: address + "checkResult/queryCheckDetailByMId.do",
		data: {
			"weeks": weeks,
			"checkProjectId": 30,
			"mId": mid
		},
		async: false,
		dataType: "json",
		success: function(e) {
			getBloodType(e.data);
		},
		error: function() {

		}
	});
	//查询b超
	$.ajax({
		type: "post",
		url: address + "bscan/findByMidAndWeeks.do",
		data: {
			"weeks": weeks,
			"checkProjectId": 14,
			"mId": mid
		},
		async: false,
		dataType: "json",
		success: function(e) {
			getBscan(e.data);
		},
		error: function(e) {
			console.log(JSON.stringify(e))
		}
	});
	//查询心电
	$.ajax({
		type: "post",
		url: address + "electrocardio/findByMidAndWeeks.do",
		data: {
			"weeks": weeks,
			"checkProjectId": 13,
			"mId": mid
		},
		async: false,
		dataType: "json",
		success: function(e) {
			getEcg(e.data);
		},
		error: function() {

		}
	}); //查询尿常规
	$.ajax({
		type: "post",
		url: address + "checkResult/queryCheckDetailByMId.do",
		data: {
			"weeks": weeks,
			"checkProjectId": 2,
			"mId": mid
		},
		async: false,
		dataType: "json",
		success: function(e) {
			getUrineMessage(e.data);
		},
		error: function() {

		}
	});

})

/**********   按孕周查看 获取相关信息的方法    ********/
//血常规
function getBloodMessage(data) {
	var length = data.length;
	for(var i = 0; i < length - 1; i++) {
		var value = data[i].checkValue;
		if(data[i].symbol != null) {
			value = value + data[i].symbol;
		}
		if(data[i].cname == "白细胞") {
			$(".WBC").html(value);
			$(".WBC1").html(value);
		} else if(data[i].cname == "红细胞") {
			$(".RBC").html(value);
			$(".RBC1").html(value);
		} else if(data[i].cname == "血红蛋白") {
			$(".HGB").html(value);
			$(".HGB1").html(value);
		} else if(data[i].cname == "红细胞压积") {
			$(".HCT").html(value);
			$(".HCT1").html(value);
		} else if(data[i].cname == "血小板计数") {
			$(".PLT").html(value);
			$(".PLT1").html(value);
		} else if(data[i].cname == "平均红细胞体积") {
			$(".MCV").html(value);
		} else if(data[i].cname == "平均红细胞血红蛋白量") {
			$(".MCH").html(value);
		} else if(data[i].cname == "平均红细胞血红蛋白浓度") {
			$(".MCHC").html(value);
		}
	}
	var template = data[length - 1].templatetitle;
	if(template != null) {
		$("#blood_name").html(template.name);
		$("#blood_age").html(template.age);
		$("#blood_bednum").html(template.bednum);
		$("#blood_medicalrecord").html(template.medicalrecord);
		$("#blood_department").html(template.department);
		$("#blood_sampletype").html(template.sampletype);
		if(template.pay == 0) {
			$("#blood_pay").html("自费");
		}
		$("#blood_senddoctor").html(template.senddoctor);
		$("#blood_clinicaldiagnosis").html(template.clinicaldiagnosis);
		$("#blood_sampleid").html(template.sampleid);
		$("#blood_barcode").html(template.barcode);

		var date1 = new Date(template.checkdate);
		var checkdate = date1.toLocaleDateString()
		$("#blood_checkdate").html(checkdate);
		var date2 = new Date(template.reportdate);
		var reportdate = date1.toLocaleDateString()
		$("#blood_reportdate").html(reportdate);
		$("#blood_examiner").html(template.examiner);
		$("#blood_auditor").html(template.auditor);
	}
}

//肝肾
function getLiverMessage(data) {
	var length = data.length;
	for(var i = 0; i < length - 1; i++) {
		var a = "<tr class='tr_firstDiagnose_width'><td>" + data[i].cname + "</td><td>" + data[i].checkValue +
			"</td><td>" + data[i].cunit + "</td><td>" + data[i].cbegin + "-" + data[i].cend + "</td></tr>";
		$("#Liver_Table1").append(a);
		$("#Liver_Table").append(a);
	}
	var a = "<tr class='tr_firstDiagnose_width'><td></td><td></td><td></td><td>" +
		"<div class='class_color_tow' style='cursor:pointer;'  data-toggle='modal' data-target='#myMo' onclick='clickShowMore(3)'>点击查看原始报告单</div></td></tr>";
	$("#Liver_Table").append(a);
	var a1 = "<tr class='tr_firstDiagnose_width'><td></td><td></td><td></td><td>" +
		"<a style='cursor:pointer;' data-toggle='modal' data-target='#myModal' onclick='clickShowMore(1)'>单击查看更多</a></td></tr>";
	$("#Liver_Table1").append(a1);
	var template = data[length - 1].templatetitle;
	if(template != null) {
		$("#liver_name").html(template.name);
		$("#liver_age").html(template.age);
		$("#liver_bednum").html(template.bednum);
		$("#liver_medicalrecord").html(template.medicalrecord);
		$("#liver_department").html(template.department);
		$("#liver_sampletype").html(template.sampletype);
		if(template.pay == 0) {
			$("#liver_pay").html("自费");
		}
		$("#liver_senddoctor").html(template.senddoctor);
		$("#liver_clinicaldiagnosis").html(template.clinicaldiagnosis);
		$("#liver_sampleid").html(template.sampleid);
		$("#liver_barcode").html(template.barcode);
		var date1 = new Date(template.checkdate);
		var checkdate = date1.toLocaleDateString()
		$("#liver_checkdate").html(checkdate);
		var date2 = new Date(template.reportdate);
		var reportdate = date1.toLocaleDateString()
		$("#liver_reportdate").html(reportdate);
		$("#liver_examiner").html(template.examiner);
		$("#liver_auditor").html(template.auditor);
	}
}
//输血八项
function getbloodTransfusion(data) {
	var length = data.length;
	for(var i = 0; i < length - 1; i++) {
		var value;
		if(data[i].checkValue == 0) {
			value = "阴性" + data[i].symbol;
		} else {
			value = "阳性" + data[i].symbol;
		}
		var a = "<tr class='tr_firstDiagnose_width'><td>" + data[i].cname + "</td>" +
			"<td>" + value + "</td><td></td></tr>";
		$("#bloodTransfusion8").append(a);
		$("#bloodTransfusion8_1").append(a);
	}
	var a = "<tr class='tr_firstDiagnose_width'><td></td><td></td><td>" +
		"<div class='class_color_tow' onclick='showMore(4)'>点击查看原始报告单</div></td></tr>";
	$("#bloodTransfusion8_1").append(a);
	var a1 = "<tr class='tr_firstDiagnose_width'><td></td><td></td><td>" +
		"<a style='cursor:pointer;' data-toggle='modal' data-target='#myModal' onclick='clickShowMore(4)'>单击查看更多</a></td></tr>";
	$("#bloodTransfusion8").append(a1);
	var template = data[length - 1].templatetitle;
	if(template != null) {
		$("#bt_name").html(template.name);
		$("#bt_age").html(template.age);
		$("#bt_bednum").html(template.bednum);
		$("#bt_medicalrecord").html(template.medicalrecord);
		$("#bt_department").html(template.department);
		$("#bt_sampletype").html(template.sampletype);
		if(template.pay == 0) {
			$("#bt_pay").html("自费");
		}
		$("#bt_senddoctor").html(template.senddoctor);
		$("#bt_clinicaldiagnosis").html(template.clinicaldiagnosis);
		$("#bt_sampleid").html(template.sampleid);
		$("#bt_barcode").html(template.barcode);
		var date1 = new Date(template.checkdate);
		var checkdate = date1.toLocaleDateString()
		$("#bt_checkdate").html(checkdate);
		var date2 = new Date(template.reportdate);
		var reportdate = date1.toLocaleDateString()
		$("#bt_reportdate").html(reportdate);
		$("#bt_examiner").html(template.examiner);
		$("#bt_auditor").html(template.auditor);
	}
}
//优生五项
function getEugenicsFive(data) {
	var length = data.length;
	for(var i = 0; i < length - 1; i++) {
		var value;
		if(data[i].symbol != null) {
			value = data[i].symbol + data[i].checkValue;

		} else {
			value = data[i].checkValue;
		}
		var a = "<tr class='tr_firstDiagnose_width'><td>" + data[i].cname + "</td><td>" + value + "</td>" +
			"<td>" + data[i].cunit + "</td><td>＜" + data[i].cend + "</td></tr>";
		$("#EugenicsFive_table").append(a);
		$("#EugenicsFive_table1").append(a);
	}
	var a = "<tr class='tr_firstDiagnose_width'><td></td><td></td><td></td><td>" +
		"<div class='class_color_tow' onclick='showMore(5)'>点击查看原始报告单</div></td></tr>";
	$("#EugenicsFive_table").append(a);
	var a1 = "<tr class='tr_firstDiagnose_width'><td></td><td></td><td></td><td>" +
		"<a style='cursor:pointer;' data-toggle='modal' data-target='#myModal' onclick='clickShowMore(5)'>单击查看更多</a></td></tr>";
	$("#EugenicsFive_table1").append(a1);
	var template = data[length - 1].templatetitle;
	if(template != null) {
		$("#EF_name").html(template.name);
		$("#EF_age").html(template.age);
		$("#EF_bednum").html(template.bednum);
		$("#EF_medicalrecord").html(template.medicalrecord);
		$("#EF_department").html(template.department);
		$("#EF_sampletype").html(template.sampletype);
		if(template.pay == 0) {
			$("#EF_pay").html("自费");
		}
		$("#EF_senddoctor").html(template.senddoctor);
		$("#EF_clinicaldiagnosis").html(template.clinicaldiagnosis);
		$("#EF_sampleid").html(template.sampleid);
		$("#EF_barcode").html(template.barcode);
		var date1 = new Date(template.checkdate);
		var checkdate = date1.toLocaleDateString()
		$("#EF_checkdate").html(checkdate);
		var date2 = new Date(template.reportdate);
		var reportdate = date1.toLocaleDateString()
		$("#EF_reportdate").html(reportdate);
		$("#EF_examiner").html(template.examiner);
		$("#EF_auditor").html(template.auditor);
	}
}
//血型
function getBloodType(data) {
	var length = data.length;
	for(var i = 0; i < length - 1; i++) {
		var value;
		var rvalue = ""; //参考值
		if(data[i].checkValue == null) {
			value = data[i].symbol;
		} else if(data[i].checkValue == 0) {
			value = "阴性" + data[i].symbol;

		} else if(data[i].checkValue == 1) {
			value = "阳性" + data[i].symbol;
		} else {
			value = data[i].symbol + data[i].checkValue;
			rvalue = data[i].symbol + data[i].cend;
		}
		var a = "<tr class='tr_firstDiagnose_width'><td>" + data[i].cname + "</td><td>" + value + "</td>" +
			"<td></td><td>" + rvalue + "</td></tr>";
		$("#bloodType_table").append(a);
		$("#bloodType_table1").append(a);
	}
	var a = "<tr class='tr_firstDiagnose_width'><td></td><td></td><td></td><td>" +
		"<div class='class_color_tow' style='cursor:pointer;'  data-toggle='modal' data-target='#myMo' onclick='clickShowMore(6)'>点击查看原始报告单</div></td></tr>";
	$("#bloodType_table1").append(a);
	var a1 = "<tr class='tr_firstDiagnose_width'><td></td><td></td><td></td><td>" +
		"<a style='cursor:pointer;' data-toggle='modal' data-target='#myModal' onclick='clickShowMore(2)'>单击查看更多</a></td></tr>";
	$("#bloodType_table").append(a1);
	var template = data[length - 1].templatetitle;
	if(template != null) {
		$("#bType_name").html(template.name);
		$("#bType_age").html(template.age);
		$("#bType_bednum").html(template.bednum);
		$("#bType_medicalrecord").html(template.medicalrecord);
		$("#bType_department").html(template.department);
		$("#bType_sampletype").html(template.sampletype);
		if(template.pay == 0) {
			$("#bType_pay").html("自费");
		}
		$("#bType_senddoctor").html(template.senddoctor);
		$("#bType_clinicaldiagnosis").html(template.clinicaldiagnosis);
		$("#bType_sampleid").html(template.sampleid);
		$("#bType_barcode").html(template.barcode);
		var date1 = new Date(template.checkdate);
		var checkdate = date1.toLocaleDateString()
		$("#bType_checkdate").html(checkdate);
		var date2 = new Date(template.reportdate);
		var reportdate = date1.toLocaleDateString()
		$("#bType_reportdate").html(reportdate);
		$("#bType_examiner").html(template.examiner);
		$("#bType_auditor").html(template.auditor);
	}
}
//B超
function getBscan(data) {
	var length = data.length;
	var bscan = data.bscan;
	if(bscan != null) {
		$("#bscan_way").html(bscan.way);
		$("#probefrequency").html(bscan.probefrequency);
		$("#bladder").html(bscan.bladder);
		$("#piclevel").html(bscan.piclevel);
		$("#checkpoint").html(bscan.checkpoint);
		$("#bdescription").html(bscan.bdescription);
		$("#btip").html(bscan.btip);
		$("#bscan_hosiptal").html(bscan.way);
		$("#bpd").html(bscan.bpd);
		$("#fetalheartrate").html(bscan.fetalheartrate);
		$("#amnioticfluid").html(bscan.amnioticfluid);
		var rightovary; //右侧卵巢
		if(bscan.rightovary == 0) {
			rightovary = "正常大小";
		} else {
			rightovary = "其他";
		}
		$("#rightovary").html(rightovary);
		$("#crl").html(bscan.crl);
		var placentalposition; //胎盘位置
		if(bscan.placentalposition == 0) {
			placentalposition = "前壁";
		} else if(bscan.placentalposition == 1) {
			placentalposition = "侧壁";
		} else if(bscan.placentalposition == 2) {
			placentalposition = "后壁";
		}
		$("#placentalposition").html(placentalposition);

		$("#femurl").html(bscan.femurl);
		var fetalmovement; //胎动
		if(bscan.fetalmovement == 0) {
			fetalmovement = "见";
		} else {
			fetalmovement = "未见";
		}
		$("#fetalmovement").html(fetalmovement);
		$("#placentalthickness").html(bscan.placentalthickness);
		$("#humerusl").html(bscan.humerusl);
		var fetalheart; //胎心
		if(bscan.fetalheart == 0) {
			fetalheart = "见";
		} else {
			fetalheart = "未见";
		}
		$("#fetalheart").html(fetalheart);

		var leftovary; //左侧卵巢
		if(bscan.leftovary == 0) {
			leftovary = "正常大小";
		} else {
			leftovary = "其他";
		}
		$("#leftovary").html(leftovary);
		$("#nt").html(bscan.nt);
		$("#nf").html(bscan.nf);
		var nasalbone; //鼻骨
		if(bscan.nasalbone == 0) {
			nasalbone = "显示";
		} else {
			nasalbone = "未显示";
		}
		$("#nasalbone").html(nasalbone);
		var fetusnumber; //胎数
		if(bscan.fetusnumber == 1) {
			fetusnumber = "单胎";
		} else {
			fetusnumber = "多胎";
		}
		$("#fetusnumber").html(fetusnumber);
		$("#weeks").html(weeks);
	}

	var template = data.templatetitle;
	if(template != null) {
		$("#bscan_name").html(template.name);
		$("#bscan_age").html(template.age);
		$("#bscan_bednum").html(template.bednum);
		$("#bscan_medicalrecord").html(template.medicalrecord);
		$("#bscan_department").html(template.department);
		$("#bscan_sampletype").html(template.sampletype);
		if(template.pay == 0) {
			$("#bscan_pay").html("自费");
		}
		$("#bscan_senddoctor").html(template.senddoctor);
		$("#bscan_clinicaldiagnosis").html(template.clinicaldiagnosis);
		$("#bscan_sampleid").html(template.sampleid);
		$("#bscan_barcode").html(template.barcode);
		var date1 = new Date(template.checkdate);
		var checkdate = date1.toLocaleDateString()
		$("#bscan_checkdate").html(checkdate);
		var date2 = new Date(template.reportdate);
		var reportdate = date1.toLocaleDateString()
		$("#bscan_reportdate").html(reportdate);
		$("#bscan_examiner").html(template.examiner);
		$("#bscan_auditor").html(template.auditor);
	}
}
//心电
function getEcg(data) {
	var ecg = data.ecg;
	if(ecg != null) {
		$("#ecg_hosiptal").html(ecg.hospitalname);
		$("#heartrate").html(ecg.heartrate);
		$("#ecg_pR").html(ecg.pR);
		$("#ecg_qrs").html(ecg.qrs);
		$("#ecg_qtc").html(ecg.qtc);
		$("#ecg_rv5Sv1").html(ecg.rv5Sv1);
		$("#ecg_rscount").html(ecg.rscount);
		$("#ecg_description").html(ecg.description);
		$("#ecg_tip").html(ecg.tip);
	}
	var template = data.templatetitle;
	if(template != null) {
		$("#ecg_name").html(template.name);
		$("#ecg_age").html(template.age);
		$("#ecg_bednum").html(template.bednum);
		$("#ecg_medicalrecord").html(template.medicalrecord);
		$("#ecg_department").html(template.department);
		$("#ecg_sampletype").html(template.sampletype);
		if(template.pay == 0) {
			$("#ecg_pay").html("自费");
		}
		$("#ecg_senddoctor").html(template.senddoctor);
		$("#ecg_clinicaldiagnosis").html(template.clinicaldiagnosis);
		$("#ecg_sampleid").html(template.sampleid);
		$("#ecg_barcode").html(template.barcode);
		var date1 = new Date(template.checkdate);
		var checkdate = date1.toLocaleDateString()
		$("#ecg_checkdate").html(checkdate);
		var date2 = new Date(template.reportdate);
		var reportdate = date1.toLocaleDateString()
		$("#ecg_reportdate").html(reportdate);
		$("#ecg_examiner").html(template.examiner);
		$("#ecg_auditor").html(template.auditor);
	}
}
//尿常规
function getUrineMessage(data) {
	var length = data.length;
	for(var i = 0; i < 11; i = i + 2) {
		var value;
		var rvalue = ""; //参考值
		if(data.hasOwnProperty("checkValue")) {
			console.log(data[i].checkValue);
			if(data[i].checkValue == null) {
				value = data[i].symbol;
			} else if(data[i].checkValue == 0) {
				value = data[i].symbol;
				rvalue = "阴性";
				if(data[i].cunit != null) {
					rvalue = rvalue + data[i].cunit;
				}
			} else if(data[i].checkValue == 1) {
				value = data[i].checkValue + data[i].symbol;
				rvalue = "阳性";
			} else {
				value = data[i].checkValue;
				rvalue = data[i].cbegin + "-" + data[i].cend
				if(data[i].cunit != null) {
					rvalue = rvalue + data[i].cunit;
				}
			}
			var value1;
			var rvalue1 = ""; //参考值
			if(data[i + 1].checkValue == null) {
				value1 = data[i + 1].symbol;
			} else if(data[i + 1].checkValue == 0) {
				value1 = data[i + 1].symbol;
				rvalue1 = "阴性";
				if(data[i + 1].cunit != null) {
					rvalue1 = rvalue1 + data[i + 1].cunit;
				}
			} else if(data[i + 1].checkValue == 1) {
				value1 = data[i + 1].checkValue + data[i + 1].symbol;
				rvalue1 = "阳性";
			} else {
				value1 = data[i + 1].checkValue;
				rvalue1 = data[i + 1].cbegin + "-" + data[i + 1].cend
				if(data[i + 1].cunit != null) {
					rvalue1 = rvalue1 + data[i + 1].cunit;
				}
			}
			var a = "<tr class='tr_firstDiagnose_width'><td>" + data[i].cname + "</td><td>" + value + "</td><td>" + rvalue + "</td>" +
				"<td>" + data[i + 1].cname + "</td><td>" + value1 + "</td><td>" + rvalue1 + "</td></tr>";
			$("#urine_table").append(a);
			$("#urine_table1").append(a);
		}
	}

	for(var i = 12; i < length - 1; i = i + 2) {
		var value;
		var rvalue = ""; //参考值
		if(data[i].checkValue == null) {
			value = data[i].symbol;
		} else if(data[i].checkValue == 0) {
			value = data[i].symbol;
			rvalue = "阴性";
			if(data[i].cunit != null) {
				rvalue = rvalue + data[i].cunit;
			}
		} else if(data[i].checkValue == 1) {
			value = data[i].checkValue + data[i].symbol;
			rvalue = "阳性";
		} else {
			value = data[i].checkValue;
			rvalue = data[i].cbegin + "-" + data[i].cend
			if(data[i].cunit != null) {
				rvalue = rvalue + data[i].cunit;
			}
		}
		var value1;
		var rvalue1 = ""; //参考值
		if(data[i + 1].checkValue == null) {
			value1 = data[i + 1].symbol;
		} else if(data[i + 1].checkValue == 0) {
			value1 = data[i + 1].symbol;
			rvalue1 = "阴性";
			if(data[i + 1].cunit != null) {
				rvalue1 = rvalue1 + data[i + 1].cunit;
			}
		} else if(data[i + 1].checkValue == 1) {
			value1 = data[i + 1].checkValue + data[i + 1].symbol;
			rvalue1 = "阳性";
		} else {
			value1 = data[i + 1].checkValue;
			rvalue1 = data[i + 1].cbegin + "-" + data[i + 1].cend
			if(data[i + 1].cunit != null) {
				rvalue1 = rvalue1 + data[i + 1].cunit;
			}
		}
		var a = "<tr class='tr_firstDiagnose_width'><td>" + data[i].cname + "</td><td>" + value + "</td><td>" + rvalue + "</td>" +
			"<td>" + data[i + 1].cname + "</td><td>" + value1 + "</td><td>" + rvalue1 + "</td></tr>";

		$("#urine_table1").append(a);
	}
	var a = "<tr class='tr_firstDiagnose_width'><td></td><td></td><td></td><td></td><td></td><td>" +
		"<div class='class_color_tow' style='cursor:pointer;'  data-toggle='modal' data-target='#myMo' onclick='clickShowMore(2)'>点击查看原始报告单</div></td></tr>";
	$("#urine_table1").append(a);
	var a1 = "<tr class='tr_firstDiagnose_width'><td></td><td></td><td></td><td></td><td></td><td>" +
		"<a style='cursor:pointer;' data-toggle='modal' data-target='#myModal' onclick='clickShowMore(3)'>单击查看更多</a></td></tr>";
	$("#urine_table").append(a1);

	var template = data[length - 1].templatetitle;
	if(template != null) {
		$("#urine_name").html(template.name);
		$("#urine_age").html(template.age);
		$("#urine_bednum").html(template.bednum);
		$("#urine_medicalrecord").html(template.medicalrecord);
		$("#urine_department").html(template.department);
		$("#urine_sampletype").html(template.sampletype);
		if(template.pay == 0) {
			$("#urine_pay").html("自费");
		}
		$("#urine_senddoctor").html(template.senddoctor);
		$("#urine_clinicaldiagnosis").html(template.clinicaldiagnosis);
		$("#urine_sampleid").html(template.sampleid);
		$("#urine_barcode").html(template.barcode);
		var date1 = new Date(template.checkdate);
		var checkdate = date1.toLocaleDateString()
		$("#urine_checkdate").html(checkdate);
		var date2 = new Date(template.reportdate);
		var reportdate = date1.toLocaleDateString()
		$("#urine_reportdate").html(reportdate);
		$("#urine_examiner").html(template.examiner);
		$("#urine_auditor").html(template.auditor);
	}
}