package primrim;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import primrim.datamodel.Contact;
import primrim.datamodel.ContactData;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainwindow.fxml"));

        setUserAgentStylesheet(STYLESHEET_MODENA);
        primaryStage.setTitle("MyContacts");
        primaryStage.setScene(new Scene(root, 900, 500));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);



    }



    @Override
    public void init() throws  Exception{
            ContactData.getInstance().loadContactsData();

    }

    @Override
    public void stop() throws Exception {


    }



}
