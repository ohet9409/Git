/**
 * 
 */
function input() {
	if(document.writeForm.code.value == ""){
		alert("도서코드를 입력하세요");
		document.writeForm.code.focus();
	} else if(document.writeForm.book.value == ""){
		alert("도서명을 입력하세요");
		document.writeForm.book.focus();
	} else if(document.writeForm.writer.value == ""){
		alert("저자를 입력하세요");
		document.writeForm.writer.focus();
	} else{
		if(confirm("제출하시겠습니까?")){
			document.writeForm.submit();
		}
	}
}