package com.doysoft.q_radio;



import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class RadioReceiver extends BroadcastReceiver{

	public static RadioReceiver receiver;
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		  
		   intent = new Intent(context, MusicUi.class);
	  	    intent.putExtra("text", "nothing"); 
		   context.startActivity(intent);
		   
		   
		  
	}

	
	
	
}
