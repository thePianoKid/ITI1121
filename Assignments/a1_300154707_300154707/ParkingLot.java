import java.io.File;
import java.util.Scanner;

/**
 * @author Mehrdad Sabetzadeh, University of Ottawa
 */
public class ParkingLot {
	/**
	 * The delimiter that separates values
	 */
	private static final String SEPARATOR = ",";

	/**
	 * The delimiter that separates the parking lot design section from the parked
	 * car data section
	 */
	private static final String SECTIONER = "###";

	/**
	 * Instance variable for storing the number of rows in a parking lot
	 */
	private int numRows; 

	/**
	 * Instance variable for storing the number of spaces per row in a parking lot
	 */
	private int numSpotsPerRow;

	/**
	 * Instance variable (two-dimensional array) for storing the lot design
	 */
	private CarType[][] lotDesign;

	/**
	 * Instance variable (two-dimensional array) for storing occupancy information
	 * for the spots in the lot
	 */
	private Car[][] occupancy;

	/**
	 * Constructs a parking lot by loading a file
	 * 
	 * @param strFilename is the name of the file
	 */
	public ParkingLot(String strFilename) throws Exception {

		if (strFilename == null) {
			System.out.println("File name cannot be null.");
			return;
		}

		// determine numRows and numSpotsPerRow; you can do so by
		// writing your own code or alternatively completing the 
		// private calculateLotDimensions(...) that I have provided
		calculateLotDimensions(strFilename);

		// instantiate the lotDesign and occupancy variables!
		lotDesign = new CarType[numRows][numSpotsPerRow];
		occupancy = new Car[numRows][numSpotsPerRow];

		// populate lotDesign and occupancy; you can do so by
		// writing your own code or alternatively completing the 
		// private populateFromFile(...) that I have provided
		populateFromFile(strFilename);
	}

	/**
	 * Parks a car (c) at a give location (i, j) within the parking lot.
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @param c is the car to be parked
	 */
	public void park(int i, int j, Car c) {
		if (canParkAt(i, j, c)) {
			occupancy[i][j] = c;
		} else {
			System.out.println("Car " + c.toString() + " cannot be parked at (" 
				+ i + ", " + j + ")");
		}
	}

	/**
	 * Removes the car parked at a given location (i, j) in the parking lot
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @return the car removed; the method returns null when either i or j are out
	 *         of range, or when there is no car parked at (i, j)
	 */
	public Car remove(int i, int j) {
		if (i < lotDesign.length && j < lotDesign[0].length) {
			if (occupancy[i][j] != null) {
				Car carToBeRemoved = occupancy[i][j];
				occupancy[i][j] = null;
				return carToBeRemoved;
			} 
		}

		return null;
	}

	/**
	 * Checks whether a car (which has a certain type) is allowed to park at
	 * location (i, j)
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @return true if car c can park at (i, j) and false otherwise
	 */
	public boolean canParkAt(int i, int j, Car c) {
		boolean notOutOfBounds = (i < lotDesign.length) && (j < lotDesign[0].length);
		CarType parkingCarType = c.getType();

		CarType lotSpot;
		boolean notTaken;

		if (notOutOfBounds) {
			lotSpot = lotDesign[i][j];
			notTaken = (occupancy[i][j] == null);
		} else {
			parkingCarType = CarType.NA;
			lotSpot = null;
			notTaken = false;
		}

		boolean notNA = (lotSpot != CarType.NA);
		boolean allowed;

		// If statement divided up for clarity
		if (parkingCarType == CarType.ELECTRIC) {
			allowed = true;
		} else if (parkingCarType == CarType.SMALL && lotSpot != CarType.ELECTRIC) {
			allowed = true;
		} else if (parkingCarType == CarType.REGULAR && 
			lotSpot != CarType.ELECTRIC && lotSpot != CarType.SMALL) {
			allowed = true;
		} else if (parkingCarType == CarType.LARGE && lotSpot == CarType.LARGE) {
			allowed = true;
		} else {
			allowed = false;
		}

		return (notNA && notOutOfBounds && notTaken && allowed);
	}

	/**
	 * @return the total capacity of the parking lot excluding spots that cannot be
	 *         used for parking (i.e., excluding spots that point to CarType.NA)
	 */
	public int getTotalCapacity() {
		int counter = 0;

		for (CarType[] lotRow : lotDesign) {
			for (CarType spot : lotRow) {
				if (spot != CarType.NA) {
					counter++;
				}
			}
		}

		return counter;
	}

	/**
	 * @return the total occupancy of the parking lot (i.e., the total number of
	 *         cars parked in the lot)
	 */
	public int getTotalOccupancy() {
		int counter = 0;

		for (Car[] occupancyRow : occupancy) {
			for(Car carSpot : occupancyRow) {
				if (carSpot != null) {
					counter++;
				}
			}
		}

		return counter;
	}

	// ----------------------- Helper Methods -----------------------

	/**
	 * Trims all white space from the inputted string
	 * 
	 * @param originalStr is the string to be trimmed
	 * @return the original string, now with no white space
	 */
	private String trimWhite(String originalStr) {
		String rtnString = "";

		for (char charToBeTrimmed : originalStr.toCharArray()) {
			if (charToBeTrimmed != ' ') {
				rtnString += charToBeTrimmed;
			}
		}

		return rtnString;
	}

	/**
	 * Counts all the occurences of a particular string in a string
	 * 
	 * @param searchStr full string to be searched
	 * @param key a single character string 
	 * @return the number of times key appears in searchStr
	 */
	private int countChars(String searchStr, String key) {
		int counter = 0;

		for (char c : searchStr.toCharArray()) {
			if (key.equals(Character.toString(c))) { 
				counter++;
			}
		}

		return counter;
	}

