var SUCCESS = 0;
var ERROR = 1;


var mid = sessionStorage.getItem("mid");
//var mid = 'dg000001';
//var wid = 115;
//var pcid = 1;
//var address = "http://192.168.1.60:8080/doctormanager/";
var address =sessionStorage.getItem("address");



function getDateString(mydate){
var d = new Date(mydate);
						//格式化日，如果小于9，前面补0  
						var day = ("0" + d.getDate()).slice(-2);  
						//格式化月，如果小于9，前面补0  
						var month = ("0" + (d.getMonth() + 1)).slice(-2);  
						//拼装完整日期格式  
						var date1 = d.getFullYear()+"-"+(month)+"-"+(day) ;
	return date1;
}

/*根据出生日期算出年龄*/  
function jsGetAge(strBirthday){         
    var returnAge;  
    var strBirthdayArr=strBirthday.split("-");  
    var birthYear = strBirthdayArr[0];  
    var birthMonth = strBirthdayArr[1];  
    var birthDay = strBirthdayArr[2];  
      
    d = new Date();  
    var nowYear = d.getFullYear();  
    var nowMonth = d.getMonth() + 1;  
    var nowDay = d.getDate();  
      
    if(nowYear == birthYear){  
        returnAge = 0;//同年 则为0岁  
    }  
    else{  
        var ageDiff = nowYear - birthYear ; //年之差  
        if(ageDiff > 0){  
            if(nowMonth == birthMonth) {  
                var dayDiff = nowDay - birthDay;//日之差  
                if(dayDiff < 0)  
                {  
                    returnAge = ageDiff - 1;  
                }  
                else  
                {  
                    returnAge = ageDiff ;  
                }  
            }  
            else  
            {  
                var monthDiff = nowMonth - birthMonth;//月之差  
                if(monthDiff < 0)  
                {  
                    returnAge = ageDiff - 1;  
                }  
                else  
                {  
                    returnAge = ageDiff ;  
                }  
            }  
        }  
        else  
        {  
            returnAge = -1;//返回-1 表示出生日期输入错误 晚于今天  
        }  
    }  
      
    return returnAge;//返回周岁年龄  
      
}  



$(function(){
	//網頁加載及判斷狀態
	getStatus();
	var status = sessionStorage.getItem('status');
	//console.log(status);
	if(status == 1){
	//网页加载即显示孕妇信息
	showMessage();
	
	//丈夫信息
	showHusband();
	
	//成员孕妇信息
	showGravida();
	//备孕信息
	showPregnancy();
	//体重
	showWeight();
	//显示孕产史信息
	showprenancyHistory();
	//有无疾病
	showHistory();
	}else{
		return;
	}
})

//網頁加載即判斷狀態
function getStatus(){
	$.ajax({
		type: "post",
		url: address + "gravidainfo/find.do",
		dataType: "json",
		async: true, 
		data:{
			 mid:mid
		},
		success:function(result){
			if(result.state==0){
				var gravida = result.data;
				sessionStorage.setItem('status',gravida.pergnancystatus);
		}
		}
	}); 
}


function showMessage(){
	var status = sessionStorage.getItem('status');
	if(status == 1){
	$.ajax({
		type: "post",
		url: address + "gravidainfo/find.do",
		dataType: "json",
		async: true, 
		data:{
			 mid:mid
		},
		success:function(result){
			if(result.state==0){
				var gravida = result.data;
				getMessage(gravida);
		}
		}
	}); 
	}
	return;
}



//孕妇信息
function getMessage(gravida){
	//console.log(gravida.gname);
	$('#g_id').text(gravida.mid);
	$('#g_name').text(gravida.gname);
	$('#g_age').text(jsGetAge(getDateString(gravida.birthYears)));
	var bir = gravida.birthYears;
	if(bir == null || bir == ''){
		bir = " ";
	}
	$('#g_birthday').text(getDateString(bir));
	$('#g_postalcode').text(gravida.postalcode);
	$('#g_high').text(gravida.ghigh);
	$('#g_date').text(getDateString(gravida.recorddate));
	var monthpresidenceaddress = (gravida.monthpresidenceaddress).replace('#','');
	$('#g_monthPResidenceAddress').text(monthpresidenceaddress.replace('#',''));
	var monthpresentaddress = (gravida.monthpresentaddress).replace('#','');
	$('#g_monthPresentAddress').text(monthpresentaddress.replace('#',''));
	var weight = sessionStorage.getItem('weight');
	var ghigh = (gravida.ghigh)/100;
	$('#g_bmi').text((weight/(ghigh*ghigh)).toFixed(2));
	sessionStorage.setItem('enddate',getDateString(gravida.enddate));
	//alert(gravida.enddate);
}

