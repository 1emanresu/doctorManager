//发送人
var username = '111';
//服务器地址http://192.168.1.26:8080120.76.194.76
//var address = "http://192.168.1.43:8080/doctormanager/"
var address = sessionStorage.getItem("address");
//接收人
var sendee = sessionStorage.getItem("mid");
var mid = sessionStorage.getItem("mid");
var modalflag = true;
var drawFlag = false;
$(function() {
	var dname = sessionStorage.getItem("dName");
	//为右上角的当前回话医生赋值
	if(dname != null && dname != "") {
		$("#dname").text(dname);
	}
	//查看未读信息
	init();
	$("#myAdviceModal").bind("show.bs.modal", ".modal", function() {
		$(this).draggable({
			//        handle: ".modal-header"   // 只能点击头部拖动
		}); // 防止出现滚动条，出现的话，你会把滚动条一起拖着走的
	});
});

//问诊结束，跳到发送医嘱页面
function confirmReport() {
	var symptomResult = "";
	var list = document.getElementsByClassName("sym-result"); //少敲了一个name
	for(var i = 0; i < list.length; i++) {
		if(i == 0) {
			symptomResult += (i + 1) + "、" + list[i].innerHTML;
		} else {
			symptomResult += "~" + (i + 1) + "、" + list[i].innerHTML;
		}
	}
	sessionStorage.setItem("symptomResult", symptomResult);
	location.href = 'confirmReport.html';
}

//此方法用于查看未读的聊天记录
function init() {
	var tem;
	$.ajax({
		type: "post",
		url: address + "helpRecord/queryByStatu.do",
		data: {
			senderid: username,
			receiverid: sendee
		},
		async: true,
		success: function(d) {
			var data = d.data;
			var textArea = document.getElementById("chat_content");
			for(var i = 0; i < data.length; i++) {
				var html = isType(data[i].filetype, data[i].sendcontent, data[i].senderid);
				textArea.innerHTML += html;
			}
			//目的是让收到新信息回到底部
			textArea.scrollTop = 0;
			//读取成功,改变状态为已读
			changeStatu();
		}
	});
}
//用于改变未读信息状态
function changeStatu() {
	$.ajax({
		type: "post",
		url: address + "helpRecord/updateStatu.do",
		data: {
			senderid: username,
			receiverid: sendee
		},
		async: true,
		success: function(i) {
			//成功处理
		}
	});
}

//查询所有记录
var bool = true;
function findRecords() {
	var tem;
	if(bool) {
		$.ajax({
			type: "post",
			url: address + "helpRecord/queryById.do",
			data: {
				senderid: username,
				receiverid: sendee
			},
			async: true,
			success: function(d) {
				bool = false;
				var data = d.data;
				var textArea = document.getElementById("chat_content");
				for(var i = 0; i < data.length; i++) {
					var html = isType(data[i].filetype, data[i].sendcontent, data[i].senderid);
					textArea.innerHTML += html;
				}
				//目的是回到顶部
				textArea.scrollTop = 0;
			}
		});
	}
}
//拖动弹出框
$(function modalMove() {
	$(".modalMove").mousedown(function(e) {
		iDiffX = e.pageX - $(this).offset().left;
		iDiffY = e.pageY - $(this).offset().top;
		var modalthis = $(this);
		$(document).mousemove(function(e) {
			modalthis.css({
				"left": (e.pageX - iDiffX),
				"top": (e.pageY - iDiffY)
			});
			//当鼠标到浏览器外面时，拖动事件停止
			var iEvent = e || event;
			if(iEvent.clientY > parseInt(window.innerHeight) || iEvent.clientY < 0 || iEvent.clientX < 0 || iEvent.clientX > parseInt(window.innerWidth)) {
				$(document).unbind("mousemove");
			}
		});
	});
	$(".modalMove").mouseup(function() {
		$(document).unbind("mousemove");
	});
});
/********         显示或隐藏左侧菜单栏 子菜单    @yinzx      ************/
//影像科隐藏
//$("#ri2").css("-webkit-transform", "rotate(90deg)");
//$("#tb2").css("background", "white");
//$("#nr2").hide();
//基因检查隐藏
//$("#ri3").css("-webkit-transform", "rotate(90deg)");
//$("#tb3").css("background", "white");
//$("#nr3").hide();

