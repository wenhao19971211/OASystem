layui.use(['form','layer','laydate'],function(){
    var form = layui.form;
    var laydate = layui.laydate;
        layer = parent.layer === undefined ? layui.layer : top.layer;
        $ = layui.jquery;

    form.on("submit(addUser)",function(data){
        var receiveEmpIds = [];
        $("input[name='receiveEmpIds']:checked").each(function(i){
            //把所有被选中的复选框的值存入数组
            receiveEmpIds[i]=$(this).val();
        })
        var url = "addTask?title="+ $(".title").val()+"&startTime="+$("#startTime").val()+"&finishTime="+$("#finishTime").val()+"&content="+$(".content").val()+"&receiveEmpIds="+receiveEmpIds;
        //弹出loading
        //var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        // 实际使用时的提交信息
        $.post(url,{
            // title : $(".title").val(),  //任务标题
            // startTime : $("#startTime").val(),  //开始时间
            // finishTime : $("#finishTime").val(),  //截至时间
            // content : $(".content").val(),  //任务内容
            // receiveEmpIds : receiveEmpIds,    //接收人

        },function(res){
            confirm(res);
            parent.location.reload();
        })
        setTimeout(function(){
                    //top.layer.close(index);
                    top.layer.msg("任务发布成功！");
                    layer.closeAll("iframe");
                    //刷新父页面
                    parent.location.reload();
                },2000);
                return false;
     })

    //格式化时间
    function filterTime(val){
        if(val < 10){
            return "0" + val;
        }else{
            return val;
        }
    }
    //定时发布
    var time = new Date();
    var submitTime = time.getFullYear()+'-'+filterTime(time.getMonth()+1)+'-'+filterTime(time.getDate())+' '+filterTime(time.getHours())+':'+filterTime(time.getMinutes())+':'+filterTime(time.getSeconds());

    //日期时间选择器
    laydate.render({
        elem: '#finishTime'
        ,type: 'datetime'
        ,min: -7 //7天前
        ,max: 7 //7天后
    });


//日期时间选择器
    laydate.render({
        elem: '#startTime'
        ,type: 'datetime'
        ,min: -7 //7天前
        ,max: 7 //7天后
    });


})


