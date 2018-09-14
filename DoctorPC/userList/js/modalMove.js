$(document).on("show.bs.modal", ".modal", function() {
	$(this).draggable({
		//        handle: ".modal-header"   // 只能点击头部拖动
	});
	// 防止出现滚动条，出现的话，你会把滚动条一起拖着走的
	$(this).css("overflow", "hidden");
});
$(function() {
	$(".modalMove").mousedown(function(e) {
		iDiffX = e.pageX - $(this).offset().left;
		iDiffY = e.pageY - $(this).offset().top;
		var modalthis = $(this);
		$(document).mousemove(function(e) {
			modalthis.css({
				"left": (e.pageX - iDiffX),
				"top": (e.pageY - iDiffY)
			});
		});
		//当鼠标到浏览器外面时，拖动事件停止
		var iEvent = e || event;
		if(iEvent.clientY > parseInt(window.innerHeight) || iEvent.clientY < 0 || iEvent.clientX < 0 || iEvent.clientX > parseInt(window.innerWidth)) {
			$(document).unbind("mousemove");
		}
	});
	$(".modalMove").mouseup(function() {
		$(document).unbind("mousemove");
	});
	$(".modalMove").css("border-radius", "5px");
});