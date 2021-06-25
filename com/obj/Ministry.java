package com.obj;

import java.util.*;

// File Handling
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

// import com.data_structures.trees.AVLTree;
import com.data_structures.trees.*;
import com.data_structures.graphs.*;
import com.users.*;

/**
 * Holds the information for the Ministry.
 * @author Group 6
 */
public class Ministry {
	// Data Fields

	private Minister minister;

	private HashMap<String, Hospital> hospitals;
	private ArrayList<User> healthEmployees;
	private ArrayList<Vaccine> vaccines;
	private AVLTree<Patient> patients;
	private MatrixGraph cityDistances;
	private double[] weights;
	private int[] intArr;

	// Constructors
	/**
	 * Here we initialize all the data structures we use
	 * We read and store the necessary information in the database
	 * distances between cities, hospital information, patients, etc.
	 * @param minister to initialized
	 */
	public Ministry(Minister minister) {
		this.minister = minister;
		this.minister.setMinistry(this);

		this.hospitals = new HashMap<String, Hospital>();
		this.healthEmployees = new ArrayList<User>();
		this.vaccines = new ArrayList<Vaccine>();
		this.patients = new AVLTree<Patient>();
		this.cityDistances = new MatrixGraph(81, false);
		this.weights = new double[81];
		this.intArr = new int[81];

		// Reading distances.txt
		try {
			Scanner scanner = new Scanner(new File("./database/distances.txt"));
			scanner.nextLine();

			while (scanner.hasNextLine()) {
				String temp = scanner.nextLine();
				String arr[] = temp.split(",");

				cityDistances.insert(new Edge(cityId.valueOf(arr[0]).ordinal(), cityId.valueOf(arr[1]).ordinal(),
						Double.valueOf(arr[2])));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Reading hospitals.txt
		try {
			Scanner scanner = new Scanner(new File("./database/hospitals.txt"));
			scanner.nextLine(); // read first line

			while (scanner.hasNextLine()) {
				String temp = scanner.nextLine();
				String arr[] = temp.split(",");

				this.hospitals.put(arr[0], new Hospital(null, this, arr[1], arr[0]));
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// hastane şehir id lerini kaydet
		HashMap<Integer, Hospital> hospitalCityIndexes = new HashMap<Integer, Hospital>();
		for (Hospital h : this.hospitals.values()) {
			int tempIndex = cityId.valueOf(h.getCity()).ordinal();
			hospitalCityIndexes.put(tempIndex, h);
		}

		// Reading patients.txt
		try {
			Scanner scanner = new Scanner(new File("./database/patients.txt"));
			scanner.nextLine(); // read first line

			while (scanner.hasNextLine()) {
				String temp = scanner.nextLine();
				String arr[] = temp.split(",");

				DijkstrasAlgorithm.dijkstrasAlgorithm(this.cityDistances, cityId.valueOf(arr[9]).ordinal(), intArr, weights);
				double min = Double.MAX_VALUE;
				int index = -1;
				for (int i = 0; i < weights.length; i++) {
					if (weights[i] < min && hospitalCityIndexes.get(i) != null) {
						min = weights[i];
						index = i;
					}
				}

				// first_name, last_name, tckno, password, age, ministry
				this.patients.add(new Patient(arr[1], arr[2], arr[0], arr[3], Integer.parseInt(arr[4]), this,
						Boolean.valueOf(arr[5]), Boolean.valueOf(arr[6]), Boolean.valueOf(arr[7]),
						Boolean.valueOf(arr[8]), arr[9], hospitalCityIndexes.get(index)));
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
				switch (arr[5]) {
				case "0":
					// creates new head physician
					HeadPhysician hPhysician = new HeadPhysician(arr[1], arr[2], arr[0], arr[3],
							Integer.parseInt(arr[4]), this.hospitals.get(arr[6]), this);
					this.hospitals.get(arr[6]).setHeadPhysician(hPhysician);
					this.healthEmployees.add(hPhysician);
					break;
				case "1":
					// creates new doctor
					this.healthEmployees.add(new Doctor(arr[1], arr[2], arr[0], arr[3], Integer.parseInt(arr[4]),
							this.hospitals.get(arr[6]), this));
					break;
				case "2":
					// creates new nurse
					this.healthEmployees.add(new Nurse(arr[1], arr[2], arr[0], arr[3], Integer.parseInt(arr[4]),
							this.hospitals.get(arr[6]), this));
					break;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		mergeSortHealthEmployees(healthEmployees, 0, healthEmployees.size() - 1);
	}
	
	/**
	 * we add the new patient to the database
	 * @param newPatient new patient requested to be added to the database
	 */
	public void writeDBpatient(Patient newPatient) {
		try {
			FileWriter fw = new FileWriter("./database/patients.txt", true);
			fw.write("\n" + newPatient.getTckNo() + "," + newPatient.getFirstName() + "," + newPatient.getLastName()
					+ "," + newPatient.getPassword() + "," + newPatient.getAge() + "," + newPatient.get_isCovid() + ","
					+ newPatient.get_isSick() + "," + newPatient.get_isSmoking() + "," + newPatient.get_isVaccinated()
					+ "," + newPatient.getCity());
			fw.close();
		} catch (Exception e) {
			System.out.println("Error : Can not write file...");
		}
	}
	/**
	 * writes the health employee to the database.
	 * @param tckno TC no of Health Employee
	 * @param firstName First name of Health Employee
	 * @param lastName Last Name of Health Employee
	 * @param pass password of Health Employee
	 * @param age Age of Health Employee
	 * @param jobType  position of Health Employee
	 * @param hospitalId is the id of the hospital where works.
	 */
	public void writeDBHealthEmployee(String tckno, String firstName, String lastName, String pass, int age,
			int jobType, String hospitalId) {
		try {
			FileWriter fw = new FileWriter("./database/healthemployees.txt", true);
			fw.write("\n" + tckno + "," + firstName + "," + lastName + "," + pass + "," + age + "," + jobType + ","
					+ hospitalId);
			fw.close();
		} catch (Exception e) {
			System.out.println("Error : Can not write file...");
		}
	}
	/**
	 * writes the hospital to the database.
	 * @param hospital new hospital added to the system
	 */
	public void writeDBHospital(Hospital hospital) {
		try {
			FileWriter fw = new FileWriter("./database/hospitals.txt", true);
			fw.write("\n" + hospital.getID() + "," + hospital.getCity());
			fw.close();
		} catch (Exception e) {
			System.out.println("Error : Can not write file...");
		}
	}
	/**
	 * We restructure the Health Employee database
	 */
	public void rebuildDBHealthEmployee() {
		int i = 0;
		try {
			FileWriter fw = new FileWriter("./database/healthemployees.txt");
			fw.write("tckno,first_name,last_name,password,age,job,hospital_id");
			while (i < healthEmployees.size()) {
				fw.write("\n" + healthEmployees.get(i).toString());
				i++;
			}
			fw.close();
		} catch (Exception e) {
			System.out.println("Error : Can not write file...");

		}
	}
	/**
	 * We restructure the Hospital database
	 */
	public void rebuildDBHospital() {
		try {
			FileWriter fw = new FileWriter("./database/hospitals.txt");
			fw.write("id,city");
			Iterator iter = hospitals.keySet().iterator();
			while (iter.hasNext()) {
				Hospital temp = hospitals.get(iter.next());
				fw.write("\n" + temp.getID() + "," + temp.getCity());
			}
			fw.close();
		} catch (Exception e) {
			System.out.println("Error : Can not write file...");
		}

	}
	/**
	 * We restructure the patient database
	 */
	public void rebuildDBPatient() {
		try {
			FileWriter fw = new FileWriter("./database/patients.txt");
			fw.write("tckno,first_name,last_name,password,age,is_covid,is_sick,is_smoking,is_vaccinated,city");
			Iterator<Patient> iter = patients.iterator();
			while (iter.hasNext()) {
				Patient patienTemp = iter.next();
				fw.write("\n" + patienTemp.getTckNo() + "," + patienTemp.getFirstName() + "," + patienTemp.getLastName()
						+ "," + patienTemp.getPassword() + "," + patienTemp.getAge() + "," + patienTemp.get_isCovid()
						+ "," + patienTemp.get_isSick() + "," + patienTemp.get_isSmoking() + ","
						+ patienTemp.get_isVaccinated() + "," + patienTemp.getCity());
			}
			fw.close();
		} catch (Exception e) {
			System.out.println("Error : Can not write file...");
		}
	}
	/**
	 * City information and a unique id are defined for the newly added hospital.
	 * @param city where the new central hospital is located
	 */
	// Functions
	public boolean addHospital(String city) {
		Doctor doctor = null;
		int maxIndex = -1;
		for (int i = 0; i < this.healthEmployees.size(); i++) {
			if (this.healthEmployees.get(i) instanceof Doctor) {
				maxIndex = i;
				doctor = (Doctor) this.healthEmployees.get(i);
				break;
			}
		}
		if (maxIndex != -1) {
			this.healthEmployees.set(maxIndex, new HeadPhysician(doctor.getFirstName(), doctor.getLastName(),
					doctor.getTckNo(), doctor.getPassword(), doctor.getAge(), doctor.getHospital(), this));
			Hospital newHospital = new Hospital( (HeadPhysician)this.healthEmployees.get(maxIndex), this, city, generateKey(8));
			System.out.println(generateKey(8));
			System.out.println(newHospital.getID());
			hospitals.put(newHospital.getID(), newHospital);
			// writeDBHospital(newHospital.getID(), city);
			writeDBHospital(newHospital);
			return true;
		}
		return false;
	}
	/**
	 * Removes hospital
	 * @param id the id of the hospital to be deleted.
	 */
	public boolean removeHospital(String id) {
		Hospital h = this.hospitals.remove(id);
		if(h != null){
			rebuildDBHospital();
			return true;
		}
		return false;
	}
	/**
	 * Adds patient
	 * @param firstName Frist Name of new patient 
	 * @param lastName 	Last Name of new patient 
	 * @param tckno TC number of new patient
	 * @param password password of new patient 
	 * @param age	age of new patient 
	 * @param isCovid Is the patient covid or not?
	 * @param isSick Is the patient or not?
	 * @param isSmoking Does the patient smoke?
	 * @param isVaccinated Has the patient been vaccinated?
	 * @param city In which city is the patient?
	 */
	public void addPatient(String firstName, String lastName, String tckno, String password, int age, Ministry ministry, boolean isCovid, boolean isSick, boolean isSmoking, boolean isVaccinated, String city){

		// check if the user is already registered
		Iterator<Patient> iter = this.patients.iterator();
		while(iter.hasNext()){
			if(iter.next().getTckNo().equals(tckno))	return;
		}

		// hastane şehir id lerini kaydet
		HashMap<Integer, Hospital> hospitalCityIndexes = new HashMap<Integer, Hospital>();
		for (Hospital h : this.hospitals.values()) {
			int tempIndex = cityId.valueOf(h.getCity()).ordinal();
			hospitalCityIndexes.put(tempIndex, h);
		}

		DijkstrasAlgorithm.dijkstrasAlgorithm(this.cityDistances, cityId.valueOf(city).ordinal(), intArr, weights);
		double min = Double.MAX_VALUE;
		int index = -1;
		for (int i = 0; i < weights.length; i++) {
			if (weights[i] < min && hospitalCityIndexes.get(i) != null) {
				min = weights[i];
				index = i;
			}
		}

		Patient newPatient = new Patient(firstName, lastName, tckno, password, age, this, isCovid, isSick, isSmoking, isVaccinated, city, hospitalCityIndexes.get(index));
		this.patients.add(newPatient);
		this.writeDBpatient(newPatient);

	}
	/**
	 * adds health employee
	 * @param firstName Frist Name of new Health Employee
	 * @param lastName Last Name of new Health Employee
	 * @param tckno TC number of new health employee
	 * @param password password of new health employee
	 * @param age age of new health employee
	 */
	public boolean addHealthEmployee(String firstName, String lastName, String tckno, String password, int age,
			String hospitalId, int type) {
		for (int i = 0; i < healthEmployees.size(); i++) {
			User currentEmployee = healthEmployees.get(i);
			String existingTckno = "";

			existingTckno = currentEmployee.getTckNo();

			if (tckno.equals(existingTckno) == true) {
				return false;
			}
		}

		Hospital hospital = this.hospitals.get(hospitalId);
		if (hospital == null)
			return false;

		if (type == 1) {
			healthEmployees.add(new Doctor(firstName, lastName, tckno, password, age, hospital, this));
			writeDBHealthEmployee(tckno, firstName, lastName, password, age, 1, hospitalId);
		}
		if (type == 2) {
			healthEmployees.add(new Nurse(firstName, lastName, tckno, password, age, hospital, this));
			writeDBHealthEmployee(tckno, firstName, lastName, password, age, 2, hospitalId);
		}
		instertionSortHealthEmployees(healthEmployees);
		return true;
	}
	/**
	 * removes health employee
	 * @param tckno TC number of health employee
	 */
	public boolean removeHealthEmployee(String tckno) {
		for (int i = 0; i < healthEmployees.size(); i++) {
			User currentEmployee = healthEmployees.get(i);
			String existingTckno = currentEmployee.getTckNo();

			if (tckno.equals(existingTckno) == true) {
				healthEmployees.remove(i);
				rebuildDBHealthEmployee();
				return true;
			}
		}
		return false;
	}
	/**
	 * bulletin
	 */
	public void getDailyStatistics() {
		BinaryTree.Node<Patient> node = patients.getNode();

		int[] arr = new int[2];

		if (stringDailyStatistics(node, arr) != null) {
			System.out.println("Covid Patients:      " + arr[0]);
			System.out.println("Vaccinated Patients: " + arr[1]);
		}
	}
	/**
	 * prints daily statistics by traversing the tree
	 * @return for daily statistics
	 * @param node tree that stores daily statistics
	 * @param arr 
	 * 
	 */
	private int[] stringDailyStatistics(BinaryTree.Node<Patient> node, int[] arr) {
		if (node == null)
			return null;

		if (node.getData().get_isCovid()) {
			arr[0]++;
		}
		if (node.getData().get_isVaccinated()) {
			arr[1]++;
		}

		stringDailyStatistics(node.getLeft(), arr);
		stringDailyStatistics(node.getRight(), arr);

		return arr;
	}
	/**
	 * Supplys vaccine for hospital
	 * @param hospitalId hospital to be supplied
	 * @param type Vaccine Type
	 * @param num number of Vaccine
	 */
	public void supplyVaccine(String hospitalId, VaccineType type, int num) {
		ArrayList<Vaccine> vaccines = this.getHospitals().get(hospitalId).getVaccines();
		for (int i = 0; i < vaccines.size(); i++) {
			if (vaccines.get(i).getType() == type) {
				vaccines.get(i).setNumber(vaccines.get(i).getNumber() + num);
				break;
			}
		}
	}
	/**
	 * Patient register
	  * @param firstName Frist Name of new patient 
	 * @param lastName 	Last Name of new patient 
	 * @param tckno TC number of new patient
	 * @param password password of new patient 
	 * @param age	age of new patient 
	 * @param isCovid Is the patient covid or not?
	 * @param isSick Is the patient or not?
	 * @param isSmoking Does the patient smoke?
	 * @param isVaccinated Has the patient been vaccinated?
	 * @param city In which city is the patient?
	 */
	public Patient register(String firstName, String lastName, String tckno, String password, int age, boolean isCovid,
			boolean isSick, boolean isSmoking, boolean isVaccinated, String city) {

		for (Patient patient : patients) {
			if (tckno.equals(patient.getTckNo()) == true) {
				return null;
			}
		}

		Patient newPatient = new Patient(firstName, lastName, tckno, password, age, this, isCovid, isSick, isSmoking,
				isVaccinated, city, null);
		patients.add(newPatient);

		return newPatient;
	}
	/**
	 * removes patient
	 * @param tckno ID number of the patient to be deleted
	 */
	public void removePatient(String tckno) {
		for (Patient patient : patients) {
			if (patient.getTckNo().equals(tckno) == true) {
				patients.remove(patient);
				return;
			}
		}
	}
	/**
	 * patient the patient is added to the vaccination queue
	 * @param new patient
	 */
	public void vaccinationOrderAdd(Patient patient) {
		patient.getHospital().getVaccinationOrder().add(patient);
	}
	/**,
	 * access Minister
	 * @return access Minister
	 */
	public Minister getMinister() {
		return this.minister;
	}
	/**
	 * access Hospital 
	 * @return access Hospital 
	 */
	public HashMap<String, Hospital> getHospitals() {
		return this.hospitals;
	}
	/**
	 * access  Health Employees
	 * @return access  Health Employees
	 */
	public ArrayList<User> getHealthEmployees() {
		return this.healthEmployees;
	}
	/**
	 * access Vaccines
	 * @return access Vaccines
	 */
	public ArrayList<Vaccine> getVaccines() {
		return this.vaccines;
	}
	/**
	 * access Patient 
	 * @return access Patient 
	 */
	public AVLTree<Patient> getPatients() {
		return this.patients;
	}

	// burası geliştirilecek, farklı data tipleri için
	public static void getData(int hospitalId) {
		return;
	}
	/**
	 *  Used after every insertion since the employee array list is already sorted.
	 *  @param list user list
	 */
	
	private void instertionSortHealthEmployees(ArrayList<User> list) {
		for (int i = 1; i < list.size(); i++) {
			User currentEmployee = list.get(i);
			int finalIndex = i;

			int ageCurrent = currentEmployee.getAge();

			for (int j = i - 1; j >= 0; j--) {
				int ageOther = list.get(j).getAge();

				if (ageOther < ageCurrent) {
					list.set(j + 1, list.get(j));
					finalIndex = j;
				} else {
					list.set(finalIndex, currentEmployee);
					break;
				}
			}
		}
	}
	/**
	 * Used one time when the employees are read from the file
	 */
	private void mergeSortHealthEmployees(ArrayList<User> list, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex) {
			return;
		}

		int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
		mergeSortHealthEmployees(list, leftIndex, midIndex);
		mergeSortHealthEmployees(list, midIndex + 1, rightIndex);
		merge(list, leftIndex, midIndex, rightIndex);
	}
	/**
	 * For merge sort
	 */
	private void merge(ArrayList<User> list, int leftIndex, int midIndex, int rightIndex) {
		// Left and right array sizes
		int leftSize = midIndex - leftIndex + 1;
		int rightSize = rightIndex - midIndex;

		// Temp subarrays
		ArrayList<User> leftList = new ArrayList<User>(leftSize);
		ArrayList<User> rightList = new ArrayList<User>(rightSize);

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
				if (leftList.get(leftListIndex) instanceof Doctor) {
					leftAge = ((Doctor) leftList.get(leftListIndex)).getAge();
				} else if (leftList.get(leftListIndex) instanceof Nurse) {
					leftAge = ((Nurse) leftList.get(leftListIndex)).getAge();
				}

				if (rightList.get(rightListIndex) instanceof Doctor) {
					rightAge = ((Doctor) rightList.get(rightListIndex)).getAge();
				} else if (rightList.get(rightListIndex) instanceof Nurse) {
					rightAge = ((Nurse) rightList.get(rightListIndex)).getAge();
				}

				// Pick the employee with the higher age and put it in the list
				if (leftAge > rightAge) {
					list.set(i, leftList.get(leftListIndex));
					leftListIndex++;
				} else {
					list.set(i, rightList.get(rightListIndex));
					rightListIndex++;
				}
			} else if (leftListIndex < leftList.size()) {
				// If all elements have been copied from rightArray, copy rest of leftArray
				list.set(i, leftList.get(leftListIndex));
				leftListIndex++;
			} else if (rightListIndex < rightList.size()) {
				// If all elements have been copied from leftArray, copy rest of rightArray
				list.set(i, rightList.get(rightListIndex));
				rightListIndex++;
			}
		}
	}
	/**
	 * @param tckno for control TC number
	 * @param password For control password
	 */
	public User loginHealthEmployee(String tckno, String password) {

		if (this.minister.getTckNo().equals(tckno) && this.minister.getPassword().equals(password))
			return this.minister;

		Iterator<User> iter = this.healthEmployees.iterator();
		while (iter.hasNext()) {
			User hEmployee = iter.next();
			if (hEmployee.getTckNo().equals(tckno) && hEmployee.getPassword().equals(password))
				return hEmployee;
		}
		return null;
	}
	/**
	 * For user login
	 *@param tckno for control TC number
	 *@param password For control password
	 *@return patient	
	 */
	public User loginPatient(String tckno, String password) {
		Iterator<Patient> iter = this.patients.iterator();
		Patient patient;
		while (iter.hasNext()) {
			patient = iter.next();
			if (patient.getPassword().equals(password) && patient.getTckNo().equals(tckno))
				return patient;
		}
		return null;
	}
	/**
	 * generates unique key
	 * @param generate key number
	 */
	public static String generateKey(int num) {
		Random random = new Random();

		String str = "abcdefghijklmnoprstuvyzABCDEFGIJKLMNOPRSTUVYZ0123456789xqXq";
		String generated = "";

		for (int i = 0; i < num; i++)
			generated += random.nextInt(str.length());
		return generated;
	}

}