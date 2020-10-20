package main.Classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class BlockController {
    @FXML
    private TextField lngt_block;
    @FXML
    private TextField wid_block;
    @FXML
    private TextField hght_block;

    //FXML annotations kijk yt video
    public void insertBlock(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {

        BlockDAO.insertBlock(Double.parseDouble(lngt_block.getText()), Double.parseDouble(wid_block.getText()), Double.parseDouble(hght_block.getText()));

    }

    public void cancelStage() {
        System.exit(0);
    }
}
