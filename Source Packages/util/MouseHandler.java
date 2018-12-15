package util;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class MouseHandler {
    
    public static boolean isDoubleClick(MouseEvent event) {
        if(event.getButton().equals(MouseButton.PRIMARY)) {
            if(event.getClickCount() == 2) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    
    public static boolean isRightClick(MouseEvent event) {
        return event.getButton().equals(MouseButton.SECONDARY);
    }
    
}
