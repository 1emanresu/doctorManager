/*
 *@author zhangqt
 * @date 2017-10-13
 * */
//医院id
var hid;
//医生名称
var dname;
var oTable;
//请求参数
var param;
var address = sessionStorage.getItem("address");
$(function() {
	//获取医院下拉列表 
	getHospitalList();
	//查询职位
	getposition();
	//科室下拉
	getOfficeList();
	//加载医生列表
	var url = address + 'doctor/queryInfo.do';
	oTable = new TableInit(url, "user_list", getColumnParams(),true);
	//改变参数
	changeParams();
//	oTable.Init(param);
});

//改变查询参数
function changeParams() {
	param = {
		hid: hid,
		dname: dname
	}
	oTable.Init(param);
}

function resetInput(){
	$("#hospital option").eq(0).attr("selected", "selected");
	$(".dname").val("");
}
//点击查询按钮
function search() {

	hid = $('#hospital').val();
	if(hid == -1) {
		hid = undefined;
	}
	dname = $('.dname').val();
	if(dname == '' || dname == null) {
		dname = undefined
	}
	changeParams();
	
}

function getColumnParams() {
	var columnParams = [{
		align: 'center',
		checkbox: true
	}, {
		title: '序号',
		sortable: true,
		align: 'center',
		clickToSelect: false,
		formatter: function(value, row, index) {
			return index + 1;
		}
	}, {
		field: 'dName',
		title: '用户名称',
		sortable: true,
		align: 'center',
		clickToSelect: false,
		sortable: true
	}, {
		field: 'pname',
		title: '职位名称',
		align: 'center',
		clickToSelect: false,
		sortable: true
	}, {
		field: 'dPhone',
		title: '联系电话',
		align: 'center',
		clickToSelect: false,
		sortable: true
	}, {
		field: 'fixedTelephone',
		title: '办公电话',
		align: 'center',
		clickToSelect: false,
		sortable: true
	}, {
		field: 'officename',
		title: '所属科室',
		sortable: true,
		align: 'center'
	}, {
		field: 'hospitalname',
		title: '所属医院',
		sortable: true,
		align: 'center',
		clickToSelect: false
	}, {
		field: 'createDate',
		title: '创建时间',
		sortable: true,
		align: 'center',
		clickToSelect: false,
		formatter: function(value, row, index) {
			return longToDate(value);
		}
	}]
	return columnParams;
}

//获取医院下拉列表 
function getHospitalList() {
	$.ajax({
		type: "post",
		url: address + "hospital/find.do",
		async: true,
		success: function(d) {
			var data = d.data;
			var htm = "";
			for(var i = 0; i < data.length; i++) {
				htm += "<option value='" + data[i].hospitalid + "'>" + data[i].hospitalname + "</option>";
			}
			$(".hospital").append(htm);
		}
	});
}

//获取科室下拉列表 
function getOfficeList() {
	$.ajax({
		type: "post",
		url: address + "office/findOffice.do",
		async: true,
		success: function(d) {
			var data = d.data;
			var htm = "";
			for(var i = 0; i < data.length; i++) {
				htm += "<option value='" + data[i].officeid + "'>" + data[i].officename + "</option>";
			}
			$(".office").append(htm);
		}
	});
}

//添加账号的方法----未完
function addAccount() {
	var form = $('#doctorForm').serialize();
	form = form + "&officeid="+$('.office').val() + "&hospitalid="+$('#hospital2').val() + "&pid="+$('.position').val();
	console.log(form);
	$.ajax({
		type: "post",
		url: address + "doctor/addDoctorAccount.do",
		data: form, 
		async: false,
		success: function(i) {
			if(i.data >= 0){
				alert("添加成功");
			}
		},
		error:function(e){
			console.log(JSON.stringify(e))
		}
	});
}
//查询所有的职位
function getposition() {
	$.ajax({
		type: "post",
		url: address + "position/find.do",
		async: true,
		success: function(d) {
			var data = d.data;
			var htm = "";
			for(var i = 0; i < data.length; i++) {
				htm += "<option value='" + data[i].pid + "'>" + data[i].pname + "</option>";
			}
			$(".position").append(htm);
		}
	});
}