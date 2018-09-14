var address = sessionStorage.getItem('address'); 

//var address = "http://192.168.1.38:8080/doctormanager/";
//var mid = 'dg376147';
var g_age;
$(function(){
	weeklyReportPie();
	serviceTypePie();
	adviceReportPie();
	find();
	//查询列表数据
	changeParam()
});

//改变查询的参数
function changeParam() {
	var weeks = $(".weeks").val();
	var sweeks = -1;
	var eweeks = -1;
	try {
		if(weeks != 0) {
			//开始孕周
			var w = weeks.split('-');
			sweeks = w[0];
			eweeks = w[1];
		}
	} catch(e) {
		//TODO handle the exception
	}
	queryParams = {
		'vipGrade': $('.vipGrade').val(),
		'typeId': typeId,
		'birthYears':g_age,
		'sweeks': sweeks, //开始孕周
		'eweeks': eweeks, //结束孕周
		'sortName': 'doctor',
		'sortOrder': 'asc',
		'medicalrecordno': medicalrecordno //病历卡号
	};
}
//搜索功能
function searchList() {
	var gage = $('.g_age').val();
	var age2;
	if(gage != null && gage != ''){
		var myDate = new Date().getFullYear();
	    var births = myDate-gage;
	    age2 = births;
	}else{
		age2 = gage;
	}    
	g_age = age2==''?undefined:age2;
	medicalrecordno = $(".medicalrecordno").val();
	changeParam();
	oTable.Init(queryParams);
}

//查找提醒
function find(){
	$.ajax({
		type:"get",
		url: address + "Reminder/selectReminder.do",
		async:false,
		success:function(result){
			var data = result.data;
			if(data != null && data != ''){
				for(i=0;i<data.length;i++){
					var remindcontent = data[i].remindcontent;
					var name = data[i].remindname;
					var code ='<div class="body_content">'+
								'<div class="list_name">'+name+'</div>'+
								'<div class="list_content">'+remindcontent+'</div>'+
								'<div class="list_operation">'+
								'	<a onclick="update(this);">编辑</a> | <a onclick="deleteMessage(this)">删除</a>'+
								'</div>'+
								'</div>';
					var code2 = '<div class="line">'+
									'<div class="remind_name" style="">'+
										'提醒名称：'+
										'<span>'+name+'</span>'+
									'</div>'+
									'<div class="remind_rule">'+
										'<input onclick="choose(this);" type="checkbox"/>'+
										' <span>按此规则提醒</span>'+
									'</div>'+
								'</div>	';						
					$('.list_body').append(code);
					$('.warning_div').append(code2)
				}
			}
		},
		error:function(e){
			console.log(JSON.stringify(e))
		}
	});
}


