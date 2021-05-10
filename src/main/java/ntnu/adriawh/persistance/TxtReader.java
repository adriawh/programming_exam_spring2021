package ntnu.adriawh.persistance;


import ntnu.adriawh.model.PostalCode;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class TxtReader {

    /**
     * Method for reading a register from a stored csv file.
     *
     * @param file the file to read data from
     * @return The register read from the given file
     * @throws IOException thrown if there was an error reading the file
     */
    public ArrayList<PostalCode> readRegister(String file) throws IOException {

        ArrayList<PostalCode> register = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Cp1252"))) {
            String data;
            while ((data = reader.readLine()) != null) {
                String[] splittedData = data.split("\t");

                register.add(new PostalCode(
                        splittedData[0], //Postal code
                        splittedData[1], //post office
                        splittedData[2], //municipal code
                        splittedData[3], //municipality name
                        splittedData[4])); //category
            }
        }
        return register;
    }
}
