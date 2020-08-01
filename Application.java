package mine;

import mine.Controller.Bridge;
import mine.views.SplashView;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Application {
    public static JFrame frame=new JFrame("CIA portal");
    public static BorderLayout borderLayout=new BorderLayout(20,20);

    public static void main(String[] args) throws InterruptedException {


        frame.setLayout(borderLayout);
        frame.setSize(700,600);
        SplashView splashView=new SplashView();
        splashView.show();
        Bridge.runDataLoaderForSplash();
        frame.setVisible(true);

    }
}
