package com.freep.freeprintshoponline;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class FreePrintShopOnline extends Activity {

	private ViewPager mPager;
	private static int NUMBER_OF_PAGES = 4;
	private MPagerAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mAdapter = new MPagerAdapter();
		mPager = (ViewPager) findViewById(R.id.my_pager);
		mPager.setAdapter(mAdapter);
		
		}
	
	private class MPagerAdapter extends PagerAdapter
	{
		
		@Override
		public int getCount()
		{
			return NUMBER_OF_PAGES;
		}
		
		@Override
		public boolean isViewFromObject(View view, Object object) 
		{
			return (view==((View)object));
		}

		@Override
		public void destroyItem(ViewGroup collection, int position, Object view)
		{
			collection.removeView((View) view);
		}
		
		@Override
		public Object instantiateItem(ViewGroup collection, int position)
		{
			
			View layout = null;
			WebView mWebView = null;
			LayoutInflater inflater = (LayoutInflater) 
					collection.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			switch (position){
			case 0:
				layout = inflater.inflate(R.layout.webview_holder, null);
				mWebView = (WebView)layout.findViewById(R.id.my_webview);
				
				//fuck javascript
				mWebView.getSettings().setJavaScriptEnabled(false);
				WebSettings webSettings0 = mWebView.getSettings();
		        //no, I mean fuck it
				webSettings0.setJavaScriptEnabled(false);
		        //Zoom, you're cool
				webSettings0.setBuiltInZoomControls(true);
		        mWebView.requestFocusFromTouch();
		        
		        mWebView.setWebViewClient(new WebViewClient());
		        mWebView.setWebChromeClient(new WebChromeClient());
		        
		        mWebView.loadUrl("file:///android_asset/shelter" + getString(R.string.assetLocation) +".html");
				((ViewPager)collection).addView((View)layout, 0);
				break;

			case 1:
				layout = inflater.inflate(R.layout.webview_holder, null);
				mWebView = (WebView)layout.findViewById(R.id.my_webview);
				
				mWebView.getSettings().setJavaScriptEnabled(false);
				WebSettings webSettings1 = mWebView.getSettings();
		        
				webSettings1.setJavaScriptEnabled(false);
		        webSettings1.setBuiltInZoomControls(true);
		        mWebView.requestFocusFromTouch();
		        
		        mWebView.setWebViewClient(new WebViewClient());
		        mWebView.setWebChromeClient(new WebChromeClient());
				
		        mWebView.loadUrl("file:///android_asset/pantry" + getString(R.string.assetLocation) +".html");
				((ViewPager)collection).addView((View)layout, 0);
				break;
				
			case 2:
				layout = inflater.inflate(R.layout.webview_holder, null);
				mWebView = (WebView)layout.findViewById(R.id.my_webview);
				
				mWebView.getSettings().setJavaScriptEnabled(false);
				WebSettings webSettings2 = mWebView.getSettings();
				
				webSettings2.setJavaScriptEnabled(false);
				webSettings2.setBuiltInZoomControls(true);
				mWebView.requestFocusFromTouch();
				
				mWebView.setWebViewClient(new WebViewClient());
				mWebView.setWebChromeClient(new WebChromeClient());
		        //mWebView0.loadData(readTextFromResource(R.raw.shelter_english), "text/html", "utf-8");
				mWebView.loadUrl("file:///android_asset/eats_png1.html");
				
				((ViewPager)collection).addView((View)layout, 0);
				break;
				
			case 3:
				layout = inflater.inflate(R.layout.webview_holder, null);
				mWebView = (WebView)layout.findViewById(R.id.my_webview);
				
				mWebView.getSettings().setJavaScriptEnabled(false);
				WebSettings webSettings3 = mWebView.getSettings();
				
				webSettings3.setJavaScriptEnabled(false);
				webSettings3.setBuiltInZoomControls(true);
				mWebView.requestFocusFromTouch();
				
				mWebView.setWebViewClient(new WebViewClient());
				mWebView.setWebChromeClient(new WebChromeClient());
				mWebView.loadUrl("file:///android_asset/eats_png2.html");
				((ViewPager)collection).addView((View)layout, 0);
				break;
			}
			return layout;
		}
		
		//taken out b/c it is too slow between gestures, left in b/c it is nifty
		/*private String readTextFromResource(int resourceID)
		{
			InputStream raw = getResources().openRawResource(resourceID);
			ByteArrayOutputStream stream  = new ByteArrayOutputStream();
			int i;
			try
			{
				i=raw.read();
				while (i != -1)
				{
					stream.write(i);
					i = raw.read();
					
				}
				raw.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			return stream.toString();
		}
*/		
		@Override
        public void finishUpdate(ViewGroup arg0) {}
       

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {}

        @Override
        public Parcelable saveState() {
                return null;
        }

        @Override
        public void startUpdate(ViewGroup arg0) {}

	}

	
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.activity_main, menu);
		//MenuItemCompat.setShowAsAction(menu.findItem(R.menu.options), 1);
		return true;
	}
}
