var myself = $("#input1").val();
var other = $("#input2").val();
//var doctotIM=JSON.parse(localStorage.getItem("IMAccount"));//医生的网易云账号
//var clientIM=JSON.parse(localStorage.getItem("gravidaIMAccount"));//孕妇的网易云账号
var afterUrlParams =  window.location.search.substring(1); //url ？后面的字符串
var ParamString=afterUrlParams.split("&");//参数分割
var IMAccount=ParamString[0].split('=')[1];//医生的网易云账号
var IMPassword=ParamString[1].split('=')[1];//医生的网易云账号密码
var clientIM=ParamString[2].split('=')[1];//孕妇的网易云账号
//alert(IMAccount);
//alert(clientIM);

var data = {};
window.nim = NIM;
var WebRTC = window.WebRTC;
var that = this;
var netcall = null;
var beCalling = false
var beCalledInfo = null
// 呼叫超时检查定时器
var callTimer = null;
// 被呼叫超时检查定时器
var beCallTimer = null;
// 音频或视频通话
var type = null;
// 是否处于通话流程中
var netcallActive = false;
// 通话的channelId
var channelId = null;
// 通话流程的另一方账户
var netcallAccount = "";
// 通话时长
var netcallDuration = 0;
// 通话正式开始时间戳
var netcallStartTime = 0;
// 通话时长定时器
var netcallDurationTimer = null;
// 音视频流配置
this.sessionConfig = {
    videoQuality: WebRTC.CHAT_VIDEO_QUALITY_480P,
    videoFrameRate: WebRTC.CHAT_VIDEO_FRAME_RATE_NORMAL,
    /*videoBitrate: 0,
    recordVideo: false,
    recordAudio: false,*/
    highAudio: false
};

var nim = NIM.getInstance({
	// 初始化SDK
	debug: true, //调试模式
	appKey: '3479a88fac4280cc7f6579737351ca5d', //
	account: IMAccount,//doctotIM.imid,
	token: IMPassword,//doctotIM.impassword,
	onconnect: onConnect,
	onerror: onError,
	onwillreconnect: onWillReconnect,
	ondisconnect: onDisconnect,
	// 同步完成
	onsyncdone: onSyncDone
});

function onConnect() {
	console.log('连接成功');
}

function onWillReconnect(obj) {
	// 此时说明 `SDK` 已经断开连接, 请开发者在界面上提示用户连接已断开, 而且正在重新建立连接
	console.log('即将重连');
	console.log(obj.retryCount);
	console.log(obj.duration);
}

function onDisconnect(error) {
	// 此时说明 `SDK` 处于断开状态, 开发者此时应该根据错误码提示相应的错误信息, 并且跳转到登录页面
	console.log('丢失连接');
	console.log(error);
	if(error) {
		switch(error.code) {
			// 账号或者密码错误, 请跳转到登录页面并提示错误
			case 302:
				break;
				// 被踢, 请提示错误后跳转到登录页面
			case 'kicked':
				break;
			default:
				break;
		}
	}
}

function onError(error) {
	console.log(error);
}


