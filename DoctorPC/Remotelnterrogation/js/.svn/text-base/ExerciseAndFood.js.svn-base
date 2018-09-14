/******* 运动 膳食 孕妇课堂 js       @yinzx **************/
//var address = "http://192.168.1.43:8080/doctormanager/"
var address=sessionStorage.getItem("address");
$(function() {
	//查询微量运动和中量运动信息
	$.ajax({
		type: "post",
		url: address + "exercise/find.do",
		async: true,
		success: function(d) {
			var data = d.data;
			var microlist = data.microlist;
			var moderalist = data.moderalist;
			if(microlist!=null){
				getMicroSportMsg(microlist);
			}
		    if(moderalist!=null){
				getModeraSportMsg(moderalist);
			}
			
		}
	});
	//查询孕妇课堂信息
	$.ajax({
		type: "post",
		url: address + "Expertsayarticle/findPregnancy.do",
		async: true,
		success: function(d) {
			var data = d.data;
			var hlist = data.hlist;
			var dlist = data.dlist;
			var hvideo = data.hvideo;
			var dvideo = data.dvideo;
			if(hlist!=null){
				var length=hlist.length;
				for(var i=0;i<(length<=2?length:2);i++){
					var subtitle="";
					var imgUrl=hlist[i].picture; //插图url
					if(hlist[i].articletitle.length>11){
						subtitle=hlist[i].articletitle.substring(0,11);
					}else{
						subtitle=hlist[i].articletitle;
					}
					$(".health_title"+(i+1)).html(hlist[i].articletitle);
					$(".sub_health_title"+(i+1)).html(subtitle);
					$(".health_content"+(i+1)).html(hlist[i].contenttext);
				}
			}
		   /* if(dlist!=null){
				var length=hlist.length;
				
				for(var i=0;i<(length<=2?length:2);i++){
					var subtitle="";
					var imgUrl=dlist[i].picture;  //插图url
					if(dlist[i].articletitle.length>11){
						subtitle=dlist[i].articletitle.substring(0,11);
					}else{
						subtitle=dlist[i].articletitle;
					}
					
					$(".disease_title"+(i+1)).html(dlist[i].articletitle);
					$(".sub_disease_title"+(i+1)).html(subtitle);
					$(".disease_content"+(i+1)).html(dlist[i].contenttext);
					
				}
			}
		    if(hvideo!=null){
				var length=hvideo.length;
				for(var i=0;i<(length<1?length:1);i++){
					var subtitle="";
					var subcontent="";
					var videoUrl=hvideo[i].video; //视频url
					if(hvideo[i].articletitle.length>11){
						subtitle=hvideo[i].articletitle.substring(0,11);
					}else{
						subtitle=hvideo[i].articletitle;
					}
					if(hvideo[i].contentintroduction.length>15){
						subcontent=hvideo[i].contentintroduction.substring(0,15)+"...";
					}else{
						subcontent=hvideo[i].contentintroduction+"...";
					}
					$(".health_videoTitle"+(i+1)).html(subtitle);
					$(".health_videoCont"+(i+1)).html(subcontent);
					$("#health_href"+(i+1)).attr('href',videoUrl);
					
				}
				
			}
		    if(dvideo!=null){
				var length=dvideo.length;
				for(var i=0;i<(length<2?length:2);i++){
					var subtitle="";
					var subcontent="";
					var videoUrl=dvideo[i].video; //视频url
					if(dvideo[i].articletitle.length>11){
						subtitle=dvideo[i].articletitle.substring(0,11);
					}else{
						subtitle=dvideo[i].articletitle;
					}
					if(dvideo[i].contentintroduction.length>15){
						subcontent=dvideo[i].contentintroduction.substring(0,15)+"...";
					}else{
						subcontent=dvideo[i].contentintroduction+"...";
					}
					$(".disease_videoTitle"+(i+1)).html(subtitle);
					$(".disease_videoCont"+(i+1)).html(subcontent);
					$("#disease_href"+(i+1)).attr('href',videoUrl);
					
				}
				
			}*/
			
		}
	});
	//膳食
	$.ajax({
		type: "post",
		url: address + "food/findfoodlist.do",
		async: true,
		success: function(d) {
			var data = d.data;
			getfoodMsg(data);
		}
	});


});

//获取微量运动信息
function getMicroSportMsg(data){
	var length=data.length;
	for(var i=0;i<(length<=6?length:6);i++){
		var effect=data[i].effect;
		effect=effect.replace(/\r\n/, "<br />")
		$(".exerciseName"+(i+1)).html(data[i].exercisename);
		$(".ex_effect"+(i+1)).html(effect);
	}
}

