/**
 * This class represents rational numbers and can perform basic arithmetic operations on them
 * 
 * Note: all the rational numbers instantiated using this class are automaticly 
 * reduced to their most simplified form 
 * 
 * @author Gabriel Braden
 */

public class Rational {

    private int numerator;
    private int denominator;

    // constructors

    public Rational(int numerator) {
	    this.numerator = numerator;
        this.denominator = 1;
    }

    public Rational(int numerator, int denominator) {
        int gcd = gcd(numerator, denominator);

        this.numerator = numerator/gcd;
        this.denominator = denominator/gcd;
    }

    // getters

    public int getNumerator() {
	    return numerator;
    }

    public int getDenominator() {
	    return denominator;
    }

    // instance methods

    public Rational plus(Rational other) {
	    int rtnNumerator = (other.denominator * this.numerator) + (this.denominator * other.numerator);
        int rtnDenominator = other.denominator * this.denominator;

        Rational rtnRational = new Rational(rtnNumerator, rtnDenominator);
        
        return rtnRational;
    }

    public static Rational plus(Rational a, Rational b) {
    	return a.plus(b);
    }

    // Transforms this number into its reduced form

    private void reduce() {
        int gcd = gcd(this.numerator, this.denominator);

        if (Math.abs(gcd) != 1) {
            this.numerator = this.numerator/gcd;
            this.denominator = this.denominator/gcd;
        }
    }

    // Euclid's algorithm for calculating the greatest common divisor
    private int gcd(int a, int b) {
      // Note that the loop below, as-is, will time out on negative inputs.
      // The gcd should always be a positive number.
      // Add code here to pre-process the inputs so this doesn't happen.
        if (!(a < 0 || b < 0)) {
            while (a != b)
                if (a > b)
                        a = a - b;
                else
                        b = b - a;
            return a;
        } else {
            return -1;
        }
    }

    public int compareTo(Rational other) {
        // Reduced forms is not a concern since all Rations are reduced upon instantiation
        double frac1 = (double)this.numerator/(double)this.denominator;
        double frac2 = (double)other.numerator/(double)other.denominator;

        if (frac1 == frac2) {
            return 0;
        } else if (frac1 > frac2) {
            return 1;
        } else {
            return -1;
        }
    }

    public boolean equals(Rational other) {
        return this.compareTo(other) == 0;
    }

    public String toString() {
    	String result;
    	if (denominator == 1) {
    	    result = Integer.toString(this.numerator);
    	} else {
    	    result = this.denominator + "/" + this.numerator;
    	}
    	return result;
    }
}