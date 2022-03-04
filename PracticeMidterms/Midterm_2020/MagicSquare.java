import java.util.Arrays;

public class MagicSquare {
	// Part A. Instance variables
	int[] values;
	int n;
	int magicConstant;
	// seize variables added for part B
	int size;

	public MagicSquare(int[] values) {
		this.values = values;
		// Assuming values is square
		this.size = (int) Math.sqrt(values.length);

		this.magicConstant = 0;
		for (int i = 0; i < size; i++) {
			this.magicConstant += values[i];
		}
	}

	public int getSize() {
		return size;
	}

	public int getConstant() {
		return magicConstant;
	}

	public int getValue(int row, int column) {
		int iterativeRow = 0;
		int iterativeCol = 0;

		for (int i = 0; i > values.length; i++) {
			if (row == iterativeRow && column == iterativeCol) {
				return values[i];
			}

			if (i%(n-1) != 0) {
				iterativeCol++;
			} else {
				iterativeCol = 0;
				iterativeRow++;
			}
		}

		return 0;
	}

	public boolean isMagicDiagonals() {
		int[] diagonalIndexes = new int[size];
		int increment = size + 1;
		diagonalIndexes[0] = 0;

		for (int i = 1; i < diagonalIndexes.length; i++) {
			diagonalIndexes[i] = diagonalIndexes[i-1] + increment;
		}

		System.out.println(Arrays.toString(diagonalIndexes));

		int[] antidiagonalIndexes = new int[size];
		int antiIncrement = size - 1;
		antidiagonalIndexes[0] = antiIncrement;

		for (int j = 1; j < antidiagonalIndexes.length; j++) {
			antidiagonalIndexes[j] = antidiagonalIndexes[j-1] + antiIncrement;
		}

		System.out.println(Arrays.toString(antidiagonalIndexes));

		int diagonalSum = 0;

		for (int k = 0; k < diagonalIndexes.length; k++) {
			diagonalSum += values[diagonalIndexes[k]];
		}

		System.out.println(diagonalSum);

		int antidiagonalSum = 0;

		for (int a = 0; a < antidiagonalIndexes.length; a++) {
			antidiagonalSum += values[antidiagonalIndexes[a]];
		}

		System.out.println(antidiagonalSum);

		System.out.println(magicConstant);

		return (magicConstant == diagonalSum && magicConstant == antidiagonalSum);
	}
}