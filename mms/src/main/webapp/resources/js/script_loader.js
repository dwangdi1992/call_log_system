/**
 * Created By Dechen Wangdi on 05/12/2019
 */

var loadScript = function () {

    if (document.URL.search("usersetup") > 1) {
        scriptLoader("setup/userSetup");
    }

    if (document.URL.search("permissionSetup") > 1) {
        scriptLoader("setup/permissionSetup");
    }

    if (document.URL.search("changePassword") > 1) {
        scriptLoader("setup/changePassword");
    }
    if (document.URL.search("passwordPolicy") > 1) {
        scriptLoader("setup/passwordPolicy");
    }

    if (document.URL.search("groupSetup") > 1) {
        scriptLoader("setup/groupSetup");
    }

    if (document.URL.search("branchSetup") > 1) {
        scriptLoader("setup/branchSetup");
    }

    // mms
    if (document.URL.search("kidu") > 1) {
        scriptLoader("mms/kidu");
    }

    if (document.URL.search("callerLog") > 1) {
        scriptLoader("mms/callerLog");
    }
    if (document.URL.search("callerLog/Report") > 1) {
        scriptLoader("mms/callerLogReport");
    }
};

var scriptLoader = function (url) {
    //TODO for production environment
    url = globalConf.context + '/resources/js/' + url + '.js';
    //url = window.location.host+'/resources/js/' + url + '.js';

    $.ajax(
        {
            type: "GET",
            url: url,
            dataType: "script",
            cache: false
            //cache: prodEnv
        }
    );
};
