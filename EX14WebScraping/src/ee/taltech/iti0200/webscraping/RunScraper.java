package ee.taltech.iti0200.webscraping;

import java.io.IOException;

public class RunScraper {
    public static void main(String[] args) throws IOException {
        Scraper scraper = new Scraper("https://www.osta.ee/kategooria/arvutid");
        scraper.findAllComputerElementsFromHtml();
        scraper.extractComputerFromElements();
        scraper.computerListToJson();
        scraper.writeJsonToFile("arvutid.txt");
    }
}
