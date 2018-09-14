/*author luoyc*/
var address= sessionStorage.getItem("address");
var mid=sessionStorage.getItem("mid");
var doctorId=sessionStorage.getItem("doctorId");
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
	//获取session中存的编辑好的医嘱,再清空
	$("#thisAdvice_content").text(sessionStorage.getItem("viewDoctorStr"));
	sessionStorage.setItem("viewDoctorStr","");
});
//保存问诊记录
function saveRecord(){
	var date = new Date();
	var seperator = "-";
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	if(month < 10) {
		month = "0" + month;
	};
	var strDate = date.getDate();
	if(strDate < 10) {
		strDate = "0" + strDate;
	};
	var currentdate = year + seperator + month + seperator + strDate;
	var doctoradvice=$("#thisAdvice_content").text().trim();
	if(doctoradvice.trim()==''){
		alert("医嘱建议不能为空");
	}else{
		//根据id找到这个表格
		var tb = document.getElementById("selfTestTable");
    	//取得这个table下的所有行
    	var rows = tb.rows;
    	//循环遍历所有的tr行
    	var jugementStrList=[];
    	for(var i=1;i<rows.length;i++){
    		//取得第几行下面的td个数，再次循环遍历该行下面的td元素
    		var jugementStr=''
      		for(var j=0;j<rows[i].cells.length;j++){
         		//获取某行下面的某个td元素
         		var cell = rows[i].cells[j];
         		//cell.innerHTML获取元素里头的值  
         		if(j==0){
         			jugementStr+=cell.innerHTML;
         		}else{
         			jugementStr+=","+cell.innerHTML;
         		}
        	}
      		jugementStrList.push(jugementStr);
    	}
    	var abnormityinfoIndex=$("#abnormal-analysis").html();
    	jugementStrList=jugementStrList.toString();
    	var rationalsymptom='';
    	var tb2 = document.getElementById("selfDescriptionTable");
    	var rows2 = tb2.rows;
    	for(var i=0;i<rows2.length;i++){
	     	var cell = rows2[i].cells[0];
	     	if(i==0){
	     		rationalsymptom+=cell.innerHTML;
	     	}else{
	     		rationalsymptom+="~"+cell.innerHTML;
	     	}
    	}
		$.ajax({
			type: "post",
			dataType: "json",
			data: {
				"mid": mid,
				"doctorid": doctorId,
				"qdate": currentdate,
				"doctoradvice":doctoradvice,
				"jugementStrList":jugementStrList,
				"abnormityinfoIndex":abnormityinfoIndex,
				"rationalsymptom":rationalsymptom
			},
			url: address + "inquiryRecord/insert.do",
			success: function(result) {
				updateState();//更改为已处理状态--zhangqt
				var Msgdata={
					"relationIds":[1],
					"title":"",
					"content": "您有一份新的问诊记录，请及时查看。"
				}
				//消息推送和短信发送
				pushSmsMsg(mid, 3, Msgdata);
				Msgdata.title="问诊提醒";
				pushAppMsg(mid, 3, Msgdata);
				pushWeChatMsg(mid, 3, Msgdata);
				
				alert("发送成功！");
			},
			error: function() {}
		});
	}	
}


//更改为已处理状态--zhangqt
function updateState() {
	var rrid = sessionStorage.getItem("rrid");
	if(rrid == '' || rrid == null || rrid == undefined) {
		return;
	}
	$.ajax({
		type: "post",
		url: address + "orderDetails/updateState.do",
		data: {
			rrid: rrid
		},
		async: true,
		success: function(e) {
			//alert("成功改变处理状态！！");
		}
	});
}

$("#inquiryRecordView").click(function(){
	var viewDoctorStr=$("#thisAdvice_content").text().trim();
	sessionStorage.setItem("viewDoctorStr",viewDoctorStr);
	location.href="confirmReportView.html";
})
$("#inquiryRecordHistory").click(function(){
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
            	sessionStorage.setItem("endDate",new Date(gravidinfo.enddate));
            	sessionStorage.setItem('backonly',1);
            	location.href='../userList/function/seeInterrogation.html';
            	
            }
        }
  });	
})
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