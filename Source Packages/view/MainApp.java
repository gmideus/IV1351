package view;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;



public class MainApp extends Application {
    private double xOffset = 0;
    private double yOffset = 0;
    
    public static void launchApp() {
        launch();
    }
    
	@Override
	public void start(Stage primaryStage) {
		try { 
		    Parent root = FXMLLoader.load(getClass().getResource("MainStage.fxml"));
		    primaryStage.initStyle(StageStyle.UNDECORATED);
		    
		    Scene scene = new Scene(root);
		    
		    root.setOnMousePressed(new EventHandler<MouseEvent>(){
		        @Override
		        public void handle(MouseEvent event) {
		            xOffset = event.getSceneX();
		            yOffset = event.getSceneY();
		        }
		    });
		    root.setOnMouseDragged(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    primaryStage.setX(event.getScreenX() - xOffset);
                    primaryStage.setY(event.getScreenY() - yOffset);
                }
            });
			
			primaryStage.setScene(scene);
			primaryStage.show();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
