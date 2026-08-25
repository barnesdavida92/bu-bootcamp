package code;

import java.util.*; 
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        contacts.put("Link", new Contact("Link", "484-777-4321"));
        contacts.put("Zelda", new Contact("Zelda", "484-100-1234"));
        contacts.put("Ganon", new Contact("Ganon", "484-666-9999"));
        contacts.put("Midna", new Contact("Midna", "484-000-4334"));
        contacts.put("Zant", new Contact("Zant", "484-000-9999"));
 
        String lookupName = "Ganon";

        // Step 5: look up a contact 
        if (contacts.containsKey(lookupName)) {
            System.out.println(contacts.get(lookupName).toString());
        } else {
            System.out.println("Contact not found: " + lookupName);
        }

        // Does not exist
        lookupName = "Vaati";

        if (contacts.containsKey(lookupName)) {
            System.out.println(contacts.get(lookupName).toString());
        } else {
            System.out.println("Contact not found: " + lookupName);
        }
 
        // Step 6: print sorted list 
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());

        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        System.out.println("===All Contacts===");
        for (Contact c : sorted) {
            System.out.println(c.toString());
        }
    } 
}