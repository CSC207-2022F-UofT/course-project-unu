package useCases;

import entities.GameState;
import entities.Player;

import java.util.List;

public class GameFacade {
    private final GameState gameState;
    private final boolean teamMode;
    private final GameSetup gameSetup;
    private final Draw draw;
    private final Play play;
    private final MakeBotMove makeBotMove;
    private final LastPlayedEffect lastPlayedEffect;
    private final ChangeTurn changeTurn;
    private final ChangeColour changeColour;
    private final ChangeDirection changeDirection;
    private final CheckWin checkWin;
    private final DisplayRealPlayerOptions displayRealPlayerOptions;
    private final Presenter_Interface presenter;

    public GameFacade(Helper helper, Presenter_Interface presenter, boolean teamMode) {
        this.gameState = new GameState(helper.getListOfPlayers());
        this.gameSetup = new GameSetup();
        this.draw = new Draw();
        this.play = new Play();
        this.makeBotMove = new MakeBotMove();
        this.lastPlayedEffect = new LastPlayedEffect();
        this.changeTurn = new ChangeTurn();
        this.changeColour = new ChangeColour();
        this.changeDirection = new ChangeDirection();
        this.checkWin = new CheckWin();
        this.displayRealPlayerOptions = new DisplayRealPlayerOptions();
        this.presenter = presenter;
        this.teamMode = teamMode;
    }

    public GameState getGameState() { return this.gameState;}

    public Presenter_Interface getPresenter() { return this.presenter;}

    public void setup() {gameSetup.setupGame(this.gameState, this.presenter);}

    /**
     * Make the player draw Cards.
     * @param drawAmount the amount of cards to be drawn
     * @param player the player drawing the cards
     */
    public void draw(int drawAmount, int player) {
        draw.draw(this.gameState, drawAmount, player, this.presenter);
    }

    /**
     * Controller calls this method to allow the user to play a card.
     * If the user does not enter a win state after their turn, run bot turns.
     * @param n the index of the Card to be played in the realPlayer's deck
     */
    public void play(int n) {
        play.playCard(this.gameState, n, this.presenter);
        //lastPlayedEffects change the turn once if it's a skip card

    }

    /**
     * Make the bot players automatically play moves until it is the user's turn.
     * The method should be called at the end of a user's turn (called in play() and draw() methods.)
     */
    public void botCycle() {
        if (checkWin.checkGameOver(this.gameState)) {
            //end game
            //try this
            presenter.showWinner(gameState.getPlayers().get(gameState.getToMove()),teamMode );
            return;
        }
        setNextTurn();
        if (getGameState().getPlayers().get(getGameState().getToMove()).getPlayerType().equalsIgnoreCase("bot")) {
            this.makeBotMove();
            this.doLastPlayedEffect();
            botCycle();
        }
    }

    /**
     * Controller calls this method when the user plays a card.
     */
    public void play(String card) {
        play(StringConverter.getIndexOfCard(card, gameState));
    }

    /**
     * Make a bot player in the current gameState make a move.
     */
    public void makeBotMove() {
        makeBotMove.makeBotPlay(this.gameState,presenter);
    }

    /**
     * Enact the changes made by the effects of the last played card.
     */
    public void doLastPlayedEffect() { lastPlayedEffect.doEffect(this);}

    /**
     * Set toMove to the next person whose turn it is.
     */
    public void setNextTurn() { changeTurn.setNextTurn(this.gameState);}

    /**
     * Set the colour of the Wild Card.
     */
    public void setColour(String colour) { changeColour.setColour(this.gameState, colour);}

    /**
     * Change the direction of the turn order.
     */
    public void changeDirection() { changeDirection.changeDirection(this.gameState);}

    /**
     * Determine whether anyone in the current gameState has entered a win state.
     */
    public boolean checkWin() {
        return checkWin.checkGameOver(this.gameState);
    }

    /**
     * Display the Cards the user is able to play from their deck.
     */
    public void displayRealPlayerOptions() {
        displayRealPlayerOptions.displayRealPlayerOptions(this.gameState, this.presenter);
    }

    public boolean getTeamMode(){
        return this.teamMode;
    }
}
