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
		<div class="inputBox">
			<div class="inputElement"> 
				<label class="inputLabel">작성자</label> 
				<input type="text" id="inputUser" name="user" value="${posts[fn:length(posts) - 1].user}" required><br>
			</div>
			<div class="inputElement"> 
				<label class="inputLabel">제목</label> 
				<input type="text" id="inputTitle" name="title" required><br> 
			</div>
			<div class="inputElement"> 
				<label class="inputLabel">내용</label>
				<textarea id="inputContent" name="content" required></textarea><br>
			</div>		
			<div class="inputElement"> 
				<label class="inputLabel">중요</label>
				<label id="info">(중요 게시물 체크해주세요)</label>
				<input id="inputCheckbox" type="checkbox" name="highlight">
			 	<input class="inputBtn" type="submit" value="제출"> 
			</div>		
		</div>
	</form>

	<form action="list" method="get">
		<div class="searchBox">
			<div class="inputElement"> 
				<select id="select" name="select">
				    <option value="user">작성자</option>
				    <option value="title">제목</option>
				</select>
				<input type="text" id="inputSearch" name="inputSearch" required><br>
				<input class="inputBtn" type="submit" value="제출"> 
			</div>
		</div>
	</form>
	<c:if test="${ fn:length(posts) == 0 }"> 게시글이 없습니다. </c:if>

	<c:if test="${ fn:length(posts) != 0 }">
		<c:forEach var="post" items="${ posts }">
			<c:if test="${ post.highlight == false }">
				<div class="postBox non-click">
					<div>작성자 : ${ post.user }</div>
					<div>제목 : ${ post.title }</div>
					<div>내용 : ${ post.content }</div>
					<button class="delete" data-pk="${ post.pk }">삭제</button>
				</div>
			</c:if>
			<c:if test="${ post.highlight == true}">
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














