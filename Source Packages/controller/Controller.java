package controller;

import java.util.List;

import dto.GuideDTO;
import model.Guide;
import model.Guides;

public class Controller {
    private static final Controller CONTROLLER = new Controller();
    
    private Controller() {
        
    }
    
    public static Controller getController() {
        return Controller.CONTROLLER;
    }
    
    public List<GuideDTO> getGuides(){
        Guides guides = new Guides();
        return guides.getGuides();
    }
    
    public Guide getGuide(GuideDTO guideDTO) {
        Guide guide = new Guide(guideDTO);
        return guide;
    }
}
