import java.util.Scanner;

public class VotingRight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How old are you? ");
        int age = sc.nextInt();
        
        if (age >= 18){
            System.out.println("You have the right to vote!");
        } else {
            System.out.println("You will be allowed to vote in "+(18-age)+" years.");
        }

        sc.close();
    }
}
