package com.users;

import com.obj.Hospital;
import com.obj.Ministry;

import java.util.Random;

/**
 * Holds the information of patients.
 * Implements functions from User and Comparable
 * @author Group 6
 */
public class Patient extends User implements Comparable<Patient> {
	
	/** Holds the information that wheter the patient smokes or not 
	 * <p> It does not have an initial value
	 */
	private boolean isSmoking;
	/** Holds the information that wheter the patient is vaccinated or not 
	 * <p> It does not have an initial value
	 */
	private boolean isVaccinated;
	/** Holds the information that wheter the patient is covid positive or not 
	 * <p> It does not have an initial value
	 */
	private boolean isCovid;
	/** Holds the information that wheter the patient is sick or not 
	 * <p> It does not have an initial value
	 */
	private boolean isSick;
	/** Holds the information of patient for vaccination prioty
	 * <p> It's initial value defined by class parameters
	 */
	private int score;
	/** Holds the information that wheter the patient spending the lockdown at house or at hospital 
	 * <p> It does not have an initial value
	 */
	private boolean state;
	/** Holds the information of the city they live in  
	 * <p> It does not have an initial value
	 */
	private String city;
	/** Holds the information of the closest hospital objecy 
	 * <p> It does not have an initial value
	 */
	private Hospital hospital;

	/**
	 * Constructor with parameters. Initializes all the fields for the class
	 * Calls for the parent class's constructor for give parameters
	 * @param firstName firstName to set for this class
	 * @param lastName lastName to set for this class
	 * @param tckno tckno to set for this class
	 * @param password password to set for this class
	 * @param age age to set for this class
	 * @param ministry ministry to set for this class
	 * @param isCovid isCovid to set for this class
	 * @param isSick isSick to set for this class
	 * @param isSmoking isSmoking to set for this class
	 * @param city city to set for this class
	 * @param hospital hospital to set for this class
	 */
	public Patient(String firstName, String lastName, String tckno, String password, int age, Ministry ministry, boolean isCovid, boolean isSick, boolean isSmoking, boolean isVaccinated, String city, Hospital hospital){
		super(firstName,lastName,tckno,password,age,ministry);
		score=getAge();
		this.isCovid = isCovid;
		this.isSick = isSick;
		this.isSmoking = isSmoking;
		this.isVaccinated = isVaccinated;
		this.city = city;
		this.hospital = hospital;
	}

	/**
	 * Function for to determine the score of the patient and set it to prioty queue.
	 */
	public void getInQueue(){

		if(isSmoking)
			score-=10;
		if(isSick)
			score+=50;
		if(isCovid)
			score-=100;
		ministry.vaccinationOrderAdd(this);
	}

	/**
	 * Returns the of the patient
	 * @return String return overrided toString method
	 */
	public String displayData(){
		return this.toString();
	}

	/**
	 * Overrided toString method returns a custom String data for this class
	 * @return sb returns a string that has the patients information
	 */
	@Override // get personal information
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append("****PERSONAL INFORMATION****" + "\n");
		sb.append("Name= "+getFirstName() + "\n");
		sb.append("Surname= "+getLastName() + "\n");
		sb.append("TCKNO= "+getTckNo() + "\n");
		sb.append("SMOKE= "+get_isSmoking() + "\n");
		sb.append("VACCINATE= "+get_isVaccinated() + "\n");
		sb.append("SICK= "+get_isSick() + "\n");
		sb.append("COVID= "+get_isCovid() + "\n");
		return sb.toString();
	}

	/**
	 * Sets a covid boolean status in a randomized fashion.
	 * Also displays the result.
	 */
	public void demandCovidTest(){
		Random r=new Random();
		int a=r.nextInt(10);
		if(a%2==0)
			System.out.println("covid test result -> positive");
		else
			System.out.println("covid test result -> negative");
	}

	/**
	 * Getter for isSmoking parameter
	 * @return isSmoking data for patients smoking status
	 */
	public boolean get_isSmoking(){
		return isSmoking;
	}

	/**
	 * Getter for isVaccinated parameter
	 * @return isVaccinated data for patients vaccination status
	 */
	public boolean get_isVaccinated(){
		return isVaccinated;
	}

	/**
	 * Getter for isCovid parameter
	 * @return isCovid data for patients covid status
	 */
	public boolean get_isCovid(){
		return isCovid;
	}

	/**
	 * Getter for isSick parameter
	 * @return isSick data for patients illness status
	 */
	public boolean get_isSick(){
		return isSick;
	}

	/**
	 * Getter for state parameter
	 * @return state data for patients lockdown status
	 */
	public boolean get_state(){
		return state;
	}

	/**
	 * Getter for city parameter
	 * @return isCovid data for patients city they live in
	 */
	public String getCity(){
		return city;
	}

	/**
	 * Setter for isSmoking parameter
	 * @param isSmoking sets the data for patients smoking status
	 */
	public void setSmoking(boolean isSmoking ){
		this.isSmoking=isSmoking;
	}

	/**
	 * Setter for isVaccinated parameter
	 * @param isVaccinated sets the data for patients vaccination status
	 */
	public void setIsVaccinated(boolean isVaccinated){
		this.isVaccinated=isVaccinated;
	}

	/**
	 * Setter for isCovid parameter
	 * @param isCovid sets the data for patients covid status
	 */
	public void setCovid(boolean isCovid){
		this.isCovid=isCovid;
	}

	/**
	 * Setter for isSick parameter
	 * @param isSick sets the data for patients sickness status
	 */
	public void setSick(boolean isSick){
		this.isSick=isSick;
	}

	/**
	 * Setter for state parameter
	 * @param state sets the data for patients city that they live in
	 */
	public void setState(boolean state){
		this.state=state;
	}

	/**
	 * Getter for hospital parameter
	 * @return hospital data for patients closest hospital where they live in
	 */
	public Hospital getHospital(){
		return this.hospital;
	}

	/**
	 * Overrided compareTo method for this class
	 * Compares two different patients scores
	 * @param o patient that will compared to
	 * @return 1 if current score greater than other patients score, 0 if equal and -1 if lesser than
	 */
	@Override
	public int compareTo(Patient o) {
		if(score>o.score)
			return 1;
		else if(score==o.score)
			return 0;
		else
			return -1;
	}
}