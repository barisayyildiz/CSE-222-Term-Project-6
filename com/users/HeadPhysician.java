package com.users;

import com.obj.*;

public class HeadPhysician extends Doctor{

    private Ministry ministry;
    private Minister minister;
    private Hospital hospital;

    public HeadPhysician(){
        super();
    }

    public HeadPhysician(Hospital hospital, Ministry ministry, Minister minister){
        this.ministry = ministry;
        this.hospital = hospital;
        this.minister = minister;
    }

    @Override
    public boolean vaccinate(){

        if(ministry.getVaccinationOrder().poll() != null)
            return true;
        
        return false;
    }

    void addHospitals(HeadPhysician headPhysician){
        
        ministry.getHospitals().add(new Hospital(headPhysician,ministry));
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
		
        minister.supplyVaccine(type, num);
	}

	public void sendNotification(String str){
		
        minister.addNotification(str);
	}

	public String getHospitalData(){

        String vaccineInfo = "";

        for(Vaccine vaccine : hospital.getVaccines())
            vaccineInfo += vaccine.getType() + "-> " + vaccine.getNumber() + "\n";

		return "Number of beds: " + hospital.numOfBeds() + "\n" + "Number of tests: " + hospital.numOfTests() + "\n" + "Vaccines:\n" + vaccineInfo;
	}
}