//编辑提醒
var u_name;
function update(data){
	$('#update_remind').modal('show');
	u_name = data.parentNode.parentNode.childNodes[0].innerText;
	document.getElementById('update_name').value = u_name;
	
	showData(u_name);//点编辑时，将发送提醒在编辑框显示
	
}
/*点编辑时，将发送提醒在编辑框显示*/
function showData(u_name){
	$('#update_report').prop('checked',false);
	$('#update_self').prop('checked',false);
	var sendway = [];
	var monitoringsuggestion = '';
	$.ajax({
		type:"post",
		url: address + "Reminder/selectByName.do",
		async:false,
		data:{
			remindname: u_name
		},
		success:function(result){
			var data = result.data;
			if(data != null && data != ''){
//				console.log(JSON.stringify(data))
				sendway = data.sendingways.split("~");
				monitoringsuggestion = data.monitoringsuggestion;
			}
		},
		error:function(e){
			console.log(JSON.stringify(e))
		}
	});
	
	if(monitoringsuggestion == "一天早晚提醒两次"){
		$('#t_times').css("border","1px solid dodgerblue");
		$('#o_times').css("border","1px solid lightgray");
		t_times = 2;
	}else if(monitoringsuggestion == "一天提醒一次"){
		$('#o_times').css("border","1px solid dodgerblue");
		$('#t_times').css("border","1px solid lightgray");
		o_times = 2;
	}
	
	for(i=0;i<sendway.length-1;i++){
//		console.log(sendway[i])
		if(sendway[i] == '短信通知'){
			$('#update_message').css("border","1px solid dodgerblue");
			update_message = $('#update_message').text();
			um = 2;
		}
		if(sendway[i] == '微信通知'){
			$('#update_wechat').css("border","1px solid dodgerblue");
			update_wechat = $('#update_wechat').text();
			uw = 2;
		}
		if(sendway[i] == 'App通知'){
			$('#update_app').css("border","1px solid dodgerblue");
			update_app = $('#update_app').text();
			ua = 2;
		}
	}
}
/*编辑后提交*/
$('#update_btn_submit').click(function(){
	var r_content = '';
	var time = '';
	
	var report = document.getElementById('update_report');
	var self = document.getElementById('update_self');
	var r_times = document.getElementById('r_times');//checkbox
	var o_time = document.getElementById('o_times');
	var t_time = document.getElementById('t_times');
	var info = {
		"remindname":u_name,
		"sendingways": remindWay2()
	}
	
	if(r_times.checked == true){
		if(o_time.style.border == "1px solid rgb(30, 144, 255)" && t_time.style.border == "1px solid rgb(30, 144, 255)"){
			alert('只能选择一项！');
			return;
		}else if(o_time.style.border == "1px solid rgb(30, 144, 255)"){
			time = "一天提醒一次";
			info.monitoringsuggestion = time;//提醒次数
		}else if(t_time.style.border == "1px solid rgb(30, 144, 255)"){
			time = "一天早晚提醒两次";
			info.monitoringsuggestion = time;//提醒次数
		}else{
			alert('请选择其中一项~')
			return;
		}
		
	}
	
	if(self.checked == true && report.checked == true){
		r_content = "报告上传完成度低于" + $('#update_report_degree').val() + "," +"自测上传完成度低于" + $('#update_self_degree').val();
		info.remindcontent = r_content;
	}else if(report.checked == true){
		r_content += "报告上传完成度低于" + $('#update_report_degree').val();
		info.remindcontent = r_content;
	}else if(self.checked == true){
		r_content += "自测上传完成度低于" + $('#update_self_degree').val();
		info.remindcontent = r_content;
	}
	
	console.log(JSON.stringify(info))
	$.ajax({
		type:"post",
		url:address + "Reminder/updateByName.do",
		async:false,
		data: info,
		success:function(result){
//				console.log(JSON.stringify(result))
			if(result >= 0){
				alert('编辑成功~');
				window.location.reload();
			}
		},
		error:function(e){
			console.log(JSON.stringify(e));
		}
	});
});


//删除提醒
function deleteMessage(data){
	del();//弹出删除框
	$('#submit22').click(function() {
		var d_name = data.parentNode.parentNode.childNodes[0].innerText;
//		console.log(d_name)
		$.ajax({
			type:"post",
			url:address + "Reminder/deleteByName.do",
			async:false,
			data:{
				remindname:d_name
			},
			success:function(result){
				if(result >= 0){
					window.location.reload();
				}
			},
			error:function(e){
				console.log(JSON.stringify(e));
			}
		});
	});
	
}


