package com.example.weatherop;


import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.view.Menu;
import android.widget.TabHost;
import android.app.Activity;
import android.content.Intent;


public class MainActivity extends TabActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
			
		TabHost host = this.getTabHost();
		
		
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
	
}
