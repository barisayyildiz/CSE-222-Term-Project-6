package com.users;

import com.obj.*;

public class Nurse extends User implements HealthEmployee
{
	private Ministry ministry;
	private Hospital hospitalId;

	public Nurse(){
		super();
		// ...
	}

	public void test(){
		return;
	}

	public boolean vaccinate(String tckno){
		return true;
	}

	public void setCovidInfo(String tckno, boolean isCovid){
		return;
	}

	
}
