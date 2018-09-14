
/*孕妇既往史下拉框显示与隐藏*/
$('#g_medical_history1').click(function (event) {  
	//取消事件冒泡  
	event.stopPropagation();  
	//按钮的toggle,如果div是可见的,点击按钮切换为隐藏的;如果是隐藏的,切换为可见的。  
	$('#g_select1').toggle();  
	$('#g_select2').hide(); 
	$('#g_select3').hide(); 
	$('#g_select4').hide(); 
		return false;
}); 
 
  //点击空白处隐藏弹出层
$(document).click(function(event){
	var con = $('#g_select1');   
	if(!con.is(event.target) && con.has(event.target).length === 0){ 
		con.hide();    
		
	}
});
 
 
 /*孕妇现病史*/
 $('#g_medical1').click(function (event) {  
	event.stopPropagation();  
	$('#g_select2').toggle(); 
	$('#g_select1').hide(); 
	$('#g_select3').hide(); 
	$('#g_select4').hide();
		return false;
 });
 
 $(document).click(function(event){
	var con = $('#g_select2');   
	if(!con.is(event.target) && con.has(event.target).length === 0){ 
		con.hide();     
		 
	}
});
 
 
 /*孕妇家族史*/
 $('#g_family_history1').click(function (event) {  
	event.stopPropagation();  
	$('#g_select3').toggle();
	$('#g_select1').hide(); 
	$('#g_select2').hide(); 
	$('#g_select4').hide();
		return false;
 });
 
 $(document).click(function(event){
	var con = $('#g_select3');   
	if(!con.is(event.target) && con.has(event.target).length === 0){ 
		con.hide();     
		 
	}
});
 
 
 /*丈夫家族史*/
 $('#husband_family_history1').click(function (event) {  
	event.stopPropagation();  
	$('#g_select4').toggle();
	$('#g_select1').hide(); 
	$('#g_select2').hide(); 
	$('#g_select3').hide();
		return false;
 });
 
$(document).click(function(event){
	var con = $('#g_select4');   
	if(!con.is(event.target) && con.has(event.target).length === 0){ 
		con.hide();    
		 
	}
});


//从将多选框的值打印到输入框   
function check_black(index){  
	switch(index){
		case 1:
			var blackName = document.getElementsByName("black1");  
		    var str = [];
		    for(var i = 0; i < blackName.length; i++){   
		       if(blackName[i].checked == true){   
			       var a = blackName[i].value;  
			       str.push(a+" ");
			       $('.g_medical_history1').val(str);
//			       $('#g_select1').hide();
		       }
		    }
		    break;
		case 2:
			var blackName = document.getElementsByName("black2");  
		    var str = [];
		    for(var i = 0; i < blackName.length; i++){   
		       if(blackName[i].checked == true){   
			       var a = blackName[i].value;  
			       str.push(a+" ");
			       $('.g_medical1').val(str);
//			       $('#g_select2').hide();
		       }   
		    }
		    break;
		case 3:
			var blackName = document.getElementsByName("black3");  
		    var str = [];
		    for(var i = 0; i < blackName.length; i++){   
		       if(blackName[i].checked == true){   
			       var a = blackName[i].value;  
			       str.push(a+" ");
			       $('.g_family_history1').val(str);
//			       $('#g_select3').hide();
		       }   
		    }
		    break;
		case 4:
			var blackName = document.getElementsByName("black4");  
		    var str = [];
		    for(var i = 0; i < blackName.length; i++){   
		       if(blackName[i].checked == true){   
			       var a = blackName[i].value;  
			       str.push(a+" ");
			       $('.husband_family_history1').val(str);
//			       $('#g_select4').hide();
		       }   
		    }
		    break;
	}
       
}   
			
//function fun(index){
//	switch(index){
//		case 1:
//			var select = document.getElementById("test1");
//	    var str = [];
//	    for(i=0;i<select.length;i++){
//	        if(select.options[i].selected){
//	            str.push(select[i].value+" ");
//	        }
//	    }
//	    $('#g_medical_history1').val(str);
//	    break;
//	case 2:
//		var select = document.getElementById("test2");
//	    var str = [];
//	    for(i=0;i<select.length;i++){
//	        if(select.options[i].selected){
//	            str.push(select[i].value+" ");
//	        }
//	    }
//	    $('#g_medical1').val(str);
//	    break;
//	case 3:
//		var select = document.getElementById("test3");
//	    var str = [];
//	    for(i=0;i<select.length;i++){
//	        if(select.options[i].selected){
//	            str.push(select[i].value+" ");
//	        }
//	    }
//	    $('#g_family_history1').val(str);
//	    break;
//	case 4:
//		var select = document.getElementById("test4");
//	    var str = [];
//	    for(i=0;i<select.length;i++){
//	        if(select.options[i].selected){
//	            str.push(select[i].value+" ");
//	        }
//	    }
//	    $('#husband_family_history1').val(str);
//		    break;
//	}
//  
//}