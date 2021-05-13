package ntnu.adriawh.model;

import java.util.Objects;

/**
 * Class for storing a postal code and its associated information.
 * All attributes are final, as the applications purpose only is to show information.
 */
public class PostalCode {
    private final String code;
    private final String postOffice;
    private final String municipalCode;
    private final String municipalityName;
    private final char category;

    /**
     * @param code the postal code, stored as string to maintain 4 digits
     * @param postOffice the associated post office
     * @param municipalCode the associated municipal code, stored as string to maintain 4 digits
     * @param municipalityName the associated municipality name
     * @param category the category type of the postal code
     */

    public PostalCode(String code, String postOffice, String municipalCode, String municipalityName, char category) throws IllegalArgumentException{
        if(code.length() != 4){
           throw new IllegalArgumentException("A postal code must contain 4 digits");
        }else if(municipalCode.length() != 4){
            throw new IllegalArgumentException("A municipal code must contain 4 digits");
        }
        this.code = code;
        this.postOffice = postOffice;
        this.municipalCode = municipalCode;
        this.municipalityName = municipalityName;
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public String getPostOffice() {
        return postOffice;
    }

    public String getMunicipalCode() {
        return municipalCode;
    }

    public String getMunicipalityName() {
        return municipalityName;
    }

    public char getCategory() {
        return category;
    }

    /**
     * Equals method checks if the code pof the postal codes are equal
     *
     * @param o the object to be compared to
     * @return true if the postal code is equal, false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostalCode code1 = (PostalCode) o;
        return code.equals(code1.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "ZipCode{" +
                "code=" + code +
                ", postOffice='" + postOffice + '\'' +
                ", municipalCode='" + municipalCode + '\'' +
                ", municipalityName='" + municipalityName + '\'' +
                ", category=" + category +
                '}';
    }
}
