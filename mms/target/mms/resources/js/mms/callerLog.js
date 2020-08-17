/**
 * Created by Dechen Wangdi on 29-Jun-2020.
 */

callerLog = (function () {
    "use strict";

    var formId = $("#callerLog");

    function _baseURL() {
        return mmsGlobal.baseURL + 'callerLog';
    }

    function save() {
        $(formId).on('click', '#btnSave', function (e) {
            $(formId).validate({
                submitHandler: function (form) {
                    $.ajax({
                        url: _baseURL() + '/save',
                        type: 'POST',
                        data: $(form).serializeArray(),
                        success: function (res) {
                            if (res.status == 1) {
                                successMsg(res.text,_baseURL());
                            } else {
                                errorMsg(res.text);
                            }
                        }
                    });
                }
            });
        })
    }

    function init() {
        save();
    }

    return {
        init: init
    };
})();

$(document).ready(function () {
    callerLog.init();
});
