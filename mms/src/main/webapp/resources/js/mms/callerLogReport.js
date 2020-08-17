/**
 * Created by Dechen Wangdi on 29-Jun-2020.
 */

callerLogReport = (function () {
    "use strict";

    var formId = $("#callerLog");


    function _baseURL() {
        return mmsGlobal.baseURL + 'callerLog/Report';
    }


    /**
     * To get get Caller LogList
     */
    function getCallerLogList() {
        $.ajax({
            url: _baseURL() + '/getCallerLogList',
            type: 'GET',
            success: function (res) {
                prepareTable($('#callerLogTbl'), res);
            }
        })
    }


    /**
     * To prepare the datatable.
     * @param element
     * @param res
     */
    function prepareTable(element, res) {
        var row = '';
        if (!isEmpty(res)) {
            for (var i in res) {
                var status = "";
                var count = 1;
                if (res[i].status == 1) {
                    status = "Resolved"
                } else {
                    status = "Unresolved";
                }
                row = row + '<tr align="left">' +
                    '<td>' + parseInt(parseInt(i) + parseInt(1)) + '</td>' +
                    '<td>' + res[i].supper_zone + '</td>' +
                    '<td>' + res[i].zone + '</td>' +
                    '<td>' + res[i].contact_no + '</td>' +
                    '<td>' + res[i].call_attend_by + '</td>' +
                    '<td>' + res[i].dateText + '</td>' +
                    '<td>' + status + '</td>'
            }

            element.dataTable().fnDestroy();
            element.find('tbody').empty().prepend(row);
            element.dataTable();
        } else {
            element.find('tbody').empty()
        }
    }

    function init() {
        getCallerLogList();
    }

    return {
        init: init
    };
})();

$(document).ready(function () {
    callerLogReport.init();
});
