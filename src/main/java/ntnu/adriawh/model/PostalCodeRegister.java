package ntnu.adriawh.model;

import java.util.ArrayList;

/**
 * Class to store a register of postalCodes
 */

public class PostalCodeRegister {
    private ArrayList<PostalCode> register;

    public PostalCodeRegister(){
        register = new ArrayList<>();
    }

    public ArrayList<PostalCode> getRegister() {
        return register;
    }

    /**
     *Method to add a postal code to the register
     *
     * @param postalCode the postal code to be added
     * @throws IllegalArgumentException if the postal code already exists
     */
    public void addPostalCode(PostalCode postalCode) throws IllegalArgumentException{
        if(!register.contains(postalCode)){
            register.add(postalCode);
        }else {
            throw new IllegalArgumentException("Postal code is already registered");
        }
    }
}
