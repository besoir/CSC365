package App;
import java.io.*;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
//import org.jsoup.select.Element;

public class Parser {
  List<String> websites;
  public Parser(List<String> web) {
    this.websites = web;
  }
  public void getStuff() throws Exception {
    for(String s: websites) {
      String website = Jsoup.connect(s).get().html();
      System.out.println(website);
    }
  }
  //public getPtag
}