//丈夫信息
function showHusband(){
	var status = sessionStorage.getItem('status');
	var url = address + "familyMember/findHusbandByMid.do";
	if(status == 1){
	$.ajax({
		type: "post",
		url: url,
		dataType: "json",
		async: true, 
		data:{
			 mid:mid
		},
		success:function(result){
			if(result.state==0){
				var husband = result.data;
				//console.log(gravida);
				
				getHusband(husband);
		}
		}
	}); 
	}
	return;
}

function getHusband(husband){
	//console.log(husband.name);
	$('#h_name').text(husband.name);
	$('#h_id').text(husband.fmid);
}


//成员孕妇信息
function showGravida(){
	var status = sessionStorage.getItem('status');
	var url = address + "familyMember/findGravidaByMid.do";
	if(status == 1){
	$.ajax({
		type: "post",
		url: url,
		dataType: "json",
		async: true, 
		data:{
			 mid:mid
		},
		success:function(result){
			if(result.state==0){
				var gravida = result.data;
				//console.log(gravida);
				
				getGravida(gravida);
		}
		}
	}); 
	}
	return;
}

function getGravida(gravida){
	//console.log(gravida.profession);
	$('#g_work').text(gravida.workunit);
	$('#g_phone').text(gravida.phone);
	$('#g_profession').text(gravida.profession);
	$('#g_nation').text(gravida.nation);
	$('#g_education').text(gravida.education);
	var bloodtype = gravida.bloodtype;
	if(bloodtype == 0){
		bloodtype = 'A';
	}else if(bloodtype == 1){
		bloodtype = 'B';
	}else if(bloodtype == 2){
		bloodtype = 'O';
	}else if(bloodtype == 3){
		bloodtype = 'AB';
	}else if(bloodtype == null){
		bloodtype = '无';
	}
	var rh = gravida.rh;
	if(rh == 0){
		rh = '阴性';
	}else if(rh == 1){
		rh = '阳性';
	}else if(rh == null){
		rh = '无';
	}
	$('#g_bloodtype').text(bloodtype+'/'+rh);
}

//备孕
function showPregnancy(){
	var status = sessionStorage.getItem('status');
	var url = address + "pregnancy/findByMid.do";
	if(status == 1){
	$.ajax({
		type: "post",
		url: url,
		dataType: "json",
		async: true, 
		data:{
			 mid:mid
		},
		success:function(result){
			if(result.state==0){
				var pregnancy = result.data;
				getPregnancy(pregnancy);
		}
		}
	}); 
	}
	return;
}

