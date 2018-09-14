var SUCCESS = 0;
var ERROR = 1;

var mid = sessionStorage.getItem("mid");
//var mid = "dg000001";
//var hospitalid = "0769fy001";
//hospitalid = localStorage.getItem("hospitalid");
//var address = "http://192.168.1.60:8080/doctormanager/";
var address = sessionStorage.getItem("address");

/*存储发送推送 对象的mid   yinzx 2017/9/21 **/
$("#send_mid").val(mid);

function getDateString(mydate) {
	if(mydate == null || mydate == "") {
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

//根據末次月經計算出預產期
function getexpectedConfinement(enddate) {
	var returnexpected;
	var expected = new Date(enddate).getTime() + 280 * 24 * 60 * 60 * 1000;
	returnexpected = getDateString(expected);
	return returnexpected;
}

//根據末次月經計算出孕周
function getweeks(enddate) {
	var returnweeks;
	//var getweeks = 40-(Math.round((new Date(expected).getTime()-(new Date().getTime()))/1000/60/60/24/7));
	var today = new Date().getTime();
	var end = new Date(enddate).getTime();
	returnweeks = Math.round((today - end) / 1000 / 60 / 60 / 24 / 7);
	return returnweeks;
}

/*根据出生日期算出年龄*/
function jsGetAge(strBirthday) {
	var returnAge;
	var strBirthdayArr = strBirthday.split("-");
	var birthYear = strBirthdayArr[0];
	var birthMonth = strBirthdayArr[1];
	var birthDay = strBirthdayArr[2];

	d = new Date();
	var nowYear = d.getFullYear();
	var nowMonth = d.getMonth() + 1;
	var nowDay = d.getDate();

	if(nowYear == birthYear) {
		returnAge = 0; //同年 则为0岁  
	} else {
		var ageDiff = nowYear - birthYear; //年之差  
		if(ageDiff > 0) {
			if(nowMonth == birthMonth) {
				var dayDiff = nowDay - birthDay; //日之差  
				if(dayDiff < 0) {
					returnAge = ageDiff - 1;
				} else {
					returnAge = ageDiff;
				}
			} else {
				var monthDiff = nowMonth - birthMonth; //月之差  
				if(monthDiff < 0) {
					returnAge = ageDiff - 1;
				} else {
					returnAge = ageDiff;
				}
			}
		} else {
			returnAge = -1; //返回-1 表示出生日期输入错误 晚于今天  
		}
	}

	return returnAge; //返回周岁年龄  

}

$(function() {
	//console.log("走了");
	//网页加载即显示孕妇信息
	showMessage2();
	//丈夫信息
	showHusband2();
	//成员孕妇信息
	showGravida2();
	//医院名字
	showHospitalname2();
	//网页加载即显示紧急联系人相关信息
	showjinji2();
})

function showHospitalname2() {
	var url = address + "hospital/selectbykey.do";
	var hospitalid = sessionStorage.getItem('hospitalid');
	$.ajax({
		type: "post",
		url: url,
		dataType: "json",
		async: true,
		data: {
			hospitalid: hospitalid
		},
		success: function(result) {
			if(result != null) {
				var hospital = result.data;
				if(hospital != null) {
					$('.g_hospital').html(hospital.hospitalname); //医院名称
				}
			}
		}
	});
}

function showMessage2() {
	//alert("走了啦啦啦");
	$.ajax({
		type: "post",
		url: address + "gravidainfo/find.do",
		dataType: "json",
		async: true,
		data: {
			mid: mid
		},
		success: function(result) {
			if(result.state == 0) {
				var gravida = result.data;
				getMessage2(gravida);
			}
		}
	});
}
//孕妇信息
function getMessage2(gravida) {
	$('.g_name').html(gravida.gname);
	if(gravida.birthYears != null && gravida.birthYears != "") {
		$('.g_age').html(jsGetAge(getDateString(gravida.birthYears)) + '岁');
		$('.g_date').html(getDateString(gravida.birthYears));
	} else {
		$('.g_date').html("暂无数据");
	}
	
	if(gravida.postalcode == null || gravida.postalcode == ''){
		$('.g_postalcode').html('暂无数据');
	}else{
		$('.g_postalcode').html(gravida.postalcode);
	}
	
	
	
	try {
		var monthpresidenceaddress = (gravida.monthpresidenceaddress).replace('#', '');
		$('.g_monthPResidenceAddress').html(monthpresidenceaddress.replace('#', ''));
		var monthpresentaddress = (gravida.monthpresentaddress).replace('#', '');
		$('.g_monthPresentAddress').html(monthpresentaddress.replace('#', ''));
		var attribution = (gravida.monthpresidenceaddress).replace('#', '');
		$('.g_attribution').html(attribution.replace('#', ''));
	} catch(e) {}
	//alert($('.g_attribution').html());

	if(gravida.distance == null) {
		$('.g_distance').html('无');
	} else {
		$('.g_distance').html(gravida.distance);
	}

	if(gravida.marry_age == null) {
		$('.g_marryage').html('无记录');
	} else {
		$('.g_marryage').html(gravida.marry_age + '年');
	}
	if(gravida.family_gdp == null) {
		$('.g_family_gdp').html('无相关记录');
	} else {
		$('.g_family_gdp').html(gravida.family_gdp + '元');
	}

	var recorddate = gravida.recorddate;
	if(recorddate == null || recorddate == '' || recorddate == NaN) {
		recorddate = '';
		$('.g_recordDate').html('暂无数据');
	} else {
		$('.g_recordDate').html(getDateString(recorddate));
	}

	var poor = gravida.poor;
	if(poor == 0) {
		poor = '否';
	} else if(poor == 1) {
		poor = '是';
	} else {
		poor = '无记录';
	}
	$('.g_poor').html(poor);
	var medicalcardtype = gravida.medicalcardtype;
	if(medicalcardtype == 0) {
		medicalcardtype = '孕保卡';
	} else if(medicalcardtype == 1) {
		medicalcardtype = '社保卡';
	} else {
		medicalcardtype = '其他';
	}
	$('.g_cardtype').html(medicalcardtype);

	if(gravida.wedlock == null) {
		$('.g_wedlock').html('无记录');
	} else {
		$('.g_wedlock').html(gravida.wedlock);
	}
	if(gravida.recordno == null){
		$('.g_recordno').html('暂无数据');
	} else {
		$('.g_recordno').html(gravida.recordno);
	}
	
	var registerType = gravida.registertype;
	if(registerType == 0) {
		registerType = '本地户口';
	} else if(registerType == 1) {
		registerType = '外地户口';
	} else {
		registerType = '其他';
	}
	$('.g_registerType').html(registerType);
	var town = gravida.town;
	if(town == 0) {
		town = '城市';
	} else if(town == 1) {
		town = '村镇';
	} else {
		town = '其他';
	}
	$('.g_town').html(town);

	var household_register = gravida.household_register;
	if(household_register == 0) {
		household_register = '城市';
	} else if(household_register == 1) {
		household_register = '村镇';
	} else {
		household_register = '其他';
	}
	$('.g_household_register').html(household_register);

	$('.g_domicile').html(gravida.domicile);

	var home = gravida.husband_condition;
	if(home == 0) {
		home = "否";
	} else if(home == 1) {
		home = "是";
	} else {
		home = '无相关信息';
	}
	$('.h_home').html(home); //丈夫是否长期不在家

	$('.g_hospitalId').html(gravida.hospitalid); //门诊号
	$('.g_endDate').html(getDateString(gravida.enddate)); //末次月经
	$('.g_gravidaId').html(gravida.mid); //孕产妇编号
	var expectedconfinement = getexpectedConfinement(gravida.enddate);
	if(expectedconfinement == null && expectedconfinement == '') {
		expectedconfinement = '暂无数据';
	}
	$('.g_expectedConfinement').html(expectedconfinement); //预产期

	var getweek = getweeks(gravida.enddate);
	$('.g_recordweek').html(getweek + '周'); //孕周--根据末次月經计算

	var doctor = gravida.doctor;
	if(doctor == 0) {
		doctor = '肖晋英';
	} else if(doctor == 1) {
		doctor = '杜秀萍';
	} else if(doctor == 2) {
		doctor = '王玲';
	} else if(doctor == 3) {
		doctor = '苗丽萍';
	} else if(doctor == 4) {
		doctor = '吴丽萍';
	} else {
		doctor = '其他';
	}
	$('.g_doctor').html(doctor); //建档医生
	if(gravida.inoculation_history == null) {
		$('.g_history').html('无记录');
	} else {
		$('.g_history').html('怀孕' + gravida.inoculation_history + '次');
	}

	if(gravida.medical_insurance == null) {
		$('.g_medical_insurance').html('无');
	} else {
		$('.g_medical_insurance').html(gravida.medical_insurance); //医保号
	}

	if(gravida.agricultural == null) {
		$('.g_agricultural').html('无');
	} else {
		$('.g_agricultural').html(gravida.agricultural); //农合号
	}

	sessionStorage.setItem('hospitalid', gravida.hospitalid);
}

//丈夫信息
function showHusband2() {
	var url = address + "familyMember/findHusbandByMid.do";
	$.ajax({
		type: "post",
		url: url,
		dataType: "json",
		async: true,
		data: {
			mid: mid
		},
		success: function(result) {
			if(result.state == 0) {
				var husband = result.data;
				if(husband != null) {
					getHusband2(husband);
				}

			}
		}
	});
}

function getHusband2(husband) {
	//console.log(husband.name);
	$('.h_name').html(husband.name); //姓名
	/*$('.g_relation').html(husband.name); //紧急联系人*/
	/*$('.g_relations').html(husband.relations); //关系*/
	/*$('.relation_tel').html(husband.phone); //丈夫电话*/
	
	$('.h_nation').html(husband.nation); //丈夫民族
	var bloodtype = husband.bloodtype;
	//alert(bloodtype == 3);
	if(bloodtype == 0) {
		bloodtype = "A型";
	} else if(bloodtype == 1) {
		bloodtype = "B型";
	} else if(bloodtype == 2) {
		bloodtype = "O型";
	} else if(bloodtype == 3) {
		bloodtype = "AB型";
	} else {
		bloodtype = '无';
	}
	var rh = husband.rh;
	if(rh == 0) {
		rh = '阴性';
	} else if(rh == 1) {
		rh = '阳性';
	} else {
		rh = '无';
	}
	$('.h_blood').html(bloodtype + '/' + rh); //丈夫血型
	
	var h_other = husband.other;//丈夫其他
	if(h_other == '' || h_other == null){
		$('.h_other').html('暂无数据')
	}else{
		$('.h_other').html(h_other);
	}

	if(husband.birthYears != null && husband.birthYears != "") {
		$('.h_date').html(getDateString(husband.birthYears)); //丈夫出生日期
		$('.h_age').html(jsGetAge(getDateString(husband.birthYears)) + '岁'); //丈夫年龄
	} else {
		$('.h_date').html("暂无数据");
	}

	$('.h_profession').html(husband.profession); //丈夫职业

	$('.h_work').html(husband.work); //丈夫工种
	$('.h_nationality').html(husband.nationality); //丈夫国籍
	$('.h_education').html(husband.education); //丈夫文化程度

}

//成员孕妇信息
function showGravida2() {
	var url = address + "familyMember/findGravidaByMid.do";
	$.ajax({
		type: "post",
		url: url,
		dataType: "json",
		async: true,
		data: {
			mid: mid
		},
		success: function(result) {
			if(result.state == 0) {
				var gravida = result.data;
				if(gravida != null) {
					getGravida2(gravida);
				}
			}
		}
	});
}

function getGravida2(gravida) {
	//console.log(gravida.profession);
	
	if(gravida.work == '' || gravida.work == null){
		$('.g_work').html('暂无数据')
	}else{
		$('.g_work').html(gravida.work);
	}
	
	if(gravida.other == '' || gravida.other == null){
		$('.g_other').html('暂无数据');
	}else{
		$('.g_other').html(gravida.other);
	}
	
	
	$('.g_phone').html(gravida.phone);
	$('.g_profession').html(gravida.profession);
	$('.g_nation').html(gravida.nation);
	$('.g_education').html(gravida.education);
	var bloodtype = gravida.bloodtype;
	//alert(bloodtype == 3);
	if(bloodtype == 0) {
		bloodtype = "A型";
	} else if(bloodtype == 1) {
		bloodtype = "B型";
	} else if(bloodtype == 2) {
		bloodtype = "O型";
	} else if(bloodtype == 3) {
		bloodtype = "AB型";
	} else {
		bloodtype = '无';
	}
	var rh = gravida.rh;
	if(rh == 0) {
		rh = '阴性';
	} else if(rh == 1) {
		rh = '阳性';
	} else {
		rh = '无';
	}
	$('.g_blood').html(bloodtype + '/' + rh);
	$('.g_tel').html(gravida.phone);
	$('.g_idcard').html(gravida.identitycard);
	$('.g_nationality').html(gravida.nationality);
	var idcardtype = gravida.idcard_type;
	if(idcardtype == 0) {
		idcardtype = '居民身份证';
	} else if(idcardtype == 1) {
		idcardtype = '士兵证';
	} else if(idcardtype == 2) {
		idcardtype = '军官证';
	} else if(idcardtype == 3) {
		idcardtype = '警官证';
	} else if(idcardtype == 4) {
		idcardtype = '护照';
	} else if(idcardtype == 5) {
		idcardtype = '其他';
	}
	$('.g_idcard_type').html(idcardtype);

}
//网页加载即显示紧急联系人信息
//hongwx 2017-10-20 增加紧急联系人读取方法
function showjinji2() {
	var url = address + "familyMember/findAllByMid.do";
	$.ajax({
		type: "post",
		url: url,
		dataType: "json",
		async: true,
		data: {
			mid: mid
		},
		success: function(result) {
			if(result.data != null && result.data != '') {
				var data = result.data;
				if(data.length == 2) {
					$('.g_relation').html(data[1].name);
					$('.relation_tel').html(data[1].phone);
					var relationid = data[1].relationid;
					$('.g_relations').html(data[1].relation.relation);
				} 
				if(data.length == 3){
					$('.g_relation').html(data[2].name);
					$('.relation_tel').html(data[2].phone);
					$('.g_relations').html(data[2].relations);
				}


			}
		},
		error:function(e){
			console.log(JSON.stringify(e))
		}
	});
}