//点击按钮，隐藏右边
function pregnantwomenroomfn(i) {
	$("#tool" + i).hide();
	$('#content_right').css('width','5%');
	$('#tool').css('width','35px');
	$('#content_middle').css('width','75%')
}
//function exerciseresthide() {
//	$("#tool8").hide();
//}
var bool = [];
for(var i = 0; i < 9; i++) {
	bool[i] = false;
}
bool[2] = true;
bool[3] = true;
//右边工具栏点击显示
function showOrHide(i) {
	if(bool[i]) {
		for(var j = 1; j < 10; j++) {
			$("#ri" + j).css("-webkit-transform", "rotate(90deg)");
			$("#tb" + j).css("background", "white");
			$("#nr" + j).hide();
			bool[j] = true;
		}
		$("#ri" + i).css("-webkit-transform", "rotate(270deg)");
		$("#tb" + i).css("background", "whitesmoke");
		$("#nr" + i).show();
		bool[i] = false;
	} else {
		$("#ri" + i).css("-webkit-transform", "rotate(90deg)");
		$("#tb" + i).css("background", "white");
		$("#nr" + i).hide();
		bool[i] = true;
	}
}
//历史问诊模块
function showOrHidehistorywz(i) {
	if(bool[i]) {
		$("#ri" + i).css("-webkit-transform", "rotate(360deg)");
		$("#tb" + i).css("background", "whitesmoke");
		$("#nr" + i).show();
		bool[i] = false;
	} else {
		$("#ri" + i).css("-webkit-transform", "rotate(180deg)");
		$("#tb" + i).css("background", "white");
		$("#nr" + i).hide();
		bool[i] = true;
	}
}
//运动作息模块
function showOrHideyd(i) {
	if(bool[i]) {
		$("#ri" + i).css("-webkit-transform", "rotate(270deg)");
		$("#nr" + i).show();
		bool[i] = false;
	} else {
		$("#ri" + i).css("-webkit-transform", "rotate(90deg)");
		$("#nr" + i).hide();
		bool[i] = true;
	}
}

/**********            查询个人基础信息    @yinzx          ***********/
$(function() {
	$.ajax({
		type: "post",
		url: address + "gravidainfo/find.do",
		data: {
			mid: mid
		},
		async: false,
		dataType: "json",
		success: function(e) {
			getBaseMsg(e.data);
			
		},
		error:function(e){
			console.log(JSON.stringify(e))
		}
	});

})

//获取此孕程中要做的检查与已经做了的检查--zhangqt
function getCheckInfo() {
	$.ajax({
		type: "post",
		url: address + "weekly/findCheckProject.do",
		data: {
			mid: mid,
			week: 10
		},
		async: false,
		success: function(d) {
			var data = d.data;
			var htm1 = "";
			var htm2 = "";
			//已检查的 
			for(var i = 0; i < data.in.length; i++) {
				if(data.in.length - 1 == i) {
					htm1 += "<span>" + data.in[i].name + "</span>";
				} else {
					htm1 += "<span>" + data.in[i].name + "</span>、";
				}
			}
			//未检查的
			for(var i = 0; i < data.not.length; i++) {
				if(data.not.length - 1 == i) {
					htm2 += "<span style='color:red;'>" + data.not[i].name + "</span>";
				} else {
					htm2 += "<span style='color:red;'>" + data.not[i].name + "</span>、";
				}
			}
			$(".inCheck").html(htm1);
			$(".notCheck").html(htm2);
		}
	});
}

var weeks;

