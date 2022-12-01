package useCases;

import entities.GameState;
import interfaceAdapters.Presenter_Interface;

public class GameFacade {
    private GameState gameState;
    private final Draw drawer;
    private final Play play;
    private final ChangeTurn changeTurn;
    private final ChangeColour changeColour;
    private final CheckWin checkWin;
    private final RecordGame recordGame;
    private final Presenter_Interface presenter;

    public GameFacade(GameState gameState, Presenter_Interface presenter) {
        this.gameState = gameState;
        this.drawer = new Draw();
        this.play = new Play();
        this.changeTurn = new ChangeTurn();
        this.changeColour = new ChangeColour();
        this.checkWin = new CheckWin();
        this.recordGame = new RecordGame();
        this.presenter = presenter;
    }

    public GameState getGameState() { return this.gameState;}

    public Presenter_Interface getPresenter() { return presenter;}

    /**
     * Remove top drawAmount cards from deck
     * Add removed cards to player's hand
     * @param drawAmount amount of cards to draw
     * @param player player
     */
    public void draw(int drawAmount, int player) {
        drawer.draw(gameState, drawAmount, player, presenter);
    }

    public void play(int n) { play.playCard(gameState, n, presenter, this);}

    public void setNextTurn() { changeTurn.setNextTurn(gameState);}

    public void setColour(String colour) { changeColour.setColour(gameState, colour);}

    public boolean checkWin() {
        return checkWin.checkGameOver(gameState);
    }

    public void recordResult() {}
}
