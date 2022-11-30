package interfaceAdapters;


import java.util.List;

/**
 * An interface of methods that lower level objects can freely interface with.
 */
public interface Presenter_Interface {
    void requestNewColour();

    void updateHand(String[] cards);

    void updateLastPlayed(String card, int toMove);
    void displayOptions(List<String> cards);

}
