package util;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * This class holds functions to get information from {@link MouseEvent}:s.
 *
 */
public class MouseHandler {

    /**
     * Checks if the event was a double click.
     * 
     * @param event The mouse event.
     * @return true if it was a double click; false otherwise.
     */
    public static boolean isDoubleClick(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            if (event.getClickCount() == 2) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * Checks if the event was a right click.
     * 
     * @param event The mouse event.
     * @return true if it was a right click; false otherwise.
     */
    public static boolean isRightClick(MouseEvent event) {
        return event.getButton().equals(MouseButton.SECONDARY);
    }

}
