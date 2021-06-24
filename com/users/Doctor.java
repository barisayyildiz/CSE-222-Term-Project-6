package com.users;

import java.io.FileWriter;

import com.data_structures.trees.SkipList;
import com.obj.*;

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
	public boolean vaccinate() {
		if (this.hospital.getVaccinationOrder().peek() != null) {
			this.hospital.getVaccinationOrder().peek().setIsVaccinated(true);
			this.hospital.getVaccinationOrder().poll();
			return true;
		}
		return false;
	}

	public void writeDBpatient(Patient newPatient) {
		try {
			FileWriter fw = new FileWriter("./database/patient.txt", true);
			fw.write("\n" + newPatient.getTckNo() + "," + newPatient.getFirstName() + "," + newPatient.getLastName()
					+ "," + newPatient.getPassword() + "," + newPatient.getAge() + "," + newPatient.get_isCovid() + ","
					+ newPatient.get_isSick() + "," + newPatient.get_isSmoking() + "," + newPatient.get_isVaccinated()
					+ "," + this.hospital.getCity());
			fw.close();
		} catch (Exception e) {
			System.out.println("Error : Can not write file...");
		}
	}

	/*
	 * public void removeDBPatient(String tckno) { SkipList tempList = new
	 * SkipList<>(); Scanner scanner = new Scanner(new
	 * File("./database/patients.txt")); scanner.nextLine(); while
	 * (scanner.hasNextLine()) { String temp = scanner.nextline(); String arr[] =
	 * temp.split(","); tempList.add( new Patient(arr[1], arr[2], arr[0], arr[3],
	 * Integer.parseInt(arr[4]), this, Boolean.valueOf(arr[5]),
	 * Boolean.valueOf(arr[6]), Boolean.valueOf(arr[7]), Boolean.valueOf(arr[8])));
	 * }
	 * 
	 * }
	 */
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
