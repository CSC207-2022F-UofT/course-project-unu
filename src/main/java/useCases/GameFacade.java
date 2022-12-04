package useCases;

import entities.GameState;
import entities.Player;
import interfaceAdapters.Presenter_Interface;

import java.util.List;

public class GameFacade {
    private GameState gameState;
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
    private final GameRecorder gameRecorder;
    private final Presenter_Interface presenter;

    public GameFacade(List<Player> listOfThePlayers, Presenter_Interface presenter) {
        this.gameState = new GameState(listOfThePlayers);
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
        this.gameRecorder = new GameRecorder();
        this.presenter = presenter;
    }

    public GameState getGameState() { return this.gameState;}

    public Presenter_Interface getPresenter() { return this.presenter;}

    public void setup() {gameSetup.setupGame(this.gameState, this.presenter);}

    public void draw(int drawAmount, int player) {
        draw.draw(this.gameState, drawAmount, player, this.presenter);
    }

    public void play(String card) {
        play(StringConverter.getIndexOfCard(card, this.gameState));
    }
    public void play(int n) { play.playCard(this.gameState, n, this.presenter);}

    public void makeBotMove() {
        makeBotMove.makeBotPlay(this.gameState, this.presenter);
    }
    public void botCycle() {
        //While no one has won, and it's not the user's turn
        while (!checkWin.checkGameOver(this.gameState) && this.gameState.getToMove() != 0) {
            makeBotMove.makeBotPlay(this.gameState, this.presenter); //make bot move
            lastPlayedEffect.doEffect(this);
            changeTurn.setNextTurn(this.gameState);
        }

        if (checkWin.checkGameOver(this.gameState)) {
            //end game
        }
    }

    public void doLastPlayedEffect() { lastPlayedEffect.doEffect(this);}

    public void setNextTurn() { changeTurn.setNextTurn(this.gameState);}

    //Set the colour of the WildCard
    public void setColour(String colour) { changeColour.setColour(this.gameState, colour);}

    public void changeDirection() { changeDirection.changeDirection(this.gameState);}

    public boolean checkWin() {
        return checkWin.checkGameOver(this.gameState);
    }

    public void displayRealPlayerOptions() {
        displayRealPlayerOptions.displayRealPlayerOptions(this.gameState, this.presenter);
    }

    // Unimplemented
    public void recordResult() {}
}
