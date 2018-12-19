package util;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 * This class is used by the View to show different messages to the user.
 *
 */
public class AlertMaker {

    /**
     * Shows a simple alert to the user with information.
     * 
     * @param title   The title of the {@link Alert}.
     * @param content The content of the {@link ALert}.
     */
    public static void showSimpleAlert(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    /**
     * Shows an error alert to the user.
     * 
     * @param title   The title of the {@link Alert}.
     * @param content The content of the {@link ALert}.
     */
    public static void showErrorMessage(String title, String content) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(title);
        alert.setContentText(content);

        alert.showAndWait();
    }

    /**
     * Shows a confirmation window to the user.
     * 
     * @param confText The text describing what should be confirmed.
     * @return true if confirmed; false otherwise.
     */
    public static boolean deleteConfirmation(String confText) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete");
        alert.setContentText("Are you sure you want to delete " + confText + "?\nThis will delete it permanently.");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK)
            return true;
        else
            showSimpleAlert("Deletion cancelled", "Deletion process was cancelled!");
        return false;
    }
}
