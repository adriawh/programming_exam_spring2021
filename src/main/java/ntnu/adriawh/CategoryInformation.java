package ntnu.adriawh;

/**
 * Class containing a static method returning information about a given category
 */
public class CategoryInformation {

    /**
     * @param category the category to return information about
     * @return information about the given category
     */
    public static String get(String category){
        switch (category){
                case "B":
                    return "Both street addresses and mailboxes";
                case "F":
                    return "Multiple uses (common)";
                case "G":
                    return "Street addresses (and place addresses), ie \"green mailboxes\"";
                case "P":
                    return "Mailboxes";
                case "S":
                    return "Service postal code (these postal codes are not used for postal addresses)";
                default:
                    return "Could not get information about the category";
            }
    }
}
