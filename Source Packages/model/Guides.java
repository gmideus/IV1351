package model;

import java.util.ArrayList;
import java.util.List;

import dto.GuideDTO;
import integration.DBHandler;

public class Guides {
    private List<GuideDTO> guides;
    
    public Guides() throws Exception {
        DBHandler handler = DBHandler.getDbhandler();
        this.guides = handler.getGuides();
    }
    
    public List<GuideDTO> getGuides(){
        return this.guides;
    }
}
