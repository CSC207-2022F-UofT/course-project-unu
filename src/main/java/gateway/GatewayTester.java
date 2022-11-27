package gateway;

public class GatewayTester {
  public static void main(String[] args) {
    CSVGateway csvReader = new CSVGateway("db/stats.csv");

    System.out.println(csvReader.getTotalGames());
    System.out.println(csvReader.getTotalWins());

    csvReader.recordNewGame(true);
    csvReader.recordNewGame(true);
    csvReader.recordNewGame(false);

    System.out.println(csvReader.getTotalGames());
    System.out.println(csvReader.getTotalWins());
  }
}
