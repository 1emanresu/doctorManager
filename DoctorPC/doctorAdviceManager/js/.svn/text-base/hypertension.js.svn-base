/*按孕周查看 特殊检查信息 js @author yinzx */

//var address = "http://192.168.1.60:8080/doctormanager/";
var address = sessionStorage.getItem("address");
//var address = "http://192.168.1.49:8080/doctormanager/";
//var mid = "dg000001";
var mid = sessionStorage.getItem("mid");
//var weeks = 14;
var weeks = sessionStorage.getItem("weeks");
/*存储发送推送 对象的mid   yinzx 2017/9/21 **/
$("#send_mid").val(mid);

//按孕周查询
$(function() {
	showTest(weeks);//加载即调用高危信息等
	$('#pid').append(prfweeksQuery());//基本信息
	$('#tscount').append(prfweeksQuery());//唐筛
	$('#niptcount').append(prfweeksQuery());//NIPT
	$('#ecgcount').append(prfweeksQuery());//心电图
	/*$('#hfcount').append(prfweeksQuery());*///胎心监护
	$('#bscancount').append(prfweeksQuery());//B超
	$('#urinecount').append(prfweeksQuery());//尿常规
	$('#bloodcount').append(prfweeksQuery());//血常规
	var count = 0;
	if(weeks >=37 && weeks<=41){
		count = "37-41";
	}else if(weeks>=33 && weeks<=36){
		count = "33-36";
	}else if(weeks>=28 && weeks<=32){
		count = "28-32";
	}else if(weeks>=24 && weeks<=28){
		count = "24-28";
	}else if(weeks>=20 && weeks<=24){
		count = "20-24";
	}else if(weeks>=14 && weeks<=20){
		count = "14-20";
	}else if(weeks>=6 && weeks<=13){
		count = "6-13";
	}else{
		count = '1-41';
	}
	
	$('#pid').val(count);
	gradeChange(count);
	/*queryAntenatalcaretime(count);*/
	/*$('#urinecount').val(count);
	changeUrine2(count);*/
	$('#bloodcount').val(count);
	changeBlood2(count);
	$('#urinecount').val(count);
	changeUrine2(count);
	$('#bscancount').val(count);
	changeBscan(count);
	/*$('#hfcount').val(count);
	changeFetalHeart(count);*/
	$('#ecgcount').val(count);
	changeEcg3(count);
	$('#tscount').val(count);
	changeTangSrceen(count);
	$('#niptcount').val(count);
	changeNipt(count);
	
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
			blood = e.data;
			if(e.data[0].cname != undefined) {
				getBloodMessage(blood);
			}
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
			if(e.data[0].cname != undefined) {
				getLiverMessage(e.data);
			}
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
			if(e.data[0].cname != undefined) {
				getbloodTransfusion(e.data);
			}
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
			if(e.data[0].cname != undefined) {
				getEugenicsFive(e.data);
			}
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
			if(e.data[0].cname != undefined) {
				getBloodType(e.data);
			}
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
			if(e.data.bscan != null) {
				getBscan(e.data);
			}
		},
		error: function() {

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
			if(e.ecg != null) {
				getEcg(e.data);
			}
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
			if(e.data[0].cname != undefined) {
				getUrineMessage(e.data);
			}
		},
		error: function() {

		}
	});

})


