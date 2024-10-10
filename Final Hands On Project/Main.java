import java.util.ArrayList;
import java.util.Scanner;

// Contact class to store contact details
class Contact {
    private String name;
    private String phoneNumber;
    private String email;
    private String address;

    public Contact(String name, String phoneNumber, String email, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email + ", Address: " + address;
    }
}

// ContactManager class to handle CRUD operations
class ContactManager {
    private ArrayList<Contact> contactList = new ArrayList<>();

    // Add contact
    public void addContact(Contact contact) {
        contactList.add(contact);
        System.out.println("Contact added successfully!");
    }

    // Delete contact by name
    public void deleteContact(String name) {
        contactList.removeIf(contact -> contact.getName().equalsIgnoreCase(name));
        System.out.println("Contact deleted successfully!");
    }

    // Update contact by name
    public void updateContact(String name, Contact updatedContact) {
        for (Contact contact : contactList) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contact.setName(updatedContact.getName());
                contact.setPhoneNumber(updatedContact.getPhoneNumber());
                contact.setEmail(updatedContact.getEmail());
                contact.setAddress(updatedContact.getAddress());
                System.out.println("Contact updated successfully!");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    // View all contacts
    public void viewContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (Contact contact : contactList) {
                System.out.println(contact);
            }
        }
    }

    // Search contact by name
    public Contact searchContact(String name) {
        for (Contact contact : contactList) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }
}

// Main class for the contact management system
public class Main {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nContact Management System:");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Search Contact");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();

                    Contact contact = new Contact(name, phoneNumber, email, address);
                    manager.addContact(contact);
                    break;
                case 2:
                    manager.viewContacts();
                    break;
                case 3:
                    System.out.print("Enter the name of the contact to update: ");
                    String oldName = scanner.nextLine();

                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new Phone Number: ");
                    String newPhoneNumber = scanner.nextLine();
                    System.out.print("Enter new Email: ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Enter new Address: ");
                    String newAddress = scanner.nextLine();

                    Contact updatedContact = new Contact(newName, newPhoneNumber, newEmail, newAddress);
                    manager.updateContact(oldName, updatedContact);
                    break;
                case 4:
                    System.out.print("Enter the name of the contact to delete: ");
                    String deleteName = scanner.nextLine();
                    manager.deleteContact(deleteName);
                    break;
                case 5:
                    System.out.print("Enter the name of the contact to search: ");
                    String searchName = scanner.nextLine();
                    Contact foundContact = manager.searchContact(searchName);
                    if (foundContact != null) {
                        System.out.println("Contact Found: " + foundContact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
