var address = sessionStorage.getItem("address");
//var address = "http://192.168.1.38:8080/doctormanager/";
var vid;
$(function(){
	find();//查询套餐
	vid = getVipId();//给vid赋值
});

//随机生成vid
function getVipId() {
	var vid = '0';
	for(var i = 0; i < 3; i++) {
		vid += Math.floor(Math.random() * 10);
	}
	return vid;
}

/*新增服务*/
$('#save').click(function(){
	var t_name = $('#t_name').val();
	var t_project = $('#t_project').val();
	var t_intrduce = $('#t_intrduce').val();
	var t_price = $('#t_price').val();
	var t_times = $('#t_times').val();
	var t_tips = $('#t_tips').val();
	var t_instructions = $('#t_instructions').val();
	
	$.ajax({
		type:"post",
		url: address + "vipGrade/insertSelective.do",
		async:false,
		data:{
			vipgradeid: vid,
			vipgradename: t_name,
			projectdetail: t_project,
			vipintroduce: t_intrduce,
			vipprices: t_price,
			usetimes: t_times,
			handletips: t_tips,
			instructions: t_instructions
		},
		success:function(result){
			if(result >= 0){
				alert("新增服务成功");
				window.location.reload();
			}
		},
		error:function(e){
			console.log(JSON.stringify(e));
		}
	});
});

//查询套餐
function find(){
	$.ajax({
		type:"get",
		url: address + "vipGrade/find.do",
		async:false,
		success:function(result){
			var data = result.data;
			if(data != null && data != ''){
				for(i=0;i<data.length;i++){
					var projectdetail = data[i].projectdetail;
					var name = data[i].vipgradename;
					if(projectdetail == null){
						projectdetail = '无';
					}
					var code ='<div class="body_content">'+
								'<div class="list_name">'+name+'</div>'+
								'<div class="list_content">'+projectdetail+'</div>'+
								'<div class="list_operation">'+
								'	<a onclick="update(this);">编辑</a> | <a onclick="deleteMessage(this)">删除</a>'+
								'</div>'+
								'</div>';
					$('.list_body').append(code);
				}
			}
		},
		error:function(e){
			console.log(JSON.stringify(e));
		}
	});
}

/*根据套餐名来获取vipId*/
var id;
function getid(name){
	$.ajax({
		type:"post",
		url: address + "vipGrade/selectByName.do",
		async:false,
		data:{
			vipgradename: name
		},
		success:function(result){
			id = result.data.vipgradeid;
			showdata(result.data);
		},
		error:function(e){
			console.log(JSON.stringify(e))
		}
	});
}



//编辑套餐
function update(data){
	$('.show_data').hide();
	$('.update_data').show();
	var update_name = data.parentNode.parentNode.childNodes[0].innerText;
	$('#title_name').html(update_name);
	getid(update_name);
	
	//编辑套餐后保存
	$('#a_save').click(function(){
		var vipgradename = $('#vipgradename').val().trim();//套餐名称
		var projectdetail = $('#projectdetail').val();//套餐项目
		var vipintroduce = $('#vipintroduce').val();//服务说明
		var price = $('#price').val();//收费
		var usetimes = $('#usetimes').val();//服务次数
		var handletips = $('#handletips').val();//小贴士
		var instructions = $('#instructions').val();//操作指南
		var info = {
			"vipgradeid": id,
			"vipgradename": vipgradename,
			"projectdetail": projectdetail,
			"vipintroduce": vipintroduce,
			"vipprices": price,
			"usetimes":usetimes,
			"handletips": handletips,
			"instructions": instructions
		};
		$.ajax({
			type:"post",
			url: address + "vipGrade/updateByVid.do",
			async:false,
			data:info,
			success:function(result){
				if(result >= 0){
					alert("修改成功");
					window.location.reload();
				}
			},
			error:function(e){
				console.log(JSON.stringify(e));
			}
		});
	});
	
}

//删除套餐
function deleteMessage(data){
	fun();
	$('#submit11').click(function() {
		var name = data.parentNode.parentNode.childNodes[0].innerText;
		console.log(name)
		getid(name);
		
		$.ajax({
			type:"post",
			url: address + "vipGrade/deleteByPrimaryKey.do",
			async:false,
			data:{
				vipgradeid: id
			},
			success:function(result){
				if(result >= 0){
					window.location.reload();
				}
			},
			error:function(e){
				console.log(JSON.stringify(e))
			}
		});
	});
	
}

//点击编辑后，在编辑框内显示之前的数据
function showdata(data){
	document.getElementById('vipgradename').value = data.vipgradename;//套餐名称
	document.getElementById('projectdetail').value = data.projectdetail;//套餐项目
	document.getElementById('vipintroduce').value = data.vipintroduce;//服务说明
	document.getElementById('price').value = data.vipprices;//收费
	document.getElementById('usetimes').value = data.usetimes;//套餐项目
	document.getElementById('handletips').value = data.handletips;//小贴士
	document.getElementById('instructions').value = data.instructions;//操作指南
}

$('#a_back').click(function(){
	$('.show_data').show();
	$('.update_data').hide();
})

$('#cancel11,#close').click(function() {
	$('#alert').modal('hide');
});

function fun() {
	$('#alert').modal('show');
}