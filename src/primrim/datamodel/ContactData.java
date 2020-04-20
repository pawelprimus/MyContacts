package primrim.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Iterator;

public class ContactData {


    private static ContactData instance = new ContactData();
    private static String filename = "Contacts.txt";

    private ObservableList<Contact> contacts;

    public ObservableList<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void deleteContact(Contact contact) {
        contacts.remove(contact);
    }

    public static ContactData getInstance() {
        return instance;
    }


    public void loadContactsData() throws IOException {


        contacts = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try {
            while ((input = br.readLine()) != null) {
                String[] contactPieces = input.split("\t");

                String firstName = contactPieces[0];
                String lastName = contactPieces[1];
                String phoneNumber = contactPieces[2];
                String notes = contactPieces[3];

                Contact contact = new Contact(firstName, lastName, phoneNumber, notes);
                contacts.add(contact);

            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    public void storeContactData() throws IOException {

        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try {
            Iterator<Contact> iter = contacts.iterator();
            while (iter.hasNext()) {
                Contact contact = iter.next();
                bw.write(String.format("%s\t%s\t%s\t%s",
                        contact.getFirstName(),
                        contact.getLastName(),
                        contact.getPhoneNumber(),
                        contact.getNotes()));
                bw.newLine();
            }

        } finally {
            if (bw != null) {
                bw.close();
            }
        }
    }


}
