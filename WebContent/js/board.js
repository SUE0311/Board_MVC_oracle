//게시판 글 작성 유효성 평가
//테이블의 not null 속성 값이 기입되었는지 체크
function boardwrite_ok(){
	//글쓴이 입력 여부
	if($.trim($("#board_name").val())==""){
		alert("이름을 입력하세요");
		$("#board_name").val("").focus();
		return false;
	}
	//제목 입력 여부
	else if($.trim($("#board_title").val())==""){
		alert("제목을 입력하세요");
		$("#board_title").val("").focus();
		return false;
	}
	//비밀번호 입력 여부
	else if($.trim($("#board_pwd").val())==""){
		alert("비밀번호를 입력하세요");
		$("#board_pwd").val("").focus();
		return false;
	//모두 입력했을 때	
	}else{ 
		$("#boardwrite_form").submit();
	}
}