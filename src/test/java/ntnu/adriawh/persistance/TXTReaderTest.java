package ntnu.adriawh.persistance;


import ntnu.adriawh.exception.FileTypeException;
import ntnu.adriawh.model.PostalCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;

public class TXTReaderTest {

    @Test
    @DisplayName("Reading when correct filetype with correct data given")
    public void positive(){
        TXTReader reader = new TXTReader();
        ArrayList<PostalCode> test = null;
        try{
            test = reader.readPostalCodeRegister("src/test/java/ntnu/adriawh/persistance/positiveTest.txt");
        }catch (IOException | FileTypeException e){
            fail(e);
        }
        assertEquals(1, test.size());
    }

    @Nested
    public class negativeTests{

        @Test
        @DisplayName("Reading from a non txt file")
        public void wrongFiletype(){
            TXTReader reader = new TXTReader();
            assertThrows(FileTypeException.class , ()-> reader.readPostalCodeRegister("src/test/java/ntnu/adriawh/persistance/positiveTest.csv"));
        }
        @Test
        @DisplayName("Reading from a file containing lines of incomplete data")
        public void fileContainingIncompleteData(){
            TXTReader reader = new TXTReader();
            ArrayList<PostalCode> test = null;
            try{
                test = reader.readPostalCodeRegister("src/test/java/ntnu/adriawh/persistance/NegativeTest.txt");
            }catch (IOException | FileTypeException e){
                fail(e);
            }
            assertEquals(2, test.size());
        }
        @Test
        @DisplayName("Reading from an empty file")
        public void emptyFile(){
            TXTReader reader = new TXTReader();

            assertThrows(IOException.class, ()-> reader.readPostalCodeRegister("src/test/java/ntnu/adriawh/persistance/emptyFile.txt"));
        }
    }
}