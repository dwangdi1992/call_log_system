/**
 * Created by sangay Tenzin on 12/20/2019.
 */
passwordPolicy = (function () {
    "use strict";
    var formID = "#passwordPolicyForm";
    var isSubmitted = false;

    function _baseURL() {
        return mmsGlobal.baseURL + "passwordPolicy"
    }

    function save() {
        $(formID).on('click', '#btnSave', function () {
            $(formID).validate({
                submitHandler: function (form) {
                    $.ajax({
                        url: _baseURL() + '/save',
                        type: 'POST',
                        data: $(form).serializeArray(),
                        success: function (res) {
                            if (res.status == 1) {
                                successMsg(res.text, _baseURL());
                                getPasswordPolicyInfo();
                            } else {
                                warningMsg(res.text);
                            }
                        }
                    });
                }
            });
        })
    }

    function getPasswordPolicyInfo() {
        $.ajax({
            url: _baseURL() + '/getPasswordPolicyInfo',
            type: 'GET',
            success: function (res) {
                if (res.isMaxLength)  $('#isMaxLength').attr('checked', true);
                if (res.isEnforcePasswordChange) $('#isEnforcePasswordChange').attr('checked', true);
                if (res.isSpecialChar) $('#isSpecialChar').attr('checked', true);
                if (res.isExpiryDaysEnable) $('#isExpiryDaysEnable').attr('checked', true);
            }
        });
    }

    return {
        save: save,
        getPasswordPolicyInfo: getPasswordPolicyInfo
    };
})();

$(document).ready(function () {
    passwordPolicy.save();
    passwordPolicy.getPasswordPolicyInfo();
});

