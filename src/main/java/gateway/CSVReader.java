package gateway;
import java.io.*;  

public class CSVReader {
  BufferedReader csvReader;

  public CSVReader(String filename) {
    try {
      this.csvReader = new BufferedReader(new FileReader(filename));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private int findCol(String colName) {
    if (this.csvReader == null) {
      return -1;
    }

    try {
      String[] headings = this.csvReader.readLine().split(", ");
      for (int i = 0; i < headings.length; i++) {
        if (headings[i].equals(colName)) {
          return i;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return -1;
  }

  public int getColValue(String colName) {
    if (this.csvReader == null) { 
      return 0;
    }

    try {
      int colOfVal = this.findCol(colName);

      if (colOfVal == -1) {
        return 0;
      }

      return Integer.parseInt(this.csvReader.readLine().split(", ")[colOfVal]);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return 0;
  }

  public void setColValue(String colName, int newValue) {
    if (this.csvReader == null) { 
      return;
    }

    try {
      int colOfVal = this.findCol(colName);

      if (colOfVal == -1) {
        return;
      }

      String[] data = this.csvReader.readLine().split(", ");
      data[colOfVal] = Integer.toString(newValue);
      this.csvReader.close();
      this.csvReader = new BufferedReader(new FileReader("db/stats.csv"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public int getTotalGames() {
    return getColValue("Total Games");
  }

  public int getTotalWins() {
    return getColValue("Total Wins");
  }

  public void intIncreaseTotalWins(int amount) {
    this.setColValue("Total Wins", this.getTotalWins() + amount);
  }

  public void recordNewGame(boolean win) {
    this.setColValue("Total Games", this.getTotalGames() + 1);
    if (win) {
      this.intIncreaseTotalWins(1);
    }
  }
}
