/**
 *
 *  @author Duda Michał S14228
 *
 */

package zad4;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class CountWords {

    private String textLine;
    private List<String> array = new ArrayList<String>();
    private FileReader fr;
    private int valeu;

    public CountWords (String fname) throws IOException {
        readFile(fname);
    }

    public void readFile(String fname)throws IOException {
        try {
            fr = new FileReader(fname);
        } catch (FileNotFoundException e) {
            System.out.print("Nie znaleziono pliku");
            System.exit(0);
        }
        BufferedReader br = new BufferedReader(fr);
        textLine = br.readLine();
        while (textLine!=null) {
            String[] tab = textLine.split("[\\p{Punct}\\s]+\\p{Punct}*");
            for (String text: tab){
                array.add(text);
            }
            textLine = br.readLine();
        }
        br.close();
    }

    public List<String> getResult(){
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        List<String> list = new LinkedList<>();
        for (String word : array ) {
            if (map.containsKey(word)) {
                valeu=map.get(word);
                map.put(word,valeu+1);
            } else {
                map.put(word,1);
            }
        }

        for (String key : map.keySet()){
            list.add(key+ " " +map.get(key));
        }

        return list;
    }
}  