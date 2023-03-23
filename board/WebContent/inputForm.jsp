<%@page import="board.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 구현</title>

<link rel="stylesheet" href="inputForm.css" />
</head>
<body>
	<header>게시판</header>
	<form action="insert" method="post">
		<label class="input-user">작성자</label> <input type="text"
			id="inputUser" name="user"
			value="${posts[fn:length(posts) - 1].user}" required><br>
		<label class="input-title">제목</label> <input type="text"
			id="inputTitle" name="title" required><br> <label
			class="input-content">내용</label>
		<textarea id="inputContent" name="content" required></textarea>
		<br> <input type="submit" value="제출"> 
		<input type="checkbox" class="highlight">중요</input>
	</form>
	<hr>
	<c:if test="${ fn:length(posts) == 0 }">
	게시글이 없습니다. 
	</c:if>

	<c:if test="${ fn:length(posts) != 0 }">
		<c:forEach var="post" items="${ posts }">
			<c:if test="${ post.highlight == null }">
				<div class="postBox non-click">
					<div>작성자 : ${ post.user }</div>
					<div>제목 : ${ post.title }</div>
					<div>내용 : ${ post.content }</div>
					<button class="delete" data-pk="${ post.pk }">삭제</button>
				</div>
			</c:if>
			<c:if test="${ post.highlight != null}">
				<div class="postBox click">
					<div>작성자 : ${ post.user }</div>
					<div>제목 : ${ post.title }</div>
					<div>내용 : ${ post.content }</div>
					<button class="delete" data-pk="${ post.pk }">삭제</button>
				</div>
			</c:if>
		</c:forEach>
	</c:if>
</body>
</html>
<script>
	var deleteBtns = document.querySelectorAll(".delete");
	deleteBtns.forEach(function(deleteBtn) {
		var deletePk = 	deleteBtn.dataset.pk;
		deleteBtn.addEventListener("click", function(e ){
			fetch("http://localhost:8080/board/delete?deletePk=" + deletePk)
			.then((resp) => {
				window.location.href = "http://localhost:8080/board/list"
			});
		});
	});
</script>














