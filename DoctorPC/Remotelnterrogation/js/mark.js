//用于记录选择的形状
function huabi() {
	/*document.ondragstart = function() {
		return false;
	} //ie禁止拖拽
	document.onselectstart = function() {
		return false;
	} //ie禁止选定
*/
	canvas_size = {
		x: $("#canvas").width(),
		y: $("#canvas").height()
	};
	origin = {
		x: 0,
		y: 0
	}
	end = {
		x: 0,
		y: 0
	}
	type = 0;
	drawable = false;
	color_changeable = false;

	canvas = document.getElementById("canvas");
	canvas2 = document.getElementById("canvas2");

	context = canvas.getContext('2d');
	context.strokeStyle = "red";
	fill_canvas("#ffffff");
	context.lineWidth = 1;
	context2 = canvas2.getContext('2d');
	context2.strokeStyle = "red";
	context2.lineWidth = 1;
	canvas_rgb = {
		r: 1,
		g: 1,
		b: 1
	};

	/*鼠标按下事件*/
	$(canvas2).bind('mousedown', function(event) {
        var ps = GetPageScroll();
        drawable = true;
        origin.x = event.clientX - $("#canvas").offset().left + ps.X;
        origin.y = event.clientY - $("#canvas").offset().top + ps.Y;
	});
	$(canvas2).bind('mouseup', function(event) {
		canvas_backup = context.getImageData(0, 0, canvas.width, canvas.height);
	});

	/*鼠标松开事件*/
	$(canvas2).bind('mouseup', function(event) {
		if((type == 1 || type == 3 || type == 4) && drawable == true) {
			var ps = GetPageScroll();
            drawable = false;
            context2.clearRect(0, 0, canvas_size.x, canvas_size.y);
            end.x = event.clientX - $("#canvas").offset().left + ps.X;
            end.y = event.clientY - $("#canvas").offset().top + ps.Y;
            draw(context);
		} else
			drawable = false;
		color_changeable = false;
	});
	/*鼠标移动事件*/
	$(canvas2).bind("mousemove", function(event) {
		if(drawable == false) return;
        var ps = GetPageScroll();
		if(type == 0) {
            end.x = event.clientX - $("#canvas").offset().left + ps.X;
            end.y = event.clientY - $("#canvas").offset().top + ps.Y;
			draw(context);
			origin.x = end.x;
			origin.y = end.y;
		} else if(type == 1 || type == 3 || type == 4 || type == 5) {
            end.x = event.clientX - $("#canvas").offset().left + ps.X;
            end.y = event.clientY - $("#canvas").offset().top + ps.Y;
			//橡皮擦功能
			if(type == 5) {
				//fill_canvas('#00aeff', end.x - 10, end.y - 10, 20, 20);
				context.save();
				context.beginPath();
				context.arc(end.x - 10, end.y - 10, 20, 0, Math.PI * 2, false)
				context.clip();
				context.clearRect(0, 0, canvas.width, canvas.height)
				context.restore();
				return;
			} else
				context2.clearRect(0, 0, canvas_size.x, canvas_size.y);
			draw(context2);
		} else if(type == 2) {
            end.x = event.clientX - $("#canvas").offset().left + ps.X;
            end.y = event.clientY - $("#canvas").offset().top + ps.Y;
			draw(context);
		}
	});
	//设置默认颜色，图形
	change_attr(-1, -1, "red");
	change_attr(3, -1, -1);
	$(".span_color").click(function() {
		var col = $(this).children().attr("title");
		change_attr(-1, -1, col);
	});

	$(".size_div").click(function() {
		if($("#size_bar").css("display") == "none") {
			$("#size_bar").show();
		} else {
			$("#size_bar").hide();
		}
	});

	/*选择粗细的进度条*/
	$("#size_bar").bind("mousedown", function(event) {
		var thumb = $("#size_thumb");
		var main_w = $(this).width();
		var mainLeft = $(this).offset().left;
		thumb.css("left", event.clientX - mainLeft - thumb.width() / 2 + "px");
		$("#size_span").html(Math.ceil($(thumb).position().left / main_w * 5) + 1);
		change_attr(-1, $("#size_span").html(), -1);
		$(document).bind("mousemove", size_bar_move);
		$(document).bind("mouseup", function unbind(event) {
			$(document).unbind("mousemove", size_bar_move);
			$(document).unbind("mouseup", unbind);
		});
	});

	$("#r_channel_bar").bind("mousedown", function(event) {
		var thumb = $("#r_channel_thumb");
		var main_w = $(this).width();
		var mainLeft = $(this).offset().left;
		thumb.css("left", event.clientX - mainLeft - thumb.width() / 2 + "px");
		$(document).bind("mousemove", {
			c: "r"
		}, channel_bar_move);
		$(document).bind("mouseup", function unbind(event) {
			canvas_rgb.r = 0.5 + $(thumb).position().left / main_w;
			change_channel();
			$(document).unbind("mousemove", channel_bar_move);
			$(document).unbind("mouseup", unbind);
		});
	});
	$("#g_channel_bar").bind("mousedown", function(event) {
		var thumb = $("#g_channel_thumb");
		var main_w = $(this).width();
		var mainLeft = $(this).offset().left;
		thumb.css("left", event.clientX - mainLeft - thumb.width() / 2 + "px");
		$(document).bind("mousemove", {
			c: "g"
		}, channel_bar_move);
		$(document).bind("mouseup", function unbind(event) {
			canvas_rgb.g = 0.5 + $(thumb).position().left / main_w;
			change_channel();
			$(document).unbind("mousemove", channel_bar_move);
			$(document).unbind("mouseup", unbind);
		});
	});
	$("#b_channel_bar").bind("mousedown", function(event) {
		var thumb = $("#b_channel_thumb");
		var main_w = $(this).width();
		var mainLeft = $(this).offset().left;
		thumb.css("left", event.clientX - mainLeft - thumb.width() / 2 + "px");
		$(document).bind("mousemove", {
			c: "b"
		}, channel_bar_move);
		$(document).bind("mouseup", function unbind(event) {
			canvas_rgb.b = 0.5 + $(thumb).position().left / main_w;
			change_channel();
			$(document).unbind("mousemove", channel_bar_move);
			$(document).unbind("mouseup", unbind);
		});
	});

}

