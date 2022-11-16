package UI;

import javax.swing.*;

/**
 * View Interface with methods that the Presenter calls to pass values for display
 */
public interface View {

    void generateGame();
    void updateCardDrawn();

    void updateCardPlayed();


}
