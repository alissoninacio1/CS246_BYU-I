package inacio;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        //User object
        User user = new User(password);

        //the password will be set
        System.out.println("Password: " + user.getPassword());
        System.out.println("Salt: " + user.getSalt());
        System.out.println("Hashed Password: " + user.getHashedPassword());

        try {
            // Password should be set here
            System.out.println("Password: " + user.getPassword());
            System.out.println("Salt: " + user.getSalt());
            System.out.println("Hashed Password: " + user.getHashedPassword());

            // hashUserPassword is a static function (no NSALoginController object needed)
            // This function will set the salt and hashedPassword in the user object
            NSALoginController.hashUserPassword(user);

            // Only salt and hashed password set at this point
            System.out.println("Password: " + user.getPassword());
            System.out.println("Salt: " + user.getSalt());
            System.out.println("Hashed Password: " + user.getHashedPassword());

            // Testing hashed password and ask the user for password
            System.out.print("Enter password: ");
            password = scanner.nextLine();
            user.setPassword(password);

            // verifyPassword and hashed password
            if (NSALoginController.verifyPassword(user)) {
                System.out.println("Verified!");
            } else {
                System.out.println("Not Verified!");
            }
        }
        catch (WeakPasswordException e) {
            System.out.println("Weak Password Error: " + e.getMessage());
        } catch(Exception e) {
            System.out.println("General Exception: " + e.toString());
        }
    }
}
