package mine.Model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountryPopulator {
    private String originalUrl = "https://www.cia.gov/library/publications/the-world-factbook";
    Document doc;

    private String makeUrl(String countryUrl) {
        return originalUrl + countryUrl.substring(2);
    }


    public static void populate(CountryModel c) {

        CountryPopulator cp = new CountryPopulator();
        c.setUrl(cp.makeUrl(c.getUrl()));
        try {
            cp.setDoc(c.getUrl());
            cp.setProneToEQHazard(c);
            cp.setHasStar(c);
            cp.setLowestElevation(c);
            cp.setForestCoverage(c);
            cp.setEthnicity(c);
            cp.setLandlocked(c);
            cp.setDeathRate(c);
            cp.setMedianAge(c);
            cp.setContinent(c);
            cp.setAgricultureCoverage(c);
            cp.setElectricityConsumptionPerCapita(c);
            cp.setBirthRateExpectancy(c);
            cp.setCoordinates(c);
            cp.setSorroundings(c);
        } catch (IOException e) {
            System.out.println("Error in populating");
            e.printStackTrace();
        }

    }


    private void setSorroundings(CountryModel c){

        Element e=doc.getElementById("field-land-boundaries");
        if(e==null){
            return;
        }

        try {

            ArrayList<String> srr=new ArrayList<>();
            String s=e.text();
            s=s.toLowerCase();
            s=s.substring(s.indexOf("countries"),s.length());
            s=s.substring(s.indexOf(":"),s.length());
            s=s.replaceAll("[0-9]","");
            s=s.replace(":","");
            s=s.trim();
            String[] arr=s.split(",");
            for(int i=0;i<arr.length;i++){

                srr.add(arr[i].substring(0,arr[i].length()-2).trim());

            }
            c.setSorroundings(srr);
        }catch (Exception exception){

        }


    }

    private void setCoordinates(CountryModel c){
        Element e=doc.getElementById("field-capital");
        if(e==null){
            return;
        }

        try {

            String s=e.text();
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(s);
            if(m.find()){
                c.setLat(Double.parseDouble(m.group()));
            }
            if(m.find()){
                c.setLat(c.getLat()+(Double.parseDouble(m.group())/60));
            }
            if(m.find()){
                c.setLon(Double.parseDouble(m.group()));
            }
            if(m.find()){
                c.setLon(c.getLon()+(Double.parseDouble(m.group())/60));
            }

        }catch (Exception exception){

            System.out.println("no lat long for capital "+c.getName());
        }
    }

    private void setBirthRateExpectancy(CountryModel c){

        Element e=doc.getElementById("field-life-expectancy-at-birth");
        if(e==null){
            c.setLifeExpectancyAtBirth(-1);
            return;
        }

        try {
            String s=e.text().toLowerCase().trim();
            Pattern p = Pattern.compile("([0-9]+[.][0-9]+)");
            Matcher m = p.matcher(s);
            if (m.find()) {
                c.setLifeExpectancyAtBirth(Float.parseFloat(m.group()));
            }

        }catch (Exception exception){

            c.setLifeExpectancyAtBirth(-1);
        }

    }

    private void setElectricityConsumptionPerCapita(CountryModel c) {
        setElectricityConsumption(c);
        setPopulation(c);
        c.setElectricityConsumpCapita((c.getElectricityConsumpTotal() / c.getPopulation()));

    }

    private void setElectricityConsumption(CountryModel c) {

        Element e = doc.getElementById("field-electricity-consumption");
        if (e == null) {
            c.setElectricityConsumpTotal(-1);
        }
        try {
            String s = e.text().trim().toLowerCase();
            Pattern p = Pattern.compile("([0-9]+[.][0-9]+)");
            Matcher m = p.matcher(s);
            if (m.find()) {
                c.setElectricityConsumpTotal(Float.parseFloat(m.group()) * 1000000000);
            }

        } catch (Exception exception) {
            c.setElectricityConsumpTotal(-1);
        }
    }

    private void setPopulation(CountryModel c) {

        Element e = doc.getElementById("field-population");
        if (e == null) {

            c.setPopulation(-1);
            return;
        }

        try {

            String s = e.text().toLowerCase().trim().replace(",", "");
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(s);
            if (m.find()) {
                c.setPopulation(Long.parseLong(m.group()));
            }

        } catch (Exception exception) {
            c.setPopulation(-1);
        }
    }


    private void setAgricultureCoverage(CountryModel c) {

        Element e = doc.getElementById("field-land-use");
        if (e == null) {
            c.setAgricultureCoverage(-1);
            return;
        }
        try {
            String s = e.text();
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(s);
            if (m.find()) {
                c.setAgricultureCoverage(Float.parseFloat(m.group()));
            }
        } catch (Exception exception) {
            c.setAgricultureCoverage(-1);
        }


    }


    private void setContinent(CountryModel c) {
        Element e = doc.getElementsByTag("strong").first();
        if (e == null) {

            c.setContinent("none");
            return;
        }

        try {
            String s = e.text();
            s = s.substring(0, s.indexOf(":"));
            s = s.trim();
            c.setContinent(s.toLowerCase());
        } catch (Exception exception) {
            c.setContinent("none");
        }

    }


    private void setMedianAge(CountryModel c) {
        Element e = doc.getElementById("field-median-age");
        if (e == null) {
            c.setMedianAge(-1);
            c.setMedianAgeRank(-1);
            return;
        }


        try {
            String s = e.text();


            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(s);
            if (m.find()) {
                c.setMedianAge(Float.parseFloat(m.group()));
            }
            s = s.substring(s.indexOf("world"));
            m = p.matcher(s);
            if (m.find()) {
                c.setMedianAgeRank(Integer.parseInt(m.group()));
            }


        } catch (Exception exception) {

            c.setMedianAge(-1);
            c.setMedianAgeRank(-1);
        }
    }


    private void setDeathRate(CountryModel c) {
        Element e = doc.getElementById("field-death-rate");
        if (e == null) {
            return;
        }

        int temp=0;
        try {


            Pattern o=Pattern.compile("\\d+");
            Matcher z=o.matcher(e.text());
            if (z.find()) {
                c.setDeathRate(Float.parseFloat(z.group()));
            }

            String s = e.text();
            Pattern x = Pattern.compile("([0-9]+[.][0-9]+)");
            Matcher m = x.matcher(s);
            if(m.find()) c.setDeathRate(Float.parseFloat(m.group()));
            s = s.substring(s.indexOf("world"));
            Pattern p = Pattern.compile("\\d+");
            Matcher n = p.matcher(s);
            if (n.find()) {
                c.setDeathRateRank(Integer.parseInt(n.group()));
            }

        } catch (Exception exception) {

        }
       // System.out.println();

    }


    private void setLandlocked(CountryModel c) {
        Element e = doc.getElementById("field-coastline");
        if (e == null) {
            c.setLandlocked(false);
            return;
        }

        try {
            if (e.text().toLowerCase().contains("landlocked")) {
                c.setLandlocked(true);
            } else {
                c.setLandlocked(false);
            }

        } catch (Exception exception) {
            c.setLandlocked(false);
        }
    }

    private void setEthnicity(CountryModel c) {
        Element e = doc.getElementById("field-religions");
        if (e == null) {
            c.setDominateEthnicityPercentage(-1);
            c.setDominateEthnicity("none");
            return;
        }

        try {
            String s = e.text();
            c.setDominateEthnicity(s.substring(0, s.indexOf(' ')));
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(s);
            if (m.find()) {
                c.setDominateEthnicityPercentage(Float.parseFloat(m.group()));
            }

        } catch (Exception exception) {
            c.setDominateEthnicityPercentage(-1);
            c.setDominateEthnicity("none");
        }

    }


    private void setDoc(String url) throws IOException {
        doc = Jsoup.connect(url).get();
    }


    private void setProneToEQHazard(CountryModel c) {
        Element e = doc.getElementById("field-natural-hazards");
        if (e == null) {
            return;
        }

        try {

            c.setHazards(e.text());

        } catch (Exception exception) {
            return;
        }
    }

    private void setFlagDesc(CountryModel c) {
        Element e = doc.getElementById("field-flag-description");
        if (e == null) {
            c.setHasStarInflag(false);
            return;
        }
        try {
            String desc = e.text().toLowerCase();

            c.setFlagDesc(desc);

        } catch (Exception exception) {
            c.setHasStarInflag(false);
        }
    }

    private void setHasStar(CountryModel c) {
        Element e = doc.getElementById("field-flag-description");
        if (e == null) {
            c.setHasStarInflag(false);
            return;
        }

        try {
            String desc = e.text().toLowerCase();

            c.setFlagDesc(desc);
            if (desc.contains("star") || desc.contains("stars")) {
                c.setHasStarInflag(true);
            } else {
                c.setHasStarInflag(false);
            }

        } catch (Exception exception) {
            c.setHasStarInflag(false);
        }

    }


    private void setLowestElevation(CountryModel c) {
        Element e = doc.getElementById("field-elevation");
        if (e == null) {
            c.setLowestElevation(-1);
            return;
        }
        try {
            String s = e.text();
            s = s.replace(",", "");
            if (!e.text().toLowerCase().contains("mean")) {
                c.setLowestElevation(-1);
                return;
            }
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(s);
            if (m.find()) {
                c.setLowestElevation(Integer.parseInt(m.group()));
            }
        } catch (Exception exception) {
            c.setLowestElevation(-1);
        }

    }


    private void setForestCoverage(CountryModel c) {

        Element e = doc.getElementById("field-land-use");
        if (e == null) {
            c.setForestCoverage(-1);
            return;
        }
        try {
            String s = e.text();
            s = s.substring(s.indexOf("forest"));
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(s);
            if (m.find()) {
                c.setForestCoverage(Float.parseFloat(m.group()));
            }
        } catch (Exception exception) {
            c.setForestCoverage(-1);
        }


    }


    public static void main(String[] args) {
    }
}
