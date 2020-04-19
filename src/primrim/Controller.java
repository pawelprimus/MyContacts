package primrim;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import primrim.datamodel.Contact;
import primrim.datamodel.ContactData;

import java.util.ArrayList;
import java.util.List;


public class Controller {



    private ContactData contactData;

    @FXML
    private TableView<Contact> tableView;




    @FXML
    private BorderPane mainBorderPane;




   public void initialize() {



       //ContactData contactData = new ContactData();

       //ObservableList<ContactData> contacts = FXCollections.observableArrayList();


       //contactData.addContact(contact1);
       //contactData.addContact(contact2);
       //contactData.addContact(contact3);

      // contactData.loadTodoItems();

       /*Contact contact1 = new Contact("Pawel", "P", "111", "Notatka");
       Contact contact2 = new Contact("Wojtek", "Pr", "222", "Note");
       Contact contact3 = new Contact("Rob", "Maklowicz", "33", "eeeeee");

       contactData.addContact(contact1);
       contactData.addContact(contact2);
       contactData.addContact(contact3);*/


       tableView.setItems(ContactData.getInstance().getContacts());




    }

    //contacts = new ArrayList


  /*  public ObservableList<ContactData> getContacts() {
        ObservableList<Contact> contacts = FXCollections.observableArrayList();
        contacts.add(new Contact("Pawel", "P", "111", "Notatka"));
        contacts.add(new Contact("Wojtek", "Pr", "222", "Note"));
        contacts.add(new Contact("Rob", "Maklowicz", "33", "eeeeee"));

        return contacts;

    }*/


    @FXML
    public void showNewContactDialog() {

    }

    @FXML
    public void handleExit() {

    }


}