/*新增提醒*/
var add_content = '';//提醒内容
$('#btn_submit').click(function(){
	var times = "";//提醒次数
	var a_name = $('#remind_name').val();
	
	//先查询，重名了就不执行新增
	var data;
	$.ajax({
		type:"post",
		url:address + "Reminder/selectByName.do",
		async:false,
		data:{
			"remindname": a_name
		},
		success:function(result){
			data = result.data;
		}
	});
	if(data != null){
		alert("该提醒已存在");
		return;
	}
	
	var report = document.getElementById('report');
	var self = document.getElementById('self');
	var remind_times = document.getElementById('remind_times');
	var one_time = document.getElementById('one_times');
	var two_time = document.getElementById('two_times');
	var info2 = {
		"remindname": a_name,
		"doctorid": 1,
		"acceptedpeople": 1,
		"sendingways": remindWay()//提醒方式
	};
	
	if(a_name == null || a_name == ''){
		alert("请输入提醒名称~");
		return;
	}
	if(report.checked == false && self.checked == false){
		alert('请选择提醒条件~');
		add_content ='';
		return;
	}
	if(remind_times.checked == true){
		if(one_time.style.border == "1px solid rgb(30, 144, 255)" && two_time.style.border == "1px solid rgb(30, 144, 255)"){
			alert('只能选择一项！');
			return;
		}else if(one_time.style.border == "1px solid rgb(30, 144, 255)"){
			times = "一天提醒一次";
			info2.monitoringsuggestion = times;//提醒次数
		}else if(two_time.style.border == "1px solid rgb(30, 144, 255)"){
			times = "一天早晚提醒两次";
			info2.monitoringsuggestion = times;//提醒次数
		}else{
			alert('请选择其中一项~')
			return;
		}
		
	}
	
	if(report.checked == true){
		add_content += "报告上传完成度低于" + $('#report_degree').val();
	}
	if(self.checked == true){
		add_content += "自测上传完成度低于" + $('#self_degree').val();
	}
	if(self.checked == true && report.checked == true){
		add_content = "报告上传完成度低于" + $('#report_degree').val() + "," +"自测上传完成度低于" + $('#self_degree').val();
	}
	info2.remindcontent = add_content;//提醒内容
	
	
	$.ajax({
		type: "post",
		url: address + "Reminder/insertSelective.do",
		async: false,
		data: info2,
		success:function(result){
			if(result >= 0){
				alert('新建成功~');
				window.location.reload();
			}
		},
		error:function(e){
			console.log(JSON.stringify(e));
		}
	});
});


/*自定义提醒*/
var selftestdetails = '';//提醒自测内容
var sendperson = '';//信息接收人
$("#submit11").click(function(){
	var Msgdata=getNoticeContent();//自测提醒 
	
	if(rule == undefined){//按规则提醒，用于判断按规则提醒是否有勾选，有勾选就不执行
		//发送对象的mid
		var a = $("#user_list").bootstrapTable('getSelections');
		for(j=0;j<a.length;j++){
			var mId = a[j].mId;
			var sendway = '';//提醒方式，下次循环要清空，否则会一直拼接
			if($('#weChat_alerts').is(':checked')){
				pushWeChatMsg(mId,1,Msgdata)
				sendway += "微信通知~";//拼接提醒方式
			}
			if($('#app_alerts').is(':checked')){
				pushAppMsg(mId,1,Msgdata)
				sendway += "APP通知~";//拼接提醒方式
			}
			if($('#sms_alerts').is(':checked')){
				pushSmsMsg(mId,1,Msgdata)
				sendway += "短信通知~";//拼接提醒方式
			}
		
			var info4 = {
				"mid":mId,
				"doctorid": 1,
				"sendingways":sendway,//发送方式
				"acceptedpeople": sendperson,//接收人
				"selftestdetails":selftestdetails,//自测内容
				"monitoringsuggestion":Msgdata.adviceCont,//监测建议
				"uploadDate": getdate(),
				"remindcontent": ''
			};
			console.log(JSON.stringify(info4))
			//点击发送后要把数据存到数据库
			var state;
			$.ajax({
				type: "post",
				url: address + "Reminder/insertSelective.do",
				async: false,
				data: info4,
				success:function(result){
					state = result;
					if(result >= 0){
						console.log("插入成功")
						
					}
				},
				error:function(e){
					console.log(JSON.stringify(e));
				}
			});
		} 
		if(state >= 0){
			alert('发送成功~');
			window.location.reload();
		}
	}
	
})


