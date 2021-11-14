$(document).ready(function(){
    $(".submitter").on("click",function(){
        var mn = $("#modelNumber").val();

        var mn_matcher = new RegExp("^([0-9]{1,10})$");

        var out=true;

        if(!mn.match(mn_matcher)){
            $("#signup_mn").html("<p class='text-danger'>Enter valid Model Number<p>");
            out=false;
        }
        
        if ($('input:radio[name=availability]').is(':checked')) {
        } 
        else {
            $("#signup_radio1").html("<p class='text-danger'>Select Availability<p>");
            out=false;
        }
        return out;
    });
    
});