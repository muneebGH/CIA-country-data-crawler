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
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Home {
    private String url;
    private CountryModelBrain brain;
    Scanner sc = new Scanner(System.in);

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


    public void prepareEverything() {
        brain = new CountryModelBrain(getCountries());
    }

    public void proneToHazards() {
        System.out.println("Enter continent");
        String continent = sc.nextLine().toLowerCase().trim();
        System.out.println("Enter hazard");
        String hazard = sc.nextLine().toLowerCase().trim();
        brain.proneToHazard(continent, hazard);
    }

    public void symbolInFlag() {
        System.out.println("Enter symbol");
        brain.haveSymbol(sc.nextLine().toLowerCase().trim());
    }

    public void lowestElevationPoint() {
        System.out.println("Enter Subcontinent");
        brain.lowestElevationPointCountry(sc.nextLine().toLowerCase().trim());
    }

    public void findCoverage() {
        System.out.println("Enter Coverage");
        String continent = sc.nextLine().toLowerCase().trim();
        System.out.println("Enter by (forest or agriculture)");
        String by = sc.nextLine().toLowerCase().trim();
        System.out.println("Enter percentage");
        Float percent = sc.nextFloat();
        brain.getCoverageBy(continent, percent, by);
    }

    public void findTop5() {
        brain.top5Consumers();
    }

    public void findEthnicity() {

        brain.ethnicityOver(sc.nextFloat());
    }

    public void findLandLocked() {

        brain.landLockedOnes();
    }

    public void top5DeathRates(){
        brain.top5DeathRateCountries();
    }

    public static void main(String[] args) {
        System.out.println("Setting up...");
        Home h = new Home("https://www.cia.gov/library/publications/the-world-factbook/print/textversion.html");

         ArrayList<CountryModel> countries = h.getCountries();
        //
        CountryPopulator.populate(countries.get(0));
        //CountryModelBrain brain = new CountryModelBrain(h.getCountries());

       // brain.ethnicityOver(80);


    }
}
