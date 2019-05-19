$(function () {
    $("#table").bootstrapTable({
        url:"../message/get",
        method:"post",
        // striped:true,
        pageSize:10,
        pageList: [10,20],
        showRefresh:false,
        cache:false,
        showToggle:false,
        pagination:true,
        hegiht:500,
        pageNumber:1,
        singleSelect:true,
        sidePagination : 'server',
        contentType: "application/x-www-form-urlencoded",
        dataType:"json",
        queryParamsType:'limit',
        queryParams:function(params){
            var nowPage=params.offset;
            return{
                page: (params.offset/params.limit)+1,//从数据库第几条记录开始
                size: params.limit,//找多少条
            }
        },
        responseHandler:function(res){
            console.log(res);
            console.log(res.data.message.content);
            return{
                "total":res.data.message.totalElements,
                "rows":res.data.message.content
            }
        },
        columns:[{
            field: "select", checkbox: true,},
            {field:"sender", title:"发送者",sortable: true},
            {field:"message", title:"消息内容",sortable: true},
            {field:"sendtime", title:"发送时间",sortable: true},
            {field:"isRead", title:"是否阅读",sortable: true}]
    });
    $(".read").click(function () {
        var row = $.map($('#table').bootstrapTable('getSelections'),function (row) {
            return row;
        });
        console.log(row[0]);
        $.ajax({
            url:"../message/update",
            type:"post",
            data:{
                id:row[0].id
            },
            dataType:"json",
            success:function (data) {
                if (data.code == 200) {
                    window.location.href="information.html";
                }
            }
        });
    });
    $(".send").click(function () {
        window.location.href="sendInforamtion.html";
    });
    $(".delete").click(function () {
        var row = $.map($('#table').bootstrapTable('getSelections'),function (row) {
            return row;
        });
        if (row.length == 0) {
            alert("请选中行");
        }
        $.ajax({
            url:"../message/delete",
            type:"post",
            data:{
                id:row[0].id
            },
            dataType:"json",
            success:function (data) {
                if (data.code == 200) {
                    window.location.href="information.html";
                }
            }
        });
    });
});