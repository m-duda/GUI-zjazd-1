/**
 *
 *  @author Duda Michał S14228
 *
 */

package zad3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args)  {

    String fname = System.getProperty("user.home") + "/tab.txt";
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    FileReader fr = null;
    try {
      fr = new FileReader(fname);
    } catch (FileNotFoundException e) {
      System.out.print("***");
      System.exit(0);
    }
    BufferedReader br = new BufferedReader(fr);

    String textLine = null;
    try {
      textLine = br.readLine();
    StringTokenizer st;
    while(textLine != null) {
      st = new StringTokenizer(textLine);
      while (st.hasMoreTokens()) {
        try {
          numbers.add(Integer.parseInt(st.nextToken()));
        } catch (NumberFormatException nfe) {
          System.out.print("***");
          System.exit(0);
        }
      }
      textLine = br.readLine();
    }
    br.close();
    } catch (IOException e) {
      System.out.print("***");
      System.exit(0);
    }
    int [] tabNumbers = new int [numbers.size()];

    int max=numbers.get(0);
    for (int i=0; i<tabNumbers.length; i++){
      tabNumbers[i]=numbers.get(i);
      System.out.print(tabNumbers[i]+" ");
      if (max<tabNumbers[i]){
        max=tabNumbers[i];
      }
    }
    System.out.println();
    System.out.println(max);

    for (int i=0; i<tabNumbers.length; i++){
      if (tabNumbers[i]==max){
        System.out.print(i+" ");
      }
    }
  }
}
