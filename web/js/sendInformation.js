$(function () {
    $(".add").click(function () {
        $.ajax({
            url:"../message/add",
            type:"post",
            async:true,
            data:{
                username:$(".name").val(),
                message:$(".content").val()
            },
            dataType:"json",
            success:function (data) {
                if (data.code == 200) {
                    window.location.href="information.html";
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
        window.location.href="information.html";
    });
});