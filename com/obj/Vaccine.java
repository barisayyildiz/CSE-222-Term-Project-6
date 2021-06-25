package com.obj;

/**
 * Holds the information for the Vaccine.
 * @author Group 6
 */
public class Vaccine {
	private int number;
	private VaccineType type;
	/**
	 * initializes the desired type and number of vaccines
	 *@param number number of Vaccine
	 *@param type type of vaccine
	 */
	public Vaccine(int number, VaccineType type){
		this.number = number;
		this.type = type;
	}
	/**
	 * set number of vaccine
	 * @param number set number
	 */
	public void setNumber(int number){
		this.number = number;
	}
	/**
	 * set type of vaccine
	 * @param type Vaccine Type
	 */
	public void setType(VaccineType type){
		this.type = type;
	}
	/**
	 * Getter number of vaccinate 
	 * @return Vaccine Number
	 */
	public int getNumber(){
		return this.number;
	}
	/**
	 * Getter vaccinate type
	 * return Vaccine Type
	 */
	public VaccineType getType(){
		return this.type;
	}
	
}
