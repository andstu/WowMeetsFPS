package wowMeetsFPS;

import java.io.Serializable;

public class Data<T> implements Serializable{

	T info;
	
	//Creates a wrapper class holding a generic type of information
	Data(T storedInformation)
	{
		info = storedInformation;
	}
	
	//Gets the information from the wrapper class
	T getInfo()
	{
		return info;
	}
}
