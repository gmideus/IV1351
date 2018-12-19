package dto;

/**
 * This class holds a language and is used by {@link Guide} and also necessary
 * to the View.
 *
 */
public class LanguageDTO {
    private String language;

    /**
     * Creates an instance of this class with the given language.
     * 
     * @param language the language.
     */
    public LanguageDTO(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return this.language;
    }

    /**
     * @return the language.
     */
    public String getLanguage() {
        return this.language;
    }
}
