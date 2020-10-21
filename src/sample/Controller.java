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
        ArrayList<Figure> figures = FigureDAO.readAllFigures();
                show_all.setItems(items);
                for (Figure f : figures) {
                    items.add(f.toString());
                    System.out.println(f.toString());
                }


    }

    public void showAllVolume() throws SQLException, ClassNotFoundException {

        double totalVolume = FigureDAO.readAllFiguresForTotalVolume();
        total_volume_all.setText(String.valueOf(totalVolume));
    }

    public void deleteSelected() throws SQLException, ClassNotFoundException {
        final int selectedIdx = show_all.getSelectionModel().getSelectedIndex();
        final String getSelItem = show_all.getSelectionModel().getSelectedItem();

        String DBId = getSelItem.substring(getSelItem.indexOf("{id") + 4, getSelItem.indexOf("}"));

        String toStringVal = getSelItem;
        int iend = toStringVal.indexOf("{");
        String classString = "";

        if (iend != -1)
        {
            classString= toStringVal.substring(0 , iend); //this will give abc
        }
        //Deletes local
        show_all.getItems().remove(selectedIdx);

        //Deletes in DB
        switch(classString) {
            case "Block":
                Block.deleteFigure(DBId);
                break;
            case "Cilinder":
                Cilinder.deleteFigure(DBId);
                break;
            case "Hemisphere":
                Hemisphere.deleteFigure(DBId);
                break;
            case "Pyramid":
                Pyramid.deleteFigure(DBId);
                break;
            case "Sphere":
                Sphere.deleteFigure(DBId);
                break;
        }

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
        try {
            showAllFigures();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