/*发送提醒框内点击checkbox后获取对应的内容*/
var sendways;
var s_content;
var s_box;
function choose(box){
	s_box = box;
	if(box.checked == true){
		var t_name = box.parentNode.parentNode.childNodes[0].childNodes[1].innerText;
//		console.log(t_name)
		
		$.ajax({
			type:"post",
			url: address + "Reminder/selectByName.do",
			async:false,
			data:{
				remindname: t_name
			},
			success:function(result){
				var remind = result.data;
				sendways = remind.sendingways.split("~");//获取发送方式
				s_content = remind.remindcontent;//获取提醒内容
			},
			error:function(e){
				console.log(JSON.stringify(e))
			}
		});
	}
}
//发送提醒判断
function sendMsg() {
	var a = $("#user_list").bootstrapTable('getSelections');//获取选中用户的所有信息
	if(a.length <= 0) {
		alert("请选中一行")
		return;
	} else {
		$('#alert').modal('show');
//		console.log(JSON.stringify(a))
//		console.log(a.length)
	}
}
/*按规则提醒*/
var rule;//按规则提醒的提醒内容
$('#submit11').click(function(){
	if(s_box == undefined){
		return;
	}
	if(s_box.checked == true){
		s_content = s_content.replace(",","，");
		s_content = s_content.replace(/%/g,"%25");//  /%/g是将所有 % 替换
		rule = getNormalPushMsg("温馨", s_content);
		var a = $("#user_list").bootstrapTable('getSelections');
		var remind = getNoticeContent();//自定义提醒，用于判断自定义是否有勾选
		if(remind.selfTestCont == '' && remind.adviceCont == ''){//有勾选就不执行按规则提醒
			var state;
			for(j=0;j<a.length;j++){
				var mId = a[j].mId;
				for(i=0;i<sendways.length-1;i++){
					var sendway = '';//提醒方式，下次循环要清空，否则会一直拼接
					if(sendways[i] == '短信通知'){
						console.log('短信通知')
						pushSmsMsg(mId, 3, rule)
						sendway += "短信通知~";//拼接提醒方式
					}
					if(sendways[i] == '微信通知'){
						console.log('微信通知')
						rule.title = '温馨提示';
						pushWeChatMsg(mId, 3, rule)
						sendway += "微信通知~";//拼接提醒方式
					}
					if(sendways[i] == 'App通知'){
						console.log('App通知')
						pushAppMsg(mId, 3, rule)
						sendway += "APP通知~";//拼接提醒方式
					}
				}
				
				var info3 = {
					"mid":mId,
					"doctorid": 1,
					"sendingways":sendway,//发送方式
					"acceptedpeople": '孕妇本人',//接收人
					"selftestdetails":'',//自测内容
					"monitoringsuggestion":'',//监测建议
					"uploadDate": getdate(),//最新的发送日期
					"remindcontent": s_content
				};
				$.ajax({
					type: "post",
					url: address + "Reminder/insertSelective.do",
					async: false,
					data: info3,
					success:function(result){
						state = result;
						if(result >= 0){
							console.log("插入成功")
							window.location.reload();
						}
					},
					error:function(e){
						console.log(JSON.stringify(e));
					}
				});
			}
			if(state >= 0){
				alert('发送成功~');
				window.location.reload();
			}

		} else {
			alert("只能选择按规则或自定义其中一种方式提醒~");
			window.location.reload();
		}
	}
});




