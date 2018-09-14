var address = sessionStorage.getItem("address");
//var address = "http://120.76.194.76/gravidamanager/";
var UtilAddress = address.replace('doctormanager','gravidamanager');
//var UtilAddress = "http://192.168.1.38:8080/gravidamanager/";
var hospitalid;//医院id
var mid;
$(function() {
	//为mid赋值
	mid = getMid();
	
	$("#form1").validate();
	$("#form2").validate();
	$("#form3").validate();
	$('.send_btn').click(function() {
//		if($("#form3").valid() == false){
//			alert("您的信息未填写完整~");
//			return;
//		}
		addUsertb();
	});
});

//随机生成mid
function getMid() {
	var mid = "dg";
	for(var i = 0; i < 6; i++) {
		mid += Math.floor(Math.random() * 10);
	}
	return mid;
}

//提交孕妇gravidainfo表的基础信息

//信息提交
function infoSubmit(userid) {
	/*
	 * 个人信息
	 */
//	var g_recordno = $('.g_recordno').val(); //卡号
//	var g_cardtype = $('.g_cardtype').val(); //卡类型
//	var g_recorddate = $('.g_recorddate').val(); //发卡日期
//	var g_hospital1 = $('.g_hospital1').val(); //发卡单位
	var g_name = $('.g_name').val(); //母亲姓名
	var g_date = $('.g_date').val(); //出生日期
	var g_age = $('.g_age').val(); //年龄
	var g_nationality = $('.g_nationality').val(); //国籍
	var g_nation = $('.g_nation').val(); //民族
	//联系电话
	var g_tel = $('.g_tel').val();
	if(g_tel == null || g_tel === '') {
		alert('请输入母亲电话号码');
		return;
	} else {
		var rule = /^(1[3584]\d{9})$/;
		if(rule.test(g_tel) === false) {
			alert('请输入正确的手机号码');
			return;
		} else {
			g_tel = $('.g_tel').val();
		}
	}

	var g_relation = $('.g_relation').val(); //紧急联系人
	//紧急联系人电话
	var relation_tel = $('.relation_tel').val();
	if(relation_tel == null || relation_tel === '') {
		alert('请输入紧急联系人电话');
		return;
	} else {
		var rule = /^(1[3584]\d{9})$/;
		if(rule.test(relation_tel) === false) {
			alert('请输入正确的手机号码');
			return;
		} else {
			relation_tel = $('.relation_tel').val();
		}
	}

	var g_relations = $('.g_relations').val(); //关系
	var g_education = $('.g_education').val(); //文化程度
	//血型
	var g_blood = $('.g_blood').val();
	var g_blood_rh = $('.g_blood_rh').val();

//	var g_work = $('.g_work').val(); //工种
	var g_wedlock = $('.g_wedlock').val(); //婚姻状况
	var g_marryage = $('.g_marryage').val(); //婚龄
	var g_profession = $('.g_profession').val(); //职业
	var g_idcard_type = $('.g_idcard_type').val(); //身份证类型
	//身份证号码
	var g_idcard = $('.g_idcard').val();
	if(g_idcard == null || g_idcard === '') {
		g_idcard = '';
	} else {
		//var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/; 
		var reg = /^([1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3})|([1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}[0-9Xx])$/
		if(reg.test(g_idcard)) {
			g_idcard = $('.g_idcard').val();
		} else {
			alert('请输入正确的证件号码');
			return;
		}
	}

//	var g_medical_insurance = $('.g_medical_insurance').val(); //医保卡
//	var g_agricultural = $('.g_agricultural').val(); //农合号
//	var g_postalcode = $('.g_postalcode').val(); //邮政编码
	var g_distance = $('.g_distance').val(); //就医路程
	var g_poor = $('.g_poor').val(); //贫困孕妇
	var g_family_gdp = $('.g_family_gdp').val(); //家庭人均年收入
	//户口属地
//	var g_attribution = $('#s_province').val() + "#" + $('#s_city').val() + "#" + $('.g_attribution').val();
	//户口所在地
	var g_monthPResidenceAddress = $('#hukou').val() + "#" + $('#chengshi').val() + "#" + $('.g_monthPResidenceAddress').val();
	//现住址
	var g_monthPresentAddress = $('#province').val() + "#" + $('#city').val() + "#" + $('.g_monthPresentAddress').val();
	var g_registerType = $('.g_registerType').val(); //户口类型
	var g_household_register = $('.g_household_register').val();//户籍类型
//	var g_town = $('.g_town').val(); //城乡分类
//	var g_domicile = $('.g_domicile').val(); //居住地分类
//	var g_other = $('.g_other').val(); //其他说明
	/*
	 * 丈夫信息
	 */
	var h_name = $('.h_name').val(); //父亲姓名
	var h_date = $('.h_date').val(); //出生日期
	var h_age = $('.h_age').val(); //年龄
	var h_nationality = $('.h_nationality').val(); //国籍
	var h_nation = $('.h_nation').val(); //民族
	var h_profession = $('.h_profession').val(); //职业
	var h_work = $('.h_work').val(); //工种
	var h_education = $('.h_education').val(); //文化程度
	//血型
	var h_blood = $('.h_blood').val();
	var h_blood_rh = $('.h_blood_rh').val();

	var h_home = $('.h_home').val(); //长期不在家
	var h_other = $('.h_other').val(); //其他说明
	/*
	 * 围产期信息
	 */
//	var g_hospitalId = $('.g_hospitalId').val(); //门诊号
//	var g_gravidaId = $('.g_gravidaId').val(); //孕妇编号
//	var g_history = $('.g_history').val(); //孕育史
	var g_endDate = $('.g_endDate').val(); //末次月经
	var g_expectedConfinement = $('.g_expectedConfinement').val(); //预产期
	
	var date = new Date();
	var today = date.getDate();
	if(today < 10){
		today = "0" + today;
	}
	var g_recordDate = date.getFullYear() + "-" + (date.getMonth()+1) + "-" + today; //建档日期
	
	var g_recordweek = $('.g_recordweek').val(); //建档孕周
//	var g_doctor = $('.g_doctor').val(); //建档医生
//	if(g_doctor == '请选择'){
//		g_doctor = '';
//	}
//	var g_hospital = $('.g_hospital').val(); //建档医院
	/*
	 * 体格检查
	 */
	var g_height = $('.g_height').val(); //身高
	var g_weight = $('.g_weight').val(); //体重
	var bmi = $('.bmi').val(); //bmi
	var g_blood_pressure = $('.g_blood_pressure').val(); //血压
	var g_heart = $('.g_heart').val(); //心脏
	var g_lung = $('.g_lung').val(); //肺部
	var g_vulua = $('.g_vulua').val(); //外阴
	var g_uterine_neck = $('.g_uterine_neck').val(); //宫颈
	var g_uterine = $('.g_uterine').val(); //子宫
	var g_vagina = $('.g_vagina').val(); //阴道
	/*
	 * 病史
	 */
	var g_medical_history = $('.g_medical_history').val(); //孕妇既往史
//	var h_medical_history = $('.h_medical_history').val(); //男方既往史
	var g_family_history = $('.g_family_history').val(); //女方家族史
	var husband_family_history = $('.husband_family_history').val(); //男方家族史
//	var g_person_history = $('.g_person_history').val(); //女方个人史
//	var husband_person_history = $('.husband_person_history').val(); //男方个人史
//	var g_give_birth = $('.g_give_birth').val(); //孕产史
	var description = $('.description').val(); //主诉

	
	//根据医院名查医院id
//	if(g_hospital != null && g_hospital != '') {
//		$.ajax({
//			type: "post",
//			url: UtilAddress + "hospital/findByHname.do",
//			dataType: "json",
//			async: false,
//			data: {
//				hospitalname: g_hospital
//			},
//			success: function(result) {
//				if(result.data != null) {
//					var id = result.data.hospitalid;
//					//console.log(id)
//					hospitalid = id;
//				}
//			}
//		});
//	}else{
//		hospitalid='';
//	}
//	console.log(mid)	
	var g_parturition_history = $('.g_pregnancy').val() +"#" + $('.g_parturition').val();//孕产史
//	console.log("mid"+mid+"&userid"+userid+"&g_height"+g_height+"&gname"+g_name+"&monthpresidenceaddress"+g_monthPResidenceAddress+"&monthpresentaddress"+g_monthPresentAddress+"&expectedconfinement"+g_expectedConfinement+"&recorddate"+g_recordDate+"&registertype"+g_registerType+"&g_endDate"+g_endDate+"&g_parturition_history"+g_parturition_history+"&g_date"+g_date+"&g_distance"+g_distance+"&h_home"+h_home+"&g_poor"+g_poor+"&g_family_gdp"+g_family_gdp+"&g_household_register"+g_household_register+"&g_wedlock"+g_wedlock+"&g_marryage"+g_marryage);
	$.ajax({
		type: "post",
		url: UtilAddress + "gravidainfo/insertSelective.do",
		data: {
			"mid": mid, //孕妇编号
			"userid": userid, //用户编号
//			"bhospitalid": hospitalid, //建档医院
			"ghigh": g_height, //母亲身高
			"gname": g_name, //孕妇姓名
			"monthpresidenceaddress": g_monthPResidenceAddress, //母亲户籍地址
			"monthpresentaddress": g_monthPresentAddress, //母亲现住地址
			"expectedconfinement": g_expectedConfinement, //预产期
			"recorddate": g_recordDate, //建档日期
			"registertype": g_registerType, //户口类型(0:本地 1:外地)
			"doctor": 0, //核实医生
			"enddate": g_endDate, //末次月经期
//			"medicalrecordno": g_hospitalId, //病历号
			"pregnancybirth": g_parturition_history, //孕产史
			"birthYears": g_date, //出生年月
			"distance": g_distance, //就医路程
			"husband_condition": h_home, //是否常年不在家（0：否；1：是）
			"poor": g_poor, //是否贫困（0：否；1：是）
			"family_gdp": g_family_gdp, //家庭人均年收入
//			"postalcode": g_postalcode, //邮政编码
			"household_register": g_household_register, //户籍类型（0：城市；1：村镇）
//			"domicile": g_domicile, //居住地分类
			"wedlock": g_wedlock, //婚姻状况
			"marry_age": g_marryage, //婚龄
//			"inoculation_history": g_history, //孕育史
//			"medical_insurance": g_medical_insurance, //医保号
//			"agricultural": g_agricultural, //农合号
		},
		async: false,
		success: function(result) {
			if(result >= 0) {
				addFamily(userid);
				addFamilyHusband();
				addMedicalHistory1();
				addMedicalHistory2();
				addFirstCheck();
			} else {
				alert("保存失败");
				return;
			}
		},
		error:function(e){
			console.log(JSON.stringify(e))
			return;
		}
	});
}

