/*@author luoyc*/
//var address = "http://120.76.194.76/doctormanager/"; 
//var address = "http://192.168.1.3/doctormanager/"; 
var address = "http://127.0.0.1:8080/doctormanager/";
sessionStorage.setItem("address",address);
mui.init();
function login() {
	var userName1 = $('#username').val();
	var password1 = $('#password').val();
	if(userName1 == "" || password1 == '') {
		mui.toast("用户名或密码不能为空");
	}
	if(userName1 != "" && password1 != "") {
		$.ajax({
			type: "post",
			dataType: "json",
			data: {
				"userName": userName1,
				"password": password1,
			},
			url: address + "user/webLogin.do",
			success: function(result) {
				var user = result.data;
				if(typeof(user.doctorId) != null) {
					//医生登录
					sessionStorage.setItem("userId",user.userId);
					
					sessionStorage.setItem("doctorId",user.doctorId);
					sessionStorage.setItem("dName",user.dName);
					//获取并保存网易云账号信息   yinzx
					var doctorIM=user.IMAccount
					if(doctorIM!=null&&doctorIM!=""){
						localStorage.setItem("IMAccount",JSON.stringify(doctorIM));
					}
					//用于判断是医生登录还是？？？？？
					sessionStorage.setItem("pid",user.pid);
					location.href="home_page.html"
				} else if(user.nurseId != null) {
					//护士登录
					location.href="home_page.html"
					sessionStorage.setItem("dName",user.nName);
				}else{
					mui.toast("账号或密码错误");
				}
			},
			error: function() {
				mui.toast("账号或密码错误");
			}
		});
	}
}

//添加回车键登录--zhangqt
 document.onkeydown = function(e){
   if(!e){
    e = window.event;
   }
   if((e.keyCode || e.which) == 13){
    login();
   }
  }
