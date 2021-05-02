package ee.taltech.iti0200.webscraping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Scraper {
    String url;
    Document scrapedHtml;
    int pageCount;
    List<Element> computerElements = new ArrayList<>();
    List<Computer> computers = new ArrayList<>();
    Gson gson;
    String jsonString;

    public Scraper(String urlToScrape) throws IOException {
        url = urlToScrape;
        pageCount = findPageCountFromHtml();
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    private int findPageCountFromHtml() throws IOException {
        Document scrapedHtml = Jsoup.connect(url).get();
        return Integer.parseInt(scrapedHtml.getElementsByClass("totalPageCount")
                .get(0).childNode(0).toString());
    }

    public void findAllComputerElementsFromHtml() throws IOException {
        for (int i = 1; i <= pageCount; i++) {
            System.out.println(i);
            Document page = Jsoup.connect(String.format("%s/page-%s", url, i)).get();
            List<Element> elements = page.getElementsByClass("col-md-4 mb-30  ");
            computerElements.addAll(elements);
        }
    }

    public void extractComputerFromElements() {
        for (Element computer : computerElements) {
            Computer computerToAdd = new Computer();
            String title = computer.getElementsByClass("offer-thumb__title").get(0).attributes().get("title");
            computerToAdd.setTitle(title);
            String price = computer.getElementsByClass("price-cp").get(0).childNode(0).toString();
            computerToAdd.setPrice(price);
            String pictureSrc = computer.select("a").get(0).attributes().get("data-original");
            computerToAdd.setPictureSrc(pictureSrc);
            String pictureHref = computer.select("a").get(0).attributes().get("href");
            computerToAdd.setPictureHref("https://www.osta.ee/" + pictureHref);
            computers.add(computerToAdd);
        }
    }

    public void computerListToJson() {
        jsonString = gson.toJson(computers);
    }

    public void writeJsonToFile(String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(jsonString);
        writer.close();
    }
}