function getBaseMsg(data) {
	if(data == null) {
		return;
	}
	$(".graName").html(data.gname); //孕妇名称
	sessionStorage.setItem("gName", data.gname);
	$(".expectedDate").html(getDateString(data.expectedconfinement)); //预产期
	$(".enddate").html(getDateString(data.enddate)); //末次月经
	weeks = getWeeks(new Date(data.enddate)).weeks;
	$(".weeks").html(weeks); //孕周
	sessionStorage.setItem("weeks", weeks);
	changeColor(weeks);
	sessionStorage.setItem("enddate", getDateString(data.enddate));
	$(".buildWeeks").html(weeks); //建档孕周
	$(".mhistory").html(data.pregnancyBirth); //孕育史
	var pergnancystatus = "";

	switch(data.pergnancystatus) {
		case 1:
			pergnancystatus = "备孕";
			break;
		case 2:
			pergnancystatus = "怀孕";
			break;
		case 3:
			pergnancystatus = "育儿";
			break;
	}
	$("#graStatus").html(pergnancystatus);
	var gravida = data.familyMemberList[0];
	var dad = data.familyMemberList[1];
	var mbloodtype = "";
	var fbloodtype = "";
	var mRh = "";
	var fRh = "";
	if(gravida != undefined) {
		switch(gravida.bloodtype) {
			case 0:
				mbloodtype = "A";
				break;
			case 1:
				mbloodtype = "B";
				break;
			case 2:
				mbloodtype = "O";
				break;
			case 3:
				mbloodtype = "AB";
				break;
		}
		if(gravida.rh == 0) {
			mRh = "阴性";
		} else {
			mRh = "阳性";
		}
		$("#mRh").html(mRh);
		$("#mbloodtype").html(mbloodtype);
		var now = new Date();
		var age = "暂无数据";
		var birthDay = "暂无数据"
		if(gravida.birthYears != undefined) {
			age = Math.floor(((now - gravida.birthYears) / 1000 / 365 / 24 / 60 / 60));
			birthDay = getDateString(gravida.birthYears);
		}
		$(".graAge").html(age); //年龄
		$("#birthDate").html(birthDay);
	}
	if(dad != undefined) {
		switch(dad.bloodtype) {
			case 0:
				fbloodtype = "A";
				break;
			case 1:
				fbloodtype = "B";
				break;
			case 2:
				fbloodtype = "O";
				break;
			case 3:
				fbloodtype = "AB";
				break;
		}
		if(dad.rh == 0) {
			fRh = "阴性";
		} else {
			fRh = "阳性";
		}
		$("#fRh").html(fRh);
		$("#fbloodtype").html(fbloodtype);
	}
	getCheckInfo();
}

function getHriskMsg(data) {
	var length = data.length;
	var hriskscore = 0;
	var hrisklevel = "";
	var hriskdata = "";
	for(var i = 0; i < length; i++) {
		hriskdata = hriskdata + (i + 1) + "." + data[i].knowledge + "<br />";
		if(hriskscore < data[i].score) {
			hriskscore = data[i].score;
		}
	}
	if(hriskscore <= 5) {
		hrisklevel = "轻度高危";
	} else if(hriskscore <= 10) {
		hrisklevel = "中度高危";
	} else if(hriskscore <= 15) {
		hrisklevel = "高度高危";
	} else if(hriskscore <= 20) {
		hrisklevel = "极度高危";
	} else if(hriskscore == 0) {
		hrisklevel = "正常";
	}
	$(".hriskdata").html(hriskdata);
	$(".hriskscore").html(hriskscore);
	$(".hrisklevel").html(hrisklevel);
}


/**********            弹出个人基础信息div     @yinzx          ***********/
$("#baseMsg_close").click(function() {
	$("#div_baseMsg").css('display', 'none');
})

function showBaseMsg() {
	$("#div_baseMsg").css('display', 'block');
	$.ajax({
		type: "post",
		url: address + "abnormityinfo/findByWeeks.do",
		data: {
			mid: mid,
			sWeeks: weeks,
			eWeeks: weeks
		},
		async: true,
		dataType: "json",
		success: function(e) {
			getHriskMsg(e.data);
		}
	});
}

