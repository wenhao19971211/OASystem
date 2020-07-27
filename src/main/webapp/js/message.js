$(function () {
    $("#message").click(function () {
        $.ajax({
            url:"page/message.html",
            data:{"empId":1},
            type:"get",
            dataType:"html",
            success:function (data) {
                $("#nr").html(data);
            }
        })
    })

    /**
     * 全部
     */
    $("#all").click(function () {
        $.ajax({
            url:"findAll",
            type:"get",
            data:{"empId":1},
            dataType:"json",
            success:function (data) {
                $("#messageContent").html("");
                for (var i = 0; i < data.list.length; i++){
                    var type = "";
                    if (data.list[i].messageType == 1){
                        type = "任务";
                    }
                    else if (data.list[i].messageType == 2){
                        type = "请假";
                    }
                    else if (data.list[i].messageType == 3){
                        type = "报销";
                    }
                    else if (data.list[i].messageType == 4){
                        type = "补录";
                    }
                    else{
                        type = "加班";
                    }
                    var readStatus = "";
                    if (data.list[i].readStatus ==1){
                        readStatus = "待阅";
                    }
                    else{
                        readStatus = "已阅";
                    }
                    var message = "<input type='text' value='"+type+"'> " +
                        "<input type='text' value='"+data.list[i].messageContent+"'>" +
                        " <input type='text' value='"+readStatus+"'><br>";
                    $("#messageContent").append(message);
                }

            }
        })
    })
    /**
     * 待审
     */
    $("#noExamine").click(function () {
        $("#messageContent").html("");
        $.ajax({
            url:"findNoExamine",
            data:{"empId":1},
            type:"get",
            dataType:"json",
            success:function (data) {
                for (var i = 0; i < data.list.length; i++){
                    var type = "";
                    if (data.list[i].messageType == 1){
                        type = "任务";
                    }
                    else if (data.list[i].messageType == 2){
                        type = "请假";
                    }
                    else if (data.list[i].messageType == 3){
                        type = "报销";
                    }
                    else if (data.list[i].messageType == 4){
                        type = "补录";
                    }
                    else{
                        type = "加班";
                    }
                    var readStatus = "";
                    if (data.list[i].readStatus ==1){
                        readStatus = "待阅";
                    }
                    else{
                        readStatus = "已阅";
                    }
                    var message = "<input type='text' value='"+type+"'> " +
                        "<input type='text' value='"+data.list[i].messageContent+"'>" +
                        " <input type='text' value='"+readStatus+"'><br>";
                    $("#messageContent").append(message);
                }
            }
        })
    })

    /**
     * 已审
     */
    $("#examine").click(function () {
        $("#messageContent").html("");
        $.ajax({
            url:"examine",
            data:{"empId":1},
            dataType:"json",
            success:function (data) {
                for (var i = 0; i < data.list.length; i++){
                    var type = "";
                    if (data.list[i].messageType == 1){
                        type = "任务";
                    }
                    else if (data.list[i].messageType == 2){
                        type = "请假";
                    }
                    else if (data.list[i].messageType == 3){
                        type = "报销";
                    }
                    else if (data.list[i].messageType == 4){
                        type = "补录";
                    }
                    else{
                        type = "加班";
                    }
                    var readStatus = "";
                    if (data.list[i].readStatus ==1){
                        readStatus = "待阅";
                    }
                    else{
                        readStatus = "已阅";
                    }
                    var message = "<input type='text' value='"+type+"'> " +
                        "<input type='text' value='"+data.list[i].messageContent+"'>" +
                        " <input type='text' value='"+readStatus+"'><br>";
                    $("#messageContent").append(message);
                }
            }
        })
    })

    /**
     * 待阅
     */
    $("#noRead").click(function () {
        $("#messageContent").html("");
        $.ajax({
            url:"noRead",
            data:{"empId":1},
            dataType:"json",
            success:function (data) {
                for (var i = 0; i < data.list.length; i++){
                    var type = "";
                    if (data.list[i].messageType == 1){
                        type = "任务";
                    }
                    else if (data.list[i].messageType == 2){
                        type = "请假";
                    }
                    else if (data.list[i].messageType == 3){
                        type = "报销";
                    }
                    else if (data.list[i].messageType == 4){
                        type = "补录";
                    }
                    else{
                        type = "加班";
                    }
                    var readStatus = "";
                    if (data.list[i].readStatus ==1){
                        readStatus = "待阅";
                    }
                    var message = "<input type='text' value='"+type+"'> " +
                        "<input type='text' value='"+data.list[i].messageContent+"'>" +
                        " <input type='text' value='"+readStatus+"'><br>";
                    $("#messageContent").append(message);
                }
            }
        })
    })

    /**
     * 已阅
     */
    $("#read").click(function () {
        $("#messageContent").html("");
        $.ajax({
            url:"read",
            data:{"empId":1},
            dataType:"json",
            success:function (data) {
                for (var i = 0; i < data.list.length; i++){
                    var type = "";
                    if (data.list[i].messageType == 1){
                        type = "任务";
                    }
                    else if (data.list[i].messageType == 2){
                        type = "请假";
                    }
                    else if (data.list[i].messageType == 3){
                        type = "报销";
                    }
                    else if (data.list[i].messageType == 4){
                        type = "补录";
                    }
                    else{
                        type = "加班";
                    }
                    var readStatus = "";
                    if (data.list[i].readStatus ==2){
                        readStatus = "已阅";
                    }
                    var message = "<input type='text' value='"+type+"'> " +
                        "<input type='text' value='"+data.list[i].messageContent+"'>" +
                        " <input type='text' value='"+readStatus+"'><br>";
                    $("#messageContent").append(message);
                }
            }
        })
    })
})

