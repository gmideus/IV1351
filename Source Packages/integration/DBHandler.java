package integration;

import dto.GuideDTO;
import dto.LanguageDTO;
import dto.ShowExpertiesDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBHandler {

    private static final DBHandler DBHANDLER = new DBHandler();
    private DBAccess db = DBAccess.getDBAccess();


    public static DBHandler getDbhandler(){
        return DBHANDLER;
    }

    public static void main(String[] args) throws Exception{
        DBHandler handler = getDbhandler();
        handler.db.connect();
        for(GuideDTO g: handler.getGuides()){
            System.out.println(g.getFnamn() + " " + g.getEnamn());
        }
        GuideDTO g = new GuideDTO("hej", "du", "9510221344", "", "");
        handler.addShowExperties(g, new ShowExpertiesDTO("The Opening", 1));
        for(LanguageDTO l : handler.getLanguages(g)){
            System.out.println(l.getLanguage());
        }
        for(ShowExpertiesDTO s : handler.getShowExperties(new GuideDTO("hej", "du", "9510221344", "", ""))){
            System.out.println(s.getShowName());
        }
        handler.db.getDBConnection().close();
    }

    public ArrayList<GuideDTO> getGuides() throws Exception{
        Connection con = db.getDBConnection();
        String query = "SELECT * FROM guide";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ArrayList<GuideDTO> result = new ArrayList<>();
        while(rs.next()){
            result.add(new GuideDTO(rs.getString("fnamn"), rs.getString("enamn"), rs.getString("personnr"), rs.getString("telefonnr"), rs.getString("epost")));
        }
        return result;
    }

    public ArrayList<LanguageDTO> getLanguages(GuideDTO g)throws Exception{
        Connection con = db.getDBConnection();
        String query = "Select * from språk";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ArrayList<LanguageDTO> result = new ArrayList<>();
        while(rs.next()){
            result.add(new LanguageDTO(rs.getString("språk")));
        }
        return result;
    }

    public ArrayList<ShowExpertiesDTO> getShows()throws Exception{
        Connection con = db.getDBConnection();
        String query = "Select * from utställning";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ArrayList<ShowExpertiesDTO> result = new ArrayList<>();
        while(rs.next()){
            result.add(new ShowExpertiesDTO(rs.getString("namn"), rs.getInt("id")));
        }
        return result;
    }


    public ArrayList<LanguageDTO> getGuideLanguages(GuideDTO g)throws Exception{
        Connection con = db.getDBConnection();
        String query = "Select språk from språkkunskap where guide = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, g.getPersonnr());
        ResultSet rs = stmt.executeQuery();
        ArrayList<LanguageDTO> result = new ArrayList<>();
        while(rs.next()){
            result.add(new LanguageDTO(rs.getString("språk")));
        }
        return result;
    }

    public ArrayList<ShowExpertiesDTO> getShowExperties(GuideDTO g)throws Exception{
        Connection con = db.getDBConnection();
        String query = "select namn, id, startdatum, slutdatum from utställning where id in (select utställning from utställningskompetens where guide = ?);";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, g.getPersonnr());
        ResultSet rs = stmt.executeQuery();
        ArrayList<ShowExpertiesDTO> result = new ArrayList<>();
        while(rs.next()){
            result.add(new ShowExpertiesDTO(rs.getString("namn"), rs.getInt("id")));
        }
        return result;
    }

    public void addLanguage(GuideDTO g, LanguageDTO l) throws Exception{
        Connection con = db.getDBConnection();
        String query = "insert into språkkunskap (guide, språk) values (?, ?)";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, g.getPersonnr());
        stmt.setString(2, l.getLanguage());
        stmt.executeUpdate();
        stmt.close();
        con.commit();
    }

    public void addShowExperties(GuideDTO g, ShowExpertiesDTO s) throws Exception{
        Connection con = db.getDBConnection();
        String query = "insert into utställningskompetens (guide, utställning) values (?, ?)";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, g.getPersonnr());
        stmt.setInt(2, s.getID());
        stmt.executeUpdate();
        stmt.close();
        con.commit();
    }

    public void removeLanguage(GuideDTO g, LanguageDTO l) throws Exception{
        Connection con = db.getDBConnection();
        String query = "delete from språkkunskap where guide = ? and språk= ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, g.getPersonnr());
        stmt.setString(2, l.getLanguage());
        stmt.executeUpdate();
        stmt.close();
        con.commit();
    }

    public void removeShowExperties(GuideDTO g, ShowExpertiesDTO s) throws Exception{
        Connection con = db.getDBConnection();
        String query = "delete from utställningskompetens where guide = ? and utställning = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, g.getPersonnr());
        stmt.setInt(2, s.getID());
        stmt.executeUpdate();
        stmt.close();
        con.commit();
    }

}
