package com.obj;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeSet;

// File Handling
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.users.*;

public class Ministry {

	private Minister minister;
	
	private ArrayList<Hospital> hospitals;
	private ArrayList<HealthEmployee> healthEmployees;
	private ArrayList<Vaccine> vaccines;
	private PriorityQueue<Integer> vaccinationOrder;
	private TreeSet<Patient> patients;
	

	public Ministry(Minister minister){
		// constructor yazılacak, txt okunacak...
		this.minister = minister;

		this.hospitals = new ArrayList<Hospital>();
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

	public Minister getMinister(){
		return this.minister;
	}

	public ArrayList<Hospital> getHospitals(){
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
