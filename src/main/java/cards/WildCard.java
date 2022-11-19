package cards;

import game.Game;

public class WildCard extends Card {

    public WildCard(String cardType) {
        super(cardType);
    }

    /**
     * Allows the player to change the colour of this card.
     *
     * @param game the Game object this card is affecting
     */
    @Override
    public void playedEffect(Game game) {
        ChangeColour useCase = new ChangeColour_Interface();
        super.setColour(useCase.getNewColour());
        /*
        Make this method call a use case. The use case will handle changing the colour of this card.
        The use case will ask the interface to provide an input which it will return to this method.
        The main issue with this is that we'll break clean architecture.
        This entity would be calling a use case/an interface. Even if we made this abstract,
        we'd need to create an object somewhere (Maybe we can still do this).

        Alternatively, we could have the draw system handle this code,
        getting the interface to change colour whenever a Wild is played,
        but that means we loose abstraction (we need to check the type of the card).

         */
        // TODO: Implement with User Inputs - super.setColour( /* User input */ );
    }
}
