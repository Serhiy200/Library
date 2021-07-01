<#import "common.ftl" as c>
<@c.page title="Book view">
<div>
    <p>Id: <a>${book.id}</a></p>
    <p>Book name: <a>${book.bookName}</a></p>
    <p>Author: <a> ${book.author}</a></p>
    <p>Description: <a> ${book.description} </a></p>
    <p>Book category: <a> ${book.category.categoryName}</a></p>
</div>
</@c.page>