//获取中量运动信息
function getModeraSportMsg(data){
	var length=data.length;
	for(var i=0;i<(length<=4?length:4);i++){
		var effect=data[i].effect;
		effect=effect.replace(/\r\n/, "<br />")
		$(".mexerciseName"+(i+1)).html(data[i].exercisename);
		$(".mex_effect"+(i+1)).html(effect);
	}
}
//获取膳食信息
function getfoodMsg(data){
	//糖类
	var sugar=data.sugar;
	if(sugar!=null &&sugar !=""){
		var length=sugar.length;
		var imglist="";
		var foodlist="";
		for(var i=0;i<(length<7?length:7);i++){
			var imgsrc="";
			if(sugar[i].picture!=null){
				imgsrc="images/food/"+sugar[i].picture;     //食物插图配图url， 上传服务器后 ，应从服务器获取
			}
			imglist+="<td><img width='90px' height='60px' src='"+ imgsrc+"'></td>";
			foodlist+="<td>"+sugar[i].foodname+"</td>";
		}
		$("#sugar_imglist").html(imglist);
		$("#sugar_foodlist").html(foodlist);
	}
	//脂肪
	var fat=data.fat;
	if(fat!=null &&fat !=""){
		var length=fat.length;
		var imglist="";
		var foodlist="";
		for(var i=0;i<(length<7?length:7);i++){
			var imgsrc="";
			if(fat[i].picture!=null){
				imgsrc="images/food/"+fat[i].picture;     //食物插图配图url， 上传服务器后 ，应从服务器获取
			}
			imglist+="<td><img width='90px' height='60px' src='"+ imgsrc+"'></td>";
			foodlist+="<td>"+fat[i].foodname+"</td>";
		}
		$("#fat_imglist").html(imglist);
		$("#fat_foodlist").html(foodlist);
	}
	//寒凉类
	var cold=data.cold;
	if(cold!=null &&cold !=""){
		var length=cold.length;
		var imglist="";
		var foodlist="";
		for(var i=0;i<(length<7?length:7);i++){
			var imgsrc="";
			if(cold[i].picture!=null){
				imgsrc="images/food/"+cold[i].picture;     //食物插图配图url， 上传服务器后 ，应从服务器获取
			}
			imglist+="<td><img width='90px' height='60px' src='"+ imgsrc+"'></td>";
			foodlist+="<td>"+cold[i].foodname+"</td>";
		}
		$("#cold_imglist").html(imglist);
		$("#cold_foodlist").html(foodlist);
	}
	//纤维
	var fibre=data.fibre;
	if(fibre!=null &&fibre !=""){
		var length=fibre.length;
		var imglist="";
		var foodlist="";
		for(var i=0;i<(length<7?length:7);i++){
			var imgsrc="";
			if(fibre[i].picture!=null){
				imgsrc="images/food/"+fibre[i].picture;     //食物插图配图url， 上传服务器后 ，应从服务器获取
			}
			imglist+="<td><img width='90px' height='60px' src='"+ imgsrc+"'></td>";
			foodlist+="<td>"+fibre[i].foodname+"</td>";
		}
		$("#fibre_imglist").html(imglist);
		$("#fibre_foodlist").html(foodlist);
	}
	//辛辣
	var spicy=data.spicy;
	if(spicy!=null &&spicy !=""){
		var length=spicy.length;
		var imglist="";
		var foodlist="";
		for(var i=0;i<(length<7?length:7);i++){
			var imgsrc="";
			if(spicy[i].picture!=null){
				imgsrc="images/food/"+spicy[i].picture;     //食物插图配图url， 上传服务器后 ，应从服务器获取
			}
			imglist+="<td><img width='90px' height='60px' src='"+ imgsrc+"'></td>";
			foodlist+="<td>"+spicy[i].foodname+"</td>";
		}
		$("#spicy_imglist").html(imglist);
		$("#spicy_foodlist").html(foodlist);
	}
	//淀粉
	var starch=data.starch;
	if(starch!=null &&starch !=""){
		var length=starch.length;
		var imglist="";
		var foodlist="";
		for(var i=0;i<(length<7?length:7);i++){
			var imgsrc="";
			if(starch[i].picture!=null){
				imgsrc="images/food/"+starch[i].picture;     //食物插图配图url， 上传服务器后 ，应从服务器获取
			}
			imglist+="<td><img width='90px' height='60px' src='"+ imgsrc+"'></td>";
			foodlist+="<td>"+starch[i].foodname+"</td>";
		}
		$("#starch_imglist").html(imglist);
		$("#starch_foodlist").html(foodlist);
	}
}