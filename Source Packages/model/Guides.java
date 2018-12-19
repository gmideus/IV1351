package model;

import java.sql.SQLException;
import java.util.List;

import dto.GuideDTO;
import integration.DBHandler;

/**
 * This class holds a <code>List</code> of {@link GuideDTO}:s of all the guides
 * in the database.
 */
public class Guides {
    private List<GuideDTO> guides;

    /**
     * Creates an instance of {@link Guides} which retrieves all the guides and
     * stores them.
     * 
     * @throws SQLException if the query to the database fails.
     */
    public Guides() throws SQLException {
        DBHandler handler = DBHandler.getDbhandler();
        this.guides = handler.getGuides();
    }

    /**
     * Returns all the guides.
     * 
     * @return a <code>List</code> of {@link GuideDTO}.
     */
    public List<GuideDTO> getGuides() {
        return this.guides;
    }
}
