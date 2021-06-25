package com.users;

import com.obj.*;

import java.util.*;

public class Minister extends User {

	// bildirim alma özelliği gelecek (hoca stack veri yapısı kullanılmasını
	// istiyor, burada kullanabilirsek güzel olur)

	private Stack<String> notifications; // queue de kullanabiliriz
	
	/**
	 * @param firstName Name of Minister
	 * @param lastName	Last name of Minister
	 * @param tckno	 tckno of Minister
	 * @param password	password of Minister
	 * @param age	age of Minister
	 * @param ministry	initialize Ministry
	 */
	public Minister(String firstName, String lastName, String tckno, String password, int age, Ministry ministry) {
		super(firstName, lastName, tckno, password, age, ministry); // parametreler eklenerek super metodu
																	// çalışıtırılacak
		this.notifications = new Stack<String>();
	}
	
	/**
	 * @param firstName  Name of Minister
	 * @param lastName Last name of Minister
	 * @param tckno  tckno of Minister
	 * @param password password of Minister
	 * @param age age of Minister
	 */
	public Minister(String firstName, String lastName, String tckno, String password, int age) {
		super(firstName, lastName, tckno, password, age); // parametreler eklenerek super metodu çalışıtırılacak
		this.notifications = new Stack<String>();
	}
	/**
	 * @param cityName city of hospital 
	 */
	public void addHospitals(String cityName) {
		this.ministry.addHospital(cityName);
		return;
	}
	/**
	 * @param hospitalId the id of the hospital to be deleted
	 */
	public void removeHospital(String hospitalId) {
		this.ministry.removeHospital(hospitalId);
	}
	/**
	 * @param hospitalId hospital to be supplied
	 * @param type type of vaccine
	 * @param num number of vaccine
	 */
	public void supplyVaccine(String hospitalId, VaccineType type, int num) {
		this.ministry.supplyVaccine(hospitalId, type, num);
	}
	/**
	 * @param hospitalId hospitalId to be supplied
	 * @param num number of tests
	 */
	public void supplyTest(String hospitalId, int num) {
		this.ministry.getHospitals().get(hospitalId).addTests(num);
		return;
	}
	/**
	 * @hospitalId Hospital informations
	 */
	public String getHospitalInformation(String hospitalId) {
		Hospital hospital = this.ministry.getHospitals().get(hospitalId);
		if (hospital != null)
			return hospital.toString();
		return "";
	}
	/** 
	 * @return Daily Statistics
	 */
	public void getDailyStatistics() {
		this.ministry.getDailyStatistics();
	}
	/**
	 * @return Last Mail
	 */
	public String getLastMail() {
		System.out.println(this.notifications.size());
		if (this.notifications.size() > 0)
			return this.notifications.pop();
		return "You have 0 new mail";
	}
	/**
	 * @param firstName Nmae of doctor
	 * @param lastName Last of name 
	 * @param tckno	tckno of doctor
	 * @param password password of doctor
	 * @param age age of doctor
	 */
	public boolean addDoctor(String firstName, String lastName, String tckno, String password, int age,
			String hospitalId, int type) {
		// this.ministry.getHealthEmployees().add(new Doctor(firstName, lastName, tckno,
		// password, age));
		return this.ministry.addHealthEmployee(firstName, lastName, tckno, password, age, hospitalId, type);
		// return true;
	}
	/**
	 * @param tckno tc of the doctor requested to be deleted
	 */
	public boolean removeDoctor(String tckno) {
		// this.ministry.getHealthEmployees().remove(tckno);
		return this.ministry.removeHealthEmployee(tckno);
		// return true;
	}
	/**
	 * @param firstName Name of Nurse
	 * @param lastName last name of nurse
	 * @param tckno tckno of nurse
	 * @param password password of nurse
	 * @param age age of nurse 
	 * @param hospitalId the id of the hospital where the nurse is located
	 * @param type 
	 */
	public boolean addNurse(String firstName, String lastName, String tckno, String password, int age,
			String hospitalId, int type) {
		// this.ministry.getHealthEmployees().add(new Nurse(firstName, lastName, tckno,
		// password, age));
		// return true;
		return this.ministry.addHealthEmployee(firstName, lastName, tckno, password, age, hospitalId, type);
		// return true;
	}
	/**
	 * @param tckno TC of the nurse to be deleted
	 */
	public boolean removeNurse(String tckno) {
		// this.ministry.getHealthEmployees().remove(tckno);
		return this.ministry.removeHealthEmployee(tckno);
		// return true;
	}
	/**
	 * @return Ministry
	 */
	public Ministry getMinistry() {
		return ministry;
	}
	/**
	 * @param str Notoficition
	 */
	public void addNotification(String str) {
		this.notifications.push(str);
	}
}
