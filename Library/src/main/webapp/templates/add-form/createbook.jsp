<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<script type="text/javascript">

    function addItem () {
        field = document.getElementById("instance_info");
        div = document.getElementById("items");


        newitem = ' <div class="form_box" >';
        newitem += '<label>Author:</label>';
        newitem += '<input name="author[]" style="margin-right: 0px; margin-left: 5px;" id="author" type="text" value="">';
        newitem += '</div>';

        newnode = document.createElement("div");
        newnode.innerHTML = newitem;

        div.insertBefore(newnode, field);

    }

    function addItem2() {
        field = document.getElementById("footer");
        div = document.getElementById("items");


        newitem = ' <div class="form_box" >';
        newitem += '<label>Publisher:</label>';
        newitem += '<input name="publisher[]" style="margin-right: 0px; margin-left: 5px;" type="text" value="">';
        newitem += '<label>ISBN:</label>';
        newitem += '<input name="isbn[]" style="margin-right: 0px; margin-left: 5px;" type="text" value="">';
        newitem += '<label>Year:</label>';
        newitem += '<input name="year[]" style="margin-right: 0px; margin-left: 5px; width: 100px;" type="text" value="">';
        newitem += '</div>';

        newnode = document.createElement("div");
        newnode.innerHTML = newitem;

        div.insertBefore(newnode, field);

    }


</script>

<form action="" method="post">

    <div id="items">
        <div class="form_box">
            <label for="title">Title:</label>
            <input name="title" id="title" type="text" value="${title}">

        </div>

        <div class="form_box" id="author_field">
            <label>Author:</label>
            <input name="author[]" style="margin-right: 0px;" type="text" value="">
            <button class="box" style="display: inline-block; " type="button" onclick="javascript:addItem()">+</button>
        </div>
        <div class="form_box" id="instance_info">
            <label>Publisher:</label>
            <input name="publisher[]" style="margin-right: 0px;" type="text" value="">
            <label>ISBN:</label>
            <input name="isbn[]" style="margin-right: 0px; " type="text" value="">
            <label>Year:</label>
            <input name="year[]" style="margin-right: 0px; width: 100px;" type="text" value="">
            <button class="box" style="display: inline-block; " type="button" onclick="javascript:addItem2()">+</button>
        </div>
        <div id="footer"></div>
    </div>

    <button type="submit" class="box" id="submit" name="submit">Add</button>


</form>