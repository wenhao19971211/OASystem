layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    //任务列表
    var tableIns = table.render({
        elem: '#userList',
        url : 'findTaskByTitle',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 20,
        id : "userListTable",
        parseData:function(data){//res 即为原始返回的数据
            data =$.parseJSON(data);
            return data;
            },
        cols : [[
            {field: 'taskSendId', title: '任务发布编号', width:100,edit: 'text', del:'test', fixed: 'left'}
            ,{field: 'title', title: '任务标题',edit: 'text', width:150}
            ,{field: 'status', title: '任务完成状态', width: 100}
            ,{field: 'taskReceiveEmpName', title: '任务接收人', width: 100,}
            ,{field: 'startTime', title: '开始时间', width:120, sort: true, }
            ,{field: 'finishTime', title: '完成时间', width:120, sort: true,}
            ,{field: 'taskSendEmpName', title: '任务发布人', width: 100}
            ,{field: 'content', title: '任务内容'}
        ]]
    });

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){
            table.reload("userListTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    title: $(".searchVal").val()  //搜索的关键字
                }
            })




        }else{
            layer.msg("请输入搜索的内容");
        }
    });

    //任务发布
    function addUser(edit){
        var index = layui.layer.open({
            title : "任务发布",
            type : 2,
            content : "page/TaskAdd.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                // if(edit){
                //     body.find(".userName").val(edit.userName);  //登录名
                //     body.find(".userEmail").val(edit.userEmail);  //邮箱
                //     body.find(".userSex input[value="+edit.userSex+"]").prop("checked","checked");  //性别
                //     body.find(".userGrade").val(edit.userGrade);  //会员等级
                //     body.find(".userStatus").val(edit.userStatus);    //用户状态
                //     body.find(".userDesc").text(edit.userDesc);    //用户简介
                //     form.render();
                // }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        })
        layui.layer.full(index);
        window.sessionStorage.setItem("index",index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(window.sessionStorage.getItem("index"));
        })
    }
    $(".addNews_btn").click(function(){
        addUser();
    })

    //批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('userListTable'),
            data = checkStatus.data,
            newsId = [];
        if(data.length > 0) {
            for (var i in data) {
                newsId.push(data[i].newsId);
            }
            layer.confirm('确定删除选中的用户？', {icon: 3, title: '提示信息'}, function (index) {
                // $.get("删除文章接口",{
                //     newsId : newsId  //将需要删除的newsId作为参数传入
                // },function(data){
                tableIns.reload();
                layer.close(index);
                // })
            })
        }else{
            layer.msg("请选择需要删除的用户");
        }
    })

    //列表操作
    table.on('tool(userList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
            addUser(data);
        }else if(layEvent === 'usable'){ //启用禁用
            var _this = $(this),
                usableText = "是否确定禁用此用户？",
                btnText = "已禁用";
            if(_this.text()=="已禁用"){
                usableText = "是否确定启用此用户？",
                btnText = "已启用";
            }
            layer.confirm(usableText,{
                icon: 3,
                title:'系统提示',
                cancel : function(index){
                    layer.close(index);
                }
            },function(index){
                _this.text(btnText);
                layer.close(index);
            },function(index){
                layer.close(index);
            });
        }else if(layEvent === 'del'){ //删除
            layer.confirm('确定删除此用户？',{icon:3, title:'提示信息'},function(index){
                // $.get("删除文章接口",{
                //     newsId : data.newsId  //将需要删除的newsId作为参数传入
                // },function(data){
                    tableIns.reload();
                    layer.close(index);
                // })
            });
        }
    });

})
