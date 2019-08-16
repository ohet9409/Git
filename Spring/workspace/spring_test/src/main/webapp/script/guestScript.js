/**
 * 
 */
function input() {
	if (document.Frm.name.value == "") {
		alert("이름을 입력하세요");
		document.Frm.name.focus();
	} else if (document.Frm.subject.value == "") {
		alert("제목을 입력하세요");
		document.Frm.subject.focus();
	} else if (document.Frm.content.value == "") {
		alert("내용을 입력하세요");
		document.Frm.content.focus();
	}else {
		document.Frm.submit();
	}
}