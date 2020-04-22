package mine.Model;

import java.util.Comparator;

public class DeathRateComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        int r1=((CountryModel)o1).getDeathRateRank();
        int r2=((CountryModel)o1).getDeathRateRank();
        if(r1==r2){
            return 0;
        }
        if(r1>r2){
            return 1;
        }
        return -1;
    }
}
