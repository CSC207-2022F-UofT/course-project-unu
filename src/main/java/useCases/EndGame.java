package useCases;

import gateway.DBGateway;
import interfaceAdapters.Presenter_Interface;

public class EndGame {
    public void endGame(Presenter_Interface presenter, DBGateway gateway, boolean isWin) {
        
        presenter.endGame();
        gateway.recordNewGame(isWin);
    }
}
