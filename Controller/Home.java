package mine.Controller;

import mine.Model.CountryModel;
import mine.Model.CountryModelBrain;
import mine.Model.CountryPopulator;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Home {
    private String url;

    public Home(String url) {
        this.url = url;
    }

    public ArrayList<CountryModel> getCountries() {
        ArrayList<CountryModel> countries = new ArrayList<>();
        boolean canStart = false;

        Connection con = Jsoup.connect(url);
        try {
            Document data = con.get();

            Elements hrefs = data.select("a[href]");

            for (Element e : hrefs) {

                if (e.text().equals("Afghanistan")) {
                    canStart = true;
                }
                if (e.text().equals("About CIA") || e.attr("href").equals("#wfbtop")) {
                    canStart = false;
                }
                if (canStart) {
                    countries.add(new CountryModel(e.text(), e.attr("href")));
                }
            }

        } catch (IOException e) {
            System.out.println("error in getting data");
            e.printStackTrace();
        }

        return countries;

    }

    public static void main(String[] args) {
        System.out.println("Setting up...");
        Home h = new Home("https://www.cia.gov/library/publications/the-world-factbook/print/textversion.html");

       ArrayList<CountryModel> countries = h.getCountries();
        CountryPopulator.populate(countries.get(0));
       // CountryModelBrain brain = new CountryModelBrain(h.getCountries());



    }
}
