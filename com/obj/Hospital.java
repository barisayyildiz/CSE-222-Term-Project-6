package com.obj;

import com.users.*;

public class Hospital {

	// hashcode
	private int id;

	private Ministry ministry;

	private int numOfBeds;
	private int numOfTests;


	public Hospital(Ministry ministry){
		// constructor yazılacak
		this.id = this.hashCode();
		this.ministry = ministry;
		this.numOfBeds = 100;
		this.numOfTests = 1000;

	}

	public int numOfBeds(){
		return this.numOfBeds;
	}

	public int numOfTests(){
		return this.numOfTests;
	}
	
}


