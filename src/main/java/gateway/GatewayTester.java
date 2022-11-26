package gateway;

public class GatewayTester {
  public static void main(String[] args) {
    CSVReader csvReader = new CSVReader("db/stats.csv");
    csvReader.listCSVLines();
  }
}
