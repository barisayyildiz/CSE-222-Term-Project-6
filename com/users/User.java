package com.users;

import com.obj.Ministry;

/**
 * Holds the information for the User.
 * @author Group 6
 */
public class User {
	protected Ministry ministry;

	private String firstName;
	private String lastName;
	private String tckno;
	private String password;
	private int age;
	
	/**
	 * Constructor with parameters. Initializes all the fields for the class
	 * Calls for the parent class's constructor for give parameters
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
	 * Constructor with parameters. Initializes all the fields for the class
	 * Calls for the parent class's constructor for give parameters
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
	 * login control for users
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
	 * Getter firstName
	 * @return first name
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Getter last name
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * Getter password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Getters age
	 * @return TC no
	 */
	public String getTckNo() {
		return tckno;
	}
	/**
	 * Getters age
	 * @return Age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * Getter ministry
	 * @return Minstry
	 */
	public Ministry getMinistry() {
		return this.ministry;
	}
	/**
	 *  ministry set initialize
	 * @param new ministry
	 */
	public void setMinistry(Ministry ministry) {
		this.ministry = ministry;
	}

}