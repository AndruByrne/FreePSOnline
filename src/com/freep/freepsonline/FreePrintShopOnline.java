package com.freep.freepsonline;

import android.app.*;
import android.content.*;
import android.net.*;
import android.os.*;
import android.support.v4.view.*;
import android.util.*;
import android.webkit.*;
import android.widget.*;
import java.io.*;
import java.lang.ref.*;
import android.view.*;

public class FreePrintShopOnline extends Activity {

	private ViewPager mPager;
	private static int NUMBER_OF_PAGES = 5;
	private MPagerAdapter mAdapter;
	private static String TAG = "FreePSOnline";
	private static String PATH = Environment.getExternalStorageDirectory().getPath()+"/";
    private static String URL= "file:///android_asset/Internal/";
//	private File mPath = new File(PATH);
//	private File intTrial;
 //   private File sdTrial;
	
 @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    //sdTrial  = new File(PATH+TAG, "trial.txt");
//	    intTrial = new File(this.getContext().getFilesDir().toString(), "inderp.html");
//		if(intTrial.exists()){
			//commenting out these lines b/c FilesDir exists
//			File testDir = new File(PATH+TAG);
//   	 	testDir.mkdir();
//			CopyAssetsToInternal("");
//			CopyAssetsToExternal("");
//			Toast mtoast = Toast.makeText(getContext(), "Assets not present, copying files", Toast.LENGTH_SHORT);
//			mtoast.show();
			
//		}
		setContentView(R.layout.activity_main);
		mAdapter = new MPagerAdapter();
		mPager = (ViewPager) findViewById(R.id.my_pager);
		mPager.setAdapter(mAdapter);
		Toast toast = Toast.makeText(getContext(), R.string.swipeInstructions, Toast.LENGTH_SHORT);
		toast.show();
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
			LayoutInflater inflater = (LayoutInflater) 
					collection.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		//	String targetDir = getContext().getFilesDir().toString();
			switch (position){
			case 0:
				layout = inflater.inflate(R.layout.webview_holder, null);
				//layoutRef = new WeakReference<WebView>((WebView) inflater.inflate(R.layout.webview_holder, null));
				
				WeakReference<WebView> mWebViewRef = new WeakReference<WebView>((WebView)layout.findViewById(R.id.my_webview));
			
				mWebViewRef.get().getSettings().setJavaScriptEnabled(false);
				WebSettings webSettings0 = mWebViewRef.get().getSettings();
				
				webSettings0.setJavaScriptEnabled(false);
		        webSettings0.setBuiltInZoomControls(false);
				mWebViewRef.get().requestFocusFromTouch();
			    
				mWebViewRef.get().setWebViewClient(new WebViewClient()
				{
		    		public boolean shouldOverrideUrlLoading(WebView view, String url){
		    			if (url.startsWith("http:") || url.startsWith("https:")){
		    				return false;
		    			}
		    			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		    			startActivity(intent);
		    			return true;
		    		}

		        });
		        mWebViewRef.get().setWebChromeClient(new WebChromeClient());
					String htmlPage0 = getHtmlFromAsset(getString(R.string.page0));
					if(htmlPage0 != null){
						mWebViewRef.get().loadDataWithBaseURL(URL, htmlPage0, "text/html", "UTF-8", URL);
					} else {Log.e(TAG, "no html string");}
					htmlPage0 = null;	
					
			//		mWebViewRef.get().loadUrl("file://"+targetDir+"/shelter" + getString(R.string.assetLocation) +".html");
		    	((ViewPager)collection).addView((View)layout, 0);
				break;

			case 1:
				
				layout = inflater.inflate(R.layout.webview_holder, null);
				WeakReference<WebView> mWebViewRef1 = new WeakReference<WebView>((WebView)layout.findViewById(R.id.my_webview));
				//mWebView = (WebView)layout.findViewById(R.id.my_webview);
				
				mWebViewRef1.get().getSettings().setJavaScriptEnabled(false);
				WebSettings webSettings1 = mWebViewRef1.get().getSettings();
		        
				webSettings1.setJavaScriptEnabled(false);
		        webSettings1.setBuiltInZoomControls(false);
		        mWebViewRef1.get().requestFocusFromTouch();
		        
		        mWebViewRef1.get().setWebViewClient(new WebViewClient()
		        {
		    		public boolean shouldOverrideUrlLoading(WebView view, String url){
		    			if (url.startsWith("http:") || url.startsWith("https:")){
		    				return false;
		    			}
		    			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		    			startActivity(intent);
		    			return true;
		    		}
		        });

		        mWebViewRef1.get().setWebChromeClient(new WebChromeClient());
					String htmlPage1 = getHtmlFromAsset(getString(R.string.page1));
					if(htmlPage1 != null){
						mWebViewRef1.get().loadDataWithBaseURL(URL, htmlPage1, "text/html", "UTF-8", URL);
					} else {Log.e(TAG, "no html string");}
					htmlPage1 = null;		
					((ViewPager)collection).addView((View)layout, 0);
				
				break;
				
			case 2:
				layout = inflater.inflate(R.layout.webview_holder, null);
				WeakReference<WebView> mWebViewRef2 = new WeakReference<WebView>((WebView)layout.findViewById(R.id.my_webview));
				//mWebView = (WebView)layout.findViewById(R.id.my_webview);
				
				mWebViewRef2.get().getSettings().setJavaScriptEnabled(false);
				WebSettings webSettings2 = mWebViewRef2.get().getSettings();
				
				webSettings2.setJavaScriptEnabled(false);
				webSettings2.setBuiltInZoomControls(true);
				mWebViewRef2.get().requestFocusFromTouch();
				
				mWebViewRef2.get().setWebViewClient(new WebViewClient());
				mWebViewRef2.get().setWebChromeClient(new WebChromeClient());
		        //mWebView0.loadData(readTextFromResource(R.raw.shelter_english), "text/html", "utf-8");
					String htmlPage2 = getHtmlFromAsset(getString(R.string.page2));
					if(htmlPage2 != null){
						mWebViewRef2.get().loadDataWithBaseURL(URL, htmlPage2, "text/html", "UTF-8", URL);
					} else {Log.e(TAG, "no html string");}
					htmlPage2 = null;				
				((ViewPager)collection).addView((View)layout, 0);
					
				break;
				
			case 3:
				layout = inflater.inflate(R.layout.webview_holder, null);
				WeakReference<WebView> mWebViewRef3 = new WeakReference<WebView>((WebView)layout.findViewById(R.id.my_webview));
				//mWebView = (WebView)layout.findViewById(R.id.my_webview);
				
				mWebViewRef3.get().getSettings().setJavaScriptEnabled(false);
				WebSettings webSettings3 = mWebViewRef3.get().getSettings();
				
				webSettings3.setJavaScriptEnabled(false);
				webSettings3.setBuiltInZoomControls(true);
				mWebViewRef3.get().requestFocusFromTouch();
				
				mWebViewRef3.get().setWebViewClient(new WebViewClient());
				mWebViewRef3.get().setWebChromeClient(new WebChromeClient());
				String htmlPage3 = getHtmlFromAsset(getString(R.string.page3));
				if(htmlPage3 != null){
					mWebViewRef3.get().loadDataWithBaseURL(URL, htmlPage3, "text/html", "UTF-8", URL);
				} else {Log.e(TAG, "no html string");}
				htmlPage3 = null;	
				//	mWebViewRef3.get().loadUrl("file://"+targetDir+"/eats_png2.html");
				((ViewPager)collection).addView((View)layout, 0);
				break;
			
			case 4:
				layout = inflater.inflate(R.layout.webview_holder, null);
//				WeakReference<WebView> mWebViewHeaderRef4 = new WeakReference<WebView>((WebView)layout.findViewById(R.id.my_header));
				WeakReference<WebView> mWebViewRef4 = new WeakReference<WebView>((WebView)layout.findViewById(R.id.my_webview));
				//mWebView = (WebView)layout.findViewById(R.id.my_webview);
//				
//				mWebViewHeaderRef4.get().getSettings().setJavaScriptEnabled(false);
//				WebSettings mWebViewHeaderRef4WebSettings = mWebViewHeaderRef4.get().getSettings();
//				mWebViewHeaderRef4WebSettings.setJavaScriptEnabled(false);
//				mWebViewHeaderRef4.get().requestFocusFromTouch();
//				mWebViewHeaderRef4.get().setWebViewClient(new WebViewClient());
//		        mWebViewHeaderRef4.get().setWebChromeClient(new WebChromeClient());
//		        
				
				mWebViewRef4.get().getSettings().setJavaScriptEnabled(false);
				WebSettings webSettings4 = mWebViewRef4.get().getSettings();
		        
				webSettings4.setJavaScriptEnabled(false);
		        webSettings4.setBuiltInZoomControls(true);
		        mWebViewRef4.get().requestFocusFromTouch();
		        
		        mWebViewRef4.get().setWebViewClient(new WebViewClient()
		        {
		    		public boolean shouldOverrideUrlLoading(WebView view, String url){
		    			if (url.startsWith("http:") || url.startsWith("https:")){
		    				return false;
		    			}
		    			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		    			startActivity(intent);
		    			return true;
		    		}
	    		public void onScaleChanged(WebView view, float oldScale, float newScale)
		    		{
	    			}

		        });
		        mWebViewRef4.get().setWebChromeClient(new WebChromeClient());
				String htmlPage4 = getHtmlFromAsset(getString(R.string.page4));
				if(htmlPage4 != null){
					mWebViewRef4.get().loadDataWithBaseURL(URL, htmlPage4, "text/html", "UTF-8", URL);
				} else {Log.e(TAG, "no html string");}
		  //      mWebViewHeaderRef4.get().loadUrl("file:///android_asset/medical_header_spanish.png");
		//		  mWebViewRef4.get().loadUrl("file://"+getContext().getFilesDir().getAbsolutePath()+"/medical" + getString(R.string.assetLocation) +".html");
				htmlPage4 = null;

				((ViewPager)collection).addView((View)layout, 0);
				break;
		
			}
			return layout;
		}

		//taken out b/c it is too slow between gestures, left in b/c it is nifty
