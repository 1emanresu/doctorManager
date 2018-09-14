//var address = "http://192.168.1.49:8080/doctormanager/";
var address=sessionStorage.getItem("address");
//改变鼠标形状
$(".advice-table1 tr td").mouseover(function() {
	$(this).css("cursor", "pointer");
});
//模糊查询医嘱库
var keyword = '';
$(".advice-table1 tr td").click(function() {
	keyword = $(this).text();
	getknowledge();
});

function searchKnowledge() {
	keyword = $("#search_keyword").val().trim();
	if(keyword == '') {
		alert("搜索关键字不能为空");
	} else {
		getknowledge();
	}
}

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
$("#modalShow a").click(function(){
	$("#myModal1_textarea").text($('#thisAdvice_content').val());
	$("#myAdviceModal").modal("show");
})

function myModal1Hide(){
	$("#myAdviceModal").modal("hide");
}

function changeDoctorAdvice() {
	$("#thisAdvice_content").val($('#myModal1_textarea').val());
	$('#myAdviceModal').modal('hide');
}

function saveMyAdvice1() {
	var doctor_advice = $("#myModal1_textarea").val().trim();
	if(doctor_advice != '') {
		$.ajax({
			type: "post",
			dataType: "json",
			data: {
				"doctorid": doctorId,
				"myknowledge": doctor_advice
			},
			url: address + "myAdvice/insert.do",
			success: function(result) {
				alert("保存成功！")
			},
			error: function() {}
		});
	} else {
		alert("医嘱不能为空");
	}
}
function choiceAdvice(e) {
	$("#myModal1_textarea").val($("#myModal1_textarea").val() + $(e).text().trim());
}
function queryAdvice() {
	$("#myModal1_textarea").text($('#thisAdvice_content').val());
	$("#myAdviceModal").modal('show');
}
