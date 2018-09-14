var ws = null;
var i = 0;
//发送人昵称
var send = '111';
//var address = "http://120.76.194.76/doctormanager/"
var address = sessionStorage.getItem("address");
//var address = "http://192.168.1.24:8080/doctormanager/"
//接收人
var accept = sessionStorage.getItem("mid");
var target = sessionStorage.getItem("address").replace("http://","ws://")+"echo?username=" + send; // 打开管道  ,ws://localhost:8080/项目名/@ServerEndpoint名字
//var target = "ws://120.76.194.76/doctormanager/echo?username=" + send; // 打开管道  ,ws://localhost:8080/项目名/@ServerEndpoint名字
//此方法用于改变聊天的对象
function serviceObject(mid) {
	//改变孕妇id 
	sessionStorage.setItem("mid", mid);
	//刷新当前页面
	location.reload();
}

$(function() {
	if(ws == null) {
		if('WebSocket' in window) {
			ws = new WebSocket(target);
		} else if('MozWebSocket' in window) {
			ws = new MozWebSocket(target);
		} else {
			alert('WebSocket is not supported by this browser.');
			return;
		}

		ws.onmessage = function(event) { //创建websocket同时,接收服务器发给客服端的消息
			if(event != null) {
				//将json字符串转为对象
				eval("var msg=" + event.data + ";");
				//得到对象里面的值
				var welcome = msg.welcome;
				var content = msg.content;
				var usernames = msg.usernames;
				var js = JSON.parse(event.data);
				//经过处理，回显给用户界面
				if(js.fileType != undefined) {
					content = isType(js.fileType, content, js.from);
				}

				//上线提醒功能
				if(undefined != welcome && welcome != send) {
					//执行更新在线人员列表
//					queryInquiryState();
				}
				var textArea = document.getElementById("chat_content");
				if(js.prompt != undefined) {
					i++;
					if(i == 1) {
						textArea.innerHTML += "<div id='prompt'>小提示： " + js.prompt + "</div>";
					}
				}

				if(undefined != content) {
					if(js.fileType == 2) {
						textArea.innerHTML += content;
					} else {
						textArea.innerHTML += content; //自己发的信息显示在右边
					}
				}
				//目的是让收到新信息回到底部
				textArea.scrollTop = textArea.scrollHeight + 50;
			}
		};

		ws.onclose = function(message) {};

	}
});
//关闭浏览器事件
window.onbeforeunload = function() {
	ws.close();
}
//用于区别发送的是文字还是拖动的控件
var sendMessageInput = document.getElementById("sendMessageTextArea");
sendMessage = function(msg, fileType) { //发送信息
	//获取用户输入的消息内容
	if(fileType == 0) {
		msg = sendMessageInput.innerHTML;
	}
	if($.trim(msg) != "") {
		if(ws != null) {
			var checkedUsernameArray = new Array(); // 被选中的复选框名字
			//增加接收人 
			checkedUsernameArray.push(accept);

			var msgObj = {
				type: 1, //1为单发
				from: send, //由谁发的
				to: checkedUsernameArray, //发给谁---数组类型
				content: msg, //发送内容
				fileType: fileType
			};

			//将msgOjb对象转为json
			var json = JSON.stringify(msgObj);
			//执行发送
			ws.send(json);
			//清空输入框
			sendMessageInput.innerHTML = "";

		} else {
			alert("websocket is null , please create a websocket");
		}
	} else {
		alert("内容为空！！！");
	}
}

/*
 * 
 * 录音
 * 
 * 
 * 
 * */

var audio_context;
var recorder;

function startUserMedia(stream) {
	var input = audio_context.createMediaStreamSource(stream);
	recorder = new Recorder(input);
}
//开始录音方法
function startRecording(button) {
	recorder && recorder.record();
	button.nextElementSibling.innerHTML = "录音中，点击发送";
	$("#send").show();
	//__log('Recording...');
}

//停止录音的方法
function stopRecording(button) {
	recorder && recorder.stop();
	$("#send").hide();
	createDownloadLink();
	recorder.clear();
}

//上传录音
function createUpload(blob) {
	var formData = new FormData();
	formData.append("file", blob);
	formData.append("senderid", send); //传进发送人
	formData.append("receiverid", accept); //传进接收人
	$.ajax({
		url: address + "/audupload.do",
		type: 'post',
		data: formData,
		async: false,
		cache: false,
		contentType: false,
		processData: false,
		success: function(returndata) {
			/*<img src='images/xh.png' widht='15px'>*/
			sendMessage(returndata, 1);
		},
		error: function(returndata) {
			alert("error");
		}
	});
}

//创建下载链接
function createDownloadLink() {
	recorder && recorder.exportWAV(function(blob) {
		createUpload(blob);
	});
}

