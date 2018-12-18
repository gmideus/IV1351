package model;

import java.util.ArrayList;
import java.util.List;

import dto.GuideDTO;
import dto.LanguageDTO;
import dto.ShowDTO;
import integration.DBHandler;

public class Guide {
    private GuideDTO guideDTO;

    
    public Guide (GuideDTO guideDTO) throws Exception{
        this.guideDTO = guideDTO;
        //fill languages from database
        //fill showExperties from database
        //addLanguage("spanska"); //remove
        //addLanguage("svenska"); //remove
        //addShow("The Opening", 1);
    }
    
    
    
    public boolean addLanguage(LanguageDTO l) throws Exception{
        DBHandler handler = DBHandler.getDbhandler();
        return handler.addGuideLanguage(this.guideDTO, l);
    }
    
    public boolean addShow(ShowDTO s) throws Exception{
        DBHandler handler = DBHandler.getDbhandler();
        return handler.addGuideShow(this.guideDTO, s);
    }

    public boolean removeLanguage(LanguageDTO l) throws Exception{
        DBHandler handler = DBHandler.getDbhandler();
        if(handler.languageRemovable(this.guideDTO, l))
            return handler.removeGuideLanguage(this.guideDTO, l);
        else
            return false;
    }

    public boolean removeShow(ShowDTO s) throws Exception{
        DBHandler handler = DBHandler.getDbhandler();
        if(handler.showRemovable(this.guideDTO, s))
            return handler.removeGuideShow(this.guideDTO, s);
        else
            return false;
    }
    
    public List<LanguageDTO> getLanguages() throws Exception{
        DBHandler handler = DBHandler.getDbhandler();
        return handler.getGuideLanguages(this.guideDTO);
    }
    
    public List<ShowDTO> getShows()throws Exception{
        DBHandler handler = DBHandler.getDbhandler();
        return handler.getGuideShows(this.guideDTO);
    }

    public List<LanguageDTO> getPotentialLanguages() throws Exception{
        DBHandler handler = DBHandler.getDbhandler();
        return handler.getPotentialLanguages(this.guideDTO);
    }

    public List<ShowDTO> getPotentialShows()throws Exception{
        DBHandler handler = DBHandler.getDbhandler();
        return handler.getPotentialShows(this.guideDTO);
    }
    
    public GuideDTO getGuideDTO() {
        return this.guideDTO;
    }
}
