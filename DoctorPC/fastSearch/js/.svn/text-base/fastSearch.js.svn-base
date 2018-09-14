/**
 * @author wangzw
 * 
 * 封装的词条检索 js
 * 
 * 说明：如需使用详细请参照 fastSearch文件下的页面使用方式
 *   		    
 */
var address = sessionStorage.getItem("address");
//var address = sessionStorage.getItem("address");
var UtilAddress = address.replace('doctormanager','knowledge');
//UtilAddress = "http://192.168.1.38:8080/knowledge/";   //上传项目后 应注释该句代码
var sunCount; //词条相关的内容 的查询总数量 变量
var videoSunCount; //词条相关资料文件的查询总数量 变量

/**
 * 提供的接口 如需修改在此处查询的值
 * 获取用户输入的值
 */
function getInputValue() {
	var value = $("#word_search").val();
	return value;
}
$(function() {
	dynamicHtml();
//	$("#btn_search").click();
});
var index = 1;
var indexValue = 1;
/**
 * 点击索检按钮查询词条相关的内容
 */
$("#btn_search").click(function() {
	if(index == 1) {
		$("#file_data").html("");
		$("#file_data").append(dictionaryContent());
		index = 2;
	}

	//词条相关的内容
	changeSize();
	if(indexValue == 1) {
		$("#video_data").append(videoContent());
		indexValue = 2;
	}
	//词条相关资料文件
	videoShow();

});

/**
 * 初始化页面js
 * 动态生成html页面内容
 */
function dynamicHtml() {
	var content = "<div id='container_dictionaries'><div id='file_data'></div><div id='video_data'></div></div>";
	$("#sun_container").append(content);
}
/**
 * 词条相关的内容 
 */
function dictionaryContent() {
	var content = "<div class='segmentation'>" +
		"<div class='wire_border'></div>" +
		"<div class='title_info'>词条相关的内容</div>" +
		"<div class='line_style'></div>" +
		"</div>" +
		"<!--词条相关的内容div-->" +
		"<div id='container'>" +
		"</div>" +
		"<div style='clear: both; border-bottom: 1px solid #EBEBEB;width: 100%;'></div>" +
		"<div class='class_bottom_container'>" +
		"<p class='class_left_float'>" +
		"当前显示第<span class='stratNum'></span> 到第 <span class='endNum'></span> 条数据，共有数据：<span class='perSun'>6</span>条" +
		"</p>" +
		"<div class='class_right_float ui-page' id='ui-page' onselectstart='return false;'>" +
		"</div>" +
		"</div>";

	return content;
}
/**
 * 查询文件视频类
 */
function videoContent() {
	var content = "<div class='segmentation'>" +
		"<div class='wire_border'></div>" +
		"<div class='title_info'>词条相关资料文件</div>" +
		"<div class='line_style'></div>" +
		"</div>" +
		"<div class='file_name'>文件类</div>" +
		"<!--显示音频文件的div-->" +
		"<div id='container2'>" +
		"</div>" +
		"<div style='clear: both; border-bottom: 1px solid #EBEBEB;width: 100%;'></div>" +
		"<div class='class_bottom_container'>" +
		"<p class='class_left_float'>" +
		"当前显示第<span class='stratNum2'></span> 到第 <span class='endNum2'></span> 条数据，共有数据：<span class='perSun2'>6</span>条" +
		"</p>" +
		"<div class='class_right_float ui-page' id='ui-page2' onselectstart='return false;'>" +
		"</div>" +
		"</div>";
	return content;
}

/**
 * 点击重置操作 清空页面重新加载页面
 */
$("#reset_search").click(function() {
	$('#word_search').val("");
	$("#video_data").html("");
	indexValue = 1;
	$("#file_data").html("");
	index = 1;
});
/**
 * 查询词条相关的内容 
 */
function selectDictionary(pageIndex, pageSize) {
	var keyword = getInputValue();
	$.ajax({
		type: "post",
		url: UtilAddress + "wordSearch/findValueDetail.do",
		dataType: "json",
		data: {
			"keyword": keyword,
			"pageIndex": pageIndex,
			"pageSize": pageSize
		},
		async: true,
		success: function(result) {
			var data = result.data;
			var content;
			if(result.total > 0) {
				var data = result;
				$("#container").html("");
				for(var i = 0; i < data.rows.length; i++) {
					content = "<div class='content_show'>" +
						"<div class='content_title'>" + (i+1) + "．" + data.rows[i].targetWord + "</div>" +
						"<div class='content_info'>" + data.rows[i].value + "</div>" +
						"</div>";
					$("#container").append(content);
				}
			}
		}
	});
}

