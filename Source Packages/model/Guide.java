package model;

import java.util.ArrayList;
import java.util.List;

import dto.GuideDTO;
import dto.LanguageDTO;
import dto.ShowExpertiesDTO;

public class Guide {
    private GuideDTO guideDTO;
    private List<LanguageDTO> languages;
    private List<ShowExpertiesDTO> showExperties; //utställningskompetens. kanske skapa object med id...
    
    public Guide (GuideDTO guideDTO) {
        this.guideDTO = guideDTO;
        this.languages = new ArrayList<LanguageDTO>();
        this.showExperties = new ArrayList<ShowExpertiesDTO>();
        //fill languages from database
        //fill showExperties from database
        addLanguage("Spanska"); //remove
        addLanguage("Svenska"); //remove
    }
    
    
    
    public void addLanguage(String language) {
        LanguageDTO languageDTO = new LanguageDTO(language);
        languages.add(languageDTO);
    }
    
    public void addShow() {
        
    }
    
    public List<LanguageDTO> getLanguages(){
        return this.languages;
    }
    
    public GuideDTO getGuideDTO() {
        return this.guideDTO;
    }
}
