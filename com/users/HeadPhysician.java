package com.users;

import com.obj.*;
import java.util.ArrayList;

public class HeadPhysician extends Doctor {

	public HeadPhysician(String firstName, String lastName, String tckno, String password, int age, Hospital hospital,
			Ministry ministry) {
		super(firstName, lastName, tckno, password, age, hospital, ministry);
	}

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

	void supplyTest() {

		hospital.setNumOfTests(hospital.numOfTests() + 100);
	}

	public void demandVaccine(VaccineType type, int num) {

		String str = String.valueOf(num) + " of " + String.valueOf(type) + " needed\n";
		this.ministry.getMinister().addNotification(str);
	}

	public void sendNotification(String str) {
		this.ministry.getMinister().addNotification(str);
	}

	public String getHospitalData() {
		return this.hospital.toString();
	}

	@Override
	public String toString() {
		String str = "";
		str += this.getTckNo() + "," + this.getFirstName() + "," + this.getLastName() + "," + this.getPassword() + ","
				+ this.getAge() + "," + "0," + this.getHospital().getID();
		return str;
	}
}
