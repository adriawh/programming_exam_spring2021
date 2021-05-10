package ntnu.adriawh.persistance;


import ntnu.adriawh.exception.FileTypeException;
import ntnu.adriawh.model.PostalCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;

public class TxtReaderTest {

    @Test
    @DisplayName("Reading when correct filetype with correct data given")
    public void positive(){
        TxtReader reader = new TxtReader();
        ArrayList<PostalCode> test = null;
        try{
            test = reader.readRegister("src/test/java/ntnu/adriawh/persistance/positiveTest.txt");
        }catch (IOException | FileTypeException e){
            fail(e);
        }
        assertEquals(1, test.size());
    }

    @Nested
    public class negativeTests{
        @Test
        public void wrongFiletype(){
            TxtReader reader = new TxtReader();
            assertThrows(FileTypeException.class , ()-> reader.readRegister("src/test/java/ntnu/adriawh/persistance/positiveTest.csv"));
        }
        @Test
        public void fileContainingIncompleteData(){
            TxtReader reader = new TxtReader();
            ArrayList<PostalCode> test = null;
            try{
                test = reader.readRegister("src/test/java/ntnu/adriawh/persistance/NegativeTest.txt");
            }catch (IOException | FileTypeException e){
                fail(e);
            }
            assertEquals(2, test.size());
        }
    }



}