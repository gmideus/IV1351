package dto;

/**
 * This class holds information of a show, such as: the name of the show, the
 * start and end time of the show and the show's id.
 *
 */
public class ShowDTO {
    private String showName;
    private int ID;
    private String startDate;
    private String endDate;

    /**
     * Creates an instance of this class.
     * 
     * @param showName  The name of the show.
     * @param ID        The id of the show.
     * @param startDate The start date of the show.
     * @param endDate   The end date of the show.
     */
    public ShowDTO(String showName, int ID, String startDate, String endDate) {
        this.showName = showName;
        this.ID = ID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String toString() {
        return this.showName + " | " + this.startDate + " | " + this.endDate;
    }

    /**
     * @return the name of the show.
     */
    public String getShowName() {
        return this.showName;
    }

    /**
     * @return the id of the show.
     */
    public int getID() {
        return ID;
    }

    /**
     * @return the start date of the show.
     */
    public String getStartDate() {
        return this.startDate;
    }

    /**
     * @return the end date of the show.
     */
    public String getEndDate() {
        return this.endDate;
    }
}
