package com.obj;

import java.util.ArrayList;

import com.users.*;

public class Ministry {

	private ArrayList<Hospital> hospitals;
	private Minister minister;
	

	// sistemde kayıtlı tüm sağlık çalışanları
	// sistemde kayıtlı tüm hastalar
	
	// sağlık çalışanları -> ArrayList
	// aşı, class -> arraylist
	// hastalar -> BST
	// aşışama sırası -> Priority Queue

	public Ministry(){
		// constructor yazılacak, txt okunacak
	}

	public ArrayList<Hospital> getHospitals(){
		return this.hospitals;
	}

	// burası geliştirilecek, farklı data tipleri için
	public static void getData(int hospitalId){
		return;
	}

}
