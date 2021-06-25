package com.users;

import com.obj.Hospital;
import com.obj.Ministry;

import java.util.Random;

public class Patient extends User implements Comparable<Patient> {
	
	private boolean isSmoking;
	private boolean isVaccinated;
	private boolean isCovid;
	private boolean isSick;
	private int score;
	private boolean state; // 0 -> evde, 1 -> hastanede (covid + ise)
	private String city;
	private Hospital hospital;

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

	public void getInQueue(){

		if(isSmoking)
			score-=10;
		if(isSick)
			score+=50;
		if(isCovid)
			score-=100;
		ministry.vaccinationOrderAdd(this);
	}

	public String displayData(){
		return this.toString();
	}

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

	public void demandCovidTest(){
		Random r=new Random();
		int a=r.nextInt(10);
		if(a%2==0)
			System.out.println("covid test result -> positive");
		else
			System.out.println("covid test result -> negative");
	}

	public boolean get_isSmoking(){
		return isSmoking;
	}
	public boolean get_isVaccinated(){
		return isVaccinated;
	}
	public boolean get_isCovid(){
		return isCovid;
	}
	public boolean get_isSick(){
		return isSick;
	}
	public boolean get_state(){
		return state;
	}
	public String getCity(){
		return city;
	}

	public void setSmoking(boolean isSmoking ){
		this.isSmoking=isSmoking;
	}
	public void setIsVaccinated(boolean isVaccinated){
		this.isVaccinated=isVaccinated;
	}
	public void setCovid(boolean isCovid){
		this.isCovid=isCovid;
	}
	public void setSick(boolean isSick){
		this.isSick=isSick;
	}
	public void setState(boolean state){
		this.state=state;
	}

	public Hospital getHospital(){
		return this.hospital;
	}

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