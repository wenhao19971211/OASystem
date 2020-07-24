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