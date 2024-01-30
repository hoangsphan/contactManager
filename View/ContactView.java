/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author macbookpro
 */
import Controller.ContactController;
import Model.Contact;
import java.util.List;
import java.util.Scanner;

public class ContactView {
    private ContactController contactController;

    public ContactView(ContactController contactController) {
        this.contactController = contactController;
    }

    public void displayMenu() {
        System.out.println("======Contact Program=====");
        System.out.println("1. Add a contact");
        System.out.println("2. Display all contacts");
        System.out.println("3. Delete a contact");
        System.out.println("4. Exit");
        System.out.print("Select an option: ");
    }

    public void addContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------Add a contact-------- ");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter group: ");
        String group = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        String phone = getValidPhoneNumber(scanner);

        contactController.addContact(name, group, address, phone);

        System.out.println("successful.");
    }

    private String getValidPhoneNumber(Scanner scanner) {
        String phone = null;
        boolean isValid = false;

        while (!isValid) {
            System.out.println("Please input the phone flow :");
            System.out.println("• 1234567890");
            System.out.println("• 123-456-7890");
            System.out.println("• 123-456-7890 x1234");
            System.out.println("• 123-456-7890 ext1234");
            System.out.println("• (123)-456-7890");
            System.out.println("• 123.456.7890");
            System.out.println("• 123 456 7890");
            System.out.print("Enter Phone: ");
            phone = scanner.nextLine();

            isValid = validatePhoneNumber(phone);

            if (!isValid) {
                System.out.println("Invalid phone number format. Please try again.");
            }
        }

        return phone;
    }

    private boolean validatePhoneNumber(String phone) {
        // Regular expression to validate phone number format
        String regex = "^\\d{10}$|^\\d{3}-\\d{3}-\\d{4}$|^\\d{3}-\\d{3}-\\d{4} x\\d+$|^\\d{3}-\\d{3}-\\d{4} ext\\d+$|^\\(\\d{3}\\)-\\d{3}-\\d{4}$|^\\d{3}\\.\\d{3}\\.\\d{4}$|^\\d{3} \\d{3} \\d{4}$";

        return phone.matches(regex);
    }

    public void displayAll() {
        List<Contact> contacts = contactController.getAllContacts();

        System.out.println("ID\tName\t\tFirst Name\tLast Name\tGroup\tAddress\t\tPhone");

        for (Contact contact : contacts) {
            System.out.printf("%d\t%s\t%s\t\t%s\t\t%s\t%s\t%s%n", contact.getId(), contact.getFullName(),
                    contact.getFirstName(), contact.getLastName(), contact.getGroup(), contact.getAddress(),
                    contact.getPhone());
        }
    }

    public void deleteContact() {
        Scanner scanner = new Scanner(System.in);

        int contactId = getValidContactId(scanner);

        boolean deleted = contactController.deleteContact(contactId);

        if (deleted) {
            System.out.println("successful.");
        } else {
            System.out.println("ID not found.");
        }
    }

     private int getValidContactId(Scanner scanner) {
        int contactId = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Enter ID: ");
            String input = scanner.nextLine();

            try {
                contactId = Integer.parseInt(input);
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("ID is digit.");
            }
        }

        return contactId;
    }
        
    }
