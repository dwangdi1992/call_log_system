/**
 * Created by  Sonam Dargay on 12/20/2019.
 */

financialInfo = (function () {
    "use strict";

    function _baseURL() {
        return mmsGlobal.baseURL;
    }

    function search() {
        $('#btnSearch').on('click', function () {
            var searchKey = $('#keyword').val();
            if (searchKey !== '') {
                getPersonalInfo(searchKey);
                getLoanInfo(searchKey);
                getDepositInfo(searchKey);
                getCitizenInfo(searchKey);
                //getWorkingCapitalInfo(searchKey);
                getKiduInfo(searchKey);
                getLandInfo(searchKey);
                //getBuildingInfo(searchKey);
                getVehicleInfo(searchKey);

                // TODO not needed now
                // getBusinessInfo(searchKey);
            }
        });
    }

    /**
     * To get loan information if any.
     */
    function getPersonalInfo(searchKey) {
        $.ajax({
            url: _baseURL() + 'getPersonalInfo',
            data: {searchKey: searchKey},
            type: 'GET',
            success: function (res) {
                var row = '', dto = res.dto;
                if (res.status == 1) {
                    $('#cidNo').text(dto.cidNo);
                    $('#name').text(dto.fullName);
                    $('#dzongkhag').text(dto.dzongkhagNmae);
                    $('#gewog').text(dto.gowegName);
                    $('#village').text(dto.villageName);
                } else {
                    $('#cidNo').text('');
                    $('#name').text('');
                    $('#dzongkhag').text('');
                    $('#gewog').text('');
                    $('#village').text('');
                }
            }
        })
    }


    /**
     * To get loan information if any.
     */
    function getLoanInfo(searchKey) {
        var isDataExist = false;
        $.ajax({
            url: _baseURL() + 'getLoanInfo',
            data: {searchKey: searchKey},
            type: 'GET',
            success: function (res) {
                var row = '';
                if (!isEmpty(res)) {
                    for (var i in res) {
                        row = row + '<tr align="left">' +
                            '<td>' + res[i].accountNo + '</td>' +
                            '<td>' + res[i].sector + '</td>' +
                            '<td>' + res[i].sanctionDate + '</td>' +
                            '<td>' + commaSeparator(res[i].sanctionAmt) + '</td>' +
                            '<td>' + commaSeparator(res[i].outstandingAmt) + '</td>' +
                            '<td>' + res[i].finInstitution + '</td>';
                    }

                    covertToDatatable($('#loanDetailTbl'), row);
                    isDataExist = true;
                }
                collapseDiv($('#loanDetailDiv'), isDataExist);
            }
        })
    }

    /**
     * To get deposit information if any.
     */
    function getDepositInfo(searchKey) {
        var isDataExist = false;
        $.ajax({
            url: _baseURL() + 'getDepositInfo',
            data: {searchKey: searchKey},
            type: 'GET',
            success: function (res) {
                var row = '';
                if (!isEmpty(res)) {
                    for (var i in res) {
                        row = row + '<tr align="left">' +
                            '<td>' + res[i].cid + '</td>' +
                            '<td>' + res[i].depositType + '</td>' +
                            '<td>' + commaSeparator(res[i].amount) + '</td>' +
                            '<td>' + res[i].finInstitution + '</td>'
                    }
                    covertToDatatable($('#depositDetailTbl'), row);
                    isDataExist = true;
                }
                collapseDiv($('#depositDetailDiv'), isDataExist);
            }
        })
    }

    function getCitizenInfo(searchKey) {
        var isDataExist = false;
        $.ajax({
            url: _baseURL() + 'getCitizenInfo',
            data: {searchKey: searchKey},
            type: 'GET',
            success: function (res) {
                /*var row = '';
                if (!isEmpty(res)) {
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
                    covertToDatatable($('#workingCapitalTbl'), row);
                    isDataExist = true;
                }
                collapseDiv($('#workingCapitalDiv'), isDataExist);*/
            }
        })
    }

    /**
     * To get working capital information if any.
     */
    function getWorkingCapitalInfo(searchKey) {
        var isDataExist = false;
        $.ajax({
            url: _baseURL() + 'getWorkingCapitalInfo',
            data: {searchKey: searchKey},
            type: 'GET',
            success: function (res) {
                var row = '';
                if (!isEmpty(res)) {
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
                    covertToDatatable($('#workingCapitalTbl'), row);
                    isDataExist = true;
                }
                collapseDiv($('#workingCapitalDiv'), isDataExist);
            }
        })
    }

    /**
     * To get kidu information if any.
     */
    function getKiduInfo(searchKey) {
        var isDataExist = false;
        $.ajax({
            url: _baseURL() + 'getKiduInfo',
            data: {searchKey: searchKey},
            type: 'GET',
            success: function (res) {
                var row = '';
                if (!isEmpty(res)) {
                    for (var i in res) {
                        row = row + '<tr align="left">' +
                            // '<td></td>' +
                            '<td>' + res[i].searchKey + '</td>' +
                            '<td>' + res[i].occupation + '</td>' +
                            '<td>' + res[i].sector + '</td>' +
                            '<td>' + res[i].companyName + '</td>' +
                            '<td>' + commaSeparator(res[i].totalKiduAmt) + '</td>';
                    }

                    covertToDatatable($('#dgkTbl'), row);
                    isDataExist = true;
                }
                collapseDiv($('#dgkDiv'), isDataExist);
            }
        });
    }

    /**
     * To get land information if any.
     */
    function getLandInfo(searchKey) {
        var isDataExist = false;
        $.ajax({
            url: _baseURL() + 'getLandInfo',
            data: {searchKey: searchKey},
            type: 'GET',
            success: function (res) {
                var row = '';
                res = res.dto;
                if (!isEmpty(res)) {
                    for (var i in res) {
                        row = row + '<tr align="left">' +
                            //'<td></td>' +
                            '<td>' + searchKey + '</td>' +
                            '<td>' + res[i].ownerName + '</td>' +
                            '<td>' + res[i].landLocationFlag + '</td>' +
                            '<td>' + res[i].thramNumber + '</td>' +
                            '<td>' + res[i].landTypeOrPrecinct + '</td>' +
                            '<td>' + res[i].ownershipType + '</td>' +
                            '<td>' + res[i].plotNetArea + " " + res[i].plotAreaUnit + '</td>' +
                            '<td>' + res[i].plotId + '</td>' +
                            '<td>' + res[i].gewogOrThromdeVillage + '</td>'
                    }
                    var landInfoTbl = $('#landInfoTbl');
                    landInfoTbl.dataTable().fnDestroy();
                    landInfoTbl.find('tbody').empty().prepend(row);
                    landInfoTbl.dataTable();
                    isDataExist = true;
                }
                collapseDiv($('#landInfoDiv'), isDataExist);
            }
        })
    }

    /**
     * To get build or house information in any.
     */
    function getBuildingInfo(searchKey) {
        var isDataExist = false;
        $.ajax({
            url: _baseURL() + 'getBuildingInfo',
            data: {searchKey: searchKey},
            type: 'GET',
            success: function (res) {
                var row = '';
                if (!isEmpty(res)) {
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

                    covertToDatatable($('#buildingTbl'), row);
                    isDataExist = true;
                }
                collapseDiv($('#buildingDiv'), isDataExist);
            }
        });
    }

    /**
     * To get vehicle information if any.
     */
    function getVehicleInfo(searchKey) {
        var isDataExist = false;
        $.ajax({
            url: _baseURL() + 'getVehicleInfo',
            data: {searchKey: searchKey},
            type: 'GET',
            success: function (res) {
                var row = '';
                res = res.dto;
                if (!isEmpty(res)) {
                    for (var i in res) {
                        if (res[i].vehicleNumber != null) {
                            row = row + '<tr align="left">' +
                                '<td>' + searchKey + '</td>' +
                                '<td>' + res[i].ownerName + '</td>' +
                                '<td>' + res[i].vehicleNumber + '</td>' +
                                '<td></td>' +
                                '<td>' + res[i].engineNumber + '</td>' +
                                '<td>' + res[i].vehicleTypeName + '</td>' +
                                '<td>' + res[i].expiryDate + '</td>';
                        }
                    }
                    covertToDatatable($('#vehicleInfoTbl'), row);
                    isDataExist = true;
                }
                collapseDiv($('#vehicleInfoDiv'), isDataExist);
            }
        })
    }

    /**
     * To get business information if any.
     */
    function getBusinessInfo(searchKey) {
        var isDataExist = false;
        $.ajax({
            url: _baseURL() + 'getBusinessInfo',
            data: {searchKey: searchKey},
            type: 'GET',
            success: function (res) {
                var row = '';
                if (!isEmpty(res)) {
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

                    covertToDatatable($('#businessTbl'), row);
                    isDataExist = true;
                }
                collapseDiv($('#businessDiv'), isDataExist);
            }
        })
    }

    /**
     * To show or hide the div content.
     * @param element
     * @param isDataExist
     */
    function collapseDiv(element, isDataExist) {
        if (isDataExist) {
            element.removeAttr('hidden');
        } else {
            element.attr('hidden', 'hidden');
        }
    }

    function covertToDatatable(element, row) {
        element.dataTable().fnDestroy();
        element.find('tbody').empty().prepend(row);
        element.dataTable();
    }


    function getTotalKiduDisbursed() {
        $.ajax({
            url: _baseURL() + 'getTotalKiduDisbursed',
            type: 'GET',
            success: function (res) {
                var dataPoints = [];
                if (res != null) {
                    for (var i in res) {
                        dataPoints.push({label: res[i].name, y: parseFloat(res[i].amount)});
                    }
                }

                var chart = new CanvasJS.Chart("total_amount", {
                    animationEnabled: true,
                    title: {
                        text: "Total amount(Working Capital, Loan, Deposit, Kidu)",
                        fontSize: 14
                    },
                    axisX: {
                        interval: 1
                    },
                    axisY: {
                        title: "Millions",
                    },
                    data: [{
                        type: "bar",
                        dataPoints: dataPoints
                    }]
                });
                chart.render();
            }
        });
    }

    /**
     * Deposit pie information.
     */
    function getDepositByBank() {
        $.ajax({
            url: _baseURL() + 'getDepositByBank',
            type: 'GET',
            success: function (res) {
                var dataPoints = [];
                if (res != null) {
                    for (var i in res) {
                        dataPoints.push({label: res[i].finInstitution, y: parseFloat(res[i].amount)});
                    }
                }

                var chart = new CanvasJS.Chart("deposit_by_bank", {
                    animationEnabled: true,
                    title: {
                        text: "Financial Inst. wise Deposit",
                        fontSize: 14
                    },
                    data: [{
                        type: "pie",
                        startAngle: 240,
                        yValueFormatString: "##0.00\"%\"",
                        indexLabel: "{label} {y}",
                        dataPoints: dataPoints,
                        width: 10
                    }]
                });
                chart.render();
            }
        });
    }


    function init() {
        search();
        getTotalKiduDisbursed();
        getDepositByBank();
    }

    return {
        init: init
    };
})();

$(document).ready(function () {
    financialInfo.init();
});
