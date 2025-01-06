package com.ace.util;

import org.json.simple.JSONArray;

public class PpkUtil {
	/*
	COUNTBLANK : 영역 중에서 공백을 세는 함수
*/	

	//E13 ~ N22는 입력한 값들

	//Min
	public String ppk_min(JSONArray valueArray, String uppTol, String lowTol){
	//IF(OR(G298="0",E187="X",E196>0),"-",MIN(E13:N22))
	//G298 : FIXED(100-COUNTBLANK(E13:N22),0,0)
	//E187 : IF(SUM(B56:B155)>0,"X","O") --> IF(ISTEXT(C56)=TRUE,1,0)	//공백 또는 숫자면 트루
	//C열 : IF(ISBLANK(E13),NA(),E13) = 입력한 값이 공백이면 N/A처리, 아니면 입력한 값

	
	//E196 : SUM(E191:E195) -> errorSearch 메서드에서 값 받아오기

	
		/*순서*/
		String result = "";
		//1. G298 : 값을 입력하는 공간의 공백 수 체크
		int blankCnt = 0;	//공백수 카운트
		int textCnt = 0;	//공백, 숫자값 카운트
		double min_val = 0.0;
		for(int i=0; i<valueArray.size(); i++){
			if("".equals(valueArray.get(i))){
				blankCnt++;
			}else{
				if(i == 0){
					min_val = Double.parseDouble(valueArray.get(i).toString());
				}else{
					if(min_val > Double.parseDouble(valueArray.get(i).toString())){
						min_val = Double.parseDouble(valueArray.get(i).toString());
					}
				}
			}
			
			if("".equals(valueArray.get(i)) || Double.parseDouble(valueArray.get(i).toString()) > 0){
				textCnt = 0;
			}else{
				textCnt += 1;
			}
		}
		
		int error = errorSearch(uppTol, lowTol);
//		System.out.println("100 - blankCnt : "+(100 - blankCnt ));
//		System.out.println("공백 판단 : "+textCnt);
//		System.out.println("문자열 확인 : "+error);
		
		if((100 - blankCnt )== 0 || textCnt > 0 || error >0){
			result = "0";
		}else{
			result = min_val+"";	
		}
		
		return result;
	}
	//Max
	public String ppk_max(JSONArray valueArray, String uppTol, String lowTol){
		String result = "";
		
		//1. G298 : 값을 입력하는 공간의 공백 수 체크
		int blankCnt = 0;	//공백수 카운트
		int textCnt = 0;	//공백, 숫자값 카운트
		double max_val = 0.0;
		for(int i=0; i<valueArray.size(); i++){
			if("".equals(valueArray.get(i))){
				blankCnt++;
			}else{
				if(i == 0){
					max_val = Double.parseDouble(valueArray.get(i).toString());
				}else{
					if(max_val < Double.parseDouble(valueArray.get(i).toString())){
						max_val = Double.parseDouble(valueArray.get(i).toString());
					}
				}
			}
			
			if("".equals(valueArray.get(i)) || Double.parseDouble(valueArray.get(i).toString()) > 0){
				textCnt = 0;
			}else{
				textCnt += 1;
			}
		}
		
		int error = errorSearch(uppTol, lowTol);
		
		if((100 - blankCnt) == 0 || textCnt > 0 || error >0){
			result = "0";
		}else{
			result = max_val+"";	
		}
		
		return result;
	}
	
	//Aver.
	public String ppk_average(JSONArray valueArray, String uppTol, String lowTol){
		String result = "";
		
		//1. G298 : 값을 입력하는 공간의 공백 수 체크
		int blankCnt = 0;	//공백수 카운트
		int textCnt = 0;	//공백, 숫자값 카운트
		double sum = 0.0;
		for(int i=0; i<valueArray.size(); i++){
			if("".equals(valueArray.get(i))){
				blankCnt++;
			}else{
				sum += Double.parseDouble(valueArray.get(i).toString());
			}
			
			if("".equals(valueArray.get(i)) || Double.parseDouble(valueArray.get(i).toString()) > 0){
				textCnt = 0;
			}else{
				textCnt += 1;
			}
		}
		
		int error = errorSearch(uppTol, lowTol);
		
		if((100 - blankCnt) == 0 || textCnt > 0 || error >0){
//			System.out.println("여기인가");
			result = "0";
		}else{
			result = String.format("%.4f",(sum/(100-blankCnt)));	
//			result = (sum/(100-blankCnt))+"";
		}			
		
		return result;
	}
	
