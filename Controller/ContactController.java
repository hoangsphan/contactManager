/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author macbookpro
 */
import Model.Contact;
import java.util.ArrayList;
import java.util.List;

public class ContactController {
    private List<Contact> contactList;
    private int lastContactId;

    public ContactController() {
        contactList = new ArrayList<>();
        lastContactId = 0;
    }

    public void addContact(String name, String group, String address, String phone) {
        String[] nameParts = name.split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts.length > 1 ? nameParts[1] : "";

        int id = ++lastContactId;

        Contact contact = new Contact(id, name, group, address, phone, lastName, firstName);
        contactList.add(contact);
    }

    public List<Contact> getAllContacts() {
        return contactList;
    }

    public boolean deleteContact(int contactId) {
        for (Contact contact : contactList) {
            if (contact.getId() == contactId) {
                contactList.remove(contact);
                return true;
            }
        }
        return false;
    }
}