//按项目查询
try{
	
}catch(e){
	//TODO handle the exception
}
$(function() {
	//查询血常规
	/*var bloodcount = $("#bloodcount").val();
	try{
		$.ajax({
		type: "post",
		url: address + "checkResult/queryResultByProject.do",
		data: {
			"count": bloodcount,
			"checkProjectId": 1,
			"mId": mid
		},
		async: false,
		dataType: "json",
		success: function(e) {
			try {
				blood = e.data;
				if(e.data[0].cname != undefined) {
					getBloodInfo(blood);
				}
			} catch(e) {
				//TODO handle the exception
			}

		},
		error: function() {

		}
	});
	
	}catch(e){
		//TODO handle the exception
	}*/
	//查询尿常规
	/*var urinecount = $("#urinecount").val();
	try{
		$.ajax({
		type: "post",
		url: address + "checkResult/queryResultByProject.do",
		data: {
			"count": urinecount,
			"checkProjectId": 2,
			"mId": mid
		},
		async: false,
		dataType: "json",
		success: function(e) {
			try {
				if(e.data[0].cname != undefined) {
					getUrineInfo(e.data);
				}
			} catch(e) {
				//TODO handle the exception
			}

		},
		error: function() {

		}
	});
	
	}catch(e){
		//TODO handle the exception
	}*/
	//查询b超
	
	/*var bscancount = $("#bscancount").val();
	$.ajax({
		type: "post",
		url: address + "bscan/queryResultByProject.do",
		data: {
			"count": bscancount,
			"checkProjectId": 14,
			"mId": mid
		},
		async: false,
		dataType: "json",
		success: function(e) {
			try {
				if(e.data[0].cname != undefined) {
					getBscanInfo(e.data);
					
				}
			} catch(e) {
				//TODO handle the exception
			}

		},
		error: function() {

		}
	});*/
	//查询心电
	/*var ecgcount = $("#ecgcount").val();
	if(ecgcount == 0){
		return;
	}
	try{
		$.ajax({
		type: "post",
		url: address + "electrocardio/queryResultByProject.do",
		data: {
			"count": ecgcount,
			"checkProjectId": 13,
			"mId": mid
		},
		async: false,
		dataType: "json",
		success: function(e) {
			try {
				if(e.data[0].cname != undefined) {
					getEcgInfo(e.data);
					
				}
			} catch(e) {
				//TODO handle the exception
			}

		},
		error: function() {

		}
	});
	
	}catch(e){
		//TODO handle the exception
	}*/
	//查询nipt
	/*var niptcount = $("#niptcount").val();
	$.ajax({
		type: "post",
		url: address + "Nipt/queryResultByProject.do",
		data: {
			"count": niptcount,
			"checkProjectId": 11,
			"mId": mid
		},
		async: false,
		dataType: "json",
		success: function(e) {
			try{
				if(e.data[0].cname != undefined) {
				getNiptInfo(e.data);
			}
			}catch(e){
				//TODO handle the exception
			}
			
		},
		error: function() {

		}
	});*/
	//查询唐筛
	/*var tscount = $("#tscount").val();
	$.ajax({
		type: "post",
		url: address + "TangScreen/queryResultByProject.do",
		data: {
			"count": tscount,
			"checkProjectId": 10,
			"mId": mid
		},
		async: false,
		dataType: "json",
		success: function(e) {
			try {
				if(e.data[0].cname != undefined) {
					
					getTangSrceen(e.data);
				}
			} catch(e) {
				//TODO handle the exception
			}

		},
		error: function() {

		}
	});*/
	//查询胎心
	var fhcount = $("#hfcount").val();
	$.ajax({
		type: "post",
		url: address + "fetalHeart/queryResultByProject.do",
		data: {
			"count": fhcount,
			"checkProjectId": 26,
			"mId": mid
		},
		async: false,
		dataType: "json",
		success: function(e) {
			
			try {
				if(e != undefined) {
					getFetalHeart(e.data);
					//console.log(e.data);
				}
			} catch(e) {
				//TODO handle the exception
			}

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
	if(template == null){
		return;
	}
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
		"<div class='class_color_tow' onclick='showMore(3)'>点击查看原始报告单</div></td></tr>";
	$("#Liver_Table").append(a);
	var a1 = "<tr class='tr_firstDiagnose_width'><td></td><td></td><td></td><td>" +
		"<a style='cursor:pointer;' data-toggle='modal' data-target='#myModal' onclick='clickShowMore(3)'>单击查看更多</a></td></tr>";
	$("#Liver_Table1").append(a1);
	var template = data[length - 1].templatetitle;
	if(template.name!=null){
		$("#liver_name").html(template.name);
	}
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
	if(template == null){
		return;
	}
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
	if(template == null){
		return;
	}
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
		"<div class='class_color_tow' onclick='showMore(6)'>点击查看原始报告单</div></td></tr>";
	$("#bloodType_table1").append(a);
	var a1 = "<tr class='tr_firstDiagnose_width'><td></td><td></td><td></td><td>" +
		"<a style='cursor:pointer;' data-toggle='modal' data-target='#myModal' onclick='clickShowMore(6)'>单击查看更多</a></td></tr>";
	$("#bloodType_table").append(a1);
	var template = data[length - 1].templatetitle;
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
//B超
function getBscan(data) {
	var length = data.length;
	var bscan = data.bscan;
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

	var template = data.templatetitle;
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
	/*$("#bscan2_checkdate").html(checkdate);*/
	var date2 = new Date(template.reportdate);
	var reportdate = date1.toLocaleDateString()
	$("#bscan_reportdate").html(reportdate);
	$("#bscan_examiner").html(template.examiner);
	$("#bscan_auditor").html(template.auditor);
}
//心电
function getEcg(data) {

	var ecg = data.ecg;
	if(ecg == null || ecg == ''){
		return;
	}
	$("#ecg_hosiptal").html(ecg.hospitalname);
	$("#heartrate").html(ecg.heartrate);
	$("#ecg_pR").html(ecg.pR);
	$("#ecg_qrs").html(ecg.qrs);
	$("#ecg_qtc").html(ecg.qtc);
	$("#ecg_rv5Sv1").html(ecg.rv5Sv1);
	$("#ecg_rscount").html(ecg.rscount);
	$("#ecg_description").html(ecg.description);
	$("#ecg_tip").html(ecg.tip);

	var template = data.templatetitle;
	if(template == null || template == ''){
		return;
	}
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
//尿常规
function getUrineMessage(data) {
	var length = data.length;
	for(var i = 0; i < 11; i = i + 2) {
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
		$("#urine_table").append(a);
		$("#urine_table1").append(a);

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
		"<div class='class_color_tow' onclick='showMore(2)'>点击查看原始报告单</div></td></tr>";
	$("#urine_table1").append(a);
	var a1 = "<tr class='tr_firstDiagnose_width'><td></td><td></td><td></td><td></td><td></td><td>" +
		"<a style='cursor:pointer;' data-toggle='modal' data-target='#myModal' onclick='clickShowMore(2)'>单击查看更多</a></td></tr>";
	$("#urine_table").append(a1);

	var template = data[length - 1].templatetitle;
	if(template == null){
		return;
	}
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

/**********   按项目查看 获取相关信息的方法    ********/
//血常规
/*function getBloodInfo(data) {
	var checkResult = data.checkResult;

	for(var i = 0; i < checkResult.length; i++) {
		var value = checkResult[i].checkValue;

		if(checkResult[i].symbol != null) {
			value = value + checkResult[i].symbol;
		}
		if(checkResult[i].cname == "白细胞") {
			$(".WBC2").html(value);
		} else if(checkResult[i].cname == "红细胞") {
			$(".RBC2").html(value);
		} else if(checkResult[i].cname == "血红蛋白") {
			$(".HGB2").html(value);
		} else if(checkResult[i].cname == "红细胞压积") {
			$(".HCT2").html(value);
		} else if(checkResult[i].cname == "血小板计数") {
			$(".PLT2").html(value);
		}

	}
	var template = data.templatetitle;
	$("#blood2_name").html(template.name);
	$("#blood2_age").html(template.age);
	$("#blood2_bednum").html(template.bednum);
	$("#blood2_medicalrecord").html(template.medicalrecord);
	$("#blood2_department").html(template.department);
	$("#blood2_sampletype").html(template.sampletype);
	if(template.pay == 0) {
		$("#blood2_pay").html("自费");
	}

	$("#blood2_senddoctor").html(template.senddoctor);
	$("#blood2_clinicaldiagnosis").html(template.clinicaldiagnosis);
	$("#blood2_sampleid").html(template.sampleid);
	$("#blood2_barcode").html(template.barcode);
	var date1 = new Date(template.checkdate);
	var checkdate = date1.toLocaleDateString()
	$(".blood2_checkdate").html(checkdate);
	var date2 = new Date(template.reportdate);
	var reportdate = date1.toLocaleDateString()
	$("#blood2_reportdate").html(reportdate);
	$("#blood2_examiner").html(template.examiner);
	$("#blood2_auditor").html(template.auditor);
	//异常信息
	var abnormityinfo = data.abnormityinfo;
	if(abnormityinfo != null) {
		//		var date1 = new Date(abnormityinfo[0].checkDate);
		//		var checkdate = date1.toLocaleDateString();
		//		$("#urine3_checkdate").html(checkdate);
		$("#blood2_highRiskResultType").html(abnormityinfo[0].highRiskResultType);
		$("#blood2_weeks").html(abnormityinfo[0].weeks + "周");
		for(var i = 0; i < abnormityinfo.length; i++) {
			var knowledge = $("#blood2_knowledge").val();
			if(abnormityinfo[i].knowledge != null) {
				knowledge = knowledge + abnormityinfo[i].knowledge + "\r\n";
				$("#blood2_knowledge").val(knowledge);
			}
		}
	}
}*/
//尿常规
/*function getUrineInfo(data) {
	var checkResult = data.checkResult;
	for(var i = 0; i < checkResult.length; i = i + 2) {
		var value;
		var rvalue = ""; //参考值
		if(checkResult[i].checkValue == null) {
			value = checkResult[i].symbol;
		} else if(checkResult[i].checkValue == 0) {
			value = checkResult[i].symbol;
			rvalue = "阴性";
			if(checkResult[i].cunit != null) {
				rvalue = rvalue + checkResult[i].cunit;
			}
		} else if(checkResult[i].checkValue == 1) {
			value = checkResult[i].checkValue + checkResult[i].symbol;
			rvalue = "阳性";
		} else {
			value = checkResult[i].checkValue;
			rvalue = checkResult[i].cbegin + "-" + checkResult[i].cend
			if(checkResult[i].cunit != null) {
				rvalue = rvalue + checkResult[i].cunit;
			}
		}
		var value1;
		var rvalue1 = ""; //参考值
		if(checkResult[i + 1].checkValue == null) {
			value1 = checkResult[i + 1].symbol;
		} else if(checkResult[i + 1].checkValue == 0) {
			value1 = checkResult[i + 1].symbol;
			rvalue1 = "阴性";
			if(checkResult[i + 1].cunit != null) {
				rvalue1 = rvalue1 + checkResult[i + 1].cunit;
			}
		} else if(checkResult[i + 1].checkValue == 1) {
			value1 = checkResult[i + 1].checkValue + checkResult[i + 1].symbol;
			rvalue1 = "阳性";
		} else {
			value1 = checkResult[i + 1].checkValue;
			rvalue1 = checkResult[i + 1].cbegin + "-" + checkResult[i + 1].cend
			if(checkResult[i + 1].cunit != null) {
				rvalue1 = rvalue1 + checkResult[i + 1].cunit;
			}
		}
		var a = "<tr class='tr_firstDiagnose_width'><td>" + checkResult[i].cname + "</td><td>" + value + "</td><td>" + rvalue + "</td>" +
			"<td>" + checkResult[i + 1].cname + "</td><td>" + value1 + "</td><td>" + rvalue1 + "</td></tr>";
		$("#urine_table2").append(a);
	}
	var a = "<tr class='tr_firstDiagnose_width'><td></td><td></td><td></td><td></td><td></td><td>" +
		"<div class='class_color_tow' onclick='showMore(2)'>点击查看原始报告单</div></td></tr>";
	$("#urine_table2").append(a);

	var template = data.templatetitle;
	$("#urine2_name").html(template.name);
	$("#urine2_age").html(template.age);
	$("#urine2_bednum").html(template.bednum);
	$("#urine2_medicalrecord").html(template.medicalrecord);
	$("#urine2_department").html(template.department);
	$("#urine2_sampletype").html(template.sampletype);
	if(template.pay == 0) {
		$("#urine2_pay").html("自费");
	}

	$("#urine2_senddoctor").html(template.senddoctor);
	$("#urine2_clinicaldiagnosis").html(template.clinicaldiagnosis);
	$("#urine2_sampleid").html(template.sampleid);
	$("#urine2_barcode").html(template.barcode);
	var date1 = new Date(template.checkdate);
	var checkdate = date1.toLocaleDateString()
	$(".urine2_checkdate").html(checkdate);
	var date2 = new Date(template.reportdate);
	var reportdate = date1.toLocaleDateString()
	$("#urine2_reportdate").html(reportdate);
	$("#urine2_examiner").html(template.examiner);
	$("#urine2_auditor").html(template.auditor);
	//异常信息
	var abnormityinfo = data.abnormityinfo;
	if(abnormityinfo != null) {

		$("#urine2_highRiskResultType").html(abnormityinfo[0].highRiskResultType);
		$("#urine2_weeks").html(abnormityinfo[0].weeks + "周");
		for(var i = 0; i < abnormityinfo.length; i++) {
			var knowledge = $("#urine2_knowledge").val();
			if(abnormityinfo[i].knowledge != null) {
				knowledge = knowledge + abnormityinfo[i].knowledge + "\r\n";
				$("#urine2_knowledge").val(knowledge);
			}
		}
	}

}*/
//B超
/*function getBscanInfo(data) {

	var bscan = data.bscan;
	$("#bscan2_way").html(bscan.way);
	$("#probefrequency2").html(bscan.probefrequency);
	$("#bladder2").html(bscan.bladder);
	$("#piclevel2").html(bscan.piclevel);
	$("#checkpoint2").html(bscan.checkpoint);

	$("#bdescription2").html(bscan.bdescription);

	$("#btip2").html(bscan.btip);

	$("#bscan2_hosiptal").html(bscan.way);

	$("#bpd2").html(bscan.bpd);
	$("#fetalheartrate2").html(bscan.fetalheartrate);
	$("#amnioticfluid2").html(bscan.amnioticfluid);
	var rightovary; //右侧卵巢
	if(bscan.rightovary == 0) {
		rightovary = "正常大小";
	} else {
		rightovary = "其他";
	}
	$("#rightovary2").html(rightovary);
	$("#crl2").html(bscan.crl);
	var placentalposition; //胎盘位置
	if(bscan.placentalposition == 0) {
		placentalposition = "前壁";
	} else if(bscan.placentalposition == 1) {
		placentalposition = "侧壁";
	} else if(bscan.placentalposition == 2) {
		placentalposition = "后壁";
	}
	$("#placentalposition2").html(placentalposition);

	$("#femurl2").html(bscan.femurl);
	var fetalmovement; //胎动
	if(bscan.fetalmovement == 0) {
		fetalmovement = "见";
	} else {
		fetalmovement = "未见";
	}
	$("#fetalmovement2").html(fetalmovement);
	$("#placentalthickness2").html(bscan.placentalthickness);
	$("#humerusl2").html(bscan.humerusl);
	var fetalheart; //胎心
	if(bscan.fetalheart == 0) {
		fetalheart = "见";
	} else {
		fetalheart = "未见";
	}
	$("#fetalheart2").html(fetalheart);

	var leftovary; //左侧卵巢
	if(bscan.leftovary == 0) {
		leftovary = "正常大小";
	} else {
		leftovary = "其他";
	}
	$("#leftovary2").html(leftovary);
	$("#nt2").html(bscan.nt);
	$("#nf2").html(bscan.nf);
	var nasalbone; //鼻骨
	if(bscan.nasalbone == 0) {
		nasalbone = "显示";
	} else {
		nasalbone = "未显示";
	}
	$("#nasalbone2").html(nasalbone);
	var fetusnumber; //胎数
	if(bscan.fetusnumber == 1) {
		fetusnumber = "单胎";
	} else {
		fetusnumber = "多胎";
	}
	$("#fetusnumber2").html(bscan.fetusnumber);
	$("#weeks2").html(bscan.weeks);*/
	/*var changwee = sessionStorage.getItem('week12');
	$("#weeks2").html(changwee);*/

	//异常信息
	/*var abnormityinfo = data.bscan;
	console.log(abnormityinfo);
	if(abnormityinfo != null) {*/
		/*var date1 = new Date(abnormityinfo.checkdate);
		var checkdate = date1.toLocaleDateString();*/
		/*$("#bscan2_checkdate").html(longToDate(abnormityinfo.checkdate));
		$("#bscan_highRiskResultType").html(abnormityinfo.highRiskResultType);*/
		//alert(abnormityinfo[0].week);
		
		/*$("#bscan2_weeks").html((abnormityinfo.week)?abnormityinfo.week:'');
		for(var i = 0; i < abnormityinfo.length; i++) {

			var knowledge = $("#bscan_knowledge").val();
			if(abnormityinfo[i].knowledge != null) {
				knowledge = knowledge + abnormityinfo[i].knowledge + "\r\n";
				$("#bscan_knowledge").val(knowledge);
			}
		}
	} else {
		var date1 = new Date(bscan.checkdate);
		var checkdate = date1.toLocaleDateString();
		$("#bscan2_checkdate").html(checkdate);
		$("#bscan_knowledge").val(bscan.bdescription);
	}

}*/
//心电
/*function getEcgInfo(data) {*/
	
	/*var ecg = data.ecg;
	if(ecg != null) {
	$("#ecg2_hosiptal").html(ecg.hospitalname);
	$("#heartrate2").html(ecg.heartrate);
	$("#ecg2_pR").html(ecg.pR);
	$("#ecg2_qrs").html(ecg.qrs);
	$("#ecg2_qtc").html(ecg.qtc);
	$("#ecg2_rv5Sv1").html(ecg.rv5Sv1);
	$("#ecg2_rscount").html(ecg.rscount);
	$("#ecg2_description").html(ecg.description);
	$("#ecg2_tip").html(ecg.tip);*/
	//异常信息
	
	/*var abnormityinfo = data.abnormityinfo;*/
		/*var date1 = new Date(abnormityinfo[0].checkDate);
		var checkdate = date1.toLocaleDateString();*/
		/*$("#ecg2_checkdate").html(getDateString(ecg.checkdate));*/
		/*$("#ecg_highRiskResultType").html(abnormityinfo[0].highRiskResultType);*/
		/*$("#ecg_weeks").html(ecg.weeks + "周");*/
		/*for(var i = 0; i < abnormityinfo.length; i++) {
			var knowledge = $("#ecg_knowledge").val();
			if(abnormityinfo[i].knowledge != null) {
				knowledge = knowledge + abnormityinfo[i].knowledge + "\r\n";
				$("#ecg_knowledge").val(knowledge);
			}*/
	/*		var knowledge = $("#ecg_knowledge").val();
			knowledge = knowledge + ecg.tip + "\r\n";
			$("#ecg_knowledge").val(knowledge);

		}
	}
*/
//nipt
/*function getNiptInfo(data) {
	var nipt = data.nipt;
	var sampletime = getDateString(nipt.sampletime);
	$("#nipt_sampletime").html(sampletime);
	var receivedtime = getDateString(nipt.receivedtime);
	$("#nipt_receivedtime").html(receivedtime);
	$("#nipt_enddate").html(getDateString(nipt.enddate));
	$("#nipt_history").html(nipt.history);
	var urlimg = nipt.bpiclink;
	$(".niptimg").append("<tr><td colspan='4' class='niptclass' onclick='seeOriginalReport(\"" + urlimg + "\")'><a>点击查看原始报告</a></td></tr>");
	var fetusnumber = "";
	switch(nipt.fetusnumber) {
		case 1:
			fetusnumber = "单胎";
			break;
		case 2:
			fetusnumber = "双胎";
			break;
		case 3:
			fetusnumber = "多胎";
			break;
		case 4:
			fetusnumber = "其他";
			break;
	}

	$("#nipt_fetusnumber").html(fetusnumber);
	$("#nipt_sampletype").html(nipt.sampletype);
	var samplestatus;
	if(nipt.samplestatus == 0) {
		samplestatus = "合格";
	} else {
		samplestatus = "不合格";
	}
	$("#nipt_samplestatus").html(samplestatus);
	$("#nipt_clinicaldiagnosis").html(nipt.clinicaldiagnosis);
	var methodsandproperties = "";
	if(nipt.methodsandproperties == 0) {
		methodsandproperties = "母体外周血胎儿游离DNA高通量测序分析";
	}
	$("#methodsandproperties").html(methodsandproperties);
	var project = "";
	if(nipt.project == 0) {
		project = "胎儿染色体非整倍体（T21、T18、T13)检查";
	}
	$("#nipt_project").html(project);
	$("#nipt_description").html(nipt.description);
	$("#nipt_tip").html(nipt.tip);
	var ivfEt = "";
	if(nipt.ivfEt == 0) {
		ivfEt = "否";
	} else {
		ivfEt = "是";
	}
	$("#nipt_ivfEt").html(ivfEt);
	$("#nipt_t21").html(nipt.t21);
	$("#nipt_t18").html(nipt.t18);
	$("#nipt_t13").html(nipt.t13);
	$("#nipt_reporttime").html(getDateString(nipt.reporttime));
	$("#nipt_checkdate").html(getDateString(nipt.checkdate));
	$("#nipt_examiner").html(nipt.examiner);
	$("#nipt_auditor").html(nipt.auditor);
	if(nipt.t21 >= -3 && nipt.t21 < 3) {
		$("#t21_result").html("低风险");
	}
	if(nipt.t18 >= -3 && nipt.t18 < 3) {
		$("#t18_result").html("低风险");
	}
	if(nipt.t13 >= -3 && nipt.t13 < 3) {
		$("#t13_result").html("低风险");
	}
	//异常信息(首诊结论)
	var abnormityinfo = data.abnormityinfo;
	if(abnormityinfo != null && abnormityinfo != "") {
		alert(0);
		var date1 = new Date(abnormityinfo[0].checkDate);
		alert(1);
		var checkdate = date1.toLocaleDateString();
		$("#nipt2_checkdate").html(checkdate);
		$("#nipt_highRiskResultType").html(abnormityinfo[0].highRiskResultType);
		$("#nipt_weeks").html(abnormityinfo[0].weeks + "周");
		for(var i = 0; i < abnormityinfo.length; i++) {
			var knowledge = $("#nipt_knowledge").val();
			if(abnormityinfo[i].knowledge != null) {
				knowledge = knowledge + abnormityinfo[i].knowledge + "\r\n";
				$("#nipt_knowledge").val(knowledge);
			}

		}
	} else {
		$("#nipt2_checkdate").html(getDateString(nipt.checkdate));
		$("#nipt_weeks").html(nipt.weeks + "周");
		$("#nipt_knowledge").html(nipt.description);
	}
}*/
//唐筛
/*function getTangSrceen(data) {
	console.log(data);
	var gravida = data.gravidainfo;
	if(gravida == null || gravida == ''){
		return;
	}
	$("#ts_weeks").html(getDateString(gravida.enddate));
	$("#ts_name").html(gravida.gname);
	$("#ts_phone").html(gravida.familyMemberList[0].phone);
	var idcard = gravida.familyMemberList[0].identitycard;
	var birthdate = idcard.substr(6, 4) + "-" + idcard.substr(10, 2) + "-" + idcard.substr(12, 2);
	$("#ts_birthdate").html(birthdate);
	$("#ts_pregnancyBirth").html(gravida.pregnancyBirth);
	//唐筛
	var ts = data.tangScreen;
	var sampletime = getDateString(ts.sampletime);
	$("#ts_sampletime").html(sampletime);
	$("#ts_tsid").html(ts.tsid);
	$("#ts_samplenum").html(ts.samplenum);
	var fetusnumber = "";
	switch(ts.fetusnumber) {
		case 1:
			fetusnumber = "单胎";
			break;
		case 2:
			fetusnumber = "双胎";
			break;
		case 3:
			fetusnumber = "多胎";
			break;
		default:
			fetusnumber = "其他";
			break;
	}

	$("#ts_fetusnumber").html(fetusnumber);
	$("#ts_smaterials").html(ts.smaterials);
	$("#ts_numeration").html(ts.numeration);

	$("#ts_smethod").html(ts.smethod);
	$("#ts_senddept").html(ts.senddept);
	$("#ts_senddoctor").html(ts.senddoctor);
	$("#ts_conclusion").html(ts.conclusion);
	$("#ts_hafp").html(ts.hafp);

	$("#ts_hafqMom").html(ts.hafqMom);
	$("#ts_freeHcg").html(ts.freeHcg);
	$("#ts_freeHcgMom").html(ts.freeHcgMom);
	$("#ts_ntd").html(ts.ntd);
	$("#ts_t21").html(ts.t21);
	$("#ts_t18").html(ts.t18);
	$("#ts_reporttime").html(getDateString(ts.reporttime));
	$("#ts_checkdate").html(getDateString(ts.checkdate));
	$("#ts_examiner").html(ts.examiner);
	$("#ts_auditor").html(ts.auditor);
	
	//异常信息(首诊结论)
	var abnormityinfo = data.abnormityinfo;
	if(abnormityinfo != null && abnormityinfo != "") {
		var date1 = new Date(abnormityinfo[0].checkDate);
		var checkdate = date1.toLocaleDateString();
		$("#ts2_checkdate").html(checkdate);
		$("#ts_highRiskResultType").html(abnormityinfo[0].highRiskResultType);
		$("#ts_weeks").html(abnormityinfo[0].weeks + "周");
		for(var i = 0; i < abnormityinfo.length; i++) {
			var knowledge = $("#ts_knowledge").val();
			if(abnormityinfo[i].knowledge != null) {
				knowledge = knowledge + abnormityinfo[i].knowledge + "\r\n";
				$("#ts_knowledge").val(knowledge);
			}

		}
	} else {
		$("#ts2_checkdate").html(getDateString(ts.checkdate));
		$("#ts_weeks").html(ts.weeks + "周");
		$("#ts_knowledge").html(ts.conclusion);
	}
}*/
//胎心监护
function getFetalHeart(data) {
	$("#fh_frateline").html("");
	$("#fh_sleepwakecycle").html("");
	$("#fh_waveshape").html("");
	$("#fh_fetalmovements").html("");
	$("#speedupTimes").html("");
	$("#flineScore").html("");
	$("#fwaveScore").html("");
	$("#friseScore").html("");
	$("#fchangeScore").html("");
	$("#fmoveScore").html("");
	$('.whatthe').val("");
	$('.spanresult').text("");
	var fh = data.fetalheart;
	if(fh != null){
		$("#fh_frateline").html(fh.frateline);
	}
	
	var sleepwakecycle = "";
	switch(fh.sleepwakecycle) {
		case 0:
			sleepwakecycle = "明显";
			break;
		case 1:
			sleepwakecycle = "不明显";
			break;
	}
	$("#fh_sleepwakecycle").html(sleepwakecycle);
	var waveshape = "";
	switch(fh.waveshape) {
		case 0:
			waveshape = "平滑";
			break;
		case 1:
			waveshape = "正弦波";
			break;
	}
	$("#fh_waveshape").html(waveshape);
	var fetalmovements = "";
	if(fh.fetalmovements > 3) {
		fetalmovements = ">3次";
	} else {
		fetalmovements = fh.fetalmovements + "次";
	}
	$("#fh_fetalmovements").html(fetalmovements);
	var list = fh.flList;
	if(list.length > 0) {
		var speedupTimes = 0; //加速次数 
		var changeValue = list[0].changevalue; //FHR最大改变值
		var risetime = list[0].risetime;
		for(var i = 0; i < list.length; i++) {
			if(changeValue < list[i].changevalue) {
				//计算FHR最大改变值
				changeValue = list[i].changevalue;
			}
			if(risetime < list[i].risetime) {
				//计算最大 上升时间
				risetime = list[i].risetime;
			}
			if(list[i].type == 3) {
				speedupTimes++; //计算加速次数
			}
		}
		if(speedupTimes > 3) {
			speedupTimes = ">3次";
		} else {
			speedupTimes = speedupTimes + "次";
		}
		$("#speedupTimes").html(speedupTimes); //加速次数
		//计算 Fischer评分
		var flineScore; //胎心率基线得分
		var fwaveScore; //振幅摆动范围 得分
		var friseScore; //FHR上升时间得分
		var fchangeScore; //FHR改变得分
		var fmoveScore; //胎动次数得分
		var sumScore; //总分
		if(fh.frateline < 100) {
			flineScore = 0;
		} else if((fh.frateline >= 100 && fh.frateline <= 119) || fh.frateline > 160) {
			flineScore = 1;
		} else if(fh.frateline >= 120 && fh.frateline <= 160) {
			flineScore = 2;
		}
		//振幅摆动范围 得分   //需要修改  振幅摆动？？
		if(changeValue < 5) {
			fwaveScore = 0;
		} else if((changeValue >= 5 && changeValue <= 9) || changeValue > 30) {
			fwaveScore = 1;
		} else if(changeValue >= 10 && changeValue <= 30) {
			fwaveScore = 2;
		}
		//FHR上升时间得分
		if(risetime < 10) {
			friseScore = 0;
		} else if(risetime >= 10 && risetime <= 14) {
			friseScore = 1;
		} else if(risetime >= 15) {
			friseScore = 2;
		}
		//FHR改变得分
		if(changeValue < 10) {
			fchangeScore = 0;
		} else if(changeValue >= 10 && changeValue <= 14) {
			fchangeScore = 1;
		} else if(changeValue >= 15) {
			fchangeScore = 2;
		}
		//胎动次数得分
		if(fh.fetalmovements == 0) {
			fmoveScore = 0;
		} else if(fh.fetalmovements == 1 || fh.fetalmovements == 2) {
			fmoveScore = 1;
		} else if(fh.fetalmovements == 3) {
			fmoveScore = 2;
		}

		$("#flineScore").html(flineScore);
		$("#fwaveScore").html(fwaveScore);
		$("#friseScore").html(friseScore);
		$("#fchangeScore").html(fchangeScore);
		$("#fmoveScore").html(fmoveScore);
		$("#Fischer").html("");
		//总分
		var sumScore = flineScore + fwaveScore + friseScore + fchangeScore + fmoveScore;

		$("#Fischer").html(sumScore);
		if(sumScore>=8 && sumScore<=10){
			$('#div-fifth-p-15').val()==0;
		}else{
			$('#div-fifth-p-15').val()==3;
		}
		
	}
	var template = data.templatetitle;
	if(template != null) {
		$("#fh_reporttime").html(getDateString(template.reportdate));
		$("#fh_checkdate").html(getDateString(template.checkdate));
		$("#fh_examiner").html(template.examiner);
		$("#fh_auditor").html(template.auditor);
	}
	//异常信息(首诊结论)
	$("#fh2_checkdate").html("");
	$("#fh_highRiskResultType").html("");
	$("#fh_weeks").html("");
	var abnormityinfo = data.abnormityinfo;
	if(abnormityinfo != null && abnormityinfo != "") {
		var date1 = new Date(abnormityinfo[0].checkDate);
		var checkdate = date1.toLocaleDateString();
		$("#fh2_checkdate").html(checkdate);
		$("#fh_highRiskResultType").html(abnormityinfo[0].highRiskResultType);
		$("#fh_weeks").html(abnormityinfo[0].weeks + "周");
		$("#fh_knowledge").val("");
		for(var i = 0; i < abnormityinfo.length; i++) {
			var knowledge = $("#fh_knowledge").val();
			if(abnormityinfo[i].knowledge != null) {
				knowledge = knowledge + abnormityinfo[i].knowledge + "\r\n";
				$("#fh_knowledge").val(knowledge);
			}
		}
	} else {
		$("#fh2_checkdate").html(getDateString(fh.checkdate));
		$("#fh_weeks").html(fh.weeks + "周");
		$("#fh_knowledge").html(fh.description);
	}
}

//转换日期类型
function getDateString(mydate) {
	var date1 = new Date(mydate);
	var time = date1.toLocaleDateString();
	return time;
}

/*function changeBlood(count) {
	
	//血常规
	$.ajax({
		type: "post",
		url: address + "checkResult/queryResultByProject.do",
		data: {
			"count": count,
			"checkProjectId": 1,
			"mId": mid
		},
		async: false,
		dataType: "json",
		success: function(e) {

			blood = e.data;
			//alert(blood);
			getBloodInfo(blood);
		},
		error: function() {

		}
	});
}*/

/*function changeUrine(count) {
	//尿常规
	$.ajax({
		type: "post",
		url: address + "checkResult/queryResultByProject.do",
		data: {
			"count": count,
			"checkProjectId": 2,
			"mId": mid
		},
		async: false,
		dataType: "json",
		success: function(e) {
			getUrineInfo(e.data);
		},
		error: function() {

		}
	});
}*/

function changeBscan(count) {
	//b超
	/*$.ajax({
		type: "post",
		url: address + "bscan/queryResultByProject.do",
		data: {
			"count": count,
			"checkProjectId": 14,
			"mId": mid
		},
		async: false,
		dataType: "json",
		success: function(e) {

			getBscanInfo(e.data);
		},
		error: function() {

		}
	});*/
	$('#bscan2_checkdate').html("");
	$('#bscan2_weeks').html("");
	$(".bscanImg").empty();
	$('.bscan-table').empty();
	$('.whatthe').val("");
	$('.spanresult').text("");
	var weeks = count;
	var sweeks2 = 0;
	var eweeks2 = 0;
	if(weeks != 0 && weeks != undefined) {
		//开始孕周
		var w = weeks.split('-');
		sweeks2 = w[0];
		eweeks2 = w[1];
	}
	if(sweeks2 == 6 && eweeks2 == 13 || sweeks2 == 1 && eweeks2 == 41){
		$('.div-check-forth').text("首诊结论");
	}else{
		$('.div-check-forth').text("复诊结论");
	}
	if(sweeks2 == 1){
		return;
	}
	var week = '';
	if(sweeks2 == 6 && eweeks2 == 13){
		week = 10;
	}else if(sweeks2 == 14 && eweeks2 == 20){
		week = 18;
	}else if(sweeks2 == 20 && eweeks2 == 24){
		week = 22;
	}else if(sweeks2 == 24 && eweeks2 == 28){
		week = 26;
	}else if(sweeks2 == 28 && eweeks2 == 32){
		week = 30;
	}else if(sweeks2 == 33 && eweeks2 == 36){
		week = 35;
	}else if(sweeks2 == 37 && eweeks2 == 41){
		week = 39;
	}else{
		week == null;
	}
	showTest(week);		
	
	var report = checkReport({
		checkProjectId: 14,
		startWeek: sweeks2,
		endWeek: eweeks2,
		mid: mid,
		htmlType: 'table-bscan'
	});
	var picLink = checkReport.prototype.reportData ;
	if(picLink == null || picLink.length == 0){
		return;
	}
	$('#bscan2_checkdate').html(longToDate(picLink[0].checkDate));
	$('#bscan2_weeks').html(picLink[0].gWeeks);
	var urlimg = picLink[0].picLink;
	$(".bscanImg").append("<tr><td colspan='4' class='niptclass' onclick='seeOriginalReport(\"" + urlimg + "\")'><a>查看原始报告</a></td></tr>");
	$('.bscan-table').html(report);

}

function changeEcg3(count) {
	//心电
	$("#ecg2_hosiptal").html("");
	$("#heartrate2").html("");
	$("#ecg2_pR").html("");
	$("#ecg2_qrs").html("");
	$("#ecg2_qtc").html("");
	$("#ecg2_rv5Sv1").html("");
	$("#ecg2_rscount").html("");
	$("#ecg2_description").html("");
	$("#ecg2_tip").html("");
	$("#ecg2_checkdate").html("");	
	$("#ecg_weeks").html("");
	$("#ecg_knowledge").val("");
	$(".ecgImg").empty();
	$('#ecg2_description').html("");
	$('.whatthe').val("");
	$('.spanresult').text("");
	/*$.ajax({
		type: "post",
		url: address + "electrocardio/queryResultByProject.do",
		data: {
			"count": count,
			"checkProjectId": 13,
			"mId": mid
		},
		async: false,
		dataType: "json",
		success: function(e) {
			getEcgInfo(e.data);
		},
		error: function() {

		}
	});*/
	var weeks = count;
	var sweeks2 = 0;
	var eweeks2 = 0;
	if(weeks != 0 && weeks != undefined) {
		//开始孕周
		var w = weeks.split('-');
		sweeks2 = w[0];
		eweeks2 = w[1];
	}
	if(sweeks2 == 6 && eweeks2 == 13 || sweeks2 == 1 && eweeks2 == 41){
		$('.div-sixth-p').text("首诊结论");
	}else{
		$('.div-sixth-p').text("复诊结论");
	}
	if(sweeks2 == 1){
		return;
	}
	var week = '';
	if(sweeks2 == 6 && eweeks2 == 13){
		week = 10;
	}else if(sweeks2 == 14 && eweeks2 == 20){
		week = 18;
	}else if(sweeks2 == 20 && eweeks2 == 24){
		week = 22;
	}else if(sweeks2 == 24 && eweeks2 == 28){
		week = 26;
	}else if(sweeks2 == 28 && eweeks2 == 32){
		week = 30;
	}else if(sweeks2 == 33 && eweeks2 == 36){
		week = 35;
	}else if(sweeks2 == 37 && eweeks2 == 41){
		week = 39;
	}else{
		week == null;
	}
	showTest(week);		
	
	var report = checkReport({
		checkProjectId: 13,
		startWeek: sweeks2,
		endWeek: eweeks2,
		mid: mid,
		htmlType: 'table-ecg'
	});
	var picLink = checkReport.prototype.reportData ;
	//console.log(picLink);
	if(picLink == null || picLink.length == 0){
		return;
	}
	$('#ecg2_checkdate').html(longToDate(picLink[0].checkDate));
	$('#ecg_weeks').html(picLink[0].gWeeks);
	var urlimg = picLink[0].picLink;
	//console.log(urlimg);
	$(".ecgImg").append("<tr><td colspan='4' class='niptclass' onclick='seeOriginalReport(\"" + urlimg + "\")'><a>查看原始报告</a></td></tr>");
	$('.left_doctorAdviceManager_content23').html(report);
	$('#ecg2_description').html(picLink[0].fontresult);
}

function changeNipt(count) {
	//nipt
	$("#nipt_ivfEt").html("");
	$("#nipt_t21").html("");
	$("#nipt_t18").html("");
	$("#nipt_t13").html("");
	$("#nipt_reporttime").html("");
	$("#nipt_checkdate").html("");
	$("#nipt_examiner").html("");
	$("#nipt_auditor").html("");
	$("#nipt2_checkdate").html("");
	$("#nipt_highRiskResultType").html("");
	$("#nipt_weeks").html("");
	$("#nipt_knowledge").val("");
	$("#t21_result").html("");
	$("#t18_result").html("");
	$("#t13_result").html("");
	$('#nipt_description').html('');
	$('#nipt_tip').html('');
	$(".niptimg").empty();
	$('#nipt_description').html("");
	$('.whatthe').val("");
	$('.spanresult').text("");
	/*$.ajax({
		type: "post",
		url: address + "Nipt/queryResultByProject.do",
		data: {
			"count": count,
			"checkProjectId": 11,
			"mId": mid
		},
		async: false,
		dataType: "json",
		success: function(e) {

			getNiptInfo(e.data);
		},
		error: function() {

		}
	});*/
	var weeks = count;
	var sweeks2 = 0;
	var eweeks2 = 0;
	if(weeks != 0 && weeks != undefined) {
		//开始孕周
		var w = weeks.split('-');
		sweeks2 = w[0];
		eweeks2 = w[1];
	}
	if(sweeks2 == 6 && eweeks2 == 13 || sweeks2 == 1 && eweeks2 == 41){
		$('.div-eigth-p').text("首诊结论");
	}else{
		$('.div-eigth-p').text("复诊结论");
	}
	if(sweeks2 == 1){
		return;
	}
	var week = '';
	if(sweeks2 == 6 && eweeks2 == 13){
		week = 10;
	}else if(sweeks2 == 14 && eweeks2 == 20){
		week = 18;
	}else if(sweeks2 == 20 && eweeks2 == 24){
		week = 22;
	}else if(sweeks2 == 24 && eweeks2 == 28){
		week = 26;
	}else if(sweeks2 == 28 && eweeks2 == 32){
		week = 30;
	}else if(sweeks2 == 33 && eweeks2 == 36){
		week = 35;
	}else if(sweeks2 == 37 && eweeks2 == 41){
		week = 39;
	}else{
		week == null;
	}
	showTest(week);		
	var report = checkReport({
		checkProjectId: 11,
		startWeek: sweeks2,
		endWeek: eweeks2,
		mid: mid,
		htmlType: 'table-nipt'
	});
	var picLink = checkReport.prototype.reportData ;
	if(picLink == null || picLink.length == 0){
		return;
	}
	
	$('#nipt2_checkdate').html(longToDate(picLink[0].checkDate));
	$('#nipt_weeks').html(picLink[0].gWeeks);
	var urlimg = picLink[0].picLink;
	//console.log(urlimg);
	$(".niptimg").append("<tr><td colspan='4' class='niptclass' onclick='seeOriginalReport(\"" + urlimg + "\")'><a>查看原始报告</a></td></tr>");
	$('.form_doctorAdviceManager_content2').html(report);
	$('#nipt_description').html(picLink[0].fontresult);
}

function changeTangSrceen(count) {
	//唐筛
	$("#ts2_checkdate").html("");
	$("#ts_highRiskResultType").html("");
	$("#ts_weeks").html("");
	$("#ts_knowledge").val("");
	$("#ts_fetusnumber").html("");
	$("#ts_smaterials").html("");
	$("#ts_numeration").html("");
	$("#ts_smethod").html("");
	$("#ts_senddept").html("");
	$("#ts_senddoctor").html("");
	$("#ts_conclusion").html("");
	$("#ts_hafp").html("");

	$("#ts_hafqMom").html("");
	$("#ts_freeHcg").html("");
	$("#ts_freeHcgMom").html("");
	$("#ts_ntd").html("");
	$("#ts_t21").html("");
	$("#ts_t18").html("");
	$("#ts_reporttime").html("");
	$("#ts_checkdate").html("");
	$("#ts_examiner").html("");
	$("#ts_auditor").html("");
	$(".tangImg").empty();
	$('#ts_conclusion').html("");
	$('.whatthe').val("");
	$('.spanresult').text("");
	/*$.ajax({
		type: "post",
		url: address + "TangScreen/queryResultByProject.do",
		data: {
			"count": count,
			"checkProjectId": 10,
			"mId": mid
		},
		async: false,
		dataType: "json",
		success: function(e) {

			getTangSrceen(e.data);
		},
		error: function() {

		}
	});*/
	var weeks = count;
	var sweeks2 = 0;
	var eweeks2 = 0;
	if(weeks != 0 && weeks != undefined) {
		//开始孕周
		var w = weeks.split('-');
		sweeks2 = w[0];
		eweeks2 = w[1];
	}
	if(sweeks2 == 6 && eweeks2 == 13 || sweeks2 == 1 && eweeks2 == 41){
		$('.div-seventh-p').text("首诊结论");
	}else{
		$('.div-seventh-p').text("复诊结论");
	}
	if(sweeks2 == 1){
		return;
	}
	var week = '';
	if(sweeks2 == 6 && eweeks2 == 13){
		week = 10;
	}else if(sweeks2 == 14 && eweeks2 == 20){
		week = 18;
	}else if(sweeks2 == 20 && eweeks2 == 24){
		week = 22;
	}else if(sweeks2 == 24 && eweeks2 == 28){
		week = 26;
	}else if(sweeks2 == 28 && eweeks2 == 32){
		week = 30;
	}else if(sweeks2 == 33 && eweeks2 == 36){
		week = 35;
	}else if(sweeks2 == 37 && eweeks2 == 41){
		week = 39;
	}else{
		week == null;
	}
	showTest(week);		
	var report = checkReport({
		checkProjectId: 10,
		startWeek: sweeks2,
		endWeek: eweeks2,
		mid: mid,
		htmlType: 'table-tang'
	});
	var picLink = checkReport.prototype.reportData ;
	if(picLink == null || picLink.length == 0){
		return;
	}
	$('#ts2_checkdate').html(longToDate(picLink[0].checkDate));
	$('#ts_weeks').html(picLink[0].gWeeks);
	var urlimg = picLink[0].picLink;
	//console.log(urlimg);
	$(".tangImg").append("<tr><td colspan='4' class='niptclass' onclick='seeOriginalReport(\"" + urlimg + "\")'><a>查看原始报告</a></td></tr>");
	$('.form_doctorAdviceManager_content').html(report);
	$('#ts_conclusion').html(picLink[0].fontresult);
}

function changeFetalHeart(count) {
	//查询胎心
	$.ajax({
		type: "post",
		url: address + "fetalHeart/queryResultByProject.do",
		data: {
			"count": count,
			"checkProjectId": 26,
			"mId": mid
		},
		async: false,
		dataType: "json",
		success: function(e) {

			getFetalHeart(e.data);
		},
		error: function() {

		}
	});
}




