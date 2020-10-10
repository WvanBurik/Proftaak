package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.Classes.Cilinder;
import main.Classes.CilinderDAO;

import javafx.event.ActionEvent;
import main.Classes.Figure;
import main.DAB.DBUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controller {

    //FXML annotations kijk yt video
    public void insertCilinder(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {

        CilinderDAO.insertCilinder(19, 17.5);
//        CilinderDAO.deleteAllCilinders();
        ArrayList<Cilinder> cilinders = CilinderDAO.readAllCilinders();
        for (Cilinder c : cilinders) {
            System.out.println(c.toString());
        }

    }
    public void deleteAllCilinders() throws SQLException, ClassNotFoundException {
        CilinderDAO.deleteAllCilinders();
    }
    public void showAllFigures() throws SQLException, ClassNotFoundException {
        Figure.showAllFigures();
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



}
