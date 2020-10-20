package main.Classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class SphereController {
    @FXML
    private TextField radius_sph;

    //FXML annotations kijk yt video
    public void insertSphere(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {

        SphereDAO.insertSphere(Double.parseDouble(radius_sph.getText()));
        ArrayList<Sphere> spheres = SphereDAO.readAllSpheres();
        for (Sphere s : spheres) {
            System.out.println(s.toString());
        }

    }
    public void cancelStage(){
        System.exit(0);
    }
}