//点击往成员表插入孕妇信息
function addFamily(userid) {
	//console.log(11)
	var url = UtilAddress + "familyMember/insertSelective.do";
	var relationid = 1;
	var birthYears = $('.g_date').val();
	var age = $('.g_age').val();
	var nation = $('.g_nation').val();
	var nationality = $('.g_nationality').val();
	var phone = $('.g_tel').val();
	var name = $('.g_name').val();
	var education = $('.g_education').val();

	var profession = $('.g_profession').val();
	var work = $('.g_work').val();
	var idcard_type = $('.g_idcard_type').val();
	var identitycard = $('.g_idcard').val();
	var bloodtype = $('.g_blood').val();
	if(bloodtype == '请选择') {
		bloodtype = null;
	}
	var rh = $('.g_blood_rh').val();
	if(rh == '请选择') {
		rh = null;
	}
	//第三页面
//	var other = $('.g_other').val(); //孕妇的其他说明 
	
	$.ajax({
		type: "post",
		url: url,
		data: {
			mid: mid,
			userid: userid,
			relationid: relationid,
			age: age,
			name: name,//孕妇名字
			birthYears: birthYears,//出生日期
			nation: nation,//民族
			nationality: nationality,//国籍
			phone: phone,//联系电话
			education: education,//文化水平
			profession: profession,//职业
//			work: work,
			idcard_type: idcard_type,//身份证类型
			identitycard: identitycard,//身份证号码
			bloodtype: bloodtype,
			rh: rh,
//			other: other
		},
		async:false,
		success: function(result) {
			console.log('成员表插入孕妇信息成功')
			if(result.state == 0) {
				var gravidaFamily = result.data;

			}
		},
		error: function(e) {
			console.log("成员表插入孕妇信息失败");
			console.log(JSON.stringify(e));
			return;
		}
	});

}