//		private String readTextFromResource(int resourceID)
//		{
//			InputStream raw = getResources().openRawResource(resourceID);
//			ByteArrayOutputStream stream  = new ByteArrayOutputStream();
//			int i;
//			try
//			{
//				i=raw.read();
//				while (i != -1)
//				{
//					stream.write(i);
//					i = raw.read();
//					
//				}
//				raw.close();
//			}
//			catch(IOException e)
//			{
//				e.printStackTrace();
//			}
//			return stream.toString();
//		}
//		
		
		
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
//	private void CopyAssetsToInternal(String sourceDir) {
//		try{
//		    String[] pages = null;
//			File     targetDir = getContext().getFilesDir();
//		    try{
//			    pages     = getContext().getAssets().list("Internal"+sourceDir);
//			} catch(Exception e){
//				Log.e(TAG, e.getMessage() +" No Internal Directory");
//			}
//			if (sourceDir != "") { 
//				sourceDir += "/"; 
//				targetDir = new File(targetDir, sourceDir); 
//				targetDir.mkdir(); 
//				Log.d(TAG, "copying assets to subdiectory "+targetDir);
//			}
//			targetDir.setReadable(true, false);
//			if(sourceDir != null){
//				
//				Log.d(TAG, "sourcedir exists");
//				for(String filename : pages) { 
//				
//					Log.d(TAG, "pages exist");
//					System.out.println("File name => "+filename); 
//					if(filename.contains(".") == false){
//						CopyAssetsToInternal("/"+filename);
//					} else {
//
//						Log.d(TAG, "COPYING");
//						File outFile;
//						InputStream in = null; 
//						OutputStream out = null; 
//						if(sourceDir == ""){
//							in = getContext().getAssets().open("Internal/"+filename); 
//						}
//						else {
//							in = getContext().getAssets().open("Internal"+sourceDir+filename);
//						}
//
//						Log.d(TAG, "copying asset: "+filename +" to internal storage, this is removed on uninstall");
//						outFile = new File(targetDir, filename);
//						// if files reside inside the "Internal" directory itself 
//						out = new FileOutputStream(outFile, false);
//						//  out = sdTrial.toString();
//						copyFile(in, out); 
//						in.close(); 
//						in = null; 
//						out.flush(); 
//						out.close(); 
//						out = null;
//					}
//				} 
//			} else {Log.e(TAG, "no sauce");}
//		} catch (IOException e) { 
//			Log.e(TAG, e.getMessage()); 
//		} 
//	}
//	private void CopyAssetsToExternal(String sourceDir) {
//		try{
//		    String[] pages = null;
//			File     targetDir = null;
//		    try{
//			    pages     = getContext().getAssets().list("External"+sourceDir);
//				targetDir = new File(PATH, TAG);
//			//	targetDir.mkdir();
//			} catch(Exception e){
//				Log.e(TAG, e.getMessage() +" No External Directory");
//			}
//			if (sourceDir != "") { 
//				sourceDir += "/"; 
//				targetDir = new File(targetDir, sourceDir); 
//				targetDir.mkdir(); 
//				Log.d(TAG, "copying assets to subdiectory "+targetDir);
//			}
//			targetDir.setReadable(true, false);
//			if(sourceDir != null){
//				
//				Log.d(TAG, "sourcedir exists");
//				for(String filename : pages) { 
//
//					Log.d(TAG, "pages exist");
//					System.out.println("File name => "+filename); 
//					if(filename.contains(".") == false){
//						CopyAssetsToExternal("/"+filename);
//					} else {
//						
//						Log.d(TAG, "COPYING");
//						File outFile;
//						InputStream in = null; 
//						OutputStream out = null; 
//						
//						if(sourceDir == ""){
//							in = getContext().getAssets().open("External/"+filename); 
//						}
//						else {
//							in = getContext().getAssets().open("External"+sourceDir+filename);
//						}
//
//						Log.d(TAG, "copying asset: "+filename +" to external storage, this is removed on uninstall");
//						outFile = new File(targetDir, filename);
//						// if files resides inside the "Files" directory itself 
//				//		Toast mtoast = Toast.makeText(getContext(), outFile.toString(), Toast.LENGTH_LONG);
//				//		mtoast.show();
//						out = new FileOutputStream(outFile, false);
//				//		  out = sdTrial;
//						copyFile(in, out); 
//						in.close(); 
//						in = null; 
//						out.flush(); 
//						out.close(); 
//						out = null;
//						
//					}
//				} 
//			} else {Log.e(TAG, "no sauce");}
//		} catch (IOException e) { 
//			Log.e(TAG, e.getMessage()); 
//		} 
//	}	

	private String getHtmlFromAsset(String htmlAsset) {
	InputStream is;
	StringBuilder builder = new StringBuilder();
        String htmlString = null;
        try {
		is = getAssets().open(htmlAsset);
		if (is != null) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String line;
                while ((line = reader.readLine()) != null) {
				    builder.append(line);
                }
                htmlString = builder.toString();
			}
		} catch (IOException e) {e.printStackTrace();}

        return htmlString;
	}
	
	
	
//	private void copyFile(InputStream in, OutputStream out) 
//	throws IOException { 
//		byte[] buffer = new byte[1024]; 
//		int read; 
//		while((read = in.read(buffer)) != -1){ 
//			out.write(buffer, 0, read); 
//		} 
//	}
//
	public static String getApplicationName(Context context) { 
	    int stringId = context.getApplicationInfo().labelRes; 
		return context.getString(stringId); 
	}
	@Override
	@Deprecated
	public Context getContext() {
		return this;
	}
//	public class mWebViewClient extends WebViewClient{
//		public void onPageFinished(WebView view, String url){
//			//	view.loadUrl("javascript:zoom();");
//		//	view.loadUrl("javascript:zoomer();");
//			Log.e(TAG, "url= " + url.toString());
//		}
//		
//	}
}
