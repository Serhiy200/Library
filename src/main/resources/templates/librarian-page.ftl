<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Customer</title>
</head>
<body>
<form action="/librarian/book" method="post">
    <input type="text" name="bookName" placeholder="Book name"><br>
    <button type="submit">Пошук</button>
</form>

<p>
    Add new book or Category
<form>
    <button formaction="/librarian/add">Add</button>
</form>
</p>
<p>
<#list books as book>
<p>
    <a  href="/librarian/book/${book.id}">${book.id} ${book.bookName} ${book.author} ${book.description}</a>
</p>
</#list>
</body>
</html>