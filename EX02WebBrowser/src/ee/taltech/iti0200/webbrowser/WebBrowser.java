package ee.taltech.iti0200.webbrowser;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WebBrowser {
    private String homePage = "google.com";
    private String currentUrl = homePage;
    private LinkedList<String> history = new LinkedList<>() {
        {
            add(homePage);
        }
    }; // shows full navigation history
    private LinkedList<String> backHistory = new LinkedList<>(); // assisting field for navigation
    private LinkedList<String> forwardHistory = new LinkedList<>(); // assisting field for navigation
    private LinkedList<String> bookmarks = new LinkedList<>();

    /**
     * Goes to homepage.
     */
    public void homePage() {
        backHistory.add(currentUrl);
        forwardHistory.clear();
        currentUrl = homePage;
        history.add(currentUrl);
    }

    /**
     * Goes back to previous page.
     */
    public void back() {
        if (!backHistory.isEmpty()) {
            forwardHistory.add(currentUrl);
            currentUrl = backHistory.getLast();
            history.add(currentUrl);
            backHistory.removeLast();
        }
    }

    /**
     * Goes forward to next page.
     */
    public void forward() {
        if (!forwardHistory.isEmpty()) {
            backHistory.add(currentUrl);
            currentUrl = forwardHistory.getLast();
            history.add(currentUrl);
            forwardHistory.removeLast();
        }
    }

    /**
     * Go to a webpage.
     *
     * @param url to go to
     */
    public void goTo(String url) {
        backHistory.add(currentUrl);
        forwardHistory.clear();
        history.add(url);
        currentUrl = url;
    }

    /**
     * Add a webpage as a bookmark.
     */
    public void addAsBookmark() {
        if (!bookmarks.contains(currentUrl)) {
            bookmarks.add(currentUrl);
        }
    }

    /**
     * Remove a bookmark.
     *
     * @param bookmark to remove
     */
    public void removeBookmark(String bookmark) {
        if (bookmarks.contains(bookmark)) {
            bookmarks.remove(bookmark);
        }
    }

    public List<String> getBookmarks() {
        return bookmarks;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }


    /**
     * Get top 3 visited pages.
     *
     * @return a String that contains top three visited pages separated with a newline "\n"
     */
    public String getTop3VisitedPages() {
        Map<String, Integer> count = new LinkedHashMap<>(); // create map from history to check page visits
        for (String address : history) {
            if (!count.containsKey(address)) {
                count.put(address, Collections.frequency(history, address));
            }
        }
        Map<String, Integer> sortedByCount = count.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        int i = 0; // sort the map by count using stream, got this solution from google

        String finalString = "";
        for (Map.Entry<String, Integer> entry : sortedByCount.entrySet()) {
            i++;
            if (i < 4) {
                if (entry.getValue() > 1) {
                    finalString += entry.getKey() + " - " + entry.getValue() + " visits\n";
                } else {
                    finalString += entry.getKey() + " - " + entry.getValue() + " visit\n";
                }
            }
        }

        return finalString;
    }

    /**
     * Returns a list of all visited pages.
     * <p>
     * Not to be confused with pages in your back-history.
     * <p>
     * For example, if you visit "facebook.com" and hit back(),
     * then the whole history would be: ["google.com", "facebook.com", "google.com"]
     *
     * @return list of all visited pages
     */
    public List<String> getHistory() {
        return history;
    }


    /**
     * Returns the active web page (string).
     *
     * @return active web page
     */
    public String getCurrentUrl() {
        return currentUrl;
    }

    public static void main(String[] args) {
        WebBrowser a = new WebBrowser();
        System.out.println(a.currentUrl); // google.com
        a.setHomePage("neti.ee");
        a.homePage();
        System.out.println(a.currentUrl); // neti.ee
        System.out.println(a.history); // google.com, neti.ee

        WebBrowser x = new WebBrowser();
        System.out.println(x.getCurrentUrl());
        x.setHomePage("neti.ee");
        x.goTo("facebook.com");
        x.back();
        x.back();
        System.out.println(x.getHistory());


        WebBrowser y = new WebBrowser();
        y.setHomePage("neti.ee");
        y.goTo("facebook.com");
        y.forward();
        y.forward();
        System.out.println(y.getHistory());

        WebBrowser z = new WebBrowser();
        z.setHomePage("neti.ee");
        z.goTo("facebook.com");
        z.back();
        z.homePage();
        z.forward();
        System.out.println(z.getHistory());

        WebBrowser c = new WebBrowser();
        System.out.println("c");
        System.out.println(c.getCurrentUrl());
        c.setHomePage("neti.ee");
        c.goTo("facebook.com");
        System.out.println(c.getCurrentUrl());
        c.goTo("google.com");
        System.out.println(c.getCurrentUrl());
        c.back();
        System.out.println(c.getCurrentUrl());
        c.addAsBookmark();
        c.forward();
        System.out.println(c.getCurrentUrl());
        c.homePage();
        System.out.println(c.getCurrentUrl());
        c.addAsBookmark();
        System.out.println(c.getBookmarks());
        System.out.println(c.getHistory());
        System.out.println(c.getTop3VisitedPages());

//        x.goTo("neti.ee");
//        x.goTo("ois2.ttu.ee");
//        x.goTo("ttu.ee");
//        System.out.println(x.currentUrl); // ttu.ee
//        System.out.println(x.history); // neti.ee, ois2.ttu.ee, ttu.ee
//        x.back();
//        System.out.println(x.history); // neti.ee, ttu.ee, ois2.ttu.ee

//        WebBrowser y = new WebBrowser();
//        System.out.println(y.currentUrl);

    }
}
