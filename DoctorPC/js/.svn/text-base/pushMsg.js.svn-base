/****  消息推送js  @yinzx*****/

var address = sessionStorage.getItem("address");
//var address="http://192.168.1.38:8080/doctormanager/";
/*********    消息推送直接发送至孕妇端后台处理    *********/
var addressURL;
if(address!=null){
   addressURL=address.split("doctormanager")[0]+"gravidamanager/";

}else{
   addressURL="http://192.168.1.43:8080/gravidamanager/";
 
}


var mid=sessionStorage.getItem("mid");
if(mid==null){
	mid="dg000001";
}

/**********         确定发送推送  自测提醒                        *********/
$("#submit").click(function(){
	//自测提醒 
	var Msgdata=getNoticeContent();
	//发送对象的mid
	var mid=$("#send_mid").val();
	//mid="dg000001";
	if($('#weChat_alerts').is(':checked')){
		console.log("微信通知")
		pushWeChatMsg(mid,1,Msgdata)
	}
	if($('#app_alerts').is(':checked')){
		console.log("app通知")
		pushAppMsg(mid,1,Msgdata)
	}
	if($('#sms_alerts').is(':checked')){
		console.log("短信通知")
		pushSmsMsg(mid,1,Msgdata)
	}
	
	
})
/**********            确定发送推送  普通消息提醒                         *********/
$("#NormalMsgSubmit").click(function(){
    //发送普通消息
    var title="温馨小贴士";
    var content="尊敬的用户，您尚未完善建档信息，请尽快完善信息 "
	var Msgdata=getNormalPushMsg(title,content);
	
	//发送对象的mid
	var mid=$("#send_mid").val();
	//mid="dg000001";
	if($('#weChat_alerts').is(':checked')){
		pushWeChatMsg(mid,3,Msgdata)
	}
	if($('#app_alerts').is(':checked')){
		
		pushAppMsg(mid,3,Msgdata)
	}
	if($('#sms_alerts').is(':checked')){
		pushSmsMsg(mid,3,Msgdata)
	}

})

//取消发送  取消全部checkbox
$("#cancelSubmit").click(function(){
	$("input[type='checkbox']").prop("checked", false);
})

//app、微信 只发送给孕妇
$("input[type='checkbox']").bind('click',function(){
	var flag=true;
	for(var j = 2; j < 5; j++) {
		if($('#sendPerson' + j).is(':checked')) {
			flag=false;
		}
	}
	if(!flag){
	 //若选中 孕妇以外的对象 只能发送短信
		$('#app_alerts').prop("checked", false); 
		$('#weChat_alerts').prop("checked", false);
		$('#app_alerts').attr("disabled",true);
		$('#weChat_alerts').attr("disabled",true);

	}else{
		$('#app_alerts').attr("disabled",false);
		$('#weChat_alerts').attr("disabled",false);
	}
})



/**
 * 发送微信消息提醒
 * mid：孕妇mid
 * relationIds 为数组int[]存放需发送对象的relationId: 1:孕妇本人，2:丈夫， 3:看护人， 4:其他亲属
 * type 发送消息类型，1：自测提醒通知，2：医嘱建议，3：普通消息通知
 * 
 */
function pushWeChatMsg(mid, type, Msgdata) {
	switch(type) {
		case 1:
			// 自测提醒通知
           var selfTestCont=Msgdata.selfTestCont; //自测项目提醒
           var adviceCont=Msgdata.adviceCont ; //监测建议
           var relationIds=[];
           relationIds=Msgdata.relationIds;
			$.ajax({
				type: "post",
				url: addressURL + "weChat/pushNotification.do",
				data: {
					"mid": mid,
					"relationIds": relationIds,
					"selfTestCont": selfTestCont,
					"adviceCont": adviceCont
				},
				async: false,
				traditional: true,
				 
				dataType: "json",
				success: function(e) {
					/*var msg=e;
					if(msg!=-1){
						alert("微信通知发送成功");
					}else{
						alert("微信通知发送失败");
					}*/
				},
				error: function() {

				}
			});
			break;
		case 2:
			//发送医嘱建议
		    var relationIds=[];
             relationIds=Msgdata.relationIds;
            var DocAdviceCont=Msgdata.DocAdviceCont ; 
			$.ajax({
				type: "post",
				url: addressURL + "weChat/pushAdvice.do",
				data: {
					"mid": mid,
					"relationIds": relationIds,
					"DocAdviceCont": DocAdviceCont
				},
				async: false,
				traditional: true,
				 
				dataType: "json",
				success: function(e) {
					/*var msg=e;
					if(msg!=-1){
						alert("微信通知发送成功");
					}else{
						alert("微信通知发送失败");
					}*/
				},
				error: function() {

				}
			});
			break;
		case 3:
		//发送普通消息
		 var title=Msgdata.title ; 
		 var content=Msgdata.content;
		  var relationIds=[];
            relationIds=Msgdata.relationIds;
			$.ajax({
				type: "post",
				url: addressURL + "weChat/pushNormalMsg.do",
				data: {
					"mid": mid,
					"relationIds": relationIds,
					"title": title,
					"content": content
				},
				async: false,
				traditional: true,
				// 
				dataType: "json",
				success: function(e) {
					/*var msg=e;
					if(msg!=-1){
						alert("微信通知发送成功");
					}else{
						alert("微信通知发送失败");
					}*/
				},
				error: function() {

				}
			});
		    break;
	}
}