function getPregnancy(pregnancy){
	if(pregnancy.familyhistory == 0){
		$('#g_familyHistory').text('无');
	}else{
		$('#g_familyHistory').text('有');
	}
	
	if(pregnancy.sibship == 0){
		$('#g_sibship').text('非近亲');
	}else{
		$('#g_familyHistory').text('近亲');
	}
	
	if(pregnancy.recentMarriage == 0){
		$('#g_recentMarriage').text('无');
	}else{
		$('#g_recentMarriage').text('有');
	}
	
	if(pregnancy.profession == 0){
		$('#g_mentalstate').text('异常');
	}else{
		$('#g_mentalstate').text('正常');
	}
	
	var favorsport = pregnancy.favorsport;//喜欢的运动
	var dosport = pregnancy.dosport;//运动状况
	if(dosport == 0){
		dosport = '每天运动';
	}else if(dosport == 1){
		dosport = '极少运动';
	}else if(dosport == 2){
		dosport = '没有运动';
	}else if(dosport == null){
		dosport = '无';
	}
	var sporttime = pregnancy.sporttime;//运动时间
	var sportpower = pregnancy.sportpower;//运动强度
	if(sportpower == 0){
		sportpower = '一般';
	}else if(sportpower == 1){
		sportpower = '较弱';
	}else if(sportpower == 2){
		sportpower = '较强';
	}else if(sportpower == null){
		sportpower = '无';
	}
	$('#g_sport').text('喜欢运动：'+favorsport+'/每天状况：'+dosport+'/每天运动时间：'+sporttime+'/运动强度：'+sportpower);
	
	
	if(pregnancy.hostileeenvironment == 0){
		$('#g_hostileeenvironment').text('无');
	}else if(pregnancy.hostileeenvironment == 1){
		$('#g_hostileeenvironment').text('有');
	}else if(pregnancy.hostileeenvironment == null){
		$('#g_hostileeenvironment').text('无');
	}
	
	var pickyeater = pregnancy.pickyeater;//偏食挑食
	if(pickyeater == 0){
		pickyeater = '无';
	}else if(pickyeater == 1){
		pickyeater = '有';
	}else{
		pickyeater = '无';
	}
	var vegetables = pregnancy.vegetables;//食用新鲜蔬菜的情况
	if(vegetables == 0){
		vegetables = '每餐都有';
	}else if(vegetables == 1){
		vegetables = '每餐极少';
	}else if(vegetables == 2){
		vegetables = '每餐没有';
	}else{
		vegetables = '无记录';
	}
	var fruits = pregnancy.fruits;//食用新鲜水果的情况
	if(fruits == 0){
		fruits = '每天至少一次';
	}else if(fruits == 1){
		fruits = '每天没有';
	}else if(fruits == 2){
		fruits = '每天两次';
	}else if(fruits == 3){
		fruits = '每天三次';
	}else if(fruits == 4){
		fruits = '每天经常食用';
	}else{
		fruits = '无记录';
	}
	var meet = pregnancy.meet;//食用肉类
	if(meet == 0){
		meet = '每餐都有';
	}else if(meet == 1){
		meet = '每餐极少';
	}else if(meet == 2){
		meet = '每餐没有';
	}else{
		meet = '无记录';
	}
	var medicine = pregnancy.medicine;//药物食用
	if(medicine == 0){
		medicine = '无';
	}else if(medicine == 1){
		medicine = '有';
	}else{
		medicine = '无';
	}
	var folicacid = pregnancy.folicacid;//叶酸服用
	if(folicacid == 0){
		folicacid = '无';
	}else if(folicacid == 1){
		folicacid = '有';
	}else{
		folicacid = '无';
	}
	$('#g_eat').text('偏食、挑食：'+pickyeater+'/ 食用新鲜蔬菜：'+vegetables+'/ 食用新鲜水果：'+fruits+'/ 食用肉类：'+meet+'/ 药物食用：'+medicine+'/ 叶酸服用：'+folicacid);
	
	var familyrelation = pregnancy.familyrelation;//与家庭成员关系
	if(familyrelation == 0){
		familyrelation = '和睦';
	}else if(familyrelation == 1){
		familyrelation = '不太和睦';
	}else if(familyrelation == 2){
		familyrelation = '经常吵架';
	}else{
		familyrelation = '无记录';
	}
	var friendship = pregnancy.friendship;//与朋友关系
	if(friendship ==0){
		friendship = '和睦';
	}else if(friendship ==1){
		friendship = '不太和睦';
	}else if(friendship == 2){
		friendship = '经常吵架';
	}else{
		friendship = '无记录';
	}
	var workship = pregnancy.workship;//与同事关系
	if(workship == 0){
		workship = '和睦';
	}else if(workship == 1){
		workship = '不太和睦';
	}else if(workship == 2){
		workship = '经常吵架';
	}else{
		workship = '无记录';
	}
	var pressure = pregnancy.pressure;//工作压力
	if(pressure == 0){
		pressure = '无';
	}else if(pressure == 1){
		pressure = '有';
	}else if(pressure == null){
		pressure = '无';
	}else{
		pressure = '无记录';
	}
	var ready = pregnancy.ready;//是否做好怀孕准备
	if(ready == 0){
		ready = '是';
	}else if(ready == 1){
		ready = '否';
	}else{
		ready = '无记录';
	}
	$('#g_familyrelation').text('与家庭成员关系：'+familyrelation+'/ 与同事关系：'+workship+'/ 与朋友关系：'+friendship+'/ 工作压力:'+pressure+'/ 是否做好怀孕准备：'+ready);
	
	var oneage = pregnancy.oneage;//初潮年龄
	var holdtime = pregnancy.holdtime;//月经持续时间
	if(holdtime == null){
		holdtime = ' ';
	}
	var menstrualcycle = pregnancy.menstrualcycle;//月经周期
	if(menstrualcycle == null){
		menstrualcycle = ' ';
	}
	var quantity = pregnancy.quantity;//月经量
	if(quantity == 0){
		quantity = '少';
	}else if(quantity == 1){
		quantity = '中';
	}else if(quantity == 2){
		quantity = '多';
	}else{
		quantity = '无记录';
	}
	var dysmenorrhea = pregnancy.dysmenorrhea;//痛经
	if(dysmenorrhea == 0){
		dysmenorrhea = '无';
	}else if(dysmenorrhea == 1){
		dysmenorrhea = '轻';
	}else if(dysmenorrhea == 2){
		dysmenorrhea = '中';
	}else if(dysmenorrhea == 3){
		dysmenorrhea = '重';
	}else if(dysmenorrhea == 4){
		dysmenorrhea = '极重';
	}else{
		dysmenorrhea = '无';
	}
	var enddate = sessionStorage.getItem('enddate');//末次月经
	//alert(enddate);
	$('#g_oneage').text('初潮年龄：'+oneage+'岁'+'/ 月经周期：'+menstrualcycle+'天/ 持续时间：'+holdtime+'天/ 量：'+quantity+'/ 痛经：'+dysmenorrhea+'/ 末次月经：'+enddate);
	
	$('#g_lifestyle').text(pregnancy.lifestyle);//生活方式
	$('#g_vaccinate').text(pregnancy.vaccinate);//预防接种
	
	var pregnancyCheck = pregnancy.pregnancyCheck;
	$('#g_dpressure').text(pregnancyCheck.spressure+'/'+pregnancyCheck.dpressure);//血压
	
	var facialfeatures = pregnancyCheck.facialfeatures;
	if(facialfeatures == 0){
		facialfeatures = '正常';
	}else if(facialfeatures == 1){
		facialfeatures = '异常';
	}else{
		facialfeatures = '无相关记录';
	}
	$('#g_facialFeatures').text(facialfeatures);//五官
	
	var skinhair = pregnancyCheck.skinhair;
	if(skinhair == 0){
		skinhair ='正常';
	}else if(skinhair ==1){
		skinhair ='异常';
	}else{
		skinhair = '无相关记录';
	}
	$('#g_skinHair').text(skinhair);//皮肤毛发
	
	var noise = pregnancyCheck.noise;
	if(noise == 0){
		noise = '有';
	}else if(noise == 1){
		noise = '无';
	}else{
		noise = '无';
	}
	var rhythmheart = pregnancyCheck.rhythmheart;
	if(rhythmheart == 0){
		rhythmheart = '正常';
	}else if(rhythmheart == 1){
		rhythmheart = '异常';
	}else{
		rhythmheart = '无记录';
	}
	$('#g_heartRate').text('心率（次/分）:'+pregnancyCheck.heartrate+'/ 心律：'+rhythmheart+'/ 杂音：'+noise);//心
	
	var lung = pregnancyCheck.lung;
	if(lung == 0){
		lung = '正常';
	}else if(lung == 1){
		lung = '异常';
	}else{
		lung = '无记录';
	}
	$('#g_lung').text(lung);//肺
	
	$('#pregnancy_other').text(pregnancyCheck.other);//其他
	
	var psychosis = pregnancyCheck.psychosis;
	if(psychosis == 0){
		psychosis = '正常';
	}else if(psychosis == 1){
		psychosis = '异常';
	}else{
		psychosis = '无记录';
	}
	$('#g_psychosis').text(psychosis);//精神状态
	
	var specialbody = pregnancyCheck.specialbody;
	if(specialbody == 0){
		specialbody = '正常';
	}else if(specialbody == 1){
		specialbody = '异常';
	}else{
		specialbody = '无记录';
	}
	$('#g_specialbody').text(specialbody);//特殊体态
	
	var thyroiddisease = pregnancyCheck.thyroiddisease;
	if(thyroiddisease == 0){
		thyroiddisease = '无';
	}else if(thyroiddisease == 1){
		thyroiddisease = '有';
	}else{
		thyroiddisease = '无';
	}
	$('#g_thyroiddisease').text(thyroiddisease);//甲状腺
	
	var liver = pregnancyCheck.liver;
	if(liver == 0){
		liver = '正常';
	}else if(liver == 1){
		liver = '异常';
	}else{
		liver = '无记录';
	}
	$('#g_liver').text(liver);//肝
	
	var intelligence = pregnancyCheck.intelligence;
	if(intelligence == 0){
		intelligence = '正常';
	}else if(intelligence == 1){
		intelligence = '异常';
	}else{
		intelligence = '无记录';
	}
	$('#g_intelligence').text(intelligence);//智力
	
	var specialface = pregnancyCheck.specialface;
	if(specialface == 0){
		specialface = '有';
	}else if(specialface == 1){
		specialface = '无';
	}else{
		specialface = '无记录';
	}
	$('#g_specialface').text(specialface);//特殊面貌
	
	var limbsspine = pregnancyCheck.limbsspine;
	if(limbsspine == 0){
		limbsspine = '正常';
	}else if(limbsspine == 1){
		limbsspine = '异常';
	}else{
		limbsspine = '无记录';
	}
	$('#g_limbsspine').text(limbsspine);//四肢脊柱
	
	var pubes = pregnancyCheck.pubes;
	if(pubes == 0){
		pubes = '正常';
	}else if(pubes == 1){
		pubes = '异常';
	}else if(pubes == 2){
		pubes = '其它';
	}else{
		pubes = '无记录';
	}
	$('#g_pubes').text(pubes);//阴毛
	
	var secretion = pregnancyCheck.secretion;
	if(secretion == 0){
		secretion = '正常';
	}else if(secretion == 1){
		secretion = '异常';
	}else if(secretion == 2){
		secretion = '其他';
	}else{
		secretion = '无记录';
	}
	$('#g_secretion').text(secretion);//分泌物
	
	$('#g_enclosure').text(pregnancyCheck.enclosure);//子宫附件
	
	var breast = pregnancyCheck.breast;
	if(breast == 0){
		breast = '正常';
	}else if(breast == 1){
		breast = '异常';
	}else if(breast == 2){
		breast = '其他';
	}else{
		breast = '无记录';
	}
	$('#g_breast').text(breast);//乳房
	
	var cervixuteri = pregnancyCheck.cervixuteri;
	if(cervixuteri == 0){
		cervixuteri = '正常';
	}else if(cervixuteri == 1){
		cervixuteri = '异常';
	}else if(cervixuteri == 2){
		cervixuteri = '其他';
	}else{
		cervixuteri = '无记录';
	}
	$('#g_cervixUteri').text(cervixuteri);//宫颈
	$('#g_other').text(pregnancyCheck.other);//其他
	
	var vulva = pregnancyCheck.vulva;//外阴
	if(vulva == 0){
		vulva = '正常';
	}else if(vulva == 1){
		vulva = '异常';
	}else if(vulva == 2){
		vulva = '其他';
	}else{
		vulva = '无记录';
	}
	$('#g_vulva').text(vulva);
	//alert(vulva);
	
	
	var uterus = pregnancyCheck.uterus;//子宫
	if(uterus == 0){
		uterus = '正常';
	}else if(uterus == 1){
		uterus = '异常';
	}else if(uterus == 2){
		uterus = '其他';
	}else{
		uterus = '无记录';
	}
	$('#g_uterus').text(uterus);
	
}

