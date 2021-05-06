package com.users;

import com.obj.*;

public class Minister extends User {

	// bildirim alma özelliği gelecek (hoca stack veri yapısı kullanılmasını istiyor, burada kullanabilirsek güzel olur)

	public Minister(Ministry ministry){
		this.ministry = ministry;
		// super(); // parametreler eklenerek super metodu çalışıtırılacak
	}

	public void addHospitals(){
		return;
	}

	public void supplyVaccine(){
		return;
	}

	public void supplyTest(){
		return;
	}

	
}
