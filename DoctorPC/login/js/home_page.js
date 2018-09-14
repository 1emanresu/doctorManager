function getSrc(src) {
	location.href = "../nav/index.html"
	sessionStorage.setItem("src", src);
}
$(function() {
	var dName = sessionStorage.getItem('dName');
	if(dName != null) {
		$("#name").html(dName);
	}
});

function getOut() {
	sessionStorage.removeItem('doctorId');
	sessionStorage.removeItem('dName');
}