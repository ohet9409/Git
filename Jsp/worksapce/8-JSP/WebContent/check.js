/**
 * 
 */

function chekInput() {
	if(document.frm.id.value ==""){
		alert("id를 입력해주세요");
		document.frm.id.focus();
	} else if(document.frm.pw.value ==""){
		alert("pw를 입력해주세요");
		document.frm.pw.focus();
	} else {
		document.frm.submit();
	}
}
