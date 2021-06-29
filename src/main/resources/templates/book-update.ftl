<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div>
        <form id="update" action="/librarian/book/${book.id}" method = "put">

            <input type="text" name="bookName" value="${book.bookName}"><br>

            <input type="text" name="author" value="${book.author}"><br>

            <input type="text" name="description" value="${book.description}"><br>

            <p>
                <select id = "category" name="category.id">
                    <#list categories as categor>
                    <option value="${categor.id}" <#if categor.categoryName == book.category.categoryName> selected =  "selected"</#if>>${categor.categoryName}</option>
            </#list>
            </select>
            </p>
            <!--input type="submit" value ="Update"/-->
            <button type="submit">Update</button>
        </form>

</div>

<form action="/librarian/book/${book.id}" method="post">
 <input type="hidden" name="_method" value="delete" />
    <button type="submit">Delete</button>
</form>
</body>
</html>