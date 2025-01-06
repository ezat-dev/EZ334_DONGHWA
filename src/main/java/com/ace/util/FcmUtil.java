package com.ace.util;

import java.io.FileInputStream;
import java.util.List;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidNotification;
import com.google.firebase.messaging.BatchResponse;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.MulticastMessage;

public class FcmUtil {
	//Bcf 1호기
	public void bcf1_FCM(List<String> tokenList, String title, String content, String send){
		try{

			FileInputStream refreshToken = new FileInputStream("D:/fcm_key/gumgusmart-firebase-adminsdk-w0icg-9ebe951d6d.json");

			
			
			FirebaseOptions options = new FirebaseOptions.Builder()
										.setCredentials(GoogleCredentials.fromStream(refreshToken))
//										.setDatabaseUrl("https://samplepush-fe215.firebaseio.com")
										.build();
			
			if(FirebaseApp.getApps().isEmpty()){
				FirebaseApp.initializeApp(options);
			}
			
			
			
			
			MulticastMessage message = MulticastMessage.builder()
					.setAndroidConfig(AndroidConfig.builder()
					.setTtl(3600 * 1000)
					.setPriority(AndroidConfig.Priority.HIGH)
					
						.setNotification(AndroidNotification.builder()
							.setTag(send+" "+content)
							.setTitle(send+" "+content)
							.setBody(title+" : "+content)
							.setClickAction("")								
							.setSound("default")
							.build())		
						/* default, siren, heartbeat */
					
					.build())
					.putData("title",title)
					.putData("body",content)
					.putData("hogi",send)
					.addAllTokens(tokenList)
					.build();
			
			
			
			BatchResponse response = FirebaseMessaging.getInstance().sendMulticast(message);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	//BCF 2호기
	public void bcf2_FCM(List<String> tokenList, String title, String content, String send){
		try{

			FileInputStream refreshToken = new FileInputStream("D:/fcm_key/gumgusmart-firebase-adminsdk-w0icg-9ebe951d6d.json");

			
			
			FirebaseOptions options = new FirebaseOptions.Builder()
										.setCredentials(GoogleCredentials.fromStream(refreshToken))
//										.setDatabaseUrl("https://samplepush-fe215.firebaseio.com")
										.build();
			
			if(FirebaseApp.getApps().isEmpty()){
				FirebaseApp.initializeApp(options);
			}
			
			
			
			
			MulticastMessage message = MulticastMessage.builder()
					.setAndroidConfig(AndroidConfig.builder()
					.setTtl(3600 * 1000)
					.setPriority(AndroidConfig.Priority.HIGH)
					
						.setNotification(AndroidNotification.builder()
							.setTag(send+" "+content)
							.setTitle(send+" "+content)
							.setBody(title+" : "+content)
							.setClickAction("")								
							.setSound("default")
							.build())		
						/* default, siren, heartbeat */
					
					.build())
					.putData("title",title)
					.putData("body",content)
					.putData("hogi",send)
					.addAllTokens(tokenList)
					.build();
			
			
			
			BatchResponse response = FirebaseMessaging.getInstance().sendMulticast(message);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	//BCF 3호기
	public void bcf3_FCM(List<String> tokenList, String title, String content, String send){
		try{

			FileInputStream refreshToken = new FileInputStream("D:/fcm_key/gumgusmart-firebase-adminsdk-w0icg-9ebe951d6d.json");

			
			
			FirebaseOptions options = new FirebaseOptions.Builder()
										.setCredentials(GoogleCredentials.fromStream(refreshToken))
//										.setDatabaseUrl("https://samplepush-fe215.firebaseio.com")
										.build();
			
			if(FirebaseApp.getApps().isEmpty()){
				FirebaseApp.initializeApp(options);
			}
			
			
			
			
			MulticastMessage message = MulticastMessage.builder()
					.setAndroidConfig(AndroidConfig.builder()
					.setTtl(3600 * 1000)
					.setPriority(AndroidConfig.Priority.HIGH)
					
						.setNotification(AndroidNotification.builder()
							.setTag(send+" "+content)
							.setTitle(send+" "+content)
							.setBody(title+" : "+content)
							.setClickAction("")								
							.setSound("default")
							.build())		
						/* default, siren, heartbeat */
					
					.build())
					.putData("title",title)
					.putData("body",content)
					.putData("hogi",send)
					.addAllTokens(tokenList)
					.build();
			
			
			
			BatchResponse response = FirebaseMessaging.getInstance().sendMulticast(message);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	//BCF 4호기
	public void bcf4_FCM(List<String> tokenList, String title, String content, String send){
		try{

			FileInputStream refreshToken = new FileInputStream("D:/fcm_key/gumgusmart-firebase-adminsdk-w0icg-9ebe951d6d.json");

			
			
			FirebaseOptions options = new FirebaseOptions.Builder()
										.setCredentials(GoogleCredentials.fromStream(refreshToken))
//										.setDatabaseUrl("https://samplepush-fe215.firebaseio.com")
										.build();
			
			if(FirebaseApp.getApps().isEmpty()){
				FirebaseApp.initializeApp(options);
			}
			
			
			
			
			MulticastMessage message = MulticastMessage.builder()
					.setAndroidConfig(AndroidConfig.builder()
					.setTtl(3600 * 1000)
					.setPriority(AndroidConfig.Priority.HIGH)
					
						.setNotification(AndroidNotification.builder()
							.setTag(send+" "+content)
							.setTitle(send+" "+content)
							.setBody(title+" : "+content)
							.setClickAction("")								
							.setSound("default")
							.build())		
						/* default, siren, heartbeat */
					
					.build())
					.putData("title",title)
					.putData("body",content)
					.putData("hogi",send)
					.addAllTokens(tokenList)
					.build();
			
			
			
			BatchResponse response = FirebaseMessaging.getInstance().sendMulticast(message);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	//BCF 5호기
	public void bcf5_FCM(List<String> tokenList, String title, String content, String send){
		try{

			FileInputStream refreshToken = new FileInputStream("D:/fcm_key/gumgusmart-firebase-adminsdk-w0icg-9ebe951d6d.json");

			
			
			FirebaseOptions options = new FirebaseOptions.Builder()
										.setCredentials(GoogleCredentials.fromStream(refreshToken))
//										.setDatabaseUrl("https://samplepush-fe215.firebaseio.com")
										.build();
			
			if(FirebaseApp.getApps().isEmpty()){
				FirebaseApp.initializeApp(options);
			}
			
			
			
			
			MulticastMessage message = MulticastMessage.builder()
					.setAndroidConfig(AndroidConfig.builder()
					.setTtl(3600 * 1000)
					.setPriority(AndroidConfig.Priority.HIGH)
					
						.setNotification(AndroidNotification.builder()
							.setTag(send+" "+content)
							.setTitle(send+" "+content)
							.setBody(title+" : "+content)
							.setClickAction("")								
							.setSound("default")
							.build())		
						/* default, siren, heartbeat */
					
					.build())
					.putData("title",title)
					.putData("body",content)
					.putData("hogi",send)
					.addAllTokens(tokenList)
					.build();
			
			
			
			BatchResponse response = FirebaseMessaging.getInstance().sendMulticast(message);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	//BCF 6호기
	public void bcf6_FCM(List<String> tokenList, String title, String content, String send){
		try{

			FileInputStream refreshToken = new FileInputStream("D:/fcm_key/gumgusmart-firebase-adminsdk-w0icg-9ebe951d6d.json");

			
			
			FirebaseOptions options = new FirebaseOptions.Builder()
										.setCredentials(GoogleCredentials.fromStream(refreshToken))
//										.setDatabaseUrl("https://samplepush-fe215.firebaseio.com")
										.build();
			
			if(FirebaseApp.getApps().isEmpty()){
				FirebaseApp.initializeApp(options);
			}
			
			
			
			
			MulticastMessage message = MulticastMessage.builder()
					.setAndroidConfig(AndroidConfig.builder()
					.setTtl(3600 * 1000)
					.setPriority(AndroidConfig.Priority.HIGH)
					
						.setNotification(AndroidNotification.builder()
							.setTag(send+" "+content)
							.setTitle(send+" "+content)
							.setBody(title+" : "+content)
							.setClickAction("")								
							.setSound("default")
							.build())		
						/* default, siren, heartbeat */
					
					.build())
					.putData("title",title)
					.putData("body",content)
					.putData("hogi",send)
					.addAllTokens(tokenList)
					.build();
			
			
			
			BatchResponse response = FirebaseMessaging.getInstance().sendMulticast(message);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	//BCF 7호기
	public void bcf7_FCM(List<String> tokenList, String title, String content, String send){
		try{

			FileInputStream refreshToken = new FileInputStream("D:/fcm_key/gumgusmart-firebase-adminsdk-w0icg-9ebe951d6d.json");

			
			
			FirebaseOptions options = new FirebaseOptions.Builder()
										.setCredentials(GoogleCredentials.fromStream(refreshToken))
//										.setDatabaseUrl("https://samplepush-fe215.firebaseio.com")
										.build();
			
			if(FirebaseApp.getApps().isEmpty()){
				FirebaseApp.initializeApp(options);
			}
			
			
			
			
			MulticastMessage message = MulticastMessage.builder()
					.setAndroidConfig(AndroidConfig.builder()
					.setTtl(3600 * 1000)
					.setPriority(AndroidConfig.Priority.HIGH)
					
						.setNotification(AndroidNotification.builder()
							.setTag(send+" "+content)
							.setTitle(send+" "+content)
							.setBody(title+" : "+content)
							.setClickAction("")								
							.setSound("default")
							.build())		
						/* default, siren, heartbeat */
					
					.build())
					.putData("title",title)
					.putData("body",content)
					.putData("hogi",send)
					.addAllTokens(tokenList)
					.build();
			
			
			
			BatchResponse response = FirebaseMessaging.getInstance().sendMulticast(message);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	
	//BCF 8호기
	public void bcf8_FCM(List<String> tokenList, String title, String content, String send){
		try{

			FileInputStream refreshToken = new FileInputStream("D:/fcm_key/gumgusmart-firebase-adminsdk-w0icg-9ebe951d6d.json");

			
			
			FirebaseOptions options = new FirebaseOptions.Builder()
										.setCredentials(GoogleCredentials.fromStream(refreshToken))
//										.setDatabaseUrl("https://samplepush-fe215.firebaseio.com")
										.build();
			
			if(FirebaseApp.getApps().isEmpty()){
				FirebaseApp.initializeApp(options);
			}
			
			
			
			
			MulticastMessage message = MulticastMessage.builder()
					.setAndroidConfig(AndroidConfig.builder()
					.setTtl(3600 * 1000)
					.setPriority(AndroidConfig.Priority.HIGH)
					
						.setNotification(AndroidNotification.builder()
							.setTag(send+" "+content)
							.setTitle(send+" "+content)
							.setBody(title+" : "+content)
							.setClickAction("")								
							.setSound("default")
							.build())		
						/* default, siren, heartbeat */
					
					.build())
					.putData("title",title)
					.putData("body",content)
					.putData("hogi",send)
					.addAllTokens(tokenList)
					.build();
			
			
			
			BatchResponse response = FirebaseMessaging.getInstance().sendMulticast(message);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
