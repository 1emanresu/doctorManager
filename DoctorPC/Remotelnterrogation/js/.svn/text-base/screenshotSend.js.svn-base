//此js公用,参数dom对象id,
//document.write('<script src="http://html2canvas.hertzen.com/build/html2canvas.js"></script>')
var addressZ = sessionStorage.getItem("address");
//var addressZ="http://192.168.1.26:8080/doctormanager/";
/*将div变为图片*/
function signSend(id) {
	$("#"+id).css("background","white");
	event.preventDefault();
	html2canvas(document.getElementById(id), {
		allowTaint: true,
		taintTest: false,
		onrendered: function(canvas) {
			canvas.id = "mycanvas";
			//生成base64图片数据  
			var dataUrl = canvas.toDataURL();
			//发送上传
			uploadP(dataUrl);
		}
	});
}

/*上传以及发送图片*/
function uploadP(base64) {
	$.ajax({
		url: addressZ + "PicUpload.do",
		type: "POST",
		data: {
			imgdata: base64 //base64值
		},
		dataType: "json",
		cache: false,
		async: true,
		success: function(data) {
			if(data.success) {
				$("#canvas,#canvas2").remove();
				//location.reload();///data.message为上传成功后的文件路径
				var pic = data.msg.substring(data.msg.lastIndexOf('/') + 1); //获取图片文件名
				sendMessage(pic, 2);
				//清空输入框
				sendMessageInput.value = "";
			} else {
				mui.toast(data.msg); ///data.message为上传失败原因
			}
		},
		error: function() {
			mui.toast("上传失败");
		}
	});
}