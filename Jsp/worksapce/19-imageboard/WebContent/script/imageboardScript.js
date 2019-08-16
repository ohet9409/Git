/**
 * 
 */
function input() {
	if(document.writeForm.imageId.value==""){
		alert("상품 코드를 입력하세요");
		document.writeForm.imageId.focus();
	} else if(document.writeForm.imageName.value==""){
		alert("상품명을 입력하세요");
		document.writeForm.imageName.focus();
	} else if(document.writeForm.imagePrice.value==""){
		alert("단가를 입력하세요");
		document.writeForm.imagePrice.focus();
	}  else if(document.writeForm.imageQty.value==""){
		alert("개수를 입력하세요");
		document.writeForm.imageQty.focus();
	} else if(document.writeForm.imageContent.value==""){
		alert("내용을 입력하세요");
		document.writeForm.imageContent.focus();
	} else {
		if(confirm("제출하시겠습니까?")){
			document.writeForm.submit();
		}
	}
}