package com.users;

import com.obj.Ministry;

public class User {
	protected Ministry ministry;

	private String firstName;
	private String lastName;
	private String tckno;
	private String password;
	private int age;
	
	/**
	 * @param firstName Name of user
	 * @param lastName	Last Name of user	
	 * @param tckno	TC number of user
	 * @param password password of user
	 * @param age age of user 
	 * @param ministry initialize ministry
	 */
	public User(String firstName, String lastName, String tckno, String password, int age, Ministry ministry) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.tckno = tckno;
		this.password = password;
		this.age = age;
		this.ministry = ministry;
	}
	/**
	 * @param firstName Name of user
	 * @param lastName	Last Name of user	
	 * @param tckno	TC number of user
	 * @param password password of user
	 * @param age of user
	 */
	public User(String firstName, String lastName, String tckno, String password, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.tckno = tckno;
		this.password = password;
		this.age = age;
	}
	/**
	 * @param tckno TC for login
	 * @param password Password for login
	 */
	public boolean login(String tckno, String password) {
		if (this.tckno.equals(tckno) && this.password.equals(password)) {
			return true;
		}
		return false;
	}
	/**
	 * @return first name
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @return TC no
	 */
	public String getTckNo() {
		return tckno;
	}
	/**
	 * @return Age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @return Minstry
	 */
	public Ministry getMinistry() {
		return this.ministry;
	}
	/**
	 * @param ministry set initialize
	 */
	public void setMinistry(Ministry ministry) {
		this.ministry = ministry;
	}

}