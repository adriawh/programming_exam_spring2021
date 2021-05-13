package ntnu.adriawh.persistance;

import ntnu.adriawh.exception.FileTypeException;
import ntnu.adriawh.model.PostalCode;
import ntnu.adriawh.model.PostalCodeRegister;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Class for reading .txt files
 */
public class TXTReader {

    /**
     * Method for reading a register from a txt file.
     *
     * @param filePath the file to read data from
     * @return the PostalCodeRegister retrived from the txt file
     * @throws IOException thrown if there was an error reading the file
     * @throws FileTypeException if the given file is not of type .txt
     */
    public PostalCodeRegister readPostalCodeRegister(String filePath) throws IOException, FileTypeException {

        if(!filePath.contains(".txt")){
            throw new FileTypeException("The given file is not txt");
        }

        PostalCodeRegister register = new PostalCodeRegister();

        try (BufferedReader reader = Files.newBufferedReader(Path.of(filePath), StandardCharsets.UTF_8)) {
            String data;
            while ((data = reader.readLine()) != null) {

                //Splitting the data in each line by tabulator(four spaces)
                String[] splittedData = data.split("\t");

                //If the data in the given line contains the correct amount of data an object is made
                //or else it is skipped
                if(splittedData.length == 5){
                   try {
                       register.addPostalCode(new PostalCode(
                               splittedData[0], //Postal code
                               splittedData[1], //post office
                               splittedData[2], //municipal code
                               splittedData[3], //municipality name
                               splittedData[4].charAt(0))); //category
                   }catch (IllegalArgumentException skipped){
                       //if the postalCode cannot be added it is skipped.
                   }
                }
            }
        }

        //If the register is empty after reading thru the file, an IOException is thrown
        if(register.getRegister().isEmpty()){
            throw new IOException("Didnt find any data in the given file");
        }else{
            return register;
        }
    }
}
