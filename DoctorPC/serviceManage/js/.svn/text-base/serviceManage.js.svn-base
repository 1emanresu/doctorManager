var address = sessionStorage.getItem("address");
var address2 = address.replace('doctormanager','gravidamanager');
//var address2 = "http://192.168.1.38:8080/gravidamanager/";
//var address = "http://192.168.1.38:8080/doctormanager/";
var row = sessionStorage.getItem('row');
var num = sessionStorage.getItem("whether2");
var rows = JSON.parse(row);
console.log(rows)
var age;
//error计数
var errorNum = 0;
var oTable;
$(function() {
	//查询vip用户列表
	//queryByVip();
	var url = address + 'gravidainfo/queryByVip.do';
	oTable = new TableInit(url, "user_list", getColumnParams(),true);
	changeParam();
	//获取高危题目列表
	getHighList(); 
	//获取医院列表
	getHospital();
	//获取vip等级下拉列表
	getVipList();
	//为关系下拉中赋值
	relation();
	$('#weeksQuery').append(prfweeksQuery());
	$("#high_result1").hide();
	
	//为mid赋值
	if(num == 3){
		$(".mid1").val(rows.mId);
		showMessage();
	}else{
		$(".mid1").val(getMid());
	}
	
	
	$("#myform1").validate();
	$("#myform2").validate();
	$("#myform5").validate();
	
});

function showMessage(){
	if(rows.pergnancystatus != null && rows.pergnancystatus != undefined){
		$('#stateInfo').val(rows.pergnancystatus);
		changeStateInfo();
	}
	/*if(rows.gName != null && rows.gName != undefined){
		alert(rows.gName);
		$('#gname').val(rows.gName);
	}
	if(rows.birthYears != null && rows.birthYears != undefined){
		$('#birthYears').val(rows.birthYears);
	}
	if(rows.medicalrecordno != null && rows.medicalrecordno != undefined){
		$('#myPhone1').val(rows.medicalrecordno);
	}*/
}

//改变查询的参数
function changeParam() {
	var medicalrecordno = $(".medicalrecordno").val();
	var weeks = $("#weeksQuery").val();
	var sweeks = -1;
	var eweeks = -1;
	if(weeks != 0 && weeks != undefined) {
		//开始孕周
		var w = weeks.split('-');
		sweeks = w[0];
		eweeks = w[1];
	}
	var params = {
		'vipGrade': $('.vipGrade').val(),
		'sweeks': sweeks, //开始孕周
		'eweeks': eweeks, //结束孕周
		'medicalrecordno': medicalrecordno //病历卡号
	};
	oTable.Init(params);
//	$.ajax({
//		type:"post",
//		url:address+'gravidainfo/queryByVip.do',
//		data:{'vipGrade': undefined,//
//		'sweeks': 1, //开始孕周
//		'eweeks': 44, //结束孕周
//		'name': undefined,
//		'medicalrecordno': undefined //病历卡号
//	},
//		async:true,
//		success:function(d){
//			console.log(JSON.stringify(d));
//		}
//	});
}

//搜索功能
function searchList() {
	medicalrecordno = $(".medicalrecordno").val();
	changeParam();
}

//随机生成mid
function getMid() {
	var mid = "dg";
	for(var i = 0; i < 6; i++) {
		mid += Math.floor(Math.random() * 10);
	}
	return mid;
}

//拖动
$(function() {

	$(".tuodongfloatdivposition").mousedown(function(e) {
		iDiffXdivfloat = e.pageX - $(this).offset().left;
		iDiffYdivfloat = e.pageY - $(this).offset().top;
		$(document).mousemove(function(e) {
			$(".tuodongfloatdivposition").css({
				"left": (e.pageX - iDiffXdivfloat),
				"top": (e.pageY - iDiffYdivfloat)
			});
		});
	});
	$(".tuodongfloatdivposition").mouseup(function() {
		$(document).unbind("mousemove");
	});

	
});

