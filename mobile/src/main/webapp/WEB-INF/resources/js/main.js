$(document).ready(function(){
    $(".submitter").on("click",function(){
        var bn = $("#brandName").val();
        var type = $("#type").val();
        var ram = $("#ram").val();
        var rom = $("#rom").val();
        var mn = $("#modelNumber").val();
        var price = $("#price").val();
        var modelName = $("#modelName").val();

        var name_matcher = new RegExp("^([a-zA-Z]{3,15})$");
        var number_matcher = new RegExp("^([0-9]{1,5})$");
        var mn_matcher = new RegExp("^([0-9]{1,10})$");

        var out=true;

        if(!type.match(name_matcher)){
            $("#signup_type").html("<p class='text-danger'>Enter valid type<p>"); 
            out=false;
        }  
        
        if(!bn.match(name_matcher)){
            $("#signup_name").html("<p class='text-danger'>Enter valid brand name");
            out=false;
        }
		
		if(!ram.match(number_matcher) || !rom.match(number_matcher)){
            $("#signup_rom_ram").html("<p class='text-danger'>Enter valid numbers for memory details in GB<p>"); 
            out=false;
        }

        if(!mn.match(mn_matcher)){
            $("#signup_mn").html("<p class='text-danger'>Enter valid Model Number<p>");
            out=false;
        }
        
        if(!price.match(mn_matcher)){
            $("#signup_price").html("<p class='text-danger'>Enter valid Price<p>");
            out=false;
        }

        if(!modelName.match(name_matcher)){
            $("#signup_mname").html("<p class='text-danger'>Enter valid Model name");
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