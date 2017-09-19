import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Lab 3 Work
 */
public class Lab3Class {

    public static void main(final String[] args) {
        String url = "http://erdani.com/tdpl/hamlet.txt";
        String urlContent = urlToString(url);

        String[] words = urlContent.split(" ");

        //Find number of occurences of a given word
        int occurences = 0;
        String findWord = "Prince";

        for (int i = 0; i < words.length; i++) {
            String thisWord = words[i].toLowerCase();
            if (thisWord.contains(findWord.toLowerCase())) {
                occurences++;
            }
        }

        System.out.println(occurences);

        //Find number of unique words

        ArrayList<String> uniqueWords = new ArrayList<String>();

        String s1 = urlContent;
        String[] s1Split = s1.split(" ");

        for (int i = 0; i < s1Split.length; i++) {
            String thisWord = s1Split[i].toLowerCase();
            boolean flag = false;
            for (int j = 0; j < uniqueWords.size(); j++) {
                if (thisWord.equals(uniqueWords.get(j))) {
                    flag = true;
                }
            }
            if (!flag) {
                uniqueWords.add(thisWord);
            }
        }

        System.out.println(uniqueWords.size());
    }

    /*
     * Retrieve contents from a URL and return them as a string
     *
     * @param url URL to retrieve the content from
     * @return the contents from the URL as a string, or an empty string on error
     *
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        //Assign the contents of the URL to a variable
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

}