//别人发送的信息
var htmlRidth = "<div class='content1'><div style='float:left;width:50px;'><img src='images/yf1.jpg' width='30px' /></div>" +
	"<div style='flex: 5;'><div id='box1'><div class='arrowzuo'></div><div>[content]</div></div></div></div>";

//自己发送的信息
var htmlLeft = "<div class='content2'><div class='conR' ><div id='box2'><div class='arrowyou'></div><div>[content]</div></div>" +
	"</div><div style='float:right;width:50px;'><img src='images/d1.jpg' width='30px' /></div></div>";

//判断发送的类型
function isType(i, content, sendId) {
	var text1;
	//文字
	if(i == 0) {
		if(sendId == send) {
			text1 = htmlLeft.replace('[content]', content);
		} else {
			text1 = htmlRidth.replace('[content]', content);
		}
	} else if(i == 1) {
		//语音样式可以在这里修改
		var audioaddress = address + "audio/chat/" + "w" + content;
		if(sendId == send) {
			text1 = "<div onclick='playOrPaused(this)'><img src='images/xh.png' width='15px' class='xhPc'/><audio src='" + audioaddress + "'></audio></div>";
			text1 = htmlLeft.replace('[content]', text1);
		} else {
			text1 = "<div onclick='playOrPaused(this)'><img src='images/xh.png' width='15px' class='xhApp'/><audio src='" + audioaddress + "'></audio></div>";
			text1 = htmlRidth.replace('[content]', text1);
		}
	} else if(i == 2) {
		//图片样式可以在这里修改  
		var src = address + "img/chat/" + content;
		if(sendId == send) {
			text1 = "<img src='" + src + "'  onload='onloadImg(this)' onclick='seeBigImg(this)'>"; //发送的图片限制为100px
			text1 = htmlLeft.replace('[content]', text1);
		} else {
			text1 = "<img src='" + src + "'  onload='onloadImg(this)'  onclick='seeBigImg(this)'>"; //发送的图片限制为100px

			text1 = htmlRidth.replace('[content]', text1);
		}
	} else if(i == 3) {
		//拖动的html
		if(sendId == send) {
			text1 = htmlLeft.replace('[content]', content);
		} else {
			text1 = htmlRidth.replace('[content]', content);
		}
	} else if(i == 4) {
		//视频窗口
		if(sendId == send) {} else {
			switch(content) {
				case "0":
					{
						alert("对方已拒绝视频邀请。");
						break;
					}
				case "1":
					{
						openWindow();
						
						break;
					}
				case "2":
					{
						if(confirm("对方邀请你加入视频聊天，是否接受？")) {
							openWindow();
						} else {
							sendMessage(0, 4);
						}
						break;
					}
			}
			/*if (content == "1") {
				alert("对方已接受视频邀请，请点击视频窗口开始按钮");
			}else if (content == "0") {
				alert("对方已取消视频邀请，请关闭视频窗口");
			}else*/
		}
	} else {
		//默认样式
		if(sendId == send) {
			text1 = htmlLeft.replace('[content]', content);
		} else {
			text1 = htmlRidth.replace('[content]', content);
		}
	}
	return text1;
}

//此方法用于对发送的图片进行调整，大于100px的图片显示为100px，小于100px的则显示原始尺寸
function onloadImg(that) {
	$(that).css({
		"border-radius": "4px"
	});
	$(that).attr("width", "100px").removeAttr("onload");
	var isrc = $(that).attr("src");
	var Img = new Image();
	Img.src = isrc;
	Img.onload = function() {
		if(Img.width > 100) {
			$(that).attr("width", "100px");
		} else {
			$(that).removeAttr("width");
		}
	}
}
$(function() {
	try {
		// webkit shim
		window.AudioContext = window.AudioContext || window.webkitAudioContext;
		navigator.getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia;
		window.URL = window.URL || window.webkitURL;
		audio_context = new window.AudioContext;
		//__log('Audio context set up.');
		//__log('navigator.getUserMedia ' + (navigator.getUserMedia ? 'available.' : 'not present!'));
	} catch(e) {
		console.log('浏览器不支持getUserMedia');
	}
	if(navigator.getUserMedia || navigator.webkitGetUserMedia) {
		navigator.getUserMedia({
			audio: true
		}, startUserMedia, function(e) {
			//__log('No live audio input: ' + e); 
		});
	} else {
		//console.log("此浏览器不支持navigator.GetUserMedia");
	}
});

