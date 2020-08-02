package mine;

import mine.Controller.Bridge;
import mine.Controller.Utils;
import mine.views.CenterView;
import mine.views.SplashView;
import mine.views.TopView;

import javax.swing.*;
import java.awt.*;

public class Application {
    public static JFrame frame=new JFrame("CIA portal");
    public static BorderLayout borderLayout=new BorderLayout(20,20);
    private static boolean internetProblem=false;

    public static void main(String[] args) throws InterruptedException {



        frame.setLayout(borderLayout);
        frame.setSize(700,600);
        try {
            try {
                Application.setAppData();
            }catch (Exception e){
                internetProblem=true;
                showInternetProblem();
            }
            if(!internetProblem){

                frame.add(new CenterView().getView(),borderLayout.CENTER);
                frame.add(new TopView().getView(),borderLayout.NORTH);
            }
        }catch (Exception e){
            showAppLoadingProblem();
        }


        frame.setVisible(true);

    }

    public static void showInternetProblem(){
        internetProblem=true;
        frame.setSize(200,100);
        frame.add(new JLabel("Internet problem try again"));
        frame.setVisible(true);
    }

    public static void showAppLoadingProblem(){

        frame.setSize(200,100);
        frame.add(new JLabel("Internet problem try again"));
        frame.setVisible(true);
    }
    public static void setAppData(){
        SplashView splashView=new SplashView();
        splashView.show();
        Bridge.runDataLoaderFromInternet();
        SplashView.hide();

    }
}
