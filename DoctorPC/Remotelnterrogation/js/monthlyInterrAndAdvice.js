/*author luoyc*/
var mid=sessionStorage.getItem("mid");
var address=sessionStorage.getItem("address");
//问诊记录
$(function(){
	$.ajax({
		type: "post",
		url: address + "inquiryRecord/findMonthlyAllRecord.do",
		data: {
			"mid": mid
		},
		dataType: "json",
		ContentType: "application/x-www-form-urlencoded;charset=utf-8",
		success: function(e) {
			var list=e.data;
			var table='';
			$.each(list, function(i) {
				var date=new Date(list[i]);
				var day=date.getDate();
				if(i%3==0){
					table+="<tr><td style='width: 30%;' class='tdCurrencyDate' onclick='getInterrogation("+day+")'><span>"+day+"</span></td>";
				}else if(i%3==1){
					table+="<td style='width: 30%;' class='tdCurrencyDate' onclick='getInterrogation("+day+")'><span>"+day+"</span></td>";
				}else if(i%3==2){
					table+="<td style='width: 30%;' class='tdCurrencyDate' onclick='getInterrogation("+day+")'><span>"+day+"</span></td></tr>";
				}
				if(i==list.length-1&&i%3==0){
					table+="<td style='width: 30%;'></td><td style='width: 30%;'></td>";
				}
				if(i==list.length-1&&i%3==1){
					table+="<td style='width: 30%;'></td>";
				}
				if(i==list.length-1&&i%3!=2){
					table+="</tr>";
				}
			});
			if(list.length==0){
				table+="<tr><td style='width: 30%;padding-left:15px'>暂无</td><td style='width: 30%;'></td><td style='width: 30%;'></td></tr>";
			}
			$("#monthlyInterrogation").append(table);
		},
		error: function() {
			
		}
	});	
})
$(function(){
	$.ajax({
		type: "post",
		url: address + "doctorAdvice/findMonthlyAllRecord.do",
		data: {
			"mid": mid
		},
		dataType: "json",
		ContentType: "application/x-www-form-urlencoded;charset=utf-8",
		success: function(e) {
			var list=e.data;
			var table2=''
			$.each(list, function(i) {
				var date=new Date(list[i]);
				var day=date.getDate();
				if(i%3==0){
					table2+="<tr><td style='width: 30%;' class='tdCurrencyDate' onclick='getAdvice("+i+")'><span>"+day+"</span></td>";
				}else if(i%3==1){
					table2+="<td style='width: 30%;' class='tdCurrencyDate' onclick='getAdvice("+i+")'><span>"+day+"</span></td>";
				}else if(i%3==2){
					table2+="<td style='width: 30%;' class='tdCurrencyDate' onclick='getAdvice("+i+")'><span>"+day+"</span></td></tr>";
				}
				if(i==list.length-1&&i%3==0){
					table2+="<td style='width: 30%;'></td><td style='width: 30%;'></td>";
				}
				if(i==list.length-1&&i%3==1){
					table2+="<td style='width: 30%;'></td>";
				}
				if(i==list.length-1&&i%3!=2){
					table2+="</tr>";
				}
			});
			
			if(list.length==0){
				table2+="<tr><td style='width: 30%;padding-left:15px'>暂无</td><td style='width: 30%;'></td><td style='width: 30%;'></td></tr>";
			}
			$("#table_doctor_advice").append(table2);
		},
		error: function() {
			
		}
	});	
})
//周报记录
$(function(){
	$.ajax({
		type: "post",
		url: address + "weeklyReport/findMonthlyAllRecord.do",
		data: {
			"mid": mid
		},
		dataType: "json",
		ContentType: "application/x-www-form-urlencoded;charset=utf-8",
		success: function(e) {
			var list=e.data;
			var table3=''
			$.each(list, function(i) {
				var date=new Date(list[i]);
				var day=date.getDate();
				if(i%3==0){
					table3+="<tr><td style='width: 30%;' class='tdCurrencyDate' onclick='getWeekreport("+day+")'><span>"+day+"</span></td>";
				}else if(i%3==1){
					table3+="<td style='width: 30%;' class='tdCurrencyDate' onclick='getWeekreport("+day+")'><span>"+day+"</span></td>";
				}else if(i%3==2){
					table3+="<td style='width: 30%;' class='tdCurrencyDate' onclick='getWeekreport("+day+")'><span>"+day+"</span></td></tr>";
				}
				if(i==list.length-1&&i%3==0){
					table3+="<td style='width: 30%;'></td><td style='width: 30%;'></td>";
				}
				if(i==list.length-1&&i%3==1){
					table3+="<td style='width: 30%;'></td>";
				}
				if(i==list.length-1&&i%3!=2){
					table3+="</tr>";
				}
			});
			
			if(list.length==0){
				table3+="<tr><td style='width: 30%;padding-left:15px;'>暂无</td><td style='width: 30%;'></td><td style='width: 30%;'></td></tr>";
			}
			$("#table_weeklyreport").append(table3);
		},
		error: function() {
			
		}
	});	
})