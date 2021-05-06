package com.users;

import com.obj.*;

public class HeadPhysician extends Doctor
{
	public HeadPhysician(){
		super();
		// eklemeler yapılacak
	}

	// düz string yollayabilir, sağlık bakanına
	public void demandVaccine(){
		return;
	}

	public void sendNotification(){
		return;
	}

	public void getHospitalData(){
		return;
	}


	@Override
	public void vaccinate(){
		return;
	}

	// ==== Doctor class ından gelen metodlar

	public void addPatient(){
		return;
	}

	public void removePatient(){
		return;
	}

	public void getPatientData(){
		return;
	}

	public void giveMedicine(){
		return;
	}


	
}
