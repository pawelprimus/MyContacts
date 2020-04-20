package primrim;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import primrim.datamodel.Contact;
import primrim.datamodel.ContactData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Controller {


    @FXML
    private ContextMenu contextMenu;

    @FXML
    private TableView<Contact> tableView;


    @FXML
    private BorderPane mainBorderPane;


    public void initialize() {


        contextMenu = new ContextMenu();
        MenuItem menuItemEdit = new MenuItem("Edit");
        contextMenu.getItems().add(menuItemEdit);
        MenuItem menuItemDelete = new MenuItem("Delete");
        contextMenu.getItems().add(menuItemDelete);

        tableView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                if(t.getButton() == MouseButton.SECONDARY) {
                    contextMenu.show(tableView, t.getScreenX(), t.getScreenY());
                    Contact contact = tableView.getSelectionModel().getSelectedItem();

                    menuItemDelete.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                            System.out.println("Menu Item delete is clicked");
                            deleteContact(contact);
                        }
                    });


                    System.out.println(contact.toString());
                }
            }
        });

       // listContextMenu.getItems().addAll(deleteMenuItem);


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
        } else {
            System.out.println("Adding new contact canceled");
        }


    }

    @FXML
    public void handleExit() {
        Platform.exit();
    }

    public void deleteContact(Contact contact) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Contact");
        alert.setHeaderText("Delete Contact: " + contact.toString());
        alert.setContentText("Are you sure? Press OK to confirm, or cancel to Black out.");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            ContactData.getInstance().deleteContact(contact);
        }

    }


    @FXML
    public void handleKeyPressed(KeyEvent keyEvent) {
        Contact selectedContact = tableView.getSelectionModel().getSelectedItem();
        if (selectedContact != null) {
            if (keyEvent.getCode().equals(KeyCode.DELETE)) {
                deleteContact(selectedContact);
            }
        }

    }


}
