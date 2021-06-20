package com.obj;

import java.util.*;

// File Handling
import java.io.File;
import java.io.FileNotFoundException;

import com.AVLTree;
import com.users.*;

public class Ministry {
	// Data Fields

	private Minister minister;

	private HashMap<Integer, Hospital> hospitals;
	private ArrayList<HealthEmployee> healthEmployees;
	private ArrayList<Vaccine> vaccines;
	private PriorityQueue<Patient> vaccinationOrder;
	private TreeSet<Patient> patients;

	// Constructors

	public Ministry(Minister minister){
		this.minister = minister;

		this.hospitals = new HashMap<Integer, Hospital>();
		this.healthEmployees = new ArrayList<HealthEmployee>();
		this.vaccines = new ArrayList<Vaccine>();
		this.vaccinationOrder = new PriorityQueue<Patient>();
		this.patients = new AVLTree<Patient>();

		// Reading patients.txt
		try {
			Scanner scanner = new Scanner(new File("./database/patients.txt"));
			scanner.nextLine(); // read first line

			while (scanner.hasNextLine()) {
				String temp = scanner.nextLine();
				String arr[] = temp.split(",");

				// first_name, last_name, tckno, password, age
				this.patients.add(new Patient(arr[1], arr[2], arr[0], arr[3], Integer.parseInt(arr[4])));
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

				// tckno,first_name,last_name,password,age,job
				switch(arr[5])
				{
					case "0":
						this.healthEmployees.add(new HeadPhysician(arr[1], arr[2], arr[0], arr[3], Integer.parseInt(arr[4])));
						break;
					case "1":
						this.healthEmployees.add(new Doctor(arr[1], arr[2], arr[0], arr[3], Integer.parseInt(arr[4])));
						break;
					case "2":
						this.healthEmployees.add(new Nurse(arr[1], arr[2], arr[0], arr[3], Integer.parseInt(arr[4])));
						break;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		mergeSortHealthEmployees(healthEmployees, 0, healthEmployees.size() - 1);
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

	// Employeelere hastane nasıl atanacak?
	public void addHealthEmployee(String firstName, String lastName, String tckno, String password, int age){
		for(int i = 0; i < healthEmployees.size(); i++){
			HealthEmployee currentEmployee = healthEmployees.get(i);
			String existingTckno = "";

			if(currentEmployee instanceof Doctor) {
				existingTckno = ((Doctor) currentEmployee).getTckNo();
			}
			else if(currentEmployee instanceof Nurse) {
				existingTckno = ((Nurse) currentEmployee).getTckNo();
			}

			if(tckno.equals(existingTckno) == true){
				return;
			}
		}

		healthEmployees.add(new Doctor(firstName, lastName, tckno, password, age));
		instertionSortHealthEmployees(healthEmployees);
	}
	public void removeHealthEmployee(String tckno){
		for(int i = 0; i < healthEmployees.size(); i++){
			HealthEmployee currentEmployee = healthEmployees.get(i);
			String existingTckno = new String();

			if(currentEmployee instanceof Doctor) {
				existingTckno = ((Doctor) currentEmployee).getTckNo();
			}
			else if(currentEmployee instanceof Nurse) {
				existingTckno = ((Nurse) currentEmployee).getTckNo();
			}

			if(tckno.equals(existingTckno) == true){
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

	public Patient register(String firstName, String lastName, String tckno, String password, int age){
		Set<Patient> set = patients;

		for(Patient patient : patients){
			if(tckno.equals(patient.getTckNo()) == true){
				return null;
			}
		}

		Patient newPatient = new Patient(firstName, lastName, tckno, password, age);
		patients.add(newPatient);

		return newPatient;
	}

	public void removePatient(String tckno){
		Set<Patient> set = patients;

		for(Patient patient : patients){
			if(patient.getTckNo().equals(tckno) == true){
				patients.remove(patient);
				return;
			}
		}
	}
	public void addVaccinationOrder(Patient patient){
		vaccinationOrder.add(patient);
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

	public PriorityQueue<Patient> getVaccinationOrder(){
		return this.vaccinationOrder;
	}

	public TreeSet<Patient> getPatients(){
		return this.patients;
	}

	// burası geliştirilecek, farklı data tipleri için
	public static void getData(int hospitalId){
		return;
	}

	// Used after every insertion since the employee array list is already sorted.
	private void instertionSortHealthEmployees(ArrayList<HealthEmployee> list) {
		for(int i = 1; i < list.size(); i++) {
			HealthEmployee currentEmployee = list.get(i);
			int finalIndex = i;

			int ageCurrent = 0;
			if(currentEmployee instanceof Doctor) {
				ageCurrent = ((Doctor) currentEmployee).getAge();
			}
			else if(currentEmployee instanceof Nurse) {
				ageCurrent = ((Nurse) currentEmployee).getAge();
			}

			for(int j = i - 1; j >= 0; j--) {
				int ageOther = 0;
				if(currentEmployee instanceof Doctor) {
					ageOther = ((Doctor) list.get(j)).getAge();
				}
				else if(currentEmployee instanceof Nurse) {
					ageOther = ((Nurse) list.get(j)).getAge();
				}

				if(ageOther < ageCurrent) {
					list.set(j + 1, list.get(j));
					finalIndex = j;
				}
				else {
					list.set(finalIndex, currentEmployee);
					break;
				}
			}
		}
	}

	// Used one time when the employees are read from the file
	private void mergeSortHealthEmployees(ArrayList<HealthEmployee> list, int leftIndex, int rightIndex) {
		if(leftIndex >= rightIndex) {
			return;
		}

		int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
		mergeSortHealthEmployees(list, leftIndex, midIndex);
		mergeSortHealthEmployees(list, midIndex + 1, rightIndex);
		merge(list, leftIndex, midIndex, rightIndex);
	}

	private void merge(ArrayList<HealthEmployee> list, int leftIndex, int midIndex, int rightIndex)
	{
		// Left and right array sizes
		int leftSize = midIndex - leftIndex + 1;
		int rightSize = rightIndex - midIndex;

		// Temp subarrays
		ArrayList<HealthEmployee> leftList = new ArrayList<HealthEmployee>(leftSize);
		ArrayList<HealthEmployee> rightList = new ArrayList<HealthEmployee>(rightSize);

		// Copy data from the main list to the subarrays
		for (int i = 0; i < leftList.size(); i++)
			leftList.set(i, list.get(leftIndex + i));
		for (int i = 0; i < rightList.size(); i++)
			rightList.set(i, list.get(midIndex + i + 1));

		// Current indexes of the subarrays
		int leftListIndex = 0;
		int rightListIndex = 0;

		// Copy from the subarrays to the main array list
		for (int i = leftIndex; i < rightIndex + 1; i++) {
			// If both lists are still iterable, choose the employee who has the highest age
			if (leftListIndex < leftList.size() && rightListIndex < rightList.size()) {
				int leftAge = 0;
				int rightAge = 0;

				// Determine the left employee's age and the right employee's age
				if(leftList.get(leftListIndex) instanceof Doctor) {
					leftAge = ((Doctor) leftList.get(leftListIndex)).getAge();
				}
				else if(leftList.get(leftListIndex) instanceof Nurse) {
					leftAge = ((Nurse) leftList.get(leftListIndex)).getAge();
				}

				if(rightList.get(rightListIndex) instanceof Doctor) {
					rightAge = ((Doctor) rightList.get(rightListIndex)).getAge();
				}
				else if(rightList.get(rightListIndex) instanceof Nurse) {
					rightAge = ((Nurse) rightList.get(rightListIndex)).getAge();
				}

				// Pick the employee with the higher age and put it in the list
				if (leftAge > rightAge) {
					list.set(i, leftList.get(leftListIndex));
					leftListIndex++;
				}
				else {
					list.set(i, rightList.get(rightListIndex));
					rightListIndex++;
				}
			}
			else if (leftListIndex < leftList.size()) {
				// If all elements have been copied from rightArray, copy rest of leftArray
				list.set(i, leftList.get(leftListIndex));
				leftListIndex++;
			}
			else if (rightListIndex < rightList.size()) {
				// If all elements have been copied from leftArray, copy rest of rightArray
				list.set(i, rightList.get(rightListIndex));
				rightListIndex++;
			}
		}
	}
}