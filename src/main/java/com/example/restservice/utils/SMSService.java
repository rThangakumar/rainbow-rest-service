package com.example.restservice.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.example.restservice.model.SMSDetails;

@Component
@PropertySource("classpath:application.properties")
public class SMSService {

	@Value("${smsApi}")
	private String smsApi;
	@Value("${sms.userId}")
	private String userId;
	@Value("${sms.password}")
	private String password;
	
	private Map<String, String> actionMessageMap;
	
	
	
	public void sendSms(SMSDetails smsDetails) {
		post(smsDetails);
	}
	

	public void post(SMSDetails smsDetails) {
	  try {
		  
		  String result = "";
	        HttpPost post = new HttpPost(smsApi);

	        // add request parameters or form parameters
	        List<NameValuePair> urlParameters = new ArrayList();
	        urlParameters.add(new BasicNameValuePair("userid", userId));
	        urlParameters.add(new BasicNameValuePair("password", password));
	        urlParameters.add(new BasicNameValuePair("sender", smsDetails.getSender()));
	        urlParameters.add(new BasicNameValuePair("mobileno", smsDetails.getMobileNo()));
	       // urlParameters.add(new BasicNameValuePair("mobileno", "9000988856"));
	        urlParameters.add(new BasicNameValuePair("msg", smsDetails.getMessage()));

	        post.setEntity(new UrlEncodedFormEntity(urlParameters));
		  
	
	 try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)){
		 if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				   + response.getStatusLine().getStatusCode());
				
			}

            result = EntityUtils.toString(response.getEntity());
            System.out.println("Response "+ response);
        }
		
	  } catch (ClientProtocolException e) {
	
		e.printStackTrace();

	  } catch (Exception e) {
	
		e.printStackTrace();
	  }

	}

}
