//发送人
var username = sessionStorage.getItem("doctorId");
//服务器地址
//var address = "http://192.168.1.26:8080/doctormanager/"
var address = sessionStorage.getItem("address");
//接收人
var sendee = sessionStorage.getItem("mid");

$(function() {
	init();
});

//此方法用于查看未读的聊天记录
var htmlLeft = "<div class='content2'><div class='conR' ><div id='box2'><div class='arrowyou'></div><div>[content]</div>" +
	"</div></div><div style='flex: 1;text-align: right;'><img src='images/d.png' width='30px' /></div></div>";

var htmlRidth = "<div class='content1'><div style='float: left;flex: 1;'><img src='images/yf.png' width='30px' /></div>" +
	"<div style='flex: 5;'><div id='box1'><div class='arrowzuo'></div><div>[content]</div></div></div></div>";

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
				if(data[i].senderid == username) {
					tem = htmlLeft.replace('[content]', data[i].sendcontent);
				} else {
					tem = htmlRidth.replace('[content]', data[i].sendcontent);
				}
				textArea.innerHTML += tem;
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
				bool=false;
				var data = d.data;
				var textArea = document.getElementById("chat_content");
				for(var i = 0; i < data.length; i++) {
					if(data[i].senderid == username) {
						tem = htmlLeft.replace('[content]', data[i].sendcontent);
					} else {
						tem = htmlRidth.replace('[content]', data[i].sendcontent);
					}
					//修改图片显示样式
					/*if(data[i].filetype==2){
						textArea.innerHTML += "<div style='float:right;'>"+data[i].sendcontent+"</div>";
					}else{
						
					}*/
					textArea.innerHTML += tem;
				}
				//目的是回到顶部
				textArea.scrollTop = 0;
			}
		});
	}
}