package aroundme;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	public static void loadPointsOfInterest(Driver driver, File inputFile) throws FileNotFoundException{
		Scanner fileReader = new Scanner(inputFile);
		while(fileReader.hasNextLine()){
			String line = fileReader.nextLine();
			String[] components = line.split(",");
			String description = components[0];
			double latitude = Double.valueOf(components[1]); //y
			double longitude = Double.valueOf(components[2]); //x
			driver.addPoint(longitude, latitude,description);
		}
	}

	public static void main(String[] args)throws FileNotFoundException {
		String underGroundCoordsFilePath;
		if(args.length == 0)
			underGroundCoordsFilePath = "/home/rob/workspace/AroundMe/tube.csv";
		else
			underGroundCoordsFilePath = args[0];
		File f = new File(underGroundCoordsFilePath);
		Driver driver = new Driver();
		loadPointsOfInterest(driver, f);
		while(true){
			System.out.println("What is you lat,long");
			Scanner keyboard = new Scanner(System.in);
			String[] location = keyboard.nextLine().split(",");
			Double latitude = Double.parseDouble(location[1]);
			Double longitude = Double.parseDouble(location[0]);
			
			driver.nearestInterestsAndDistances(latitude, longitude, 5);
			System.out.println();
		}
		
		

	}

}
