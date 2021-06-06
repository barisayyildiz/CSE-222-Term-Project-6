package com.users;

import com.obj.*;

public class Doctor extends User implements HealthEmployee
{
	private Ministry ministry;
	private Hospital hospitalId;
	
	public Doctor(String firstName, String lastName, String tckno, String password, int age){
		super(firstName, lastName, tckno, password, age);
		ministry = new Ministry(null);
		hospitalId=new Hospital(null, ministry);
	}

	@Override
	public boolean vaccinate(String tckno){
		for(Patient searchedPaitent : ministry.getPatients()) {
			if(searchedPaitent.getTckNo().equals(tckno)) {
				searchedPaitent.setVaccinated(true);
				return true;
			}
		}	
		return false;
	}

	public void addPatient(Patient newPatient){		
		ministry.getPatients().add(newPatient);
	}

	public void removePatient(String tckno){		
		for(Patient searchedPaitent : ministry.getPatients()) {
			if(searchedPaitent.getTckNo().equals(tckno)) {
				ministry.getPatients().remove(searchedPaitent);
			}
		}	
	}

	public String getPatientData(String tckno){
		for(Patient searchedPaitent : ministry.getPatients()) {
			if(searchedPaitent.getTckNo().equals(tckno)) {
				 return String.format("%s %s, %s, %d",searchedPaitent.getFirstName(),searchedPaitent.getLastName(),
						 								searchedPaitent.getTckNo(),searchedPaitent.getAge());
			}
		}	
		return null;		
	}
	
}

