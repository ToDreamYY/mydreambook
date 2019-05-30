$(function () {
    /*通过uid去获取此用户的权限以及菜单*/
    $.ajax({
        url:"/findRolesAndMenusByUid",
        data:{
            uid:$("#uid").text()
        },
        success:function (data) {
           /*data就是获取到的菜单*/

            for (var i = 0; i < data.length; i++) {
             if(data[i].p_id==1){
                 /*取到父菜单*/
              var li="<li id='"+data[i].mid+"'  class='a'><a href='#' ><i class='icon-cogs'></i><span class='title'>"+data[i].mname+"</span><span class='arrow'></span></a></li>"
                 $("#index").append(li)
             }else{

             }
            }
            var ul="<ul class=\"sub-menu\">"
            $(".a").each(function () {
                for (var i = 0; i < data.length; i++) {
                    if($(this).attr("id")==data[i].p_id){
                      ul+=" <li><a href='"+data[i].url+"'>"+data[i].mname+"</a></li>"
                    }
                }
                ul+="</ul>";
                $(this).append(ul)
                ul="<ul class=\"sub-menu\">";

            })


        }
    })
})