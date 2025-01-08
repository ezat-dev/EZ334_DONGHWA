<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>동화엔텍</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<style>
    body, html {
      margin: 0;
      padding: 0;
      height: 100%;
    }

    .header {
      background: #123478;
      width: 100%; 
      height: 60px;
      position: fixed;
      top: 0;
      left: 0;
      z-index: 10;
    }

    .hamburger-icon {
      width: 33px;
      height: 27.19px;
      position: absolute;
      left: 13px;
      top: 12px;
      cursor: pointer; 
      z-index: 3;
      display: flex;
      flex-direction: column;
      justify-content: space-between;
    }

    .hamburger-icon div {
      width: 100%;
      height: 4px;
      background-color: white;
      border-radius: 2px;
    }

	.menu {
	  width: 230px;
	  height: calc(100% - 30px);  /* 화면 크기에서 200px를 제외 */
	  background: #123478;
	  position: fixed;
	  left: -350px;
	  top: 40px;  /* 메뉴가 200px 아래로 내리기 */
	  transition: left 0.3s ease;
	  padding: 20px;
	  color: white;
	  z-index: 1;
	}
  
    .menu.active {
      left: 0;
    }

    .submenu {
      max-height: 0;
      overflow: hidden;
      transition: max-height 0.3s ease;
      padding-left: 20px;
    }
  
    .submenu.active {
      max-height: 100px;
    }

    .menu > ul {

      list-style-type: none;
      padding: 0;
      margin: 0;
      
    }

	.menu > ul > li {
	  margin-top: 22px;
	  cursor: pointer;
	  padding: 5px 0;
	  font-size: 22px;  
	}
	
	.submenu li {
	  padding: 5px 0;
	  white-space: nowrap;
	  font-size: 20px; 
	}


    

    /* 추가된 스타일 */
    .main-content {
      background-color: #123478; /* 헤더와 동일한 색 */
      height: calc(100% - 60px); /* 헤더를 제외한 나머지 공간 채우기 */
    }

</style>
</head>

<body>
  <div class="header">
    <div class="hamburger-icon">
      <div></div>
      <div></div>
      <div></div>
    </div>
  </div>

 <div class="menu" id="hamburgerMenu">
  <ul>
    <li>
      Furnace
      <ul class="submenu">
        <li onclick="menuClick('/donghwa/');">Overview</li>
        <li onclick="popupClick('/donghwa/furnace/manualOperationPop', 391, 770);">Manual Operation</li>
        <li onclick="popupClick('/donghwa/furnace/operationPressPop', 430, 427);">Operation Press</li>
        <li onclick="popupClick('/donghwa/furnace/automaticProgramPop3', 636, 486);">Automatic program</li>
        <li onclick="menuClick('/donghwa/furnace/recipe');">Recipe</li>
      </ul>
    </li>
    <li>
      Process values
      <ul class="submenu">
        <li onclick="popupClick('/donghwa/process/temperaturePop', 530, 750);">Temperature</li>
        <li onclick="popupClick('/donghwa/process/pressurePop', 395, 501);">Pressure</li>
        <li onclick="popupClick('/donghwa/process/pressureSwitchesPop', 430, 251);">Pressure switches</li>
        <li onclick="popupClick('/donghwa/process/heaterPop', 468, 262);">Heater</li>
        <li onclick="popupClick('/donghwa/process/pressPop', 1080, 561);">Press</li>
        <li onclick="popupClick('/donghwa/process/powerConsumptionPop', 1042, 495);">Power Consumption</li>
      </ul>
    </li>
    <li>
      Analysis
      <ul class="submenu">
        <li onclick="menuClick('/donghwa/analysis/historyTrend');">Historytrends</li>
        <li>Batchreport</li>
        <li>Alarmhistory</li>
      </ul>
    </li>
    <li>
      Parameter
      <ul class="submenu">
        <li onclick="popupClick('/donghwa/parameter/limitSwitchesPop', 400, 400);">Limit switches</li>
        <li onclick="popupClick('/donghwa/parameter/fastcoolingPop', 400, 400);">Fastcooling</li>
        <li onclick="popupClick('/donghwa/parameter/timerPop', 400, 400);">Timer</li>
        <li onclick="popupClick('/', 400, 400);">Calibrate TC measuring syst</li>
      </ul>
    </li>
    <li>
      Documentation
      <ul class="submenu">
        <li>Functions</li>
        <li>Commissioning</li>
        <li>General operation</li>
        <li>Faults</li>
        <li>Circuit Diagram</li>
        <li>Reference list history trends</li>
      </ul>
    </li>
  </ul>
</div>





  <script>
  function modalClick(location){
      const modal = document.querySelector('.'+location);
      modal.style.display="";
  }
  
  
    const hamburgerIcon = document.querySelector('.hamburger-icon');
    const menu = document.getElementById('hamburgerMenu');

    hamburgerIcon.addEventListener('click', () => {
      menu.classList.toggle('active');
    });

    const menuItems = document.querySelectorAll('.menu > ul > li');

    menuItems.forEach(item => {
      item.addEventListener('click', (event) => {
        menuItems.forEach(otherItem => {
          if (otherItem !== item) {
            const submenu = otherItem.querySelector('.submenu');
            if (submenu) {
              submenu.classList.remove('active');
              submenu.style.maxHeight = null;
            }
          }
        });

        const submenu = item.querySelector('.submenu');
        if (submenu) {
          submenu.classList.toggle('active');
          if (submenu.classList.contains('active')) {
            submenu.style.maxHeight = submenu.scrollHeight + "px";
          } else {
            submenu.style.maxHeight = null;
          }
        }

        event.stopPropagation();
      });
    });

    const historyTrendsItem = document.getElementById('historytrends');
    if (historyTrendsItem) {
      historyTrendsItem.addEventListener('click', () => {
        window.location.href = 'RecipeTrend';
      });
    }

    function menuClick(url) {
      location.href = url;
    }

    function popupClick(url, popupWidth = 600, popupHeight = 600) {
        // 브라우저 창 크기 가져오기
        var browserWidth = window.innerWidth; // 브라우저 가로 크기
        var browserHeight = window.innerHeight; // 브라우저 세로 크기

        // 팝업창 위치 계산
        var popupLeft = (browserWidth - popupWidth) / 2 + window.screenX;
        var popupTop = (browserHeight - popupHeight) / 2 + window.screenY;

        // 팝업창 열기
        var popup = window.open(
            url,
            "popupWindow",
            "width=" + popupWidth + 
            ",height=" + popupHeight + 
            ",top=" + popupTop + 
            ",left=" + popupLeft + 
            ",menubar=no,toolbar=no,scrollbars=no,status=no,location=no,directories=no,resizable=no"
        );

        // 팝업창이 정상적으로 열리지 않았을 경우 경고 메시지
        if (!popup || popup.closed || typeof popup.closed == "undefined") {
            alert("팝업이 차단되었습니다. 팝업 차단 설정을 확인해주세요.");
        }
    }




  </script>
</body>
</html>
