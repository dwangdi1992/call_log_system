/**
 * Created by  Sonam Dargay on 12/20/2019.
 */

apiConnection = (function () {
    "use strict";

    function _baseURL() {
        return mmsGlobal.baseURL;
    }

    function search() {
        $('#btnSearch').on('click', function () {
            var searchKey = $('#keyword').val();
            if (searchKey !== '') {
                getLoanInfo(searchKey);
                //getDepositInfo(searchKey);
                //getWorkingCapitalInfo(searchKey);
                //getKiduInfo(searchKey);
                //getLandInfo(searchKey);
                //getBuildingInfo(searchKey);
                //getVehicleInfo(searchKey);

                // TODO not needed now
                // getBusinessInfo(searchKey);
            }
        });
    }


    /**
     * To get land information if any.
     */
    function getLandInfo() {
        var divId = $('#landInfoDiv');
        $.ajax({
            url: _baseURL() + 'getLandInfo',
            type: 'GET',
            success: function (res) {
                var row = '';
                if (res.status === 1) {
                    for (var i in res) {
                        row = row + '<tr align="left">' +
                            '<td></td>' +
                            '<td>' + res[i].accountNo + '</td>' +
                            '<td>' + res[i].sector + '</td>' +
                            '<td>' + res[i].sanctionDate + '</td>' +
                            '<td>' + res[i].sanctionAmt + '</td>' +
                            '<td>' + res[i].outstandingAmt + '</td>' +
                            '<td>' + res[i].finInstitution + '</td>'
                    }
                    var landInfoTbl = $('#landInfoTbl');
                    landInfoTbl.dataTable().fnDestroy();
                    landInfoTbl.find('tbody').empty().prepend(row);
                    landInfoTbl.dataTable();
                    divId.removeClass('hidden');
                } else {
                    divId.addClass('hidden');
                }
            }
        })
    }


    /**
     * To get vehicle information if any.
     */
    function getVehicleInfo() {
        var divId = $('#vehicleInfoDiv');
        $.ajax({
            url: _baseURL() + 'getVehicleInfo',
            type: 'GET',
            success: function (res) {
                var row = '';
                if (res.status === 1) {
                    for (var i in res) {
                        row = row + '<tr align="left">' +
                            '<td></td>' +
                            '<td>' + res[i].accountNo + '</td>' +
                            '<td>' + res[i].sector + '</td>' +
                            '<td>' + res[i].sanctionDate + '</td>' +
                            '<td>' + res[i].sanctionAmt + '</td>' +
                            '<td>' + res[i].outstandingAmt + '</td>' +
                            '<td>' + res[i].finInstitution + '</td>'
                    }
                    var vehicleInfoTbl = $('#vehicleInfoTbl');
                    vehicleInfoTbl.dataTable().fnDestroy();
                    vehicleInfoTbl.find('tbody').empty().prepend(row);
                    vehicleInfoTbl.dataTable();
                    divId.removeClass('hidden');
                } else {
                    divId.addClass('hidden');
                }
            }
        })
    }

    function init() {
        search();
    }

    return {
        init: init
    };
})();

$(document).ready(function () {
    apiConnection.init();
});
