package startup;

import integration.DBAccess;
import view.MainApp;

public class Startup {

    public static void main(String[] args) throws Exception {
        /*Connect to database*/
        DBAccess db = DBAccess.getDBAccess();
        db.connect();
        MainApp.launchApp();

    }

}
