package mine.Controller;

import mine.Model.CountryModel;
import mine.Model.CountryModelBrain;
import mine.Model.CountryPopulator;
import mine.views.CenterView;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BrainController {
    private String url;
    private CountryModelBrain brain;
    Scanner sc = new Scanner(System.in);


    public BrainController(String url) {
        this.url = url;
    }

    public ArrayList<CountryModel> _getCountries() {
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
        brain = new CountryModelBrain(_getCountries());
    }

    public void proneToHazards() {

        sc=new Scanner(System.in);
        System.out.println("Enter continent");
        String continent = sc.nextLine().toLowerCase().trim();
        System.out.println("Enter hazard");
        String hazard = sc.nextLine().toLowerCase().trim();
        brain.proneToHazard(continent, hazard);
    }

    public void symbolInFlag() {

        sc=new Scanner(System.in);
        System.out.println("Enter symbol");
        brain.haveSymbol(sc.nextLine().toLowerCase().trim());
    }

    public void lowestElevationPoint() {

        sc=new Scanner(System.in);
        System.out.println("Enter Subcontinent");
        brain.lowestElevationPointCountry(sc.nextLine().toLowerCase().trim());
    }

    public void findCoverage() {
        sc=new Scanner(System.in);
        System.out.println("Enter Coverage");
        String continent = sc.nextLine().toLowerCase().trim();
        System.out.println("Enter by (forest or agriculture)");
        String by = sc.nextLine().toLowerCase().trim();
        System.out.println("Enter percentage");
        Float percent = sc.nextFloat();
        brain.getCoverageBy(continent, percent, by);
    }

    public void sortByElectricityConsumption() {
        brain.topConsumers();
        CenterView.renderList();
    }

    public void findEthnicity() {

        sc=new Scanner(System.in);
        System.out.println("Enter precentage");

        brain.ethnicityOver(sc.nextFloat());
    }

    public void findLandLocked() {

        brain.landLockedOnes();
    }

    public void sortByDeathRate(){

        brain.topDeathRateCountries();
        CenterView.renderList();
    }

    public void sortByMedianAge(){

        brain.topMedianAges();
        CenterView.renderList();
    }

    public void sortByDefault(){
        brain.sortByDefault();
        CenterView.renderList();
    }

    public void sortByBirthExpectancy(){
        brain.sortByBirthExpectancies();
        CenterView.renderList();
    }
//
//    public void overlapsBetweenMedianAndExpectancy(){
//
//        sc=new Scanner(System.in);
//        System.out.println("Enter Number for median ages");
//        int m=sc.nextInt();
//        System.out.println("Enter number for birth expectancies");
//        int b=sc.nextInt();
//        ArrayList<CountryModel> arr1=brain.topmedianAges(m);
//        ArrayList<CountryModel> arr2=brain.topBirthExpectancies(b);
//
//        System.out.println("Overlaps:");
//        for(int i=0;i<m;i++){
//            String a=arr1.get(i).getName().toLowerCase().trim();
//            for(int j=0;j<b;j++){
//                String s=arr2.get(j).getName().toLowerCase().trim();
//                if(a.equals(s)) System.out.println(a);
//            }
//        }
//
//    }

    public ArrayList getList(){
        return brain.getList();
    }
    public static void main(String[] args) {
        System.out.println("Setting up...");
        BrainController h = new BrainController("https://www.cia.gov/library/publications/the-world-factbook/print/textversion.html");

         ArrayList<CountryModel> countries = h._getCountries();
        //
        CountryPopulator.populate(countries.get(0));
       // CountryModelBrain brain = new CountryModelBrain(h.getCountries());

        //System.out.println(brain);
       // brain.ethnicityOver(80);


    }


}
