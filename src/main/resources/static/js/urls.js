/**
 * Created by haojy on 2018/3/30.
 */
function getShortUrl() {
    var str = $("#url").val();
    console.log(str);
    $.ajax({
        cache : true,
        type : "POST",
        url : "/getShortUrl",
        data : {"url":str},
        async : false,
        error : function() {
            alert("系统异常");
        },
        success : function(data) {
            if (data.code == 0) {
                $('#urls').val(getHost()+data.data);
            }
        }
    });

}

function getJSON(value) {
    var json  = {};
    json.url = value;
    return json;
}

function getHost() {
    var protocol = window.location.protocol;
    var host = window.location.host;
    return protocol+'//'+host+'/';
}