function size_bar_move(e) {
	var thumb = $("#size_thumb");
	var main_w = $("#size_bar").width();
	var mainLeft = $("#size_bar").offset().left;
	if(e.clientX - mainLeft < 0){
		thumb.css("left", -thumb.width() / 2 + "px");
	}else if(e.clientX - mainLeft > main_w){
		thumb.css("left", main_w - thumb.width() / 2 + "px");
	}else{
		thumb.css("left", e.clientX - mainLeft - thumb.width() / 2 + "px");
	}
	$("#size_span").html(Math.ceil($(thumb).position().left / main_w * 5) + 1);
	change_attr(-1, $("#size_span").html(), -1);
}

function channel_bar_move(e) {
	var c = e.data.c;
	var thumb = $("#" + c + "_channel_thumb");
	var main_w = $("#" + c + "_channel_bar").width();
	var mainLeft = $("#" + c + "_channel_bar").offset().left;
	if(e.clientX - mainLeft < 0)
		thumb.css("left", -thumb.width() / 2 + "px");
	else if(e.clientX - mainLeft > main_w)
		thumb.css("left", main_w - thumb.width() / 2 + "px");
	else
		thumb.css("left", e.clientX - mainLeft - thumb.width() / 2 + "px");
}

function draw(context) {
	if(type == 0 || type == 1 || type == 2) {
		context.beginPath();
		context.moveTo(origin.x, origin.y);
		context.lineTo(end.x, end.y);
		context.stroke();
	} else if(type == 3) {
		var k = ((end.x - origin.x) / 0.75) / 2,
			w = (end.x - origin.x) / 2,
			h = (end.y - origin.y) / 2,
			x = (end.x + origin.x) / 2,
			y = (end.y + origin.y) / 2;
		context.beginPath();
		context.moveTo(x, y - h);
		context.bezierCurveTo(x + k, y - h, x + k, y + h, x, y + h);
		context.bezierCurveTo(x - k, y + h, x - k, y - h, x, y - h);
		context.closePath();
		context.stroke();
	} else if(type == 4) {
		context.beginPath();
		context.rect(origin.x, origin.y, end.x - origin.x, end.y - origin.y);
		context.stroke();
	}
}

