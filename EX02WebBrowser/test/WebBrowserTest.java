import ee.taltech.iti0200.webbrowser.WebBrowser;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;


class WebBrowserTest {
    WebBrowser webBrowser;

    @BeforeEach
    void setWebBrowser() {
        webBrowser = new WebBrowser();
    }

    @org.junit.jupiter.api.Test
    void homePage() {
        webBrowser.setHomePage("neti.ee");
        webBrowser.homePage();
        assert webBrowser.getCurrentUrl().equals("neti.ee");
    }

    @org.junit.jupiter.api.Test
    void back() {
        webBrowser.goTo("ois.ttu.ee");
        webBrowser.goTo("facebook.com");
        webBrowser.back();
        assert webBrowser.getCurrentUrl().equals("ois.ttu.ee");
    }

    @org.junit.jupiter.api.Test
    void forward() {
        webBrowser.goTo("ois.ttu.ee");
        webBrowser.goTo("facebook.com");
        webBrowser.back();
        webBrowser.forward();
        assert webBrowser.getCurrentUrl().equals("facebook.com");
    }

    @org.junit.jupiter.api.Test
    void goTo() {
        webBrowser.goTo("ois.ttu.ee");
        assert webBrowser.getCurrentUrl().equals("ois.ttu.ee");
    }

    @org.junit.jupiter.api.Test
    void addAsBookmark() {
        webBrowser.goTo("postimees.ee");
        webBrowser.addAsBookmark();
        assert webBrowser.getBookmarks().contains("postimees.ee");
    }

    @org.junit.jupiter.api.Test
    void removeBookmark() {
        webBrowser.goTo("postimees.ee");
        webBrowser.addAsBookmark();
        webBrowser.goTo("delfi.ee");
        webBrowser.addAsBookmark();
        webBrowser.removeBookmark("postimees.ee");
        List<String> bookmarks = new ArrayList<>() {
            {
                add("delfi.ee");
            }
        };
        assert webBrowser.getBookmarks().equals(bookmarks);
    }

    @org.junit.jupiter.api.Test
    void getBookmarks() {
        webBrowser.goTo("postimees.ee");
        webBrowser.addAsBookmark();
        webBrowser.goTo("delfi.ee");
        webBrowser.addAsBookmark();
        webBrowser.goTo("postimees.ee");
        webBrowser.addAsBookmark();
        List<String> bookmarks = new ArrayList<>() {
            {
                add("postimees.ee");
                add("delfi.ee");
            }
        };
        assert webBrowser.getBookmarks().equals(bookmarks);
    }

    @org.junit.jupiter.api.Test
    void setHomePage() {
        webBrowser.setHomePage("neti.ee");
        webBrowser.homePage();
        assert webBrowser.getCurrentUrl().equals("neti.ee");
    }

    @org.junit.jupiter.api.Test
    void getTop3VisitedPages() {
        webBrowser.goTo("postimees.ee");
        webBrowser.homePage();
        webBrowser.goTo("facebook.com");
        webBrowser.goTo("facebook.com");
        webBrowser.homePage();
        String result = "google.com - 3 visits\n"
                + "facebook.com - 2 visits\n"
                + "postimees.ee - 1 visit\n";
        assert webBrowser.getTop3VisitedPages().equals(result);
    }

    @org.junit.jupiter.api.Test
    void getHistory() {
        webBrowser.goTo("ois.ttu.ee");
        webBrowser.goTo("postimees.ee");
        webBrowser.goTo("facebook.com");
        List<String> history = new ArrayList<>() {
            {
                add("google.com");
                add("ois.ttu.ee");
                add("postimees.ee");
                add("facebook.com");
            }
        };
        assert webBrowser.getHistory().equals(history);
    }

    @org.junit.jupiter.api.Test
    void getCurrentUrl() {
        webBrowser.goTo("orkut.com");
        assert webBrowser.getCurrentUrl().equals("orkut.com");
    }
}