	/**
	 * Uses the builtin String.split method to parse a trimmed line read from a .inf file
	 * 
	 * @param line
	 * @return array of strings containing [row, spot in the row, car type, plate number]
	 */
	public static String[] parseCarOccupancy(String line) {
		return line.split(SEPARATOR);
	}

	/**
	 * Converts a char primitive type into a CarType reference type
	 * 
	 * @param charCarType
	 * @return a variable of type CarType if the inputted character does not match a CarType, it defaults to CarType.NA
	 */
	private static CarType convertCarType(char charCarType) {
		String strCarType = Character.toString(charCarType);

		return Util.getCarTypeByLabel(strCarType);
	}

	/**
	 * Converts a string to an integer using the Integer wrapper class
	 * 
	 * @param str
	 * @return integer representation of the inputted string
	 */
	private static int convertStrToInt(String str)
    {
        int val = 0;
  
        // Convert the String
        try {
            val = Integer.parseInt(str);
        }
        catch (NumberFormatException e) {
            System.out.println("Error in convertStrToInt: Invalid String");
        }
        return val;
    }
	
	/**
	 * Calculates the parking lot dimensions of based on the given .inf file
	 * 
	 * @param strFilename
	 * @throws Exception
	 */
	private void calculateLotDimensions(String strFilename) throws Exception {
		Scanner scanner = new Scanner(new File(strFilename));

		int counter = 0;

		while (scanner.hasNext()) {
			String str = trimWhite(scanner.nextLine());

			if (counter == 0) {
				int numOfSeparators = countChars(str, SEPARATOR);
				int numOfSpace = countChars(str, " ");
				numSpotsPerRow = str.length() - numOfSeparators - numOfSpace;
			}

			char firstChar;
			if (str.toCharArray().length > 0) {
				firstChar = str.toCharArray()[0];
			} else {
				firstChar = '0';
			}

			if (firstChar == 'S' || firstChar == 'N' 
			|| firstChar == 'R' || firstChar == 'L' ||
			firstChar == 'E') {
				counter++;
			}
		}

		numRows = counter;
		
		scanner.close();
	}
	
	/**
	 * Populates the lotDesign and occupancy variables by reading the given .inf file
	 * 
	 * @param strFilename
	 * @throws Exception
	 */
	private void populateFromFile(String strFilename) throws Exception {

		Scanner scanner = new Scanner(new File(strFilename));

		int rowNum = 0;
		int colNum;

		// while loop for reading the lot design
		while (scanner.hasNext()) {
			String str = trimWhite(scanner.nextLine());

			if (str.equals(SECTIONER)) {
				break;
			}

			colNum = 0;

			if (str.toCharArray().length > 0){
				for (char ch : str.toCharArray()) {
					if (ch == 'E' || ch == 'S' || ch == 'R' || ch == 'L' || ch == 'N') {
						lotDesign[rowNum][colNum] = convertCarType(ch);
						colNum++;
					}
				}
				rowNum++;
			}
		}

		// while loop for reading occupancy data
		while (scanner.hasNext()) {
			String str = scanner.nextLine();
			if (str.toCharArray().length > 1) {
				String trimmedStr = trimWhite(str);
				String[] lineInfo = parseCarOccupancy(trimmedStr);

				int carRowNum = convertStrToInt(lineInfo[0]);
				int carColNum = convertStrToInt(lineInfo[1]);
				CarType parkingCarType = Util.getCarTypeByLabel(lineInfo[2]);
				String licensePlate = lineInfo[3];

				Car carToBeParked = new Car(parkingCarType, licensePlate);

				park(carRowNum, carColNum, carToBeParked);
			}
		}

		scanner.close();
	}

	/**
	 * Produce string representation of the parking lot
	 * 
	 * @return String containing the parking lot information
	 */
	public String toString() {
		// NOTE: The implementation of this method is complete. You do NOT need to
		// change it for the assignment.
		StringBuffer buffer = new StringBuffer();
		buffer.append("==== Lot Design ====").append(System.lineSeparator());

		for (int i = 0; i < lotDesign.length; i++) {
			for (int j = 0; j < lotDesign[0].length; j++) {
				buffer.append((lotDesign[i][j] != null) ? Util.getLabelByCarType(lotDesign[i][j])
						: Util.getLabelByCarType(CarType.NA));
				if (j < numSpotsPerRow - 1) {
					buffer.append(", ");
				}
			}
			buffer.append(System.lineSeparator());
		}

		buffer.append(System.lineSeparator()).append("==== Parking Occupancy ====").append(System.lineSeparator());

		for (int i = 0; i < occupancy.length; i++) {
			for (int j = 0; j < occupancy[0].length; j++) {
				buffer.append(
						"(" + i + ", " + j + "): " + ((occupancy[i][j] != null) ? occupancy[i][j] : "Unoccupied"));
				buffer.append(System.lineSeparator());
			}

		}
		return buffer.toString();
	}

	/**
	 * <b>main</b> of the application. The method first reads from the standard
	 * input the name of the file to process. Next, it creates an instance of
	 * ParkingLot. Finally, it prints to the standard output information about the
	 * instance of the ParkingLot just created.
	 * 
	 * @param args command lines parameters (not used in the body of the method)
	 * @throws Exception
	 */

	public static void main(String args[]) throws Exception {

		StudentInfo.display();

		System.out.print("Please enter the name of the file to process: ");

		Scanner scanner = new Scanner(System.in);

		String strFilename = scanner.nextLine();

		ParkingLot lot = new ParkingLot(strFilename);

		System.out.println("Total number of parkable spots (capacity): " + lot.getTotalCapacity());

		System.out.println("Number of cars currently parked in the lot: " + lot.getTotalOccupancy());

		System.out.print(lot);

	}
}