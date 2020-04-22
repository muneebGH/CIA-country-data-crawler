package mine.Model;

import java.util.Comparator;

public class ElevationComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        CountryModel c1=(CountryModel)o1;
        CountryModel c2=(CountryModel)o2;

        int e1;
        int e2;

        if(c1.getLowestElevation()==-1){
            e1=1000000;
        }else{
            e1=c1.getLowestElevation();
        }


        if(c2.getLowestElevation()==-1){
            e2=1000000;
        }
        else{
            e2=c2.getLowestElevation();
        }

        if(e1==e2){
            return 0;
        }
        if(e1>e2){
            return 1;
        }
        return -1;
    }
}
