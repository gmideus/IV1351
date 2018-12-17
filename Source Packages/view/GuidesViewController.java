package view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controller.Controller;
import dto.GuideDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Guide;
import util.MouseHandler;

public class GuidesViewController implements Initializable{
    private ObservableList<GuideDTO> guides = FXCollections.observableArrayList();
    
    @FXML
    private AnchorPane tableViewPane;
    
    @FXML
    private TableView<GuideDTO> tableView;
    
    @FXML
    private TableColumn<GuideDTO, String> personnrColumn;
    
    @FXML
    private TableColumn<GuideDTO, String> fNamnColumn;
    
    @FXML
    private TableColumn<GuideDTO, String> eNamnColumn;
    
    @FXML
    private TableColumn<GuideDTO, String> telefonnrColumn;
    
    @FXML
    private TableColumn<GuideDTO, String> epostColumn;
    
    @FXML
    private void selectGuide(MouseEvent event) {
        if(!MouseHandler.isDoubleClick(event))
            return;
        
        GuideDTO selectedGuide = tableView.getSelectionModel().getSelectedItem();
        
        if(selectedGuide == null)
            return;
        
        Controller controller = Controller.getController();
        Guide guide = controller.getGuide(selectedGuide);
           
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Guide.fxml"));
        Node node;
        try {
            node = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return; //
        }
        
        GuideController guideController = loader.getController();
        guideController.setSelectedGuide(guide);
        
        tableViewPane.getChildren().setAll(node);

    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        setGuides();
        personnrColumn.setCellValueFactory(new PropertyValueFactory<>("personnr"));
        fNamnColumn.setCellValueFactory(new PropertyValueFactory<>("fnamn"));
        eNamnColumn.setCellValueFactory(new PropertyValueFactory<>("enamn"));
        telefonnrColumn.setCellValueFactory(new PropertyValueFactory<>("telefonnr"));
        epostColumn.setCellValueFactory(new PropertyValueFactory<>("epost"));
        
        tableView.setItems(guides);
    }
    
    private void setGuides() {
        Controller controller = Controller.getController();
        List<GuideDTO> guidesDTO = controller.getGuides();
        for (GuideDTO guide : guidesDTO)
            this.guides.add(guide);
    }

}
