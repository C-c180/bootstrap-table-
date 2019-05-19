$(function () {
    $(".add").click(function () {
        $.ajax({
            url:"../address/add",
            type:"post",
            data:{
                name:$(".name").val(),
                sex:$("input[type='radio']:checked").val(),
                mobile:$(".mobile").val(),
                email:$(".email").val(),
                qq:$(".qq").val(),
                company:$(".company").val(),
                address:$(".address").val(),
                postcode:$(".postCode").val()
            },
            success:function (data) {
                if (data.code == 200) {
                    window.location.href="addressBook.html";
                }else{
                    console.log(data);
                    var message="";
                    $.each(data.data.errors,function (i,error) {
                        message=message+error.defaultMessage+"\n";
                    });
                    alert(message);
                }
            }
        });
    });
    $(".back").click(function () {
        window.location.href="addressBook.html";
    });
});