/**
 * 发送短信消息提醒
 * mid：孕妇mid
 * relationIds 为数组int[]存放需发送对象的relationId: 1:孕妇本人，2:丈夫， 3:看护人， 4:其他亲属
 * type 发送消息类型，1：自测提醒通知，2：医嘱建议，3：普通消息通知
 * 
 */
function pushSmsMsg(mid, type, Msgdata) {
	switch(type) {
		case 1:
			// 自测提醒通知
           var selfTestCont=Msgdata.selfTestCont; //自测项目提醒
           var adviceCont=Msgdata.adviceCont ; //监测建议
           var relationIds=[];
           relationIds=Msgdata.relationIds;
			$.ajax({
				type: "post",
				url: addressURL + "smsPush/pushNotification.do",
				data: {
					"mid": mid,
					"relationIds": relationIds,
					"selfTestCont": selfTestCont,
					"adviceCont": adviceCont
				},
				async: false,
				traditional: true,
				 
				dataType: "json",
				success: function(e) {
					/*var msg=e;
					alert("短信通知发送成功");*/
					
				},
				error: function() {

				}
			});
			break;
		case 2:
			//发送医嘱建议
		    var relationIds=[];
             relationIds=Msgdata.relationIds;
            var DocAdviceCont=Msgdata.DocAdviceCont ; 
			$.ajax({
				type: "post",
				url: addressURL + "smsPush/pushAdvice.do",
				data: {
					"mid": mid,
					"relationIds": relationIds,
					"DocAdviceCont": DocAdviceCont
				},
				async: false,
				traditional: true,
				 
				dataType: "json",
				success: function(e) {
					/*var msg=e;
					alert("短信通知发送成功");*/
				},
				error: function() {

				}
			});
			break;
		case 3:
		//发送普通消息
		var title=Msgdata.title ; 
		 var content=Msgdata.content;
		  var relationIds=[];
            relationIds=Msgdata.relationIds;
			$.ajax({
				type: "post",
				url: addressURL + "smsPush/pushNormalMsg.do",
				data: {
					"mid": mid,
					"relationIds": relationIds,
					"title": title,
					"content": content
				},
				async: false,
				//contentType:"charset=utf-8",
				traditional: true,
				
				dataType: "json",
				success: function(e) {
					/*var msg=e;
					alert("短信通知发送成功");*/
					
				},
				error: function() {

				}
			});
		    break;
	}
}

/**
 * 发送App消息提醒
 * mid：孕妇mid
 * relationIds 为数组int[]存放需发送对象的relationId: 1:孕妇本人，2:丈夫， 3:看护人， 4:其他亲属
 * type 发送消息类型，1：自测提醒通知，2：医嘱建议，3：普通消息通知
 * 
 */