function onSyncDone() {
	console.log('同步完成');
	NIM.use(WebRTC);

	// 初始化webrtc
	netcall = window.webrtc = this.webrtc = WebRTC.getInstance({
		nim: nim,
		container: $("#self")[0],
		remoteContainer: $("#other")[0],
		debug: true
	});
	//监听挂断音视频通话
	netcall.on("hangup", function(obj) {
		console.log('on hangup', obj);
		resetWhenHangup();
		alert("对方已挂断");
		CloseWebPage();
	}.bind(this));
	//被呼叫
	netcall.on("beCalling", function(obj) {
		console.log('被呼叫', obj);
		// 获取通话标识符 channelId, 每一通会话的 channelId 都不一样
		var channelId = obj.channelId;
		// 通知对方自己已经收到此次通话的请求
		netcall.control({
			channelId: channelId,
			command: WebRTC.NETCALL_CONTROL_COMMAND_START_NOTIFY_RECEIVED
		})
		// 只有在没有通话并且没有被叫的时候才记录被叫信息, 否则直接挂断
		if(!netcall.calling && !beCalling) {
			console.log('正常被呼叫...');
			beCalling = true
			beCalledInfo = obj
			netcall.response({
		        accepted: true,
		        beCalledInfo: beCalledInfo,
		        sessionConfig: { //会话配置
					videoQuality: WebRTC.CHAT_VIDEO_QUALITY_480P, //视频分辨率
					videoFrameRate: WebRTC.CHAT_VIDEO_FRAME_RATE_25, //视频帧率
					highAudio: false //高清语音开关, 默认关闭
				}
		    });
		} else {
			// 通知呼叫方我方繁忙
			console.log('我方繁忙...');
			netcall.control({
				channelId: channelId,
				command: WebRTC.NETCALL_CONTROL_COMMAND_BUSY
			});
			netcall.response({
		        accepted: false,
		        beCalledInfo: beCalledInfo,
		    });
			beCalledInfo = null;
			beCalling = false;
		}
	}.bind(this));
	//监听拒绝音视频被呼叫
	netcall.on('callRejected', function (obj) {
		console.log('拒绝呼叫', obj);
  		clearCallTimer();
	});
	//监听接听音视频被呼叫
	netcall.on('callAccepted', function (obj) {
		console.log('监听接听音视频被呼叫', obj);
  		var promise;
        if (obj.type === WebRTC.NETCALL_TYPE_VIDEO) {
            promise = setDeviceVideoIn(true);
        } else {
            promise = setDeviceVideoIn(false);
        }
        promise.then(function () {
            return setDeviceAudioIn(true);
        }.bind(this)).then(function () {
            this.startLocalStream();
            //this.updateVideoShowSize(true, false);
            setCaptureVolume(150);
        }.bind(this)).then(function () {
            console.log("开始webrtc连接")
            return netcall.startRtc();
        }.bind(this)).then(function () {
            console.log("webrtc连接成功")
            //changeState();
            return setDeviceAudioOut(true);
        }.bind(this)).catch(function (e) {
            console.error(e);
            console.log("连接出错");
            if (e === '信令链接地址缺失') {
                minAlert.alert({
                    type: 'error',
                    msg: '无法接通!请让呼叫方打开"WebRTC兼容开关"，方可正常通话', //消息主体
                    confirmBtnMsg: '知道了，挂断',
                    cbConfirm: this.hangup.bind(this)
                })
            }
        }.bind(this))
	});
	//通知设备状态的变更
	netcall.on('deviceStatus', function(obj) { 
		console.log('通知设备状态的变更', obj) 
	});
	//对方接入webrtc的通知, 这个时候可以开启远程视频流
	netcall.on('joinChannel', function(obj) { 
		console.log('对方接入webrtc的通知', obj); 
		//设置对方画面的尺寸
		netcall.setVideoViewRemoteSize({
		    width: 800,
		    height: 600,
		    cut: true
		});
		netcall.startRemoteStream(obj);
	});
	//监听音视频通话控制指令
	webrtc.on("control", function (obj) {
        onControl(obj);
    }.bind(this));
	//设置自己画面的尺寸
	netcall.setVideoViewSize({
	    width: 800,
	    height: 600,
	    cut: true
	});
	//doCalling(WebRTC.NETCALL_TYPE_VIDEO);
	// TODO 按钮事件，改成直接视频
	$('#btn').click(function(){
		doCalling(WebRTC.NETCALL_TYPE_VIDEO);
	});

}

