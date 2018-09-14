/*author luoyc*/
var address= sessionStorage.getItem("address");
var mid=sessionStorage.getItem("mid");
var doctorId=sessionStorage.getItem("doctorId");
$(function(){
	var now =new Date();
	$.ajax({
        type: "post",
        url: address + "inquiryRecord/findByQid.do",
        data: {
            qid: sessionStorage.getItem("viewId")
        },
        dataType: "json",
        success: function(inquiryRecord) {
        	//医嘱
        	$("#doctor_advice_forview").text(inquiryRecord.doctoradvice);
			//问诊孕周、时间
			if(inquiryRecord.qdate!=null&&inquiryRecord.qdate!=undefined){
				$(".recordDay").text(getDateString(inquiryRecord.qdate));
				
			}else{
				$(".recordDay").text("暂无数据");
			}
			//自觉症状
			var systomStr=inquiryRecord.rationalsymptom;
			var tableStr=""
			if(systomStr==null||systomStr==""||systomStr==undefined||systomStr.trim()=="暂无"){
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
			//查询报告异常指标
			if(inquiryRecord.uploaddate!=null&&inquiryRecord.uploaddate!=undefined){
				findAbnormityinfo(new Date(inquiryRecord.uploaddate));
			}
			//异常指标分析
			if(inquiryRecord.abnormityinfoIndex!=null&&inquiryRecord.abnormityinfoIndex!=undefined){
				$("#abnormal-analysis").html(inquiryRecord.abnormityinfoIndex);
				$(".notHaveYet").css("padding","10px");
			}
			//自测项目
			if(inquiryRecord.selfTestJudgment!=null&&inquiryRecord.selfTestJudgment!=undefined){
				selfTestTable(inquiryRecord.selfTestJudgment);
			}
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
		            	}else{
		            		$(".endDate").text("暂无数据");
		            	}
		            	if(gravidinfo.expectedconfinement!=undefined&&gravidinfo.expectedconfinement!=null){
		            		$(".expectedDate").text(getDateString(gravidinfo.expectedconfinement));
		            	}else{
		            		$(".expectedDate").text("暂无数据");
		            	}
		            	if(gravidinfo.enddate!=undefined&&gravidinfo.enddate!=null&&inquiryRecord.uploaddate!=undefined&&inquiryRecord.uploaddate!=null){
							$(".recordWeek").text(getWeeksToDate(gravidinfo.enddate,inquiryRecord.uploaddate).weeks);
						}else{
							$(".recordWeek").text("暂无数据");
						}
			        }
    			}
		    });
		}
    });
})
//查询最近一周异常报告指标
function findAbnormityinfo(uploadDate){
	$.ajax({
		type: "post",
		dataType: "json",
		data: {
			"mid": mid,
			"uploaddate":uploadDate
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

//获取自测判断表
function selfTestTable(list){	
	var dataList=list;
	var tableNotDoneStr='';
	var selfTestStr='';
	$.each(dataList, function(i) {
		tableNotDoneStr+="<tr><td>"
						 +dataList[i].sname
						 +"</td><td>"
						 +dataList[i].judgment
						 +"</td><td>"
						 +dataList[i].illustration
						 +"</td>";
		if(i==0){
			selfTestStr+=dataList[i].sname;
		}else{
			selfTestStr+="、"+dataList[i].sname;
		}
	});
	if(tableNotDoneStr.trim()!=""){
		$("#selfTestTable").append(tableNotDoneStr);
		$("#selfTest").text(selfTestStr);
	}else{
		$("#selfTestTable").hide();
		$("#haveNone").text("暂无");
	}			
};
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
//计算孕周
function getWeeksToDate(date1, date2) {
	if(date1 == "" || date1 == undefined || date1 == null) {
		return '';
	}
	var date3 = new Date(date2) - date1;
	var days = Math.floor(date3 / (24 * 3600 * 1000));
	var json = {
		"weeks": parseInt(days / 7),
		"day": days % 7
	};
	return json;
}
