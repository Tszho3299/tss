package com.doysoft.q_radio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.doysoft.app.radio.R;

public class ExpandablelistviewAdapter extends BaseExpandableListAdapter {
	//private List<String> groups;
	//private List<List<String>> childs;
	LayoutInflater mInflater;
	Context context;
	
	ViewChild mViewChild;
	
	private String[] group = { "总台", "国内台", "港澳台",  };

	 private String[][] child = new String [][]{ { "音乐", "资讯","网络" },{"北京","广东","河南","河北","江西","江苏"},{"香港","澳门","台湾","国外"}};
	  

	
	 class ViewChild {
	        ImageView imageView;
	        TextView textView;
	        ListView listView;
	    }

	    
		   public ExpandablelistviewAdapter(Context context) {
		        // TODO Auto-generated constructor stub
		        mInflater = LayoutInflater.from(context);
		        this.context = context;
		    }
	 
		   private void setGridViewListener(final ListView listView) {
		        listView.setOnItemClickListener(new GridView.OnItemClickListener() {
		             @Override
		           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		                // TODO Auto-generated method stub
		            /*    if(view instanceof TextView){
		                    TextView tv = (TextView) view ;
		                    Toast.makeText(context, "position=" + position+"||"+tv.getText(), Toast.LENGTH_SHORT).show();
		                 
		                  //  Log.e("hefeng", "gridView listaner position=" + position + "||text="+tv.getText());
		                }
	              */
		            	 
		           	 
		            	 
		            }
		        });
		    }
		   
	  @Override
	    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
	        // TODO Auto-generated method stub
	        if (convertView == null) {
	            mViewChild = new ViewChild();
	            convertView = mInflater.inflate(R.layout.expandablelistview, null);
	            mViewChild.textView = (TextView) convertView.findViewById(R.id.channel_group_name);
	            mViewChild.imageView = (ImageView) convertView.findViewById(R.id.channel_imageview_orientation);
	            convertView.setTag(mViewChild);
	        } else {
	            mViewChild = (ViewChild) convertView.getTag();
	        }

	        if (isExpanded) {
	            mViewChild.imageView.setImageResource(R.drawable.channel_expandablelistview_top_icon);
	        } else {
	            mViewChild.imageView.setImageResource(R.drawable.channel_expandablelistview_bottom_icon);
	        }
	        mViewChild.textView.setText(group[groupPosition]);
	      //  mViewChild.textView.setText(getGroup(groupPosition).toString());
	        return convertView;
	    }

 

		 @Override
		    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		        // TODO Auto-generated method stub
		        if (convertView == null) {
		        	
		            mViewChild = new ViewChild();
		            convertView = mInflater.inflate(R.layout.expandablelistview_item, null);
		            mViewChild.textView = (TextView) convertView.findViewById(R.id.textViewChild);
		            convertView.setTag(mViewChild);
		        } else {
		        	
		            mViewChild = (ViewChild) convertView.getTag();
		            
		        }
		        
		        mViewChild.textView.setText(child[groupPosition][childPosition]);
		      //  mViewChild.textView.setText(getChild(groupPosition, childPosition).toString());
		        mViewChild.textView.setPadding(50, 0, 0, 0);   
				return convertView;
				
		 }
		 
		
		 
	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return  group.length;
	}


	
	 @Override 
     public int getChildrenCount(int groupPosition) { 
         // TODO Auto-generated method stub 
         return child[groupPosition].length; 
     } 

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return group[groupPosition];
	}


	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return child[groupPosition][childPosition];
	}


	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}


	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}


	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}





	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 /*   public String[] group = { "国内", "国外", "CC" };

	 public String[][] gridViewChild = { { "A", "B", "C" },{"E","F"},{"G","H"}};
	         
	    String[][] child = { { "" }, { "" }, { "" } };

	    
	   public ExpandablelistviewAdapter(Context context) {
	        // TODO Auto-generated constructor stub
	        mInflater = LayoutInflater.from(context);
	        this.context = context;
	    }
	 

	    @Override
	    public Object getChild(int groupPosition, int childPosition) {
	        // TODO Auto-generated method stub
	        return gridViewChild[groupPosition][childPosition];
	    }

	    @Override
	    public long getChildId(int groupPosition, int childPosition) {
	        // TODO Auto-generated method stub
	        return childPosition;
	    }
	   
	 
	    @Override
	    public int getChildrenCount(int groupPosition) {
	        // TODO Auto-generated method stub
	        return child[groupPosition].length;
	    }

	    @Override
	    public Object getGroup(int groupPosition) {
	        // TODO Auto-generated method stub
	        return group[groupPosition];
	    }

	    @Override
	    public int getGroupCount() {
	        // TODO Auto-generated method stub
	        return group.length;
	    }

	    
	    
	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}


	  @Override
	    public boolean isChildSelectable(int groupPosition, int childPosition) {
	        // TODO Auto-generated method stub

		  return true;
	    }
	
	  
	    @Override
	    public boolean hasStableIds() {
	        // TODO Auto-generated method stub
	        return false;
	    }


	
	  @Override
	    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
	        // TODO Auto-generated method stub
	        if (convertView == null) {
	            mViewChild = new ViewChild();
	            convertView = mInflater.inflate(R.layout.expandablelistview, null);
	            mViewChild.textView = (TextView) convertView.findViewById(R.id.channel_group_name);
	            mViewChild.imageView = (ImageView) convertView.findViewById(R.id.channel_imageview_orientation);
	            convertView.setTag(mViewChild);
	        } else {
	            mViewChild = (ViewChild) convertView.getTag();
	        }

	        if (isExpanded) {
	            mViewChild.imageView.setImageResource(R.drawable.channel_expandablelistview_top_icon);
	        } else {
	            mViewChild.imageView.setImageResource(R.drawable.channel_expandablelistview_bottom_icon);
	        }
	        mViewChild.textView.setText(getGroup(groupPosition).toString());
	        return convertView;
	    }

	
	   private ArrayList<HashMap<String, Object>> setGridViewData(String[] data) {
	        ArrayList<HashMap<String, Object>> gridItem = new ArrayList<HashMap<String, Object>>();
	        for (int i = 0; i < data.length; i++) {
	            HashMap<String, Object> hashMap = new HashMap<String, Object>();
	            hashMap.put("gridview_item", data[i]);
	            gridItem.add(hashMap);
	        }
	        return gridItem;
	    }
	
	
	 @Override
	    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
	        // TODO Auto-generated method stub
	        if (convertView == null) {
	        	
	            mViewChild = new ViewChild();
	            convertView = mInflater.inflate(R.layout.expandablelistview_item, null);
	            mViewChild.listView = (ListView) convertView.findViewById(R.id.item_child_gridView);
	            convertView.setTag(mViewChild);
	        } else {
	        	
	            mViewChild = (ViewChild) convertView.getTag();
	            
	        }

	        SimpleAdapter mSimpleAdapter = new SimpleAdapter(context, setGridViewData(gridViewChild[groupPosition]), R.layout.gridview_item,
	                new String[] { "gridview_item" }, new int[] {R.id.gridview_item });
	        mViewChild.listView.setAdapter(mSimpleAdapter);
	        setGridViewListener(mViewChild.listView);
	        mViewChild.listView.setSelector(new ColorDrawable(Color.TRANSPARENT));

//	        hashMap.put(groupPosition + "", mViewChild.gridView);
	        return convertView;
	    }

	    private void setGridViewListener(final ListView listView) {
	        listView.setOnItemClickListener(new GridView.OnItemClickListener() {
	             @Override
	           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	                // TODO Auto-generated method stub
	            /*    if(view instanceof TextView){
	                    TextView tv = (TextView) view ;
	                    Toast.makeText(context, "position=" + position+"||"+tv.getText(), Toast.LENGTH_SHORT).show();
	                 
	                  //  Log.e("hefeng", "gridView listaner position=" + position + "||text="+tv.getText());
	                }
              */
	            	 
	    /*        	 
	            	 
	            }
	        });
	    }
	 
	*/
	   
	 
	/*class ViewHolder {
		TextView textView;
	}*/
	/*ViewChild mViewChild;
	
	 static class ViewChild {
	        ImageView imageView;
	        TextView textView;
	        ListView listView;
	    }
*/
	
	
	

}