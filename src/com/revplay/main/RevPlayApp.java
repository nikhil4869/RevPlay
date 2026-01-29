package com.revplay.main;

import java.util.Scanner;
import com.revplay.model.User;
import com.revplay.ui.UserMenu;
import com.revplay.ui.UserMenuUI;
import com.revplay.ui.ArtistMenu;
import com.revplay.service.UserService;

public class RevPlayApp {

    public static Scanner sc = new Scanner(System.in);
    private static UserService userService = new UserService();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== REVPLAY =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Forget Password");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            String input = sc.nextLine();

            // 🔴 Empty input
            if (input == null || input.trim().isEmpty()) {
                System.out.println("Please enter a choice.");
                continue;
            }

            int choice;

            // 🔴 Invalid number
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Numbers only (1-4).");
                continue;
            }

            switch (choice) {

                case 1:
                    UserMenu.register();
                    break;

                case 2:
                    User user = UserMenu.login();
                    if (user != null) {
                        if ("ARTIST".equalsIgnoreCase(user.getRole()))
                            ArtistMenu.showMenu(user);
                        else
                            UserMenuUI.showMenu(user);
                    }
                    break;

                // 🆕 FORGOT PASSWORD FEATURE
                case 3:
                    try {
                        System.out.print("Enter your registered Email: ");
                        String email = sc.nextLine();

                        System.out.print("Enter your Username: ");
                        String username = sc.nextLine();

                        // Validate empty
                        if (email.trim().isEmpty() || username.trim().isEmpty()) {
                            System.out.println("Fields cannot be empty.");
                            break;
                        }

                        boolean verified = userService.verifyUser(email, username);

                        if (!verified) {
                            System.out.println("User not found. Check email/username.");
                            break;
                        }

                        System.out.print("Enter New Password: ");
                        String newPass = sc.nextLine();

                        if (newPass.trim().isEmpty()) {
                            System.out.println("Password cannot be empty.");
                            break;
                        }

                        if (userService.resetPassword(email, newPass))
                            System.out.println("Password reset successful! You can login now.");
                        else
                            System.out.println("Password reset failed.");

                    } catch (Exception e) {
                        System.out.println("Something went wrong. Try again.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting RevPlay. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Select 1-4.");
            }
        }
    }
}