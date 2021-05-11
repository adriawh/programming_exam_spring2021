package ntnu.adriawh.exception;

/**
 * An exception to be thrown if there is an error with the filetype to be handled
 */
public class FileTypeException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     *
     * @param error the errormessage the developer wants to display when thrown
     */
    public FileTypeException(String error) {
        super(error);
    }
}


