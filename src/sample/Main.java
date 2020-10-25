package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("../main/design/sample.fxml"));
        primaryStage.setTitle("VAT");
        primaryStage.setScene(new Scene(root, 617, 468));
        primaryStage.setResizable(false);
        primaryStage.show();
    }



    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        launch(args);
    }

}

