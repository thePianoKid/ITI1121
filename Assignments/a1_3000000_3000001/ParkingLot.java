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
		System.out.println("number of rows: "+numRows);
		System.out.println("num of spots per row: "+numSpotsPerRow);
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
		// WRITE YOUR CODE HERE!
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
		// WRITE YOUR CODE HERE!
		return null; // REMOVE THIS STATEMENT AFTER IMPLEMENTING THIS METHOD

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
		// WRITE YOUR CODE HERE!
		return false; // REMOVE THIS STATEMENT AFTER IMPLEMENTING THIS METHOD

	}

	/**
	 * @return the total capacity of the parking lot excluding spots that cannot be
	 *         used for parking (i.e., excluding spots that point to CarType.NA)
	 */
	public int getTotalCapacity() {
		// WRITE YOUR CODE HERE!
		return -1; // REMOVE THIS STATEMENT AFTER IMPLEMENTING THIS METHOD

	}

	/**
	 * @return the total occupancy of the parking lot (i.e., the total number of
	 *         cars parked in the lot)
	 */
	public int getTotalOccupancy() {
		// WRITE YOUR CODE HERE!
		return -1; // REMOVE THIS STATEMENT AFTER IMPLEMENTING THIS METHOD		
	}

	// ----------------------- Helper Methods -----------------------
	private String trimWhite(String originalStr) {
		String rtnString = "";

		for (char charToBeTrimmed : originalStr.toCharArray()) {
			if (charToBeTrimmed != ' ') {
				rtnString += charToBeTrimmed;
			}
		}

		return rtnString;
	}

	private int countChars(String searchStr, char key) {
		int counter = 0;

		for (char c : searchStr.toCharArray()) {
			if (key == c) { // TODO: Replace w/ .equals() method
				counter++;
			}
		}

		return counter;
	}

	public static String[] parseCarOccupancy(String line) {
		return line.split(",");
	}

	private CarType convertCarType(char carType) {
		if (carType == 'E'){
			return CarType.ELECTRIC;
		} else if (carType == 'S') {
			return CarType.SMALL;
		} else if (carType == 'R') {
			return CarType.REGULAR;
		} else if (carType == 'L') {
			return CarType.LARGE;
		} else if (carType == 'N') {
			return CarType.NA;
		}

		return null;
	}

	private static int convertStrToInt(String str)
    {
        int val = 0;
  
        // Convert the String
        try {
            val = Integer.parseInt(str);
        }
        catch (NumberFormatException e) {
            // System.out.println("Error in convertStrToInt: Invalid String");
        }
        return val;
    }
	
	private void calculateLotDimensions(String strFilename) throws Exception {
		Scanner scanner = new Scanner(new File(strFilename));

		int counter = 0;

		while (scanner.hasNext()) {
			String str = trimWhite(scanner.nextLine());

			if (counter == 0) {
				int numOfCommas = countChars(str, ',');
				int numOfSpace = countChars(str, ' ');
				numSpotsPerRow = str.length() - numOfCommas - numOfSpace;
			}

			char firstChar;
			if (str.toCharArray().length > 0) {
				firstChar = str.toCharArray()[0];
			} else {
				firstChar = '0';
			}

			if (firstChar == 'S' || firstChar == 'N' 
			|| firstChar == 'R' || firstChar == 'L' ||
			firstChar == 'E') { // TODO: Clean Me!
			// TODO: Replace w/ .equals() method
				counter++;
			}
		}

		numRows = counter;
		
		scanner.close();
	}
	
	private void populateFromFile(String strFilename) throws Exception {

		Scanner scanner = new Scanner(new File(strFilename));

		// YOU MAY NEED TO DEFINE SOME LOCAL VARIABLES HERE!
		int rowNum = 0;
		int colNum;

		// while loop for reading the lot design
		while (scanner.hasNext()) {
			String str = trimWhite(scanner.nextLine());

			if (str.equals("###")) {
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

				boolean notOutOfBounds = (carRowNum < lotDesign.length) && (carColNum < lotDesign[0].length);
				// System.out.println("notOutOfBounds: " + notOutOfBounds);

				CarType parkingCarType;
				String licensePlate;
				CarType lotSpot;
				boolean notTaken;

				if (notOutOfBounds) {
					parkingCarType = convertCarType(lineInfo[2].toCharArray()[0]);
					licensePlate = lineInfo[3];
					lotSpot = lotDesign[carRowNum][carColNum];
					notTaken = (occupancy[carRowNum][carColNum] == null);
					// System.out.println("notTaken: " + notTaken);
				} else {
					parkingCarType = CarType.NA;
					licensePlate = "";
					lotSpot = null;
					notTaken = false;
				}

				Car carToBeParked = new Car(parkingCarType, licensePlate);

				boolean notNA = (lotSpot != CarType.NA);
				// System.out.println("notNA: " + notNA);
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

				// System.out.println("allowed: " + allowed);

				if (notNA && notOutOfBounds && notTaken && allowed) {
					Car car = new Car(parkingCarType, licensePlate);
					occupancy[carRowNum][carColNum] = car;
				} else {
					System.out.println("Car " + carToBeParked.toString() + "cannot be parked at (" 
						+ carRowNum + ", " + carColNum + ")");
				}
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