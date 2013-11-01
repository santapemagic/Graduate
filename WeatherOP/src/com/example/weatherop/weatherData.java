package com.example.weatherop;

public class weatherData 
{
	
	String w_City;	//장소
	String w_Day;	//날짜
	String w_Time;	//시간
	
	int w_Max;	//최고온도
	int w_Min;	//최저온도
	String w_Cond;	//날씨
	
	public void setCity( String city ) 
	{
		w_City = city;
	}
	
	public String getCity() 
	{
		return w_City;
	}
	
	public void setDay( String day )
	{
		w_Day = day;
	}
	public String getDay() 
	{
		return w_Day;
	}
	
	public void setTime( String time ) 
	{
		w_Time = time;
	}
	public String getTime() 
	{
		return w_Time;
	}
	
	public void setMax( String max ) 
	{
		w_Max = Integer.parseInt(max);
	}
	public int getMax() 
	{
		return w_Max;
	}
	
	public void setMin( String min )
	{
		w_Min = Integer.parseInt(min);
	}
	public int getMin()
	{
		return w_Min;
	}
	public void setCond( String cond ) 
	{
		w_Cond = cond;
	}
	public String getCond() 
	{
		return w_Cond;
	}


	

};
