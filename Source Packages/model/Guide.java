package model;

import java.util.ArrayList;
import java.util.List;

import dto.GuideDTO;
import dto.LanguageDTO;
import dto.ShowDTO;
import integration.DBHandler;

public class Guide {
    private GuideDTO guideDTO;
    private List<LanguageDTO> languages;
    private List<ShowDTO> showExperties; //utställningskompetens. kanske skapa object med id...
    
    public Guide (GuideDTO guideDTO) throws Exception{
        this.guideDTO = guideDTO;
        DBHandler handler = DBHandler.getDbhandler();
        this.languages = handler.getGuideLanguages(guideDTO);
        this.showExperties = handler.getGuideShows(guideDTO);
        //fill languages from database
        //fill showExperties from database
        //addLanguage("spanska"); //remove
        //addLanguage("svenska"); //remove
        //addShow("The Opening", 1);
    }
    
    
    
    public void addLanguage(String language) {
        LanguageDTO languageDTO = new LanguageDTO(language);
        languages.add(languageDTO);
    }
    
    public void addShow(String show, int id) {
        ShowDTO showDTO = new ShowDTO(show, id, "start", "slut");
        showExperties.add(showDTO);
    }
    
    public List<LanguageDTO> getLanguages(){
        return this.languages;
    }
    
    public List<ShowDTO> getShowExperties(){
        return this.showExperties;
    }
    
    public GuideDTO getGuideDTO() {
        return this.guideDTO;
    }
}
