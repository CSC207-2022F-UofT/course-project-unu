package useCases;

import entities.GameState;
import interfaceAdapters.Presenter_Interface;

public class GameFacade {
    private GameState gameState;
    private final Drawer drawer;
    private final Play play;
    private final Presenter_Interface presenter;

    public GameFacade(GameState gameState, Presenter_Interface presenter) {
        this.gameState = gameState;
        this.drawer = new Drawer();
        this.play = new Play();
        this.presenter = presenter;
    }

    public Presenter_Interface getPresenter() {
        return presenter;
    }

    /**
     * Remove top drawAmount cards from deck
     * Add removed cards to player's hand
     * @param drawAmount amount of cards to draw
     * @param player player
     */
    public void draw(int drawAmount, int player) {
        drawer.draw(gameState, drawAmount, player, presenter);
    }

    public void play(int n) {
        play.playCard(gameState, n, presenter);
    }
}
