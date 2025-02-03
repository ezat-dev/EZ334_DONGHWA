<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공통 팝업</title>
<style>
    #popupOverlay {
        display: none;
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background: rgba(0, 0, 0, 0.5);
        z-index: 999;
    }

    #commonPopup {
        display: none;
        position: relative;
        
        margin-top:120px;
        top: 80%;
        left: 50%;
        transform: translate(-50%, -50%);
        width: 300px;
        height: 200px;
        background-color: white;
        border-radius: 10px;
        box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.3);
        z-index: 1000;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        position: relative;
    }

    .close-btn {
        position: absolute;
        top: 10px;
        right: 15px;
        font-size: 20px;
        font-weight: bold;
        cursor: pointer;
        color: #666;
        background: none;
        border: none;
    }

    .close-btn:hover {
        color: #ff4d4d;
    }

    .popup-content {
        padding: 20px;
        text-align: center;
    }

    /* ON/OFF 버튼 스타일 */
    .toggle-btn {
        padding: 10px 20px;
        font-size: 16px;
        cursor: pointer;
        border: none;
        border-radius: 5px;
        transition: background-color 0.3s;
        margin-top: 20px; /* 버튼에 여백 추가 */
    }

    .on-btn {
        background-color: #4CAF50;
        color: white;
    }

    .off-btn {
        background-color: #f44336;
        color: white;
    }

    .toggle-btn:hover {
        opacity: 0.8;
    }
</style>
</head>
<body>

<button onclick="openPopup()">팝업 열기</button>

<!-- ON/OFF 버튼 추가 -->
<button id="toggleButton" class="toggle-btn on-btn" onclick="togglePopup()">ON</button>

<div id="popupOverlay" onclick="closePopup()"></div>

<div id="commonPopup">
    <button class="close-btn" onclick="closePopup()">✖</button>
    
    <div class="popup-content">
      
        <h3>공통 팝업</h3>
        <button class="bt_on" type="button">ON</button>
        <button class="bt_off" type="button">OFF</button>
        <p> 팝업은 </p>
        
        <button class="bt_send" type="button" onclick="valueDigitalSend();">전송</button>
    </div>
</div>

<script>
	var setTagDir = "";
	var setTagName = "";
	var setTagValue = 0;

	window.onload = function() {
	    document.getElementById('popupOverlay').style.display = 'none';
	    document.getElementById('commonPopup').style.display = 'none';
	};

	//이벤트
	$(".bt_on").on("click", function(e){
		$(".bt_on").css("background-color","blue");
		$(".bt_off").css("background-color","#F0F0F0");
		setTagValue = 1;
		
	});
	
	$(".bt_off").on("click", function(e){
		$(".bt_off").css("background-color","blue");
		$(".bt_on").css("background-color","#F0F0F0");
		setTagValue = 0;
	});
	
	//함수
	function openPopup() {
	    document.getElementById('popupOverlay').style.display = 'block';
	    document.getElementById('commonPopup').style.display = 'flex';
	}
	
	function closePopup() {
	    document.getElementById('popupOverlay').style.display = 'none';
	    document.getElementById('commonPopup').style.display = 'none';
	}
	
	function togglePopup() {
	    var button = document.getElementById('toggleButton');
	    if (button.classList.contains('on-btn')) {
	        button.classList.remove('on-btn');
	        button.classList.add('off-btn');
	        button.textContent = 'OFF';
	    } else {
	        button.classList.remove('off-btn');
	        button.classList.add('on-btn');
	        button.textContent = 'ON';
	    }
	}

	function digitalSet(tagDir, tagName){
		console.log(tagDir+"// "+tagName);
		setTagDir = tagDir;
		setTagName = tagName;

		openPopup();
	}

	function valueDigitalSend(){
		var sendTagDir = setTagDir;
		var sendTagName = setTagName;
		var sendTagValue = false;
		
		if(setTagValue == 1){
			sendTagValue = true;
		}else{
			sendTagValue = false;
		}
		

		
		
		console.log(sendTagDir);
		console.log(sendTagName);
		console.log(sendTagValue);

		$.ajax({
			url:"/donghwa/common/valueDigitalSet",
			type:"post",
			dataType:"json",
			data:{
				"sendTagDir":sendTagDir,
				"sendTagName":sendTagName,
				"sendTagValue":sendTagValue
			},
			sucess:function(result){
				console.log(result);	
			}
		});

		
	}
	
</script>

</body>
</html>