function chewww_zzjs_netValidate(cb) {
	for(j = 0; j < 6; j++) {
		if(eval("document.formname.boxname[" + j + "].checked") == true) {
			document.formname.boxname[j].checked = false;
			if(j == cb) {
				document.formname.boxname[j].checked = true;
			}
		}
	}

	if(cb == 0) {
		guanbiriskchange();

		$(".risktypechange1").show();

	}
	if(cb == 1) {

		guanbiriskchange();
		$(".risktypechange2").show();

	}
	if(cb == 2) {

		guanbiriskchange();
		$(".risktypechange3").show();
	}
	if(cb == 3) {

		guanbiriskchange();
		$(".risktypechange4").show();
	}
	if(cb == 4) {

		guanbiriskchange();
		$(".risktypechange5").show();
	}
	if(cb == 5) {

		guanbiriskchange();
		$(".risktypechange6").show();
	}
}

//zhangqt---服务开通js
function highConf(h) {
	//隐藏高危选项，显示高危结果
	$("#high_select" + h).fadeOut(0);
	$("#high_result" + h).fadeIn(1000);
	//获取当前时间
	var myDate = new Date();
	date2 = myDate.getFullYear() + '-' + (myDate.getMonth() + 1) + '-' + myDate.getDate();
	var checkH = $("#high_form" + h + " table tr td input[type='checkbox']");
	//序号
	var j = 1;
	//高危总分
	var high_count = 0;
	//循环将选择好的加入到结果表格中
	for(var i = 0; i < checkH.length; i++) {
		if(checkH.eq(i).is(':checked')) {
			high_count += Number(checkH.eq(i).parent().next().next().html());
			var hhtm = "<tr class='extion' height='20px'><td style='color: black;'>" + j + "</td><td>" + date2 + "</td><td>" + $(".weeks").val() + "</td><td>" +
				checkH.eq(i).parent().next().html() + "</td><td>" +
				checkH.eq(i).parent().next().next().html() + "</td></tr>";
			$(".highdea" + h).append(hhtm);
			j++;
		}
	}
	$(".high_count" + h).html(high_count);
	if(high_count == 0) {
		$(".high_count" + h).css("color", "green");
	} else {
		$(".high_count" + h).css("color", "red");
	}
	//判断高危程度
	if(high_degree(high_count) == "无高危") {
		$(".high_text" + h).css("color", "green");
	} else {
		$(".high_text" + h).css("color", "red");
	}
	$(".high_text" + h).html(high_degree(high_count));
	leftHeight(h);
}

//修改高危填写
function revise(i) {
	//重置高危选择中的checkbox
	document.getElementById('high_form' + i).reset();
	//清空之前的高危结果值
	$(".highdea" + i + " tr").eq(0).nextAll().remove();
	$("#high_select" + i).fadeIn(1000);
	$("#high_result" + i).fadeOut(100);
	setTimeout(function() {
		leftHeight(i);
	}, 200);
}

//查找基本信息
function getInfo(mid) {
	$.ajax({
		type: "post",
		url: address + "gravidainfo/queryHospitalByMid.do",
		data: {
			mid: mid
		},
		async: true,
		success: function(d) {
			if(d.data != null) {
				setInfo(d.data);
			}
		}
	});

	$.ajax({
		type: "post",
		url: address + "contacts/queryByMid.do",
		data: {
			mid: mid
		},
		async: true,
		success: function(d) {
			//常用联系人
			var data = d.data;
			if(data.length != 0) {
				$(".contactsName1").val(data[0].contName);
				$(".contactsName2").val(data[1].contName);
				$(".contactsPhone1").val(data[0].contPhone);
				$(".contactsPhone2").val(data[1].contPhone);
				$("#contactsRelation1 option[value='" + data[0].relationId + "']").attr("selected", "selected");
				$("#contactsRelation2 option[value='" + data[1].relationId + "']").attr("selected", "selected");
			}

		}
	});
}

//将基本信息填写到input中
var weeks = "";

