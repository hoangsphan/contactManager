/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controller;

import View.ContactView;
import java.util.Scanner;

/**
 *
 * @author macbookpro
 */
public class Main {
    public static void main(String[] args) {
        ContactController contactController = new ContactController();
        ContactView contactView = new ContactView(contactController);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            contactView.displayMenu();
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    contactView.addContact();
                    break;
                case 2:
                    contactView.displayAll();
                    break;
                case 3:
                    contactView.deleteContact();
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
