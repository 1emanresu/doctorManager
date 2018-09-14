var address=sessionStorage.getItem("address");
//var address = "http://192.168.1.26:8080/doctormanager/";
//改变鼠标形状
$(".advice-table1 tr td").mouseover(function() {
	$(this).css("cursor", "pointer");
});
//模糊查询医嘱库
var keyword = '';
function searchKnowledge() {
	keyword = $("#search_keyword").val().trim();
	if(keyword == '') {
		alert("搜索关键字不能为空");
	} else {
		getknowledge();
	}
}
function clickKeyWord(e) {
	keyword = $(e).text();
	getknowledge();
};

function getknowledge() {
	$.ajax({
		type: "post",
		dataType: "json",
		data: {
			"keyword": keyword
		},
		url: address + "knowledge/queryByKeyword.do",
		success: function(result) {
			var list = result.data;
			var tableStr = '';
			if(list.length != 0) {
				$.each(list, function(i) {
					tableStr += "<tr><td ondblclick='choiceAdvice(this)'>" + list[i] + "</td></tr>";
				});
				$(".advice-table2 tr").remove();
				$(".advice-table2").append(tableStr);
			} else {
				alert("暂无相关医嘱");
			}
		},
		error: function() {}
	});
}
function choiceAdvice(e) {
	$("#sendMessageTextArea").text($("#sendMessageTextArea").text() + $(e).text().trim());
}
var table1="<tr style='cursor:pointer'><td onclick='clickKeyWord(this)'>羊水过少</td><td onclick='clickKeyWord(this)'>饮食</td><td onclick='clickKeyWord(this)'>少盐</td><td onclick='clickKeyWord(this)'>运动</td><td onclick='clickKeyWord(this)'>左侧卧</td><td onclick='clickKeyWord(this)'>血压监测</td></tr>";
var table2="<tr style='cursor:pointer'><td onclick='clickKeyWord(this)'>地西泮</td><td onclick='clickKeyWord(this)'>肼苯哒嗪</td><td onclick='clickKeyWord(this)'>叶酸</td><td onclick='clickKeyWord(this)'>维生素</td><td onclick='clickKeyWord(this)'>硫酸镁</td><td onclick='clickKeyWord(this)'>甲基多巴</td></tr>";
var table3="<tr style='cursor:pointer'><td onclick='clickKeyWord(this)'>解痉</td><td onclick='clickKeyWord(this)'>镇静</td><td onclick='clickKeyWord(this)'>降压</td><td onclick='clickKeyWord(this)'>利尿</td><td onclick='clickKeyWord(this)'>扩容</td><td onclick='clickKeyWord(this)'>子痫</td></tr>";
var table4="<tr style='cursor:pointer'><td onclick='clickKeyWord(this)'>胰岛素</td><td onclick='clickKeyWord(this)'>饮食</td><td onclick='clickKeyWord(this)'>运动</td><td onclick='clickKeyWord(this)'>控糖</td></tr>";
var table5="<tr style='cursor:pointer'><td onclick='clickKeyWord(this)'>补铁</td><td onclick='clickKeyWord(this)'>叶酸</td><td onclick='clickKeyWord(this)'>吸氧</td><td onclick='clickKeyWord(this)'>饮食</td><td onclick='clickKeyWord(this)'>维生素</td></tr>";
var table6="<tr style='cursor:pointer'><td onclick='clickKeyWord(this)'>维生素</td><td onclick='clickKeyWord(this)'>叶酸</td><td onclick='clickKeyWord(this)'>少食</td><td onclick='clickKeyWord(this)'>控盐</td></tr>";
function queryAdvice(i) {
	$(".advice-table1 tr").remove();
	if(i==1){
		keyword = '饮食';
		getknowledge();
		$(".advice-table1").append(table1);
	}else if(i==2){
		keyword = "药";
		getknowledge();
		$(".advice-table1").append(table2);
	}else if(i==3){
		keyword = '血压监测';
		getknowledge();
		$(".advice-table1").append(table3);
	}else if(i==4){
		keyword = '血糖监测';
		getknowledge();
		$(".advice-table1").append(table4);
	}else if(i==5){
		keyword = '饮食';
		getknowledge();
		$(".advice-table1").append(table5);
	}else if(i==6){
		keyword = '饮食';
		getknowledge();
		$(".advice-table1").append(table6);
	}
	$("#myAdviceModal").modal('show');
	//删除classmodal-backdrop，可去除阴影
	$(".modal-backdrop").attr("class",'');
}
$("#searchAdvice_close").click(function(){
	$("#myAdviceModal").modal('hide');
})
