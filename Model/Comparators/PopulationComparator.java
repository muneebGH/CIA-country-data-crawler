package mine.Model.Comparators;

import mine.Model.CountryModel;

import java.util.Comparator;

public class PopulationComparator implements Comparator<CountryModel> {
    @Override
    public int compare(CountryModel o1, CountryModel o2) {
        if(o1.getPopulation()==o2.getPopulation()){
            return 0;
        }
        if(o1.getPopulation()>o2.getPopulation()){
            return 1;
        }
        return -1;
    }
}
