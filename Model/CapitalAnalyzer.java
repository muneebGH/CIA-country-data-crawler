//package mine.Model;
//
//import orig.Country;
//
//import java.util.ArrayList;
//
//public class CapitalAnalyzer extends CountryModelBrain{
//
//
//    ArrayList<Integer> lengths;
//    int length=0;
//    public CapitalAnalyzer(ArrayList<CountryModel> countries) {
//        super(countries);
//        lengths=new ArrayList<>(countries.size());
//    }
//
//    public void analyzeCapitals(){
//        for (ArrayList<CountryModel> a:arr
//             ) {
//            analyzeRecursively(a);
//            lengths.add(length);
//            length=0;
//        }
//
//    }
//
//    private void analyzeRecursively(ArrayList<CountryModel> arr){
//        for (CountryModel c:arr
//             ) {
//            ArrayList<CountryModel> inner=findListFromArr(c.getName());
//            length=length+inner.size();
//            analyzeRecursively(inner);
//        }
//    }
//
//    private ArrayList<CountryModel> findListFromArr(String countryName){
//        ArrayList<CountryModel> toReturn=new ArrayList<>();
//        for (ArrayList<CountryModel> x:arr
//             ) {
//            if(x.get(0).getName().toLowerCase().trim().equals(countryName.toLowerCase().trim())){
//                toReturn=x;
//                return  toReturn;
//            }
//        }
//
//        return toReturn;
//    }
//}