/**********              发送报告         @yinzx                ***********/
function sendReport() {
	var msg;
	var tab = $("#report_table").html();
	if(tab == null || tab == "") {
		//存储发送的div表格html
		var tbody = "<div id='sendReportDIV'><label id='sendName'>" + $("#report_name").html() + "</label>";
		msg = tbody + $("#report_main").html() + "</div>";
		console.log(msg);
	} else {
		var thisTable = document.getElementById("report_table");
		var trs = thisTable.rows;
		//存储发送的div表格html
		var tbody = "<div id='sendReportDIV'><label id='sendName'>" + $("#report_name").html() + "</label><table  id='sendTable' >";
		//获取表格标题行
		var td = "</td>";
		var th = "<tr id='tr_tittle'>" + trs[0].outerHTML.substring(trs[0].outerHTML.indexOf(td) + 5);

		tbody = tbody + th;
		for(var i = 1; i < trs.length; i++) {
			//获取已选中的 tr
			if($("#check" + i).is(':checked')) {
				var tr = "<tr>" + trs[i].outerHTML.substring(trs[i].outerHTML.indexOf(td) + 5);
				tbody = tbody + tr;
			}
		}
		tbody += "</table>";
		//获取标记
		$(".circle").each(function() {
			if(this.outerHTML != null && this.outerHTML != "") {
				tbody += this.outerHTML;
			}
		});
		tbody += "</div>";
		msg = tbody;
	}
	sendMessage(msg, 3);
	$("#div_report").css('display', 'none');
	//解除标记状态
	markCircle(false, "report_main");
	if(drawFlag) {
		$("#mark").click();
	}
}

/***********       查看报告单        **********/
function showMoreImg(num) {
	$(".div_firstDiagnose_sh").find(".item").removeClass("active");
	$(".div_firstDiagnose_sh").find(".item").eq(num).addClass("active");
}

/***********    膳食浮动框        **********/
$(".dietcloseimg").click(function() {
	$(this).parent().css('display', 'none');
});

$(".dietcloseimg1").click(function() {
	$(this).parent().css('display', 'none');
});

function closeparentsbox(e) {
	var parentid = e.target.parentNode.parentNode.getAttribute("id");
	$("#" + parentid).hide();
}

//拖动
$(".dietTestDate").mousedown(function(e) {
	iDiffX = e.pageX - $(this).offset().left;
	iDiffY = e.pageY - $(this).offset().top;
	$(document).mousemove(function(e) {
		$(".dietTestDate").css({
			"left": (e.pageX - iDiffX),
			"top": (e.pageY - iDiffY)
		});
		//当鼠标到浏览器外面时，拖动事件停止
		var iEvent = e || event;
		if(iEvent.clientY > parseInt(window.innerHeight) || iEvent.clientY < 0 || iEvent.clientX < 0 || iEvent.clientX > parseInt(window.innerWidth)) {
			$(document).unbind("mousemove");
		}
	});
});
$(".dietTestDate").mouseup(function() {
	$(document).unbind("mousemove");
});

$(".dragBox").mousedown(function(e) {
	iDiffX = e.pageX - $(this).offset().left;
	iDiffY = e.pageY - $(this).offset().top;
	$(document).mousemove(function(e) {
		$(".testData").css({
			"left": (e.pageX - iDiffX),
			"top": (e.pageY - iDiffY)
		});
		//当鼠标到浏览器外面时，拖动事件停止
		var iEvent = e || event;
		if(iEvent.clientY > parseInt(window.innerHeight) || iEvent.clientY < 0 || iEvent.clientX < 0 || iEvent.clientX > parseInt(window.innerWidth)) {
			$(document).unbind("mousemove");
		}
	});
});
$(".dragBox").mouseup(function() {
	$(document).unbind("mousemove");
});
$(".dietTestDate1").mousedown(function(e) {
	iDiffX = e.pageX - $(this).offset().left;
	iDiffY = e.pageY - $(this).offset().top;
	$(document).mousemove(function(e) {
		$(".dietTestDate1").css({
			"left": (e.pageX - iDiffX),
			"top": (e.pageY - iDiffY)
		});
		//当鼠标到浏览器外面时，拖动事件停止
		var iEvent = e || event;
		if(iEvent.clientY > parseInt(window.innerHeight) || iEvent.clientY < 0 || iEvent.clientX < 0 || iEvent.clientX > parseInt(window.innerWidth)) {
			$(document).unbind("mousemove");
		}
	});
});
$(".dietTestDate1").mouseup(function() {
	$(document).unbind("mousemove");
});


function showTestDateDiettd(id) {
	// 	  $(document).unbind("click");
	$(".dietTestDate").hide();
	$(".dietTestDate1").hide();

	$("#" + id).css('display', 'block');
}

