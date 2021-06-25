package com.users;

import com.obj.*;
import java.util.ArrayList;

/**
 * Holds the information for the Head Physician class
 * Implements methods from Doctor
 * @author Group 6
 */
public class HeadPhysician extends Doctor {

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
	public HeadPhysician(String firstName, String lastName, String tckno, String password, int age, Hospital hospital,
			Ministry ministry) {
		super(firstName, lastName, tckno, password, age, hospital, ministry);
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
	 * Supplies hospital with given vaccine type
	 * @param type parameter for vaccination enum
	 * @param num parameter for the number of vaccines added
	 * @return returns the supplied number of vaccines
	 */
	int supplyVaccine(VaccineType type, int num) {

		for (Vaccine vaccine : hospital.getVaccines()) {
			if (vaccine.getType().equals(type)) {
				vaccine.setNumber(vaccine.getNumber() + num);
				return num;
			}
		}

		hospital.getVaccines().add(new Vaccine(num, type));

		return num;
	}

	/**
	 * Supplies hospital with 100 test
	 */
	void supplyTest() {

		hospital.setNumOfTests(hospital.numOfTests() + 100);
	}

	/**
	 * Demands vaccines from the minister for the hospital with given vaccine type
	 * @param type parameter for vaccination enum
	 * @param num parameter for the number of vaccines demanded
	 */
	public void demandVaccine(VaccineType type, int num) {

		String str = String.valueOf(num) + " of " + String.valueOf(type) + " needed" + ", to the hospital : " + this.hospital.getID() + "\n";
		this.ministry.getMinister().addNotification(str);
	}

	/**
	 * Sends string data to the minister
	 * @param str parameter to send to the minister
	 */
	public void sendNotification(String str) {
		this.ministry.getMinister().addNotification(str);
	}

	/**
	 * Returns hospital data
	 * @return String that modified with overrided toString method from hospital
	 */
	public String getHospitalData() {
		return this.hospital.toString();
	}

	/**
	 * Overrided toString method
	 * @return String data for the given class information
	 */
	@Override
	public String toString() {
		String str = "";
		str += this.getTckNo() + "," + this.getFirstName() + "," + this.getLastName() + "," + this.getPassword() + ","
				+ this.getAge() + "," + "0," + this.getHospital().getID();
		return str;
	}
}
