package com.example.weatherop;


import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.view.Menu;

import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;					//url 사용

import android.util.Log;
import org.xmlpull.v1.XmlPullParser;	//XML파서 사용
import org.xmlpull.v1.XmlPullParserFactory;
import java.util.ArrayList;				//arraylist 사용

import java.lang.Object;


public class MainActivity extends Activity {
	
	TextView w_info;	
	TextView w_advice;
	
	
	weatherData currentInfo;
	
	
	URL url;
	XmlPullParserFactory f_test;
	XmlPullParser p_test;
	int p_index;
	InputStream i_stream;
	
	int isData = 0;
	int isBody = 0;

	public void Init()
	{
	//	w_info = (TextView)findViewById(R.id.Weather_info);
	//	w_advice = (TextView)findViewById(R.id.Advice_info);
	//	Log.i("InfoTag", "씨발 뭐 아무것도 안되냐??");
		
		try
		{
				
			f_test = XmlPullParserFactory.newInstance();
			p_test = f_test.newPullParser();	
			
			Thread t = new Thread(new Runnable() {
				
				@Override
				public void run() {
					Log.i("InfoTag", "쓰레드 시작부분");
					try
					{
						url = new URL("http://api.openweathermap.org/data/2.5/weather?q=Seoul&mode=xml");	
						i_stream = url.openStream();		//이걸 처리해줘야한다. 스레드써야한다는데
					//	Log.i("InfoTag", url);		
						
						p_test.setInput( i_stream, "euc-kr");
						
						p_index = p_test.getEventType();
						int repeat = 0;
						Log.i("InfoTag", "repeat="+repeat);
						while(repeat < 1)
						{
							Log.i("InfoTag", "반복문 시작부분");
							switch(p_index)
							{
								case XmlPullParser.START_DOCUMENT:
									//Log.e("parsetRest", "test");
									break;
								
								case XmlPullParser.START_TAG:
									String tag = p_test.getName();
									if( tag.equals("body") )
									{
										isBody = 1;
										Log.i("InfoTag", "인바디");
									}
									if( tag.equals("city") )
									{
										String city = p_test.getAttributeValue(0);
										currentInfo.setCity(city);
										Log.i("InfoTag", "city="+currentInfo.w_City);
									}
									if( tag.equals("data") )
									{
										isData = 1;
										Log.i("InfoTag", "인데이터");
									}
									if( isData*isBody !=0 )
									{
										if( tag.equals("tmEF") )
										{
											String time = p_test.getAttributeValue(0);
											currentInfo.setTime(time);
											Log.i("InfoTag", "time="+currentInfo.w_Time);
										}
										else if( tag.equals("wf") )
										{
											String cond = p_test.getAttributeValue(0);
											currentInfo.setCond(cond);	
											Log.i("InfoTag", "cond="+currentInfo.w_Cond);
										}
										else if( tag.equals("tmn") )
										{
											String min = p_test.getAttributeValue(0);
											currentInfo.setMin(min);
											Log.i("InfoTag", "min="+currentInfo.w_Min);
										}
										else if( tag.equals("tmx") )
										{
											String max = p_test.getAttributeValue(0);
											currentInfo.setMax(max);
											Log.i("InfoTag", "max="+currentInfo.w_Max);
										}
									}

									break;
									
								case XmlPullParser.TEXT:
									break;
									
								case XmlPullParser.END_TAG:
									tag = p_test.getName();
									
								//	if( tag.equals("body") )
								//	{
								//		isBody = 0;
								//		Log.i("InfoTag", "밖바디");
								//	}
									if( tag.equals("data") )
									{
										isData = 0;
										Log.i("InfoTag", "데이터밖");
										repeat++;
										Log.i("InfoTag", "repeat 증가");
									}
									break;
									//String region = p_test.getText();
									
									//Log.e("region", region);
									//Toast.makeText(this, "이건뭐냐", Toast.LENGTH_SHORT).show());
									
								
							}
							Log.i("InfoTag", "반복문 끝");
							p_index = p_test.next();
						}
			
					}catch(Exception e){ }
					Log.i("InfoTag", "쓰레드 끝부분");
					
					
					
				}
			});
			
			
			t.start();
			
			
		}catch(Exception e){ Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show(); }
	
//		String str2 = "도시:"+currentInfo.getCity()+"\n"+"시간"+currentInfo.getTime()+"\n";
	
//		String str1 = "시발 제발 좀 되세요 네??";
//		w_advice.setText(str1);
//		Log.i("InfoTag", str1);
//		w_info.setText(str1);

		
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

		Init();		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
	
}
