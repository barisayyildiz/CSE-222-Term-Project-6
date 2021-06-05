package com.obj;

import com.users.*;
import java.util.ArrayList;

public class Hospital {

	// hashcode
	private int id;
	private Ministry ministry;
	private HeadPhysician headPhysician;

	private int numOfBeds;
	private int numOfTests;
	// aşı tipleri ve sayılarını içeren 2d bir array yazılacak

	private ArrayList<Vaccine> vaccines;


	public Hospital(HeadPhysician headPhysician, Ministry ministry){
		this.id = this.hashCode();
		this.ministry = ministry;
		this.numOfBeds = 100;
		this.numOfTests = 1000;
		this.headPhysician = headPhysician;
		
		// aşılar eklendi
		this.vaccines = new ArrayList<Vaccine>();
		this.vaccines.add(new Vaccine(100, VaccineType.ASTRAZENECA));
		this.vaccines.add(new Vaccine(100, VaccineType.BIOENTECH));
		this.vaccines.add(new Vaccine(100, VaccineType.KAYSERI));
		this.vaccines.add(new Vaccine(100, VaccineType.SINOVAC));
		this.vaccines.add(new Vaccine(100, VaccineType.SPUTNIK));

	}

	public int numOfBeds(){
		return this.numOfBeds;
	}

	public int numOfTests(){
		return this.numOfTests;
	}

	public void addTests(int num){
		this.numOfTests += num;
	}

	public ArrayList<Vaccine> getVaccines(){
		return this.vaccines;
	}

	@Override
	public String toString(){
		String str = "";

		str += "Head Physician : " + this.headPhysician.toString() + "\n";
		str += "Number of beds : " + this.numOfBeds + "\n";
		str += "Number of tests : " + this.numOfTests;

		return str;
	}
	
}


