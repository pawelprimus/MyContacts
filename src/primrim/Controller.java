package primrim;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import primrim.datamodel.Contact;
import primrim.datamodel.ContactData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add new Contact");
        dialog.setHeaderText("Use this dialog to create new contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("newContactDialog.fxml"));

        try {
            //Parent root = FXMLLoader.load(getClass().getResource("todoItemDialog.fxml"));
            //dialog.getDialogPane().setContent(root);
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            dialogController controller = fxmlLoader.getController();
            Contact contact = controller.processResults();
            // todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());
            //todoListView.getSelectionModel().select(newItem);
            // System.out.println("Ok pressed");
        } /*else {
            System.out.println("Cancel pressed");
        }*/


    }

    @FXML
    public void handleExit() {
        Platform.exit();
    }


}
