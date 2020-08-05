package mine;

import java.util.Comparator;

public class AgricultureCoverageComparator implements Comparator<CountryModel> {
    @Override
    public int compare(CountryModel o1, CountryModel o2) {
        if(o1.getAgricultureCoverage()==o2.getAgricultureCoverage()){
            return 0;
        }

        if(o1.getAgricultureCoverage()>o2.getAgricultureCoverage()){
            return 1;
        }
        return-1;
    }
}
