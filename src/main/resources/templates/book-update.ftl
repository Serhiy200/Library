<#import "common.ftl" as c>
<@c.page title="Book update">
<div>
    <form action="/librarian/book/${book.id}" method="post">

        <input type="text" name="bookName"  class="form-control ${(bookNameError??)?string('is-invalid', '')}" value="${book.bookName}"><br>
        <#if bookNameError??>
            <div class="invalid-feedback">
                ${bookNameError}
            </div>
        </#if>

        <input type="text" name="author"  class="form-control ${(authorError??)?string('is-invalid', '')}" value="${book.author}"><br>
        <#if authorError??>
            <div class="invalid-feedback">
                ${authorError}
             </div>
        </#if>

        <input type="text" name="description"  class="form-control ${(descriptionError??)?string('is-invalid', '')}" value="${book.description}"><br>
        <#if descriptionError??>
            <div class="invalid-feedback">
                ${descriptionError}
            </div>
        </#if>

        <p>
            <select id="category" name="category.id">
                <#list categories as categor>
                <option value="${categor.id}"
                <#if categor.categoryName == book.category.categoryName> selected = "selected"</#if>>${categor.categoryName}</option>
                </#list>
        </select>
        </p>
        <button type="submit">Update</button>
    </form>

</div>

<form action="/librarian/delete/${book.id}" method="post">
    <button type="submit">Delete</button>
</form>
</@c.page>