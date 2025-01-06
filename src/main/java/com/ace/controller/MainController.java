package com.ace.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.stack.core.UaException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	public static OpcUaClient client = null;


    //OPC서버 연결시작
    public static void opcStart() throws UaException, InterruptedException, ExecutionException {
		client = OpcUaClient.create("opc.tcp://192.168.1.62:5660");
			
		client.connect().get();
    }
    
    //OPC서버 연결종료
    public static void opcEnd() throws InterruptedException, ExecutionException {
		client.disconnect().get();
    }	
    
    
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "/home.jsp";
	}	
}
