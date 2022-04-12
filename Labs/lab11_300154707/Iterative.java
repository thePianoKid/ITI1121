public class Iterative {

	public static BitList complement( BitList in ) {
        BitList bl = new BitList();
        
        Iterator i = in.iterator();
        while (i.hasNext()) {
            if (i.next() == 0) {
                bl.addFirst(1);
            } else {
                bl.addFirst(0);
            }
        }

        return bl;
	}

	public static BitList or( BitList a, BitList b ) {
        Iterator ia = a.iterator();
        Iterator ib = b.iterator();
        BitList bl = new BitList();
        int aVal;
        int bVal;

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

        if (counterA == counterB) {
            ia = a.iterator();
            ib = b.iterator();
            while (ia.hasNext()) {
                aVal = ia.next();
                bVal = ib.next();
                if (aVal == 0 && bVal == 0) {
                    bl.addFirst(0);
                } else {
                    bl.addFirst(1);
                }
            }
        } else {
            throw new IllegalArgumentException();
        }

        return bl;
	}

	public static BitList and( BitList a, BitList b ) {
        Iterator ia = a.iterator();
        Iterator ib = b.iterator();
        BitList bl = new BitList();
        int aVal;
        int bVal;

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

        if (counterA == counterB) {
            ia = a.iterator();
            ib = b.iterator();
            while (ia.hasNext()) {
                aVal = ia.next();
                bVal = ib.next();
                if (aVal == 1 && bVal == 1) {
                    bl.addFirst(1);
                } else {
                    bl.addFirst(0);
                }
            }
        } else {
            throw new IllegalArgumentException();
        }

        return bl;
	}

	public static BitList xor( BitList a, BitList b ) {
        Iterator ia = a.iterator();
        Iterator ib = b.iterator();
        BitList bl = new BitList();
        int aVal;
        int bVal;

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

        if (counterA == counterB) {
            ia = a.iterator();
            ib = b.iterator();
            while (ia.hasNext()) {
                aVal = ia.next();
                bVal = ib.next();
                if (aVal == 0 && bVal == 1 || aVal == 1 && bVal == 0) {
                    bl.addFirst(1);
                } else {
                    bl.addFirst(0);
                }
            }
        } else {
            throw new IllegalArgumentException();
        }

        return bl;
	}
}