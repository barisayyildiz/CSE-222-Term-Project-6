package com.users;

import com.obj.*;

public class Nurse extends User implements HealthEmployee
{
	private Ministry ministry;
	private Hospital hospitalId;

	public Nurse(String firstName, String lastName, String tckno, String password, int age){
		super(firstName, lastName, tckno, password, age);
		ministry = new Ministry(null);
		ministry = new Ministry(null);
		hospitalId = new Hospital(null,ministry);
	}
	
	public void test(Patient obj){

		Random rand = new Random();

		if( rand.nextBoolean() ) {
			obj.setCovidInfo(true);
		}
		else
			obj.setCovidInfo(false);
		
		return;
	}

	@Override
	public boolean vaccinate(String tckno){
		for(Patient searchedPaitent : ministry.getPatients()) {
			if(searchedPaitent.getTckNo().equals(tckno)) {
				ArrayList<Vaccine> vac = hospitalId.getVaccines();
				for(int i = 0; i < vac.size(); i++ ) {
					if( vac.get(i).getNumber() > 0 ) {
						searchedPaitent.setVaccinated(true);
						vac.get(i).setNumber( vac.get(i).getNumber() - 1 );
						return true;
					}
				}
				
			}
		}	
		return false;
	}

	public void setCovidInfo(String tckno, boolean isCovid){
		for(Patient searchedPaitent : ministry.getPatients()) {
			if(searchedPaitent.getTckNo().equals(tckno)) {
				searchedPaitent.setCovidInfo(isCovid);
			}
		}
		return;
	}

	
}
