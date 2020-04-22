package mine.Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class CountryModelBrain {
    ArrayList<CountryModel> countries;


    public CountryModelBrain(ArrayList<CountryModel> countries) {

        this.countries = countries;
        int i=1;
        for (CountryModel c:countries
             ) {
            System.out.println("populating country"+i+"...");
            CountryPopulator.populate(c);
            i++;

        }
    }

    public void top5DeathRateCountries(){

        Collections.sort(countries,new DeathRateComparator());
        System.out.println(" list of countries with highest death rate");
        System.out.print("1: ");
        System.out.println(countries.get(countries.size()-1).getName());
        System.out.print("2: ");
        System.out.println(countries.get(countries.size()-2).getName());
        System.out.print("3: ");
        System.out.println(countries.get(countries.size()-3).getName());
        System.out.print("4: ");
        System.out.println(countries.get(countries.size()-4).getName());
        System.out.print("5: ");
        System.out.println(countries.get(countries.size()-5).getName());
    }


    public void ethnicityOver(float percent){

        System.out.println(" printing dominating ethnicities over "+percent);
        for (CountryModel c:countries
             ) {

            try {
                if(c.getDominateEthnicityPercentage()>=percent){
                    System.out.println("Country :"+c.getName()+" Religion: "+c.getDominateEthnicity());
                }
            }catch (Exception e){
                System.out.println("none");
            }

        }
    }

    public void top5Consumers(){
        Collections.sort(countries,new ElectricityPerCapitaComparator());
        System.out.println(" list of countries with highest Electricity per capita consumption");
        System.out.print("1: ");
        System.out.println(countries.get(countries.size()-1).getName());
        System.out.print("2: ");
        System.out.println(countries.get(countries.size()-2).getName());
        System.out.print("3: ");
        System.out.println(countries.get(countries.size()-3).getName());
        System.out.print("4: ");
        System.out.println(countries.get(countries.size()-4).getName());
        System.out.print("5: ");
        System.out.println(countries.get(countries.size()-5).getName());
    }


    public void haveSymbol(String symbol){

        System.out.println("List of countries that have "+symbol+" in flag :");
        for (CountryModel c:countries
             ) {
            if(c.getFlagDesc().toLowerCase().contains(symbol)){
                System.out.println(c.getName());
            }

        }
    }

    private ArrayList<CountryModel> getCountriesOfContinent(String continent){
        ArrayList<CountryModel> countriesOfContinent=new ArrayList<>();
        try {
            for (CountryModel c:countries
            ) {
                if(c.getContinent().toLowerCase().equals(continent)){
                    countriesOfContinent.add(c);
                }
            }
        }catch (Exception exception){
            System.out.println("error in filtering countries by continent");
        }

        return countriesOfContinent;
    }

    public void lowestElevationPointCountry(String continent){
        System.out.println("lowest elevation point country in "+continent);
        ArrayList<CountryModel> filteredCountries=getCountriesOfContinent(continent.toLowerCase());
        CountryModel c=Collections.min(filteredCountries,new ElevationComparator());
        System.out.println(c.getName());

    }

    public void landLockedOnes(){
        System.out.println("LandLocked Countries :");
        for (CountryModel c:
             countries) {
            if(c.isLandlocked()){
                System.out.println(c.getName());
            }
        }
    }
    public void getCoverageBy(String continent,Float percent,String by){


        ArrayList<CountryModel> filteredCountries=getCountriesOfContinent(continent.toLowerCase());
        System.out.println("coverage by "+percent+" of"+ by);
        by=by.trim().toLowerCase();
        if(by.equals("forest")){

            for (CountryModel c:filteredCountries
                 ) {
                if(c.getForestCoverage() >= percent){
                    System.out.println(c.getName());
                }
            }
        }else if(by.equals("forest")){
            for (CountryModel c:filteredCountries
            ) {
                if(c.getAgricultureCoverage() >= percent){
                    System.out.println(c.getName());
                }
            }
        }


    }
    public void proneToHazard(String continent,String hazard){
        System.out.println("printing Countries of "+continent+" prone to "+hazard);
        ArrayList<CountryModel> filteredCountries=getCountriesOfContinent(continent.toLowerCase());
        for (CountryModel c:filteredCountries
             ) {
            if(c.getHazards().toLowerCase().contains(hazard)){

                System.out.println(c.getName());
            }
        }
    }

}
