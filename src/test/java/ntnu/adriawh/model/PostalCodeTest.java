package ntnu.adriawh.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PostalCodeTest {

    @Test
    @DisplayName("An instance of Postal code can be made when correct data is given")
    public void postalCodePositive(){
        PostalCode test = null;
        try{
            test = new PostalCode("0010", "Test", "1000", "Test", 'S');
        }catch (IllegalArgumentException e){
            fail(e);
        }
        assertNotNull(test);
    }

    @Nested
    public class postalCodeNegative{

        @Test
        @DisplayName("IllegalArgumentException is thrown if there isn't 4 digits in the postal code")
        public void postalCodeWrongDigitPostalCode(){
            assertThrows(IllegalArgumentException.class, ()-> new PostalCode("00101", "Test", "1000", "Test", 'S'));
        }
        @Test
        @DisplayName("IllegalArgumentException is thrown if there isn't 4 digits in the municipal code")
        public void postalCodeWrongDigitMunicipalCode(){
            assertThrows(IllegalArgumentException.class, ()-> new PostalCode("0010", "Test", "10001", "Test", 'S'));
        }
    }

}