//luoyc 2017-09-27 当前孕周背景颜色改变
function changeColor(week) {
	if(week>5 && week<= 13){
		$("#btn2").css('background','#B8BFC8');
	}
	if(week>13 && week<= 20){
		$("#btn3").css('background','#B8BFC8');
	}
	if(week>20 && week<= 24){
		$("#btn4").css('background','#B8BFC8');
	}
	if(week>24 && week<= 28){
		$("#btn5").css('background','#B8BFC8');
	}
	if(week>28 && week<= 32){
		$("#btn6").css('background','#B8BFC8');
	}
	if(week>32 && week<= 36){
		$("#btn7").css('background','#B8BFC8');
	}
	if(week>36 ){
		$("#btn8").css('background','#B8BFC8');
	}
	$('#arrows').css({'background':'url(images/jiantou2.png) no-repeat','background-size':'94% 80px','background-position':'-10%'});
	$("#btn1").click(function() {
		modalForWeekly(1);
	});
	$("#btn1").css("cursor", "pointer");
	if(week > 5) {
		$("#btn2").find("img").attr("src", "images/6-131.png");
		$("#btn2").click(function() {
			modalForWeekly(2);
		});
		$("#btn2").css("cursor", "pointer");
	}
	if(week > 13) {
		$("#btn3").find("img").attr("src", "images/14-201.png");
		$("#btn3").click(function() {
			modalForWeekly(3);
		});
		$("#btn3").css("cursor", "pointer");
	}
	if(week > 20) {
		$("#btn4").find("img").attr("src", "images/21-241.png");
		$("#btn4").click(function() {
			modalForWeekly(4);
		});
		$("#btn4").css("cursor", "pointer");
	}
	if(week > 24) {
		$("#btn5").find("img").attr("src", "images/25-281.png");
		$("#btn5").click(function() {
			modalForWeekly(5);
		});
		$("#btn5").css("cursor", "pointer");
	}
	if(week > 28) {
		$("#btn6").find("img").attr("src", "images/29-321.png");
		$("#btn6").click(function() {
			modalForWeekly(6);
		});
		$("#btn6").css("cursor", "pointer");
	}
	if(week > 32) {
		$("#btn7").find("img").attr("src", "images/33-361.png");
		$("#btn7").click(function() {
			modalForWeekly(7);
		});
		$("#btn7").css("cursor", "pointer");
	}
	if(week > 36) {
		$("#btn8").find("img").attr("src", "images/37-411.png");
		
		$("#btn8").click(function() {
			modalForWeekly(8);
		});
		$("#btn8").css("cursor", "pointer");
	}
}

//新增退出键  @zhongjl
$('#cancel11,#close').click(function() {
	$('#alert').modal('hide');
});

function fun() {
	$('#alert').modal('show');
	$('#submit11').click(function() {
//		sessionStorage.setItem("src", "../userList/interrogationModule/pendingInquiry.html");
		location.href = '../userList/interrogationModule/pendingInquiry.html';
	});
}
/*运动记录*/
function showrecord() {
	$('#motionTestDateStarch11').show();
	$('#frame').html('')
	//	var mid = sessionStorage.getItem("mid");
	//	var address = "http://192.168.1.38:8080/gravidamanager/";
	//	var mid = 'dg376147';
	addressG = address.replace("doctormanager", "gravidamanager");
	$.ajax({
		type: "get",
		url: addressG + "ExecriseRecord/selectByMid.do",
		async: false,
		data: {
			mid: mid
		},
		success: function(result) {
			var data = result.data;
			if(data != null && data != '') {
				for(i = 0; i < data.length; i++) {
					if(data[i].edate != null) {
						if(i % 2 == 0) {
							var code = '<div class="line">' +
								'<div class="sports_date">' + getDateString(data[i].edate) + '</div>' +
								'<div class="sports_name">' + data[i].ename + '</div>' +
								'<div class="sports_time">' + data[i].etimes + ' 分钟</div>' +
								'</div>';
							$('#frame').append(code);
						}
						if(i % 2 != 0) {
							var code2 = '<div class="line2">' +
								'<div class="sports_date">' + getDateString(data[i].edate) + '</div>' +
								'<div class="sports_name">' + data[i].ename + '</div>' +
								'<div class="sports_time">' + data[i].etimes + ' 分钟</div>' +
								'</div>';
							$('#frame').append(code2);
						}
					} else {
						var code = '<div class="line" style="font-size:14px">暂无运动记录</div>';
						$('#frame').append(code);
						return;
					}
				}
			} else {
				var code = '<div class="line" style="font-size:14px">暂无数据</div>';
				$('#frame').append(code);
				return;
			}
		},
		error: function(e) {
			console.log(JSON.stringify(e))
		}
	});
}
/*膳食习惯*/
function showhabit() {
	var good = [];
	var bad = [];
	//	var address = "http://192.168.1.38:8080/doctormanager/";
	//	var mid = 'dg376147';
	$.ajax({
		type: "post",
		url: address.replace("doctormanager", "gravidamanager") + "foodRecord/queryByMid.do",
		async: false,
		data: {
			mid: mid
		},
		success: function(result) {
			var data = result.data;
			//console.log(JSON.stringify(result))
			if(data != null && data != '') {
				$('#dietTestDateStarch7').show();
				if(data.content != null && data.content != '') {
					bad = data.content.split("~");
					$('.h_left').html('');
					$('.h_right').html('');
					for(i = 0; i < bad.length - 1; i++) {
						if(i % 2 == 0) {
							var code2 = '<div class="h_line">' +
								'<div class="h_img"><img src="images/u14394.png"/></div>' +
								'<div class="h_span"><span>' + bad[i] + '</span></div>' +
								'</div>';
							$('.h_right').append(code2);
						} else {
							var code = '<div class="h_line">' +
								'<div class="h_img"><img src="images/u14396.png"/></div>' +
								'<div class="h_span"><span>' + bad[i] + '</span></div>' +
								'</div>';
							$('.h_left').append(code);
						}
					}
				}
			} else {
				$('#dietTestDateStarch7').hide();
				alert('暂无数据');
			}
		},
		error: function(e) {
			console.log(JSON.stringify(e))
		}
	});
}

