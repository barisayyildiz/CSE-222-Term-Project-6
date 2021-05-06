import com.obj.*;
import com.users.*;
import java.util.*;

public class Main
{
	public static void main(String args[]){

		Ministry ministery = new Ministry();
		ArrayList<Hospital> arr = ministery.getHospitals();

		// Testing...
		arr.add(new Hospital());
		System.out.println(arr.size());
		System.out.println(ministery.getHospitals().size());



	}
}