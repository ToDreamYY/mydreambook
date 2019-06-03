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
              var li="<li id='"+data[i].mid+"'  class='a'><a href=\"javascript:;\"><i class='"+data[i].icon+"'></i><cite>"+data[i].mname+"</cite><i class='iconfont nav_right'>&#xe697;</i></a></li>"
                 $("#nav").append(li)
             }else{

             }
            }
            var ul="<ul class=\"sub-menu\">"
            $(".a").each(function () {
                for (var i = 0; i < data.length; i++) {
                    if($(this).attr("id")==data[i].p_id){
                      ul+=" <li><a href='"+data[i].url+"' target='myifram'><i class=\"iconfont\">&#xe6a7;</i><cite>"+data[i].mname+"</cite></a></li>"
                    }
                }
                ul+="</ul>";
                $(this).append(ul)
                ul="<ul class=\"sub-menu\">";

            })

        }
    })
    $("body").on('click','.a',function(){
        if($(this).children('.sub-menu').length){
            if($(this).hasClass('open')){
                $(this).removeClass('open');
                $(this).find('.nav_right').html('&#xe697;');
                $(this).children('.sub-menu').stop().slideUp();
                $(this).siblings().children('.sub-menu').slideUp();
            }else{
                $(this).addClass('open');
                $(this).children('a').find('.nav_right').html('&#xe6a6;');
                $(this).children('.sub-menu').stop().slideDown();
                $(this).siblings().children('.sub-menu').stop().slideUp();
                $(this).siblings().find('.nav_right').html('&#xe697;');
                $(this).siblings().removeClass('open');
            }
        }else{

            var url = $(this).children('a').attr('_href');
            var title = $(this).find('cite').html();
            var index  = $('.left-nav #nav li').index($(this));

            for (var i = 0; i <$('.x-iframe').length; i++) {
                if($('.x-iframe').eq(i).attr('tab-id')==index+1){
                    tab.tabChange(index+1);
                    event.stopPropagation();
                    return;
                }
            };
            tab.tabAdd(title,url,index+1);
            tab.tabChange(index+1);
        }

        event.stopPropagation();

    });
})