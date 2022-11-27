package gateway;

public interface DBGateway {
  /**
   * Record a new game and increment the total number of games played by 1
   * If the game was a win, increment the total number of wins by 1
   * @param isWin
   */
  public void recordNewGame(boolean isWin);

  /**
   * Get the total number of wins
   */
  public int getTotalGames();

  /**
   * Get the total number of games played
   */
  public int getTotalWins();
}
