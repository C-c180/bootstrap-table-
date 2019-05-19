$(function () {
    verify();
    var isRun=false;
    $("#login").click(function () {
        if (!isRun) {
            alert("请滑动验证码")
            return false;
        }
        $.ajax({
            url:"userLogin",
            type:"post",
            async:true,
            data:{
                "username":$("#userName").val(),
                "password":$("#pwd").val()},
            success:function(data){
                console.log(data);
                if (data.code==200){
                    window.location.href="pages/index.html";
                }else{
                    alert("账号或密码错误")
                }
            }
        });
    });
    $("#registerUser").click(function () {
        $(".login").toggle();
        $(".register").toggle();
        $(".confirmPwd").toggle();
        $("#confirmPwd").toggle();
        $(".email").toggle();
        $("#email").toggle();
    });
    $("#Userlogin").click(function () {
        $(".login").toggle();
        $(".register").toggle();
        $(".confirmPwd").toggle();
        $("#confirmPwd").toggle();
        $(".email").toggle();
        $("#email").toggle();
    });
    $("#register").click(function () {
        if (!isRun) {
            alert("请滑动验证码")
            return false;
        }
        if ($("#pwd").val() != $("#confirmPwd").val()) {
            alert("密码不一致");
            return false;
        }
        $.ajax({
            url:"userReginter",
            type:"post",
            async:true,
            data:{
                "username":$("#userName").val(),
                "password":$("#pwd").val(),
                "email":$("#email").val()
            },
            success:function (data) {
                if (data.code == 200) {
                    alert("注册成功");
                    window.location.href="login.html";
                }else{
                    console.log(data);
                    var message="";
                    $.each(data.data.errors,function (i,error) {
                        message=message+error.defaultMessage+"\n";
                    });
                    message=message+data.data.username;
                    alert(message);
                }
            }
        });
    });
    function pattern() {
        var reg=/^([a-zA-z]|[\u4e00-\u9fa5]){1,20}$/ig;
    }
    function verify(){
        $("#mpanel1").slideVerify({
            type : 1,		//类型
            vOffset : 5,	//误差量，根据需求自行调整
            barSize : {
                width : '300px',
                height : '40px',
            },
            ready : function() {
            },
            success : function() {
                isRun=true;
            },
            error : function() {
//		        	alert('验证失败！');
            }
        });
    }
});
