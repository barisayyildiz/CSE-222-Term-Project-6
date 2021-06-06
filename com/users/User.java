package com.users;

class User
{
	private Ministry ministry;

	private String firstName;
	private String lastName;
	private String tckno;
	private String password;
	private int age;
	// enum -> user type

	public User(String firstName, String lastName, String tckno, String password, int age){
		// constructor yazılacak
	}

	public boolean login(String tckno, String password){
		return true;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPassword() {
		return password;
	}
	public String getTckNo() {
		return tckno;
	}
	public int getAge() {
		return age;
	}
	

}