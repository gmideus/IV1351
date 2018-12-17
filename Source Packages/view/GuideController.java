package view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dto.GuideDTO;
import dto.LanguageDTO;
import dto.ShowExpertiesDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Guide;

public class GuideController implements Initializable{
    private Guide guide;
    private ObservableList<LanguageDTO> languages; //= FXCollections.observableArrayList();
    private ObservableList<ShowExpertiesDTO> showExperties = FXCollections.observableArrayList();
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private TableView<LanguageDTO> languagesTableView;
    @FXML
    private TableView<ShowExpertiesDTO> showExpertiesTableView;
    
    @FXML
    private TableColumn<LanguageDTO, String> languagesColumn;
    @FXML
    private TableColumn<ShowExpertiesDTO, String> showExpertiesColumn;
    
    @FXML
    private Label fNamn;
    @FXML
    private Label eNamn;
    @FXML
    private Label personnr;
    @FXML
    private Label telefonnr;
    @FXML
    private Label epost;
    
    
    @FXML
    private void previousPage(ActionEvent event) {
        Node node;
        try {
            node = (Node)FXMLLoader.load(getClass().getResource("GuidesView.fxml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        }
        anchorPane.getChildren().setAll(node);
        
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        languagesColumn.setCellValueFactory(new PropertyValueFactory<>("language"));
        showExpertiesColumn.setCellValueFactory(new PropertyValueFactory<>("showName"));
        
    }
    
    void setSelectedGuide(Guide guide) {
        this.guide = guide;
        GuideDTO guideDTO = guide.getGuideDTO();
        fNamn.setText(guideDTO.getFnamn());
        eNamn.setText(guideDTO.getEnamn());
        personnr.setText(guideDTO.getPersonnr());
        telefonnr.setText(guideDTO.getTelefonnr());
        epost.setText(guideDTO.getEpost());
        setLanguages();
        setShowExperties();
        languagesTableView.setItems(this.languages);
        showExpertiesTableView.setItems(this.showExperties);
        //fill experties
    }
    
    private void setLanguages() {
        List<LanguageDTO> languages = guide.getLanguages();
        this.languages = FXCollections.observableArrayList(languages);
        /*
        for(LanguageDTO language : languages)
            this.languages.add(language);
            */
    }
    
    private void setShowExperties() {
        List<ShowExpertiesDTO> showExperties = guide.getShowExperties();
        this.showExperties = FXCollections.observableArrayList(showExperties);
    }

    
}
