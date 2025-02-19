<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- jQuery -->
<script type="text/javascript" src="/donghwa/js/jquery-3.7.1.min.js"></script>

<!-- Tabulator -->
<script type="text/javascript" src="/donghwa/js/tabulator/tabulator.js"></script>
<link rel="stylesheet" href="/donghwa/css/tabulator/tabulator_simple.css">

<!-- HighChart -->
<script type="text/javascript" src="/donghwa/js/highchart/highcharts.js"></script>
<script type="text/javascript" src="/donghwa/js/highchart/exporting.js"></script>
<script type="text/javascript" src="/donghwa/js/highchart/export-data.js"></script>
<!--  
<script type="text/javascript" src="/donghwa/js/highchart/data.js"></script>
-->

<!-- Air Datepicker -->
<script type="text/javascript" src="/donghwa/js/airdatepicker/datepicker.min.js"></script>
<script type="text/javascript" src="/donghwa/js/airdatepicker/datepicker.ko.js"></script>
<link rel="stylesheet" href="/donghwa/css/airdatepicker/datepicker.min.css"> 
<link rel="stylesheet" href="/donghwa/css/select2/select2.css">


<script type="text/javascript" src="/donghwa/js/select2/select2.min.js"></script>

<style>
	


	
	
</style>
	
<script>
$(".datetimeSet").datepicker({
    language: 'ko',
    autoClose: true,
    timepicker: true,         // 시간 선택 활성화
    dateFormat: 'yyyy-mm-dd', // 날짜 형식
    timeFormat: 'HH:ii',      // 시간과 분 형식
    step: 1,                  // 분 단위 조정(예: 5분 단위)
});

$(".datetimeSet2").datepicker({
    language: 'ko',
    autoClose: true,
    timepicker: true,         // 시간 선택 활성화
    dateFormat: 'yyyy-mm-dd', // 날짜 형식
    timeFormat: 'HH:ii',      // 시간과 분 형식
    step: 1,                  // 분 단위 조정(예: 5분 단위)
});
</script>
