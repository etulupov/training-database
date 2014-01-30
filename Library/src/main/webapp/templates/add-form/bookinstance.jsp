
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<form action="" method="post">


    <div class="form_box">
        <label for="book_id">Book id:</label>
        <input name="book_id" id="book_id" type="text" value="${book_id}">
    </div>

    <div class="form_box">
        <label for="publisher_id">Publisher id:</label>
        <input name="publisher_id" id="publisher_id" type="text" value="${publisher_id}">
    </div>

    <div class="form_box">
        <label for="year">Year:</label>
        <input name="year" id="year" type="text" value="${year}">
    </div>
    <div class="form_box">
        <label for="isbn">ISBN:</label>
        <input name="isbn" id="isbn" type="text" value="${isbn}">
    </div>

    <button type="submit" class="box" id="submit"  name="submit">Add</button>


</form>