var MicroAddress = address.split("doctormanager")[0] + "knowledge/";
var IPURLAddress=address.split("doctormanager")[0];
findVideo();
function findVideo() {
	var html="<div class='check_project8' style='overflow: hidden;'><div class='shiping_tip1' style='margin-top: 9px;'>"+
         "<div id='[id]' class='vod' draggable='true' ondragstart='draglabel1(event)'><div class='tupiantuodongdiv' id='imgsp_drag1' style='background-image: url([imgUrl]);'>"+
         "</div><label style='margin-top: 5px;  font-weight:normal; ' class='health_videoTitle1'>[oldname]</label>"+
         "<div class='problem' style='display: none;'><a id='health_href1' href='#' style='text-decoration:none; color:#333;'>"+
		 "<div class='toptip_patendiv'><div class='top_tip'><label>还有一个视频讲座不错，推荐你看看</label></div><div class='zujiancontent1'>"+
		 "<div class='fvideo' data='[vsrcurl]'></div><img height='55px' width='81px' src='images/videoPlay.jpg' onclick='fvideo(this,[vsrc])'>"+
		 "<div class='conten_botton1'><span class='health_videoTitle1'>[oldname2]</span><div class='collection_div' onclick='collectionFun([data],this)'>收藏</div>"+
		 "</div></div></div></a></div></div></div></div>";
	var url = MicroAddress + "microVideo/find.do";
	var map = {
		"title": $("#search_value").val()
	}
	$.post(url, map, function(result) {
		$("#whole").empty();
		if(result.state == 0) {
			var list = result.data;
			var htm="";
			for(var i = 0; i < list.length; i++) {
				var obj = list[i];
				var imgsrc = IPURLAddress+"knowledgeMedia/MicroVideoPic/" + (obj.titlepic != null ? obj.titlepic : "images/timg.jpg");//显示图片
				htm=html.replace("[oldname]",obj.oldname.substring(0,13)+"...");
				htm=htm.replace("[oldname2]",obj.oldname);
				htm=htm.replace("[imgUrl]",imgsrc);
				htm=htm.replace("[id]","dragid"+i);
				htm=htm.replace("[vsrcurl]",IPURLAddress+"knowledgeMedia/MicroVideo/"+obj.filename);
				htm=htm.replace("[vsrc]",JSON.stringify(obj));
				htm=htm.replace("[data]",JSON.stringify(obj));
				$("#nr8").append(htm);
			}
		}
	});
}
function fvideo(that){
	return false;
}

