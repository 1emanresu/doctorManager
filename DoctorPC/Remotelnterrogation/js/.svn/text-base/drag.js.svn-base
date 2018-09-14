//实现拖动
function allowDrop(ev) {
	ev.preventDefault();
}

function dragToSend(ev) {
	ev.dataTransfer.setData("Text", ev.target.id);
}

function draglabel1(ev) {
	ev.dataTransfer.setData("Text", ev.target.id);
}
//拖动后放手事件
function drop(ev) {
	ev.stopPropagation(); //阻止拖动时在浏览器中出现新的搜索页面
	ev.preventDefault(); //阻止默认行为
	var data = ev.dataTransfer.getData("Text");
	var sendHtm = $("#" + data + " " + ".problem");
	//实现分开	多条发送
		sendMessage(sendHtm[0].innerHTML, 3);
		var i=1;
		var s;
		s=setInterval(function() {
			if(i < sendHtm.length) {
				sendMessage(sendHtm[i].innerHTML, 3);
			}else{
				clearInterval(s);
			}
			i++;
		}, 4000);
}