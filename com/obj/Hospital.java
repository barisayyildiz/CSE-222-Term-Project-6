package com.obj;

import com.users.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Hospital {

	// hashcode
	private String id;
	private Ministry ministry;
	private HeadPhysician headPhysician;

	private int numOfBeds;
	private int numOfTests;
	private String city;
	// aşı tipleri ve sayılarını içeren 2d bir array yazılacak

	private ArrayList<Vaccine> vaccines;
	private PriorityQueue<Patient> vaccinationOrder;

	/**
	 * @param headPhysician Initialize HeadPhysician
	 * @param ministry Initialize ministry
	 * @param city city where the hospital is located
	 * @param id id of hospital
	 */
	public Hospital(HeadPhysician headPhysician, Ministry ministry, String city, String id) {
		this.id = id;
		this.ministry = ministry;
		this.numOfBeds = 100;
		this.numOfTests = 1000;
		this.headPhysician = headPhysician;
		this.city = city;
		this.vaccinationOrder = new PriorityQueue<Patient>();

		// aşılar eklendi
		this.vaccines = new ArrayList<Vaccine>();
		this.vaccines.add(new Vaccine(100, VaccineType.ASTRAZENECA));
		this.vaccines.add(new Vaccine(100, VaccineType.BIOENTECH));
		this.vaccines.add(new Vaccine(100, VaccineType.KAYSERI));
		this.vaccines.add(new Vaccine(100, VaccineType.SINOVAC));
		this.vaccines.add(new Vaccine(100, VaccineType.SPUTNIK));

	}
	/**
	 * @return number of beds
	 */
	public int numOfBeds() {
		return this.numOfBeds;
	}
	/**
	 * @return number of tests
	 */
	public int numOfTests() {
		return this.numOfTests;
	}

	/**
	 * @return Adding new test
	 */
	public void addTests(int num) {
		this.numOfTests += num;
	}
	/**
	 * @return vaccine list
	 */
	public ArrayList<Vaccine> getVaccines() {
		return this.vaccines;
	}
	/**
	 * @param Set number of tests
	 */
	public void setNumOfTests(int numOfTests) {
		this.numOfTests = numOfTests;
	}
	/**
	 * @return Number of Tests
	 */
	public int getNumOfTests(){
		return this.numOfTests;
	}
	/**
	 * @return Hopital id
	 */
	public String getID() {
		return id;
	}
	/**
	 * @param hPhysician new  HeadPhysician
	 */
	public void setHeadPhysician(HeadPhysician hPhysician) {
		this.headPhysician = hPhysician;
	}
	/**
	 * @return  Vaccination Order
	 */
	public PriorityQueue<Patient> getVaccinationOrder() {
		return this.vaccinationOrder;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @return all information about the hospital
	 */
	@Override
	public String toString() {
		String str = "", vaccineInfo = "";

		for (Vaccine vaccine : this.getVaccines())
			vaccineInfo += vaccine.getType() + "-> " + vaccine.getNumber() + "\n";
		
		str += "Hospital Id : " + this.id + "\n";
		str += "Head Physician : " + this.headPhysician.getFirstName() + " " + this.headPhysician.getLastName() + "\n";
		str += "Number of beds : " + this.numOfBeds + "\n";
		str += "Number of tests : " + this.numOfTests + "\n";
		str += "City : " + this.city + "\n";
		str += "Number of patients in the vaccination queue : " + this.vaccinationOrder.size() + "\n";
		str += "Vaccine info : \n";
		str += vaccineInfo;

		return str;
	}

}
