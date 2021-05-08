package com.users;

import com.obj.*;

public class HeadPhysician extends Doctor
{
	private Hospital hospitalId;

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

	public String getHospitalData(){
		return "";
	}

	public void sendNotification(String str){
		return; // bakana gider
	}


	@Override
	public boolean vaccinate(String tckno){
		return true;
	}

	// // ==== Doctor class ından gelen metodlar

	// public void addPatient(){
	// 	return;
	// }

	// public void removePatient(){
	// 	return;
	// }

	// public void getPatientData(){
	// 	return;
	// }

	// public void giveMedicine(){
	// 	return;
	// }

	
}
