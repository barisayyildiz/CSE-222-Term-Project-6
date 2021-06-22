package com.users;

import com.obj.*;

public class Doctor extends User implements HealthEmployee
{

	protected Hospital hospital;

	public Doctor(String firstName, String lastName, String tckno, String password, int age, Hospital hospital, Ministry ministry){
		super(firstName, lastName, tckno, password, age,ministry);
		this.hospital=hospital;
	}

	public Hospital getHospital(){
		return this.hospital;
	}

	@Override
	public boolean vaccinate(String tckno){
		for(Patient searchedPaitent : ministry.getPatients()) {
			if(searchedPaitent.getTckNo().equals(tckno)) {
				searchedPaitent.setIsVaccinated(true);
				return true;
			}
		}	
		return false;
	}

	public void addPatient(Patient newPatient){		
		ministry.getPatients().add(newPatient);
	}

	public boolean removePatient(String tckno){		
		for(Patient searchedPaitent : ministry.getPatients()) {
			if(searchedPaitent.getTckNo().equals(tckno)) {
				ministry.getPatients().remove(searchedPaitent);
				return true;
			}
		}
		return false;
	}

	public String getPatientData(String tckno){
		for(Patient searchedPaitent : ministry.getPatients()) {
			if(searchedPaitent.getTckNo().equals(tckno)) {
				return searchedPaitent.toString();
				//  return String.format("%s %s, %s, %d",searchedPaitent.getFirstName(),searchedPaitent.getLastName(),
				// 		 								searchedPaitent.getTckNo(),searchedPaitent.getAge());
			}
		}	
		return null;		
	}
	
}