//往成员表插入丈夫信息
function addFamilyHusband() {
	//console.log(22)
	var url = UtilAddress + "familyMember/insertSelective.do";
	var relationid = 2;
	var birthYears = $('.h_date').val();
	var age = $('.h_age').val();
	var nation = $('.h_nation').val();
	var nationality = $('.h_nationality').val();
	var name = $('.h_name').val();
	var education = $('.h_education').val();
	var profession = $('.h_profession').val();
	var work = $('.h_work').val();
	var bloodtype = $('.h_blood').val();
	if(bloodtype == "请选择") {
		bloodtype = null;
	}
	var rh = $('.h_blood_rh').val();
	if(rh == "请选择") {
		rh = null;
	}
	var other = $('.h_other').val(); //丈夫的其他说明 
	//console.log(g_gravidaId+" & "+relationid+" & "+age+ " & "+nation+" & "+birthYears+" & "+nationality+" & "+name+" & "+education+" & "+profession+" & "+work+" & "+bloodtype+" & "+rh+" & "+other);
	$.ajax({
		type: "post",
		url: url,
		data: {
			mid: mid,
			relationid: relationid,
			age: age,
			nation: nation,
			birthYears: birthYears,
			nationality: nationality,
			name: name,
			education: education,
			profession: profession,
			work: work,
			bloodtype: bloodtype,
			rh: rh,
			other: other
		},
		async:false,
		success: function(result) {
			console.log('成员表插入丈夫信息成功')
			if(result >= 0) {
				var HusbandFamily = result.data;
				addrelation();
			}
		},
		error: function(e) {
			console.log("成员表插入丈夫信息失败");
			console.log(JSON.stringify(e));
			return;
		}
	});
}
//往成员表插入紧急联系人信息
function addrelation() {
	var relations = $('.g_relations').val(); //紧急联系人关系
	var relationid = 2;
	var relation = '';
	if(relations == '本人') {
		relationid = 1;
	} else if(relations == '夫妻') {
		relationid = 2;
		relation = '夫妻';
	} else if(relations == '亲属') {
		relationid = 3;
		relation = '亲属';
	} else if(relations == '看护人') {
		relationid = 4;
		relation = '看护人';
	} else {
		relationid = 5;
		relation = '其他';
	}
	//console.log(relation)
	var jinjiperson = $('.g_relation').val();
	var jinjitel = $('.relation_tel').val();
	$.ajax({
		type: "post",
		url: UtilAddress + "familyMember/updateOrAdd.do",
		dataType: "json",
		async: false,
		data: {
			"mid": mid,
			"relationid": relationid,//关系id
			"name": jinjiperson,//紧急联系人姓名
			"phone": jinjitel,//电话
			"relations": relation//关系
		},
		success: function(result) {
			console.log('成员表插入紧急联系人信息成功');
			if(result >= 0) {
				var family = result.data;
			} else {
				alert("保存失败");
				return;
			}
		},
		error:function(e){
			console.log('成员表插入紧急联系人信息失败');
			console.log(JSON.stringify(e));
			return;
		}
	});
}

