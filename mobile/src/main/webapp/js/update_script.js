$(document).ready(function(){
    $(".submitter").on("click",function(){
        var login_email = $("#inputEmail14").val();
		var pwd = $("#inputPassword4").val();
        var cnfpwd = $("#inputPassword5").val();
        
        var pwd_valid = new RegExp("^([a-zA-Z0-9]{8,16})$");
        var email_matcher = new RegExp("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$"); 

        var out=true;

        if(!login_email.match(email_matcher)){
            $("#signup_email2").html("<p style='font-size: 14px;' class='text-danger'>Email must be 6-18 characters with proper domain<p>"); 
            out=false;
        }
        if(!pwd.match(pwd_valid)){
            $("#signup_pass").html("<p class='text-danger'>Password must be 8 to 16 alphanumeric characters<p>");
            out=false;
        }

        if(cnfpwd != pwd){
            $("#signup_passes").html("<p class='text-danger'>Passwords do not match<p>");
            out=false;
        }

    return out;
    });
    
});