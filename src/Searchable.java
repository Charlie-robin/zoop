// DEFINING OUR INTERFACE
public interface Searchable {
    // CONTRACT -> DESCRIBES SOMETHING THAT CAN BE SEARCHED
    // WHAT-THEY-WILL-RETURN METHOD-NAME
    String toString();
    // DEFINE THE PARAMETERS OF THE METHOD -> TYPE ETC..
    boolean hasMatch(String searchTerm);
}
