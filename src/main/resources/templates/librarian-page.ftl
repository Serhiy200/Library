<#import "common.ftl" as c>
<@c.page title="Books">
<form action="/librarian/book" method="post">
    <input type="text" name="bookName" placeholder="Book name">
      <input type="text" name="author" placeholder="Author">
       <select id = "category" name="category.id">
        <option selected value="-1">All category</option>
                     <#list categories as categor>
                      <option value = "${categor.id}" >${categor.categoryName}</option>
                     </#list>
       </select><br>
      <button type="submit">Пошук</button>
</form>

<p>
    Add new book or Category
<form>
    <button formaction="/librarian/add">Add</button>
</form>
</p>
<#if errorMessage??>
          <div>
             ${errorMessage}
          </div>
      <#else>
    <#list books as book>
    <p>
        <a  href="/librarian/book/${book.id}">${book.id} ${book.bookName} ${book.author} ${book.description}</a>
    </p>
    </#list>
    </#if>
</@c.page>