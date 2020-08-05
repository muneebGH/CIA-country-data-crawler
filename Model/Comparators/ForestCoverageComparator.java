package mine;

import java.util.Comparator;

public class ForestCoverageComparator implements Comparator<CountryModel> {
    @Override
    public int compare(CountryModel o1, CountryModel o2) {
        if(o1.getForestCoverage()==o2.getForestCoverage()){
            return 0;
        }

        if(o1.getForestCoverage()>o2.getForestCoverage()){
            return 1;
        }
        return -1;
    }
}
