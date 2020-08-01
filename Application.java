package mine;

import mine.Controller.Bridge;
import mine.Controller.Utils;
import mine.views.SplashView;

import javax.swing.*;
import java.awt.*;

public class Application {
    public static JFrame frame=new JFrame("CIA portal");
    public static BorderLayout borderLayout=new BorderLayout(20,20);

    public static void main(String[] args) {


        frame.setLayout(borderLayout);
        frame.setSize(700,600);
        Application.setAppData();
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
