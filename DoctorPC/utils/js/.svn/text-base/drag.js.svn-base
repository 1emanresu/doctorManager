//采用绝对定位的拖动方法
function drag(element) {
	element.mousedown(function(e) {
		iDiffX = e.pageX - $(this).offset().left;
		iDiffY = e.pageY - $(this).offset().top;
		$(document).mousemove(function(e) {
			element.css({
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
	element.mouseup(function(e) {
		$(document).unbind("mousemove");
	});
}

//采用固定定位的拖动方法
function drag2(element) {
	element.mousedown(function(e) {
		iDiffX = e.pageX - element[0].getBoundingClientRect().left;
		//算出鼠标到元素顶部的距离
		iDiffY = e.pageY - element[0].getBoundingClientRect().top;
		$(document).mousemove(function(e) {
			element.css({
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
	element.mouseup(function(e) {
		$(document).unbind("mousemove");
	});
}