function setInfo(data) {
//	console.log(JSON.stringify(data))
	
	//联系电话
	$.ajax({
		type:"post",
		url: address2 + "user/getUserInfo.do",
		data: {
			userId: data.userID
		},
		async:false,
		success:function(result){
			$('.myPhone2').val(result.data.username);
			$('.myPhone1').val(result.data.username);
		}
	});
	//根据怀孕状态改变初始显示的孕况
	$("#stateInfo2 option[value='" + data.pergnancystatus + "']").attr("selected", "selected");
	changeStateInfo2();
	//姓名
	$(".gname").val(data.gName);
	//出生日期
	$(".birthYears").val(data.birthYears);
	//病历号
	$(".medicalRecordNo").val(data.medicalRecordNo);
	//孕育史
	$(".inoculation_history").val(data.inoculation_history);
	//末次月经
	var myDate1 = new Date(data.endDate);
	date1 = myDate1.getFullYear() + '-' + addPreZero((myDate1.getMonth() + 1)) + '-' + addPreZero(myDate1.getDate());
	$(".enddate").val(date1);
	//孕产妇编号 
	$(".mnnum").val(data.mId);

	//建档医院
	setTimeout(function() {
		$("#hospital option[value='" + data.hospitalId + "']").attr("selected", "selected");
	}, 200);

	//建档日期recordDate
	var myDate2 = new Date(data.recordDate);
	var date2 = myDate2.getFullYear() + '-' + addPreZero((myDate2.getMonth() + 1)) + '-' + addPreZero(myDate2.getDate());
	$(".bdate").val(date2);

	//预产期
	var budget = getBudgetDate(myDate1);
	var myDate3 = new Date(budget);
	var date3 = myDate3.getFullYear() + '-' + addPreZero((myDate3.getMonth() + 1)) + '-' + addPreZero(myDate3.getDate());
	$(".budget2").val(date3);

	//孕周
	var w = getWeeks(myDate1);
	weeks = w.weeks + "周+" + w.day + "天";
	$(".weeks2").val(weeks);
}

//选择末次月经，改变孕周与预产期
function alretDate(that, i) {
	var weeks = getWeeks(new Date($(that).val()));
	$(".weeks" + i).val(weeks.weeks + "周+" + weeks.day + "天");

	var budget = getBudgetDate(new Date($(that).val()));
	var myDate3 = new Date(budget);
	var date4 = myDate3.getFullYear() + '-' + addPreZero((myDate3.getMonth() + 1)) + '-' + addPreZero(myDate3.getDate());
	$(".budget" + i).val(date4);
}
//补0操作,方便为date类型的input赋值
function addPreZero(num) {
	if(num < 10) {
		return '0' + num;
	} else {
		return num;
	}
}
//为关系下拉列表赋值
function relation() {
	$.ajax({
		type: "post",
		url: address + "relation/find.do",
		async: true,
		success: function(d) {
			var data = d.data;
			for(var i = 0; i < data.length; i++) {
				//去掉本人
				if(data[i].relationid != 1) {
					$(".contactsRelation").append("<option value='" + data[i].relationid + "'>" + data[i].relation + "</option>");
				}
			}
		}
	});
}

////查询会员列表
//function queryByVip() {
//	var medicalrecordno = $(".medicalrecordno").val();
//	if(medicalrecordno == "" || medicalrecordno == null) {
//		medicalrecordno = -1;
//	}
//	var vipGradeid = $(".vip_service_list").val();
//	if(vipGradeid == "" || vipGradeid == null) {
//		vipGradeid = -1;
//	}
//	$.ajax({
//		type: "post",
//		url: address + "gravidainfo/queryByVip.do",
//		data: {
//			'vipGradeid': vipGradeid,
//			'medicalrecordno': medicalrecordno
//		},
//		async: true,
//		success: function(d) {
//			ListHandle(d.data);
//		}
//	});
//}
//显示会员列表
//function ListHandle(data) {
//	//表头
//	var tr = "<tr><td>序号</td><td>选择</td><td>病历号</td><td>姓名</td><td>年龄</td>" +
//		"<td>孕周</td><td>套餐等级</td><td>联系电话</td><td>金额</td><td>注册时间</td>" +
//		"<td>到期时间</td><td>剩余天数</td><td colspan='3'>操作</td></tr>";
//	for(var i = 0; i < data.length; i++) {
//		var d = data[i];
//		var weeks;
//		//利用末次月经计算孕周
//		if(d.endDate != null && d.endDate != "" && d.endDate != undefined) {
//			weeks = getWeeks(new Date(d.endDate)).weeks;
//		} else {
//			weeks = "";
//		}
//
//		//利用出生日期算出年龄
//		var age = "";
//		if(d.birthYears != undefined) {
//			var age = getAge(d.birthYears);
//		}
//		tr += "<tr><td>" + (i + 1) + "</td><td><input type='checkbox'/></td><td>" + un(d.medicalRecordNo) + "</td><td>" + un(d.gName) + "</td><td>" + age + "</td><td>" + weeks + "</td><td>" + d.vipgradeName + "</td>" +
//			"<td>" + un(d.phone) + "</td><td>" + un(d.vipPrices) + "</td><td>" + un(longToDate(d.sdate)) + "</td><td>" + longToDate(d.edate) + "</td><td>" + surplusDay(new Date(d.edate)) + "</td>" +
//			"<td><a class='pointer' onclick='selectUser(\"" + d.mId + "\")'>续费</a><a class='pointer' style='margin-left:15px;'  onclick='selectUser(\"" + d.mId + "\")'>变更</a></td></tr>";
//	}
//	$("#user_list").html('').append(tr);
//}

