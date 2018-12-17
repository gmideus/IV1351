package dto;

public class ShowExpertiesDTO {
    private String showName;
    private int ID;

    public ShowExpertiesDTO(String showName, int ID) {
        this.showName = showName;
        this.ID = ID;
    }
    
    public String getShowName() {
        return this.showName;
    }

    public int getID() {
        return ID;
    }
}
