package dto;

public class ShowDTO {
    private String showName;
    private int ID;
    private String startDate;
    private String endDate;

    public ShowDTO(String showName, int ID, String startDate, String endDate) {
        this.showName = showName;
        this.ID = ID;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public String toString() {
        return this.showName + " | " + this.startDate + " | " + this.endDate;
    }
    
    public String getShowName() {
        return this.showName;
    }

    public int getID() {
        return ID;
    }

    public String getStartDate(){
        return this.startDate;
    }

    public String getEndDate(){
        return this.endDate;
    }
}
