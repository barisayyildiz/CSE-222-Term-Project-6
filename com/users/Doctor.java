package com.users;

import java.io.FileWriter;

import com.data_structures.trees.SkipList;
import com.obj.*;
import java.util.ArrayList;

public class Doctor extends User implements HealthEmployee {

	protected Hospital hospital;

	public Doctor(String firstName, String lastName, String tckno, String password, int age, Hospital hospital,
			Ministry ministry) {
		super(firstName, lastName, tckno, password, age, ministry);
		this.hospital = hospital;
	}

	public Hospital getHospital() {
		return this.hospital;
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

	public void writeDBpatient(Patient newPatient) {
		try {
			FileWriter fw = new FileWriter("./database/patients.txt", true);
			fw.write("\n" + newPatient.getTckNo() + "," + newPatient.getFirstName() + "," + newPatient.getLastName()
					+ "," + newPatient.getPassword() + "," + newPatient.getAge() + "," + newPatient.get_isCovid() + ","
					+ newPatient.get_isSick() + "," + newPatient.get_isSmoking() + "," + newPatient.get_isVaccinated()
					+ "," + this.hospital.getCity());
			fw.close();
		} catch (Exception e) {
			System.out.println("Error : Can not write file...");
		}
	}
	
	public void addPatient(Patient newPatient) {
		ministry.getPatients().add(newPatient);
		writeDBpatient(newPatient);
	}

	public boolean removePatient(String tckno) {
		for (Patient searchedPaitent : ministry.getPatients()) {
			if (searchedPaitent.getTckNo().equals(tckno)) {
				ministry.getPatients().remove(searchedPaitent);

				return true;
			}
		}
		return false;
	}

	public String getPatientData(String tckno) {
		for (Patient searchedPaitent : ministry.getPatients()) {
			if (searchedPaitent.getTckNo().equals(tckno)) {
				return searchedPaitent.toString();
			}
		}
		return null;
	}

	@Override
	public String toString() {
		String str = "";
		str += this.getTckNo() + "," + this.getFirstName() + "," + this.getLastName() + "," + this.getPassword() + ","
				+ this.getAge() + "," + "1," + this.getHospital().getID();
		return str;
	}
}