//播放录音与停止录音
var fk;
function playOrPaused(that) {
	clearInterval(fk);
	$(".xhApp").css("opacity", "1.0");
	$(".xhPc").css("opacity", "1.0");
	var audio = $(that).children("audio")[0];
	//先判断录音是否在播放中，不是就播放，是就停止
	if(audio.paused) {
		//播放
		audio.play();
		var i = 1;
		fk = setInterval(function() {
			i++;
			//图片闪动
			if(i % 2 == 0) {
				$(that).children("img").css("opacity", "0.3");

			} else {
				$(that).children("img").css("opacity", "1.0");
			}
		}, 300);

	} else {
		clearInterval(fk);
		//停止播放
		audio.pause();
		audio.currentTime = 0.0;
	}

	//播放完成时，图片不再闪动
	$(that).children("audio").bind('ended', function() {
		$(that).children("img").css("opacity", "1.0");
		clearInterval(fk);
	});
}

/*
 * 
 * 发送图片
 * author:zhangqt
 * 
 * 
 * 
 * 
 * */

//用于选择图片之后显示在输入框中
/*function changeImg() {
	var r = new FileReader();
	f = document.getElementById('uimg').files[0];
	r.readAsDataURL(f);
	r.onload = function(e) {
		var image = new Image();
		image.src = this.result;
		if(image.width > 80) {
			sendMessageInput.innerHTML += "<img class='img1' src='" + this.result + "' width='80px'>";
		} else {
			sendMessageInput.innerHTML += "<img id='img1' src='" + this.result + "'>";
		}
	};

}
*/
//电脑端上传图片的方法
function uploadPhoto() {
	var filepath = $("#uimg").val();
	if(filepath == "") {
		return;
	}
	var extStart = filepath.lastIndexOf(".");
	var ext = filepath.substring(extStart, filepath.length).toUpperCase();
	if(".jpg|.png|.bmp|.jpeg".toUpperCase().indexOf(ext.toUpperCase()) == -1) {
		alert("只允许发送jpg、png、bmp、jpeg格式的图片");
		return false;
	}
	//以图片宽度为800进行压缩
	lrz(document.getElementById('uimg').files[0], {
			width: 800
		})
		.then(function(rst) {
			//压缩后异步上传
			var img = new Image();
			$.ajax({
				url: address + "PicUpload.do",
				type: "POST",
				data: {
					imgdata: rst.base64 //压缩后的base值
				},
				dataType: "json",
				cache: false,
				async: true,
				success: function(data) {
					if(data.success) {
						//location.reload();///data.message为上传成功后的文件路径
						var pic = data.msg.substring(data.msg.lastIndexOf('/') + 1); //获取图片文件名
						var src = address + "img/chat/" + pic;
						var image = new Image();
						image.src = src;
						image.onload = function() {
							sendMessage(pic, 2);
							//清空输入框
							sendMessageInput.innerHTML = "";

							//清空图片选择input
							var nfile = $("#uimg");
							nfile.after(nfile.clone().val(""));
							nfile.remove();
						}

					} else {
						alert(data.msg); ///data.message为上传失败原因
					}
				},
				error: function() {
					alert("上传失败");
				}
			});
		});
}

$(function() {
	//将选择文件的点击控制交给图片
	$('#fileClick').on('click', '', function() {
		$('#uimg').click();
	});
	//按下enter键事件-----发送信息
	document.onkeydown = function(e) {
		if(!e) e = window.event;
		if((e.keyCode || e.which) == 13) {
			sendMessage(1, 0);
		}
	}

	$("#video_btn").click(function() {
		sendMessage(1, 4);
		//openWindow();
	})
});

function openWindow() {
	//$('#doctotIM').val(localStorage.getItem("IMAccount"));//医生的网易云账号
    //$('#clientIM').val(localStorage.getItem("gravidaIMAccount"));//孕妇的网易云账号
	var doctotIM=JSON.parse(localStorage.getItem("IMAccount"));//医生的网易云账号
    var clientIM=JSON.parse(localStorage.getItem("gravidaIMAccount"));//孕妇的网易云账号 
	window.open(
		'https://120.76.194.76:8443/DoctorPC/Remotelnterrogation/video.html?IMAccount='+doctotIM.imid+'&IMPassword='+doctotIM.impassword+'&clientIM='+clientIM.imid,
		'newwindow',
		'height=' + (screen.availHeight - 50) + ',width=' + (screen.availWidth - 10) +
		',top=0,left=0,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no'
	);
	
　　setTimeout(function() {sendMessage(doctotIM.imid, 4);}, 2000);
//	setTimeout(function() {
//		sendMessage(2, 4);
//		
//	}, 2000);
	
	/*window.open(
		'video1.html?mid=' + username,
		'newwindow',
		'height=800,width=2000,top=100,left=200,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no'
	);*/
}

//此方法保留--有用--zhangqt
function problemBut(str){
	return false;
}
function skip2(who){
	return false;
}
