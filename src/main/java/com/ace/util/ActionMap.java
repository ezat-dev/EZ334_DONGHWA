package com.ace.util;

import java.util.HashMap;
import java.util.Map;

public class ActionMap {

	Map<String, Object> actionMap = new HashMap<String, Object>();
	
	
	public String getReturnAction(String tagName) {
		String result = "";
		
		int index = tagName.lastIndexOf("-");

		String text = tagName.substring(0, index);
		
//		result = actionMap.get(text).toString();

		if(text.contains("alarm")) {
			result = "c";
		}else if(text.contains("yello-left")) {
			result = "b";
		}else if(text.contains("yello-right")) {
			result = "b";
		}else {
			//v는 .val포함
			result = "v";
		}
		
		
		return result;
		
	}	
	
	public String getReturnAction(Map<String, Object> tagInfo) {
		String result = "";
		
		String tagName = tagInfo.get("tagName").toString();
		String tagType = tagInfo.get("tagType").toString();
		
		
		if("analog".equals(tagType)){
			//t-tong 또는 b-tong
			result = "value";			
		}else{
			if(tagName.contains("Ropen")){
				result = "Ropen";
			}else if(tagName.contains("Lopen")) {
				result = "Lopen";
			}else if(tagName.contains("Rclose")) {
				result = "Rclose";	
			}else if(tagName.contains("Lclose")) {
				result = "Lclose";	
			}else if(tagName.contains("-img")) {
				result = "img";	
			}else if(tagName.contains("asd-")) {
				result = "asd";
			}else if(tagName.contains("plc-")) {
				result = "plc"; // v는 .val 포함
			}else {
				result = "v";
			}
		}		
		return result;
		
	}	
	
	
}