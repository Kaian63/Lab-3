import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int wordCount(final String url) {
        int count = 0;
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return 0;
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        String[] words = contents.trim().split("\\s+");
        for (int i = 0; i < words.length; i++) {
            count++;
        }
        return count;

    }
    public static int singleWord(final String url, final String word) {
        int count = 0;
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return 0;
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        String[] words = contents.trim().split("\\s+");
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i].replace(",",""));
            if (words[i].replace(",","").toUpperCase().equals(word.toUpperCase())) {
                count++;
            }
        }
        return count;
    }
    public static void main (String[] unused) {
        System.out.println("wordCount: " + wordCount("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println("single Count: " + singleWord("http://erdani.com/tdpl/hamlet.txt","Prince"));
    }
}
