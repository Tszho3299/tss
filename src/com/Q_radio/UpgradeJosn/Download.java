package com.Q_radio.UpgradeJosn;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import com.doysoft.q_radio.RadioUi;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class Download {

	public final static String EXTRA_MESSAGE = "com.example.myapp.MESSAGE";
	HttpClient client;
	public String res;
	public Handler myHandler;

	public void getphp(){
		
	}
	
	private void startUrlCheck() {
		new Thread() {
			public void run() {
				client = new DefaultHttpClient();
				StringBuilder builder = new StringBuilder();
				HttpGet myget = new HttpGet("testAndroid.php");
				// HttpGet myget = new HttpGet("http://www.crazyit.org");
				try {
					HttpResponse response = client.execute(myget);
					HttpEntity entity = response.getEntity();
					BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
					for (String s = reader.readLine(); s != null; s = reader.readLine()) {
						builder.append(s);
					}
					JSONObject jsonObject = new JSONObject(builder.toString());
				
					
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	/* public String getFromAssets(String text){ 
         try { 
              InputStreamReader inputReader = new InputStreamReader(RadioUi.Rcontext.getResources().getAssets().open(text)); 
             BufferedReader bufReader = new BufferedReader(inputReader);
             String line="";
             String Result="";
             while((line = bufReader.readLine()) != null)
                 Result += line;
             return Result;
         } catch (Exception e) { 
             e.printStackTrace(); 
         }
         
		return text;
		
	 }*/
}
