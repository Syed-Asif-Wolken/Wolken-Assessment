$(document).ready(function(){
    $(".submitter").on("click",function(){
        var bn = $("#brandName").val();

        var name_matcher = new RegExp("^([a-zA-Z]{3,15})$");

        var out=true;
        
        if(!bn.match(name_matcher)){
            $("#signup_name").html("<p class='text-danger'>Enter valid brand name");
            out=false;
        }
        return out;
    });
    
});