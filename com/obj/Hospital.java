package com.obj;

import com.users.*;

public class Hospital {

	// hashcode
	private int id;

	private Ministry ministry;

	private HeadPhysician headPhysician;

	private int numOfBeds;
	private int numOfTests;
	// aşı tipleri ve sayılarını içeren 2d bir array yazılacak


	public Hospital(HeadPhysician headPhysician, Ministry ministry){
		// constructor yazılacak
		this.id = this.hashCode();
		this.ministry = ministry;
		this.numOfBeds = 100;
		this.numOfTests = 1000;
		this.headPhysician = headPhysician;

	}

	public int numOfBeds(){
		return this.numOfBeds;
	}

	public int numOfTests(){
		return this.numOfTests;
	}
	
}


