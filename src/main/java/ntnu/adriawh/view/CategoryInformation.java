package ntnu.adriawh.view;

/**
 * Utility Class containing a static method returning information about a given category
 */
public class CategoryInformation {

    /**
     * If the class is tried to be initialized, an exception is thrown.
     * Utility classes can not be initialized.
     */
    private CategoryInformation(){
        throw new IllegalStateException("Can not be initiated since it is a utility class");
    }

    /**
     * @param category the category to return information about
     * @return information about the given category
     */
    public static String get(char category){
        switch (category){
                case 'B':
                    return "Both street addresses and mailboxes";
                case 'F':
                    return "Multiple uses (common)";
                case 'G':
                    return "Street addresses (and place addresses), ie \"green mailboxes\"";
                case 'P':
                    return "Mailboxes";
                case 'S':
                    return "Service postal code (these postal codes are not used for postal addresses)";
                default:
                    return "Could not get information about the category";
        }
    }
}