//孕妇现病史和既往病史
function addMedicalHistory1(){
	var g_medical_history = $('.g_medical_history').val();
	var g_medical = $('.g_medical').val();
	//孕妇既往病史
	if(g_medical_history == 2){
		var info = "mid=" + mid +"&type=" + 0;
		var g_medical_history1 = $('.g_medical_history1').val().trim().split(" ,");
//		console.log(g_medical_history1)
		for(i=0;i<=g_medical_history1.length;i++){
			if(g_medical_history1[i]=='心脏病'){
				info += "&heartdisease=" + 1;
			}
			if(g_medical_history1[i]=='肺结核'){
				info += "&tb=" + 1;
			}
			if(g_medical_history1[i]=='泌尿生殖系统疾病'){
				info += "&urogenitaldiseases=" + 1;
			}
			if(g_medical_history1[i]=='糖尿病'){
				info += "&diabetes=" + 1;
			}
			if(g_medical_history1[i]=='高血压'){
				info += "&hypertension=" + 1;
			}
			if(g_medical_history1[i]=='精神病'){
				info += "&psychosis=" + 1;
			}
			if(g_medical_history1[i]=='性病'){
				info += "&umpire=" + 1;
			}
			if(g_medical_history1[i]=='癫痫'){
				info += "&epilepsy=" + 1;
			}
			if(g_medical_history1[i]=='五官疾病(眼)'){
				info += "&heenteyes=" + 1;
			}
			if(g_medical_history1[i] =='五官疾病(耳)'){
				info += "&heentear=" + 1;
			}
			if(g_medical_history1[i] =='五官疾病(鼻)'){
				info += "&heentnose=" + 1;
			}
			if(g_medical_history1[i] =='五官疾病(喉)'){
				info += "&heentthroat=" + 1;
			}
			if(g_medical_history1[i] =='五官疾病(口腔)'){
				info += "&heentmouth=" + 1;
			}
			if(g_medical_history1[i] =='甲状腺疾病'){
				info += "&thyroiddisease=" + 1;
			}
			if(g_medical_history1[i] =='先天或遗传性疾病'){
				info += "&hereditarydisease=" + 1;
				info += "&other=" + $('.g_medical_history2').val();
			}
		}
//		console.log(info)
		$.ajax({
			type:"post",
			url: UtilAddress + "medicalHistory/insertSelective.do",
			data: info,
			async:false,
			success:function(result){
				if(result > 0){
					console.log('孕妇既往病史插入成功')
				}
			},
			error:function(e){
				console.log('孕妇既往病史插入失败')
				console.log(JSON.stringify(e));
				return;
			}
		});
	}
	//孕妇现病史
	if(g_medical == 2){
		var info = "mid=" + mid +"&type=" + 1;
		var g_medical1 = $('.g_medical1').val().trim().split(" ,");
//		console.log(g_medical1)
		for(i=0;i<=g_medical1.length;i++){
			if(g_medical1[i] =='心脏病'){
				info += "&heartdisease=" + 1;
			}
			if(g_medical1[i] =='肺结核'){
				info += "&tb=" + 1;
			}
			if(g_medical1[i] =='泌尿生殖系统疾病'){
				info += "&urogenitaldiseases=" + 1;
			}
			if(g_medical1[i] =='糖尿病'){
				info += "&diabetes=" + 1;
			}
			if(g_medical1[i] =='高血压'){
				info += "&hypertension=" + 1;
			}
			if(g_medical1[i] =='精神病'){
				info += "&psychosis=" + 1;
			}
			if(g_medical1[i] =='性病'){
				info += "&umpire=" + 1;
			}
			if(g_medical1[i] =='癫痫'){
				info += "&epilepsy=" + 1;
			}
			if(g_medical1[i] =='五官疾病(眼)'){
				info += "&heenteyes=" + 1;
			}
			if(g_medical1[i] =='五官疾病(耳)'){
				info += "&heentear=" + 1;
			}
			if(g_medical1[i] =='五官疾病(鼻)'){
				info += "&heentnose=" + 1;
			}
			if(g_medical1[i] =='五官疾病(喉)'){
				info += "&heentthroat=" + 1;
			}
			if(g_medical1[i] =='五官疾病(口腔)'){
				info += "&heentmouth=" + 1;
			}
			if(g_medical1[i] =='甲状腺疾病'){
				info += "&thyroiddisease=" + 1;
			}
			if(g_medical1[i] =='先天或遗传性疾病'){
				info += "&hereditarydisease=" + 1;
				info += "&other=" + $('.g_medical2').val();
			}
		}
//		console.log(info)
		$.ajax({
			type:"post",
			url: UtilAddress + "medicalHistory/insertSelective.do",
			data: info,
			async:false,
			success:function(result){
				if(result > 0){
					console.log('孕妇现病史插入成功')
				}
			},
			error:function(e){
				console.log('孕妇现病史插入失败')
				console.log(JSON.stringify(e));
				return;
			}
		});
	}
}

