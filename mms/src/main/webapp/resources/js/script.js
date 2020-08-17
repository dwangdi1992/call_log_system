//region === Global Ajax Settings ===
$(document)
    .ajaxSend(function (e, xhr, options) {
        var token = $('input[name="_csrf"]').val();
        xhr.setRequestHeader("X-CSRF-TOKEN", token);
        if (options.type.toUpperCase() === "POST" || options.type.toUpperCase() === "GET") {
            $.blockUI();
        }
        NProgress.start();
    }).ajaxStart(function () {
    NProgress.set(0.4);
}).ajaxStop(function () {
    $.unblockUI();
    NProgress.done();
}).ajaxError(function (event, jgxhr, settings, thrownError) {
    $.unblockUI();
    NProgress.done();
    if (event.redirect) {
        window.location.href = event.redirect;
    }
    switch (jgxhr.status) {
        case 901:
            window.location.href = mmsGlobal.baseURL() + "login";
            break;
        case 500:
            errorMsg("System encountered with problem(s). Please try again or if the problem persist, contact with Administrator.");
            break;
        case 404:
            errorMsg("Invalid Request - 404");
            break;
        case 400:
            errorMsg("Bad Request - 400");
            break;
    }
}).ajaxComplete(function () {
    $.unblockUI();
    NProgress.done();
}).ajaxSuccess(function (event, request, settings) {
    $.unblockUI();
    NProgress.done();
    if (event.redirect) {
        window.location.href = event.redirect;
    }
    var location = request.getResponseHeader('Location');
    if (location && location != window.location.href) {
        window.location.href = location;
    }
});
//endregion === Global Ajax Settings ===


//region === Start of When Document Is Ready ===
$(document).ready(function () {
    $("body").css('overflow', 'hidden');
    $("body").css('overflow', 'auto');

    //region === Menu Heighlighting ===
    var url = window.location.pathname + window.location.search;
    var side_bar = $('.sidebar');
    var nav_item = side_bar.find('.nav-item');
    var menuLink = nav_item.find('.collapse-item');
    $.each(menuLink, function () {
        if ($(this).attr('href') === url) {
            $(this).addClass('active');
            $(this).closest('li').addClass('active');
            $(this).closest('.collapse').addClass('show');
            $(this).closest('.nav-item').addClass('active');
            /*var ul = $(this).parent('li').parent('ul');
            while(!ul.hasClass('sidebar-menu')){
                ul.parent('li').addClass("active");
                ul= ul.parent('li').parent('ul');
            }*/
        }
    });

    nav_item.each(function () {
        var item = $(this).find('.collapse-item').length > 0;

        if (!item) {
            $(this).remove();
        }
    });

    $('.sidebar .sub-item').each(function () {
        var item = $(this).find('.collapse-item').length > 0;

        if (!item) {
            $(this).remove();
        }
    });


    if (!($('.sidebar .nav-item').length > 0)) {
        side_bar.remove();
    }

    loadScript();

});