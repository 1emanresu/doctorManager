/*author luoyc*/
var address= sessionStorage.getItem("address");
var mid=sessionStorage.getItem("mid");
var doctorId=sessionStorage.getItem("doctorId");
$(function(){
	var now =new Date();
	$(".recordDay").text(getDateString(now));
	$.ajax({
        type: "post",
        url: address + "gravidainfo/find.do",
        data: {
            mid: mid
        },
        dataType: "json",
        success: function(e) {
        	var gravidinfo=e.data;
            if(e.data!=null){
            	$(".gName").text(replaceUndefined(gravidinfo.gname));
            	var age="暂无数据"
            	if(gravidinfo.birthYears!=undefined){            		
					age=Math.floor(((now-gravidinfo.birthYears)/1000/365/24/60/60));
				}
            	$(".age").text(age);
            	if(gravidinfo.enddate!=undefined&&gravidinfo.enddate!=null){
            		$(".endDate").text(getDateString(gravidinfo.enddate));
            		$(".recordWeek").text(getWeeks(gravidinfo.enddate).weeks);
            	}else{
            		$(".endDate").text("暂无数据");
            	}
            	if(gravidinfo.expectedconfinement!=undefined&&gravidinfo.expectedconfinement!=null){
            		$(".expectedDate").text(getDateString(gravidinfo.expectedconfinement));
            	}else{
            		$(".expectedDate").text("暂无数据");
            	}
            	
            }
        }
    });
    //获取session中存的编辑好的医嘱
	$("#doctor_advice_forview").text(sessionStorage.getItem("viewDoctorStr"));
})
findAbnormityinfo();
//查询最近一周异常报告指标
function findAbnormityinfo(){
	$.ajax({
		type: "post",
		dataType: "json",
		data: {
			"mid": mid
		},
		url: address + "abnormityinfo/findWeeklyAbnormityinfo.do",
		success: function(result) {
			var checkReportList = result.data;
			var checkDetailList;
			var htmlStr='';
			$.each(checkReportList, function(i) {
				checkDetailList=checkReportList[i];
				if(i%2==0){
					$.each(checkDetailList, function(j) {
						if(j==0){
							htmlStr += "<div class='tables_div'>"
								  +"<div class='div-left'>"
		                          +"<div class='third_class_titile'>"
		                          +checkDetailList[j][0]
		                          +"</div>"
		                          +"<table class='table-for-usual secondLineRed'>"
		                          +"<tr><td>名称</td><td>结果</td><td>单位</td><td>参考值</td></tr><tr><td>"
		                          +checkDetailList[j][1]
		                          +"</td><td>"
		                          +checkDetailList[j][2]
								  +"</td><td>"
		                          +checkDetailList[j][3]
		                          +"</td><td>"
		                          +checkDetailList[j][4]
		                          +"</td></tr>";
						}else{
							htmlStr+= "<tr><td>"
		                          	 +checkDetailList[j][1]
		                          	 +"</td><td>"
		                         	 +checkDetailList[j][2]
								   	 +"</td><td>"
		                          	 +checkDetailList[j][3]
		                          	 +"</td><td>"
		                          	 +checkDetailList[j][4]
		                          	 +"</td></tr>";
						}
						if(j==checkDetailList.length-1){
							htmlStr+= "</table></div>";
						}
						if(i==checkReportList.length-1){
							htmlStr+= "</div>";
						}
			        })
				}else{
					$.each(checkDetailList, function(j) {
						if(j==0){
							htmlStr += "<div class='div-right'>"
			                          +"<div class='third_class_titile'>"
			                          +checkDetailList[j][0]
			                          +"</div>"
			                          +"<table class='table-for-usual secondLineRed'>"
			                          +"<tr><td>名称</td><td>结果</td><td>单位</td><td>参考值</td></tr><tr><td>"
			                          +checkDetailList[j][1]
			                          +"</td><td>"
			                          +checkDetailList[j][2]
									  +"</td><td>"
			                          +checkDetailList[j][3]
			                          +"</td><td>"
			                          +checkDetailList[j][4]
			                          +"</td></tr>";
			          	}else{
			          		htmlStr+= "<tr><td>"
		                          	 +checkDetailList[j][1]
		                          	 +"</td><td>"
		                         	 +checkDetailList[j][2]
								   	 +"</td><td>"
		                          	 +checkDetailList[j][3]
		                          	 +"</td><td>"
		                          	 +checkDetailList[j][4]
		                          	 +"</td></tr>";
			         	}
		                if(j==checkDetailList.length-1){
		                	htmlStr+="</table></div></div>"
		                }
					})
				}		  
			})
			if(htmlStr==''){
				$("#abnormityinfoReport").append("<div style='color:#888888'>暂无</div>");
			}else{
				$("#abnormityinfoReport").after(htmlStr);
			}
		},
		error: function() {}
	});
}
//非空处理
function listAdd(list,selftest){
	if(selftest!=null&&selftest!=''){
		list.push(selftest)
	}
}
//自测表格赋值
$(function(){
	var tablestr='';
	var list=[];
	listAdd(list,(sessionStorage.getItem("血压")));
	listAdd(list,(sessionStorage.getItem("血脂")));
	listAdd(list,(sessionStorage.getItem("血糖")));
	listAdd(list,(sessionStorage.getItem("体重")));
	listAdd(list,(sessionStorage.getItem("体温")));
	listAdd(list,(sessionStorage.getItem("宫高")));
	listAdd(list,(sessionStorage.getItem("血氧")));
	listAdd(list,(sessionStorage.getItem("心电")));
	listAdd(list,(sessionStorage.getItem("腹围")));
	listAdd(list,(sessionStorage.getItem("胎动")));
	listAdd(list,(sessionStorage.getItem("动态血糖")));
	listAdd(list,(sessionStorage.getItem("动态血压")));
	listAdd(list,(sessionStorage.getItem("胎心(大)")));
	listAdd(list,(sessionStorage.getItem("胎心(小)")));
	listAdd(list,(sessionStorage.getItem("运动")));
	listAdd(list,(sessionStorage.getItem("尿液")));
	sessionStorage.setItem("血压",'');
	sessionStorage.setItem("血脂",'');
	sessionStorage.setItem("血糖",'');
	sessionStorage.setItem("体重",'');
	sessionStorage.setItem("体温",'');
	sessionStorage.setItem("宫高",'');
	sessionStorage.setItem("血氧",'');
	sessionStorage.setItem("心电",'');
	sessionStorage.setItem("腹围",'');
	sessionStorage.setItem("胎动",'');
	sessionStorage.setItem("动态血糖",'');
	sessionStorage.setItem("动态血压",'');
	sessionStorage.setItem("胎心(大)",'');
	sessionStorage.setItem("胎心(小)",'');
	sessionStorage.setItem("运动",'');
	sessionStorage.setItem("尿液",'');
	$.each(list, function(i) {
		var jugement=list[i].split(",");
		tablestr+="<tr><td>"+jugement[0]+"</td><td>"+jugement[1]+"</td><td>"+jugement[2]+"</td></tr>";
	});
	$("#selfTestTable").append(tablestr);
});
//获取自述症状
$(function(){
	$.ajax({
		type: "post",
		dataType: "json",
		data: {
			"mid": mid
		},
		url: address + "selfTest/findThisWeek.do",
		success: function(result) {
			var allList=result.data[0];
			var notDoneList=result.data[1];
			var tableNotDoneStr='';
			var selfTestStr='';
			$.each(notDoneList, function(i) {
				tableNotDoneStr+="<tr><td>"+notDoneList[i]+"</td><td>提醒做而未做</td><td></td>"
			});
			$.each(allList, function(i) {
				if(i==0){
					selfTestStr+=allList[i];
				}else{
					selfTestStr+="、"+allList[i];
				}
			});
			
			if(tableNotDoneStr.trim()!=""){
				$("#selfTestTable").append(tableNotDoneStr);
				$("#selfTest").text(selfTestStr);
			}else{
				$("#selfTestTable").hide();
				$("#haveNone").text("暂无");
			}
			
		},
		error: function() {}
	});
	var systomStr=sessionStorage.getItem("symptomResult");
	var tableStr=""
	if(systomStr==null||systomStr==""){
		tableStr="<tr><td>暂无</td></tr>"
	}else{
		var systomStrlist=systomStr.split("~");
		$.each(systomStrlist, function(i) {
			tableStr+="<tr><td>"
					  +systomStrlist[i]
					  +"<td></tr>";
		});
	}
	$("#selfDescriptionTable").append(tableStr);
});

