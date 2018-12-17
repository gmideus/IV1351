package util;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class AlertMaker {
        public static void showSimpleAlert(String title, String content) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(content);
            alert.showAndWait();
        }

        public static void showErrorMessage(String title, String content) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(title);
            alert.setContentText(content);

            alert.showAndWait();
        }
        
        public static boolean deleteConfirmation(String s) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete");
            alert.setContentText("Are you sure you want to delete " + s + "?\nThis will delete it permanently.");
            Optional<ButtonType> answer = alert.showAndWait();
            if(answer.get() == ButtonType.OK)
                return true;
            else
                showSimpleAlert("Deletion cancelled", "Deletion process was cancelled!");
            return false;
        }
}