	//Dev
	public String ppk_dev(JSONArray valueArray, String uppTol, String lowTol){
		String result = "";
		
		//1. G298 : 값을 입력하는 공간의 공백 수 체크
		int blankCnt = 0;	//공백수 카운트
		int textCnt = 0;	//공백, 숫자값 카운트
		
		for(int i=0; i<valueArray.size(); i++){
			if("".equals(valueArray.get(i))){
				blankCnt++;
			}
			if("".equals(valueArray.get(i)) || Double.parseDouble(valueArray.get(i).toString()) > 0){
				textCnt = 0;
			}else{
				textCnt += 1;
			}
		}			
		
		
		//1. 값들의 평균 구하기
		String average = ppk_average(valueArray, uppTol, lowTol);
//		System.out.println("평균 : "+average);
		
		//2. 각각의 값 - 1.의 평균값 - 편차
		JSONArray stevArray = new JSONArray();
		for(int i=0; i<valueArray.size(); i++){
			if(!"".equals(valueArray.get(i))){
//				System.out.println("[i"+(i+1)+"]"+Double.parseDouble(valueArray.get(i).toString()) +", "+ Double.parseDouble(average));
//				System.out.println("["+(i+1)+"]"+(Double.parseDouble(valueArray.get(i).toString()) - Double.parseDouble(average)));
				stevArray.add(Double.parseDouble(valueArray.get(i).toString()) - Double.parseDouble(average));
			}
		}
		
		//3. 각 2.번의 값들 제곱 구하기
		JSONArray stevPow = new JSONArray();
		for(int j=0; j<stevArray.size(); j++){
//			System.out.println("[j"+(j+1)+"]"+Double.parseDouble(stevArray.get(j).toString()));
			stevPow.add(Math.pow(Double.parseDouble(stevArray.get(j).toString()), 2));
		}
		
		//4. 3.에서 구한 값들의 평균 구하기
		double powSum = 0.0;
		for(int k=0; k<stevPow.size(); k++){
			powSum += Double.parseDouble(stevPow.get(k).toString());
		}
		
		//분산 값
		double powAverage = powSum/(stevPow.size()-1);
		
		//5. 4.에서 구한값의 *1/2 (제곱근)
		double powSqrt = (Math.sqrt(powAverage) * 0.01);
		
		
		int error = errorSearch(uppTol, lowTol);
		
		if((100 - blankCnt) == 0 || textCnt > 0 || error >0){
			result = "0";
		}else{
			result = String.format("%.3f",(Math.round(powSqrt * 1000)/1000.0));	
		}
		
		return result;
	}
	
	//추정불량율
	
	
	
	//Pp
	//IF(OR(E187="X",G298="0",E196>0),"-",IF(OR(Q10="B",Q10="C"),"-",IF(Q10="A",(I10-M10)/(6*M24),"")))
	public String ppk_pp(JSONArray valueArray, String uppTol, String lowTol){
		String result = "";
		
		String tolType = tolType(uppTol, lowTol);
		
		//1. G298 : 값을 입력하는 공간의 공백 수 체크
		int blankCnt = 0;	//공백수 카운트
		int textCnt = 0;	//공백, 숫자값 카운트

		for(int i=0; i<valueArray.size(); i++){
			if("".equals(valueArray.get(i))){
				blankCnt++;
			}
			
			if("".equals(valueArray.get(i)) || Double.parseDouble(valueArray.get(i).toString()) > 0){
				textCnt = 0;
			}else{
				textCnt += 1;
			}
		}
		
		double upp = 0.0;
		double low = 0.0;
		
		if("∞".equals(uppTol) || "".equals(uppTol)){
			upp = 0.0;
		}else{
			upp = Double.parseDouble(uppTol);	//I10
		}
		
		if("".equals(lowTol)){
			low = 0.0;
		}else{
			low = Double.parseDouble(lowTol);	//M10	
		}
		
		String dev = ppk_dev(valueArray, uppTol, lowTol);
		
		int error = errorSearch(uppTol, lowTol);
		//IF(Q10="A",(I10-M10)/(6*M24),""))
		if((100 - blankCnt) == 0 || textCnt > 0 || error >0){
			result = "0";
		}else if("B".equals(tolType) || "C".equals(tolType)){
			result = "0";
		}else if("A".equals(tolType)){
			//(I10-M10)/(6*M24)
			result = String.format("%.2f",((upp-low)/(6*Double.parseDouble(dev))));
		}else{
			result = "0";
		}
		
		return result;
	}
	
