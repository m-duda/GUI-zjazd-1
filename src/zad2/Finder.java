/**
 *
 *  @author Duda Michał S14228
 *
 */

package zad2;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finder {

    private int counterIf;
    private int counterWords;
    private String text;
    private String textWithout;

    public Finder(String fname) throws IOException {
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
        String textLine = br.readLine();

        do {
            text = text+textLine;
            textLine = textLine.replaceAll("//.*"," ");
            textWithout =textWithout + textLine;
            textWithout = textWithout.replaceAll("/\\*[^\\*]*\\*/"," ");
            textWithout = textWithout.replaceAll("\"[^\"]*\""," ");
            textLine = br.readLine();
        } while(textLine != null);

        br.close();
    }

    public int getIfCount(){
        Pattern pattern = Pattern.compile("[\\W]if\\s*\\(");
        Matcher matcher = pattern.matcher(textWithout);
        while (matcher.find()){
            counterIf++;
        }
        return counterIf;
    }

    public int getStringCount(String word){
        Pattern pattern = Pattern.compile(word);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
                 counterWords++;
            }
        return counterWords;
    }
}     
