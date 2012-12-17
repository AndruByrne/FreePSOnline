package com.freep.freeprintshoponline;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		WebView wv = (WebView)findViewById(R.id.my_webview);
		File file = new File(Environment.getExternalStorageDirectory() + "/Download/shelter english.html");
		wv.setWebViewClient(new WebViewClient() 
		
		{
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url)
			{
				view.loadUrl(url);
				return true;
			}
		});
		
		wv.loadUrl("file:///" + file.getAbsolutePath());
	}


}
