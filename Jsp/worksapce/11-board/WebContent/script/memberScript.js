/**
 * 
 */
// writeForm
function checkInput() {
	if (document.frm.name.value == "") {
		alert("이름을 입력하세요");
		document.frm.name.focus();
	} else if (document.frm.id.value == "") {
		alert("아이디를 입력하세요");
		document.frm.id.focus();
	} else if (document.frm.pwd.value == "") {
		alert("비밀번호를 입력하세요");
		document.frm.pwd.focus();
	} else if (document.frm.pwdCheck.value == "") {
		alert("비밀번호 재확인을 입력하세요");
		document.frm.pwdCheck.focus();
	} else if (document.frm.pwd.value != document.frm.pwdCheck.value) {
		alert("비밀번호가 일치하지 않습니다.");

	} else {
		if (confirm("제출하시겠습니까?")) {
			document.frm.submit();
		}
	}
}
function checkpwd() {
	if (document.frm.pwd.value != document.frm.pwdCheck.value) {
		alert("비밀번호가 일치하지 않습니다.");
		document.frm.pwd.focus();
	}

}
function checkId() {
	var sId = document.frm.id.value;
	if(sId == ""){
		alert("먼저 아이디를 입력하세요");
		document.writeForm.id.focus();
	} else {	    /*요청 페이지? 요청값= + 데이터*/	
		window.open("checkId.jsp?id=" + sId,"","width=350 height=100 left=500 top=200");
	}
}


// loginForm
function login() {
	if(document.frm.id.value==""){
		alert("아이디를 입력하세요");
		document.frm.id.focus();
	} else if(document.frm.pwd.value==""){
		alert("비밀번호를 입력하세요");
		document.frm.pwd.focus();
	} else{
		if(confirm("로그인 하시겠습니까?")){
			document.frm.submit();
		}
	}
}

function checkModify() {
	if (document.frm.name.value == "") {
		alert("이름을 입력하세요");
		document.frm.name.focus();
	} else if (document.frm.id.value == "") {
		alert("아이디를 입력하세요");
		document.frm.id.focus();
	} else if (document.frm.pwd.value == "") {
		alert("비밀번호를 입력하세요");
		document.frm.pwd.focus();
	} else if (document.frm.pwdCheck.value == "") {
		alert("비밀번호 재확인을 입력하세요");
		document.frm.pwdCheck.focus();
	} else if (document.frm.pwd.value != document.frm.pwdCheck.value) {
		alert("비밀번호가 일치하지 않습니다.");

	} else {
		if (confirm("수정하시겠습니까?")) {
			document.frm.submit();
		}
	}
}


