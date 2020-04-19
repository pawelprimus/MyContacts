package primrim;

import javafx.application.Platform;
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


        tableView.setItems(ContactData.getInstance().getContacts());


    }


    @FXML
    public void showNewContactDialog() {

    }

    @FXML
    public void handleExit() {
        Platform.exit();
    }


}
