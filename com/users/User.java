package com.users;

import com.obj.Ministry;

public class User {
	protected Ministry ministry;

	private String firstName;
	private String lastName;
	private String tckno;
	private String password;
	private int age;

	public User(String firstName, String lastName, String tckno, String password, int age, Ministry ministry) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.tckno = tckno;
		this.password = password;
		this.age = age;
		this.ministry = ministry;
	}

	public User(String firstName, String lastName, String tckno, String password, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.tckno = tckno;
		this.password = password;
		this.age = age;
	}

	public boolean login(String tckno, String password) {
		if (this.tckno.equals(tckno) && this.password.equals(password)) {
			return true;
		}
		return false;
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

	public Ministry getMinistry() {
		return this.ministry;
	}

	public void setMinistry(Ministry ministry) {
		this.ministry = ministry;
	}

}