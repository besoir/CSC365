import java.io.*;
import java.net.*;
import java.util.List;
import java.util.ArrayList;

/*
 * CSC 365 Project One: Wikipedia Linker
 * Thomas Hanley
 * Last Updated: 15 February 2019
 */

public class Main {
  public static void main(String[] args) throws Exception{
    File savedWebsites = new File("websites.txt");
    List<String> websites = getWebsites(savedWebsites);
    for(String website: websites) {
      URL url = new URL(website);
      URLConnection connection = url.openConnection();
      BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String inputLine;
      while((inputLine = in.readLine()) != null)
          System.out.println(inputLine);
      in.close();

      //HashTable harrison = new HashTable(123, "mikel");
      //System.out.println(harrison.hash("mikel"));
    }
  }

  /*
   * Method: getWebsites(File f)
   */
  public static List<String> getWebsites(File f) throws IOException {
    List<String> sites = new ArrayList<String>();
    BufferedReader grabber = new BufferedReader(new FileReader(f));
    String website;
    while((website = grabber.readLine()) != null) {
      System.out.println(website);
      sites.add(website);
    }
    return sites;
  }
}