	//Ppu
	//IF(Q10="C","-",(I10-E161)/(3*E162))
	public String ppk_ppu(JSONArray valueArray, String uppTol, String lowTol){
		String result = "";
		String tolType = tolType(uppTol, lowTol);
		
		//E161
		String average = ppk_average(valueArray, uppTol, lowTol);

		//E162
		
		String dev = ppk_dev(valueArray, uppTol, lowTol);
		
		double upp = 0.0;
		if(!"".equals(uppTol) && !"∞".equals(uppTol)){
			upp = Double.parseDouble(uppTol);
		}
		
		if("C".equals(tolType)){
			result = "0";
		}else{
			result = String.format("%.2f",(upp - Double.parseDouble(average))/
					(3*Double.parseDouble(dev)));
		}
		
		return result;
		
	}
	
	
	//Ppl
	//IF(Q10="B","-",(E161-M10)/(3*E162))
	public String ppk_ppl(JSONArray valueArray, String uppTol, String lowTol){
		String result = "";
		String tolType = tolType(uppTol, lowTol);
		
		//E161
		String average = ppk_average(valueArray, uppTol, lowTol);

		//E162
		String dev = ppk_dev(valueArray, uppTol, lowTol);
		
		double low = 0.0;
		if(!"".equals(lowTol)){
			low = Double.parseDouble(lowTol);
		}
		
		if("B".equals(tolType)){
			result = "0";
		}else{
			result = String.format("%.2f",(Double.parseDouble(average) - low)/
					(3*Double.parseDouble(dev)));
		}
		
		return result;
		
	}		
	
	//Ppk
	//IF(OR(E187="X",G298="0",E196>0),"-",IF(Q10="C",(E161-M10)/(3*E162),IF(Q10="B",(I10-E161)/(3*E162),IF(AND(Q10="A",(I10+M10)/2<E161),(I10-E161)/(3*E162),(E161-M10)/(3*E162)))))
	public String ppk_ppk(JSONArray valueArray, String uppTol, String lowTol){
		String result = "";
		
		String tolType = tolType(uppTol, lowTol);
		
		int blankCnt = 0;	//공백수 카운트
		int textCnt = 0;	//공백, 숫자값 카운트

		for(int i=0; i<valueArray.size(); i++){
			if("".equals(valueArray.get(i))){
				blankCnt++;
			}
			
			if("".equals(valueArray.get(i)) || Double.parseDouble(valueArray.get(i).toString()) > 0){
				textCnt = 0;
			}else{
				textCnt += 1;
			}
		}
		
		//E161 : 평균
		String average = ppk_average(valueArray, uppTol, lowTol);
		
		//E162 : dev
		String dev = ppk_dev(valueArray, uppTol, lowTol);

		
		
		//I10 : 규격상한 uppTol			
		double upp = 0.0;
		if(!"".equals(uppTol) && !"∞".equals(uppTol)){
			upp = Double.parseDouble(uppTol);
		}
		
		
		//M10 : 규격하한 lowTol
		double low = 0.0;
		if(!"".equals(lowTol)){
			low = Double.parseDouble(lowTol);
		}
		
		int error = errorSearch(uppTol, lowTol);
		
		if((100 - blankCnt) == 0 || textCnt > 0 || error >0){
//			System.out.println("여기인가");
			result = "0";
		}else{
			if("C".equals(tolType)){
				//(E161-M10)/(3*E162)
				result = String.format("%.2f",(Double.parseDouble(average) - low/
						(3*Double.parseDouble(dev))));
			}else if("B".equals(tolType)){
				//(I10-E161)/(3*E162)
				result = String.format("%.2f",(upp - Double.parseDouble(average)/
						(3 * Double.parseDouble(dev))));
			}else if("A".equals(tolType) && 
					((upp+low)/2)
						> (Double.parseDouble(dev)) ){
				//AND(Q10="A",(I10+M10)/2<E161) : if조건
				//(I10-E161)/(3*E162),
				result = String.format("%.2f", ((upp-(Double.parseDouble(average)))
						/ (3 * (Double.parseDouble(dev))))
						);
			}else{
				//(E161-M10)/(3*E162)
				result = String.format("%.2f", ((Double.parseDouble(average) - (low))
						/(3 * (Double.parseDouble(dev))))
						);
			}
		}	
		
		return result;
	}
	
