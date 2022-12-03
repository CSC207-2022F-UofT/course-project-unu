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
    private final List<Player> listOfThePlayers;

    public GameFacade(List<Player> listOfThePlayers, Presenter_Interface presenter) {
        this.listOfThePlayers = listOfThePlayers;
        this.gameState = new GameState(this.listOfThePlayers);
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

    //Controller calls this when user plays a card
    public void play(int n) {
        play.playCard(this.gameState, n, this.presenter, this);
        //lastPlayedEffects change the turn once if it's a skip card
        lastPlayedEffect.doEffect(this);
        changeTurn.setNextTurn(this.gameState);

        //CheckWin now checks is ANY player has an empty hand.
        if (checkWin.checkGameOver(this.gameState)){
            //end game
        } else {
            botCycle();
        }
    }
    //Bots automatically make moves until it's the user's turn again.
    //Should be called by play() and draw() i.e. when the user's turn is over.
    //Should maybe be its own class
    public void botCycle() {
        //While no one has won and it's not the user's turn
        while (!checkWin.checkGameOver(this.gameState) && this.gameState.getToMove() != 0) {
            makeBotMove.makeBotPlay(this.gameState); //make bot move
            lastPlayedEffect.doEffect(this);
            changeTurn.setNextTurn(this.gameState);
        }

        if (checkWin.checkGameOver(this.gameState)) {
            //end game
        }
    }
    //Controller calls this when user plays a card
    public void play(String card) {
        play(StringConverter.convertCardToInteger(card, gameState));
    }


    public void makeBotMove() {
        makeBotMove.makeBotPlay(this.gameState);
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

    //Unimplemented
    public void recordResult() {}
}
