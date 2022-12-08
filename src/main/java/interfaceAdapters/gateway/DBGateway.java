package interfaceAdapters.gateway;

public interface DBGateway {
  /**
   * Record a new game and increment the total number of games played by 1
   * If the game was a win, increment the total number of wins by 1
   * @param isWin whether the player won
   */
  void recordNewGame(boolean isWin);

  /**
   * Get the total number of wins
   */
  int getTotalGames();

  /**
   * Get the total number of games played
   */
  int getTotalWins();
}
