package ntnu.adriawh.exception;

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


