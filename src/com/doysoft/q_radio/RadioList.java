package com.doysoft.q_radio;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.Q_radio.lib.JsonRecRadio;
import com.Q_radio.lib.JsonRadio;

public class RadioList {
	 public static  List<Catething> lists; 

       //   int i;
	// String Lcategory ;
	
	 
	 
      public  static List<Catething> setlist(){
	    	

    	JsonRadio.setData(JsonRadio.initdata());

    	 lists = new ArrayList<Catething>();
    	 
    	
    	int i ;
    	for (i=0;i<JsonRadio.map_arr.size();i++){
    		
    	  String Lcategory =  JsonRadio.map_arr.get(String.valueOf(i)).get("category").toString();

    		if(Detail.type.equals(Lcategory)){
    			String Lname = JsonRadio.map_arr.get(String.valueOf(i)).get("name").toString();
        		
        		String Lregion = JsonRadio.map_arr.get(String.valueOf(i)).get("region").toString();
        		String Lpic =  JsonRadio.map_arr.get(String.valueOf(i)).get("pic").toString();
        		String Llink =  JsonRadio.map_arr.get(String.valueOf(i)).get("link").toString();
        		
        		int resID = Detail.mContext.getResources().getIdentifier(Lpic , "drawable", Detail.mContext.getPackageName());
        		
        		
        		Catething data = new Catething(Lname,Lregion,resID,Llink,Lcategory);
        		lists.add(data);
        		data = null;
   
    		}else {
    			
    		}
    		
    	
    		
    	//	 Conthing bbb  = new Conthing( "女", "喜欢读书",R.drawable.p2 );
    	//	lists.add(bbb);
    	}
    	
    	
	return lists;
	  }
}
