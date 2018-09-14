var canvas_;
var context;
//判断鼠标是否按下
var m_down = false;
var array_paint = [];
var current_y = 0;
var current_x = 0;

function mark(id) {
	var id = $("#" + id);
	var canvas_ = document.createElement("canvas");
	canvas_.height = id.height();
	canvas_.width = id.width();
	canvas_.setAttribute("id", "myCanvas")
	id.append(canvas_);
	context = canvas_.getContext("2d");
	//画笔颜色
	context.strokeStyle = "blue";
	//画笔宽度
	context.lineWidth = 2;

	//按下鼠标
	canvas_.onmousedown = function(event) {
		m_down = true;
		current_x = event.offsetX;
		current_y = event.offsetY;
		array_paint.push([current_x, current_y]);
		paint();
	}

	//鼠标松开,清空数据
	canvas_.onmouseup = function(event) {
		m_down = false;
		array_paint = [];
	}
	
	
	//离开范围内，清空数据
	canvas_.onmouseout = function(event) {
		var x = event.clientX;
		var y = event.clientY;
		var divx1 = canvas_.offsetLeft;
		var divy1 = canvas_.offsetTop;
		var divx2 = canvas_.offsetLeft + div.offsetWidth;
		var divy2 = canvas_.offsetTop + div.offsetHeight;
		if(x < divx1 || x > divx2 || y < divy1 || y > divy2) {
			//如果离开，则执行。。
			m_down = false;
			array_paint = [];
		}

	}

	//鼠标按下后拖动
	canvas_.onmousemove = function(event) {
		if(m_down) {
			current_x = event.offsetX;
			current_y = event.offsetY;
			array_paint.push([current_x, current_y]);
			paint();
		}
	}
}

function paint() {
	context.beginPath();
	context.moveTo(array_paint[0][0], array_paint[0][1]);
	if(array_paint.length == 1)
		context.lineTo(array_paint[0][0] + 1, array_paint[0][1] + 1);
	else {
		var i = 1;
		for(i in array_paint) {
			context.lineTo(array_paint[i][0], array_paint[i][1]);
			context.moveTo(array_paint[i][0], array_paint[i][1]);
		}

	}
	context.closePath();
	context.stroke();
}