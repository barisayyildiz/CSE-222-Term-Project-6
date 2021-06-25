package com.obj;

public class Vaccine {
	private int number;
	private VaccineType type;
	/**
	 *@param number number of Vaccine
	 *@param type type of vaccine
	 */
	public Vaccine(int number, VaccineType type){
		this.number = number;
		this.type = type;
	}
	/**
	 * @param number set number
	 */
	public void setNumber(int number){
		this.number = number;
	}
	/**
	 * @param type Vaccine Type
	 */
	public void setType(VaccineType type){
		this.type = type;
	}
	/**
	 * @return Vaccine Number
	 */
	public int getNumber(){
		return this.number;
	}
	/**
	 * return Vaccine Type
	 */
	public VaccineType getType(){
		return this.type;
	}
	
}