function change_attr(tp, sz, clr) {
	if(tp != -1)
		type = tp;
	if(clr != -1) {
		context.strokeStyle = clr;
		context2.strokeStyle = clr;
	}
	if(sz != -1) {
		context.lineWidth = sz;
		context2.lineWidth = sz;
	}
}

function clear_canvas() {
	context.clearRect(0, 0, canvas_size.x, canvas_size.y);
}

function fill_canvas(col, orix, oriy, w, h) {
	context.fillStyle = col;
	context.fillRect(orix, oriy, w, h);
}

function change_channel() {
	can_data = context.getImageData(0, 0, canvas.width, canvas.height);
	for(var i = 0; i < canvas.width; i++) {
		for(var j = 0; j < canvas.height; j++) {
			var idx = (i + j * can_data.width) * 4;
			can_data.data[idx + 0] = canvas_backup.data[idx + 0] * canvas_rgb.r;
			can_data.data[idx + 1] = canvas_backup.data[idx + 1] * canvas_rgb.g;
			can_data.data[idx + 2] = canvas_backup.data[idx + 2] * canvas_rgb.b;
		}
	}
	context.putImageData(can_data, 0, 0);
}

//画笔样式html
var hml = "<div id='but'><div id='drayTool'><div style='border-right:gainsboro solid 1px;flex: 2;'><div style='display: flex;height: 35px;'>" +
	"<span style='flex: 1;padding-top: 5px;' onClick='change_attr(0,-1,-1)'><img src='images/pencil_48px.png' width='25px' /></span>" +
	"<span style='flex: 1;padding-top: 5px;' onClick='change_attr(5,-1,-1)'><img src='images/draw_eraser.png' width='25px' /></span>" +
	"</div><span class='fontmei'>工具</span>	</div><div style='flex: 1;border-right:gainsboro solid 1px;'><div style='height: 35px;display: flex'>" +
	"<span style='flex:1;margin-top: 5px;' onClick='clear_canvas()'><img src='images/paint_brush.png' width='25px' /></span></div>" +
	"<span class='fontmei'>刷子</span></div><div style='flex: 3;border-right:gainsboro solid 1px;'><div style='display: flex;border: gainsboro solid 1px;margin:3px 5px;padding: 2px;'>" +
	"<span style='flex: 1;' onClick='change_attr(1,-1,-1)'><img src='images/zhixian.png' width='25px'/></span>" +
	"<span style='flex: 1;' onClick='change_attr(3,-1,-1)'><img src='images/tuoyuan.png' width='25px'/></span>" +
	"<span style='flex: 1;' onClick='change_attr(4,-1,-1)'><img src='images/changfangxing.png' width='40px' height='25px'/></span>" +
	"</div><span class='fontmei'>形状</span></div><div style='flex: 1;border-right:gainsboro solid 1px;'><div class='size_div'>" +
	"<div style='margin-top: 5px;'><img src='images/cuxi.png' width='35px' /></div><div class='fontmei' style='margin-top:3px;'>粗细</div>" +
	"<div id='size_bar'><span id='size_span'>1</span><span id='size_thumb'></span></div></div></div><div style='flex: 2;'><div style='height: 22px;margin-left: 5px;'>" +
	"<div class='span_color'><div style='background: blue;' title='blue'></div></div><div class='span_color'><div style='background: red;' title='red'></div>" +
	"</div><div class='span_color'><div style='background: orange;' title='orange'></div></div></div><div style='height: 23px;margin-left: 5px;'><div class='span_color'>" +
	"<div style='background: yellow;' title='yellow'></div></div><div class='span_color'><div style='background: gray;' title='gray'></div></div><div class='span_color'>" +
	"<div style='background: black;' title='black'></div></div></div></div></div></div>";

var that2;

//开始画
function mark2(that, id) {
	if($(that).text() == "标记") {
		$(that).text("取消标记");
		//取消拖动事件
		$(".modalMove").unbind();
		that2 = $(that);
		$("#drayTool").remove();
		$("#" + id).after(hml);
		var id = $("#" + id);
		if(!document.getElementById("canvas")) {
			var canvas_ = document.createElement("canvas");
			canvas_.height = id.height();
			canvas_.width = id.width();
			canvas_.setAttribute("id", "canvas")
			id.append(canvas_);
		}
		if(!document.getElementById("canvas2")) {
			var canvas2_ = document.createElement("canvas");
			canvas2_.height = id.height();
			canvas2_.width = id.width();
			canvas2_.setAttribute("id", "canvas2")
			id.append(canvas2_);
		}
		//调用画笔功能
		huabi();
	} else {
		off();
		$(that).text("标记");
	}
}

