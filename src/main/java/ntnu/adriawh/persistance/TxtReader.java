package ntnu.adriawh.persistance;


import ntnu.adriawh.model.PostalCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class TxtReader {

    /**
     * Method for reading a register from a stored csv file.
     *
     * @param file the file to read data from
     * @return The register read from the given file
     * @throws IOException thrown if there was an error reading the file
     */
    public HashMap<Integer, PostalCode> readRegister(File file) throws IOException {

        HashMap<Integer, PostalCode> register = new HashMap();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String patientData;
            while ((patientData = reader.readLine()) != null) {
                String[] data = patientData.split("\t");
                register.put(Integer.parseInt(data[0]), new PostalCode(Integer.parseInt(data[0]),data[1], data[2],data[3],data[4]));
            }
        }
        return register;
    }
}
