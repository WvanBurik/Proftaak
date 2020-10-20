package main.Classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class HemisphereController {
    @FXML
    private TextField radius_hem;

    //FXML annotations kijk yt video
    public void insertHemisphere(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {

        HemisphereDAO.insertHemisphere(Double.parseDouble(radius_hem.getText()));
        ArrayList<Hemisphere> hemispheres = HemisphereDAO.readAllHemispheres();
        for (Hemisphere h : hemispheres) {
            System.out.println(h.toString());
        }

    }
    public void cancelStage(){
        System.exit(0);
    }
}
