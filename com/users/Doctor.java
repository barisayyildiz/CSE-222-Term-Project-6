package com.users;

import com.obj.*;

public class Doctor extends User implements HealthEmployee
{
	private Ministry ministry;
	private Hospital hospitalId;
	
	public Doctor(){
		// ctor yazılacak
		super();
	}

	@Override
	public boolean vaccinate(String tckno){
		return true;
	}

	public void addPatient(){
		return;
	}

	public void removePatient(String tckno){
		return;
	}

	public String getPatientData(String tckno){
		return "";
	}
	
}

