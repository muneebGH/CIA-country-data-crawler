package mine.Model.Comparators;

import mine.Model.CountryModel;

import java.util.Comparator;

public class MedianAgeComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        int r1=((CountryModel)o1).getMedianAgeRank();
        int r2=((CountryModel)o2).getMedianAgeRank();

        if(r1==r2){
            return 0;
        }
        if(r1>r2){
            return 1;
        }
        return -1;


    }
}