	//Up ppm : (1-NORMDIST(I10,J24,M24,TRUE))*1000000
	//I10 : 규격상한(분포를 구하려는 값) x, J24 : 평균값(분포의 산술평균) m, M24 : dev(분포의 표준편차) d, 
	//TRUE(TRUE:분포함수 반환, FALSE:확률 질량함수를 반환)
	//찾은 공식 -> NORMDIST : 1/Math.sqrt(2*Math.PI*d*d)*Math.exp(-((x-m)*(x-m))/2*d*d);
	public String upPPm(JSONArray valueArray, String uppTol, String lowTol){
		String result = "";
		double upp = 0.0;
		if("".equals(uppTol) || "∞".equals(uppTol)){
			upp = 0.0;
		}else{
			upp = Double.parseDouble(uppTol);				
		}
		
		//J24
		String average = ppk_average(valueArray, uppTol, lowTol);
		double m = 0.0;
		if(!"".equals(average)){
			m = Double.parseDouble(average);
		}
		//M24
		String dev = ppk_dev(valueArray, uppTol, lowTol);
		double d = 0.0;
		if(!"".equals(dev)){
			d = Double.parseDouble(dev);
		}
		
//		System.out.println(upp+", "+m+", "+d);
		
//		result = ((1-1/Math.sqrt(2*Math.PI)*Math.exp(-(upp*upp)/2))*1000000)+"";
		result = (Math.round(( (1/(d*Math.sqrt(2*Math.PI))) * Math.exp((-Math.pow(upp-m,2)) /(2*Math.pow(d,2))) ))) +"";
		
		
		return result;
	}
	

	
	//lowPPm
	//NORMDIST(M10,J24,M24,TRUE)*1000000
	public String lowPPm(JSONArray valueArray, String uppTol, String lowTol){
		String result = "";
		double low = 0.0;
		if("".equals(lowTol) || "∞".equals(lowTol)){
			low = 0.0;
		}else{
			low = Double.parseDouble(lowTol);				
		}
		
		//J24
		String average = ppk_average(valueArray, uppTol, lowTol);
		double m = 0.0;
		if(!"".equals(average)){
			m = Double.parseDouble(average);
		}
		//M24
		String dev = ppk_dev(valueArray, uppTol, lowTol);
		double d = 0.0;
		if(!"".equals(dev)){
			d = Double.parseDouble(dev);
		}
		
//		System.out.println(low+", "+m+", "+d);
		
//		result = (1/Math.sqrt(2*Math.PI*d*d)*Math.exp(-((low-m)*(low-m))/2*d*d))*1000000+"";
//		result = ((1/Math.sqrt(2*Math.PI)*Math.exp(-(low*low)/2))*1000000)+"";
		result = (Math.round(( (1/(d*Math.sqrt(2*Math.PI))) * Math.exp((-Math.pow(low-m,2)) /(2*Math.pow(d,2))) ))) +"";
		
		return result;
	}		
	
	
	
