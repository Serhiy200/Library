<!DOCTYPE html>
<html lang="en" xmlns:th="http://thymeleaf.org">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>book update</title>
</head>
<p>
<p>Add new book
<form action="/librarian/add" method="POST">

    <input type="text" name="bookName" placeholder="Book name"><br>


    <input type="text" name="author" placeholder="author"><br>


    <input type="text" name="description" placeholder="Description"><br>



    <select id = "category" name="category.id">
               <#list categories as categor>
                   <option value = "${categor.id}" >${categor.categoryName}</option>
               </#list>
           </select>

    <button type="submit">Add</button>
</form>
</p>
<p>Add new category</p>
<form action="/librarian/category" method="POST">

    <input type="text" name="categoryName" placeholder="Category name"><br>

    <button type="submit">Add</button>
</form>
</body>
</html>