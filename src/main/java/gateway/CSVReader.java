package gateway;
import java.io.*;  
import java.util.Scanner;  

public class CSVReader {
  BufferedReader csvReader;

  public static void main(String[] args) {
    new CSVReader("db/stats.csv");
  }

  public CSVReader(String filename) {
    try {
      this.csvReader = new BufferedReader(new FileReader(filename));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public int getWins() {
    if (this.csvReader == null) { 
      return 0;
    }

    return 0;
  }

  public int getTotalGames() {

  }
}
