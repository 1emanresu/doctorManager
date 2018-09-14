/*author luoyc 2017-9-18*/
var address=sessionStorage.getItem("address");
var mid=sessionStorage.getItem("mid");
var week=sessionStorage.getItem("week");
$("#gWeek").text(week);
if(week>40){
	week=40;
}

var weeklyReportDate=sessionStorage.getItem("weeklyReportDate");

$(function(){
	//获取姓名
	$.ajax({
		type: "post",
		ContentType: "application/x-www-form-urlencoded;charset=utf-8",
		url: address + "gravidainfo/find.do",
		dataType: "json",
		data: {
			"mid": mid,
		},
		success: function(e) {
			var gravidinfo=e.data;
			var gName='';
			if(gravidinfo.gname!=null&&gravidinfo.gname!=undefined){
				gName=gravidinfo.gname;
			}
			$("#gName").text(gName);
		}
	});
	//医嘱建议
	var doctorAdvice=sessionStorage.getItem("viewDoctorStr");
	sessionStorage.setItem("viewDoctorStr","");
	$("#doctor_advice").append(doctorAdvice);
	//用药记录
	var date1=new Date();
	$.ajax({
		type: "post",
		url: address + "prescription/findByDateRange.do",
		data: {
			"mid": mid,
			"end":date1
		},
		success: function(d) {
			var list=d.data;
			var tableStr='';
			$.each(list, function(i) {
				tableStr+="<tr><td>"+list[i].medicinename+"</td><td>"+list[i].method+"</td><td>"+list[i].dose+"</td></tr>";
			});
			$("#table_prescription").append(tableStr);
			if(list.length==0){
				$(".div_prescription").hide();
			}
		},
		error: function(e) {
			
		}
	});
	//根据返回的上传时间查询，自测项目
	$.ajax({
		type: "post",
		url: address + "selfTest/findSpecialWeek.do",
		data: {
			"mid": mid,
			"date":date1,
			"week":week
		},
		success: function(d) {
			var list=d.data[0]
			var list1=d.data[1];
			var tableStr="";
			var abnormalList=[];
			$.each(list1, function(i) {
				abnormalList.push(list1[i][0]);
				var decription=list1[i][1];
				if(decription==''){
					decription="正常";
				}
				tableStr+="<tr><td>"+list1[i][0]+"</td><td>"+decription+"</td><td>"+list1[i][2]+"</td></tr>";
			});
			//检查报告结果，异常计数
			$.ajax({
				type: "post",
				url: address + "checkResult/queryResultByUploadDate.do",
				data: {
					"mid": mid,
					"uploaddate":date1
				},
				success: function(result) {
					var list3=result.data;
					var tableStr1='';
					$.each(list3, function(i) {
						tableStr1+="<tr><td>"+list3[i][0]+"</td><td>"+list3[i][1]+"</td></tr>";
					});
					$("#table_checkProject").append(tableStr1);
					if(list3.length==0){
						$(".div_checkProject").hide();
					}
				},
				error: function(e) {
			
				}
			});
			//自测项目，异常评价
			$.ajax({
				type: "post",
				url: address + "abnormityinfo/findSelfTestAbnormityinfo.do",
				data: {
					"mid": mid,
					"uploaddate":date1
				},
				success: function(result) {
					var list2=result.data;
					$.each(list2, function(i) {
						abnormalList.push(list2[i][0]);
						var decription=list2[i][1];
						if(decription==''){
							decription="正常";
						}
						tableStr+="<tr><td>"+list2[i][0]+"</td><td>"+decription+"</td><td>"+list2[i][2]+"</td></tr>";
					});
					for(var i=0;i<list.length;i++){
						for(var j=0;j<abnormalList.length;j++){
							if(list[i]==abnormalList[j]){
								abnormalList.splice(j,1);
								list[i]="";
								break;
							}
						}
					}
					$.each(list, function(i) {
						if(list[i]!=''){
							tableStr+="<tr><td>"+list[i]+"</td><td>正常</td><td>"+referencevalue(list[i])+"</td></tr>";
						}
					});
					if(tableStr.trim()==''){
						$(".div_selfTest").hide();
					}
					$("#selfTestDetail").append(tableStr);
				},
				error: function(e) {
			
				}
			});
		},
		error: function(e) {
			
		}
	});	
});
//周报通用数据 luoyc 2017-09-19
$(function(){
    $.ajax({
		type: "post",
		url: address + "weeklyReport/findWeeklyTemplate.do",
		data: {
			"mid": mid,
			"week":week
		},
		success: function(d) {
			var list=d.data;
			//重点关注
			var keyAttentionList=list[0];
			var attentionStr='';
			$.each(keyAttentionList, function(i) {
				if(i==0){
					attentionStr+=keyAttentionList[i].attentionproject;
				}else{
					attentionStr+="、"+keyAttentionList[i].attentionproject;
				}
			});
			$("#p_keyAttention").html(attentionStr);
			//产检要点
			var checkProjectList=list[1];
			var checkProjectStr='';
			$.each(checkProjectList, function(i) {
				if(i==0){
					checkProjectStr+=checkProjectList[i].riskname;
				}else{
					checkProjectStr+="、"+checkProjectList[i].riskname;
				}
				
			});
			$("#p_checkReport").html(checkProjectStr);
			//存在风险
			var symptomList=list[2];
			var symptomStr='';
			var symptomDetailStr='';
			$.each(symptomList, function(i) {
				if(i==0){
					symptomStr+=symptomList[i].symptomname;
				}else{
					symptomStr+="、"+symptomList[i].symptomname;
				}
				symptomDetailStr+="<div class='p_weekReport_container div_riskExist'>"
								  +"<div class='div_weekReport_disple'>"
								  +"<div class='div_weekReport_posi'>"
								  +"<div class='div_weekReport_triangle'></div>"
								  +"<div class='disease_title'>"
								  +symptomList[i].symptomname
								  +"</div>";
				if(symptomList[i].abnormalexpression!=null&&symptomList[i].abnormalexpression.trim()!=''){
					symptomDetailStr+="<span>症状：<span><p>"
									  +symptomList[i].abnormalexpression
									  +"</p>";
				}
				if(symptomList[i].reason!=null&&symptomList[i].reason.trim()!=''){
					symptomDetailStr+="<span>诱发因素：<span><p>"
									  +symptomList[i].reason
									  +"</p>";
				}
				if(symptomList[i].prevention!=null&&symptomList[i].prevention.trim()!=''){
					symptomDetailStr+="<span>预防：<span><p>"
									  +symptomList[i].prevention
									  +"</p>";
				}
				if(symptomList[i].suggest!=null&&symptomList[i].suggest.trim()!=''){
					symptomDetailStr+="<span>建议：<span><p>"
									  +symptomList[i].suggest
									  +"</p>";
				}
				if(symptomList[i].dispose!=null&&symptomList[i].dispose.trim()!=''){
					symptomDetailStr+="<span>治疗：<span><p>"
									  +symptomList[i].dispose
									  +"</p>";
				}
				symptomDetailStr+="</div></div></div>"
			});
			$("#div_symptomDetail").append(symptomDetailStr);
			$("#p_symptom").html(symptomStr);
			//饮食要点
			var weeklyFood=list[3];
			var eatYes=weeklyFood.eatyes;
			var eatNo=weeklyFood.eatno;
			var nutritional=weeklyFood.nutritional;
			$("#eatYes").html(eatYes);
			$("#eatNo").html(eatNo);
			$("#nutritional").html(nutritional);
			//运动要点
			var exerciseYesList=list[4];
			var exerciseYesStr='';
			$.each(exerciseYesList, function(i) {
				exerciseYesStr+="<div class='div_exercisTitle'>"
								+(i+1)+"."+exerciseYesList[i].exercisename
								+"</div>";
				if(exerciseYesList[i].effect!=null&&exerciseYesList[i].effect.trim()!=''){
					exerciseYesStr+="<p>"
									+exerciseYesList[i].effect
									+"</p>"
				}
			});
			$("#div_exerciseYes").append(exerciseYesStr);
			var exerciseNoList=list[5];
			var exerciseNoStr='';
			$.each(exerciseNoList, function(i) {
				exerciseNoStr+="<div class='div_exercisTitle'>"
								+(i+1)+"."+exerciseNoList[i].exercisename
								+"</div>";
				if(exerciseNoList[i].effect!=null&&exerciseNoList[i].effect.trim()!=''){
					exerciseNoStr+="<p>"
									+exerciseNoList[i].effect
									+"</p>"
				}
			});
			$("#div_exerciseNo").append(exerciseNoStr);
			//护理要点
			var nursingEssentialsList=list[6];
			var nursingEssentialsStr='';
			var nursingtips='';
			$.each(nursingEssentialsList, function(i) {
				nursingEssentialsStr+="<div class='p_weekReport_container'>"
									  +"<div class='div_weekReport_disple'>"
									  +"<div class='div_weekReport_posi'>"
									  +"<div class='div_weekReport_triangle'></div>"
									  +"<p>"
									  +nursingEssentialsList[i].essentialsname
									  +"</p>"
									  +"<p>"
									  +nursingEssentialsList[i].essentialsdescribe
									  +"</p>";
									  +"</div></div></div>"
				if(nursingEssentialsList[i].nursingtips!=null&&nursingEssentialsList[i].nursingtips.trim()!=''){
					nursingtips=nursingEssentialsList[i].nursingtips;
				}
			});
			$("#div_nursingTip").html(nursingtips);
			$("#div_nursingDetail").append(nursingEssentialsStr);
			//心理要点
			var psychologyEssentialsList=list[7];
			var essentialsdescribe=psychologyEssentialsList[psychologyEssentialsList.length-1].essentialsdescribe;
			$("#div_essentialsdescribe").html(essentialsdescribe);
		},
		error: function(e) {
			
		}
	});
});
//参考值
function referencevalue(str){
	if(str=="体重"){
		return "--";
	}else if(str=="体温"){
		return "36.5-38℃";
	}else if(str=="胎动"){
		return "3-5次";
	}else if(str=="血糖"){
		return "≤5.1mmol/L";
	}else{
		return "--";
	}
}
//症状自诉
$(function(){
	$.ajax({
		type: "post",
		url: address + "pregnancyRecord/findByWeek.do",
		data: {
			"mid": mid,
			"weeks":week
		},
		success: function(d) {
			var list=d.data;
			var divStr="";
			$.each(list, function(i) {
				if(i%2==0){
					divStr+="<div class='div_weekReport_table' style='margin-top:20px;'>"
						  +"<div class='div_weekReport_symptom'>"
						  +"<div>"
						  +list[i]
						  +"</div>"
						  +"<img src='images/weekreport/symptom_1.png' width='50' height='110'/>"
						  +"</div>";
				}else{
					divStr+="<div class='div_weekReport_symptom2'>"
						  +"<div>"
						  +list[i]
						  +"</div>"
						  +"<img src='images/weekreport/symptom_2.png' width='109' height='90'/>"
						  +"</div></div>";
				}
				if(i==list.length-1&&i%2==0){
					divStr+="</div>";
				}
			});
			$("#div_selfDescription").append(divStr);
			if(list.length==0){
				$(".div_selfDescription").hide();
			}
		},
		error: function(e) {
			
		}
	});
});