var doCalling = function(type) {
	console.log("发起音视频呼叫");
	var deviceType = type === WebRTC.NETCALL_TYPE_VIDEO ? WebRTC.DEVICE_TYPE_VIDEO : WebRTC.DEVICE_TYPE_AUDIO_IN;

	netcall.call({
		type: type, //通话类型
		account: clientIM,//clientIM.imid, //对方账号
		pushConfig: { //推送配置
			enable: true, //是否需要推送, 默认 true
			needBadge: true, //是否需要角标计数, 默认 true
			needPushNick: true, //是否需要推送昵称, 默认 true
			pushContent: '', //推送内容
			custom: '', //自定义通知数据, 推荐封装成 JSON 字符串
			/*custom: JSON.stringify({
		    	key: 'value'
		    })*/
			pushPayload: '', //JSON格式的推送 payload
			sound: '', //推送声音
		},
		//webrtcEnable: true,
		sessionConfig: { //会话配置
			videoQuality: WebRTC.CHAT_VIDEO_QUALITY_480P, //视频分辨率
			videoFrameRate: WebRTC.CHAT_VIDEO_FRAME_RATE_25, //视频帧率
			highAudio: false //高清语音开关, 默认关闭
		}
	}).then(function(obj) {
		console.log("发起通话成功，等待对方接听");
		// 设置超时计时器
		this.callTimer = setTimeout(function() {
			if(!netcall.callAccepted) {
				console.log("超时无人接听");
				//this.showTip("无人接听", 2000, this.cancelCalling.bind(this));
				//this.sendLocalMessage("无人接听");
			}
		}.bind(this), 1000 * 45);

	}.bind(this)).catch(function(err) {
		console.log("发起音视频通话请求失败：", err);
		if(err && err.code === 11001) {
			console.log("发起音视频通话请求失败，对方不在线");
			/*if (this.afterPlayRingA) {
			    this.afterPlayRingA = function () {
			        this.showTip("对方不在线", 3000, this.cancelCalling.bind(this));
			        this.sendLocalMessage("对方不在线");
			    }.bind(this);
			} else {
			    this.showTip("对方不在线", 3000, this.cancelCalling.bind(this));
			    this.sendLocalMessage("对方不在线");
			}*/
		} else {
			this.cancelCalling();
		}

	}.bind(this));
}

//清理音视频呼叫超时计时器
clearCallTimer = function() {
	if(callTimer) {
		clearTimeout(callTimer);
		callTimer = null;
	}
};

// 取消呼叫
var cancelCalling = function(isClick) {
	//if (isClick === true && this.$callingHangupButton.is(".disabled")) return;

	if(!this.isBusy) {
		console.log("取消呼叫");
		this.netcall.hangup();
	}
	this.clearCallTimer();
	this.clearRingPlay();
	//if (isClick === true && !this.isBusy) this.sendLocalMessage("未接通");//聊天窗口添加信息
	//this.hideAllNetcallUI();
	this.resetWhenHangup(); //音视频状态重置
};
//清除响铃
var clearRingPlay = function() {
	if(this.playRingInstance) {
		this.playRingInstance.cancel && this.playRingInstance.cancel();
		this.playRingInstance = null;
	}
};

function resetWhenHangup() {
	beCalledInfo = null
	beCalling = false
	clearCallTimer()
	netcall.stopLocalStream()
	netcall.stopRemoteStream()
	netcall.stopDeviceAudioIn()
	netcall.stopDeviceAudioOutLocal()
	netcall.stopDeviceAudioOutChat()
	netcall.stopDeviceVideo()
}

function hangup() {
	netcall.hangup()
	resetWhenHangup()
}

var clearBeCallTimer = function () {
    if (this.beCallTimer) {
        clearTimeout(this.beCallTimer);
        this.beCallTimer = null;
    }
};

var callAcceptedResponse = function () {

    this.clearBeCallTimer();
    console.log("同意对方音视频请求");
    this.beCalling = false;

    this.netcall.response({
        accepted: true,
        beCalledInfo: this.beCalledInfo,
        sessionConfig: this.sessionConfig
    }).then(function () {
        console.log("同意对方音视频请求成功");
        // 加个定时器 处理点击接听了 实际上对面杀进程了，没有callAccepted回调
        this.acceptAndWait = true;
        setTimeout(function () {
            if (this.acceptAndWait) {
                console.log("通话建立过程超时");
                //this.hideAllNetcallUI();
                this.hangup()
                this.acceptAndWait = false;
            }
        }.bind(this), 10000)

    }.bind(this)).catch(function (err) {
        console.log("同意对方音视频通话失败，转为拒绝");
        console.log("error info:", err);
        //this.$beCallingAcceptButton.toggleClass("loading", false);
        this.reject();
    }.bind(this));

}

