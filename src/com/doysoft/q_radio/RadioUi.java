package com.doysoft.q_radio;

import java.lang.reflect.Field;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.astuetz.PagerSlidingTabStrip;
import com.doysoft.app.radio.R;

public class RadioUi extends FragmentActivity implements OnClickListener,
		OnCheckedChangeListener {

	ViewPager viewPager;

	private Rcoradio rcoradio;
	private Cateradio cateradio;
	private Moreradio moreradio;
	private PagerSlidingTabStrip tabs;
	private DisplayMetrics dm;

	private Button btn;
	public static TextView text;

	public static ToggleButton pause;

	// public static Context Rcontext;

	Intent urlint = null;

	private int icon;
	private CharSequence tickerText;
	private long when;

	String rebote;

	public void init() {
		setOverflowShowingAlways();
		dm = getResources().getDisplayMetrics();
		ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
		tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
		pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
		// pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
		btn = (Button) findViewById(R.id.btnui);
		btn.setOnClickListener(this);
		text = (TextView) findViewById(R.id.textname);
		pause = (ToggleButton) findViewById(R.id.tgbtn);
		pause.setOnCheckedChangeListener(this);
		tabs.setViewPager(pager);
		setTabsValue();

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		Intent intent = null;
		intent = new Intent(this, MusicUi.class);
		intent.putExtra("text", "look");
		intent.putExtra("texttitle", text.getText());

		// startActivity(intent);

	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		if (isChecked) {

			urlint = new Intent(this, Radioplayer.class);
			urlint.putExtra("action", "pause");
			// urlint.putExtra("num", "two");

			startService(urlint);

		} else {

			urlint = new Intent(this, Radioplayer.class);
			urlint.putExtra("action", "play");

			startService(urlint);

		}
	}

	@Override
	protected void onDestroy() {

		this.finish();

		super.onDestroy();

	}

	public void stopservice() {

		urlint = new Intent(this, Radioplayer.class);
		urlint.putExtra("action", "stop");
		// urlint.putExtra("num", "two");

		startService(urlint);
	}

	public void setBottomText(String txt) {
		text.setText(txt);

	}

	public void returnbottomText() {
		rebote = this.getIntent().getStringExtra("buttonname");
		text.setText(rebote);

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			AlertDialog.Builder build = new AlertDialog.Builder(this);
			build.setTitle("退出")
					.setMessage("确定要退出吗？")
					.setPositiveButton("确定",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// stopService(Rcoradio.intent);
									// Radioplayer.cancelNotification();

									stopservice();

									// Radioplayer.stop();

									finish();

								}
							})
					.setNeutralButton("后台播放",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									finish();
								}
							})
					.setNegativeButton("取消",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub

								}
							}).show();
			break;

		default:
			break;
		}
		return false;
	}

	/*
	 * private PendingIntent pause_PendingIntent(){
	 * if(Radioplayer.isPlaying==true){
	 * 
	 * //contentView.setImageViewResource(R.id.statusbar_pause,
	 * R.drawable.uamp_ic_pause_white_48dp);
	 * 
	 * Intent urlint = new Intent(this, Radioplayer.class);
	 * urlint.putExtra("action", "play"); // urlint.putExtra("num", "two");
	 * 
	 * startService(urlint);
	 * 
	 * 
	 * }else{ // contentView.setImageViewResource(R.id.statusbar_pause,
	 * R.drawable.uamp_ic_play_arrow_white_48dp); // status_icon =
	 * R.drawable.ic_appwidget_music_pause;
	 * 
	 * Intent urlint = new Intent(this, Radioplayer.class);
	 * urlint.putExtra("action", "pause");
	 * 
	 * 
	 * startService(urlint);
	 * 
	 * }
	 * 
	 * return null;
	 */

	private void setTabsValue() {
		// 设置Tab是自动填充满屏幕的
		tabs.setShouldExpand(true);
		// 设置Tab的分割线是透明的
		tabs.setDividerColor(Color.TRANSPARENT);
		// 设置Tab底部线的高度
		tabs.setUnderlineHeight((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 1, dm));
		// 设置Tab Indicator的高度
		tabs.setIndicatorHeight((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 4, dm));
		// 设置Tab标题文字的大小
		tabs.setTextSize((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_SP, 16, dm));
		// 设置Tab Indicator的颜色
		tabs.setIndicatorColor(Color.parseColor("#BADAF9"));
		// 设置选中Tab文字的颜色 (这是我自定义的一个方法)
		tabs.setSelectedTextColor(Color.parseColor("#BADAF9"));
		// 取消点击Tab时的背景色
		tabs.setTabBackground(0);
	}

	private class MyPagerAdapter extends FragmentPagerAdapter {
		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		private final String[] titles = { "推荐", "分类" };

		public CharSequence getPageTitle(int position) {
			return titles[position];
		}

		@Override
		public int getCount() {
			return titles.length;
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
			case 0:
				if (rcoradio == null) {
					rcoradio = new Rcoradio();
				}
				return rcoradio;
			case 1:
				if (cateradio == null) {
					cateradio = new Cateradio();
				}
				return cateradio;
				/*
				 * case 2: if (moreradio == null) { moreradio = new Moreradio();
				 * } return moreradio;
				 */
			default:
				return null;
			}
		}

	}

	private void setOverflowShowingAlways() {
		try {
			ViewConfiguration config = ViewConfiguration.get(this);
			Field menuKeyField = ViewConfiguration.class
					.getDeclaredField("sHasPermanentMenuKey");
			menuKeyField.setAccessible(true);
			menuKeyField.setBoolean(config, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_radio_ui);
		// rContext = this.getActivity();
		ActionBar actionBar = getActionBar();
		//actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#74B1C5")));
		// actionBar.setDisplayHomeAsUpEnabled(true);
		
		//actionBar.setTitle("网上电台");
		actionBar.setDisplayShowHomeEnabled(false);
		init();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.radio_ui, menu);
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

}
