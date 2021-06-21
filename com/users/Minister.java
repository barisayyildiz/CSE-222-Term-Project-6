package com.users;

import com.obj.*;

import java.util.*;

public class Minister extends User {

	// bildirim alma özelliği gelecek (hoca stack veri yapısı kullanılmasını istiyor, burada kullanabilirsek güzel olur)


	private Stack<String> notifications; // queue de kullanabiliriz

	public Minister(String firstName, String lastName, String tckno, String password, int age, Ministry ministry){
		super(firstName, lastName, tckno, password, age, ministry);  // parametreler eklenerek super metodu çalışıtırılacak
	}

	public Minister(String firstName, String lastName, String tckno, String password, int age){
		super(firstName, lastName, tckno, password, age);  // parametreler eklenerek super metodu çalışıtırılacak
	}

	public void addHospitals(){
		return;
	}

	public void removeHospital(int hospitalId){
		this.ministry.getHospitals().remove(hospitalId);
	}

	public void supplyVaccine(int hospitalId, VaccineType type, int num){
		ArrayList<Vaccine> vaccines = this.ministry.getHospitals().get(hospitalId).getVaccines();
		for(int i=0; i<vaccines.size(); i++){
			if(vaccines.get(i).getType() == type){
				vaccines.get(i).setNumber(vaccines.get(i).getNumber() + num);
				break;
			}
		}
	}

	public void supplyTest(int hospitalId, int num){
		this.ministry.getHospitals().get(hospitalId).addTests(num);
		return;
	}

	public String getHospitalInformation(int hospitalId){
		return this.ministry.getHospitals().get(hospitalId).toString();
	}

	public void getDailyStatistics(){
		 this.ministry.getDailyStatistics();
	}

	public String getLastMail(){
		return this.notifications.pop();
	}

	public boolean addDoctor(String firstName, String lastName, String tckno, String password, int age){
		// this.ministry.getHealthEmployees().add(new Doctor(firstName, lastName, tckno, password, age));
		return this.ministry.addDoctor(firstName, lastName, tckno, password, age);
		// return true;
	}

	public boolean removeDoctor(String tckno){
		this.ministry.getHealthEmployees().remove(tckno);
		return true;
	}

	public boolean addNurse(String firstName, String lastName, String tckno, String password, int age){
		// this.ministry.getHealthEmployees().add(new Nurse(firstName, lastName, tckno, password, age));
		// return true;
		return this.ministry.addNurse(firstName, lastName, tckno, password, age);
	}

	public boolean removeNurse(String tckno){
		this.ministry.getHealthEmployees().remove(tckno);
		return true;
	}

	public Ministry getMinistry() {
		return ministry;
	}
}
