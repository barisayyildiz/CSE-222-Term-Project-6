package com.obj;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeSet;

import com.users.*;

public class Ministry {

	private Minister minister;
	
	private ArrayList<Hospital> hospitals;
	private ArrayList<HealthEmployee> healthEmployees;
	private ArrayList<Vaccine> vaccines;
	private PriorityQueue<Integer> vaccinationOrder;
	private TreeSet<Patient> patients;
	

	// sistemde kayıtlı tüm sağlık çalışanları
	// sistemde kayıtlı tüm hastalar
	
	// sağlık çalışanları -> ArrayList
	// aşı, class -> arraylist
	// hastalar -> BST
	// aşışama sırası -> Priority Queue

	public Ministry(){
		// constructor yazılacak, txt okunacak
		this.hospitals = new ArrayList<Hospital>();
		this.healthEmployees = new ArrayList<HealthEmployee>();
		this.vaccines = new ArrayList<Vaccine>();
		this.vaccinationOrder = new PriorityQueue<Integer>();
		this.patients = new TreeSet<Patient>();
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
