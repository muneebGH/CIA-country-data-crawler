package mine;

import mine.Controller.Home;
import mine.Model.CountryModelBrain;

import java.awt.*;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Home controller = new Home("https://www.cia.gov/library/publications/the-world-factbook/print/textversion.html");
        controller.prepareEverything();
        boolean repeat = true;
        while (repeat) {
            System.out.println("press 1 to get countries of _ subcontinent prone to _ disease");
            System.out.println("press 2 to list countries that have _ symbol in flag ");
            System.out.println("press 3 to find country with lowest elevation point in _ continent");
            System.out.println("press 4 to List countries in _ have at least _ % of their land covered in _");
            System.out.println("press 5 to Find the top 5 countries with the highest electricity consumption per capita.");
            System.out.println("press 6 to find countries with dominant ethnicity over _%");
            System.out.println("press 7 to find landlocked countries");
            System.out.println("press 8 to find top 5 countries with highest death rate");
            System.out.println("press something else to exit");


            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    controller.proneToHazards();
                    break;
                case 2:
                    controller.symbolInFlag();
                    break;
                case 3:
                    controller.lowestElevationPoint();
                    break;
                case 4:
                    controller.findCoverage();
                    break;
                case 5:
                    controller.findTop5();
                    break;
                case 6:
                    controller.findEthnicity();
                    break;
                case 7:
                    controller.findLandLocked();
                    break;
                case 8:
                    controller.top5DeathRates();
                    break;
                default:
                    repeat = false;


            }


        }
    }
}
