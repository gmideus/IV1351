package dto;

public class GuideDTO {
    private String fnamn;
    private String enamn;
    private String personnr;
    private String telefonnr;
    private String epost;
    
    public GuideDTO(String fnamn, String enamn, String personnr, String telefonnr, String epost) {
        this.fnamn = fnamn;
        this.enamn = enamn;
        this.personnr = personnr;
        this.telefonnr = telefonnr;
        this.epost = epost;
    }
    
    public String getFnamn() {
        return this.fnamn;
    }
    
    public String getEnamn() {
        return this.enamn;
    }
    
    public String getPersonnr() {
        return this.personnr;
    }
    
    public String getTelefonnr() {
        return this.telefonnr;
    }
    
    public String getEpost() {
        return this.epost;
    }
}