/** 拒绝音视频通话, 兼容多人音视频 */
var reject = function () {

    if (!this.beCalling) return;

    this.clearBeCallTimer();
    console.log("拒绝对方音视频通话请求");
    var beCalledInfo = this.beCalledInfo;
    this.netcall.response({
        accepted: false,
        beCalledInfo: beCalledInfo
    }).then(function () {
        console.log("拒绝对方音视频通话请求成功");
        //this.sendLocalMessage("已拒绝");
        this.beCalledInfo = null;
        this.beCalling = false;
        this.hideAllNetcallUI();
    }.bind(this)).catch(function (err) {
        // 自己断网了
        console.log("拒绝对方音视频通话请求失败");
        console.log("error info:", err);
        this.beCalledInfo = null;
        this.beCalling = false;
        this.hideAllNetcallUI();
    }.bind(this));

};
//监听音视频通话控制指令
var onControl = function (obj) {
    console.log("on control:", obj);

    var netcall = this.netcall;
    // 如果不是当前通话的指令, 直接丢掉
    if (netcall.notCurrentChannelId(obj)) {
        console.log("非当前通话的控制信息");
        return;
    }

    var type = obj.type;
    switch (type) {
        // NETCALL_CONTROL_COMMAND_NOTIFY_AUDIO_ON 通知对方自己打开了音频
        case WebRTC.NETCALL_CONTROL_COMMAND_NOTIFY_AUDIO_ON:
            console.log("对方打开了麦克风");
            break;
        // NETCALL_CONTROL_COMMAND_NOTIFY_AUDIO_OFF 通知对方自己关闭了音频
        case WebRTC.NETCALL_CONTROL_COMMAND_NOTIFY_AUDIO_OFF:
            console.log("对方关闭了麦克风");
            break;
        // NETCALL_CONTROL_COMMAND_NOTIFY_VIDEO_ON 通知对方自己打开了视频
        case WebRTC.NETCALL_CONTROL_COMMAND_NOTIFY_VIDEO_ON:
            console.log("对方打开了摄像头");
            break;
        // NETCALL_CONTROL_COMMAND_NOTIFY_VIDEO_OFF 通知对方自己关闭了视频
        case WebRTC.NETCALL_CONTROL_COMMAND_NOTIFY_VIDEO_OFF:
            console.log("对方关闭了摄像头");
            break;
        // NETCALL_CONTROL_COMMAND_SWITCH_AUDIO_TO_VIDEO_REJECT 拒绝从音频切换到视频
        case WebRTC.NETCALL_CONTROL_COMMAND_SWITCH_AUDIO_TO_VIDEO_REJECT:
            console.log("对方拒绝从音频切换到视频通话");
            //this.requestSwitchToVideoRejected();
            break;
        // NETCALL_CONTROL_COMMAND_SWITCH_AUDIO_TO_VIDEO 请求从音频切换到视频
        case WebRTC.NETCALL_CONTROL_COMMAND_SWITCH_AUDIO_TO_VIDEO:
            console.log("对方请求从音频切换到视频通话");
            /*if (this.requestSwitchToVideoWaiting) {
                this.doSwitchToVideo();
            } else {
                this.beingAskSwitchToVideo();
            }*/
            break;
        // NETCALL_CONTROL_COMMAND_SWITCH_AUDIO_TO_VIDEO_AGREE 同意从音频切换到视频
        case WebRTC.NETCALL_CONTROL_COMMAND_SWITCH_AUDIO_TO_VIDEO_AGREE:
            console.log("对方同意从音频切换到视频通话");
            /*if (this.requestSwitchToVideoWaiting) {
                this.doSwitchToVideo();
            }*/
            break;
        // NETCALL_CONTROL_COMMAND_SWITCH_VIDEO_TO_AUDIO 从视频切换到音频
        case WebRTC.NETCALL_CONTROL_COMMAND_SWITCH_VIDEO_TO_AUDIO:
            console.log("对方请求从视频切换为音频");
            //this.doSwitchToAudio();
            break;
        // NETCALL_CONTROL_COMMAND_BUSY 占线
        case WebRTC.NETCALL_CONTROL_COMMAND_BUSY:
            console.log("对方正在通话中");
            console.log("取消通话");
            this.netcall.hangup();
            this.clearCallTimer();
            this.isBusy = true;
            //this.sendLocalMessage("对方正在通话中");
            function doEnd() {
                this.cancelCalling();
            }
            doEnd = doEnd.bind(this);
            /*if (this.afterPlayRingA) {
                this.afterPlayRingA = function () {
                    this.playRing("C", 3, function () {
                        this.showTip("对方正在通话中", 2000, doEnd);
                    }.bind(this));
                }.bind(this);
            } else {
                this.clearRingPlay();
                this.playRing("C", 3, function () {
                    this.showTip("对方正在通话中", 2000, doEnd);
                }.bind(this));
            }*/
            break;
        // NETCALL_CONTROL_COMMAND_SELF_CAMERA_INVALID 自己的摄像头不可用
        case WebRTC.NETCALL_CONTROL_COMMAND_SELF_CAMERA_INVALID:
            console.log("对方摄像头不可用");
            //this.$videoRemoteBox.toggleClass("empty", true).find(".message").text("对方摄像头不可用");
            /*if (this.isRtcSupported) {
                //p2p
                if (this.yx.crtSessionType === 'p2p') {
                    return this.stopRemoteStream();
                }
                // team
                this.stopRemoteStreamMeeting(obj.account);
            }*/
            break;
        // NETCALL_CONTROL_COMMAND_SELF_ON_BACKGROUND 自己处于后台
        // NETCALL_CONTROL_COMMAND_START_NOTIFY_RECEIVED 告诉发送方自己已经收到请求了（用于通知发送方开始播放提示音）
        // NETCALL_CONTROL_COMMAND_NOTIFY_RECORD_START 通知对方自己开始录制视频了
        // NETCALL_CONTROL_COMMAND_NOTIFY_RECORD_STOP 通知对方自己结束录制视频了
    }
};

