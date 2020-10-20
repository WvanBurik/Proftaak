package main.Classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class PyramidController {
    @FXML
    private TextField height_pyr;
    @FXML
    private TextField base_pyr;

    public void insertPyramid(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {

        PyramidDAO.insertPyramid(Double.parseDouble(height_pyr.getText()), Double.parseDouble(base_pyr.getText()));
        ArrayList<Pyramid> pyramids = PyramidDAO.readAllPyramids();
        for (Pyramid p : pyramids) {
            System.out.println(p.toString());
        }

    }
    public void cancelStage(){
        System.exit(0);
    }
}
