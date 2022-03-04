public class Token {
	private int intVal;
	private String strVal;

	public Token(String value) {
		strVal = value;
	}

	public Token(int value) {
		intVal = value;
	}

	public boolean isString() {
		return strVal != null;
	}

	public String toString() {
		if (!isString()) {
			return ""+intVal;
		} else {
			return strVal;
		}
	}

	public static boolean equals(Token a, Token b) {
		if (a == null && b != null) {
			return false;
		} else if (a != null && b == null) {
			return false;
		}

		if (a.isString() && !b.isString()) {
			return false;
		} else if (a.isString() && b.isString()) {
			if (!a.equals(b)) {
				return false;
			}
		}

		if (!a.isString() && !b.isString()) {
			if (a == b) {
				return false;
			}
		}

		return true;
	}
}