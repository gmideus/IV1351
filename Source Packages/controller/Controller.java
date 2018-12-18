package controller;

import java.util.List;

import dto.GuideDTO;
import dto.LanguageDTO;
import integration.DBHandler;
import model.Guide;
import model.Guides;

public class Controller {
    private static final Controller CONTROLLER = new Controller();
    
    private Controller() {
        
    }
    
    public static Controller getController() {
        return Controller.CONTROLLER;
    }
    
    public List<GuideDTO> getGuides() throws Exception{
        Guides guides = new Guides();
        return guides.getGuides();
    }
    
    public Guide getGuide(GuideDTO guideDTO)throws Exception {

        Guide guide = new Guide(guideDTO);
        return guide;
    }

    public void addGuideLanguages(GuideDTO g, LanguageDTO l){

    }
}
