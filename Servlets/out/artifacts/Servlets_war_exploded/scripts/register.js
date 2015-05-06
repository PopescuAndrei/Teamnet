/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () { //wait until all the document loads
    $("#firstname").change(function () { //when element with uname id changes
        $("#firstname_error").html("Loading"); //change innerHTML of the span to loading
        $("#firstname_error").show();
        var username = $("#firstname").val();
        $.ajax({
            type: "get", //http method
            url: "zerotohero", //servlet url
            data: "firstname=" + firstname, //parameter for servlet
            success: function (data) {
                if (data == "0") {
                    $("#firstname_error").html("Unique");
                }
                else {
                    $("#firstname_error").html("Existing");
                }
            }
        });

    });

});

$(document).ready(function () { //wait until all the document loads
    $("#lastname").change(function () { //when element with uname id changes
        $("#lastname_error").html("Loading"); //change innerHTML of the span to loading
        $("#lastname_error").show();
        var username = $("#lastname").val();
        $.ajax({
            type: "get", //http method
            url: "zerotohero", //servlet url
            data: "lastname=" + lastname, //parameter for servlet
            success: function (data) {
                if (data == "0") {
                    $("#lastname_error").html("Unique");
                }
                else {
                    $("#lastname_error").html("Existing");
                }
            }
        });

    });

});

