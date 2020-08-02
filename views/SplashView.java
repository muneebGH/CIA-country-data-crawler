package mine.views;

import mine.Controller.ResourceHouse;

import javax.swing.*;
import java.awt.*;

public class SplashView {
    private static JWindow window ;
    private static JProgressBar progressBar;
    public SplashView() {

        window=new JWindow();
        progressBar=new JProgressBar(0,267);
        progressBar.setString("populating ...");
        progressBar.setStringPainted(true);
        window.getContentPane().add(progressBar,SwingConstants.CENTER);
        window.setBounds(500, 150, 400, 200);

    }

    public void show(){
        window.setVisible(true);
    }

    public static void hide(){
        window.setVisible(false);
        window.dispose();
    }

    public static void setContentOfSplash(String text,int completedCountries){
        progressBar.setString(text);
        progressBar.setValue(completedCountries);
    }

}
