package mine.Model;

import java.util.Comparator;

public class ElectricityPerCapitaComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Double ec1=((CountryModel)o1).getElectricityConsumpCapita();
        Double ec2=((CountryModel)o2).getElectricityConsumpCapita();

        if(ec1==ec2){
            return 0;
        }
        if(ec1>ec2){
            return 1;
        }
        return -1;
    }
}
