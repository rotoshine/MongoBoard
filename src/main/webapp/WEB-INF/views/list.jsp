<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>20분만에 만든 낙서장</title>
</head>
<body>
<form method="post">
제목 : <input type="text" name="title"/><br />
내용 : <textarea name="content"></textarea> <input type="submit" value="작성">
</form>
<hr />
<c:forEach items="${articleList}" var="article">
	<div style="border:1px solid black;margin-bottom:2px">
		ID : ${article.id} <br/>
		제목 : ${article.title} <br />
		내용 : ${article.content}<br />
		작성일 : ${article.writeDate }<br/>
	</div>
</c:forEach>

</body>
</html>