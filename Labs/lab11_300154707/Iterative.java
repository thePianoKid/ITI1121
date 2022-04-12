public class Iterative {

    private static String revStr(String str) {
        char[] charArr = new char[str.length()];
        for (int i = str.toCharArray().length - 1; i >= 0; i--) {
            charArr[str.toCharArray().length-1-i] = str.toCharArray()[i];
        }
  
        return new String(charArr);
    }

	public static BitList complement( BitList in ) {
        String binaryString = "";
        
        Iterator i = in.iterator();
        while (i.hasNext()) {
            if (i.next() == 0) {
                binaryString += "1";
            } else {
                binaryString += "0";
            }
        }

        return new BitList(revStr(binaryString));
	}

	public static BitList or( BitList a, BitList b ) {
        Iterator ia = a.iterator();
        Iterator ib = b.iterator();
        int aVal;
        int bVal;
        String binaryStr = "";

        int counterA = 0;
        while (ia.hasNext()) {
            ia.next();
            counterA++;
        }

        int counterB = 0;
        while (ib.hasNext()) {
            ib.next();
            counterB++;
        }

        if (counterA == 0) {
            throw new IllegalArgumentException();
        }

        if (counterA == counterB) {
            ia = a.iterator();
            ib = b.iterator();
            while (ia.hasNext()) {
                aVal = ia.next();
                bVal = ib.next();
                if (aVal == 0 && bVal == 0) {
                    binaryStr += "0";
                } else {
                    binaryStr += "1";
                }
            }
        } else {
            throw new IllegalArgumentException();
        }

        String revBiStr = revStr(binaryStr);
        BitList bl = new BitList(revBiStr);
        return bl;
	}

	public static BitList and( BitList a, BitList b ) {
        Iterator ia = a.iterator();
        Iterator ib = b.iterator();
        int aVal;
        int bVal;
        String binaryStr = "";

        int counterA = 0;
        while (ia.hasNext()) {
            ia.next();
            counterA++;
        }

        int counterB = 0;
        while (ib.hasNext()) {
            ib.next();
            counterB++;
        }

        if (counterA == 0) {
            throw new IllegalArgumentException();
        }

        if (counterA == counterB) {
            ia = a.iterator();
            ib = b.iterator();
            while (ia.hasNext()) {
                aVal = ia.next();
                bVal = ib.next();
                if (aVal == 1 && bVal == 1) {
                    binaryStr += "1";
                } else {
                    binaryStr += "0";
                }
            }
        } else {
            throw new IllegalArgumentException();
        }

        String revBiStr = revStr(binaryStr);
        BitList bl = new BitList(revBiStr);
        return bl;
	}

	public static BitList xor( BitList a, BitList b ) {
        Iterator ia = a.iterator();
        Iterator ib = b.iterator();
        int aVal;
        int bVal;
        String binaryStr = "";

        int counterA = 0;
        while (ia.hasNext()) {
            ia.next();
            counterA++;
        }

        int counterB = 0;
        while (ib.hasNext()) {
            ib.next();
            counterB++;
        }

        if (counterA == 0) {
            throw new IllegalArgumentException();
        }

        if (counterA == counterB) {
            ia = a.iterator();
            ib = b.iterator();
            while (ia.hasNext()) {
                aVal = ia.next();
                bVal = ib.next();
                if ((aVal == 0 && bVal == 1) || (aVal == 1 && bVal == 0)) {
                    binaryStr += "1";
                } else {
                    binaryStr += "0";
                }
            }
        } else {
            throw new IllegalArgumentException();
        }

        String revBiStr = revStr(binaryStr);
        BitList bl = new BitList(revBiStr);
        return bl;
	}
}