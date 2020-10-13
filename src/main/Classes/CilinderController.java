package main.Classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class CilinderController {
    @FXML
    private TextField height_cil;
    @FXML
    private TextField radius_cil;

    //FXML annotations kijk yt video
    public void insertCilinder(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {

        CilinderDAO.insertCilinder(Double.parseDouble(height_cil.getText()), Double.parseDouble(radius_cil.getText()));
//        CilinderDAO.deleteAllCilinders();
        ArrayList<Cilinder> cilinders = CilinderDAO.readAllCilinders();
        for (Cilinder c : cilinders) {
            System.out.println(c.toString());
        }

    }
    public void cancelStage(){
        System.exit(0);
    }
}
