package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.Classes.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ListView show_all;
//
//    //FXML annotations kijk yt video
//    public void insertCilinder(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
//
//        CilinderDAO.insertCilinder(Double.parseDouble(height_cil.getText()), 3);
////        CilinderDAO.deleteAllCilinders();
//        ArrayList<Cilinder> cilinders = CilinderDAO.readAllCilinders();
//        for (Cilinder c : cilinders) {
//            System.out.println(c.toString());
//        }
//
//    }
//
//    public void deleteAllCilinders() throws SQLException, ClassNotFoundException {
//        CilinderDAO.deleteAllCilinders();
//    }

    public void showAllFigures() throws SQLException, ClassNotFoundException {
        FigureDAO.readAllFigures();
    }

    public void stageCilinder(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cilinder.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOpacity(1);
        stage.setTitle("Cilinder");
        stage.setScene(new Scene(root, 469, 157));
        stage.showAndWait();
    }

    public void stageBlock(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("block.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOpacity(1);
        stage.setTitle("Block");
        stage.setScene(new Scene(root, 469, 157));
        stage.showAndWait();
    }
    public void stageHemisphere(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hemisphere.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOpacity(1);
        stage.setTitle("Hemisphere");
        stage.setScene(new Scene(root, 469, 157));
        stage.showAndWait();
    }
    public void stageSphere(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sphere.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOpacity(1);
        stage.setTitle("Sphere");
        stage.setScene(new Scene(root, 469, 157));
        stage.showAndWait();
    }
    public void stagePyramid(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pyramid.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOpacity(1);
        stage.setTitle("Pyramid");
        stage.setScene(new Scene(root, 469, 157));
        stage.showAndWait();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
