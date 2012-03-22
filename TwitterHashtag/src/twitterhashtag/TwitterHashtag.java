/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterhashtag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author chaosong
 */
public class TwitterHashtag {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        // TODO code application logic here
        if (args.length == 0) {
            System.out.println("Missing hashtag. Usage: TwitterHashtag <hashtag>");
        } else {
            String query = "http://search.twitter.com/search.json?q=%23"+ args[0] +"&rpp=1005&include_entities=true&result_type=recent%22";
            URL oracle = new URL(query);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                int i = inputLine.indexOf("\"url\"");
                while (i>=0) {
                    inputLine = inputLine.substring(i+7);
                    int j = inputLine.indexOf("\"");
                    System.out.println(inputLine.substring(0, j).replaceAll("\\\\", ""));
                    inputLine = inputLine.substring(j);
                    i = inputLine.indexOf("\"url\"");
                }
                    
                    
                //System.out.println(inputLine);
            }
            in.close();
        }
    }
}
