
import com.data_structures.graphs.*;
import com.cityId;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import java.util.Iterator;

public class Test {

	public static void main(String args[]){

		MatrixGraph cityDistances = new MatrixGraph(81, false);

		// Reading distances.txt
		try {
			Scanner scanner = new Scanner(new File("./database/distances.txt"));
			scanner.nextLine();

			while (scanner.hasNextLine()) {
				String temp = scanner.nextLine();
				String arr[] = temp.split(",");

				cityDistances.insert(new Edge(cityId.valueOf(arr[0]).ordinal(), cityId.valueOf(arr[1]).ordinal(),
						Double.valueOf(arr[2])));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


		double[] weights = new double[81];
		int[] intArr = new int[81];
	
		DijkstrasAlgorithm.dijkstrasAlgorithm(cityDistances, cityId.valueOf("KAYSERİ").ordinal(), intArr, weights);

		for(double d : weights){
			System.out.println(d);
		}

		Iterator iter = cityDistances.edgeIterator(cityId.valueOf("KAYSERİ").ordinal());
		while(iter.hasNext()){
			System.out.println(iter.next());
		}

		
	}




}
