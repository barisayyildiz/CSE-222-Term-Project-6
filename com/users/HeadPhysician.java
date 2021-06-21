package com.users;

import com.obj.*;

public class HeadPhysician extends Doctor{

	private Hospital hospital;

	public HeadPhysician(String firstName, String lastName, String tckno, String password, int age, Hospital hospital, Ministry ministry, Minister minister){
		super(firstName, lastName, tckno, password, age, ministry, hospital);
		this.ministry = ministry;
		this.hospital = hospital;
	}

	@Override
	public boolean vaccinate(){

			if(ministry.getVaccinationOrder().poll() != null)
					return true;

			return false;
	}

	void addHospitals(HeadPhysician headPhysician){

			ministry.getHospitals().add(new Hospital(headPhysician,ministry, Ministry.generateKey(8)));
	}

	void removeHospital(int hospitalId){

			for(int i=0;i<ministry.getHospitals().size();i++)
					if(hospitalId == ministry.getHospitals().get(i).getID())
							ministry.getHospitals().remove(i);
	}

	int supplyVaccine(VaccineType type, int num){

			for(Vaccine vaccine : hospital.getVaccines()){
					if(vaccine.getType().equals(type)){
							vaccine.setNumber(vaccine.getNumber() + num);
							return num;
					}
			}

			hospital.getVaccines().add(new Vaccine(num,type));

			return num;
	}

	void supplyTest(){

			hospital.setNumOfTests(hospital.numOfTests() + 100);
	}

	public void demandVaccine(VaccineType type, int num){

		String str = String.valueOf(num) + " of " + String.valueOf(type) + " needed\n";
		this.ministry.getMinister().addNotification(str);
			// minister.supplyVaccine(type, num);
	}

	public void sendNotification(String str){
		this.ministry.getMinister().addNotification(str);
	}

	public String getHospitalData(){

			String vaccineInfo = "";

			for(Vaccine vaccine : hospital.getVaccines())
					vaccineInfo += vaccine.getType() + "-> " + vaccine.getNumber() + "\n";

			return "Number of beds: " + hospital.numOfBeds() + "\n" + "Number of tests: " + hospital.numOfTests() + "\n" + "Vaccines:\n" + vaccineInfo;
	}
}