//孕妇家族史和丈夫家族史
function addMedicalHistory2(){
	var g_family_history = $('.g_family_history').val();
	var husband_family_history = $('.husband_family_history').val();
	//孕妇家族史
	if(g_family_history == 2){
		var info = "mid=" + mid +"&type=" + 2;
		var g_family_history1 = $('.g_family_history1').val().trim().split(" ,");
//		console.log(g_family_history1)
		for(i=0;i<=g_family_history1.length;i++){
			if(g_family_history1[i] =='盲'){
				info += "&blind=" + 1;
			}
			if(g_family_history1[i] =='聋'){
				info += "&deaf=" + 1;
			}
			if(g_family_history1[i] =='哑'){
				info += "&dumb=" + 1;
			}
			if(g_family_history1[i] =='精神病'){
				info += "&psychosis=" + 1;
			}
			if(g_family_history1[i] =='先天性智力低下'){
				info += "&cmr=" + 1;
			}
			if(g_family_history1[i] =='先天性心脏病'){
				info += "&chd=" + 1;
			}
			if(g_family_history1[i] =='血友病'){
				info += "&hemophilia=" + 1;
			}
			if(g_family_history1[i] =='糖尿病'){
				info += "&diabetes=" + 1;
			}
			if(g_family_history1[i] =='其他'){
				info += "&other=" + $('.g_family_history2').val();
			}
		}
//		console.log(info)
		$.ajax({
			type:"post",
			url: UtilAddress + "medicalHistory/insertSelective.do",
			data: info,
			async:false,
			success:function(result){
				if(result > 0){
					console.log('孕妇家族史插入成功')
				}
			},
			error:function(e){
				console.log('孕妇家族史插入失败')
				console.log(JSON.stringify(e))
				return;
			}
		});
	}
	//丈夫家族史
	if(husband_family_history == 2){
		var info = "mid=" + mid +"&type=" + 3;
		var husband_family_history1 = $('.husband_family_history1').val().trim().split(" ,");
//		console.log(husband_family_history1)
		for(i=0;i<=husband_family_history1.length;i++){
			if(husband_family_history1[i] =='盲'){
				info += "&blind=" + 1;
			}
			if(husband_family_history1[i] =='聋'){
				info += "&deaf=" + 1;
			}
			if(husband_family_history1[i]=='哑'){
				info += "&dumb=" + 1;
			}
			if(husband_family_history1[i]=='精神病'){
				info += "&psychosis=" + 1;
			}
			if(husband_family_history1[i]=='先天性智力低下'){
				info += "&cmr=" + 1;
			}
			if(husband_family_history1[i]=='先天性心脏病'){
				info += "&chd=" + 1;
			}
			if(husband_family_history1[i]=='血友病'){
				info += "&hemophilia=" + 1;
			}
			if(husband_family_history1[i]=='糖尿病'){
				info += "&diabetes=" + 1;
			}
			if(husband_family_history1[i]=='其他'){
				info += "&other=" + $('.husband_family_history2').val();
			}
		}
//		console.log(info)
		$.ajax({
			type:"post",
			url: UtilAddress + "medicalHistory/insertSelective.do",
			data: info,
			async:false,
			success:function(result){
				if(result > 0){
					console.log('丈夫家族史插入成功')
				}
			},
			error:function(e){
				console.log('丈夫家族史插入失败')
				console.log(JSON.stringify(e))
				return;
			}
		});
	}
}

