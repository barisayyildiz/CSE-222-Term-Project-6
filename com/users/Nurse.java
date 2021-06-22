package com.users;

import com.obj.*;

import java.util.Random;

public class Nurse extends User implements HealthEmployee
{
	private Hospital hospitalId;
	private Hospital hospital;

	public Nurse(String firstName, String lastName, String tckno, String password, int age, Hospital hospital, Ministry ministry){
		super(firstName, lastName, tckno, password, age, ministry);
		this.hospital = hospital;
		// hospitalId = new Hospital(null,ministry);
	}
	
	public void test(Patient obj){

		Random rand = new Random();

		if( rand.nextBoolean() ) {
			obj.setCovidInfo(true);
		}
		else
			obj.setCovidInfo(false);
		
		return;
	}

	@Override
	public boolean vaccinate(){
		if(this.hospital.getVaccinationOrder().poll() != null)
			return true;
		return false;
	}

	public void setCovidInfo(String tckno, boolean isCovid){
		for(Patient searchedPaitent : ministry.getPatients()) {
			if(searchedPaitent.getTckNo().equals(tckno)) {
				searchedPaitent.setCovidInfo(isCovid);
			}
		}
		return;
	}

	
}
