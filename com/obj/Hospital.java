package com.obj;

import com.users.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Holds the information for the Hospital.
 * @author Group 6
 */
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
	 * Constructor with parameters. Initializes all the fields for the class
	 * Calls for the parent class's constructor for give parameters
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
	 * number of beds
	 * @return number of beds
	 */
	public int numOfBeds() {
		return this.numOfBeds;
	}
	/**
	 * number of tests
	 * @return number of tests
	 */
	public int numOfTests() {
		return this.numOfTests;
	}

	/**
	 * Adding new test
	 * @param number of tests
	 */
	public void addTests(int num) {
		this.numOfTests += num;
	}
	/**
	 * list of vaccines
	 * @return vaccine list
	 */
	public ArrayList<Vaccine> getVaccines() {
		return this.vaccines;
	}
	/**
	 * Setting number of tests
	 * @param number of tests
	 */
	public void setNumOfTests(int numOfTests) {
		this.numOfTests = numOfTests;
	}
	/**
	 * Getter number of tests
	 * @return Number of Tests
	 */
	public int getNumOfTests(){
		return this.numOfTests;
	}
	/**
	 * Getter Id
	 * @return Hopital id
	 */
	public String getID() {
		return id;
	}
	/**
	 * Set new Head Physician
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
	 * Set new city
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Getter city
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * to view all the information on the hospital
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
