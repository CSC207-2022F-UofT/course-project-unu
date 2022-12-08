package gateway_tests;
import interfaceAdapters.gateway.CSVGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CSVGatewayTests {
  CSVGateway gateway;

  @BeforeEach
  public void setup() {
    this.gateway = new CSVGateway("db/test_stats.csv");
  }

  /**
  * Test if the gateway can add a win correctly.
  */
  @Test
  public void addWin() {
    int startingGames = this.gateway.getTotalGames();
    int startingWins = this.gateway.getTotalWins();

    this.gateway.recordNewGame(true);
    
    Assertions.assertEquals(this.gateway.getTotalGames(), startingGames + 1);
    Assertions.assertEquals(this.gateway.getTotalWins(), startingWins + 1);
  }

  /**
   * Test if the gateway can add a loss correctly.
   */
  @Test 
  public void addLoss() {
    int startingGames = this.gateway.getTotalGames();
    int startingWins = this.gateway.getTotalWins();

    this.gateway.recordNewGame(false);
    
    Assertions.assertEquals(this.gateway.getTotalGames(), startingGames + 1);
    Assertions.assertEquals(this.gateway.getTotalWins(), startingWins);
  }
}
