package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField total_volume_all;

    @FXML
    private ListView<String> show_all;


    public void showAllFigures() throws SQLException, ClassNotFoundException {
        ObservableList<String> items = FXCollections.observableArrayList();

        Connection Conn = null;

        try {
            Conn = DriverManager.getConnection("jdbc:mysql://localhost/proftaak?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
            System.out.println("Verbonden met de database");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Verbinding met de database is mislukt.");
        }
//        show_all.setItems(items);
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = Conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM cilinder");

            while (rs.next()) {
                show_all.setItems(items);
                items.add(rs.getString(2));
                System.out.println("Height: "+rs.getString(2) +" Radius: "+ rs.getString(3));
            }
        } catch (SQLException e) {

        }
    }
    public void showAllVolume() throws SQLException, ClassNotFoundException {
        FigureDAO.readAllFiguresForTotalVolume();
    }

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

//    public void showAllFigures() throws SQLException, ClassNotFoundException {
//        FigureDAO.readAllFigures();
//    }

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
        try {
            showAllFigures();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
