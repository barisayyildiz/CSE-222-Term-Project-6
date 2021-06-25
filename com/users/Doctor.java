package com.users;

import java.io.FileWriter;

import com.data_structures.trees.SkipList;
import com.obj.*;
import java.util.ArrayList;

/**
 * Holds the information for the Doctor.
 * Implements funtions from HealthEmployee and User classes
 * @author Group 6
 */
public class Doctor extends User implements HealthEmployee {

	/** Holds the information that the doctor works in 
	 * <p> It does not have an initial value
	 */
	protected Hospital hospital;

	/**
	 * Constructor with parameters. Initializes all the fields for the class
	 * Calls for the parent class's constructor for give parameters
	 * @param firstName firstName to set for this class
	 * @param lastName lastName to set for this class
	 * @param tckno tckno to set for this class
	 * @param password password to set for this class
	 * @param age age to set for this class
	 * @param hospital hospital to set for this class
	 * @param ministry ministry to set for this class
	 */
	public Doctor(String firstName, String lastName, String tckno, String password, int age, Hospital hospital,
			Ministry ministry) {
		super(firstName, lastName, tckno, password, age, ministry);
		this.hospital = hospital;
	}

	/**
	 * Getter for hospital parameter
	 * @return hospital data for patients closest hospital where they live in
	 */
	public Hospital getHospital() {
		return this.hospital;
	}

	/**
	 * Overrided vaccination function defines the vaccination process
	 * @return Patient returns null if vaccination failed else patient object
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
	 * Adds a new Patient to database and writes to the txt file
	 * @param newPatient parameter to add Patient object
	 */
	public void addPatient(Patient newPatient) {
		ministry.getPatients().add(newPatient);
		this.ministry.writeDBpatient(newPatient);
	}

	/**
	 * Removes a patient if it exists else return false
	 * @param tckno parameter for searched patient
	 * @return return true if succesfull otherwise false
	 */
	public boolean removePatient(String tckno) {
		for (Patient searchedPaitent : ministry.getPatients()) {
			if (searchedPaitent.getTckNo().equals(tckno)) {
				ministry.getPatients().remove(searchedPaitent);
				this.ministry.rebuildDBPatient();
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets the patient data
	 * @param tckno parameter for searched patient
	 * @return return toString method if found otherwise null
	 */
	public String getPatientData(String tckno) {
		for (Patient searchedPaitent : ministry.getPatients()) {
			if (searchedPaitent.getTckNo().equals(tckno)) {
				return searchedPaitent.toString();
			}
		}
		return null;
	}

	/**
	 * Overrided toString method
	 * @return String data for the given class information
	 */
	@Override
	public String toString() {
		String str = "";
		str += this.getTckNo() + "," + this.getFirstName() + "," + this.getLastName() + "," + this.getPassword() + ","
				+ this.getAge() + "," + "1," + this.hospital.getID();
		// String str = "";
		// str += "TCKNO : " + this.getTckNo() + "\n";
		// str += "First name : " + this.getFirstName() + "\n";
		// str += "Last name : " + this.getLastName() + "\n";
		// str += "Password : " + this.getPassword() + "\n";
		// str += "Age : " + this.getAge() + "\n";
		// str += "Hospital information : " + "\n";
		// str += this.hospital.toString();
		return str;
	}
}
