package com.example.weatherop;

public class weatherData 
{
	
	String w_City;	//���
	String w_Day;	//��¥
	String w_Time;	//�ð�
	
	int w_Max;	//�ְ�µ�
	int w_Min;	//�����µ�
	String w_Cond;	//����
	
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