/**
 * 动态生成词条相关的内容底部分页按钮及功能
 */
function changeSize() {
	$("#ui-page").html("");
	getSunCount(getInputValue());
	var count = sunCount;
	if(sunCount <= 0) {
		var div = "<div style='width:100%;margin-top:30px;font-size:16px;text-align:center;'>很抱歉，没有找到与"+ ' " ' +$('#word_search').val() + ' " ' +"相关的内容。</div>"
		$("#file_data").html(div);
		index = 1;
	} else {
		var size = 6; //parseInt(6);
		var initTotalPageNum = Math.ceil(count / size);
		/* 初始化页面 */
		$("#ui-page").paging({
			//显示数字为3个
			pageSize: 3,
			totalPage: initTotalPageNum
		});
		$(".stratNum").html(1);
		$(".endNum").html(size);
		//默认显示第一页
		selectDictionary(0, size);
		$(".perSun").text(count);
	}
}
/**
 * 查询词条相关的内容的总数量
 */
function getSunCount(filename) {
	$.ajax({
		type: "post",
		url: UtilAddress + "wordSearch/findValueDetail.do",
		dataType: "json",
		data: {
			"keyword": filename,
			"pageIndex": null,
			"pageSize": null
		},
		async: false,
		success: function(result) {
			sunCount = result.total;
		}
	});
}

/**
 * -------------------------------代码分割线------------------------------------------------
 * 查询文件视频类
 */

function selectFileVideo(pageIndex, pageSize) {
	//点击查询是清空div的内容
//	$("#container2").empty();
	var filename = getInputValue();
	$.ajax({
		type: "post",
		url: UtilAddress + "mediasource/findMediasource.do",
		dataType: "json",
		data: {
			"filename": filename,
			"pageIndex": pageIndex,
			"pageSize": pageSize
		},
		async: true,
		success: function(result) {
			//console.log(JSON.stringify(result));
			var content;
			if(result != null) {
				var data = result;
				//清空div的内容再追加html
				$("#container2").html("");
				for(var i = 0; i < data.rows.length; i++) {
					var DateShow = getDate(data.rows[i].uploadtime);
					var img; //显示是否是视频文件的格式
					var fileStyle; //显示视频图的样式
					if(data.rows[i].format == "mp4") {
						img = "img/video.png";
						fileStyle = "video_img";
					} else {
						img = "img/file.png";
						fileStyle = "file_img";
					}
					content = "<div class='video_show'  onclick='clickDownLoad(" + data.rows[i].sourceid + ")'>" +
						"<div class='left_content'><img class='" + fileStyle + "' src='" + img + "'/></div>" +
						"<div class='rigth_content'>" +
						"<div  class='file_typeName'>" + data.rows[i].filename + "</div>" +
						"<div><span>上传时间：</span><span>" + DateShow + "</span></div>" +
						"</div>" +
						"</div>";
					$("#container2").append(content);
				}
			}
		}
	});
}

/**
 * 动态生成词条相关资料文件底部分页按钮及功能
 */
function videoShow() {
	$("#ui-page2").html("");
	getVideoSunCount(getInputValue());
	var count = videoSunCount;
	if(count <= 0) {
		$("#video_data").html("");
		indexValue = 1;
	} else {
		var size = 6; //parseInt(6);
		var initTotalPageNum = Math.ceil(count / size);
		/* 初始化页面 */
		$("#ui-page2").paging2({
			//显示数字为3个
			pageSize: 3,
			totalPage: initTotalPageNum
		});
		$(".stratNum2").html(1);
		$(".endNum2").html(size);
		//默认显示第一页
		selectFileVideo(0, size);
	}
}

/**
 * 查询词条相关资料文件的总数量
 */
function getVideoSunCount(filename) {
	$.ajax({
		type: "post",
		url: UtilAddress + "mediasource/findMediasource.do",
		dataType: "json",
		data: {
			"filename": filename,
			"pageIndex": null,
			"pageSize": null
		},
		async: false,
		success: function(result) {
			videoSunCount = result.total;
			$(".perSun2").text(videoSunCount);
		}
	});
}

/**
 * 转换时间格式
 */
function getDate(resultdate) {
	var dateTime = new Date(resultdate);
	var getHours = dateTime.getHours() < 10 ? "0" + dateTime.getHours() : dateTime.getHours();
	var dateStr = dateTime.getFullYear() + "/" + (dateTime.getMonth() + 1) + "/" + dateTime.getDate();
	return dateStr;
}

/**
 * 绑定一个单击下载事件
 */
function clickDownLoad(sourceid) {
	var url = this.UtilAddress + "mediasource/doDownLoad.do?id=" + sourceid;
	document.location.href = url;
}