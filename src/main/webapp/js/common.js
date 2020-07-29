/**
 * 解析url
 * @param url
 */
function parseUrl(url) {
    if (url.indexOf("?")){
        url = url.substring(url.indexOf("?")+1);
        var param = url.split("&");
        var obj = new Object();
        for (var i = 0; i <param.length; i++){
            var keyValue = param[i].split("=");
            var key = keyValue[0];
            var value = keyValue[1];
            obj[key] = value;
        }
        return obj;
    }
}

function parseDate(time) {
    var date = new Date(time);
    var hireDate = "";
    Y = date.getFullYear();
    M = (date.getMonth()+1 <10 ? '0'+(date.getMonth()+1):date.getMonth()+1);
    D = (date.getDate() <10 ? '0'+(date.getDate()):date.getDate());
    hireDate = Y+"-"+M+"-"+D;
    return hireDate;

}

function parseDate1(time) {
    var date = new Date(time);
    var hireDate="";
    H = date.getHours();
    m = (date.getMinutes() <10 ? '0'+(date.getMinutes()):date.getMinutes());
    s = (date.getSeconds() <10 ? '0'+(date.getSeconds()):date.getSeconds());
    hireDate = H+":"+m+":"+s;
    return hireDate;
}


function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate;
    return currentdate;
}

/**
 * 获取本月第一天
 */
function getFirstDay() {
    var now = new Date(); //当前日期
    var nowMonth = now.getMonth(); //当前月
    var nowYear = now.getFullYear(); //当前年
    //本月的开始时间
    var monthStartDate = new Date(nowYear, nowMonth, 1);
    var timeStar=Date.parse(monthStartDate);//s
    return timeStar;
}

/**
 * 获取本月最后一天
 */
function getLastDay() {
    var now = new Date(); //当前日期
    var nowMonth = now.getMonth(); //当前月
    var nowYear = now.getFullYear(); //当前年
    //本月的结束时间
    var monthEndDate = new Date(nowYear, nowMonth+2, 1);
    var timeEnd=Date.parse(monthEndDate);//s
    return timeEnd;
}