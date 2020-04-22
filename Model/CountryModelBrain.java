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
                    System.out.println("adding in list "+c.getName());
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
    public void getCoverageBy(Float percent,String by){
        System.out.println("coverage by "+percent+" of"+ by);
        by=by.trim().toLowerCase();
        if(by.equals("forest")){

            for (CountryModel c:countries
                 ) {
                if(c.getForestCoverage() >= percent){
                    System.out.println(c.getName());
                }
            }
        }else if(by.equals("forest")){
            for (CountryModel c:countries
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
