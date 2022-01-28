public class Ticket {
	// Clears variable
	private static int lastSerialNumber = 0;
	// Instance variable
	private int serialNumber;

	public Ticket() {
		serialNumber = lastSerialNumber;
		lastSerialNumber++;
	}

	public int getSerialNumber() {
		return serialNumber;
	}
}