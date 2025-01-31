<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <%@ include file="../include/mainHeader.jsp" %>
  <jsp:include page="../include/pluginpage.jsp"/>
  <link rel="stylesheet" href="/donghwa/css/furnace/overview.css">

  <style>
    a, button, input, select, h1, h2, h3, h4, h5, * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
        border: none;
        text-decoration: none;
        background: none;
        -webkit-font-smoothing: antialiased;
    }

    menu, ol, ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
    }

    body {
        display: flex;
        justify-content: center;
        align-items: flex-start;
        height: 100vh;
        background-color: #E2E2E2;
    }

    .table-container {
        position: relative;
        top: 300px;
        display: grid;
        grid-template-columns: repeat(2, 1fr);
        grid-template-rows: repeat(3, 1fr);
        gap: 30px;
        width: 34%;
    }

    .table {
        display: grid;
        grid-template-columns: 1fr 1fr;
        grid-template-rows: auto 1fr;
        width: 100%;
        height: 100%;
        border: 1px solid #ccc;
        border-radius: 8px;
    }

    .table-header {
        color: black;
        padding: 10px;
        text-align: center;
        font-size: 1.2em;
        font-weight: bold;
        grid-column: span 2;
    }

    .table1 .table-header {
        background-color: #f1a7b2;
    }

    .table2 .table-header {
        background-color: #109010;
    }

    .table3 .table-header {
        background-color: #7aaedc;
    }

    .table4 .table-header {
        background-color: #109010;
    }

    .table-cell {
        background-color: white;
        border-top: 1px solid #ccc;
        padding: 10px;
        text-align: center;
    }
  </style>

  <title>Document</title>
</head>
<body>

  <div class="rectangle-104"></div>
  <div class="rectangle-105"></div>
  <div class="ellipse-4"></div>
  <div class="ellipse-5"></div>
  <div class="rectangle-106"></div>
  <div class="rectangle-107"></div>
  <div class="rectangle-108"></div>
  <div class="rectangle-109"></div>
  <div class="rectangle-110"></div>
  <div class="rectangle-111"></div>
  <div class="rectangle-112"></div>
  <div class="rectangle-113"></div>
  <img class="_3" src="/donghwa/css/furnace/img/_30.png" />
  <img class="_4" src="/donghwa/css/furnace/img/_40.png" />

  <div class="table-container">
    <div class="table table1">
      <div class="table-header">Furance temperature     Auto</div>
      <div class="table-cell">TIC 4.x</div>
      <div class="table-cell">내용2</div>
      <div class="table-cell">TSP 4</div>
      <div class="table-cell">내용 4</div>
    </div>

    <div class="table table2">
      <div class="table-header">Position</div>
      <div class="table-cell">GIC 22.260.10</div>
      <div class="table-cell">내용 2</div>
      <div class="table-cell">GSP 22.260.10</div>
      <div class="table-cell">내용 4</div>
    </div>

    <div class="table table3">
      <div class="table-header">Furnace Pressure</div>
      <div class="table-cell">PIS 6.x / 13.5</div>
      <div class="table-cell">내용 2</div>
      <div class="table-cell">PSP 6</div>
      <div class="table-cell">내용 4</div>
    </div>

    <div class="table table4">
      <div class="table-header">Press capacity</div>
      <div class="table-cell">WIC 22.4.2 X</div>
      <div class="table-cell">내용 2</div>
      <div class="table-cell">WSC 22.4.2 X</div>
      <div class="table-cell">내용 4</div>
    </div>
  </div>

</body>
</html>