function pushAppMsg(mid, type, Msgdata) {
	switch(type) {
		case 1:
			// 自测提醒通知
           var selfTestCont=Msgdata.selfTestCont; //自测项目提醒
           var adviceCont=Msgdata.adviceCont ; //监测建议
           var relationIds=[];
           relationIds=Msgdata.relationIds;
			$.ajax({
				type: "post",
				url: addressURL + "appPush/pushNotification.do",
				data: {
					"mid": mid,
					"relationIds": relationIds,
					"selfTestCont": selfTestCont,
					"adviceCont": adviceCont
				},
				async: false,
				traditional: true,
				 
				dataType: "json",
				success: function(e) {
					/*var msg=e;
					if(msg!=-1){
						alert("App通知发送成功");
					}else{
						alert("App通知发送失败");
					}*/
					
				},
				error: function() {

				}
			});
			break;
		case 2:
			//发送医嘱建议
		    var relationIds=[];
             relationIds=Msgdata.relationIds;
            var DocAdviceCont=Msgdata.DocAdviceCont ; 
			$.ajax({
				type: "post",
				url: addressURL + "appPush/pushAdvice.do",
				data: {
					"mid": mid,
					"relationIds": relationIds,
					"DocAdviceCont": DocAdviceCont
				},
				async: false,
				traditional: true,
				 
				dataType: "json",
				success: function(e) {
					/*var msg=e;
					if(msg!=-1){
						alert("App通知发送成功");
					}else{
						alert("App通知发送失败");
					}*/
				},
				error: function() {

				}
			});
			break;
		case 3:
		//发送普通消息
		var title=Msgdata.title ; 
		 var content=Msgdata.content;
		  var relationIds=[];
            relationIds=Msgdata.relationIds;
			$.ajax({
				type: "post",
				url: addressURL + "appPush/pushNormalMsg.do",
				data: {
					"mid": mid,
					"relationIds": relationIds,
					"title": title,
					"content": content
				},
				async: false,
				//contentType:"charset=utf-8",
				traditional: true,
				
				dataType: "json",
				success: function(e) {
					var msg=e;
					/*if(msg!=-1){
						alert("App通知发送成功");
					}else{
						alert("App通知发送失败");
					}*/
				},
				error: function() {

				}
			});
		    break;
	}
}
/*********   获取页面需要发送的提醒消息内容        *********/


//获取自测提醒信息
function getNoticeContent() {
	var selfTestCont = ""; //自测项目提醒
	var adviceCont = ""; //监测建议

	if($('#selfTestNotice1').is(':checked')) {
		var pressure = $("#pressureCont").val();
		if(pressure == 0) {
			selfTestCont = selfTestCont + "血糖检测  每日检查7次（即三餐前30分钟，三餐后2小时和夜间24点血糖检查）" + "\r\n";
		} else if(pressure == 1) {
			selfTestCont = selfTestCont + "血糖检测 每日检查7次（即三餐前30分钟，三餐后2小时和夜间24点血糖检查）" + "\r\n";
		}else if(pressure == 3){
			selfTestCont = selfTestCont + "血压检测 每日早晚各一次血压检测" + "\r\n";
		}else if(pressure == 4){
			selfTestCont = selfTestCont + "血压检测 每日早晚各一次血压检测，连续测量7天" + "\r\n";
		}else if(pressure == 5){
			selfTestCont = selfTestCont + "血压检测 连续24小时动态血压检测，连续测量7天" + "\r\n";
		}
	}
	for(var i = 2; i < 7; i++) {
		if($('#selfTestNotice' + i).is(':checked')) {
			selfTestCont = selfTestCont + $(".NoticeItem" + i).html() + " " + $(".NoticeCont" + i).html() + "\r\n";
		}
	}

	adviceCont = $("#thisAdvice_content").val();
	var relationIds = [];
	for(var j = 1; j < 4; j++) {
		if($('#sendPerson' + j).is(':checked')) {
			relationIds.push(j);
		}
	}
	//存储自测提醒信息的对象
	var Msgdata = {
		"selfTestCont": selfTestCont,
		"adviceCont": adviceCont,
		"relationIds": relationIds
	}
	return Msgdata;

}

//获取医嘱提醒信息内容
function getAdviceCont(){
	var DocAdviceCont=$("").val();
	var relationIds = [];
	for(var j = 1; j < 4; j++) {
		if($('#sendPerson' + j).is(':checked')) {
			relationIds.push(j);
		}
	}
	//存储医嘱提醒信息内容的对象
	var Msgdata = {
		"DocAdviceCont": DocAdviceCont,
		"relationIds": relationIds
	}
	return Msgdata;
}

//获取普通提醒信息内容
function getNormalPushMsg(title,content){
	
	var relationIds = [];
	for(var j = 1; j < 4; j++) {
		if($('#sendPerson' + j).is(':checked')) {
			relationIds.push(j);
		}
	}
	//存储提醒信息内容的对象
	var Msgdata = {
		"title": title,
		"content": content,
		"relationIds": relationIds
	}
	return Msgdata;
}