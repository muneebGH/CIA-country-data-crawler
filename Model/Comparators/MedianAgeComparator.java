package mine;

import java.util.Comparator;

public class MedianAgeComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        float r1=((CountryModel)o1).getMedianAge();
        float r2=((CountryModel)o2).getMedianAge();

        if(r1==r2){
            return 0;
        }
        if(r1>r2){
            return 1;
        }
        return -1;


    }
}
