package model;

import java.util.ArrayList;
import java.util.List;

import dto.GuideDTO;

public class Guides {
    private List<GuideDTO> guides;
    
    public Guides() {
        this.guides = new ArrayList<GuideDTO>();
        GuideDTO kalle = new GuideDTO("Kalle", "Anka", "123", "112", "mail@hotmail.com");
        guides.add(kalle);
    }
    
    public List<GuideDTO> getGuides(){
        return this.guides;
    }
}
