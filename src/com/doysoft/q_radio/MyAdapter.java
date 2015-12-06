package com.doysoft.q_radio;

import java.util.List;


import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.doysoft.app.radio.R;



public  class MyAdapter extends BaseAdapter {  
     private Context context;  
     public static List<Conthing> lists =null;  
     private LayoutInflater layoutInflater;  
     private LayoutInflater mInflater;
     //   private List<HashMap<String, Object>> dataList;  
     

		
		 
     public MyAdapter(Context context, List<Conthing> lists) {  
    		if(lists !=null){

    		//	lists.clear();
    		  
        	}
    	 this.context = context;  
         this.lists = lists;  
        
         layoutInflater = LayoutInflater.from(this.context);  
       //  queue = Volley.newRequestQueue(context);
 		//imageLoader = new ImageLoader(queue, new BitmapCache());
 	
     
     } 

	 
     @Override
 	public int getCount() {
 		return lists.size();
 	}

 	@Override
 	public Object getItem(int position) {
 		return lists.get(position);
 	}

 	@Override
 	public long getItemId(int position) {
 		return position;
 	}
 	
 	 public void clear() {
         lists.clear();
         notifyDataSetChanged();
     }
 	 
 	 public void remove(int index) {
         lists.remove(index);
         notifyDataSetChanged();
     }
 	 
     //移除对象
     public void remove(Object obj) {
          lists.remove(obj);
         notifyDataSetChanged();
     }
 

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	
		
		ViewHolder holder=null;
		
	      if (convertView == null) {     	
	    	  convertView = LayoutInflater.from(context).inflate(
						R.layout.reclist, null);
	    		holder = new ViewHolder();
	    		holder.image=(ImageView)convertView.findViewById(R.id.imageView1);
	    		holder.tv1 = (TextView) convertView.findViewById(R.id.info);  
	    		holder.tv2 = (TextView) convertView.findViewById(R.id.title);  
	    		holder.tv3 = (TextView) convertView.findViewById(R.id.url);  
	    		
	      
	    		convertView.setTag(holder);  
	    		
	    		
	      }  else {
				holder = (ViewHolder) convertView.getTag();
				resetViewHolder(holder);
			}
	      
	      holder.image.setBackgroundResource(lists.get(position).getPicture());  
  		holder.tv1.setText(lists.get(position).getTitle());  
  		holder.tv2.setText(lists.get(position).getinfo());  
  		holder.tv3.setText(lists.get(position).geturl());  

	      
	      
        return convertView;  

}  
	protected void resetViewHolder(ViewHolder ViewHolder)
	{
		ViewHolder.tv1.setText(null);
		ViewHolder.tv2.setText(null);
		ViewHolder.tv3.setText(null);

		ViewHolder.image.setImageResource(0);
	}
	
	
	
	
 	private  class ViewHolder {
 		ImageView image;
 		TextView tv1;
 		TextView tv2;
 		TextView tv3;
 	} 	
     
 
 }
 