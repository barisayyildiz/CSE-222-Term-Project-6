package com.users;

import com.obj.*;

import java.util.Random;

public class Nurse extends User implements HealthEmployee {
	private Hospital hospital;

	public Nurse(String firstName, String lastName, String tckno, String password, int age, Hospital hospital,
			Ministry ministry) {
		super(firstName, lastName, tckno, password, age, ministry);
		this.hospital = hospital;
		// hospitalId = new Hospital(null,ministry);
	}

	private boolean test() {
		Random rand = new Random();
		return rand.nextBoolean();
	}

	@Override
	public boolean vaccinate() {
		if (this.hospital.getVaccinationOrder().peek() != null) {
			this.hospital.getVaccinationOrder().peek().setIsVaccinated(true);
			this.hospital.getVaccinationOrder().poll();
			return true;
		}
		return false;
	}

	public void setCovidInfo(String tckno) {
		for (Patient searchedPaitent : ministry.getPatients()) {
			if (searchedPaitent.getTckNo().equals(tckno)) {
				searchedPaitent.setCovid(this.test());
			}
		}
		return;
	}

	@Override
	public String toString() {
		String str = "";
		str += this.getTckNo() + "," + this.getFirstName() + "," + this.getLastName() + "," + this.getPassword() + ","
				+ this.getAge() + "," + "2," + this.hospital.getID();
		return str;
	}

}
