package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * This class is the controller of the main stage (main frame).
 *
 */
public class MainStageController implements Initializable {

    @FXML
    AnchorPane bodyPane;

    @FXML
    private void handleClose(MouseEvent event) {
        Platform.exit();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Node node;
        try {
            node = (Node) FXMLLoader.load(getClass().getResource("GuidesView.fxml"));
            bodyPane.getChildren().setAll(node);
        } catch (IOException e) {
            System.err.println("Couldn't locate GuidesView.fxml");
            e.printStackTrace();
        }

    }

}
