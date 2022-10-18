import java.awt.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

//        new createUser();

        Scanner s = new Scanner(System.in);

        System.out.println("1 - Create a user ");
        System.out.println("2 - Log in");
        System.out.println("3 - Forget my password");
//        System.out.println("3 - Forget my password");
        System.out.print("Hello and welcome to CU! What do you want to do? (1-3) --->");
        int num = s.nextInt();
        switch (num) {
            case 1 -> new createUser();
            case 2 -> new loginDemo();
            case 3 -> new forgetPassword();
        }

//        Search s1 = new Search();
//
//        System.out.println(s1.SearchPasswordByUsername("Nir_Geron"));


    }

}
