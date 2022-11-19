package cards;

import game.Game;

public class WildCard extends Card {

    public WildCard(String cardType, int botPriority) {
        super(cardType, botPriority);
    }

    /**
     * Allows the player to change the colour of this card.
     *
     * @param game the Game object this card is affecting
     */
    @Override
    public void playedEffect(Game game) {
        new ColourChange_UseCaseInteractor(game.getPresenter()).requestColourChange();
        /*
        new RequestColourChange().requestColourChange();
        Get this to call the use case while preserving Clean Architecture.

        Current Flow of Code:
        WildCard > RequestColourChange (Use Case) > Presenter (Interface) > View (Interface)
        */
    }
}