	//totalPPm
	//+IF(Q10="A",E168+E167,IF(Q10="B",E167,IF(Q10="C",E168,"-")))
	//Q10 : String tolType(String uppTol, String lowTol)
	public String totalPPm(JSONArray valueArray, String uppTol, String lowTol){
		String tolType = tolType(uppTol, lowTol);
		String upPPm = upPPm(valueArray, uppTol, lowTol);
		String lowPPm = lowPPm(valueArray, uppTol, lowTol);
		
		String result = "";
		
		
//		System.out.println(upPPm+", "+lowPPm);
		
		if("A".equals(tolType)){
			result = Integer.parseInt(upPPm)+Integer.parseInt(lowPPm)+"ppm";
		}else if("B".equals(tolType)){
			result = Integer.parseInt(upPPm)+"ppm";
		}else if("C".equals(tolType)){
			result = Integer.parseInt(lowPPm)+"ppm";
		}else{
			result = "-";
		}
		
		return result;
	}
	
	
	//errorSearch
	public int errorSearch(String uppTol, String lowTol){

		String tolType = tolType(uppTol,lowTol);
//		System.out.println("톨 타입 : "+tolType);
		int result = 0;
		int e191 = 0; int e192 = 0; int e193 = 0; int e194 = 0;
		//E191 : IF(AND(Q10="A",I10>M10),0,IF(AND(Q10="B",OR(M10=0,M10="")),0,IF(AND(Q10="C",OR(I10=0,I10="∞",I10="")),0,1)))
		//E192 : IF(OR(Q10="A",Q10="B",Q10="C"),0,1)
		//E193 : IF(OR(ISNUMBER(I10),AND(I10="∞",Q10="C"),AND(Q10="C",I10=""),AND(Q10="C",I10=0)),0,1)
		//E194 : IF(OR(ISNUMBER(M10),AND(Q10="B",M10=0),AND(Q10="B",M10="")),0,1)
		double upp = 0.0;
		double low = 0.0;
		boolean isInfinity = false;
		if("∞".equals(uppTol) || "".equals(uppTol)){
			isInfinity = true;
			upp = 0.0;
		}else{
			isInfinity = false;
			upp = Double.parseDouble(uppTol);	//I10
		}
		
		if("".equals(lowTol)){
			low = 0.0;
		}else{
			low = Double.parseDouble(lowTol);	//M10	
		}
		
		
		
		//E191 : IF(AND(Q10="A",I10>M10),0,IF(AND(Q10="B",OR(M10=0,M10="")),0,IF(AND(Q10="C",OR(I10=0,I10="∞",I10="")),0,1)))		
		if("A".equals(tolType) && upp > low){
			e191 = 0;
		}else if("B".equals(tolType) && (low == 0)){
			e191 = 0;
		}else if("C".equals(tolType) && (upp == 0 || isInfinity)){
			e191 = 0;
		}else{
			e191 = 1;
		}
		
		//E192 : IF(OR(Q10="A",Q10="B",Q10="C"),0,1)
		if("A".equals(tolType) || "B".equals(tolType) || "C".equals(tolType)){
			e192 = 0;
		}else{
			e192 = 1;
		}
		
		//E193 : IF(OR(ISNUMBER(I10),AND(I10="∞",Q10="C"),AND(Q10="C",I10=""),AND(Q10="C",I10=0)),0,1)
		if(upp > 0.0 || (isInfinity && "C".equals(tolType)) || ("C".equals(tolType) && "".equals(uppTol)) || ("C".equals(tolType) && upp == 0.0)){
			e193 = 0;
		}else{
			e193 = 1;
		}
		
		
		//E194 : IF(OR(ISNUMBER(M10),AND(Q10="B",M10=0),AND(Q10="B",M10="")),0,1)
		if(low > 0.0 ||("B".equals(tolType) && low == 0.0) || ("B".equals(tolType) && "".equals(lowTol))){
			e194 = 0;
		}else{
			e194 = 1;
		}
		
//		System.out.println("e191 : "+e191+", e192 : "+e192+", e193 : "+e193+", e194 : "+e194);
		
		result = (e191+e192+e193+e194);
		
		return result;
	}
	
	
	//tolType
	public String tolType(String uppTol, String lowTol){
		//I10 : 규격상한, M10 : 규격하한
		//Q10 : IF(AND(ISBLANK(I10),ISBLANK(M10)),"D",IF(ISBLANK(I10),"C",IF(ISBLANK(M10),"B","A")))
		//규격상한, 규격하한 둘다 공백이면 D, 상한만 공백이면 C, 하한만 공백이면 B, 둘다 아니면 A			
		String result = "";
		if("".equals(uppTol) && "".equals(lowTol)){
			result = "D";
		}else if("".equals(uppTol)){
			result = "C";
		}else if("".equals(lowTol)){
			result = "B";
		}else{
			result = "A";
		}
	
		return result;
		
	}
	
	//tolType2
	//IF(Q10="A","Both",IF(Q10="B","Under",IF(Q10="C","Over","#N/A")))
	public String tolType2(String uppTol, String lowTol){
		String result = "";
		
		String tolType = tolType(uppTol, lowTol);
		
		if("A".equals(tolType)){
			result = "Both";
		}else if("B".equals(tolType)){
			result = "Under";
		}else if("C".equals(tolType)){
			result = "Over";
		}else{
			result = "N/A";
		}
		
		return result;
		
	}

}
