package com.users;

import com.obj.*;

import java.util.*;

public class Minister extends User {

	// bildirim alma özelliği gelecek (hoca stack veri yapısı kullanılmasını istiyor, burada kullanabilirsek güzel olur)

	private Ministry ministry;

	private Stack<String> notifications; // queue de kullanabiliriz

	public Minister(Ministry ministry){
		this.ministry = ministry;
		// super(); // parametreler eklenerek super metodu çalışıtırılacak
	}

	public void addHospitals(){
		return;
	}

	public void removeHospital(int hospitalId){
		return;
	}

	public void supplyVaccine(VaccineType type, int num){
		return;
	}

	public void supplyTest(){
		return;
	}

	public String getHospitalInformation(int hospitalId){
		return "";
	}

	public void getDailyStatistics(){
		return; // output.txt 'ye günlük veriler yazılacak
	}

	public String getLastMail(){
		return ""; // en son gelen maili pop eder
	}

	public boolean addDoctor(String firstName, String lastName, String tckno, String password, int age){
		return true;
	}

	public boolean removeDoctor(String tckno){
		return true;
	}

	public boolean addNurse(String firstName, String lastName, String tckno, String password, int age){
		return true;
	}

	public boolean removeNurse(String tckno){
		return true;
	}

	

	
}
