<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Recipe</title>
  <!-- furnace/recipeData -->
  <link rel="stylesheet" href="/donghwa/css/furnace/manualOperationPop.css">
   <jsp:include page="../include/pluginpage.jsp"/>
   <jsp:include page="../include/commonPopup.jsp"/>
  <style>
    /* 필요한 스타일을 여기에 추가 */
  </style>
</head>
<body>
  <div class="manual-operation-box"></div>
  <div class="manual-operation-header"></div>
  <div class="manual-operation-main"></div>

  <div class="manual-operation">Manual Operation</div>
  <div class="auto"></div>
  <div class="plc-auto"></div>
  <div class="auto2">Auto</div>
  <div class="manual"></div>
  <div class="plc-manual"></div>
  <div class="manual2">Manual</div>
  <div class="pumping"></div>
  <div class="plc-pumping"></div>
  <div class="pumping-station">Pumping station</div>
  <div class="high-vacuum-pump"></div>
  <div class="plc-high-vacuum"></div>
  <div class="high-vacuum-pump2">High vacuum pump</div>
  <div class="evacuate-fine"></div>
  <div class="plc-evacuate-fine"></div>
  <div class="evacuate-fine-vaccum">Evacuate Fine Vaccum</div>
  <div class="evacuate-high"></div>
  <div class="plc-evacuate-high"></div>
  <div class="evacuate-high-vaccum">Evacuate High Vaccum</div>
  <div class="fur-pre-control"></div>
  <div class="plc-fur-control"></div>
  <div class="furnace-pressure-control">Furnace Pressure Control</div>
  <div class="fur-hit"></div>
  <div class="plc-fur-hit"></div>
  <div class="furnace-heating">Furnace heating</div>
  <div class="n-2"></div>
  <div class="plc-n-2"></div>
  <div class="n-2-inlet">N2-Inlet</div>
  <div class="ar"></div>
  <div class="plc-ar"></div>
  <div class="ar-inlet">Ar Inlet</div>
  <div class="venting"></div>
  <div class="plc-venting"></div>
  <div class="venting2">Venting</div>
  <div class="venting-n-2"></div>
  <div class="plc-venting-n-2"></div>
  <div class="venting-n-22">Venting N2</div>
  <div class="venting-ar"></div>
  <div class="plc-venting-ar"></div>
  <div class="venting-ar2">Venting Ar</div>
  <div class="fastcooling"></div>
  <div class="plc-fastcooling"></div>
  <div class="fastcooling2">Fastcooling</div>
  <div class="manual-leaktest"></div>
  <div class="plc-leak"></div>
  <div class="manual-leaktest2">Manual leaktest</div>
  <div class="open-lid"></div>
  <div class="plc-open-lid"></div>
  <div class="open-lid-clamps">Open Lid Clamps</div>
  <div class="close-lid"></div>
  <div class="plc-close-lid"></div>
  <div class="close-lid-clamps">Close Lid Clamps</div>

<script>

var overviewInterval;

//로드
$(function(){
	overviewListView();
	overviewInterval = setInterval("overviewListView()", 1000);
});

//OPC값 알람 조회
function overviewListView(){
	$.ajax({
		url:"/donghwa/furnace/manualOperation/view",
		type:"post",
		dataType:"json",
		success:function(result){				
			var data = result.multiValues;
			
        for(let key in data){
        	for(let keys in data[key]){
        		var d = data[key];

					if(d[keys].action == "v"){
						v(keys, d[keys].value);
					}else if(d[keys].action == "c"){
						c(keys, d[keys].value);
					}else if(d[keys].action == "b"){
						b(keys, d[keys].value);
					}else if(d[keys].action == "value"){
						value(keys, d[keys].value);
					}

        	}                    	
        }
		}
	});
}

function v(keys, value){
	
	if(value == true){
		$("."+keys).css("background-color","green");
		$("."+keys).css("color","white");
	}else{
		$("."+keys).css("background-color","#E3E3E3");
		$("."+keys).css("color","black");
	}

	$("."+keys).attr("onclick","digitalSet('DONGHWA.FURNACE.MANUAL_OPERATION','"+keys+"')");
	$("."+keys).css("cursor","pointer");
}
/*
function c(keys, value){
//	$("."+keys).text(value);
	
	if(value == true){
		$("."+keys).css("background-color","red");
		$("."+keys).css("color","white");
	}else{
		$("."+keys).css("background-color","green");
		$("."+keys).css("color","black");
	}
	
}
*/

function value(keys, value){
	$("."+keys).text(value);
	$("."+keys).css("text-align","center");
	$("."+keys).css("font-size","12pt");

}

</script>  
</body>
</html>