/*发送提醒记录*/
var id;//mid
function showrecord(data){
	$('#record').modal('show');
	id = data;
	$.ajax({
		type:"post",
		url: address + "Reminder/selectByMid.do",
		async:false,
		data:{
			mid:data
		},
		success:function(result){
			if(result.data != '' && result.data != null){
				
				$('#frame1').show();
				$('#frame2').hide();
				
				var length = result.data.length;
				var msg = result.data[length-1];//取最新的一条
				//最近发送时间
				$('#uploadDate').html(msg.uploadDate);
				//发送提醒内容
				if(msg.remindcontent == '' || msg.remindcontent == null){
					$('#remindcontent').html('暂无数据');
				}else{
					$('#remindcontent').html(msg.remindcontent.replace(/%25/g,'%'));
				}
				//自测内容
				if(msg.selftestdetails != '' && msg.selftestdetails != null){
					var self = msg.selftestdetails.split('~');
					var code = '';
					for(i=0;i<self.length;i++){
						if(self[i] == '血压检测'){
							code += '<div class="r_test">'+
										'<div class="test_title" >'+ self[i] +'</div>'+
										'<div class="test_content">每日一次定时血压测量</div>'+
									'</div>';
						}
						if(self[i] == '体重检测'){
							code += '<div class="r_test">'+
										'<div class="test_title" >'+ self[i] +'</div>'+
										'<div class="test_content">每日一次定时体重检测</div>'+
									'</div>';
						}
						if(self[i] == '尿液检测'){
							code += '<div class="r_test">'+
										'<div class="test_title" >'+ self[i] +'</div>'+
										'<div class="test_content">每日一次定时尿液检测</div>'+
									'</div>';
						}
						if(self[i] == '胎动检测'){
							code += '<div class="r_test">'+
										'<div class="test_title" >'+ self[i] +'</div>'+
										'<div class="test_content">每日一次定时胎动检测</div>'+
									'</div>';
						}
						if(self[i] == '胎心检测'){
							code += '<div class="r_test">'+
										'<div class="test_title" >'+ self[i] +'</div>'+
										'<div class="test_content">每日一次定时胎心测量</div>'+
									'</div>';
						}
						if(self[i] == '血糖检测:每日检查7次（即三餐前30分钟，三餐后2小时和夜间24点血糖检查）'){
							code += '<div class="r_test">'+
										'<div class="test_title" >血糖检测</div>'+
										'<div class="test_content">每日检查7次（即三餐前30分钟，三餐后2小时和夜间24点血糖检查</div>'+
									'</div>';
						}
						if(self[i] == '血糖检测:连续24小时动态血糖监测，连续监测7日（即三餐前30分钟，三餐后2小时和夜间24点血糖检查）'){
							code += '<div class="r_test">'+
										'<div class="test_title" >血糖检测</div>'+
										'<div class="test_content">连续24小时动态血糖监测，连续监测7日（即三餐前30分钟，三餐后2小时和夜间24点血糖检查）</div>'+
									'</div>';
						}
						$('#selftestdetails').html(code)
					}
				}else{
					$('#selftestdetails').html('暂无数据');
				}
				//监测建议
				if(msg.monitoringsuggestion == '' || msg.monitoringsuggestion == null){
					$('#monitoringsuggestion').html('暂无数据');
				}else{
					$('#monitoringsuggestion').html(msg.monitoringsuggestion);
				}
				//接收人
				if(msg.acceptedpeople != '' && msg.acceptedpeople != null){
					var people = msg.acceptedpeople.split('~');
					var code2 = '';
					for(i=0;i<people.length;i++){
						if(people[i] == '孕妇本人'){
							code2 += '<div class="send">'+ people[i] +'</div>'
						}
						if(people[i] == '丈夫'){
							code2 += '<div class="send">'+ people[i] +'</div>'
						}
						if(people[i] == '看护人'){
							code2 += '<div class="send">'+ people[i] +'</div>'
						}
						$('#acceptedpeople').html(code2)
					}
				}
				//提醒方式
				if(msg.sendingways != '' && msg.sendingways != null){
					var way = msg.sendingways.split('~')
					var code3 = '';
					for(i=0;i<way.length;i++){
						if(way[i] == '短信通知'){
							code3 += '<div class="send">'+ way[i] +'</div>'
						}
						if(way[i] == 'APP通知'){
							code3 += '<div class="send">'+ way[i] +'</div>'
						}
						if(way[i] == '微信通知'){
							code3 += '<div class="send">'+ way[i] +'</div>'
						}
						$('#sendingways').html(code3)
					}
				}
				
			} else {
				//无数据时
				$('#frame1').hide()
				$('#frame2').show()
				var code =  '<div style="text-align: center;font-size:15px;line-height:30px;">暂无提醒</div>';
				$('#frame2').html(code)
			}
			
		}
	});
}
/*再次提醒*/
$('#send_again').click(function(){
	var selfTestCont = '';//自测项目提醒
	var adviceCont;//监测建议
	var data;
	$.ajax({
		type:"post",
		url: address + "Reminder/selectByMid.do",
		async:false,
		data:{
			mid:id
		},
		success:function(result){
			var length = result.data.length;
			data = result.data[length-1];//取最新的一条
//			console.log(JSON.stringify(data))
			
		}
	});
	
	var relationIds = [];//接收人
	var acceptedpeople = data.acceptedpeople.split('~');
	for(i=0;i<acceptedpeople.length;i++){
		if(acceptedpeople[i] == '孕妇本人'){
			relationIds.push(1);
		}
		if(acceptedpeople[i] == '丈夫'){
			relationIds.push(2);
		}
		if(acceptedpeople[i] == '看护人'){
			relationIds.push(3);
		}
	}
	//如果自测内容和监测建议不为空,就发送自定义提醒的内容
	if(data.monitoringsuggestion != null || data.selftestdetails != null){
		//监测建议
		adviceCont = data.monitoringsuggestion;
		//自测内容
		var selfs = data.selftestdetails.split('~');
		for(i=0;i<selfs.length;i++){	
			//console.log(selfs[i])	
			if(selfs[i] == '血压检测'){
				selfTestCont += "血压检测:每日一次定时血压测量" + "。\r\n";
			}
			if(selfs[i] == '体重检测'){
				selfTestCont += "体重检测:每日一次定时体重检测" + "。\r\n";
			}
			if(selfs[i] == '尿液检测'){
				selfTestCont += "尿液检测:每日一次定时尿液检测" + "。\r\n";
			}
			if(selfs[i] == '胎动检测'){
				selfTestCont += "胎动检测:每日一次定时胎动检测" + "。\r\n";
			}
			if(selfs[i] == '胎心检测'){
				selfTestCont += "胎心检测:每日一次定时胎心检测" + "。\r\n";
			}
			if(selfs[i] == '血糖检测:每日检查7次（即三餐前30分钟，三餐后2小时和夜间24点血糖检查）'){
				selfTestCont += "血糖检测:每日检查7次（即三餐前30分钟，三餐后2小时和夜间24点血糖检查）" + "。\r\n";
			}
			if(selfs[i] == '血糖检测:连续24小时动态血糖监测，连续监测7日（即三餐前30分钟，三餐后2小时和夜间24点血糖检查）'){
				selfTestCont += "血糖检测:连续24小时动态血糖监测，连续监测7日（即三餐前30分钟，三餐后2小时和夜间24点血糖检查）" + "。\r\n";
			}
		}
		//存储自测提醒信息的对象
		var Msgdata = {
			"selfTestCont": selfTestCont,//自测项目提醒
			"adviceCont":adviceCont,//监测建议
			"relationIds": relationIds//发送人
		}
	}
	
	//如果发送提醒内容不为空就根据按规则提醒方式发送
	if(data.remindcontent != null && data.remindcontent != ''){
		var Msgdata = {
			"title": "温馨提示",
			"content": data.remindcontent,
			"relationIds": relationIds
		}
	}
	
	var ways = data.sendingways.split('~');
	for(i=0;i<ways.length;i++){
		if(ways[i] == '微信通知'){
			console.log("微信通知")
			pushWeChatMsg(id,1,Msgdata)
		}
		if(ways[i] == 'APP通知'){
			console.log("APP通知")
			pushAppMsg(id,1,Msgdata)
		}
		if(ways[i] == '短信通知'){
			console.log("短信通知")
			pushSmsMsg(id,1,Msgdata)
		}
	}
	
});
















