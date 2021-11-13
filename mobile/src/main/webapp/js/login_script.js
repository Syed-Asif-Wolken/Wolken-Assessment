$(document).ready(function(){
    $(".submitter").on("click",function(){
        var login_email = $("#inputEmail14").val();

        var email_matcher = new RegExp("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$"); 

        var out=true;

        if(!login_email.match(email_matcher)){
            $("#signup_email2").html("<p style='font-size: 14px;' class='text-danger'>Email must be 6-18 characters with proper domain<p>"); 
            out=false;
        }

    return out;
    });
    
});