import java.io.*;
import java.util.Scanner;

public class Search {

    /***
     * Check if the user is inside the database
     * @param user_name - a user name
     * @return - return true or false if the user is inside our database.
     * @throws FileNotFoundException - throw exception if something went wrong.
     */
    public Boolean SearchUserName(String user_name) throws FileNotFoundException {
        try {
            File f = new File("Users.txt");
            Scanner myReader = new Scanner(f);
            while (myReader.hasNextLine()) {
                String[] curr_line = myReader.nextLine().split(",", 4);
                if (curr_line[0].equals(user_name)) {
                    return true;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return false;
    }

    /***
     * @param user_name - a user name
     * @return - this function return the user_name's password from our database
     */
    public String GetPasswordFromUsername(String user_name) throws FileNotFoundException {
        try {
            File f = new File("Users.txt");
            Scanner myReader = new Scanner(f);
            while (myReader.hasNextLine()) {
                String[] curr_line = myReader.nextLine().split(",", 4);
                if (curr_line[0].equals(user_name)) {
                    return curr_line[1];
                }
            }
            return "null";
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return "null";
    }

    /***
     * @param user_name - a user name
     * @return - this function return the user_name's email from our database
     */
    public String GetEmailFromUsername(String user_name) throws FileNotFoundException {
        try {
            File f = new File("Users.txt");
            Scanner myReader = new Scanner(f);
            while (myReader.hasNextLine()) {
                String[] curr_line = myReader.nextLine().split(",", 4);
                if (curr_line[0].equals(user_name)) {
                    return curr_line[3];
                }
            }
            return "null";
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return "null";
    }

    /***
     * @param user_name - a user name
     * @return - this function return the user_name's id from our database
     */
    public String GetIDFromUsername(String user_name) throws FileNotFoundException {
        try {
            File f = new File("Users.txt");
            Scanner myReader = new Scanner(f);
            while (myReader.hasNextLine()) {
                String[] curr_line = myReader.nextLine().split(",", 4);
                if (curr_line[0].equals(user_name)) {
                    return curr_line[2];
                }
            }
            return "null";
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return "null";
    }

}
