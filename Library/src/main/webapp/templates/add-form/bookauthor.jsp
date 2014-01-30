
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<form action="" method="post">


    <div class="form_box">
        <label for="book_id">Book ID:</label>
        <input name="book_id" id="book_id" type="text" value="${book_id}">
    </div>
    <div class="form_box">
        <label for="author_id">Author ID:</label>
        <input name="author_id" id="author_id" type="text" value="${author_id}">
    </div>


    <button type="submit" class="box" id="submit"  name="submit">Add</button>


</form>