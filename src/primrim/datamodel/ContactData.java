package primrim.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContactData {

    private static ContactData instance = new ContactData();
    private static String filename = "TodoListItems.txt";

    private ObservableList<Contact> contacts;

    public ObservableList<Contact> getContacts(){
        return contacts;
    }

    public void addContact(Contact contact){
        contacts.add(contact);
    }

    public void deleteContact(Contact contact){
        contacts.remove(contact);
    }

    public static ContactData getInstance() {
        return instance;
    }

    public void loadContacts(){

        contacts = FXCollections.observableArrayList();

        Contact contact1 = new Contact("Pawel", "Pri", "111-123-456", "Notatka");
        Contact contact2 = new Contact("John", "Smith", "222-333-777", "Note");
        Contact contact3 = new Contact("Rob", "Maklowicz", "333-456-111", "eeeeee");

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);

    }



    /*public void loadTodoItems(){
        Contact contact1 = new Contact("Pawel", "P", "111", "Notatka");
        Contact contact2 = new Contact("Wojtek", "Pr", "222", "Note");
        Contact contact3 = new Contact("Rob", "Maklowicz", "33", "eeeeee");

        contacts.add(contact1);

    }*/


}
