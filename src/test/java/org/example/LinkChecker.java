package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LinkChecker {
    HttpURLConnection huc = null;
    int respCode = 200;
    String url = "";

    //below method checks the http connection for all links on screen
    public List<List<String>> checker(WebDriver driverIn) {
        ArrayList<WebElement> links = (ArrayList<WebElement>) driverIn.findElements(By.tagName("a"));
        Iterator<WebElement> it = links.iterator();
        List<List<String>> listOfLists = new ArrayList<List<String>>(links.size());
        while(it.hasNext()){
            url = it.next().getAttribute("href");
            if(url.startsWith("http") || url.startsWith("https")) {
                ArrayList<String>list = new ArrayList<String>();
                //      System.out.println(url);

                try {
                    //	System.out.println(Integer.toString(respCode));
                    huc = (HttpURLConnection)(new URL(url).openConnection());
                    huc.setRequestMethod("HEAD");
                    huc.connect();
                    respCode = huc.getResponseCode();
                    //      System.out.println(Integer.toString(respCode));
                    list.add(url);
                    list.add(Integer.toString(respCode));
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                listOfLists.add(list);
            }
        }
        return listOfLists;
    }
}

