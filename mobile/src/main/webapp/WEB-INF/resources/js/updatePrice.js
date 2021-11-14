$(document).ready(function(){
    $(".submitter").on("click",function(){
        var mn = $("#modelNumber").val();
        var price = $("#price").val();

        var mn_matcher = new RegExp("^([0-9]{1,10})$");

        var out=true;
		
        if(!mn.match(mn_matcher)){
            $("#signup_mn").html("<p class='text-danger'>Enter valid Model Number<p>");
            out=false;
        }
        
        if(!price.match(mn_matcher)){
            $("#signup_price").html("<p class='text-danger'>Enter valid Price<p>");
            out=false;
        }
        return out;
    });
    
});