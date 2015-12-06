package com.doysoft.q_radio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.doysoft.app.radio.R;

public class Getdataphp extends Activity implements OnClickListener {

	HttpClient client;
	public String res;
	public Handler myHandler;
	Button btn;
	Button btnwr;
	String data;
	
	// public final static String EXTRA_MESSAGE = "com.example.myapp.MESSAGE";
    TextView txt;
	private void startUrlCheck() {
		new Thread() {
			public void run() {
				client = new DefaultHttpClient();
				StringBuilder builder = new StringBuilder();
				HttpGet myget = new HttpGet("http://192.168.0.101/json.php");
				// HttpGet myget = new HttpGet("http://www.crazyit.org");
				try {
					HttpResponse response = client.execute(myget);
					HttpEntity entity = response.getEntity();
					BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
					for (String s = reader.readLine(); s != null; s = reader.readLine()) {
						builder.append(s);
					}
					JSONObject jsonObject = new JSONObject(builder.toString());
					
					//byte[] data = new byte[jsonObject.available()];
					
					
				//	txt.setText(builder);
					data=jsonObject.toString();
				       txt.setText(jsonObject.toString());
	
					/*String re_password = jsonObject.getString("radio_link");
					res = re_password;
					Message msg = new Message();
					msg.what = 0x123;
					msg.obj = res;
					myHandler.sendMessage(msg);
*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	public void write() throws IOException{
		
		/*File tofile=new File("text.json");

		FileWriter fw=new FileWriter(tofile);
		BufferedWriter buffw=new BufferedWriter(fw);
		PrintWriter pw=new PrintWriter(buffw);

		String str=data;
		pw.println(str);

		pw.close();
		buffw.close();
		fw.close();
		*/
		File file = new File("text.json");
		
		
	}
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_getdataphp);

		btn = (Button) findViewById(R.id.button12);
		 btn.setOnClickListener(this) ;
       txt =(TextView)findViewById(R.id.txt);
       btnwr= (Button)findViewById(R.id.button13);
       btnwr.setOnClickListener(this);
       
       
		myHandler = new Handler() {
			public void handleMessage(Message msg) {
				if (msg.what == 0x123) {
					Toast toast = Toast.makeText(Getdataphp.this, msg.obj.toString(), Toast.LENGTH_SHORT);
					toast.show();
				}
			}
		};
	}

	public void sendMessage(View view) {
		startUrlCheck();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.getdataphp, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {  
        case R.id.button12:  
           
        	startUrlCheck();
        	
            break;  
        case R.id.button13:  
          
        	try {
				write();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            break;  
        default:  
            break;  
        }     

	}
}
