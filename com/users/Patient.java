package com.users;

public class Patient extends User {
	
	private boolean isSmoking;
	private boolean isVaccinated;
	private boolean isCovid;
	private boolean isSick;
	private int score;
	private boolean state; // 0 -> evde, 1 -> hastanede (covid + ise)

	public Patient(String firstName, String lastName, String tckno, String password, int age){
		super(firstName,lastName,tckno,password,age);
	}

	public void getInQueue(){

		return;
	}

	public void displayData(){
		toString();
	}

	@Override // get personal information
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append("****PERSONAL INFORMATION****");
		sb.append("Name= "+getFirstName());
		sb.append("Surname= "+getLastName());
		sb.append("TCKNO= "+getTckNo());
		sb.append("SOMOKE= "+get_isSmoking());
		sb.append("VACCINATE= "+get_isVaccinated());
		sb.append("SICK= "+get_isSick());
		sb.append("COVID= "+get_isCovid());
		return sb.toString();
	}

	public void demandCovidTest(){
		System.out.println("covid test requested..\n");
		Random r=new Random();
		int a=r.nextInt(10);
		if(a%2==0)
			System.out.println("result= positive");
		else
			System.out.println("result= negative");
	}

	public boolean get_isSmoking(){
		return isSmoking;
	}
	public boolean get_isVaccinated(){
		return isSmoking;
	}
	public boolean get_isCovid(){
		return isSmoking;
	}
	public boolean get_isSick(){
		return isSmoking;
	}
	public boolean get_state(){
		return state;
	}

	public void setSmoking(boolean isSmoking ){
		this.isSmoking=isSmoking;
	}
	public void setIsVaccinated(boolean isVaccinated){
		this.isVaccinated=isVaccinated;
	}
	public void setCovid(boolean isCovid){
		this.isCovid=isCovid;
	}
	public void setSick(boolean isSick){
		this.isSick=isSick;
	}
	public void setState(boolean state){
		this.state=state;
	}

}
