/* 右侧中用药记录 @author zhangqt*/
//var mid = sessionStorage.getItem("mid");
var address = sessionStorage.getItem("address");
var mid = sessionStorage.getItem("mid");
//var address = "http://192.168.1.26:8080/doctormanager/";
var data;
$(function() {
	$.ajax({
		type: "post",
		url: address + "prescription/queryByMid.do",
		data: {
			mid: mid
		},
		async: true,
		success: function(d) {
			data = d.data;
			dataHandel(data);
		}
	});
	var clickDay;
	var cld = new Calendar({
		el: 'body',
		value: '', // 默认为new Date();
		callback: function(obj) {
			showPharmacy(obj, data);
			clickDay = obj.day;
		}
	});
});

//处理数据
function dataHandel() {
	//将long类型的时间转为1990-1-1 00:00:00格式
	var signList2 = "[";
	for(var i = 0; i < data.length; i++) {
		var myDate = new Date(data[i].startdate);
		if(i == (data.length - 1)) {
			signList2 += "{'signDay': {'year': '" + myDate.getFullYear() + "','moth': '" + (myDate.getMonth() + 1) + "','day': '" + myDate.getDate() + "'}}";
		} else {
			signList2 += "{'signDay': {'year': '" + myDate.getFullYear() + "','moth': '" + (myDate.getMonth() + 1) + "','day': '" + myDate.getDate() + "'}},";
		}
	}
	signList2 += "]";
	var signList = eval('(' + signList2 + ')');
	/*数组表示用药记录日期，通过ajax从后台获取*/
	var canChooses = document.querySelectorAll(".canChoose");
	var year = $(".calendar-year").html();
	var month = $(".calendar-month").html();
	for(i = 0; i < canChooses.length; i++) {
		for(var j = 0; j < signList.length; j++) {
			var riLiDate = year + month + (i + 1);
			var prescriptionDate = signList[j].signDay.year + "年" + signList[j].signDay.moth + "月" + signList[j].signDay.day;
			if(riLiDate == prescriptionDate) {
				canChooses[i].classList.add("chose");
			}
		}
	}
}

//显示数据
function showPharmacy(jsn, dat) {
	$(".tablePreDetail").html("");
	var htmTop = "<tr><td class='tdPreTitle'>处方日期</td><td class='tdPreTitle'>用药名称</td>" +
		"<td class='tdPreTitle'>用药剂量</td><td class='tdPreTitle'>用药时长</td>" +
		"<td class='tdPreTitle'>药品照片</td><td class='tdPreTitle'>处方</td></tr>";
		$(".tablePreDetail").append(htmTop);
	var htm = "<tr><td class='tdPreTitle'>[date]</td><td class='tdPreTitle'>[name]</td>" +
		"<td class='tdPreTitle'>[count]</td><td class='tdPreTitle'>[day]</td>" +
		"<td class='tdPreTitle'><img src='[medicinepic]' onclick='[onclick]' height='50px'><img src='[img1]'></td>" +
		"<td class='tdPreTitle'><img src='[prepic]' onclick='[onclick2]' height='50px'><img src='[img2]'></td></tr>";
	var date1 = jsn.year + "-" + jsn.month + "-" + jsn.day;
	var j = 0;
	for(var i = 0; i < dat.length; i++) {
		var myDate = new Date(dat[i].startdate);
		var date2 = myDate.getFullYear() + '-' + (myDate.getMonth() + 1) + '-' + myDate.getDate();
		if(date1 == date2) {
			//时间差
			var num = datedifference(dat[i].startdate, dat[i].enddate);
			j++;
			var td = htm.replace('[date]', date1);
			if(dat[i].medicinepic != "") {
				td = td.replace('[medicinepic]', dat[i].medicinepic);
				td = td.replace('[onclick]', 'seeOriginalReport(\"' + dat[i].medicinepic + '\")');
				td = td.replace('[img1]', 'images/u17692.png');
			} else {
				td = td.replace('[medicinepic]', '');
				td = td.replace('[onclick]', '');
				td = td.replace('[img1]', '');
			}
			if(dat[i].prepic != "") {
				td = td.replace('[prepic]', dat[i].prepic);
				td = td.replace('[onclick2]', 'seeOriginalReport(\"' + dat[i].prepic + '\")');
				td = td.replace('[img2]', 'images/u17692.png');
			} else {
				td = td.replace('[prepic]', '');
				td = td.replace('[onclick2]', '');
				td = td.replace('[img2]', '');
			}
			td = td.replace('[name]', dat[i].medicinename);
			td = td.replace('[day]', num + "天");
			td = td.replace('[count]', dat[i].dose);
			$(".tablePreDetail").append(td);
		}
	}
	if(j != 0) {
		//显示用药记录
		$(".class_serious_risk").show();
	} else {
		$(".class_serious_risk").hide();
		alert("无用药记录!!!");
	}
}