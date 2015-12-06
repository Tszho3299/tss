package com.Q_radio.UpgradeJosn;

public interface DownloadListener {

	void onStart(int fileByteSize);
	
	void onFail();
	
	void onCancel();
}
