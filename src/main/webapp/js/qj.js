$("#qj").click(function () {
    alert("哈哈哈");
    var empId=$("#empId").val();
    $.ajax({
        url:"page/leave.html",
        data:{"empId":empId},
        type:"get",
        dataType:"html",
        success:function (data) {
            $("#nr").html(data);
        }
    })
})