//往孕妇首诊表插入数据
function addFirstCheck() {
	//console.log(33)
	var date = new Date();
	var today = date.getDate();
	if(today < 10){
		today = "0" + today;
	}
	var checkdate = date.getFullYear() + "-" + (date.getMonth()+1) + "-" + today; //检查日期	
	var g_weight = $('.g_weight').val(); //体重
	//收缩压跟舒张压
	var mmsg = $('.g_blood_pressure').val();
	var arr = mmsg.split('/');
	var spressure = 0;
	var dpressure = 0;
	if(mmsg != null || mmsg != '') {
		if(arr.length != 2) {
			spressure = '';
			dpressure = '';
		} else {
			spressure = arr[0];//收缩压
			dpressure = arr[1];//舒张压
		}
	}
	var heart = $('.g_heart').val(); //心脏
	var g_lung = $('.g_lung').val(); //肺部
	var g_vulua = $('.g_vulua').val(); //外阴
	var g_uterine_neck = $('.g_uterine_neck').val(); //宫颈
	var g_uterine = $('.g_uterine').val(); //子宫
	var g_vagina = $('.g_vagina').val(); //阴道
	var g_vagina_detail = $('.g_vagina_detail').val();//阴道异常描述
	var description = $('.description').val(); //主诉
//	console.log("mid"+mid+"&checkdate"+checkdate+"&g_weight"+g_weight+"&spressure"+spressure+"&dpressure"+dpressure+"&heart"+heart+"&g_lung"+g_lung+"&g_vulua"+g_vulua+"&g_uterine_neck"+g_uterine_neck+"&g_uterine"+g_uterine+"&g_vagina"+g_vagina+"&description"+description);
	if(g_vagina_detail != null && g_vagina_detail != ''){
		console.log()
		description = "阴道:"+ g_vagina_detail +"; ";
	}
	$.ajax({
		type: "post",
		url: UtilAddress + "GravidaFirstCheck/addorupdate.do",
		dataType: "json",
		async: false,
		data: {
			"mid": mid,
			"checkdate": checkdate,//检查日期
			"weight": g_weight,//体重
			"spressure": spressure,//收缩压
			"dpressure": dpressure,//舒张压
			"heart": heart,//心脏
			"lung": g_lung,//肺
			"vulva": g_vulua,//外阴
			"cervixuteri": g_uterine_neck,//宫颈
			"uterus": g_uterine,//子宫
			"vagina": g_vagina,//阴道
			"complaint": description//主诉
		},
		async:false,
		success: function(result) {
			//console.log(JSON.stringify(result))
			if(result.state == 0) {
				var gravidaFirstCheck = result.data;
				console.log('建档成功')
				alert("建档成功！");
				window.location.href = '../userList/archivesModule/firstDiagnose.html';
			} else {
				alert('建档失败');
				return;
			}
		},
		error:function(e){
			alert('建档失败');
			console.log(JSON.stringify(e));
			return;
		}
	});
}


