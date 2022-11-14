package UI;

/**
 * View Interface with methods that the Presenter calls to pass values for display
 */
public interface View {

    void createMainField();

    void createBackground(int panelNum, String bgFileName);

//    void createStartPage();
//
//    void createGamePage();
//
//    /**
//     * update the card deck of the player in the view
//     */
//    void updateCardDeck();
//
//    /**
//     * display a choose colour page with three buttons after a wildCard is played
//     */
//    void chooseColour();
}
