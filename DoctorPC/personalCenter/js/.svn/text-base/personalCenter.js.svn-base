var address = sessionStorage.getItem('address')
var did=sessionStorage.getItem("doctorId");
//address = 'http://192.168.1.38:8080/doctormanager/'
//did = '15'
function display(num) {
	if(num == 1) {
		$("#panel-978065").css('display', 'none');
		$("#panel-978066").css('display', 'inherit');

	} else if(num == 2) {
		$("#panel-978066").css('display', 'none');
		$("#panel-978065").css('display', 'inherit');

	}
}
$(function() {
	//加载科室  医院信息
	loadOfInfo();
	loadHpInfo();
	loadInfo();
	//保证信息
	$('#u4171').click(function() {
		saveInfo();
	});
	//验证密码
	$('#u4284_div').blur(function() {
		checkPwd();
	});
	//修改密码
	$('#u4296').click(function() {
		//判断密码长度大于6
		if($('#u4289_div').val().length > 5 && $('#u4289_div').val().length<=11) {
			//新密码与再次输入一致后 更新密码 否则提醒正确输入
			if($('#u4289_div').val() == $('#u4294_div').val()) {
				changPwd()
			} else {
				
			}
		} else {
			return;
		}

	});
});
/**
 * 查询并加载医师信息
 */
function loadInfo() {
	$.ajax({
		type: "post",
		dataType: "json",
		data: {
			"did": did
		},
		url: address + "personCentor/doctorInfo.do",
		success: function(result) {
			$('#u4176_div').val(result.data.dname)
			$('#u4181_div').val(result.data.dphone)
			//固定电话
			$('#u4186_div').val(result.data.fixedTelephone);
			//邮箱地址
			$('#u4191_div').val(result.data.email);
			//所属科室
			$("#u4196_div option[value='" + result.data.officeid + "']").attr("selected", "selected");
			//所属医院
			$("#u4167_div option[value='" + result.data.hospitalid + "']").attr("selected", "selected");
		},
		error: function() {}
	});
}
/**
 * 查询并加载科室信息
 */
function loadOfInfo() {
	$.ajax({
		type: "post",
		dataType: "json",
		async: false,
		url: address + "personCentor/loadOfInfo.do",
		success: function(result) {
			for(var i = 0; i < result.data.length; i++) {
				$('#u4196_div').append("<option value=" + result.data[i].officeid + ">" + result.data[i].officename + "</option>");
			}

		},
		error: function() {}
	});
}
/**
 * 查询医院信息
 */
function loadHpInfo() {
	$.ajax({
		type: "post",
		dataType: "json",
		async: false,
		url: address + "personCentor/loadHpInfo.do",
		success: function(result) {
			for(var i = 0; i < result.data.length; i++) {
				$('#u4167_div').append("<option value=" + result.data[i].hospitalid + ">" + result.data[i].hospitalname + "</option>");
			}
		},
		error: function() {}
	});
}
/**
 * 保存个人资料
 */
function saveInfo() {
	$.ajax({
		type: "post",
		dataType: "json",
		data: {
			doctorid: did,
			dname: $('#u4176_div').val(),
			dphone: $('#u4181_div').val(),
			fixedTelephone:$('#u4186_div').val(),
			email: $('#u4191_div').val(),
			officeid: $('#u4196_div').val(),
			hospitalid: $('#u4167_div').val()
		},
		url: address + "personCentor/saveInfo.do",
		success: function(result) {
			if(result >= 0) {
				alert('保存成功')
				window.location.reload();
			}
		},
		error: function() {}
	});
}

function checkPwd() {
	var userName = $('#u4181_div').val();
	var pwd = $('#u4284_div').val()
	$.ajax({
		type: "post",
		dataType: "json",
		data: {
			'username': userName,
			'pwd': pwd
		},
		url: address + "personCentor/checkPwd.do",
		success: function(result) {
			if(result == 1) {
				$('#u4284_div').css('background', 'url("images/ch43.png") no-repeat scroll right center transparent');
				$('.wrong').hide();
			} else {
				$('#u4284_div').css('background', 'url("images/wrong.png") no-repeat scroll right center transparent')
				$('.wrong').show();
				$('#u4284_div').focus();
			}
		},
		error: function() {}
	});
}

function changPwd() {
	var userName = $('#u4181_div').val();
	var newPwd = $('#u4294_div').val();
	$.ajax({
		type: "get",
		dataType: "json",
		data: {
			'username': userName,
			'password': newPwd
		},
		url: address + "personCentor/changPwd.do",
		success: function(result) {
			if(result >= 1) {
				alert('修改成功')
				window.location.reload();
			} else {
				alert('稍后再试')
				return;
			}
		},
		error: function() {}
	});
}