//点击往usertb表插入信息
function addUsertb() {
	var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;
	var username = $('.g_tel').val();
	if(username == null) {
		return;
	}
	if(myreg.test(username)) {
		$.ajax({
			type: "post",
			url: UtilAddress + "user/findUseridByUsername.do",
			data: {
				username: username
			},
			async: false,
			success: function(result) {
				if(result > 0) {
					alert("该手机已建档！请从已建档查看信息");
				} else if(result == -1) {
					inser(username);
				}
			},
			error:function(e){
				console.log(JSON.stringify(e))
			}
		});

	} else {
		alert("请输入正确的手机号码");
	}
}
//根据电话号码插入返回userid
function inser(username) {
	$.ajax({
		type: "post",
		url: UtilAddress + "user/inserUserTa.do",
		data: {
			username: username
		},
		async: false,
		success: function(result) {
			if(result >= 0) {
				var userid = result;
				infoSubmit(userid);
			} else {
			}
		},
		error: function(e) {
			console.log(JSON.stringify(e));
		}
	});

}

/*
//根据医院名查医院id
function showHospitalname(hospitalname) {
	if(hospitalname != null && hospitalname != '') {
		$.ajax({
			type: "post",
			url: UtilAddress + "hospital/findByHname.do",
			dataType: "json",
			async: false,
			data: {
				hospitalname: hospitalname
			},
			success: function(result) {
				if(result.data != null) {
					var hospitalid = result.data.hospitalid;
					hospital = hospitalid;
				}
			}
		});
	}

}
*/

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
			returnAge = ""; //返回-1 表示出生日期输入错误 晚于今天  
		}
	}

	return returnAge; //返回周岁年龄  

}

