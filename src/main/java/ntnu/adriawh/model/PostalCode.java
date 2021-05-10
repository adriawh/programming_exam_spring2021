package ntnu.adriawh.model;

import java.util.Objects;

public class PostalCode {
    private final String code;
    private final String postOffice;
    private final String municipalCode;
    private final String municipalityName;
    private final String category;

    /**
     * Class for storing a postal code and its associated information
     *
     * @param code the postal code
     * @param postOffice the associated post office
     * @param municipalCode the associated municipal code
     * @param municipalityName the associated municipality name
     * @param category the category type of the postal code
     */

    public PostalCode(String code, String postOffice, String municipalCode, String municipalityName, String category) {
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

    public String getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostalCode zipCode = (PostalCode) o;
        return code.equals(zipCode.code);
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
