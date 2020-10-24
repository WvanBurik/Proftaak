package main.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import main.classes.Hemisphere;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class HemisphereController {
    @FXML
    private TextField radius_hem;

    public void insertHemisphere(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        Hemisphere.createHemisphere(Double.parseDouble(radius_hem.getText()));

        ArrayList<Hemisphere> hemispheres = Hemisphere.readAllFigures();
        for (Hemisphere h : hemispheres) {
            System.out.println(h.toString());
        }

    }
    public void cancelStage(){
        System.exit(0);
    }
}
