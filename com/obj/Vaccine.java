package com.obj;

public class Vaccine {
	private int number;
	private VaccineType type;

	public Vaccine(int number, VaccineType type){
		this.number = number;
		this.type = type;
	}

	public void setNumber(int number){
		this.number = number;
	}

	public void setType(VaccineType type){
		this.type = type;
	}

	public int getNumber(){
		return this.number;
	}

	public VaccineType getType(){
		return this.type;
	}
	
}
