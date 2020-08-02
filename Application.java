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

    public static void main(String[] args) {


        frame.setLayout(borderLayout);
        frame.setSize(700,600);
       // Application.setAppData();
        frame.add(new CenterView().getView(),borderLayout.CENTER);
        frame.add(new TopView().getView(),borderLayout.NORTH);
        frame.setVisible(true);

    }

    public static void setAppData(){
        SplashView splashView=new SplashView();
        splashView.show();
        if(Utils.netIsAvailable()){
            Bridge.runDataLoaderFromInternet();
        }else{
            SplashView.hide();
        }
    }
}
