<!DOCTYPE html>
<html lang="en" xmlns:th="http://thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Reader</title>
</head>
<body>
<form th:action="@{/reader/book}" th:object="${book}" method="post">
    <input type="text" name="bookName" placeholder="Book name"><br>
    <button type="submit">Пошук</button>
</form>

<div>
<#list books as book>
<p>
    <a  href="/reader/book/${book.id}">${book.id} ${book.bookName} ${book.author} ${book.description}</a>
</p>
</#list>
</div>
</body>
</html>