//取消画笔
function off() {
	//加入拖动事件
	addDrag();
	//删除画笔工具
	$("#drayTool").remove();
	//清除画布
	$("#canvas,#canvas2").remove();
}
//隐藏所有，打开指定工具
function openTool(id) {
	$(".tool").hide();
	$('#content_right').css('width','25%');
	$('#tool').css('width','15%');
	$('#content_middle').css('width','55%')
	$("#" + id).show();
}

//关闭工具,同时清除画布,清除工具栏，显示标记按钮
$(function() {
	//加入拖动事件
	addDrag();
	$(".close img,.report_close").click(function() {
		if(document.getElementById("canvas")) {
			$("#canvas,#canvas2").remove();
			$("#drayTool").remove();
			$('.markBut').html('标记');
		}
		$("#div_report").css('display', 'none');
		$('.testData').css('display', 'none');
	})
});
var bloodpressureSelfTestFlag = true;
var bloodsugarSelfTestFlag = true;
var fetalSmSelfTestFlag = true;
var fetalLargeSelfTestFlag = true;
var weightSelfTestFlag = true;
var fetalMovementSelfTestFlag = true;
var uterineSelfTestFlag = true;
var circumferenceSelfTestFlag = true;
var bloodoxygenSelfTestFlag = true;
var temperatureSelfTestFlag = true;
var bloodfatSelfTestFlag = true;
var electrocardioSelfTestFlag = true;
var sportsSelfTestFlag = true;
var urineSelfTestFlag = true;

function showTestDate(id, i) {
	if(document.getElementById("canvas")) {
		$("#canvas,#canvas2").remove();
		$("#drayTool").remove();
	}
	if(that2 != undefined) {
		that2.parent().show();
	}
	$(".testData").hide();
	if(i == 1 && bloodpressureSelfTestFlag) {
		bloodpressure();
		bloodpressureSelfTestFlag = false;
	}
	if(i == 2 && bloodsugarSelfTestFlag) {
		bloodsugar();
		bloodsugarSelfTestFlag = false;
	}
	if(i == 3 && fetalSmSelfTestFlag) {
		fetalSmall();
		//		fetalSmSelfTestFlag=false;
	}
	if(i == 4 && fetalLargeSelfTestFlag) {
		fetalLarge();
		//		fetalLargeSelfTestFlag=false;
	}
	if(i == 5 && weightSelfTestFlag) {
		weight();
		weightSelfTestFlag = false;
	}
	if(i == 6 && fetalMovementSelfTestFlag) {
		featalMovement2();
		fetalMovementSelfTestFlag = false;
	}
	if(i == 7 && uterineSelfTestFlag) {
		fundalHeight();
		uterineSelfTestFlag = false;
	}
	if(i == 8 && circumferenceSelfTestFlag) {
		abdominalCircumference();
		circumferenceSelfTestFlag = false;
	}
	if(i == 9 && bloodoxygenSelfTestFlag) {
		bloodoxygen2();
		bloodoxygenSelfTestFlag = false;
	}
	if(i == 10 && temperatureSelfTestFlag) {
		temperature();
		temperatureSelfTestFlag = false;
	}
	if(i == 11 && bloodfatSelfTestFlag) {
		bloodfat();
		bloodfatSelfTestFlag = false;
	}
//	if(i == 12 && electrocardioSelfTestFlag) {
//
//	}
//	if(i == 13 && sportsSelfTestFlag) {
//
//	}
//	if(i == 14 && urineSelfTestFlag) {
//
//	}
	$("#" + id).css('display', 'block');
}

//拖动事件
function addDrag() {
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
}

/*获取滚动条位置*/
function GetPageScroll() { 
    var x, y;
    if(window.pageYOffset) {
        // all except IE
        y = window.pageYOffset;    
        x = window.pageXOffset; 
    } else if(document.documentElement && document.documentElement.scrollTop) {
        // IE 6 Strict
        y = document.documentElement.scrollTop;    
        x = document.documentElement.scrollLeft; 
    } else if(document.body) {
        // all other IE
        y = document.body.scrollTop;    
        x = document.body.scrollLeft;   
    } 
    return {X:x, Y:y};
}