//获取医院下拉列表 
function getHospital() {
	$.ajax({
		type: "post",
		url: address + "hospital/find.do",
		async: true,
		success: function(d) {
			var data = d.data;
			var htm = "";
			for(var i = 0; i < data.length; i++) {
				htm += "<option value='" + data[i].hospitalid + "'>" + data[i].hospitalname + "</option>";
			}
			$(".hospital").append(htm);
		}
	});
}

//获取vip等级列表
var vipData;

function getVipList() {
	$.ajax({
		type: "post",
		url: address + "vipGrade/find.do",
		async: true,
		success: function(d) {
			var data = d.data;
			vipData = data;
			var htm = "";
			var htm2 = "<option value='-1'>请选择</option>";
			for(var i = 0; i < data.length; i++) {
				htm += "<option value='" + data[i].vipgradeid + "'>" + data[i].vipprices + "元</option>";
				htm2 += "<option value='" + data[i].vipgradeid + "'>" + data[i].vipgradename + "</option>";
			}
			$(".vipGrade").append(htm2);
			$(".selectservice_style").append(htm).click();
		}
	});
}

function VipDescDate(that, j) {
	changeVipDescDate(that, j);
	$(that).removeAttr("onclick");
}

//显示vip套餐的内容
function changeVipDescDate(that, j) {
	for(var i = 0; i < vipData.length; i++) {
		if($(that).val() == vipData[i].vipgradeid) {
			var htm = "<tr><th>提供相应的服务：</th></tr><tr><td>" + vipData[i].vipintroduce + "</td></tr>";
			htm = htm.replace(/&a/g, "<br/>");
			htm = htm.replace(/&b/g, "<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			htm = htm.replace(/&c/g, "<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			$("#service" + j).html("").append(htm);
		}
	}
	leftHeight(j);
}

//此方法用于调整左边线条的高度
function leftHeight(i) {
	if(i == 1) {
		$("#left" + i).css("height", ($("#panel-978065").height() - 400) + "px");
	} else if(i == 2) {
		$("#left" + i).css("height", ($("#panel-978066").height() - 400) + "px");
	}
}

//开通服务后提交数据
var info;
var username;

function subForm() {
	var gravidaAddress;
	var stateNumber = $('#selectservice_style1').val();//服务等级
	$(".subBut").attr("disabled","disabled");
	if($("#stateInfo").val() == 1) {//备孕
		if($("#myform1").valid() == false || $("#myform5").valid() == false){
			alert("您的信息未填写完整");
			$(".subBut").removeAttr("disabled");
			return;
		} else {
			info = $("#myform1").serialize();
			gravidaAddress = $('#hukou').val() +"#"+ $('#chengshi').val() +"#"+ $('#detail_address1').val();
			info += "&monthpresidenceaddress=" + gravidaAddress ;
			username = $("#myPhone1").val();
			createregister(username);
			serviceOpening(username,stateNumber);
		}
		
	} else {//怀孕
		if($("#myform2").valid() == false || $("#myform5").valid() == false){
			alert("您的信息未填写完整");
			$(".subBut").removeAttr("disabled");
			return;
		} else {
			info = $("#myform2").serialize();
			gravidaAddress = $('#s_province').val() +"#"+ $('#s_city').val() +"#"+ $('#detail_address2').val();
			info += "&monthpresidenceaddress=" + gravidaAddress ;
			username = $("#myPhone2").val();
			createregister(username);
			serviceOpening(username,stateNumber);
		}
		
	}

}

function subForm2() {
	if($("#stateInfo").val() == 1) {
		info = $("#myform1").serialize();
		username = $("#myPhone1").val();
		valuesCode(username);
	} else {
		info = $("#myform2").serialize();
		username = $("#myPhone2").val();
		valuesCode(username);
	}
}

/*服务变更管理提交*/
var phoneNum;
function subService(){
	var state = $("#stateInfo2").val();//孕况状态
	var stateNumber = $('#selectservice_style2').val();//服务等级
	phoneNum = $('.myPhone1').val();//联系电话
	var msg = {
		"gname": $('.gname').val(),//姓名
		"birthYears": $('.birthYears').val(),//出生日期
		"mid": $('.mnnum').val(),//孕妇编号
		"medicalrecordno": $('.medicalRecordNo').val(),//病历号
	};
	
	if(state == 1) {//备孕
		addInfo2(msg);
		serviceOpening(phoneNum,stateNumber);
	} else {//怀孕
		msg.enddate = $('.enddate').val();//末次月经
		msg.expectedconfinement = $('.budget').val(); //预产期
		addInfo2(msg);
		serviceOpening(phoneNum,stateNumber);
	}
}

//将数据插入到数据库
function addInfo2(msg){
	var userid;
	$.ajax({
		type:"post",
		url: address2 + "user/findUseridByUsername.do",
		data:{
			username: phoneNum
		},
		async:false,
		success:function(result){
			userid = result;
		}
	});
	
	msg.userid = userid;
	msg.vipid = $("#selectservice_style2").val()//服务等级
	msg.phone = phoneNum;//联系电话
	msg.pergnancystatus = $("#stateInfo2").val()//孕况状态
//	console.log(JSON.stringify(msg))
	
	$.ajax({
		type: "post",
		data: msg,
		url: address + "gravidainfo/addOrUpdateInfo.do",
		async: false,
		success: function(i) {
		
		},
		error: function() {
			errorNum++;
		}
	});
	
	//插入家庭成员表
	$.ajax({
		type: "post",
		data: {
			relationid: $(".c_relation").val(),//关系id
			mid: $('.mnnum').val(),
			name: $(".c_orderlies").val(),//姓名
			phone:$(".c_orderliesPhone").val(),//联系电话
			relations:'o'//关系
		},
		url: address + "familyMember/add.do",
		async: false,
		success: function(i) {
//			console.log(i);
		},
		error: function() {
			errorNum++;
		}
	});
}

var code;
function valuesCode(phoneNumber) {
	if(phoneNumber != null) {
		$.ajax({
			type: "get",
			data: {
				"phoneNumber": phoneNumber
			},
			url: address2 + "SMSverification/register.do",
			async: true,
			success: function(e) {
				if(e != null) {
					alert("验证码发送成功！请填写在后方输入框");
					code = e;
				}
			},
			error: function() {}
		});
	}
}
$(function() {
	$("#verificationCode2").blur(function() {
		reg2Next("#verificationCode2", $("#verificationCode2").val());
	});
	$("#verificationCode1").blur(function() {
		reg2Next("#verificationCode1", $("#verificationCode1").val());
	});
});

function reg2Next(id, vercode) {
	//判断得到输入的验证码与系统生成发给手机的验证码是否一致是则下一步，否继续输入
	var sysVerCode = code; //系统验证码（随机数）
	if(vercode == sysVerCode) {
		
	} else {
		alert("验证码错误，请重新输入");
		$(id).val("");
		return;
	}
}

/*开通健康周报管理服务的信息提醒*/
function serviceOpening(username,stateNumber){
	$.ajax({
		type:"post",
		url: address + "SMSverification/opening.do",
		data:{
			phoneNumber: username,
			state: stateNumber
		},
		async: false,
		success: function(result){
//			console.log(result)
			if(result == "0"){
				alert("开通成功");
				window.location.reload();
			}else{
				alert("开通服务短信发送失败,请检查联系电话是否正确或填写完整");
			}
		},
		error:function(e){
			console.log(JSON.stringify(e))
		}
	});

}

function createregister(username) {
	//往usertb表添加或更新一个账号，返回账号的id
	$.ajax({
		type: "post",
		url: address + "user/register.do",
		data: {
			username: username,
			password:'123456'
		},
		async: false,
		success: function(userId) {
			addInfo(userId);
			//添加高危信息
			setHighInfo();
		},
		error: function() {
			errorNum++;
		}
	});
}

//添加基本信息到数据库,同时将开通信息插入到viporder中
function addInfo(userId) {
	var data = info + "&userid=" + userId + "&vipid=" + $("#selectservice_style1").val() + "&phone=" + username + "&pergnancystatus=" + $("#stateInfo").val();
	//基本信息序列化
//	console.log(data)
	$.ajax({
		type: "post",
		data: data,
		url: address + "gravidainfo/addOrUpdateInfo.do",
		async: false,
		success: function(i) {
			
		},
		error: function() {
			errorNum++;
		}
	});
	var mid;
	var phone = $("#myPhone2").val();
	$.ajax({
		type: "post",
		url: address + "gravidainfo/queryByUserPhone.do",
		data: {
			phone: phone
		},
		async: false,
		success: function(d) {
			if(d != null || d != "") {
				mid = d;
			}
		},
		error: function() {
			errorNum++;
		}
	});
	$.ajax({
		type: "post",
		data: {
			relationid: $(".relation").val(),
			mid: mid,
			name: $(".orderlies").val(),
			phone:$(".orderliesPhone").val(),
			relations:'o'
		},
		url: address + "familyMember/add.do",
		async: false,
		success: function(i) {
//			console.log(i);
		},
		error: function() {
			errorNum++;
		}
	});
}

//切换服务开通的孕况状态table
function changeStateInfo() {
	var stateInfo = $("#stateInfo").val();
	if(stateInfo == 2) {
		$('#myform1').hide();
		$('#myform2').show();
	} else if(stateInfo == 1) {
		$('#myform2').hide();
		$('#myform1').show();
	}
	leftHeight(1);
}

//切换服务开通的孕况状态table
function changeStateInfo2() {
	var stateInfo = $("#stateInfo2").val();
	if(stateInfo == 2) {
		$('#myform3').hide();
		$('#myform4').show();
	} else if(stateInfo == 1) {
		$('#myform4').hide();
		$('#myform3').show();
	}
	leftHeight(2);
}

//选择操作的孕妇
function selectUser(mid) {
	$("a[href='#panel-978066']").click();
	getInfo(mid);
}

function getHighList() {
	$.ajax({
		type: "post",
		url: address + "highriskProblem/find.do",
		async: true,
		success: function(d) {
			var data = d.data;
			var html = "";
			if(data.length != 0) {
				for(var i = 0; i < data.length; i++) {
					if(i % 2 == 0) {
						html += "<tr>";
					}
					html += "<td><input type='checkbox' value='" + data[i].highriskproblemid + "'/></td><td>" + data[i].highriskproblem + "</td><td>" + data[i].problemscore + "</td>";
					if(i % 2 != 0) {
						html += "</tr>";
					}
					if(data.length % 2 != 0 && i == (data.length - 1)) {
						html += "<td></td><td></td><td></td>";
					}
				}
				$("#high_form1 table").append(html);
				leftHeight(1);
			}
		},
		error: function() {
			errorNum++;
		}
	});
}

//将高危信息添加到高危表中
function setHighInfo() {
	var id = 1;
	var mid = $(".mid1").val();
	var sunScore = 0;
	var saveDataAry = [];
	$.each($("#high_form1 table tr td input[type='checkbox']"), function() {
		if(this.checked) {
			var score = $(this).parent().next().next().html();
			sunScore += parseInt(score);
		}
	});

	var phone = $("#myPhone2").val();
	$.ajax({
		type: "post",
		url: address + "gravidainfo/queryByUserPhone.do",
		data: {
			phone: phone
		},
		async: false,
		success: function(d) {
			if(d != null || d != "") {
				mid = d;
			}
		},
		error: function() {
			errorNum++;
		}
	});
//	console.log($("#high_form1 table tr td input[type='checkbox']:checked").length);

	if($("#high_form1 table tr td input[type='checkbox']:checked").length != 0) {
		//当前时间
		var myDate = new Date();
		var date2 = myDate.getFullYear() + '-' + (myDate.getMonth() + 1) + '-' + myDate.getDate() + " " + myDate.getHours() + ":" + myDate.getMinutes() + ":" + myDate.getSeconds();
		//保存到高危结果表里面
		$.ajax({
			type: "post",
			url: address + "highrisktestResult/insert.do",
			data: {
				mid: mid,
				resultdate: date2,
				sunscore: sunScore
			},
			async: false,
			success: function(i) {
//				console.log(i)
				id = i;
			},
			error: function() {
				errorNum++;
			}
		});
		$.each($("#high_form1 table tr td input[type='checkbox']"), function() {
			if(this.checked) {
				var score = $(this).parent().next().next().html();
				var data = {
					"highrisktestresultid": id,
					"highriskproblemid": $(this).val(),
					"ifhighrisk": 0,
					"highrisktestscore": score
				};
				saveDataAry.push(data);
			}
		});

		$.ajax({
			type: "post",
			url: address + "highriskTest/insertLoop.do",
			data: JSON.stringify(saveDataAry),
			dataType: "json",
			contentType: "application/json", // 指定这个协议很重要
			async: true,
			success: function(i) {
//				console.log(i)
			},
			error: function() {
				errorNum++;
			}
		});
	}
	if(errorNum==0){
		$(".subBut").removeAttr("disabled");
	}

}

function getColumnParams() {
	var columnParams = [{
		title: 'checkbox',
		width: '4%',
		align: 'center',
		checkbox: true
	}, {
		title: '序号',
		align: 'center',
		sortable: true,
		width: '6%',
		clickToSelect: false, //点击是否选择此行
		formatter: function(value, row, index) {
			return "<span>" + (parseInt(index) + 1) + "</span>";
		}
	}, {
		field: 'medicalRecordNo',
		title: '病历号',
		width: '8%',
		align: 'center',
		clickToSelect: false,
		sortable: true
	}, {
		field: 'gName',
		title: '姓名',
		width: '6%',
		align: 'center',
		clickToSelect: false,
		sortable: true
	}, {
		field: 'birthYears',
		title: '年龄',
		align: 'center',
		width: '6%',
		clickToSelect: false,
		sortable: true,
		formatter: function(value) {
			return getAge(longToDate(value));
		}
	}, {
		field: 'endDate',
		title: '孕周',
		width: '6%',
		align: 'center',
		clickToSelect: false,
		sortable: true,
		formatter: function(value) {
			return getWeeks(value).weeks;
		}
	}, {
		title: '健康套餐',
		align: 'center',
		width: '8%',
		clickToSelect: false,
		sortable: true,
		formatter: function(value, row, index) {
			return "<span>" + row.vipgradeName + "</span>";
		}
	}, {
		title: '联系电话',
		sortable: true,
		align: 'center',
		clickToSelect: false,
		formatter: function(value, row, index) {
			return row.phone;
		}
	}, {
		title: '金额',
		sortable: true,
		align: 'center',
		width: '6%',
		clickToSelect: false,
		formatter: function(value, row, index) {
			return row.vipPrices;
		}
	}, {
		title: '注册时间',
		sortable: true,
		align: 'center',
		clickToSelect: false,
		formatter: function(value, row, index) {
			return longToDate(row.sdate);
		}
	},{
		title: '到期时间',
		sortable: true,
		align: 'center',
		clickToSelect: false,
		formatter: function(value, row, index) {
			return longToDate(row.edate);
		}
	},{
		title: '剩余天数',
		sortable: true,
		align: 'center',
		width: '9%',
		clickToSelect: false,
		formatter: function(value, row, index) {
			return surplusDay(new Date(row.edate));
		}
	},{
		title: '操作',
		align: 'center',
		clickToSelect: false,
		formatter: function(value, row, index) {
			//return row.mId;
			return "<a class='pointer' style='cursor:pointer' onclick='selectUser(\"" + row.mId + "\")'>续费</a><a class='pointer' style='cursor:pointer;margin-left:15px;'  onclick='selectUser(\"" + row.mId + "\")'>变更</a>"
		}
	}]
	return columnParams;
}