var SUCCESS = 0;
var ERROR = 1;
//var address = "http://192.168.1.60:8080/doctormanager/";
var address = sessionStorage.getItem("address");
//var mid = 'dg217181';
var mid = sessionStorage.getItem("mid");
var enddate = sessionStorage.getItem("enddate");

var dates = new Date(enddate).getTime();

$(function(){
	/*showTest(7);*/
})

//血常规
function changeBlood2(count){
	$('.bloodRutine-table-div').empty();
	$('#bloodCheck').text("");
	$('#blood2_weeks').text("");
	$('#bloodImg').empty();
	$('.whatthe').val("");
	$('.spanresult').text("");
	var weeks = count;
	var sweeks = 0;
	var eweeks = 0;
	if(weeks != 0 && weeks != undefined) {
		//开始孕周
		var w = weeks.split('-');
		sweeks = w[0];
		eweeks = w[1];
	}
	if(sweeks == 6 && eweeks == 13 || sweeks == 1 && eweeks == 41){
		$('.div-one-p').text("首诊结论");
	}else{
		$('.div-one-p').text("复诊结论");
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
	if(weeks!=null&&weeks!=''){				
	var url = address + "checkResult/selectCheckDetailByMId.do";
	$.ajax({
		type: "post",
		url: url,
		async: true,
		dataType: "json",
		data: {
			mid: mid,
			checkProjectId:1,
			weeks:week
		},
		success:function(result){
			if(result.state == 0){
				var blood = result.data;
				if(blood != null && blood.length >0){
					showBlood(blood);
				}
				
			}
		}
	})
	}else{
		return;
	}
}
var showBlood = function(blood){
	//console.log(longToDate(blood[0].checkDate));
	$(".bloodImg").empty();
	if(blood[0].checkDate != null && blood[0].checkDate != undefined){
		$('#bloodCheck').text(longToDate(blood[0].checkDate));
	}
	
	$('#blood2_weeks').text(blood[0].gWeeks+'周');
	var html = '';
	var th = "<tr class='tr_firstDiagnose_width tr_firstDiagnose_color'>"+
															"<td>名称</td>"+
															"<td>简称</td>"+
															"<td>结果</td>"+
															"<td>单位</td>"+
															"<td>参考值</td>"+
														"</tr>";
	html += "<table>";
	html += th;
	for(var i=0;i<blood.length;i++){
		var cname = blood[i].cname;
		var shortname = blood[i].shortname;
		var checkValue = blood[i].checkValue;
		var cunit = blood[i].cunit;
		var referencevalue = blood[i].referencevalue;
		html += "<tr class='tr_firstDiagnose_width'><td>"+(cname?cname:'')+"</td>"+
				"<td>"+(shortname?shortname:'')+"</td>"+
				"<td class='RBC2'>"+(checkValue?checkValue:'')+"</td>"+
				"<td>"+(cunit?cunit:'')+"</td>"+
				"<td>"+(referencevalue?referencevalue:'')+"</td></tr>";
	}
	
	html += "</table>";
	
	$('.bloodRutine-table-div').html(html);
	var urlimg = blood[0].picLink;
	//console.log(urlimg);
	$(".bloodImg").append("<tr><td colspan='4' class='niptclass' onclick='seeOriginalReport(\"" + urlimg + "\")'><a>查看原始报告</a></td></tr>");
}

//尿常规
var changeUrine2 = function(count){
	$('.neurineRutine-table').empty();
	$('#urine2-check').text("");
	$('#urine2_weeks').text("");
	$(".urineImg").empty();
	$('.whatthe').val("");
	$('.spanresult').text("");
	var weeks = count;
	var sweeks = 0;
	var eweeks = 0;
	if(weeks != 0 && weeks != undefined) {
		//开始孕周
		var w = weeks.split('-');
		sweeks = w[0];
		eweeks = w[1];
	}
	if(sweeks == 6 && eweeks == 13 || sweeks == 1 && eweeks == 41){
		$('.div-this-check').text("首诊结论");
	}else{
		$('.div-this-check').text("复诊结论");
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
	if(weeks!=null&&weeks!=''){				
	var url = address + "checkResult/selectCheckDetailByMId.do";
	$.ajax({
		type: "post",
		url: url,
		async: true,
		dataType: "json",
		data: {
			mid: mid,
			checkProjectId:2,
			weeks:week
		},
		success:function(result){
			if(result.state == 0){
				var urine = result.data;
				if(urine != null && urine.length > 0 ){
					showUrine(urine);
				}
				
			}
		}
	})
	}else{
		return;
	}
}
var showUrine = function(urine){
	//console.log(urine)
	$(".urineImg").empty();
	if(urine[0].checkDate != null && urine[0].checkDate != undefined){
		$('#urine2-check').text(longToDate(urine[0].checkDate));
	}
	
	$('#urine2_weeks').text(urine[0].gWeeks+'周');
	var html = '';
	var th = "<tr class='tr_firstDiagnose_width tr_firstDiagnose_color'>"+
															"<td>名称</td>"+
															"<td>简称</td>"+
															"<td>结果</td>"+
															"<td>单位</td>"+
															"<td>参考值</td>"+
														"</tr>";
	html += "<table id='urine_table2'>";
	html += th;
	for(var i=0;i<urine.length;i++){
		var cname = urine[i].cname;
		var shortname = urine[i].shortname;
		var checkValue = urine[i].checkValue;
		var cunit = urine[i].cunit;
		var referencevalue = urine[i].referencevalue;
		html += "<tr class='tr_firstDiagnose_width'><td>"+(cname?cname:'')+"</td>"+
				"<td>"+(shortname?shortname:'')+"</td>"+
				"<td class='RBC2'>"+(checkValue?checkValue:'')+"</td>"+
				"<td>"+(cunit?cunit:'')+"</td>"+
				"<td>"+(referencevalue?referencevalue:'')+"</td></tr>";
	}
	
	html += "</table>";
	$('.neurineRutine-table').html(html);
	var urlimg = urine[0].picLink;
	//console.log(urlimg);
	$(".urineImg").append("<tr><td colspan='4' class='niptclass' onclick='seeOriginalReport(\"" + urlimg + "\")'><a>查看原始报告</a></td></tr>");
}


function showTest(count){
	$('.spanresult').text("");
	$('.whatthe').val("");
	var begintime;
	var endtime;
	if(count>=6 && count<=13){
		begintime = longToDate(dates + 6*7*24*60*60*1000);
		endtime = longToDate(dates + 13*7*24*60*60*1000);
	}
	if(count>=14 && count<=20){
		begintime = longToDate(dates + 14*7*24*60*60*1000);
		endtime = longToDate(dates + 20*7*24*60*60*1000);
	}
	if(count>=20 && count<=24){
		begintime = longToDate(dates + 20*7*24*60*60*1000);
		endtime = longToDate(dates + 24*7*24*60*60*1000);
	}
	if(count>=24 && count<=28){
		begintime = longToDate(dates + 24*7*24*60*60*1000);
		endtime = longToDate(dates + 28*7*24*60*60*1000);
	}
	if(count>=28 && count<=32){
		begintime = longToDate(dates + 28*7*24*60*60*1000);
		endtime = longToDate(dates + 32*7*24*60*60*1000);
	}
	if(count>=33 && count<=36){
		begintime = longToDate(dates + 33*7*24*60*60*1000);
		endtime = longToDate(dates + 36*7*24*60*60*1000);
	}
	if(count>=37 && count<=41){
		begintime = longToDate(dates + 37*7*24*60*60*1000);
		endtime = longToDate(dates + 41*7*24*60*60*1000);
	}
	if(count<6){
		begintime = null;
		endtime = null;
	}
	var url = address + "gravidainfo/getabnormitybyweeks.do";
	$.ajax({
		type: "post",
		url: url,
		data: {
			"mid": mid,
			"begintime": begintime,
			"endtime": endtime
		},
		async: false,
		dataType: "json",
		success:function(result){
			//console.log(JSON.stringify(result));
			if(result!= null){
				/*$('#nipt_knowledge').val(result[0].abnormity);
				$('#nipt_highRiskResultType').text(result[0].riskscore);
				alert($('#nipt_knowledge').val());*/
				var fxys = $('.whatthe').val();
				var sum = 0;
				for(var i =0;i<result.length;i++){
					var highPloblem = result[i].abnormity;
					var score = result[i].riskscore;	
					if(highPloblem!=null){
						//alert(111);
						fxys = fxys+highPloblem+ "\r\n";
					}
					if(score != null){
						sum += score;
					}
				}
				$('.whatthe').val(fxys);
				var highScore = sum*0.2;
				if(highScore>=2&&highScore<=4){
					$('.spanresult').text('轻度高危');
				}
				if(highScore>=5&&highScore<=7){
					$('.spanresult').text('中度高危');
				}
				if(highScore>=8){
					$('.spanresult').text('重度高危');
				}
				if(highScore<2){
					$('.spanresult').text('正常');
				}
				
				
			}
		}
	});
	
}
