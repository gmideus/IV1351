package dto;

public class LanguageDTO {
    private String language;

    public LanguageDTO(String language) {
        this.language = language;
    }
    
    @Override
    public String toString() {
        return this.language;
    }
    public String getLanguage() {
        return this.language;
    }
}
