package mine;

import java.util.ArrayList;
import java.util.Collections;

public class CountryModelBrain {
    ArrayList<CountryModel> countries;


    public CountryModelBrain(ArrayList<CountryModel> countries) {

        this.countries = countries;
        int i=1;
        for (CountryModel c:countries
             ) {
            Bridge.passDataToSplash(""+countries.get(i-1).getName(),i);
            System.out.println("populating -> "+countries.get(i-1).getName()+" Country No : "+i+"/267 ...");
            CountryPopulator.populate(c);
            i++;
        }
        Bridge.finishedLoading();
//        populateLatLongDifferences();
//
//        for (ArrayList<CountryModel> x:arr
//             ) {
//            System.out.println();
//            for (CountryModel c:x
//                 ) {
//                System.out.print("->"+c.getName());
//            }
//        }

    }

//    public void populateLatLongDifferences(){
//        int i=0;
//        for (CountryModel c:countries
//             ) {
//
//            if(c.getLat()==-1 || c.getLon()==-1){
//                continue;
//            }
//            ArrayList<CountryModel> inner=new ArrayList<>();
//            inner.add(0,c);
//            arr.add(i,inner);
//            int y=1;
//            for (CountryModel x:countries
//                 ) {
//                if(c.getName().toLowerCase().trim().equals(x.getName().toLowerCase().trim())){
//                    continue;
//                }
//                if(x.getLat()==-1 || x.getLon()==-1){
//                    continue;
//                }
//                double latDiff=Math.abs(c.getLat()-x.getLat());
//                double lonDiff=Math.abs(c.getLon()-x.getLon());
//                if(latDiff<=10 && lonDiff<=10){
//
//                    inner.add(y,x);
//                }
//
//            }
//
//
//        }
//    }

    public void sortByBirthExpectancies(){

        Collections.sort(countries,new BirthExpectancyComparator());

    }


    public void topMedianAges(){

        Collections.sort(countries,new MedianAgeComparator());

    }

    public ArrayList<CountryModel> getList(){
        return countries;
    }


    public void topDeathRateCountries(){

        Collections.sort(countries,new DeathRateComparator());


    }

    public void sortByDefault(){
        Collections.sort(countries,new DefaultComparator());
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

    public void topConsumers(){
        Collections.sort(countries,new ElectricityPerCapitaComparator());
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

    public void sortByPopulation(){
        Collections.sort(countries,new PopulationComparator());
    }


    public void sortByForestCoverage(){
        Collections.sort(countries,new ForestCoverageComparator());
    }

    public void sortByAgricultureCoverage(){
        Collections.sort(countries,new AgricultureCoverageComparator());
    }




    public void landLockedOnes(){
        System.out.println("LandLocked Countries :");
        for (CountryModel c:
             countries) {
            int i=0;
            ArrayList<String> srr=c.getSorroundings();
            for (String s:srr
                 ) {

                if(findLandLocked(s)){

                    i++;
                }

            }
            if(i==srr.size() && i>=2){
                System.out.println(c.getName());
            }
        }
    }

    private boolean findLandLocked(String name){


        for (CountryModel c:countries
             ) {
            if(c.getName().toLowerCase().trim().equals(name)){
                if(c.isLandlocked()){
                    return true;
                }

            }
        }

        return false;
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
        }else if(by.equals("agriculture")){
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


    @Override
    public String toString() {
        return "CountryModelBrain{" +
                "countries=" + countries +
                '}';
    }
}
