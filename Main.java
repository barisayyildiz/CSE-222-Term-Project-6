
import com.obj.*;
import com.users.*;
import com.data_structures.graphs.*;
import com.data_structures.trees.*;
import java.util.Scanner;


public class Main
{
	public static void main(String args[]){

		menu();
		
	}

	public static void menu(){

		Ministry ministry = new Ministry(new Minister("john", "doe", "", "", 55));

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
			if(!type.equals("1") && !type.equals("2")){
				System.out.println("Try again...");
				continue;
			}
			break;			
		}

		if(type.compareTo("1") == 0){
			scanner.nextLine();
			while(true){
				System.out.print("\nTCKNO : ");
				tckno = scanner.nextLine();
				System.out.print("Password : ");
				password = scanner.nextLine();
	
				User user = ministry.loginHealthEmployee(tckno, password);
				
				if(user instanceof Minister){
					minister = (Minister)user;
					ministerPage(minister);
					break;
				}else if(user instanceof Nurse){
					nurse = (Nurse)user;
					nursePage(nurse);
					break;
				}else if(user instanceof HeadPhysician){
					headPhysician = (HeadPhysician)user;
					headPhysicanPage(headPhysician);
					break;
				}else if(user instanceof Doctor){
					doctor = (Doctor)user;
					doctorPage(doctor);
					break;
				}else{
					System.out.println("user not found...");
					continue;
				}

				
			}
		}else if(type.compareTo("2") == 0){
			scanner.nextLine();
			while(true){
				System.out.print("\nTCKNO : ");
				tckno = scanner.nextLine();
				System.out.print("Password : ");
				password = scanner.nextLine();
	
				User user = ministry.loginPatient(tckno, password);
				if(user instanceof Patient){
					Patient patient = (Patient)user;
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

	
	public static void ministerPage(Minister minister){
		
		Scanner obj=new Scanner(System.in);
		int choos;
		String firstName,lastName, password,tc, hospId;
		int age;
		boolean exit=true;
		while(exit) {
			System.out.println("Welcome to Minister Page");
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
			System.out.println("11 - Show last notification");
			System.out.println("0 - Exit");
			choos= obj.nextInt();
			
			switch (choos) {
				case 1:
					System.out.println(minister.getMinistry().getHospitals());
					System.out.println("Hospital ID");
					System.out.println(minister.getHospitalInformation(obj.next()));
					break;
				case 2:
					minister.getDailyStatistics();
					break;
				case 3:
					/*yapılacak*/
					break;
				case 4:
					String type;
					obj.nextLine();
					while(true){
						System.out.println("PLEASE SELECT VACCINE TYPE\nSINOVAC,\nBIOENTECH\nASTRAZENECA\nSPUTNIK\nKAYSERI");
						type=obj.nextLine();
						if (!type.equals("SINOVAC") && !type.equals("BIOENTECH") && !type.equals("SPUTNIK") && !type.equals("ASTRAZENECA") && !type.equals("KAYSERI")){
							System.out.println("tekrar dene");
							continue;
						}
						break;
					}
					VaccineType tip;
					tip=VaccineType.valueOf(type);
					System.out.print("Amount : ");
					int vaccnum=obj.nextInt();
					System.out.print("Enter hospital id : ");
					String hosptid=obj.next();
					minister.supplyVaccine(hosptid,tip,vaccnum);
					break;
				case 5:
				obj.nextLine();
					System.out.print("firstName=");
					firstName=obj.nextLine();
					System.out.print("lastName=");
					lastName=obj.nextLine();
					System.out.print("tckno=");
					tc=obj.nextLine();
					System.out.print("password=");
					password=obj.nextLine();
					System.out.print("age=");
					age=obj.nextInt();
					
					System.out.print("hospital id : ");
					hospId = obj.nextLine();
					minister.addDoctor(firstName,lastName,tc,password,age,hospId,1);
					break;
				case 6:
					obj.nextLine();
					System.out.print("tckno= ");
					tc=obj.nextLine();
					minister.removeDoctor(tc);
					break;
				case 7:
					obj.nextLine();
					System.out.println(minister.getMinistry().getHospitals());
					System.out.print("Hospital id : ");
					String num=obj.next();
					minister.removeHospital(num);
					break;
				case 8:
				obj.nextLine();
					System.out.print("firstName=");
					firstName=obj.nextLine();
					System.out.print("lastName=");
					lastName=obj.nextLine();
					System.out.print("tckno=");
					tc=obj.nextLine();
					System.out.print("password=");
					password=obj.nextLine();
					System.out.print("age=");
					age=obj.nextInt();
					System.out.print("hospital id : ");
					hospId = obj.nextLine();
					minister.addNurse(firstName,lastName,tc,password,age,hospId,2);

					break;
				case 9:
					obj.nextLine();
					System.out.print("tckno=");
					tc=obj.nextLine();
					minister.removeNurse(tc);
					break;
				case 10:
					System.out.println(minister.getMinistry().getHospitals());
					System.out.println("HASTANE SEÇ");
					String num2=obj.next();
					System.out.println("AŞI SAYISI");
					int num3=obj.nextInt();
					minister.supplyTest(num2,num3);
					break;
				case 11:
					System.out.println(minister.getLastMail());
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
		String tc=null, temp;
		Scanner obj=new Scanner(System.in);
		int choos;
		boolean exit=true;
		while(exit) {

			System.out.println("Welcome to HeadPhysican Page");
			System.out.println("1 - Get patient information");
			System.out.println("2 - Get hospital data");
			System.out.println("3 - Input that patient is vaccinated");
			System.out.println("4 - Demand vaccines form Minister");
			System.out.println("0 - Exit");

			choos = obj.nextInt();
			switch (choos) {
				case 1:
					System.out.println("Patient tc");
					tc=obj.next();
					temp = headphysician.getPatientData(tc);
					if(temp != null){
						System.out.println(temp);
					}else{
						System.out.println("Patient with that TCKNO not exists...");
					}
					break;
				case 2:
					System.out.println(headphysician.getHospitalData());
					break;
				case 3:
					if(headphysician.vaccinate()){
						System.out.println("Patient in the head of the queue got vaccinated");
					}else{
						System.out.println("No patient in the queue");
					}
					break;
				case 4:
					System.out.println("PLEASE SELECT VACCINE TYPE\nSINOVAC,\nBIOENTECH\nASTRAZENECA\nSPUTNIK\nKAYSERI");
					String type;
					while(true){
						type=obj.next();
						if (!type.equals("SINOVAC") && !type.equals("BIOENTECH") && !type.equals("SPUTNIK") && !type.equals("ASTRAZENECA") && !type.equals("KAYSERI"))
							System.out.println("tekrar dene");
						else
							break;
					}
					VaccineType tip;
					tip=VaccineType.valueOf(type);

					System.out.println("PLEASE enter  VACCINE number");
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
		
		String tc=null, temp;
		boolean isCovid, isSick, isSmoking, isVaccinated;
		Scanner obj=new Scanner(System.in);
		int choos; 
		boolean exit=true;
		while(exit) {

			System.out.println("Welcome to Doctor Page");
			System.out.println("1 - Add patient");
			System.out.println("2 - Remove patient");
			System.out.println("3 - Get patient Data");
			System.out.println("4 - Input that patient is vaccinated");
			System.out.println("0 - Exit");
			choos = obj.nextInt();

			switch (choos) {
				case 1:
					obj.nextLine();
					String firstName,lastName, password;
					int age;
					System.out.print("firstName= ");
					firstName=obj.nextLine();
					System.out.print("lastName= ");
					lastName=obj.nextLine();
					System.out.print("tckno= ");
					tc=obj.nextLine();
					System.out.print("password= ");
					password=obj.nextLine();
					System.out.print("age= ");
					age=obj.nextInt();
					System.out.print("isCovid : ");
					temp = obj.next();
					isCovid = Boolean.valueOf(temp);
					System.out.print("isSick : ");
					temp = obj.next();
					isSick = Boolean.valueOf(temp);
					System.out.print("isSmoking : ");
					temp = obj.next();
					isSmoking = Boolean.valueOf(temp);
					System.out.print("isVaccinated : ");
					temp = obj.next();
					isVaccinated = Boolean.valueOf(temp);
					System.out.println("City : ");
					temp = obj.next();
					// doctor.addPatient(new Patient(firstName, lastName, tc, password, age, doctor.getMinistry(), isCovid, isSick, isSmoking, isVaccinated, temp));
					break;
				case 2:
					System.out.print("Patient tc : ");
					tc=obj.next();
					if(doctor.removePatient(tc)){
						System.out.println("Patient removed successfully...");
					}else{
						System.out.println("Patient with that TCKNO not exists...");
					}
					break;
				case 3:
					System.out.print("Patient tc : ");
					tc=obj.next();
					temp = doctor.getPatientData(tc);
					if(temp != null){
						System.out.println(temp);
					}else{
						System.out.println("Patient with that TCKNO not exists...");
					}
					break;
				case 4:
					if(doctor.vaccinate()){
						System.out.println("Patient in the head of the queue got vaccinated");
					}else{
						System.out.println("No patient in the queue");
					}
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
		
		Scanner obj=new Scanner(System.in);
		int choos;
		String tc=null;
		boolean exit=true;
		while(exit) {

			System.out.println("Welcome to Nurse Page");
			System.out.println("1 - Mark the test information");
			System.out.println("2 - Input that patient is vaccinated");
			System.out.println("0 - Exit");

			choos = obj.nextInt();

			switch (choos) {
				case 1:
					System.out.print("Patient tc : ");
					tc=obj.next();
					nurse.setCovidInfo(tc);
					break;
				case 2:
					if(nurse.vaccinate()){
						System.out.println("Patient in the head of the queue got vaccinated");
					}else{
						System.out.println("No patient in the queue");
					}
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