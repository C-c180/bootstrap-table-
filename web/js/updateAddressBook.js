$(function () {
    var url=location.search;
    var id=null;
    if (url.indexOf('?') !== -1) {
        id = url.substr(1);
    }
    console.log(id);
    $.ajax({
        url:"address/getAddress",
        type:"post",
        data:{
            id:id
        },
        dataType:"json",
        success:function (res) {
            if (res.code == 200) {
                console.log(res);
                $(".name").val(res.data.address.name);
                if (res.data.address.sex == 0) {
                    $("#boy").prop("checked",true);
                    $("#girl").prop("checked",false);
                }
                $(".mobile").val(res.data.address.mobile);
                $(".email").val(res.data.address.email);
                $(".qq").val(res.data.address.qq);
                $(".company").val(res.data.address.company);
                $(".address").val(res.data.address.address);
                $(".postCode").val(res.data.address.postcode);
            }
        }
    });
    $(".add").click(function () {
        $.ajax({
            url:"../address/getAddress",
            type:"post",
            data:{
                id:id,
                name:$(".name").val(),
                sex:$("input[type='radio']:checked").val(),
                mobile:$(".mobile").val(),
                email:$(".email").val(),
                qq:$(".qq").val(),
                company:$(".company").val(),
                address:$(".address").val(),
                postcode:$(".postCode").val()
            },
            dataType:"json",
            success:function (res) {
                if (res.code == 200) {
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