package mine;

import java.util.Comparator;

public class DefaultComparator  implements Comparator<CountryModel> {


    @Override
    public int compare(CountryModel o1, CountryModel o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
