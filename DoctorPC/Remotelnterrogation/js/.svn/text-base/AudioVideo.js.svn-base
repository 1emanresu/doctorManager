/************************* 音视频相关操作 ***********************/
/** 打开自己麦克风 */
var startDeviceAudioIn = function () {
    var that = this;
    that.netcall.startDevice({
        type: WebRTC.DEVICE_TYPE_AUDIO_IN
    }).then(function () {
        // 通知对方自己开启了麦克风
        that.netcall.control({
            command: WebRTC.NETCALL_CONTROL_COMMAND_NOTIFY_AUDIO_ON
        })
    }).catch(function () {
        console.log('启动麦克风失败')
        $(".netcall-box .microphone.control-item").toggleClass("no-device", true).attr("title", "麦克风不可用");
    })
}

/** 关闭自己麦克风 */
var stopDeviceAudioIn = function () {
    var that = this;
    that.netcall.stopDevice(WebRTC.DEVICE_TYPE_AUDIO_IN).then(function () {
        // 通知对方自己关闭了麦克风
        that.netcall.control({
            command: WebRTC.NETCALL_CONTROL_COMMAND_NOTIFY_AUDIO_OFF
        })
    })
}

/** 打开摄像头
 * 默认设置采集大小是全屏状态下的采集大小
 */
var startDeviceVideo = function () {
    var that = this;
    var defaultWidth = 800, defaultHeight = 600;

    netcall.startDevice({
        type: WebRTC.DEVICE_TYPE_VIDEO,
        width: defaultWidth,
        height: defaultHeight,
        cut: 1
    }).then(function () {
        // 通知对方自己开启了摄像头
        that.netcall.control({
            command: WebRTC.NETCALL_CONTROL_COMMAND_NOTIFY_VIDEO_ON
        })
    }).catch(function () {
        // 通知对方自己的摄像头不可用
        that.netcall.control({
            command: WebRTC.NETCALL_CONTROL_COMMAND_SELF_CAMERA_INVALID
        })
        console.log('启动摄像头失败')
        that.nodeLoadingStatus(that.yx.accid, '摄像头不可用');
        that.nodeCameraStatus(that.yx.accid, false);

        /** 图标展示摄像头不可用 */
        var $camera = $(".netcall-box .camera.control-item");
        $camera.toggleClass("no-device", true).attr("title", "摄像头不可用");
        $(".netcall-video-local").toggleClass("empty", true);
        $(".netcall-video-local .message").text("摄像头不可用");
        // that.updateDeviceStatus(WebRTC.DEVICE_TYPE_VIDEO, true, false);

    })
}

/** 关闭摄像头 */
var stopDeviceVideo = function () {
    var that = this;
    that.netcall.stopDevice(WebRTC.DEVICE_TYPE_VIDEO).then(function () {
        // 通知对方自己关闭了摄像头
        that.netcall.control({
            command: WebRTC.NETCALL_CONTROL_COMMAND_NOTIFY_VIDEO_OFF
        })
        that.nodeLoadingStatus(that.yx.accid, '摄像头已关闭');
        that.nodeCameraStatus(that.yx.accid, false);
    })
}

/** 开启自己本地音视频流 */
var startLocalStreamMeeting = function () {
    var node = this.findAccountNode(this.yx.accid);
    if (this.netcall) {
        this.netcall.startLocalStream(node)
        this.nodeLoadingStatus(this.yx.accid)
    }
}

/** 关闭本地视频流 */
var stopLocalStreamMeeting = function () {
    if (this.netcall) {
        this.netcall.stopLocalStream()
    }
}

/** 开启远程音视频流 */
var startRemoteStreamMeeting = function (obj) {
    if (!obj.account && !obj.uid) {
        console.log('远程流错误，缺少account或者uid：', obj);
    }
    if (!obj.account) {
        obj.account = this.netcall.getAccountWithUid(obj.uid);
    }
    obj.node = this.findAccountNode(obj.account);
    if (this.netcall) {
        this.netcall.startRemoteStream(obj)
        this.nodeLoadingStatus(obj.account)
    }
}

/** 关闭远程视频流 */
var stopRemoteStreamMeeting = function (account) {
    if (this.netcall) {
        this.netcall.stopRemoteStream(account)
    }
}

/** 设置采集音量大小
 * 默认值255
 */
var setCaptureVolume = function () {
    var netcall = this.netcall;
    if (netcall) {
        netcall.setCaptureVolume(this.captureVolume || 255)
    }
}

/** 设置播放音量大小 */
var setPlayVolume = function () {
    var netcall = this.netcall;
    if (netcall) {
        netcall.setPlayVolume({ volume: this.playVolume || 255 })
    }
}

var videoCaptureSize = {
    width: 800,
    height: 600
}
/** 设置自己视频大小尺寸
 * @param {object} option
 * @param {string} option.width 宽度
 * @param {string} option.height 高度
 */
var setVideoViewSize = function () {
    this.netcall.setVideoViewSize(this.videoCaptureSize)
}

/** 设置远程视频尺寸大小 */
var setVideoViewRemoteSize = function () {
    this.netcall.setVideoViewRemoteSize(this.videoCaptureSize)
}

/** 设置视频裁剪尺寸 */
var setVideoScale = function () {
    this.netcall.setVideoScale && this.netcall.setVideoScale({ type: 1 });
}

/** 播放自己的声音 */
var startDeviceAudioOutLocal = function () {
    var that = this;
    that.netcall.startDevice({
        type: WebRTC.DEVICE_TYPE_AUDIO_OUT_LOCAL
    }).catch(function () {
        console.log('播放自己的声音失败')
    })
}

/** 关闭自己的声音 */
var stopDeviceAudioOutLocal = function () {
    this.netcall.stopDevice(WebRTC.DEVICE_TYPE_AUDIO_OUT_LOCAL)
}

/** 播放远程声音 */
var startDeviceAudioOutChat = function () {
    var that = this;
    that.netcall.startDevice({
        type: WebRTC.DEVICE_TYPE_AUDIO_OUT_CHAT
    }).catch(function () {
        console.log('播放对方的声音失败')
    })
}

/** 关闭远程声音 */
var stopDeviceAudioOutChat = function () {
    this.netcall.stopDevice(WebRTC.DEVICE_TYPE_AUDIO_OUT_CHAT)
}

/** 自己本地设备状态变化的通知
 * @param {string} type 类型：视频 / 音频（默认）
 * @param {boolean} isOn 状态：开（默认） / 关
 * @param {boolean} isEnable 状态：设备可用（默认） / 设备不可用
 */
var updateDeviceStatus = function (type, isOn, isEnable) {
    type = type || WebRTC.DEVICE_TYPE_AUDIO_IN;
    isOn = isOn;
    isEnable = isEnable;
    var map = {};
    map[WebRTC.DEVICE_TYPE_AUDIO_IN] = '麦克风';
    map[WebRTC.DEVICE_TYPE_VIDEO] = '摄像头';
    var text = (isEnable ? (isOn ? '' : '已关闭') : '不可用');
    text = text ? map[type] + text : '';
    this.log(text);
    if (type === WebRTC.DEVICE_TYPE_VIDEO) {
        this.nodeLoadingStatus(this.yx.accid, text);
        this.nodeCameraStatus(this.yx.accid, isEnable && isOn);
    }
}