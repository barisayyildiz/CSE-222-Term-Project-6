
import com.obj.*;
import com.users.*;
import com.data_structures.graphs.*;
import com.data_structures.trees.*;
import java.util.Scanner;


public class Main
{
	public static void main(String args[]){



	}

	public static void menu(){

		Ministry ministry = new Ministry(new Minister("john", "doe", "01234567890", "asdqwe", 55));

		System.out.println("Welcome to the COVID Management System\n");
		String tckno, password;
		String type;
		Scanner scanner = new Scanner(System.in);

		Minister minister;
		Nurse nurse;
		Doctor doctor;
		HeadPhysician headPhysician;


		System.out.println("Choose user type : ");
		System.out.println("1. Health Employee");
		System.out.println("2. Patient");
		
		while(true){
			type = scanner.next();
			if(!type.equals("1") || type.equals("2")){
				System.out.println("Try again...");
				continue;
			}
			break;			
		}

		if(type.compareTo("1") == 0){
			while(true){
				System.out.print("\nTCKNO : ");
				tckno = scanner.nextLine();
				System.out.print("Password : ");
				password = scanner.nextLine();
	
				User user = ministry.loginHealthEmployee(tckno, password);
	
				minister = (Minister)user;
				nurse = (Nurse)user;
				doctor = (Doctor)user;
				headPhysician = (HeadPhysician)user;
				if(minister != null){
					System.out.println("you are a minister");
					ministerPage(minister);
					break;
				}else if(nurse != null){
					System.out.println("you are a nurse");
					nursePage(nurse);
					break;
				}else if(doctor != null){
					System.out.println("you are a doctor");
					doctorPage(doctor);
					break;
				}else if(headPhysician != null){
					System.out.println("you are a headphysician");
					headPhysicanPage(headPhysician);
					break;
				}else{
					System.out.println("User not found...");
					continue;
				}
			}
		}else if(type.compareTo("2") == 0){
			while(true){
				System.out.print("\nTCKNO : ");
				tckno = scanner.nextLine();
				System.out.print("Password : ");
				password = scanner.nextLine();
	
				User user = ministry.loginHealthEmployee(tckno, password);
				Patient patient = (Patient)user;
				if(patient != null){
					System.out.println("You are a patient");
					patientPage(patient);
					break;
				}else{
					System.out.println("Patient not found");
					continue;
				}
			}
		}

		scanner.close();

	}


	// public static void menu(){
	// 	System.out.println("NE İSTİYOSUN");
	// 	String tckno,password;
	// 	Scanner obj=new Scanner(System.in);
	// 	System.out.println("NESİN SEN\nHEADPYSICIAN\nDOCTOR\nNURSE\nPATIENT");
	// 	String type=obj.nextLine();
	// 	while(true){
	// 		if (!(type.equals("HEADPYSICIAN") || type.equals("DOCTOR") || type.equals("NURSE") || type.equals("PATIENT")))
	// 			System.out.println("tekrar dene");
	// 		else
	// 			break;
	// 	}
	// 	user_type tip;
	// 	tip=user_type.valueOf(type);

	// 	switch (tip){
	// 		case HEADPYSICIAN:
	// 			/*login kısmı*/
	// 			headPhysicanPage();
	// 		case DOCTOR:
	// 			/*login kısmı*/
	// 			doctorPage();
	// 			break;

	// 		case NURSE:
	// 			/*login ksımı*/
	// 			nursePage();
	// 			break;

	// 		case PATIENT:
	// 			/*login kısmı*/
	// 			patientPage();
	// 			break;
	// 		case MINISTER:
	// 			/*login kısmı*/
	// 			ministerPage();
	// 			break;
	// 	}


	// }

	
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
		String firstName,lastName, password,tc;
		int age;
		while(exit) {
			switch (choos) {
				case 1:
					System.out.println(minister.getMinistry().getHospitals());
					System.out.println("Hospital ID");
					System.out.println(minister.getHospitalInformation(obj.nextInt()));
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
					minister.addDoctor(firstName,lastName,tc,password,age);
					break;
				case 6:
					System.out.println("tckno=");
					tc=obj.nextLine();
					minister.removeDoctor(tc);
					break;
				case 7:
					System.out.println(minister.getMinistry().getHospitals());
					int num=obj.nextInt();
					minister.removeHospital(num);
					break;
				case 8:
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
					minister.addNurse(firstName,lastName,tc,password,age);

					break;
				case 9:
					System.out.println("tckno=");
					tc=obj.nextLine();
					minister.removeNurse(tc);
					break;
				case 10:
					System.out.println(minister.getMinistry().getHospitals());
					System.out.println("HASTANE SEÇ");
					int num2=obj.nextInt();
					System.out.println("AŞI SAYISI");
					int num3=obj.nextInt();
					minister.supplyTest(num2,num3);
					break;
				case 0:
					System.out.println("EXIT...");
					exit=false;
					break;

				default:
					System.out.println("ERROR");
			}


		}

		obj.close();
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

		obj.close();


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
					doctor.addPatient(new Patient(firstName, lastName, tc, password, age, doctor.getMinistry()));
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

		obj.close();

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
		obj.close();
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
		obj.close();
	}

}