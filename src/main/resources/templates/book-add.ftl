<#import "common.ftl" as c>
<@c.page title="Add book">
<p>
<p>Add new book
<form action="/librarian/add" method="POST">

    <input type="text" name="bookName" class="form-control ${(bookNameError??)?string('is-invalid', '')}" placeholder="Book name"><br>
        <#if bookNameError??>
            <div class="invalid-feedback">
                 ${bookNameError}
            </div>
        </#if>

    <input type="text" name="author" class="form-control ${(authorError??)?string('is-invalid', '')}" placeholder="author"><br>
        <#if authorError??>
            <div class="invalid-feedback">
                 ${authorError}
            </div>
        </#if>

    <input type="text" name="description" class="form-control ${(descriptionError??)?string('is-invalid', '')}" placeholder="Description"><br>
        <#if descriptionError??>
            <div class="invalid-feedback">
                 ${descriptionError}
            </div>
        </#if>


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

    <input type="text" name="categoryName" class="form-control ${(categoryNameError??)?string('is-invalid', '')}" placeholder="Category name"><br>
    <#if categoryNameError??>
    <div class="invalid-feedback">
        ${categoryNameError}
    </div>
</#if>
    <button type="submit">Add</button>
</form>
</@c.page>