package mine;

public class Bridge {
    public static void passDataToSplash(String text,int completedCountries){
        SplashView.setContentOfSplash(text,completedCountries);
    }

    public static void finishedLoading(){
        SplashView.hide();
    }

    public static void runDataLoaderFromInternet(){
        ResourceHouse.controller.prepareEverything();
    }

}
