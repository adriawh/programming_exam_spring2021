package ntnu.adriawh.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PostalCodeRegisterTest {

    @Test
    public void addPostalCodePositive() {
        PostalCodeRegister testRegister = new PostalCodeRegister();
        PostalCode test = new PostalCode("0010", "Test", "1000", "Test", 'S');

        testRegister.addPostalCode(test);
        assertTrue(testRegister.getRegister().contains(test));
    }

    @Test
    public void addPostalCodeNegative(){
        PostalCodeRegister testRegister = new PostalCodeRegister();
        PostalCode test1 = new PostalCode("0010", "Test1", "1000", "Test1", 'S');
        PostalCode test2 = new PostalCode("0010", "Test2", "1000", "Test2", 'P');

        testRegister.addPostalCode(test1);
        assertThrows(IllegalArgumentException.class, ()->testRegister.addPostalCode(test2));
    }


}