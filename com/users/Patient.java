package com.users;

public class Patient extends User {
	
	private boolean isSmoking;
	private boolean isVaccinated;
	private boolean isCovid;
	private boolean isSick;
	private int score;
	private boolean state; // 0 -> evde, 1 -> hastanede (covid + ise)

	public Patient(){
		super();
	}

	public void getInQueue(){
		return;
	}

	public void displayData(){
		return;
	}

	
}