var setDeviceVideoIn = function (state) {
    //$(".icon-camera").toggleClass("icon-disabled", !state);
    this.deviceVideoInOn = !!state;

    if (state) {
        console.log("开启摄像头");
        return this.netcall.startDevice({
            type: WebRTC.DEVICE_TYPE_VIDEO
            /* width: this.videoCaptureSize.width,
             height: this.videoCaptureSize.height */
        }).then(function () {
            this.videoType = 'video'
            console.log("开启摄像头成功，通知对方己方开启了摄像头");
            // 通知对方自己开启了摄像头
            this.netcall.control({
                command: WebRTC.NETCALL_CONTROL_COMMAND_NOTIFY_VIDEO_ON
            });
            $(".netcall-video-local").toggleClass("empty", false);
            $(".netcall-video-local .message").text("");

        }.bind(this)).catch(function (err) {
            console.error(err)
            this.videoType = null
            // 通知对方自己的摄像头不可用
            console.log("开启摄像头失败，通知对方己方摄像头不可用", err);
            this.onDeviceNoUsable(WebRTC.DEVICE_TYPE_VIDEO);

            this.netcall.control({
                command: WebRTC.NETCALL_CONTROL_COMMAND_SELF_CAMERA_INVALID
            });
            /*$(".netcall-video-local").toggleClass("empty", true);
            $(".netcall-video-local .message").text("摄像头不可用");
            $(".netcall-box .camera.control-item").toggleClass("no-device", true).attr("title", "摄像头不可用");*/

            // console.log("摄像头不可用");
        }.bind(this));

    } else {
        this.videoType = null
        console.log("关闭摄像头");
        return this.netcall.stopDevice(WebRTC.DEVICE_TYPE_VIDEO).then(function () {
            // 通知对方自己关闭了摄像头
            console.log("关闭摄像头成功，通知对方我方关闭了摄像头");
            this.netcall.control({
                command: WebRTC.NETCALL_CONTROL_COMMAND_NOTIFY_VIDEO_OFF
            });
            $(".netcall-video-local").toggleClass("empty", true);
            $(".netcall-video-local .message").text("您关闭了摄像头");
        }.bind(this)).catch(function (e) {
            this.videoType = null
            console.log("关闭摄像头失败");
        }.bind(this));

    }

};
var setDeviceAudioIn = function (state) {
    //$(".icon-micro").toggleClass("icon-disabled", !state);
    this.deviceAudioInOn = !!state;

    if (state) {
        this.log("开启麦克风");
        return this.netcall.startDevice({
            // 开启麦克风输入
            type: WebRTC.DEVICE_TYPE_AUDIO_IN
        }).then(function () {
            this.log("开启麦克风成功，通知对方我方开启了麦克风");
            // 通知对方自己开启了麦克风
            this.netcall.control({
                command: WebRTC.NETCALL_CONTROL_COMMAND_NOTIFY_AUDIO_ON
            })
        }.bind(this)).catch(function () {
            console.log("开启麦克风失败");
            this.log("开启麦克风失败");
            this.onDeviceNoUsable(WebRTC.DEVICE_TYPE_AUDIO_IN);
        }.bind(this));
    } else {
        this.log("关闭麦克风");
        return this.netcall.stopDevice(WebRTC.DEVICE_TYPE_AUDIO_IN) // 关闭麦克风输入
            .then(function () {
                this.log("关闭麦克风成功，通知对方我方关闭了麦克风");
                // 通知对方自己关闭了麦克风
                this.netcall.control({
                    command: WebRTC.NETCALL_CONTROL_COMMAND_NOTIFY_AUDIO_OFF
                });
            }.bind(this)).catch(function () {
                this.log("关闭麦克风失败");
            }.bind(this));
    }
};
var setDeviceAudioOut = function (state) {
    //$(".icon-volume").toggleClass("icon-disabled", !state);
    this.deviceAudioOutOn = !!state;

    if (state) {
        this.log("开启扬声器");
        return this.netcall.startDevice({
            type: WebRTC.DEVICE_TYPE_AUDIO_OUT_CHAT
        }).then(function () {
            this.log("开启扬声器成功");
        }.bind(this)).catch(function () {
            console.log("开启扬声器失败");
            this.log("开启扬声器失败");
            this.onDeviceNoUsable(WebRTC.DEVICE_TYPE_AUDIO_OUT_CHAT);
        }.bind(this));
    } else {
        this.log("关闭扬声器");
        return this.netcall.stopDevice(WebRTC.DEVICE_TYPE_AUDIO_OUT_CHAT).then(function () {
            this.log("关闭扬声器成功");
        }.bind(this)).catch(function () {
            this.log("关闭扬声器失败");
        }.bind(this));
    }
};
/** 设置采集音量大小
 * 默认值255
 */
var setCaptureVolume = function (captureVolume) {
    var netcall = this.netcall;
    if (netcall) {
        netcall.setCaptureVolume(captureVolume || 255)
    }
}

var log = function (message) {
    console.log("%c" + message, "color: green;font-size:16px;");
};

function CloseWebPage() {
	if(navigator.userAgent.indexOf("MSIE") > 0) {
		if(navigator.userAgent.indexOf("MSIE 6.0") > 0) {
			window.opener = null;
			window.close();
		} else {
			window.open('', '_top');
			window.top.close();
		}
	} else if(navigator.userAgent.indexOf("Firefox") > 0) {
		window.location.href = 'about:blank ';
	} else {
		window.opener = null;
		window.open('', '_self', '');
		window.close();
	}
}
window.onbeforeunload = function() {
	hangup();
}
