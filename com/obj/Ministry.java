package com.obj;

import java.util.*;

// File Handling
import java.io.File;
import java.io.FileNotFoundException;

import com.users.*;

public class Ministry {
	// Data Fields

	private Minister minister;

	private HashMap<Integer, Hospital> hospitals;
	private ArrayList<HealthEmployee> healthEmployees;
	private ArrayList<Vaccine> vaccines;
	private PriorityQueue<Integer> vaccinationOrder;
	private TreeSet<Patient> patients;

	// Constructors

	public Ministry(Minister minister){
		this.minister = minister;

		this.hospitals = new HashMap<Integer, Hospital>();
		this.healthEmployees = new ArrayList<HealthEmployee>();
		this.vaccines = new ArrayList<Vaccine>();
		this.vaccinationOrder = new PriorityQueue<Integer>();
		this.patients = new TreeSet<Patient>();

		// Reading patients.txt
		try {
			Scanner scanner = new Scanner(new File("./database/patients.txt"));
			scanner.nextLine(); // read first line

			while (scanner.hasNextLine()) {
				String temp = scanner.nextLine();
				String arr[] = temp.split(",");

				// sırasıyla
				// tckno,first_name,last_name,password,age,is_covid,is_sick,is_smoking,is_vaccinated
				this.patients.add(new Patient(arr[0], arr[1], arr[2], arr[3], Integer.parseInt(arr[4]), Boolean.valueOf(arr[5]), Boolean.valueOf(arr[6]), Boolean.valueOf(arr[7]), Boolean.valueOf(arr[8])  ));
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Reading healthemployees.txt
		try {
			Scanner scanner = new Scanner(new File("./database/healthemployees.txt"));
			scanner.nextLine(); // read first line

			while (scanner.hasNextLine()) {
				String temp = scanner.nextLine();
				String arr[] = temp.split(",");

				// sırasıyla
				// tckno,first_name,last_name,password,age,job
				switch(arr[5])
				{
					case "0":
						this.healthEmployees.add(new HeadPhysician(arr[0], arr[1], arr[2], arr[3], Integer.parseInt(arr[4])));
						break;
					case "1":
						this.healthEmployees.add(new Doctor(arr[0], arr[1], arr[2], arr[3], Integer.parseInt(arr[4])));
						break;
					case "2":
						this.healthEmployees.add(new Nurse(arr[0], arr[1], arr[2], arr[3], Integer.parseInt(arr[4])));
						break;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Functions

	public void addHospital(){
		/*
		int maxAgeIndex = 0;

		for(int i = 0; i < healthEmployees.size(); i++){
			if(healthEmployees.get(i) instanceof Doctor){
				if(i == 0){
					maxAgeIndex = i;
				}
				else if(((Doctor) healthEmployees.get(i)).getAge() > ){
					healthEmployees.remove(i);
					return;
				}
			}
		}

		Hospital newHospital = new Hospital(,this);
		hospitals.put(newHospital.getId(), newHospital);
		*/
	}

	public void removeHospital(int id){
		hospitals.remove(id);
	}

	public void addDoctor(String tckno, String firstName, String lastName, String password, int age){
		for(int i = 0; i < healthEmployees.size(); i++){
			if(healthEmployees.get(i).equals(tckno) == true){
				return;
			}
		}

		healthEmployees.add(new Doctor(tckno, firstName, lastName, password, age));
	}
	public void removeDoctor(String tckno){
		for(int i = 0; i < healthEmployees.size(); i++){
			if(healthEmployees.get(i).equals(tckno) == true){
				healthEmployees.remove(i);
				return;
			}
		}
	}

	public void addNurse(String tckno, String firstName, String lastName, String password, int age){
		for(int i = 0; i < healthEmployees.size(); i++){
			if(healthEmployees.get(i).equals(tckno) == true){
				return;
			}
		}

		healthEmployees.add(new Nurse(tckno, firstName, lastName, password, age));
	}
	public void removeNurse(String tckno){
		for(int i = 0; i < healthEmployees.size(); i++){
			if(healthEmployees.get(i).equals(tckno) == true){
				healthEmployees.remove(i);
				return;
			}
		}
	}

	public void addVaccine(int vacNumber, VaccineType vacType) {
		for (int i = 0; i < vaccines.size(); i++) {
			if (vaccines.get(i).getType() == vacType) {
				return;
			}
		}

		vaccines.add(new Vaccine(vacNumber, vacType));
	}

	public Patient register(String firstName, String lastName, String tckno, String password, int age, boolean isSmoking, boolean isVaccinated, boolean isCovid, boolean isSick){
		Set<Patient> set = patients;

		for(Patient patient : patients){
			if(patient.getTckno().equals(tckno) == true){
				return null;
			}
		}

		Patient newPatient = new Patient(tckno, firstName, lastName, password, age, isSmoking, isVaccinated, isCovid, isSick);
		patients.add(newPatient);

		return newPatient;
	}

	public void removePatient(String tckno){
		Set<Patient> set = patients;

		for(Patient patient : patients){
			if(patient.getTckno().equals(tckno) == true){
				patients.remove(patient);
				return;
			}
		}
	}
	public void addVaccinationOrder(Integer value){
		vaccinationOrder.add(value);
	}

	public Minister getMinister(){
		return this.minister;
	}

	public HashMap<Integer, Hospital> getHospitals(){
		return this.hospitals;
	}

	public ArrayList<HealthEmployee> getHealthEmployees(){
		return this.healthEmployees;
	}

	public ArrayList<Vaccine> getVaccines(){
		return this.vaccines;
	}

	public PriorityQueue<Integer> getVaccinationOrder(){
		return this.vaccinationOrder;
	}

	public TreeSet<Patient> getPatients(){
		return this.patients;
	}

	// burası geliştirilecek, farklı data tipleri için
	public static void getData(int hospitalId){
		return;
	}
}