public class MyInteger {
	int value;

	MyInteger (int value) {
		this.value = value;
	}

	public boolean equals (MyInteger other) {
		return this.value == other.value;
	}
}