//异常指标分析
var getGravidato = function() {
	var url = address+"/gravidainfo/getabnormity.do";
	$.ajax({
		type: "post",
		url: url,
		dataType: "json",
		async: true,
		data: {
			mid: mid
		},
		success: function(result1) {
			if(result1 != null || result1 != '') {
				var resultList=result1;
				var list2=[];
				for(var i=0;i<resultList.length-1;i++){
					if(resultList[i].cname!=undefined&&resultList[i].cname!=""){
						list2.push(resultList[i].cname);
					}
				}
				$.ajax({
					type: "post",
					url: address.replace("doctormanager","knowledge")+"riskModel/getAdvice.do",
					dataType: "json",
					async: true,
					traditional: true,
					data: {
						"cnamelist": list2
					},
					success: function(e) {
						if(e != null || e != '') {
							$.each(e, function(i) {
								var advicecont = "<p>" + (i + 1) + "&nbsp;&nbsp;" + e[i] + "</p>";
								$("#abnormal-analysis").append(advicecont);
							});
							if(e.length==0){
								$("#abnormal-analysis").append("<div class='notHaveYet'>暂无</div>");
								$(".notHaveYet").css("padding","10px");
							}
						}else{
							$("#abnormal-analysis").append("<div class='notHaveYet'>暂无</div>");
							$(".notHaveYet").css("padding","10px");
						}
					}
				});
			}
		}
	});
}
getGravidato();
//替换空值
function replaceUndefined(str){
	if(str==undefined||str==null){
		return "暂无数据"
	}
	return str;
}
//long值转字符串
function getDateString(mydate) {
	var d = new Date(mydate);
	//格式化日，如果小于9，前面补0  
	var day = ("0" + d.getDate()).slice(-2);
	//格式化月，如果小于9，前面补0  
	var month = ("0" + (d.getMonth() + 1)).slice(-2);
	//拼装完整日期格式  
	var date1 = d.getFullYear() + "/" + (month) + "/" + (day);
	return date1;
}
//获取孕周
function getWeeks(date1) {
    var date2 = new Date();
    var date3 = date2.getTime() - new Date(date1).getTime();
    var days = Math.floor(date3 / (24 * 3600 * 1000));
    var json = {
        "weeks": parseInt(days / 7),
        "day": days % 7
    };
    return json;
}