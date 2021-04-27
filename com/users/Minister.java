package com.users;

import com.obj.*;

public class Minister extends User {

	private Ministry ministry;

	public Minister(Ministry ministry){
		this.ministry = ministry;
		// super(); // parametreler eklenerek super metodu çalışıtırılacak
	}

	public void addHospitals(){
		return;
	}

	public void supplyVaccine(){
		return;
	}

	public void supplyTest(){
		return;
	}

	
}
