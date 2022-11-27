package gateway;

public interface DBGateway {
  public void recordNewGame(boolean isWin);

  public int getTotalGames();

  public int getTotalWins();
}
