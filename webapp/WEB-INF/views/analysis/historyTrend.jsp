<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>History Trend</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <%@ include file="../include/mainHeader.jsp" %>
    <jsp:include page="../include/pluginpage.jsp"/>
    <style>
        html, body {
            height: 100%;
            margin: 0;
            font-family: Arial, sans-serif;
        }

        .container2 {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100%;
            padding: 20px;
            background-color: #f8f9fa;
        }

        .button-container {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-bottom: 33px;
            margin-right:350px;
        }

  		 .date-picker {
            margin-right: 10px;
            font-size: 17pt;
            padding: 10px;
            border-radius: 4px;
            width: 250px;
            background-color: #fff;
            border: 3px solid #ccc;
            font-weight: bold;
            height:28px;
        }

        #load-pen-group, #stop-button, #cursor1, #cursor2 {
            margin-left: 10px;
            padding: 10px 20px;
            font-size: 14pt;
            cursor: pointer;
            border: none;
            background-color: #b0b0b0;
            color: white;
            border-radius: 5px;
            transition: background-color 0.3s;
            height:52px;
        }

        #load-pen-group:hover, #stop-button:hover, #cursor1:hover, #cursor2:hover {
            background-color: #8e8e8e;
        }

        #container {
            width: 70%;
            height: 700px;
        }
        
        #pen-group-button {
    margin-left: 10px;
    padding: 10px 20px;
    font-size: 14pt;
    cursor: pointer;
    border: none;
    background-color: #b0b0b0;
    color: white;
    border-radius: 5px;
    transition: background-color 0.3s;
    height: 52px;
}

#pen-group-button:hover {
    background-color: #8e8e8e;
}
        
    </style>
</head>
<body>
<div class="container2">
    <div class="button-container">
        <input type="date" id="startDate" class="date-picker">
        <input type="date" id="endDate" class="date-picker">
        <button id="load-pen-group"><i class="fas fa-save"></i> LOAD PEN GROUP</button>
        <button id="stop-button"><i class="fas fa-stop"></i> STOP</button>
        <button id="cursor1"><i class="fas fa-caret-left"></i> Cursor1</button>
        <button id="cursor2"><i class="fas fa-caret-right"></i> Cursor2</button>
        <button id="pen-group-button"><i class="fas fa-users"></i> 펜 그룹</button>
        
    </div>
    <div id="container"></div>
</div>


<script>
var seriesArray = [];

function formatDate(date) {
    var d = new Date(date);
    var year = d.getFullYear();
    var month = ('0' + (d.getMonth() + 1)).slice(-2);
    var day = ('0' + d.getDate()).slice(-2);
    return year + '-' + month + '-' + day;
}

$(document).ready(function() {
    var today = new Date();
    var startDate = new Date(today);
    startDate.setDate(today.getDate() - 7);
    var endDate = new Date(today);
    endDate.setDate(today.getDate() + 1);

    $("#startDate").val(formatDate(startDate));
    $("#endDate").val(formatDate(endDate));

    var selectedGroup = 'ex4';

    console.log("Initial data load:");
    console.log("sdateTime:", formatDate(startDate) + "T00:00:00");
    console.log("edateTime:", formatDate(endDate) + "T12:59:59");
    console.log("pen_group_name:", selectedGroup);

    getPenGroupChartData();

    $("#pen-group-button").click(function() {
        window.location.href = "/donghwa/analysis/historyTrendPenGroup";
    });
});

function getPenGroupChartData() {
    var sdate = $("#startDate").val() + "T00:00:00";
    var edate = $("#endDate").val() + "T12:59:59";
    var selectedGroup = 'ex4';

    $.ajax({
        url: "/donghwa/analysis/historyTrendPenGroupChart",
        type: "post",
        dataType: "json",
        data: {
            "sdateTime": sdate,
            "edateTime": edate,
            "pen_group_name": selectedGroup
        },
        success: function(result) {
            var data = result.data;
            var groupConcatSplit = data.groupConcat.split(",");
            var dataKeys = Object.keys(data);
            var dataValues = Object.values(data);

            var idx = 0;
            for (var i = 0; i < dataKeys.length; i++) {
                for (var j = 0; j < groupConcatSplit.length; j++) {
                    if (dataKeys[i] == groupConcatSplit[j]) {
                        seriesArray[idx] = dataValues[i];
                        idx++;
                    }
                }
            }

            if (seriesArray.length > 0) {
                getPenGroupChart();
            } else {
                console.log("No data for chart");
            }

            var chart = $("#container").highcharts();
            if (typeof chart != "undefined") {
                chart.redraw();
            }
        }
    });
}

function getPenGroupChart() {
    const chart = Highcharts.chart('container', {
        chart: {
            type: "spline",
            panning: true,
            panKey: "shift",
            zoomType: "x",
            styleMode: true
        },
        time: {
            timezone: "Asia/Seoul",
            useUTC: false
        },
        yAxis: [{
            crosshair: {
                width: 3,
                color: '#5D5D5D',
                zIndex: 5
            },
            title: {
                text: 'Temper(℃)'
            },
            labels: {
                style: {
                    fontSize: "14pt"
                }
            }
        }],
        xAxis: {
            crosshair: {
                width: 3,
                color: '#5D5D5D',
                zIndex: 5
            },
            labels: {
                formatter: function() {
                    return unix_timestamp(this.value);
                },
                style: {
                    fontSize: "11pt"
                }
            },
            allowDecimals: false
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle'
        },
        plotOptions: {
            series: {
                selected: true,
                marker: {
                    radius: 1
                }
            }
        },
        tooltip: {
            split: true,
            shared: true,
            style: {
                fontSize: "14pt"
            }
        },
        series: seriesArray,
        responsive: {
            rules: [{
                condition: {
                    maxWidth: 1200
                },
                chartOptions: {
                    legend: {
                        layout: 'horizontal',
                        align: 'center',
                        verticalAlign: 'bottom'
                    }
                }
            }]
        },
        exporting: {
            menuItemDefinitions: {
                label: {
                    onclick: function() {
                        this.renderer.label(
                            'You just clicked a custom menu item',
                            100,
                            100
                        )
                            .attr({
                                fill: '#a4edba',
                                r: 5,
                                padding: 10,
                                zIndex: 10
                            })
                            .css({
                                fontSize: '1.5em'
                            })
                            .add();
                    },
                    text: 'Show label'
                }
            },
            buttons: {
                contextButton: {
                    menuItems: ['downloadPNG', 'downloadPDF', 'downloadXLS', 'separator']
                }
            }
        },
        legend: {
            itemStyle: {
                fontSize: "11pt"
            }
        }
    });
}

function unix_timestamp(t) {
    var date = new Date(t * 1000);
    var year = date.getFullYear();
    var month = "0" + (date.getMonth() + 1);
    var day = "0" + date.getDate();
    var hour = "0" + date.getHours();
    var minute = "0" + date.getMinutes();
    var second = "0" + date.getSeconds();
    return month.substr(-2) + "-" + day.substr(-2) + " " + hour.substr(-2) + ":" + minute.substr(-2);
}
</script>
</body>
</html>
