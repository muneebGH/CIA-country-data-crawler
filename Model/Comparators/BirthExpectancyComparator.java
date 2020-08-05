package mine;

import java.util.Comparator;

public class BirthExpectancyComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        float br1=((CountryModel)o1).getLifeExpectancyAtBirth();
        float br2=((CountryModel)o2).getLifeExpectancyAtBirth();

        if(br1==br2){
            return 0;
        }
        if(br1>br2){
            return 1;
        }
        return -1;

    }
}
