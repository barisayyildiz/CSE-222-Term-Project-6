package com.users;

import com.obj.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * Holds the information for the Nurse.
 * Implements functions from HealthEmployee and extends from User classes
 * @author Group 6
 */
public class Nurse extends User implements HealthEmployee {
	private Hospital hospital;
	
	/**
	 * Constructor with parameters. Initializes all the fields for the class
	 * Calls for the parent class's constructor for give parameters
	 * @param firstName Name of nurse
	 * @param lastName Last name of nurse
	 * @param tckno	tkno of nurse
	 * @param password password of nurse
	 * @param age	age of nurse
	 * @param hospital hospital of nurse
	 * @param ministry	initialize ministry
	 */
	public Nurse(String firstName, String lastName, String tckno, String password, int age, Hospital hospital, Ministry ministry) {
		super(firstName, lastName, tckno, password, age, ministry);
		this.hospital = hospital;
	}
	
	/**
	 * randomly determined by the test result
	 * @return test result true or false
	 */
	private boolean test() {
		Random rand = new Random();
		return rand.nextBoolean();
	}
	/**
	 * finds and removes the patient who needs to be vaccinated
	 * @return  Vaccinated patient  
	 */
	@Override
	public Patient vaccinate() {
		if (this.hospital.getVaccinationOrder().peek() != null) {
			this.hospital.getVaccinationOrder().peek().setIsVaccinated(true);
			// adjust vaccine number
			ArrayList<Vaccine> vaccines = this.hospital.getVaccines();
			for(int i=0; i<vaccines.size(); i++){
				if(vaccines.get(i).getNumber() != 0){
					vaccines.get(i).setNumber(vaccines.get(i).getNumber() - 1);
					break;
				}
			}
			return this.hospital.getVaccinationOrder().poll();
		}
		return null;
	}
	/**
	 * information about whether the patient has covid
	 * @param TC no of patient
	 */
	public void setCovidInfo(String tckno) {
		for (Patient searchedPaitent : ministry.getPatients()) {
			if (searchedPaitent.getTckNo().equals(tckno)) {
				searchedPaitent.setCovid(this.test());
				this.hospital.setNumOfTests(this.hospital.getNumOfTests() - 1);
			}
		}
		return;
	}
	/**
	 * Access for hospital
	 * @return Hospital
	 */
	public Hospital getHospital(){
		return this.hospital;
	}
	/**
	 * For nurse's information
	 * @return Nurse information
	 */
	@Override
	public String toString() {
		String str = "";
		str += this.getTckNo() + "," + this.getFirstName() + "," + this.getLastName() + "," + this.getPassword() + ","
				+ this.getAge() + "," + "2," + this.hospital.getID();
		return str;
	}

}
