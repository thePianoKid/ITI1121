public class Tools {
    public static void say(String msg) {
        System.out.println(msg);
    }

    public static void say(String msg, int iter) {
        // for (int i = 0; i < iter; i++) {
        //     say(msg);
        // }
        
        if ((iter > 0) && (iter <= 10)) {
            // while (iter > 0) {
            //     iter--;
            //     say(msg);   
            // }

            int n = 1;
            while (n <= iter) {
                n++;
                say(msg);
            }
        } else {
            say("Incorrect iteration number");
        }
    }

    public static void say(String[] msgArr) {
        // for (String msg : msgArr) {
        //     say(msg);
        // }
        for (int i = 0; i < msgArr.length; i++) {
            if (i != msgArr.length - 1) {
                System.out.print(msgArr[i]+' ');
            } else {
                System.out.print(msgArr[i]);
            }
        }
    }
}