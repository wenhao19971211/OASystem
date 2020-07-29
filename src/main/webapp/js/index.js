$(function () {
    $(".btn").click(function () {
        $(this).css({background:"#009688",color:"white"});
        $(".btn").not(this).css({background:"white",color:"#009688"});
    })



})