function showWeight(){
	var status = sessionStorage.getItem('status');
	if(status == 1){
	$.ajax({
		type: "post",
		url: address + "weightTest/selectByMid.do",
		dataType: "json",
		async: true, 
		data:{
			 mid:mid
		},
		success:function(result){
			//console.log(result);
			if(result.state==0){
				var weight = result.data;
				$('#g_weight').text(weight[0].pregnancy);
				//alert(weight[0].pregnancy);
				sessionStorage.setItem('weight',weight[0].pregnancy); 
		}
		}
	}); 
	}
	return;
}

//孕产史
function showprenancyHistory(){
	var status = sessionStorage.getItem('status');
	var url = address + "pregnancyHistory/selectHistoryGradeInfo.do";
	if(status == 1){
	$.ajax({
		type: "post",
		url: url,
		dataType: "json",
		async: true, 
		data:{
			 mid:mid
		},
		success:function(result){
			if(result.state==0){
				//console.log(JSON.stringify(result.data));
				var pregnancyHistory = result.data;
				getprenancyHistory(pregnancyHistory[0]);
		}
		}
	}); 
	}
	return;
}

function getprenancyHistory(pregnancyHistory){
	
	//console.log(pregnancyHistory.gravidity);
	$('#g_gravidity').text('怀孕：'+pregnancyHistory.gravidity+'次');//怀孕
	
}

//历史疾病
function showHistory(){
	var status = sessionStorage.getItem('status');
	var url = address + "pregnancyHistory/selectHistory.do";
	if(status == 1){
	$.ajax({
		type: "post",
		url: url,
		dataType: "json",
		async: true, 
		data:{
			 mid:mid
		},
		success:function(result){
			var data = result.data;
			$('#g_grahistory').text(data.history);//既往疾病
		}
	}); 
	}
	return;
}
