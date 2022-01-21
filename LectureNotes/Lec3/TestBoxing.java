public class TestBoxing {
	public static void main(String[] args) {
		long start, stop;
		start = System.currentTimeMillis();
		long s1 = (long) 0;
		for (int j = 0; j < 100000000; j++) {
			s1 += (long) 1;
		}
		stop = System.currentTimeMillis();

		System.out.println("Time elapsed: "+(stop-start));
		
		start = System.currentTimeMillis();
		Long s2 = (long) 0;
		for (int k=0; k < 100000000; k++) {
			s2 += (long) 1;
		}
		stop = System.currentTimeMillis();

		System.out.println("Time elapsed: "+(stop-start));
	}
}
