package ntnu.adriawh.persistance;

import ntnu.adriawh.exception.FileTypeException;
import ntnu.adriawh.model.PostalCode;

import java.io.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class TXTReader {

    /**
     * Method for reading a register from a txt file.
     *
     * @param file the file to read data from
     * @return Arraylist containing the data from the txt file
     * @throws IOException thrown if there was an error reading the file
     * @throws FileTypeException if the given file is not of type .txt
     */
    public ArrayList<PostalCode> readRegister(String file) throws IOException, FileTypeException {
        if(!file.contains(".txt")){
            throw new FileTypeException("The given file is not txt");
        }

        ArrayList<PostalCode> register = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Path.of(file), StandardCharsets.UTF_8)) {
            String data;

            while ((data = reader.readLine()) != null) {

                //Splitting the data in each line by tabulator(four spaces)
                String[] splittedData = data.split("\t");

                //If the data in the given line contains the correct amount of data an object is made
                //or else it is skipped
                if(splittedData.length == 5){
                    register.add(new PostalCode(
                            splittedData[0], //Postal code
                            splittedData[1], //post office
                            splittedData[2], //municipal code
                            splittedData[3], //municipality name
                            splittedData[4])); //category
                }
            }
        }
        return register;
    }
}
