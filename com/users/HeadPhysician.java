package com.users;

import com.obj.*;

public class HeadPhysician extends Doctor{

	public HeadPhysician(String firstName, String lastName, String tckno, String password, int age, Hospital hospital, Ministry ministry){
		super(firstName, lastName, tckno, password, age, hospital, ministry);
	}

	@Override
	public boolean vaccinate(){
		if(this.hospital.getVaccinationOrder().peek() != null){
			this.hospital.getVaccinationOrder().peek().setIsVaccinated(true);
			this.hospital.getVaccinationOrder().poll();
			return true;
		}
		return false;
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
	}

	public void sendNotification(String str){
		this.ministry.getMinister().addNotification(str);
	}

	public String getHospitalData(){

		return this.hospital.toString();

	}
}
