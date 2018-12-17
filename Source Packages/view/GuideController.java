package view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dto.GuideDTO;
import dto.LanguageDTO;
import dto.ShowDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Guide;
import util.AlertMaker;

public class GuideController implements Initializable{
    private Guide guide;
    private ObservableList<LanguageDTO> languages;
    private ObservableList<ShowDTO> showExperties;

    @FXML
    private ComboBox<LanguageDTO> languageCombo;
    @FXML
    private ComboBox<ShowDTO> showCombo;





    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TableView<LanguageDTO> languagesTableView;
    @FXML
    private TableView<ShowDTO> showExpertiesTableView;

    @FXML
    private TableColumn<LanguageDTO, String> languageColumn;
    @FXML
    private TableColumn<ShowDTO, String> showColumn;

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



    @FXML
    private void addLanguage(ActionEvent event) {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        languageColumn.setCellValueFactory(new PropertyValueFactory<>("language"));
        showColumn.setCellValueFactory(new PropertyValueFactory<>("showName"));
        languagesTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

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
        this.languageCombo.setItems(this.languages); //REMOVE

    }

    private void setLanguages() {
        List<LanguageDTO> languages = guide.getLanguages();
        this.languages = FXCollections.observableArrayList(languages);
    }

    private void setShowExperties() {
        List<ShowDTO> showExperties = guide.getShowExperties();
        this.showExperties = FXCollections.observableArrayList(showExperties);
    }


}