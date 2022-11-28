package gateway;

public class CSVGateway implements DBGateway {
  CSVHandler csvHandler;

  public CSVGateway(String filename) {
    this.csvHandler = new CSVHandler(filename);
  }

  /**
   * Increase the total number of wins by the specified amount 
   * @param amount
   */
  private void increaseTotalWins(int amount) {
    this.csvHandler.setColValue("Total Wins", Integer.toString(this.getTotalWins() + amount));
  }

  // =================
  // Interface Methods
  // =================
  public int getTotalGames() {
    return Integer.parseInt(this.csvHandler.getColValue("Total Games"));
  }

  public int getTotalWins() {
    return Integer.parseInt(this.csvHandler.getColValue("Total Wins"));
  }

  public void recordNewGame(boolean isWin) {
    String newTotalGames = Integer.toString(this.getTotalGames() + 1);
    this.csvHandler.setColValue("Total Games", newTotalGames);
    if (isWin) {
      this.increaseTotalWins(1);
    }
  }
}
