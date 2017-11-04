package wowMeetsFPS;

import java.io.Serializable;

public class Data<T> implements Serializable{

	private T info;
	
	//Creates a wrapper class holding a generic type of information
	public Data(T storedInformation)
	{
		info = storedInformation;
	}
	
	//Gets the information from the wrapper class
	public T getInfo()
	{
		return info;
	}
	
}
