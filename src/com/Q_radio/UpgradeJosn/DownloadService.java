package com.Q_radio.UpgradeJosn;



import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class DownloadService extends Service {
	static final int Flag_Init = 0; // 初始状态
	static final int Flag_Down = 1; // 下载状态
	static final int Flag_Pause = 2; // 暂停状态
	static final int Flag_Done = 3; // 完成状态

	String url;
	
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
