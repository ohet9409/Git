/**
 * 
 */
function login() {
	if(document.frm.id.value==""){
		alert("아이디를 입력해 주세요.");
		document.frm.id.focus();
	} else if (document.frm.pwd.value=="") {
		alert("비밀번호를 입력해 주세요.");
		document.frm.pwd.focus();
	} else{
		confirm("입력하신 내용이 맞습니까?")
		opener.close();
	}
}