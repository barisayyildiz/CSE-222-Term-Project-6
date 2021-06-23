package com.users;

import com.obj.*;

import java.util.*;

public class Minister extends User {

	// bildirim alma özelliği gelecek (hoca stack veri yapısı kullanılmasını
	// istiyor, burada kullanabilirsek güzel olur)

	private Stack<String> notifications; // queue de kullanabiliriz

	public Minister(String firstName, String lastName, String tckno, String password, int age, Ministry ministry) {
		super(firstName, lastName, tckno, password, age, ministry); // parametreler eklenerek super metodu
																	// çalışıtırılacak
		this.notifications = new Stack<String>();
	}

	public Minister(String firstName, String lastName, String tckno, String password, int age) {
		super(firstName, lastName, tckno, password, age); // parametreler eklenerek super metodu çalışıtırılacak
		this.notifications = new Stack<String>();
	}

	public void addHospitals(String cityName) {
		this.ministry.addHospital(cityName);
		return;
	}

	public void removeHospital(String hospitalId) {
		this.ministry.removeHospital(hospitalId);
	}

	public void supplyVaccine(String hospitalId, VaccineType type, int num) {
		ArrayList<Vaccine> vaccines = this.ministry.getHospitals().get(hospitalId).getVaccines();
		for (int i = 0; i < vaccines.size(); i++) {
			if (vaccines.get(i).getType() == type) {
				vaccines.get(i).setNumber(vaccines.get(i).getNumber() + num);
				break;
			}
		}
	}

	public void supplyTest(String hospitalId, int num) {
		this.ministry.getHospitals().get(hospitalId).addTests(num);
		return;
	}

	public String getHospitalInformation(String hospitalId) {
		Hospital hospital = this.ministry.getHospitals().get(hospitalId);
		if (hospital != null)
			return hospital.toString();
		return "";
	}

	public void getDailyStatistics() {
		this.ministry.getDailyStatistics();
	}

	public String getLastMail() {
		System.out.println(this.notifications.size());
		if (this.notifications.size() > 0)
			return this.notifications.pop();
		return "You have 0 new mail";
	}

	public boolean addDoctor(String firstName, String lastName, String tckno, String password, int age,
			String hospitalId, int type) {
		// this.ministry.getHealthEmployees().add(new Doctor(firstName, lastName, tckno,
		// password, age));
		return this.ministry.addHealthEmployee(firstName, lastName, tckno, password, age, hospitalId, type);
		// return true;
	}

	public boolean removeDoctor(String tckno) {
		// this.ministry.getHealthEmployees().remove(tckno);
		return this.ministry.removeHealthEmployee(tckno);
		// return true;
	}

	public boolean addNurse(String firstName, String lastName, String tckno, String password, int age,
			String hospitalId, int type) {
		// this.ministry.getHealthEmployees().add(new Nurse(firstName, lastName, tckno,
		// password, age));
		// return true;
		return this.ministry.addHealthEmployee(firstName, lastName, tckno, password, age, hospitalId, type);
		// return true;
	}

	public boolean removeNurse(String tckno) {
		// this.ministry.getHealthEmployees().remove(tckno);
		return this.ministry.removeHealthEmployee(tckno);
		// return true;
	}

	public Ministry getMinistry() {
		return ministry;
	}

	public void addNotification(String str) {
		this.notifications.push(str);
	}
}