//获取自测提醒信息
function getNoticeContent() {
	var selfTestCont = ""; //自测项目提醒
	var adviceCont = ""; //监测建议

	if($('#selfTestNotice1').is(':checked')) {
		var pressure = $("#pressureCont").val();
		if(pressure == 0) {
			selfTestCont = selfTestCont + "血糖检测:每日检查7次（即三餐前30分钟，三餐后2小时和夜间24点血糖检查）" + "。\r\n";
		} else if(pressure == 1) {
			selfTestCont = selfTestCont + "血糖检测:连续24小时动态血糖监测，连续监测7日（即三餐前30分钟，三餐后2小时和夜间24点血糖检查）" + "。\r\n";
		}else if(pressure == 3){
			selfTestCont = selfTestCont + "血压检测:每日早晚各一次血压检测" + "。\r\n";
		}else if(pressure == 4){
			selfTestCont = selfTestCont + "血压检测:每日早晚各一次血压检测，连续测量7天" + "。\r\n";
		}else if(pressure == 5){
			selfTestCont = selfTestCont + "血压检测:连续24小时动态血压检测，连续测量7天" + "。\r\n";
		}
		selftestdetails += selfTestCont.replace('。\r\n','~');//拼接自测内容
	}
	for(var i = 2; i < 7; i++) {
		if($('#selfTestNotice' + i).is(':checked')) {
			selfTestCont = selfTestCont + $(".NoticeItem" + i).html() + ":" + $(".NoticeCont" + i).html() + "。\r\n";
			selftestdetails += $(".NoticeItem" + i).html() + '~';//拼接自测内容
		}
	}

	adviceCont = $("#thisAdvice_content").val();
	var relationIds = [];
	for(var j = 1; j < 4; j++) {
		if($('#sendPerson' + j).is(':checked')) {
			relationIds.push(j);
			if(j == 1){
				sendperson += '孕妇本人';//拼接接收人
			}
			if(j == 2){
				sendperson += '~丈夫';
			}
			if(j == 3){
				sendperson += '~看护人';
			}
		}
	}
	//存储自测提醒信息的对象
	var Msgdata = {
		"selfTestCont": selfTestCont,//自测项目提醒
		"adviceCont":adviceCont,//监测建议
		"relationIds": relationIds//发送人
	}
	return Msgdata;

}
//获取普通提醒信息内容
function getNormalPushMsg(title,content){
//	var relationIds = [];
//	for(var j = 1; j < 4; j++) {
//		if($('#sendPerson' + j).is(':checked')) {
//	relationIds.push(1);
//		}
//	}
	//存储提醒信息内容的对象
	var Msgdata = {
		"title": title,
		"content": content,
		"relationIds": 1
	}
	return Msgdata;
}
function getdate(){
	//当前时间
	var date = new Date();
	var minutes = date.getMinutes();
	if(minutes<10){
		minutes = "0" + minutes;
	}
	var second = date.getSeconds();
	if(second<10){
		second = "0" + second;
	}
	var now = date.getFullYear() +"-"+ (date.getMonth()+1) +"-"+ date.getDate() +" "+ date.getHours() +":"+ minutes +":"+ second;
	
	return now;
}
/*新增提醒---提醒方式的拼接*/
var message;//短信通知
var wechat;//微信通知
var app;//app通知
function remindWay(){
	var str = [];
	var send = '';
	if(message != null && message != ''){
		str.push(message);
	}
	if(wechat != null && wechat != ''){
		str.push(wechat);
	}
	if(app != null && app != ''){
		str.push(app);
	}
	for(i=0;i<str.length;i++){
		send += str[i] + '~';
	}
	return send;
}
/*编辑提醒---提醒方式的拼接*/
var update_message;
var update_wechat;
var update_app;
function remindWay2(){
	var str = [];
	var send2 = '';
	if(update_message != null && update_message != ''){
		str.push(update_message);
	}
	if(update_wechat != null && update_wechat != ''){
		str.push(update_wechat);
	}
	if(update_app != null && update_app != ''){
		str.push(update_app);
	}
	for(i=0;i<str.length;i++){
		send2 += str[i] + '~';
	}
	return send2;
}
/*提醒方式的选择和取消事件*/
var m = 1;//新增--短信
var w = 1;//新增--微信
var a = 1;//新增--app
var um = 1;//编辑--短信
var uw = 1;//编辑--微信
var ua = 1;//编辑--app
function changeback(index){
	switch(index){
		case 1:
			if(m == 1){
				$('#message').css("border","1px solid dodgerblue");
				message = $('#message').text();
				m = 2;
				break;
			}else{
				$('#message').css("border","1px solid lightgray");
				message = '';
				m = 1;
				break;
			}
		case 2:
			if(w == 1){
				$('#wechat').css("border","1px solid dodgerblue");
				wechat = $('#wechat').text();
				w = 2;
				break;	
			}else{
				$('#wechat').css("border","1px solid lightgray");
				wechat = '';
				w = 1;
				break;
			}
		case 3:
			if(a == 1){
				$('#app').css("border","1px solid dodgerblue");
				app = $('#app').text();
				a = 2;
				break;	
			}else{
				$('#app').css("border","1px solid lightgray");
				app = '';
				a = 1;
				break;
			}
		case 4:
			if(um == 1){
				$('#update_message').css("border","1px solid dodgerblue");
				update_message = $('#update_message').text();
				um = 2;
				break;
			}else{
				$('#update_message').css("border","1px solid lightgray");
				update_message = '';
				um = 1;
				break;
			}
		case 5:
			if(uw == 1){
				$('#update_wechat').css("border","1px solid dodgerblue");
				update_wechat = $('#update_wechat').text();
				uw = 2;
				break;	
			}else{
				$('#update_wechat').css("border","1px solid lightgray");
				update_wechat = '';
				uw = 1;
				break;
			}
		case 6:
			if(ua == 1){
				$('#update_app').css("border","1px solid dodgerblue");
				update_app = $('#update_app').text();
				ua = 2;
				break;	
			}else{
				$('#update_app').css("border","1px solid lightgray");
				update_app = '';
				ua = 1;
				break;
			}
	}
}
/*提醒次数的选择和取消事件*/
var o_times = 1;
var t_times = 1;
var one_times = 1;
var two_times = 1;
function changeback2(index){
	switch(index){
		case 1:
			if(o_times == 1){
				$('#o_times').css("border","1px solid dodgerblue");
				o_times = 2;
				break;
			}else{
				$('#o_times').css("border","1px solid lightgray");
				o_times = 1;
				break;
			}
		case 2:
			if(t_times == 1){
				$('#t_times').css("border","1px solid dodgerblue");
				t_times = 2;
				break;
			}else{
				$('#t_times').css("border","1px solid lightgray");
				t_times = 1;
				break;
			}
		case 3:
			if(one_times == 1){
				$('#one_times').css("border","1px solid dodgerblue");
				one_times = 2;
				break;
			}else{
				$('#one_times').css("border","1px solid lightgray");
				one_times = 1;
				break;
			}
		case 4:
			if(two_times == 1){
				$('#two_times').css("border","1px solid dodgerblue");
				two_times = 2;
				break;
			}else{
				$('#two_times').css("border","1px solid lightgray");
				two_times = 1;
				break;
			}
	}
}
//全选发送
function selectAllSend() {
	if($('.send_selectAll').is(':checked')) {
		$(".select_gravida").prop("checked", true);
		$(".select_husband").prop("checked", true);
		$(".select_orderlies").prop("checked", true);
		$(".select_other").prop("checked", true);
		$("#sms_alerts").prop("checked", true);
		$("#app_alerts").prop("checked", true);
		$("#weChat_alerts").prop("checked", true);
	} else {
		$(".select_gravida").prop("checked", false);
		$(".select_husband").prop("checked", false);
		$(".select_orderlies").prop("checked", false);
		$(".select_other").prop("checked", false);
		$("#sms_alerts").prop("checked", false);
		$("#app_alerts").prop("checked", false);
		$("#weChat_alerts").prop("checked", false);
	}
}
/*----------------------------点击显示或隐藏的事件--------------------------------*/
//关闭发送提醒弹出框
$('#cancel11,#close').click(function() {
	$('#alert').modal('hide');
});
//关闭新增提醒弹出框
$('#btn_cancel,#close2').click(function() {
	$('#write_remind').modal('hide');
});
//关闭编辑提醒弹出框
$('#update_btn_cancel,#close3').click(function() {
	$('#update_remind').modal('hide');
	/*点取消后去除选定边框*/
	um = 1;//编辑--短信
	uw = 1;//编辑--微信
	ua = 1;//编辑--app
	$('#update_message').css("border","1px solid lightgray");
	$('#update_wechat').css("border","1px solid lightgray");
	$('#update_app').css("border","1px solid lightgray");
});
//进入提醒管理页面
$('#remind_manage_btn').click(function(){
	$('.main_content').hide();
	$('.remind_manage').show();
});
//从提醒管理页面返回
$('#backoff').click(function(){
	$('.main_content').show();
	$('.remind_manage').hide();
});

function fun(index) {
	switch(index){
		case 1:
			//显示发送提醒弹出框
			sendMsg();
			break;
		case 2:
			//显示新增提醒弹出框
			$('#write_remind').modal('show');
			break;
	}
}
//关闭删除提醒弹出框
$('#cancel22,#close4').click(function() {
	$('#delete').modal('hide');
});
//点击删除显示弹出框
function del() {
	$('#delete').modal('show');
}
var i = 1;
var j = 1;
function hide(index){
	switch(index){
		case 1:
			if(i == 1){
				$('.warning_div').show();
				$('#down').show();
				$('#up').hide();
				i = 2;
			} else {
				$('.warning_div').hide();
				$('#down').hide();
				$('#up').show();
				i = 1;
			}
			break;
		case 2:
			if(j == 1){
				$('.content_Notice').hide();
				$('#down2').hide();
				$('#up2').show();
				j = 2;
			} else {
				$('.content_Notice').show();
				$('#down2').show();
				$('#up2').hide();
				j = 1;
			}
			break;
	}
	
}

$('#close5').click(function(){
	$('#record').modal('hide');
})
/*---------------------------------------------------------------------------------*/