function getDateString(mydate) {
	if(mydate == null || mydate == undefined) {
		return "";
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
	sessionStorage.setItem('week', returnweeks);
	return returnweeks;
}
//自动添加孕妇年龄
function aa() {
	var end = $(".g_date").val();
	document.getElementById('g_age').value = jsGetAge(end);
}
//自动添加丈夫年龄
function bb() {
	var end = document.getElementById('h_date').value;
	document.getElementById('h_age').value = jsGetAge(end);
}
//自动添加预产期和孕周
function cc() {
	var end = document.getElementById('g_endDate').value;
	document.getElementById('g_expectedConfinement').value = getexpectedConfinement(end);
	document.getElementById('g_recordweek').value = getweeks(end) + '周';
}
//自动添加bmi
function showBmi() {
	var weight = document.getElementById('g_weight').value;
	var high = document.getElementById('g_height').value;
	var bmi = (weight / ((high / 100) * (high / 100))).toFixed(2);
	if(bmi == Infinity){
		document.getElementById('g_bmi').value = '请输入身高';
		return;
	}
	document.getElementById('g_bmi').value = bmi;
}
//显示疾病选择框
function a(index){
   	switch(index){
   		case 1:
   			var g_medical_history = $('#g_medical_history').val();
   			if(g_medical_history == 2){
   				show(index);
   			}
   			break;
   		case 2:
   			var g_medical = $('#g_medical').val();
   			if(g_medical == 2){
   				show(index);
   			}
   			break;
   		case 3:
   			var g_family_history = $('#g_family_history').val();
   			if(g_family_history == 2){
   				show(index);
   			}
   			break;
   		case 4:
   			var husband_family_history = $('#husband_family_history').val();
   			if(husband_family_history == 2){
   				show(index);
   			}
   			break;
   		case 5:
   			var husband_family_history = $('.g_vagina').val();
   			if(husband_family_history == 1){
   				show(index);
   			}
   			break;
// 		case 6:
// 			var g_medical_history1 = $('.g_medical_history1').val();
// 			if(g_medical_history1 == '先天或遗传性疾病'){
// 				show(index);
// 			}
// 			break;
// 		case 7:
// 			var g_medical1 = $('.g_medical1').val();
// 			if(g_medical1 == '先天或遗传性疾病'){
// 				show(index);
// 			}
// 			break;
// 		case 8:
// 			var g_family_history1 = $('.g_family_history1').val();
// 			if(g_family_history1 == '其他'){
// 				show(index);
// 			}
// 			break;
// 		case 9:
// 			var husband_family_history1 = $('.husband_family_history1').trim().val();
// 			if(husband_family_history1 == '其他'){
// 				show(index);
// 			}
// 			break;
   	}
}

function b(index){
   	switch(index){
   		case 1:
   			var g_medical_history = $('#g_medical_history').val();
   			if(g_medical_history != 2){
   				hide(index);
   			}
   			break;
   		case 2:
   			var g_medical = $('#g_medical').val();
   			if(g_medical != 2){
   				hide(index);
   			}
   			break;
   		case 3:
   			var g_family_history = $('#g_family_history').val();
   			if(g_family_history != 2){
   				hide(index);
   			}
   			break;
   		case 4:
   			var husband_family_history = $('#husband_family_history').val();
   			if(husband_family_history != 2){
   				hide(index);
   			}
   			break;
   		case 5:
   			var husband_family_history = $('.g_vagina').val();
   			if(husband_family_history != 1){
   				hide(index);
   			}
   			break;
// 		case 6:
// 			var g_medical_history1 = $('.g_medical_history1').val();
// 			if(g_medical_history1 != '先天或遗传性疾病'){
// 				hide(index);
// 			}
// 			break;
// 		case 7:
// 			var g_medical1 = $('.g_medical1').val();
// 			if(g_medical1 != '先天或遗传性疾病'){
// 				hide(index);
// 			}
// 			break;
// 		case 8:
// 			var g_family_history1 = $('.g_family_history1').val();
// 			if(g_family_history1 != '其他'){
// 				hide(index);
// 			}
// 			break;
// 		case 9:
// 			var husband_family_history1 = $('.husband_family_history1').val();
// 			if(husband_family_history1 != '其他'){
// 				hide(index);
// 			}
// 			break;
   		
   	}	
}
//显示多选框
function show(index){
	switch(index){
		case 1:
			$('.g_medical_history1').show();
			break;
		case 2:
			$('.g_medical1').show();
			break;
		case 3:
			$('.g_family_history1').show();
			break;
		case 4:
			$('.husband_family_history1').show();
			break;
		case 5:
			$('.g_vagina_detail').show();
			break;
		case 6:
			$('.g_medical_history2').show();
			break;
		case 7:
			$('.g_medical2').show();
			break;
		case 8:
			$('.g_family_history2').show();
			break;
		case 9:
			$('.husband_family_history2').show();
			break;
	}
}
//隐藏多选框
function hide(index){
	switch(index){
		case 1:
			$('.g_medical_history1').hide();
			$('.g_medical_history2').hide();
			break;
		case 2:
			$('.g_medical1').hide();
			$('.g_medical2').hide();
			break;
		case 3:
			$('.g_family_history1').hide();
			$('.g_family_history2').hide();
			break;
		case 4:
			$('.husband_family_history1').hide();
			$('.husband_family_history2').hide();
			break;
		case 5:
			$('.g_vagina_detail').hide();
			break;
		case 6:
			$('.g_medical_history2').hide();
			break;
		case 7:
			$('.g_medical2').hide();
			break;
		case 8:
			$('.g_family_history2').hide();
			break;
		case 9:
			$('.husband_family_history2').hide();
			break;
	}
}
//下一步
function next(index){
	switch(index){
		case 1:
			if($("#form1").valid() == false){
				return;
			}
			var rule = /^(1[3584]\d{9})$/;
			var g_tel = $('.g_tel').val();//联系电话
			var relation_tel = $('.relation_tel').val();//紧急联系人电话
			if(rule.test(g_tel) === false || rule.test(relation_tel) === false) {
				alert('请输入正确的手机号码');
				return;
			} else {
				g_tel = $('.g_tel').val();
				relation_tel = $('.relation_tel').val();
			}
			
			$('.step_one').hide();
			$('.step_two').show();
			break;
		case 2:
			if($("#form2").valid() == false){
				return;
			}
			$('.step_two').hide();
			$('.step_three').show();
			$('#btn_two').show();
			break;
	}
}
function back(){
	$('.step_one').show();
	$('.step_two').hide();
}
//function jump(index){
//	switch(index){
//		case 1:
//			$('.step_one').hide();
//			$('.step_two').show();
//			break;
//		case 2:
//			$('.step_two').hide();
//			$('.step_three').show();
//			$('#btn_two').show();
//			break;
//	}
//}
$('.g_tel').blur(function(){
	$.ajax({
		type:"post",
		url: UtilAddress + "user/findUserByUsername.do",
		async:false,
		data:{
			username: $('.g_tel').val()
		},
		success:function(result){
			if(result.data != null){
				alert('该号码已注册')
			}
		}
	});
});
