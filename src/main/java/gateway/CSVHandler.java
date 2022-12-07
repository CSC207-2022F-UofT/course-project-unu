package gateway;
import java.io.*;  

public class CSVHandler {
  BufferedReader csvReader;
  String filename;
  String[] headings;
  String[] data;

  public CSVHandler(String filename) {
    this.filename = filename;
    this.readInNewFile();
  }

  /**
   * Read data from the file
   * Returns true if successful, false if not
   * @return boolean
   */
  private boolean readInNewFile() {
    try {
      this.csvReader = new BufferedReader(new FileReader(this.filename));
      this.headings = this.csvReader.readLine().split(",");
      this.data = this.csvReader.readLine().split(",");

      return true;
    } catch (IOException e) {
      e.printStackTrace();

      return false;
    }
  }

  /**
   * Saves the current headings and data to the CSV file
   * Returns true if successful, false if not
   * @return boolean
   */
  public boolean writeToFile() {
    try {
      FileWriter csvWriter = new FileWriter(this.filename);
      csvWriter.append(String.join(",", this.headings));
      csvWriter.append("\n");
      csvWriter.append(String.join(",", this.data));
      csvWriter.flush();
      csvWriter.close();

      return true;
    } catch (IOException e) {
      e.printStackTrace();
      
      return false;
    }
  }

  /**
   * Finds the col index with given heading name
   * @param colName column name
   */
  public int findColIndexByHeading(String colName) {
    if (this.headings == null) {
      return -1;
    }

    for (int i = 0; i < this.headings.length; i++) {
      if (this.headings[i].equals(colName)) {
        return i;
      }
    }

    return -1;
  }

  /**
   * Gets the value of the first row with a given heading name
   * @param colName column name
   * @return Int
   */
  public String getColValue(String colName) {
    int colOfVal = this.findColIndexByHeading(colName);
    if (colOfVal == -1) {
      return "0";
    }

    return this.data[colOfVal];
  }

  /**
   * Sets the value of the first row with a given heading name
   * @param colName column name
   * @param newValue the new value of the first row
   */
  public void setColValue(String colName, String newValue) {
    int colOfVal = this.findColIndexByHeading(colName);
    if (colOfVal == -1) {
      return;
    }

    this.data[colOfVal] = newValue;
    this.writeToFile();
  }
}
