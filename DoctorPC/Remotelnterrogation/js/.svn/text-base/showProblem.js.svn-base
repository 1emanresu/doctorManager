var SUCCESS = 0;
var ERROR = 1;
var address = sessionStorage.getItem('address');
//var address = "http://192.168.1.60:8080/doctormanager/";

$(function(){
	showProblem();
})

var showProblem = function(){
	var url = address + 'foodproblem/selectAll.do';
	$.ajax({
		type: "post",
		url: url,
		async: true,
		data: {},
		success:function(result){
			if(result.state == 0){
				var data = result.data;
					getProblem(data);
			}
		}
	});
}

var getProblem = function(data){
	var answer = data[0].answera;
	var thisan = answer.split("~");
	var length = data.length;
	var htm = '';
	htm += "<div>"+
		"您好，您已开始进行膳食分析问卷，共计"+length+"个小问题，预计花费3分钟完成，现在开始咯~</div>";
	for (var i=0;i<data.length;i++) {
		htm += "<div class='problem_box'>"+
		"<span>"+"Q"+data[i].fpid+":"+"</span><span>"+data[i].problem+"</span>"+
								"<br />"+
								"<div class='problem_but_3k'>"+
									"<button onclick='getAnswer(this)'>"+thisan[0]+"</button>"+
									"<button onclick='getAnswer(this)'>"+thisan[1]+"</button>"+
									"<button onclick='getAnswer(this)'>"+thisan[2]+"</button>"+
								"</div>";
			htm += "</div>";
	}
	/*console.log(htm)*/ 
	$('#shanshiwenjuan1').html(htm);
}
function getAnswer(a){
	return false;
}
