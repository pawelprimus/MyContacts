package primrim;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import primrim.datamodel.Contact;
import primrim.datamodel.ContactData;


public class dialogController {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField notesField;



    public Contact processResults() {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String phoneNumber = phoneNumberField.getText().trim();
        String notes = notesField.getText().trim();


        Contact contact = new Contact(firstName, lastName, phoneNumber, notes);
        ContactData.getInstance().addContact(contact);
        return contact;
    }


    public boolean isDataValid(){

        if(firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty() || phoneNumberField.getText().isEmpty() || notesField.getText().isEmpty() ){
            return false;
        } else {
            return true;
        }

    }


}
