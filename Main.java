
package com.users;
import com.obj.VaccineType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
public class Main
{
	public static void main(String args[]){



	}
	public static void menu(){
		System.out.println("NE İSTİYOSUN");
		String tckno,password;
		Scanner obj=new Scanner(System.in);
		System.out.println("NESİN SEN\nHEADPYSICIAN\nDOCTOR\nNURSE\nPATIENT");
		String type=obj.nextLine();
		while(true){
			if (!(type.equals("HEADPYSICIAN") || type.equals("DOCTOR") || type.equals("NURSE") || type.equals("PATIENT")))
				System.out.println("tekrar dene");
			else
				break;
		}
		user_type tip;
		tip=user_type.valueOf(type);

		switch (tip){
			case HEADPYSICIAN:
				/*login kısmı*/
				headPhysicanPage();
			case DOCTOR:
				/*login kısmı*/
				doctorPage();
				break;

			case NURSE:
				/*login ksımı*/
				nursePage();
				break;

			case PATIENT:
				/*login kısmı*/
				patientPage();
				break;
			case MINISTER:
				/*login kısmı*/
				ministerPage();
				break;
		}


	}
	public static void ministerPage(Minister minister){
		System.out.println("Welcom to Minister Page");
		System.out.println("1 - Get hospital information");
		System.out.println("2 - Update announce daily statistics");
		System.out.println("3 - Add hospital");
		System.out.println("4 - Supply vaccines hospital");
		System.out.println("5 - Add doctor");
		System.out.println("6 - Remove doctor");
		System.out.println("7 - Remove hospital");
		System.out.println("8 - Add nurse");
		System.out.println("9 - Remove nurse");
		System.out.println("10 - Supply test to hospital");
		System.out.println("0 - Exit");
		Scanner obj=new Scanner(System.in);
		int choos= obj.nextInt();
		boolean exit=true;
		while(exit) {
			switch (choos) {
				case 1:
					System.out.println(minister.getMinistry().getHospitals());
					System.out.println("Hospital ID");
					minister.getHospitalInformation(obj.nextInt());
					break;
				case 2:
					minister.getDailyStatistics();
					break;
				case 3:
					/*yapılacak*/
					break;
				case 4:
					System.out.println("PLEASE SELECT VACCINE TYPE\nSINOVAC,\nBIOENTECH\nASTRAZENECA\nSPUTNIK\nKAYSERI");
					String type;
					while(true){
						type=obj.nextLine();
						if (!(type.equals("SINOVAC") || type.equals("BIOENTECH") || type.equals("SPUTNIK") || type.equals("ASTRAZENECA")|| type.equals("KAYSERI")))
							System.out.println("tekrar dene");
						else
							break;
					}
					VaccineType tip;
					tip=VaccineType.valueOf(type);
					System.out.println("aşı sayısı");
					int vaccnum=obj.nextInt();
					System.out.println("enter hospital id");
					int hosptid=obj.nextInt();
					minister.supplyVaccine(hosptid,tip,vaccnum);
					break;
				case 5:
					String firstName,lastName, password;
					int age;
					System.out.println("firstName=");
					firstName=obj.nextLine();
					System.out.println("lastName=");
					lastName=obj.nextLine();
					System.out.println("tckno=");
					String tc=obj.nextLine();
					System.out.println("password=");
					password=obj.nextLine();
					System.out.println("age=");
					age=obj.nextInt();
					minister.addDoctor(new)
					break;

				default:
					System.out.println("ERROR");
			}


	}

	public static void headPhysicanPage(HeadPhysician headphysician){
		System.out.println("Welcome to HeadPhysican Page");
		System.out.println("1 - Get patient information");
		System.out.println("2 - Get hospital data");
		System.out.println("3 - Input that patient is vaccinated");
		System.out.println("4 - Demand vaccines form Minister");
		System.out.println("0 - Exit");
		String tc=null;
		Scanner obj=new Scanner(System.in);
		int choos= obj.nextInt();
		boolean exit=true;
		while(exit) {
			switch (choos) {
				case 1:
					System.out.println("Patient tc");
					tc=obj.nextLine();
					headphysician.getPatientData(tc);
					break;
				case 2:
					headphysician.getHospitalData();
					break;
				case 3:
					System.out.println("Patient tc");
					tc=obj.nextLine();
					if(!headphysician.vaccinate(tc))
						System.out.println("BÖYLE BİR HASTA YOK!");
					break;
				case 4:
					System.out.println("PLEASE SELECT VACCINE TYPE\nSINOVAC,\nBIOENTECH\nASTRAZENECA\nSPUTNIK\nKAYSERI");
					String type;
					while(true){
						type=obj.nextLine();
						if (!(type.equals("SINOVAC") || type.equals("BIOENTECH") || type.equals("SPUTNIK") || type.equals("ASTRAZENECA")|| type.equals("KAYSERI")))
							System.out.println("tekrar dene");
						else
							break;
					}
					VaccineType tip;
					tip=VaccineType.valueOf(type);

					System.out.println("PLEASE enter  VACCINE number");
					obj.nextLine();
					int a=obj.nextInt();
					headphysician.demandVaccine(tip,a);
					break;
				case 0:
					System.out.println("EXIT...");
					exit=false;
					break;

				default:
					System.out.println("ERROR");
			}
		}


	}
	public static void doctorPage(Doctor doctor){
		System.out.println("Welcome to Doctor Page");
		System.out.println("1 - Add patient");
		System.out.println("2 - Remove patient");
		System.out.println("3 - Get patient Data");
		System.out.println("4 - Input that patient is vaccinated");
		System.out.println("0 - Exit");
		String tc=null;
		Scanner obj=new Scanner(System.in);
		int choos= obj.nextInt();
		boolean exit=true;
		while(exit) {
			switch (choos) {
				case 1:
					String firstName,lastName, password;
					int age;
					System.out.println("firstName=");
					firstName=obj.nextLine();
					System.out.println("lastName=");
					lastName=obj.nextLine();
					System.out.println("tckno=");
					tc=obj.nextLine();
					System.out.println("password=");
					password=obj.nextLine();
					System.out.println("age=");
					age=obj.nextInt();
					doctor.addPatient(new Patient(firstName,lastName,tc, password,age));
					break;
				case 2:
					System.out.println("Patient tc");
					tc=obj.nextLine();
					doctor.removePatient(tc);
					break;
				case 3:
					System.out.println("Patient tc");
					tc=obj.nextLine();
					doctor.getPatientData(tc);
					break;
				case 4:
					System.out.println("Patient tc");
					tc=obj.nextLine();
					if(!doctor.vaccinate(tc))
						System.out.println("BÖYLE BİR HASTA YOK!");
					break;
				case 0:
					System.out.println("EXIT...");
					exit=false;
					break;

				default:
					System.out.println("ERROR");
			}
		}

	}

	public static void nursePage(Nurse nurse){
		System.out.println("Welcome to Nurse Page");
		System.out.println("1 - Mark the test information");
		System.out.println("2 - Input that patient is vaccinated");
		System.out.println("0 - Exit");
		Scanner obj=new Scanner(System.in);
		String tc=null;
		int choos= obj.nextInt();
		boolean exit=true;
		while(exit) {
			switch (choos) {
				case 1:
					System.out.println("Patient tc");
					tc=obj.nextLine();
					System.out.println("Patient isCovid");
					Boolean isCovid=obj.nextBoolean();
					nurse.setCovidInfo(tc,isCovid);
					break;
				case 2:
					System.out.println("Patient tc");
					tc=obj.nextLine();
					nurse.vaccinate(tc);
					break;
				case 0:
					System.out.println("EXIT...");
					exit=false;
					break;
				default:
					System.out.println("ERROR");
			}
		}
	}

	public static void patientPage(Patient patient){
		System.out.println("Welcome to Patient Page");
		System.out.println("1 - Demand covid test");
		System.out.println("2 - Get personal information");
		System.out.println("0 - EXIT");
		Scanner obj=new Scanner(System.in);
		int choos= obj.nextInt();
		boolean exit=true;
		while(exit) {
			switch (choos) {
				case 1:
					patient.demandCovidTest();
					break;
				case 2:
					patient.displayData();
					break;
				case 0:
					System.out.println("EXIT...");
					exit=false;
					break;
				default:
					System.out.println("ERROR");
			}
		}
	}

}