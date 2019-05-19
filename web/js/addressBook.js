$(function () {
    $("#table").bootstrapTable({
        url:"../address/get",//请求的url地址
        method:"post",//请求方式
        // striped:true,//是否显示行间隔色
        pageSize:10,//每页显示的数量
        pageList: [10,20],//提供选择每页显示多少条
        showRefresh:false,//是否显示刷新按钮
        cache:false,//是否使用缓存
        showToggle:false,//是否显示详细视图和列表视图的切换按钮
        pagination:true,//是否显示分页
        hegiht:500,//表格的高度
        pageNumber:1,//初始化显示第几页，默认第1页
        singleSelect:true,//复选框只能选择一条记录
        sidePagination : 'server',//分页显示方式，可以选择客户端和服务端（server|client）
        contentType: "application/x-www-form-urlencoded",//使用post请求时必须加上
        dataType:"json",//接收的数据类型
        queryParamsType:'limit',//参数格式，发送标准的Restful类型的请求
        //得到查询参数即发给服务端的参数
        queryParams:function(params){
            var nowPage=params.offset;
            return{
                page: (params.offset/params.limit)+1,//第几页
                size: params.limit,//每页显示多少条
            }
        },
        //回调函数
        responseHandler:function(res){
            console.log(res);//查看从服务端得到的数据
            console.log(res.data.address.content);
            return{
                "total":res.data.address.totalElements,//当采用服务端分时必须给total赋值即从服务端得到总条数，表格将自动根据总条数进行分页
                "rows":res.data.address.content//每行显示的数据集合，注意必须是（total和rows不能是其他的字段，否则将不能显示数据或分页）
            }
        },
        columns:[{
            field: "select", checkbox: true},//开启选择框
            {field:"name", title:"姓名",sortable: true},//表头，其中field值是返回JSON格式中对应的属性
            {field:"sex", title:"性别",sortable: true},
            {field:"email", title:"Email",sortable: true},
            {field:"qq", title:"QQ号码",sortable: true},
            {field:"company", title:"工作单位",sortable: true},
            {field:"address", title:"地址",sortable: true},
            {field:"postcode", title:"邮编",sortable: true}]
    });
    $(".add").click(function () {
        window.location.href="addAddressBook.html";
    });
    $(".update").click(function () {
        var row = $.map($('#table').bootstrapTable('getSelections'),function (row) {
            return row;
        });
        if (row.length==0) {
            alert("请选中行");
            return false;
        }
        window.location.href="updateAddressBook.html?"+row[0].id;
    });
});