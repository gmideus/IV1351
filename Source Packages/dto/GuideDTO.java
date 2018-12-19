package dto;

/**
 * This class holds the basic information of a guide stored in the database.
 *
 */
public class GuideDTO {
    private String fnamn;
    private String enamn;
    private String personnr;
    private String telefonnr;
    private String epost;

    /**
     * Creates an instance of this class with information of a guide.
     * @param fnamn the first name.
     * @param enamn the last name.
     * @param personnr the personal identity number.
     * @param telefonnr the phone number.
     * @param epost the email.
     */
    public GuideDTO(String fnamn, String enamn, String personnr, String telefonnr, String epost) {
        this.fnamn = fnamn;
        this.enamn = enamn;
        this.personnr = personnr;
        this.telefonnr = telefonnr;
        this.epost = epost;
    }

    /**
     * @return the guide's first name.
     */
    public String getFnamn() {
        return this.fnamn;
    }

    /**
     * @return the guide's last name.
     */
    public String getEnamn() {
        return this.enamn;
    }

    /**
     * @return the guide's personal identity number.
     */
    public String getPersonnr() {
        return this.personnr;
    }

    /**
     * @return the guide's phone number.
     */
    public String getTelefonnr() {
        return this.telefonnr;
    }

    /**
     * @return the guide's email.
     */
    public String getEpost() {
        return this.epost;
    }
}
